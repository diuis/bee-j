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
import it.demis.gallisto.bjs.strategies.io.DataStrategy;
import it.demis.gallisto.bjs.strategies.io.DataStrategyIOException;
import it.demis.gallisto.bjs.strategies.io.DataStrategyLoad;
import java.util.logging.Level;

/**
 *
 * @author Demis Gallisto
 */
@PlayerQualifier
public class BlackjackBasicStrategy extends AbstractGameStrategy {

  private DataStrategy dataStrategy;

  public BlackjackBasicStrategy() {
    super();
  }

  public String toString() {
    return "BlackjackBasicStrategy{" + '}';
  }

  @Override
  public Advice getAdvice(final Hand _playerHand, final Hand _dealerHand, final Memory _playerMemory) throws StrategyException {
    Advice res = null;
    if (dataStrategy == null) {
      try {
        this.dataStrategy = DataStrategyLoad.getInstance().load();
      } catch (final DataStrategyIOException _e) {
        throw new StrategyException("error loading data strategy", _e);
      }
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
