/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.model.cards;

import it.demis.gallisto.bjs.core.model.cards.PlayingCardDecorator;
import it.demis.gallisto.bjs.core.model.cards.FrenchCard;
import it.demis.gallisto.bjs.core.model.cards.FrenchSuit;
import it.demis.gallisto.bjs.core.model.cards.Facing;
import it.demis.gallisto.bjs.core.model.cards.BlackJackCardDecorator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Demis Gallisto
 */
public class BlackJackCardDecoratorTest {

  private PlayingCardDecorator card1;
  private PlayingCardDecorator card2;
  private PlayingCardDecorator card3;

  public BlackJackCardDecoratorTest() {
    super();
  }

  @Before
  public void setUp() {
    this.card1 = new BlackJackCardDecorator(new FrenchCard("2", FrenchSuit.CLUBS.name()));
    this.card2 = new BlackJackCardDecorator(new FrenchCard("K", FrenchSuit.DIAMOND.name()));
    this.card3 = new BlackJackCardDecorator(new FrenchCard("J", FrenchSuit.HEARTS.name()));
    this.card1.setFacing(Facing.UP);
    this.card2.setFacing(Facing.UP);
  }

  @Test
  public void testGetFacing() {
    assertEquals(Facing.UP, this.card1.getFacing());
    assertEquals(Facing.UP, this.card2.getFacing());
    assertEquals(Facing.DOWN, this.card3.getFacing());
  }

  @Test
  public void testSetFacing() {
    this.card1.setFacing(Facing.DOWN);
    this.card2.setFacing(Facing.DOWN);
    assertEquals(Facing.DOWN, this.card1.getFacing());
    assertEquals(Facing.DOWN, this.card2.getFacing());
    this.card1.setFacing(Facing.UP);
    this.card2.setFacing(Facing.UP);
    assertEquals(Facing.UP, this.card1.getFacing());
    assertEquals(Facing.UP, this.card2.getFacing());
  }

  @Test
  public void testGetValue() {
    assertEquals("2", this.card1.getValue());
    assertEquals("K", this.card2.getValue());
    assertEquals("", this.card3.getValue());
  }

  @Test
  public void testGetSuit() {
    assertEquals(FrenchSuit.CLUBS.name(), this.card1.getSuit());
    assertEquals(FrenchSuit.DIAMOND.name(), this.card2.getSuit());
    assertEquals("", this.card3.getSuit());
  }

  @Test
  public void testGetCalculatedValue() {
    assertEquals(2, this.card1.getCalculatedValue());
    assertEquals(10, this.card2.getCalculatedValue());
    assertEquals(0, this.card3.getCalculatedValue());
  }
}
