/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.io;

import java.io.File;

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
public class DataStrategySaveTest {

  public DataStrategySaveTest() {
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
   * Test of getInstance method, of class DataStrategySave.
   */
  @Test
  public void testGetInstance() {
    assertEquals(DataStrategySave.getInstance(), DataStrategySave.getInstance());
  }

  /**
   * Test of save method, of class DataStrategySave.
   */
  @Test
  public void testSave() throws Exception {
    final DataStrategySave dss = DataStrategySave.getInstance();
    dss.save();
    File file = new File(dss.getFileName());
    assertTrue(file != null && file.exists());
  }
}
