/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model;

import it.demis.gallisto.bjs.model.actors.Dealer;
import it.demis.gallisto.bjs.model.actors.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
  private Set<Player> players = new HashSet<>();
  @Inject
  private Dealer dealer;

  public BlackjackTable() {
    super();
  }

  @PostConstruct
  public void init() {
    this._log.log(Level.INFO, "blackjack table created: the dealer names is {0} and the number of players is {1}", new Object[]{this.dealer.getName(), this.players.size()});
  }

  public Dealer getDealer() {
    return dealer;
  }

  public void setDealer(final Dealer _dealer) {
    this.dealer = _dealer;
  }

  @Override
  public List<Player> getGamePlayers() {
    return Collections.unmodifiableList(new ArrayList<>(this.getPlayers()));
  }

  protected Set<Player> getPlayers() {
    return players;
  }

  protected void setPlayers(final Set<Player> _players) {
    this.players = _players;
  }

  @Override
  public void addPlayer(final String _name) {
    final String name = _name == null || _name.isEmpty() ? "anonymous player" : _name;
    this.getPlayers().add(new Player(name));
  }
}
