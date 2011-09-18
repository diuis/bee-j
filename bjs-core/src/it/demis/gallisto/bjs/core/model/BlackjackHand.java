/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.model;

import it.demis.gallisto.bjs.core.model.cards.Facing;
import it.demis.gallisto.bjs.core.model.cards.PlayingCard;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Demis Gallisto
 */
public class BlackjackHand implements Hand {

  private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private List<PlayingCard> cards = new ArrayList<>();

  public BlackjackHand() {
    super();
  }

  /**
   * This method is thread-safe
   */
  @Override
  public List<PlayingCard> getAllCards() {
    List<PlayingCard> res = null;
    try {
      this.lock.readLock().lock();
      res = this.cards;
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  /**
   * This method is thread-safe
   */
  @Override
  public List<PlayingCard> getUpCards() {
    List<PlayingCard> res = null;
    try {
      this.lock.readLock().lock();
      if (this.getAllCards() != null) {
        res = new ArrayList<>();
        for (final PlayingCard card : this.getAllCards()) {
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

  /**
   * This method is thread-safe
   */
  @Override
  public PlayingCard getFirstUpCard() {
    PlayingCard res = null;
    try {
      this.lock.readLock().lock();
      final List<PlayingCard> cardsUp = this.getUpCards();
      if (cardsUp != null && cardsUp.size() > 0) {
        res = cardsUp.get(0);
      }
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  @Override
  public void makeAllCardsWithFaceUp() {
    try {
      this.lock.writeLock().lock();
      final List<PlayingCard> allCards = this.getAllCards();
      if (allCards != null) {
        for (final PlayingCard card : allCards) {
          if (card != null && card.getFacing().equals(Facing.DOWN)) {
            card.setFacing(Facing.UP);
          }
        }
      }
    } finally {
      this.lock.writeLock().unlock();
    }
  }

  /**
   * This method is thread-safe
   */
  protected void setCards(final List<PlayingCard> _cards) {
    try {
      this.lock.writeLock().lock();
      this.cards = _cards;
    } finally {
      this.lock.writeLock().unlock();
    }
  }

  /**
   * This method is thread-safe
   */
  @Override
  public void addCard(final PlayingCard _card) {
    if (_card == null) {
      throw new IllegalArgumentException("not valid parameter card: is null");
    }
    try {
      this.lock.writeLock().lock();
      this.getAllCards().add(_card);
    } finally {
      this.lock.writeLock().unlock();
    }
  }

  /**
   * This method is thread-safe
   */
  @Override
  public int getTotalAllCards() {
    int res = 0;
    try {
      this.lock.readLock().lock();
      res = this.getAllCards().size();
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  /**
   * This method is thread-safe
   */
  @Override
  public int getTotalUpCards() {
    int res = 0;
    try {
      this.lock.readLock().lock();
      res = this.getUpCards().size();
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

  /**
   * This method is thread-safe
   */
  @Override
  public HandValue getValueOfUpCards() {
    HandValue res = null;
    boolean acePresent = false;
    try {
      int val = 0;
      this.lock.readLock().lock();
      final List<PlayingCard> cardsList = this.getUpCards();
      for (final PlayingCard card : cardsList) {
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
      boolean pair = false;
      if (cardsList.size() == 2) {
        final PlayingCard c1 = cardsList.get(0);
        final PlayingCard c2 = cardsList.get(1);
        if (c1 != null && c2 != null) {
          if (c1.getValue() != null && c2.getValue() != null) {
            pair = c1.getValue().equals(c2.getValue());
          }
        }
      }
      res = new HandValue(val, soft, pair);
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  /**
   * This method is thread-safe
   */
  @Override
  public HandValue getValueOfAllCards() {
    HandValue res = null;
    boolean acePresent = false;
    try {
      int val = 0;
      this.lock.readLock().lock();
      final List<PlayingCard> cardsList = this.getAllCards();
      for (final PlayingCard card : this.getAllCards()) {
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
      boolean pair = false;
      if (cardsList.size() == 2) {
        final PlayingCard c1 = cardsList.get(0);
        final PlayingCard c2 = cardsList.get(1);
        if (c1 != null && c2 != null) {
          if (c1.getValue() != null && c2.getValue() != null) {
            pair = c1.getValue().equals(c2.getValue());
          }
        }
      }
      res = new HandValue(val, soft, pair);
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  /**
   * This method is thread-safe
   */
  @Override
  public boolean isAcePresentOnAllCards() {
    boolean res = false;
    try {
      this.lock.readLock().lock();
      final List<PlayingCard> cardsList = this.getAllCards();
      if (cardsList != null && cardsList.size() > 0) {
        for (final PlayingCard card : cardsList) {
          if (card != null && card.getValue().equals("1")) {
            res = true;
            break;
          }
        }
      }
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  /**
   * This method is thread-safe
   */
  @Override
  public boolean isAcePresentOnUpCards() {
    boolean res = false;
    try {
      this.lock.readLock().lock();
      final List<PlayingCard> cardsList = this.getUpCards();
      if (cardsList != null && cardsList.size() > 0) {
        for (final PlayingCard card : cardsList) {
          if (card != null && card.getValue().equals("1")) {
            res = true;
            break;
          }
        }
      }
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  @Override
  public boolean isBusting() {
    boolean res = false;
    try {
      this.lock.readLock().lock();
      res = this.getValueOfAllCards().getValue() > 21;
    } finally {
      this.lock.readLock().unlock();
    }
    return res;
  }

  @Override
  public String toString() {
    return "Hand{" + "cards=" + cards + '}';
  }
}
