/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.model;

import it.demis.gallisto.bjs.core.model.cards.PlayingCard;
import java.io.Serializable;

/**
 *
 * @author Demis Gallisto
 */
public interface CardDeck extends Serializable {

  void init();

  PlayingCard getCard();

  int totalAvailableCards();

  int totalRemovedCards();
}
