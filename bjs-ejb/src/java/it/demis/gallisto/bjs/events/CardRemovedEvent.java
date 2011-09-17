/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.events;

import it.demis.gallisto.bjs.model.cards.PlayingCard;

/**
 * @author Demis Gallisto
 */
public class CardRemovedEvent {

  private PlayingCard removedCard;

  public CardRemovedEvent(final PlayingCard _removedCard) {
    this.setRemovedCard(_removedCard);
  }

  public PlayingCard getRemovedCard() {
    return removedCard;
  }

  public String toString() {
    return "CardRemovedEvent{" + "removedCard=" + removedCard + '}';
  }

  public void setRemovedCard(final PlayingCard _removedCard) {
    this.removedCard = _removedCard;
  }
}
