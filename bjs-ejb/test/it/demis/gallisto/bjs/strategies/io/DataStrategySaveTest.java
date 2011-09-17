/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.io;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Demis Gallisto
 */
public class DataStrategySaveTest {

  public DataStrategySaveTest() {
    super();
  }

  @Before
  public void setUp() {
    System.setProperty("bjs.datastrategy.save.filename", "/opt/develop/data_bj_basicstrategy.xml");
  }

  @Test
  public void testGetInstance() {
    assertEquals(DataStrategySave.getInstance(), DataStrategySave.getInstance());
  }

  @Test
  public void testSave() throws Exception {
    final DataStrategySave dss = DataStrategySave.getInstance();
    dss.save();
    File file = new File(dss.getFileName());
    assertTrue(file != null && file.exists());
  }
}
