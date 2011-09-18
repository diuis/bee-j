/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.utils;


import it.demis.gallisto.bjs.core.utils.Cache;
import it.demis.gallisto.bjs.core.utils.VerySimpleCache;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Demis Gallisto
 */
public class VerySimpleCacheTest {

  private Cache cache1 = null;
  private Cache cache2 = null;
  private Cache cache3 = null;
  private String key1 = "1";
  private String key2 = "2";
  private String key3 = "3";
  private Integer obj1 = 1;
  private Integer obj2 = 2;
  private Integer obj3 = 3;

  public VerySimpleCacheTest() {
    super();
  }

  @Before
  public void setUp() {
    this.cache1 = new VerySimpleCache();
    this.cache2 = new VerySimpleCache();
    this.cache3 = new VerySimpleCache();

    this.cache1.put(this.key1, this.obj1);
    this.cache1.put(this.key2, this.obj2);
    this.cache1.put(this.key3, this.obj3);
  }

  @After
  public void tearDown() {
    this.cache1 = null;
    this.cache2 = null;
    this.cache3 = null;
  }

  @Test
  public void testGet() {
    assertEquals(this.obj1, this.cache1.get(this.key1));
    assertEquals(this.obj2, this.cache1.get(this.key2));
    assertEquals(this.obj3, this.cache1.get(this.key3));

    assertEquals(null, this.cache2.get(this.key1));
    assertEquals(null, this.cache2.get(this.key2));
    assertEquals(null, this.cache2.get(this.key3));
  }

  @Test
  public void testPut() {
    assertEquals(this.cache3.put(this.key1, this.obj1), this.obj1);
    assertEquals(this.cache3.put(this.key2, this.obj2), this.obj2);
    assertEquals(this.cache3.put(this.key3, this.obj3), this.obj3);
  }
}
