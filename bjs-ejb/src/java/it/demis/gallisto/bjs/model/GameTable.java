/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model;

import it.demis.gallisto.bjs.model.actors.Dealer;
import it.demis.gallisto.bjs.model.actors.Player;

/**
 *
 * @author Demis Gallisto
 */
public interface GameTable {

  Dealer getDealer();

  Player getPlayer();
}
