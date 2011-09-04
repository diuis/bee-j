/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.impl;

import it.demis.gallisto.bjs.strategies.GameStrategy;

/**
 *
 * @author Demis Gallisto
 */
public abstract class AbstractGameStrategy implements GameStrategy {
 
  public String getName() {
    return this.getClass().getSimpleName();
  }
  
}
