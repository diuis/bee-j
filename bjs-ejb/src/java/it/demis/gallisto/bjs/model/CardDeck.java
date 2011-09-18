/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model;

import it.demis.gallisto.bjs.events.CardRemovedEvent;
import it.demis.gallisto.bjs.model.cards.FrenchCard;
import it.demis.gallisto.bjs.model.cards.FrenchSuit;
import it.demis.gallisto.bjs.model.cards.PlayingCard;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author Demis Gallisto
 */
@ManagedBean
public class CardDeck {

  private List<PlayingCard> availabCards = new ArrayList<>(52);
  private List<PlayingCard> removedCards = new ArrayList<>(52);
  private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  @Inject
  private Event<CardRemovedEvent> events;

  public CardDeck() {
    super();
  }

  /**
   * This method is thread-safe
   */
  @PostConstruct
  protected void init() {
    try {
      this.lock.writeLock().lock();
      if (!this.availabCards.isEmpty()) {
        this.availabCards.clear();
      }
      if (!this.removedCards.isEmpty()) {
        this.removedCards.clear();
      }
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

  /**
   * This method is thread-safe
   */
  protected void shuffle() {
    try {
      this.lock.writeLock().lock();
      Collections.shuffle(this.availabCards, new SecureRandom());
    } finally {
      this.lock.writeLock().unlock();
    }
  }

  /**
   * This method is thread-safe
   */
  public PlayingCard getCard() {
    PlayingCard res = null;
    try {
      this.lock.writeLock().lock();
      if (this.availabCards.isEmpty()) {
        this.init();
      }
      final PlayingCard card = this.availabCards.remove(0);
      this.removedCards.add(card);
      res = card;
      if (this.events != null) {
        this.events.fire(new CardRemovedEvent(res));
      }
    } finally {
      this.lock.writeLock().unlock();
    }
    return res;
  }

  /**
   * This method is thread-safe
   */
  public int totalAvailableCards() {
    int res = 0;
    try {
      this.lock.readLock().lock();
      res = this.availabCards.size();
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  /**
   * This method is thread-safe
   */
  public int totalRemovedCards() {
    int res = 0;
    try {
      this.lock.readLock().lock();
      res = this.removedCards.size();
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }
}
