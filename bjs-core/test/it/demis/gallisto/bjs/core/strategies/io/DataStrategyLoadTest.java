/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.strategies.io;

import it.demis.gallisto.bjs.core.strategies.io.DataStrategyLoad;
import it.demis.gallisto.bjs.core.strategies.io.DataStrategy;
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
    assertEquals(new Integer(0), result.getPlayerHardMapping().get(6));
    assertEquals(new Integer(0), result.getPlayerHardMapping().get(7));
    assertEquals(new Integer(0), result.getPlayerHardMapping().get(8));
    assertEquals(new Integer(1), result.getPlayerHardMapping().get(9));
    assertEquals(new Integer(2), result.getPlayerHardMapping().get(10));
    assertEquals(new Integer(3), result.getPlayerHardMapping().get(11));
    assertEquals(new Integer(4), result.getPlayerHardMapping().get(12));
    assertEquals(new Integer(5), result.getPlayerHardMapping().get(13));
    assertEquals(new Integer(5), result.getPlayerHardMapping().get(14));
    assertEquals(new Integer(6), result.getPlayerHardMapping().get(15));
    assertEquals(new Integer(7), result.getPlayerHardMapping().get(16));
    assertEquals(new Integer(8), result.getPlayerHardMapping().get(17));
    assertEquals(new Integer(8), result.getPlayerHardMapping().get(18));
    assertEquals(new Integer(8), result.getPlayerHardMapping().get(19));
    assertEquals(new Integer(8), result.getPlayerHardMapping().get(20));

    assertNull(result.getPlayerSoftMapping().get(1));
    assertNull(result.getPlayerSoftMapping().get(10));

    assertEquals(new Integer(0), result.getPlayerSoftMapping().get(2));
    assertEquals(new Integer(0), result.getPlayerSoftMapping().get(3));
    assertEquals(new Integer(1), result.getPlayerSoftMapping().get(4));
    assertEquals(new Integer(1), result.getPlayerSoftMapping().get(5));
    assertEquals(new Integer(2), result.getPlayerSoftMapping().get(6));
    assertEquals(new Integer(3), result.getPlayerSoftMapping().get(7));
    assertEquals(new Integer(4), result.getPlayerSoftMapping().get(8));
    assertEquals(new Integer(4), result.getPlayerSoftMapping().get(9));

    assertEquals(new Integer(0), result.getPlayerPairMapping().get(2));
    assertEquals(new Integer(0), result.getPlayerPairMapping().get(3));
    assertEquals(new Integer(1), result.getPlayerPairMapping().get(4));
    assertEquals(new Integer(2), result.getPlayerPairMapping().get(5));
    assertEquals(new Integer(3), result.getPlayerPairMapping().get(6));
    assertEquals(new Integer(4), result.getPlayerPairMapping().get(7));
    assertEquals(new Integer(5), result.getPlayerPairMapping().get(8));
    assertEquals(new Integer(6), result.getPlayerPairMapping().get(9));
    assertEquals(new Integer(7), result.getPlayerPairMapping().get(10));
    assertEquals(new Integer(8), result.getPlayerPairMapping().get(1));

    assertEquals(new Integer(0), result.getDealerMapping().get(2));
    assertEquals(new Integer(1), result.getDealerMapping().get(3));
    assertEquals(new Integer(2), result.getDealerMapping().get(4));
    assertEquals(new Integer(3), result.getDealerMapping().get(5));
    assertEquals(new Integer(4), result.getDealerMapping().get(6));
    assertEquals(new Integer(5), result.getDealerMapping().get(7));
    assertEquals(new Integer(6), result.getDealerMapping().get(8));
    assertEquals(new Integer(7), result.getDealerMapping().get(9));
    assertEquals(new Integer(8), result.getDealerMapping().get(10));
    assertEquals(new Integer(9), result.getDealerMapping().get(1));

  }
}
