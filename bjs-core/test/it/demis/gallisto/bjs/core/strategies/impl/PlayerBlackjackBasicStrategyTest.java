/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.strategies.impl;

import it.demis.gallisto.bjs.core.strategies.impl.PlayerBlackjackBasicStrategy;
import it.demis.gallisto.bjs.core.model.cards.Facing;
import it.demis.gallisto.bjs.core.model.cards.FrenchSuit;
import it.demis.gallisto.bjs.core.model.cards.FrenchCard;
import it.demis.gallisto.bjs.core.strategies.GameStrategy;
import it.demis.gallisto.bjs.core.model.BlackjackHand;
import it.demis.gallisto.bjs.core.strategies.Advice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Demis Gallisto
 */
public class PlayerBlackjackBasicStrategyTest {

  private GameStrategy strategy = null;

  public PlayerBlackjackBasicStrategyTest() {
    super();
  }

  @Before
  public void setUp() {
    System.setProperty("bjs.datastrategy.load.filename", "/opt/develop/data_bj_basicstrategy.xml");
    this.strategy = new PlayerBlackjackBasicStrategy();
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetAdvice() throws Exception {

    BlackjackHand dHand = null;
    BlackjackHand pHand = null;
    FrenchCard card = null;
    Advice result = null;

    dHand = new BlackjackHand();
    card = new FrenchCard("2", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.DOWN);
    dHand.addCard(card);
    card = new FrenchCard("3", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);
    pHand = new BlackjackHand();
    card = new FrenchCard("3", FrenchSuit.DIAMOND.name());
    card.setFacing(Facing.UP);
    pHand.addCard(card);

    result = this.strategy.getAdvice(pHand, dHand, null);
    assertEquals(Advice.NOT_AVAILABLE, result);


    dHand = new BlackjackHand();
    card = new FrenchCard("2", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.DOWN);
    dHand.addCard(card);
    card = new FrenchCard("3", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);
    pHand = new BlackjackHand();
    card = new FrenchCard("4", FrenchSuit.DIAMOND.name());
    card.setFacing(Facing.UP);
    pHand.addCard(card);

    result = this.strategy.getAdvice(pHand, dHand, null);
    assertEquals(Advice.NOT_AVAILABLE, result);


    dHand = new BlackjackHand();
    card = new FrenchCard("2", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.DOWN);
    dHand.addCard(card);
    card = new FrenchCard("3", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);
    pHand = new BlackjackHand();
    card = new FrenchCard("6", FrenchSuit.DIAMOND.name());
    card.setFacing(Facing.UP);
    pHand.addCard(card);

    result = this.strategy.getAdvice(pHand, dHand, null);
    assertEquals(Advice.HIT, result);


    dHand = new BlackjackHand();
    card = new FrenchCard("2", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.DOWN);
    dHand.addCard(card);
    card = new FrenchCard("9", FrenchSuit.CLUBS.name());
    card.setFacing(Facing.UP);
    dHand.addCard(card);
    
    pHand = new BlackjackHand();
    card = new FrenchCard("10", FrenchSuit.DIAMOND.name());
    card.setFacing(Facing.UP);
    pHand.addCard(card);
    card = new FrenchCard("2", FrenchSuit.DIAMOND.name());
    card.setFacing(Facing.UP);
    pHand.addCard(card);
    card = new FrenchCard("4", FrenchSuit.DIAMOND.name());
    card.setFacing(Facing.UP);
    pHand.addCard(card);

    result = this.strategy.getAdvice(pHand, dHand, null);
    assertEquals(Advice.SURRENDER, result);

  }
}
