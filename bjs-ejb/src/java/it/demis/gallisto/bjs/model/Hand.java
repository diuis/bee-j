/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model;

import it.demis.gallisto.bjs.model.cards.PlayingCard;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Demis Gallisto
 */
public class Hand {

  public class HandValue {

    private int value = 0;
    private boolean soft = false;

    public HandValue() {
      super();
    }

    public boolean isSoft() {
      return soft;
    }

    private void setSoft(final boolean _soft) {
      this.soft = _soft;
    }

    public int getValue() {
      return value;
    }

    private void setValue(final int _value) {
      this.value = _value;
    }
  }
  private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
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
    try {
      this.lock.writeLock().lock();
      this.getCards().add(_card);
    } finally {
      this.lock.writeLock().unlock();
    }
  }

  public int totalCards() {
    int res = 0;
    try {
      this.lock.readLock().lock();
      res = this.getCards().size();
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  public HandValue getValue() {
    HandValue res = new HandValue();
    boolean acePresent = false;
    try {
      int val = 0;
      this.lock.readLock().lock();
      for (final PlayingCard card : this.getCards()) {
        if (card != null) {
          try {
            final int cardValue = Integer.parseInt(card.getValue());
            if (cardValue == 1) {
              acePresent = true;
            } else {
              val += cardValue;
            }
          } catch (final NullPointerException | NumberFormatException _e) {
            if (card.getValue() != null) {
              switch (card.getValue()) {
                case "J":
                  val += 10;
                  break;
                case "Q":
                  val += 10;
                  break;
                case "K":
                  val += 10;
                  break;
                default:
                  throw new IllegalStateException("card value not supported: " + card.getValue());
              }
            } else {
              throw new IllegalStateException("not expected null card value", _e);
            }
          }
        }
      }
      boolean soft = false;
      if (acePresent) {
        if (val + 10 <= 21) {
          soft = true;
        }
      }
      res.setValue(val);
      res.setSoft(soft);
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  public String toString() {
    return "Hand{" + "cards=" + cards + '}';
  }
}
