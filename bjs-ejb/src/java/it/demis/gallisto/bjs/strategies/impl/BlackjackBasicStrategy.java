/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.impl;

import it.demis.gallisto.bjs.strategies.AbstractGameStrategy;
import it.demis.gallisto.bjs.model.Hand;
import it.demis.gallisto.bjs.model.actors.Memory;
import it.demis.gallisto.bjs.model.cards.BlackJackCardDecorator;
import it.demis.gallisto.bjs.model.cards.FrenchCard;
import it.demis.gallisto.bjs.model.cards.PlayingCard;
import it.demis.gallisto.bjs.strategies.Advice;
import it.demis.gallisto.bjs.strategies.StrategyException;
import it.demis.gallisto.bjs.strategies.io.DataStrategy;
import it.demis.gallisto.bjs.strategies.io.DataStrategyIOException;
import it.demis.gallisto.bjs.strategies.io.DataStrategyLoad;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author Demis Gallisto
 */
@PlayerQualifier
public class BlackjackBasicStrategy extends AbstractGameStrategy {

  private volatile DataStrategy dataStrategy;

  public BlackjackBasicStrategy() {
    super();
  }

  @Override
  public String toString() {
    return "BlackjackBasicStrategy{" + '}';
  }

  @Override
  public Advice getAdvice(final Hand _playerHand, final Hand _dealerHand, final Memory _playerMemory) throws StrategyException {
    Advice res = null;

    if (this.dataStrategy == null) {
      synchronized (this) {
        if (this.dataStrategy == null) {
          try {
            this.dataStrategy = DataStrategyLoad.getInstance().load();
          } catch (final DataStrategyIOException _e) {
            throw new StrategyException("error loading data strategy", _e);
          }
        }
      }
    }

    final PlayingCard dealerCard = _dealerHand.getFirstUpCard();
    if (dealerCard instanceof FrenchCard) {

      final int dealerHandCalculatedValue = new BlackJackCardDecorator((FrenchCard) dealerCard).getCalculatedValue();

      final Integer indexArrayD = this.dataStrategy.getDealerMapping().get(dealerHandCalculatedValue);

      final int totUpCards = _playerHand.totalUpCards();
      if (totUpCards > 0) {
        final Hand.HandValue handValue = _playerHand.getValueOfUpCards();

        if (handValue.isPair()) {
          final Integer idxLookup = handValue.getValue() / 2;
          final Integer idxArrayP = this.dataStrategy.getPlayerPairMapping().get(idxLookup);
          final String[][] arr = this.dataStrategy.getPair();
          final String adviceStr = arr[indexArrayD][idxArrayP];
          // resolve advice
        } else {
          if (handValue.isSoft() && totUpCards == 2) {
            final int v1 = new BlackJackCardDecorator((FrenchCard) _playerHand.getUpCards().get(0)).getCalculatedValue();
            final int v2 = new BlackJackCardDecorator((FrenchCard) _playerHand.getUpCards().get(1)).getCalculatedValue();
            final Integer idxLookup = Math.max(v1, v2);
            final Integer idxArrayP = this.dataStrategy.getPlayerSoftMapping().get(idxLookup);
            final String[][] arr = this.dataStrategy.getSoft();
            final String adviceStr = arr[indexArrayD][idxArrayP];
            // resolve advice

          }
        }
        if (res == null) {
          // default or hard
          final Integer idxLookup = handValue.getValue();
          final Integer idxArrayP = this.dataStrategy.getPlayerHardMapping().get(idxLookup);
          final String[][] arr = this.dataStrategy.getSoft();
            final String adviceStr = arr[indexArrayD][idxArrayP];
            // resolve advice
        }

      } else {
        // no cards
        res = Advice.HIT;
      }

    } else {
      throw new StrategyException(String.format("strategy %s is available only with FrenchCard type", this.getClass().getName()));
    }



    if (this._log.isLoggable(Level.INFO)) {
      this._log.log(Level.INFO, "advice is {0} for player hand {1}", new Object[]{res, _playerHand});
    }
    return res;
  }
}
