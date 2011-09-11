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

    private int value;
    private boolean soft;

    public HandValue(final int _value, final boolean _soft) {
      this.setValue(_value);
      this.setSoft(_soft);
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

  public int getValue() {
    int res = 0;
    boolean acePresent = false;
    try {
      this.lock.readLock().lock();
      for (final PlayingCard card : this.getCards()) {
        if (card != null) {
          try {
            final int cardValue = Integer.parseInt(card.getValue());
            if (cardValue == 1) {
              acePresent = true;
            } else {
              res += cardValue;
            }
          } catch (final NullPointerException | NumberFormatException _e) {
            if (card.getValue() != null) {
              switch (card.getValue()) {
                case "J":
                  res += 10;
                  break;
                case "Q":
                  res += 10;
                  break;
                case "K":
                  res += 10;
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
      if (acePresent) {
      }
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  public String toString() {
    return "Hand{" + "cards=" + cards + '}';
  }
}
