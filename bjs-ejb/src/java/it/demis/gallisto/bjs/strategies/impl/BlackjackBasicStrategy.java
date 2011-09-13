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

    final PlayingCard dealerCard = _dealerHand.getFirstCardUp();
    if (dealerCard instanceof FrenchCard) {

      final int dealerHandCalculatedValue = new BlackJackCardDecorator((FrenchCard) dealerCard).getCalculatedValue();

      final Integer dealerMappingIndex = this.dataStrategy.getDealerMapping().get(dealerHandCalculatedValue);
      if (dealerMappingIndex != null) {
        final List<PlayingCard> playerCards = _playerHand.getCardsUp();
        if (playerCards != null && playerCards.size() > 0) {
          int playerHandValue = 0;
          for (final PlayingCard playerCard : playerCards) {
            final int playerHandCalculatedValue = new BlackJackCardDecorator((FrenchCard) playerCard).getCalculatedValue();
            playerHandValue += playerHandCalculatedValue;
          }
          this.dataStrategy.
        } else {
          // no cards in player's hand
          res = Advice.HIT;
        }
      }

    } else {
      throw new StrategyException(String.format("strategy %s is available only with FrenchCard type", this.getClass().getName()));
    }



    if (_dealerHand.totalCards() >= 17) {
      res = Advice.STAY;
    } else {
      res = Advice.HIT;
    }
    if (this._log.isLoggable(Level.INFO)) {
      this._log.log(Level.INFO, "advice is {0} for player hand {1}", new Object[]{res, _playerHand});
    }
    return res;
  }
}
