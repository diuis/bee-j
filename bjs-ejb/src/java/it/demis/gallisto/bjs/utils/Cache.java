/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.utils;

import java.io.Serializable;

/**
 *
 * @author Demis Gallisto
 */
public interface Cache<K extends String, T extends Serializable> {
  
  T get(K _key);
  
  T put(K _key, T _val);
}
