/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.model;

import it.demis.gallisto.bjs.core.model.cards.PlayingCard;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Demis Gallisto
 */
public interface Hand extends Serializable {

  boolean isAcePresentOnUpCards();

  boolean isAcePresentOnAllCards();

  HandValue getValueOfAllCards();

  HandValue getValueOfUpCards();

  int totalUpCards();

  int totalAllCards();

  void addCard(final PlayingCard _card);

  PlayingCard getFirstUpCard();

  List<PlayingCard> getUpCards();

  List<PlayingCard> getAllCards();

  void makeAllCardsWithFaceUp();
}
