/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.model.actors;

import it.demis.gallisto.bjs.core.model.BlackjackCardDeckQualifier;
import it.demis.gallisto.bjs.core.model.CardDeck;
import it.demis.gallisto.bjs.core.model.BlackjackHand;
import it.demis.gallisto.bjs.core.model.cards.Facing;
import it.demis.gallisto.bjs.core.model.cards.PlayingCard;
import it.demis.gallisto.bjs.core.strategies.GameStrategy;
import it.demis.gallisto.bjs.core.strategies.impl.DealerQualifier;
import java.util.logging.Level;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author Demis Gallisto
 */
@ManagedBean
public class BlackjackDealer extends GameActor {

  @Inject
  @BlackjackCardDeckQualifier
  private CardDeck deck;

  public BlackjackDealer() {
    this(null);
  }

  public BlackjackDealer(final String _name) {
    super();
    this.setName(_name == null || _name.isEmpty() ? "anonymous dealer" : _name);
    this.setHand(new BlackjackHand());
  }

  @PostConstruct
  public void init() {
    _log.log(Level.INFO, "dealer created, his name is {0}", this.getName());
    final PlayingCard card1 = this.getDeck().getCard();
    final PlayingCard card2 = this.getDeck().getCard();
    card2.setFacing(Facing.UP);
    this.getHand().addCard(card1);
    this.getHand().addCard(card2);
  }

  protected CardDeck getDeck() {
    return this.deck;
  }

  protected void setDeck(final CardDeck _deck) {
    this.deck = _deck;
  }

  public PlayingCard[] getCardsForPlayer() {
    final PlayingCard[] res = new PlayingCard[2];
    res[0] = this.getDeck().getCard();
    res[0].setFacing(Facing.UP);
    res[1] = this.getDeck().getCard();
    res[1].setFacing(Facing.UP);
    if (_log.isLoggable(Level.INFO)) {
      _log.log(Level.INFO, "tot remaining cards : {0}", this.getDeck().totalAvailableCards());
      _log.log(Level.INFO, "tot removed cards : {0}", this.getDeck().totalRemovedCards());
    }
    return res;
  }

  @Override
  @Inject
  public void setStrategy(@DealerQualifier final GameStrategy _strategy) {
    super.setStrategy(_strategy);
  }
}
