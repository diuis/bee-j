/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model;

import it.demis.gallisto.bjs.model.actors.Dealer;
import it.demis.gallisto.bjs.model.actors.Player;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Demis Gallisto
 */
public interface GameTable {

  List<Player> getGamePlayers();

  Dealer getDealer();

  void addPlayer(String _name);
}
