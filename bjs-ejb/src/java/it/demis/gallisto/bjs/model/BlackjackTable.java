/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model;

import it.demis.gallisto.bjs.model.actors.Dealer;
import it.demis.gallisto.bjs.model.actors.Player;
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
public class BlackjackTable implements GameTable {

  private final Logger _log = Logger.getLogger(this.getClass().getName());

  @Inject
  private Player player;
  @Inject
  private Dealer dealer;

  public BlackjackTable() {
    super();
  }

  @PostConstruct
  public void init() {
    this._log.log(Level.INFO, "blackjack table created: the dealer names is {0} and the player name is {1}", new Object[]{this.getDealer().getName(), this.getPlayer().getName()});
  }

  @Override
  public Dealer getDealer() {
    return dealer;
  }

  public void setDealer(final Dealer _dealer) {
    this.dealer = _dealer;
  }

  @Override
  public Player getPlayer() {
    return player;
  }

  public void setPlayer(final Player _player) {
    this.player = _player;
  }
}
