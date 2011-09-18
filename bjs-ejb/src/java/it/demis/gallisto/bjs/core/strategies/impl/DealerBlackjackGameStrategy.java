/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.strategies.impl;

import it.demis.gallisto.bjs.core.model.Hand;
import it.demis.gallisto.bjs.core.model.actors.Memory;
import it.demis.gallisto.bjs.core.strategies.AbstractGameStrategy;
import it.demis.gallisto.bjs.core.strategies.Advice;
import it.demis.gallisto.bjs.core.strategies.StrategyException;
import java.util.logging.Level;

/**
 *
 * @author Demis Gallisto
 */
@DealerQualifier
public class DealerBlackjackGameStrategy extends AbstractGameStrategy {

  public DealerBlackjackGameStrategy() {
    super();
  }

  @Override
  public Advice getAdvice(final Hand _playerHand, final Hand _dealerHand, final Memory _playerMemory) throws StrategyException {
    Advice res = null;
    if (_dealerHand.getValueOfUpCards().getValue() >= 17) {
      res = Advice.STAY;
    } else {
      res = Advice.HIT;
    }
    if (this._log.isLoggable(Level.INFO)) {
      this._log.log(Level.INFO, "advice is {0} for dealer hand {1}", new Object[]{res, _dealerHand});
    }
    return res;
  }

  @Override
  public String toString() {
    return "DealerGameStrategy{" + '}';
  }
}
