/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model;

import it.demis.gallisto.bjs.model.cards.PlayingCard;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Demis Gallisto
 */
public class Hand {

  private List<PlayingCard> cards = new ArrayList<>();

  public List<PlayingCard> getCards() {
    return this.cards;
  }

  protected void setCards(final List<PlayingCard> _cards) {
    this.cards = _cards;
  }

  public void addCard(final PlayingCard _card) {
    if (_card == null) {
      throw new IllegalArgumentException("not valid parameter card: is null");
    }
    this.getCards().add(_card);
  }

  public int totalCards() {
    return this.getCards().size();
  }

  public int getValue() {
    int res = 0;
    for (final PlayingCard card : this.getCards()) {
      if (card != null) {
        //res += card.getValue();
      }
    }
    return res;
  }
  
  public String toString() {
    return "Hand{" + "cards=" + cards + '}';
  }
}
