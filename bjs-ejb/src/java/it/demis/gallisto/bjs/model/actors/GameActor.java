/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model.actors;

import it.demis.gallisto.bjs.model.Hand;
import it.demis.gallisto.bjs.strategies.GameStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Demis Gallisto
 */
public abstract class GameActor {

  protected final Logger _log = Logger.getLogger(this.getClass().getName());
  private GameStrategy strategy;
  private String name;
  private Hand hand;

  public GameActor() {
    super();
  }

  public String getName() {
    return name;
  }

  public void setName(final String _name) {
    this.name = _name;
  }

  public GameStrategy getStrategy() {
    return this.strategy;
  }

  public void setStrategy(final GameStrategy _strategy) {
    this.strategy = _strategy;
    if (_log.isLoggable(Level.FINE)) {
      _log.log(Level.FINE, "strategy injected {0}", _strategy);
    }
  }

  public Hand getHand() {
    return this.hand;
  }

  protected void setHand(final Hand _hand) {
    this.hand = _hand;
  }

  @Override
  public String toString() {
    return "GameActor{" + "strategy=" + strategy + ", name=" + name + '}';
  }
}
