/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.impl;

import it.demis.gallisto.bjs.model.Hand;
import it.demis.gallisto.bjs.model.actors.Memory;
import it.demis.gallisto.bjs.strategies.Advice;
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
public class PlayerBlackjackBasicStrategyTest {

  public PlayerBlackjackBasicStrategyTest() {
    super();
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetAdvice() throws Exception {
    System.out.println("getAdvice");
    Hand _playerHand = null;
    Hand _dealerHand = null;
    Memory _playerMemory = null;
    PlayerBlackjackBasicStrategy instance = new PlayerBlackjackBasicStrategy();
    Advice expResult = null;
    Advice result = instance.getAdvice(_playerHand, _dealerHand, _playerMemory);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
}
