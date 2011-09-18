/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model.cards;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Demis Gallisto
 */
public class FrenchCardTest {

  private FrenchCard card1;
  private FrenchCard card2;
  private FrenchCard card3;

  public FrenchCardTest() {
    super();
  }

  @Before
  public void setUp() {
    this.card1 = new FrenchCard("Q", FrenchSuit.CLUBS.name());
    this.card1.setFacing(Facing.UP);
    this.card2 = new FrenchCard("J", FrenchSuit.CLUBS.name());
    this.card2.setFacing(Facing.UP);
    this.card3 = new FrenchCard("K", FrenchSuit.CLUBS.name());
  }

  @Test
  public void testgetValue() {
    assertEquals("Q", this.card1.getValue());
    assertEquals("J", this.card2.getValue());
    assertEquals("", this.card3.getValue());
  }

  @Test
  public void testGetSuit() {
    assertEquals(FrenchSuit.CLUBS.name(), this.card1.getSuit());
    assertEquals(FrenchSuit.CLUBS.name(), this.card2.getSuit());
    assertEquals("", this.card3.getSuit());
  }

  @Test
  public void testGetFacing() {
    assertEquals(Facing.UP, this.card1.getFacing());
    assertEquals(Facing.UP, this.card2.getFacing());
    assertEquals(Facing.DOWN, this.card3.getFacing());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor1() {
    new FrenchCard("B", FrenchSuit.CLUBS.name());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2() {
    new FrenchCard("2", "not_available");
  }
}
