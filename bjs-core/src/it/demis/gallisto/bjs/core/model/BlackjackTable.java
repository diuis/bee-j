/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.model;

import it.demis.gallisto.bjs.core.model.actors.BlackjackDealer;
import it.demis.gallisto.bjs.core.model.actors.BlackjackPlayer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author Demis Gallisto
 */
@ManagedBean
public class BlackjackTable implements Table {

  private transient final Logger _log = Logger.getLogger(this.getClass().getName());
  @Inject
  private BlackjackPlayer player;
  @Inject
  private BlackjackDealer dealer;

  public BlackjackTable() {
    super();
  }

  @PostConstruct
  public void init() {
    this._log.log(Level.INFO, "blackjack table created: the dealer names is {0} and the player name is {1}", new Object[]{this.getDealer().getName(), this.getPlayer().getName()});
  }

  @Override
  public BlackjackDealer getDealer() {
    return this.dealer;
  }

  protected void setDealer(final BlackjackDealer _dealer) {
    this.dealer = _dealer;
  }

  @Override
  public BlackjackPlayer getPlayer() {
    return this.player;
  }

  protected void setPlayer(final BlackjackPlayer _player) {
    this.player = _player;
  }
}
