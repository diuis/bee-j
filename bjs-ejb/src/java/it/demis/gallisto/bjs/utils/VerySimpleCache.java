/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.inject.Singleton;

/**
 *
 * @author Demis Gallisto
 */
@Singleton
public class VerySimpleCache<K extends String, T extends Serializable> implements Cache<K, T> {

  private Map<K, T> map = new HashMap<>();
  private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

  public VerySimpleCache() {
    super();
  }

  @Override
  public T get(final K _key) {
    T res = null;
    if (_key != null) {
      try {
        this.lock.readLock().lock();
        res = this.map.get(_key);
      } finally {
        this.lock.readLock().unlock();
      }
    }
    return res;
  }

  @Override
  public T put(final K _key, final T _val) {
    T res = null;
    if (_key != null && _val != null) {
      try {
        this.lock.writeLock().lock();
        this.map.put(_key, _val);
        res = _val;
      } finally {
        this.lock.writeLock().unlock();
      }
    }
    return res;
  }
}
