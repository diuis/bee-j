/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.io;


import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Demis Gallisto
 */
public class DataStrategyLoadTest {
  
  public DataStrategyLoadTest() {
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
   * Test of getInstance method, of class DataStrategyLoad.
   */
  @Test
  public void testGetInstance() {
    assertEquals(DataStrategyLoad.getInstance(), DataStrategyLoad.getInstance());
  }

  /**
   * Test of load method, of class DataStrategyLoad.
   */
  @Test
  public void testLoad() throws Exception {
    DataStrategy result = DataStrategyLoad.getInstance().load();
    assertNotNull(result);
  }

}
