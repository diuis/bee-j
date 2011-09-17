/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.io;


import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Demis Gallisto
 */
public class DataStrategyLoadTest {
  
  public DataStrategyLoadTest() {
    super();
  }

  @Before
  public void setUp() {
    System.setProperty("bjs.datastrategy.load.filename", "/opt/develop/data_bj_basicstrategy.xml");
  }
  
  @After
  public void tearDown() {
  }

  @Test
  public void testGetInstance() {
    assertEquals(DataStrategyLoad.getInstance(), DataStrategyLoad.getInstance());
  }

  @Test
  public void testLoad() throws Exception {
    DataStrategy result = DataStrategyLoad.getInstance().load();
    assertNotNull(result);
    
    assertNull(result.getPlayerHardMapping().get(1));
    assertNull(result.getPlayerHardMapping().get(2));
    assertNull(result.getPlayerHardMapping().get(3));
    assertNull(result.getPlayerHardMapping().get(4));
    assertNull(result.getPlayerHardMapping().get(21));
    
    assertEquals(new Integer(0), result.getPlayerHardMapping().get(5));
  }

}
