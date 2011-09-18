/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model;

import it.demis.gallisto.bjs.model.actors.BlackjackDealer;
import it.demis.gallisto.bjs.model.actors.BlackjackPlayer;
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
public class BlackjackTable {

  private final Logger _log = Logger.getLogger(this.getClass().getName());

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

  public BlackjackDealer getDealer() {
    return dealer;
  }

  public void setDealer(final BlackjackDealer _dealer) {
    this.dealer = _dealer;
  }

  public BlackjackPlayer getPlayer() {
    return player;
  }

  public void setPlayer(final BlackjackPlayer _player) {
    this.player = _player;
  }
}
