/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.impl;

import it.demis.gallisto.bjs.strategies.AbstractGameStrategy;
import it.demis.gallisto.bjs.model.Hand;
import it.demis.gallisto.bjs.model.actors.Memory;
import it.demis.gallisto.bjs.strategies.Advice;
import it.demis.gallisto.bjs.strategies.StrategyException;
import java.util.logging.Level;

/**
 *
 * @author Demis Gallisto
 */
@DealerQualifier
public class DealerGameStrategy extends AbstractGameStrategy {

  public DealerGameStrategy() {
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
