/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model.actors;

import it.demis.gallisto.bjs.model.Hand;
import java.util.List;
import it.demis.gallisto.bjs.model.cards.FrenchCard;
import it.demis.gallisto.bjs.model.cards.Facing;
import it.demis.gallisto.bjs.model.cards.FrenchSuit;
import it.demis.gallisto.bjs.model.cards.PlayingCard;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Demis Gallisto
 */
public class PlayerTest {

  private BlackjackPlayer player;

  public PlayerTest() {
    super();
  }

  @Before
  public void setUp() {
    PlayingCard[] cards = new PlayingCard[2];
    cards[0] = new FrenchCard("4", FrenchSuit.SPADES.name());
    cards[0].setFacing(Facing.UP);
    cards[1] = new FrenchCard("K", FrenchSuit.SPADES.name());
    cards[1].setFacing(Facing.UP);
    this.player = new BlackjackPlayer("test player");
    this.player.initHand(cards);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitHand() {

    PlayingCard[] cards = new PlayingCard[3];

    cards[0] = new FrenchCard("3", FrenchSuit.CLUBS.name());
    cards[1] = new FrenchCard("Q", FrenchSuit.CLUBS.name());
    cards[2] = new FrenchCard("4", FrenchSuit.CLUBS.name());

    BlackjackPlayer pl = new BlackjackPlayer();
    pl.initHand(cards);

  }

  @Test
  public void testGetHand() {
    Hand hand = this.player.getHand();
    assertNotNull(hand);

    List<PlayingCard> cards = hand.getUpCards();
    assertNotNull(cards);

    assertEquals(Facing.UP, cards.get(0).getFacing());
    assertEquals(Facing.UP, cards.get(1).getFacing());
  }
}
