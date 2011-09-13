/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model;

import it.demis.gallisto.bjs.model.cards.Facing;
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
    List<PlayingCard> res = null;
    try {
      this.lock.readLock().lock();
      res = this.cards;
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  public List<PlayingCard> getCardsUp() {
    List<PlayingCard> res = null;
    try {
      this.lock.readLock().lock();
      if (this.getCards() != null) {
        res = new ArrayList<>();
        for (final PlayingCard card : this.getCards()) {
          if (card != null) {
            if (card.getFacing() != null && card.getFacing().equals(Facing.UP)) {
              res.add(card);
            }
          }
        }
      }
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  public PlayingCard getFirstCardUp() {
    PlayingCard res = null;
    try {
      this.lock.readLock().lock();
      final List<PlayingCard> cardsUp = this.getCardsUp();
      if (cardsUp != null && cardsUp.size() > 0) {
        res = cardsUp.get(0);
      }
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  protected void setCards(final List<PlayingCard> _cards) {
    try {
      this.lock.writeLock().lock();
      this.cards = _cards;
    } finally {
      this.lock.writeLock().unlock();
    }
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

  private int translateValue(final PlayingCard _card) {
    int res = 0;
    try {
      res = Integer.parseInt(_card.getValue());
    } catch (final NullPointerException | NumberFormatException _e) {
      if (_card.getValue() != null) {
        switch (_card.getValue()) {
          case "J":
            res = 10;
            break;
          case "Q":
            res = 10;
            break;
          case "K":
            res = 10;
            break;
          default:
            throw new IllegalStateException("card value not supported: " + _card.getValue());
        }
      } else {
        throw new IllegalStateException("not expected null card value", _e);
      }
    }
    return res;
  }

  public HandValue getValueOfUpCards() {
    HandValue res = new HandValue();
    boolean acePresent = false;
    try {
      int val = 0;
      this.lock.readLock().lock();
      for (final PlayingCard card : this.getCardsUp()) {
        if (card != null) {
          int cardValue = this.translateValue(card);
          val += cardValue;
          if (cardValue == 1) {
            acePresent = true;
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

  public HandValue getValueOfAllCards() {
    HandValue res = new HandValue();
    boolean acePresent = false;
    try {
      int val = 0;
      this.lock.readLock().lock();
      for (final PlayingCard card : this.getCards()) {
        if (card != null) {
          int cardValue = this.translateValue(card);
          val += cardValue;
          if (cardValue == 1) {
            acePresent = true;
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

  public boolean isAcePresentOnAllCards() {
    boolean res = false;
    final List<PlayingCard> cardsList = this.getCards();
    if (cardsList != null && cardsList.size() > 0) {
      for (final PlayingCard card : cardsList) {
        if (card != null && card.getValue().equals("1")) {
          res = true;
          break;
        }
      }
    }
    return res;
  }

  public boolean isAcePresentOnCardsUp() {
    boolean res = false;
    final List<PlayingCard> cardsList = this.getCardsUp();
    if (cardsList != null && cardsList.size() > 0) {
      for (final PlayingCard card : cardsList) {
        if (card != null && card.getValue().equals("1")) {
          res = true;
          break;
        }
      }
    }
    return res;
  }

  public String toString() {
    return "Hand{" + "cards=" + cards + '}';
  }
}
