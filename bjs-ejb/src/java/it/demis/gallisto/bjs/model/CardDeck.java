/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model;

import it.demis.gallisto.bjs.model.cards.PlayingCard;
import it.demis.gallisto.bjs.model.cards.FrenchCard;
import it.demis.gallisto.bjs.model.cards.FrenchSuit;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

/**
 *
 * @author Demis Gallisto
 */
@ManagedBean
public class CardDeck {

  private List<PlayingCard> availabCards = new ArrayList<>(52);
  private List<PlayingCard> removedCards = new ArrayList<>(52);
  private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

  public CardDeck() {
    super();
  }
  
  @PostConstruct
  protected void init() {
    try {
      this.lock.writeLock().lock();
      for (final FrenchSuit suit : FrenchSuit.values()) {
        for (int i = 1; i <= 10; i++) {
          this.availabCards.add(new FrenchCard(String.valueOf(i), suit.name()));
        }
        final String[] jqk = {"J", "Q", "K"};
        for (final String v : jqk) {
          this.availabCards.add(new FrenchCard(v, suit.name()));
        }
      }
      this.shuffle();
    } finally {
      this.lock.writeLock().unlock();
    }
  }

  protected void shuffle() {
    try {
      this.lock.writeLock().lock();
      Collections.shuffle(this.availabCards, new SecureRandom());
    } finally {
      this.lock.writeLock().unlock();
    }
  }

  public PlayingCard getCard() {
    PlayingCard res = null;
    this.lock.writeLock();
    if (!this.availabCards.isEmpty()) {
      final PlayingCard card = this.availabCards.remove(0);
      this.removedCards.add(card);
      res = card;
    }
    return res;
  }
}
