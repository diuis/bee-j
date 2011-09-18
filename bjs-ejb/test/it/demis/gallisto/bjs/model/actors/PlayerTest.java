/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model.actors;

import it.demis.gallisto.bjs.model.Hand;
import it.demis.gallisto.bjs.model.cards.PlayingCard;
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
public class PlayerTest {
  
  public PlayerTest() {
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
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of initHand method, of class Player.
   */
  @Test
  public void testInitHand() {
    System.out.println("initHand");
    PlayingCard[] _card = null;
    Player instance = new Player();
    instance.initHand(_card);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of init method, of class Player.
   */
  @Test
  public void testInit() {
    System.out.println("init");
    Player instance = new Player();
    instance.init();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getHand method, of class Player.
   */
  @Test
  public void testGetHand() {
    System.out.println("getHand");
    Player instance = new Player();
    Hand expResult = null;
    Hand result = instance.getHand();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setHand method, of class Player.
   */
  @Test
  public void testSetHand() {
    System.out.println("setHand");
    Hand _hand = null;
    Player instance = new Player();
    instance.setHand(_hand);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getAdvice method, of class Player.
   */
  @Test
  public void testGetAdvice() throws Exception {
    System.out.println("getAdvice");
    Hand _dealerHand = null;
    Player instance = new Player();
    String expResult = "";
    String result = instance.getAdvice(_dealerHand);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of play method, of class Player.
   */
  @Test
  public void testPlay() throws Exception {
    System.out.println("play");
    Player instance = new Player();
    instance.play();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of stay method, of class Player.
   */
  @Test
  public void testStay() {
    System.out.println("stay");
    Player instance = new Player();
    instance.stay();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of hit method, of class Player.
   */
  @Test
  public void testHit() {
    System.out.println("hit");
    Player instance = new Player();
    instance.hit();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setStrategy method, of class Player.
   */
  @Test
  public void testSetStrategy() {
    System.out.println("setStrategy");
    GameStrategy _strategy = null;
    Player instance = new Player();
    instance.setStrategy(_strategy);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
}
