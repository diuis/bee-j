/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model;

import it.demis.gallisto.bjs.model.cards.PlayingCard;

/**
 *
 * @author Demis Gallisto
 */
public interface CardDeck {

  void init();

  PlayingCard getCard();

  int totalAvailableCards();

  int totalRemovedCards();
}
