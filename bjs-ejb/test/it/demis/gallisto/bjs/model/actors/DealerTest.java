/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model.actors;

import it.demis.gallisto.bjs.model.CardDeck;
import it.demis.gallisto.bjs.model.Hand;
import it.demis.gallisto.bjs.model.cards.Facing;
import it.demis.gallisto.bjs.model.cards.FrenchSuit;
import it.demis.gallisto.bjs.model.cards.FrenchCard;
import it.demis.gallisto.bjs.model.cards.PlayingCard;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Demis Gallisto
 */
public class DealerTest {

  private Dealer dealer;

  public DealerTest() {
    super();
  }

  @Before
  public void setUp() {
    PlayingCard[] cards = new PlayingCard[2];
    cards[0] = new FrenchCard("4", FrenchSuit.SPADES.name());
    cards[1] = new FrenchCard("K", FrenchSuit.SPADES.name());
    this.dealer = new Dealer("test dealer");
    this.dealer.setDeck(new CardDeck());
    this.dealer.getDeck().init();
    this.dealer.init();
  }

  @Test
  public void testGetDeck() {
    assertNotNull(this.dealer.getDeck());
  }

  @Test
  public void testGetHand() {
    Hand hand = this.dealer.getHand();
    assertNotNull(hand);
  }

  @Test
  public void testGetCardsForPlayer() {
    PlayingCard[] cards = this.dealer.getCardsForPlayer();
    assertNotNull(cards);
    assertTrue(cards.length == 2);
    assertEquals(Facing.UP, cards[0].getFacing());
    assertEquals(Facing.UP, cards[1].getFacing());
  }
  
}
