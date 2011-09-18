/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.impl;

import it.demis.gallisto.bjs.strategies.AbstractGameStrategy;
import it.demis.gallisto.bjs.model.BlackjackHand;
import it.demis.gallisto.bjs.model.actors.Memory;
import it.demis.gallisto.bjs.model.cards.BlackJackCardDecorator;
import it.demis.gallisto.bjs.model.cards.FrenchCard;
import it.demis.gallisto.bjs.model.cards.PlayingCard;
import it.demis.gallisto.bjs.strategies.Advice;
import it.demis.gallisto.bjs.strategies.StrategyException;
import it.demis.gallisto.bjs.strategies.io.DataStrategy;
import it.demis.gallisto.bjs.strategies.io.DataStrategyIOException;
import it.demis.gallisto.bjs.strategies.io.DataStrategyLoad;
import java.util.logging.Level;

/**
 *
 * @author Demis Gallisto
 */
@PlayerQualifier
public class PlayerBlackjackBasicStrategy extends AbstractGameStrategy {

  private volatile DataStrategy dataStrategy;

  public PlayerBlackjackBasicStrategy() {
    super();
  }

  @Override
  public String toString() {
    return "BlackjackBasicStrategy{" + '}';
  }

  @Override
  public Advice getAdvice(final BlackjackHand _playerHand, final BlackjackHand _dealerHand, final Memory _playerMemory) throws StrategyException {
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

      final Integer idxArrayD = this.dataStrategy.getDealerMapping().get(dealerHandCalculatedValue);

      final int totUpCards = _playerHand.totalUpCards();
      if (totUpCards > 0) {
        final BlackjackHand.HandValue handValue = _playerHand.getValueOfUpCards();

        if (handValue.isPair()) {
          final Integer idxLookup = handValue.getValue() / 2;
          final Integer idxArrayP = this.dataStrategy.getPlayerPairMapping().get(idxLookup);
          if (idxArrayP != null) {
            final String[][] arr = this.dataStrategy.getPair();
            final String adviceStr = arr[idxArrayP][idxArrayD];
            res = this.resolveAdvice(adviceStr);
          } else {
            if (_log.isLoggable(Level.WARNING)) {
              _log.log(Level.WARNING, "advice not available in strategy table [player hand={0}]", handValue);
            }
            res = Advice.NOT_AVAILABLE;
          }
        } else {
          if (handValue.isSoft() && totUpCards == 2) {
            final int v1 = new BlackJackCardDecorator((FrenchCard) _playerHand.getUpCards().get(0)).getCalculatedValue();
            final int v2 = new BlackJackCardDecorator((FrenchCard) _playerHand.getUpCards().get(1)).getCalculatedValue();
            final Integer idxLookup = Math.max(v1, v2);
            final Integer idxArrayP = this.dataStrategy.getPlayerSoftMapping().get(idxLookup);
            if (idxArrayP != null) {
              final String[][] arr = this.dataStrategy.getSoft();
              final String adviceStr = arr[idxArrayP][idxArrayD];
              res = this.resolveAdvice(adviceStr);
            } else {
              if (_log.isLoggable(Level.WARNING)) {
                _log.log(Level.WARNING, "advice not available in strategy table [player hand={0}]", handValue);
              }
              res = Advice.NOT_AVAILABLE;
            }
          }
        }
        if (res == null) {
          // default or hard
          final Integer idxLookup = handValue.getValue();
          final Integer idxArrayP = this.dataStrategy.getPlayerHardMapping().get(idxLookup);
          if (idxArrayP != null) {
            final String[][] arr = this.dataStrategy.getHard();
            final String adviceStr = arr[idxArrayP][idxArrayD];
            res = this.resolveAdvice(adviceStr);
          } else {
            if (_log.isLoggable(Level.WARNING)) {
              _log.log(Level.WARNING, "advice not available in strategy table [player hand={0}]", handValue);
            }
            res = Advice.NOT_AVAILABLE;
          }
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

  private Advice resolveAdvice(final String _code) {
    Advice res = null;
    switch (_code) {
      case "hi":
        res = Advice.HIT;
        break;
      case "st":
        res = Advice.STAY;
        break;
      case "su":
        res = Advice.SURRENDER;
        break;
      case "dh":
        res = Advice.DOUBLE_HIT;
        break;
      case "ds":
        res = Advice.DOUBLE_STAY;
        break;
      case "sp":
        res = Advice.SPLIT;
        break;
    }
    return res;
  }
}
