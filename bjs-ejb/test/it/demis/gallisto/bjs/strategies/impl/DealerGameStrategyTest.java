/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.impl;

import it.demis.gallisto.bjs.model.Hand;
import it.demis.gallisto.bjs.model.actors.Memory;
import it.demis.gallisto.bjs.model.cards.Facing;
import it.demis.gallisto.bjs.model.cards.FrenchCard;
import it.demis.gallisto.bjs.model.cards.FrenchSuit;
import it.demis.gallisto.bjs.strategies.Advice;
import it.demis.gallisto.bjs.strategies.GameStrategy;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Demis Gallisto
 */
public class DealerGameStrategyTest {

  private GameStrategy strategy = null;

  public DealerGameStrategyTest() {
    super();
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

  @Before
  public void setUp() {
    this.strategy = new DealerBlackjackGameStrategy();
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetAdvice() throws Exception {

    Hand dHand = null;
    FrenchCard card = null;
    Advice result = null;

    dHand = new Hand();
    card = new FrenchCard("2", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    card = new FrenchCard("3", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    result = this.strategy.getAdvice(null, dHand, null);
    assertEquals(Advice.HIT, result);


    dHand = new Hand();
    card = new FrenchCard("9", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    card = new FrenchCard("8", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    result = this.strategy.getAdvice(null, dHand, null);
    assertEquals(Advice.STAY, result);

    
    dHand = new Hand();
    card = new FrenchCard("9", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    card = new FrenchCard("Q", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    result = this.strategy.getAdvice(null, dHand, null);
    assertEquals(Advice.STAY, result);

    
    dHand = new Hand();
    card = new FrenchCard("2", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    card = new FrenchCard("3", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    card = new FrenchCard("K", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    result = this.strategy.getAdvice(null, dHand, null);
    assertEquals(Advice.HIT, result);

    
    dHand = new Hand();
    card = new FrenchCard("1", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    card = new FrenchCard("1", FrenchSuit.DIAMOND.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    card = new FrenchCard("1", FrenchSuit.HEARTS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    result = this.strategy.getAdvice(null, dHand, null);
    assertEquals(Advice.HIT, result);
    
    
    dHand = new Hand();
    card = new FrenchCard("1", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    card = new FrenchCard("K", FrenchSuit.DIAMOND.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    card = new FrenchCard("Q", FrenchSuit.HEARTS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);

    result = this.strategy.getAdvice(null, dHand, null);
    assertEquals(Advice.STAY, result);

  }
}
