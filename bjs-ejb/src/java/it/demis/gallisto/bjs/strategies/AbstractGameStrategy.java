/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies;

/**
 *
 * @author Demis Gallisto
 */
public abstract class AbstractGameStrategy implements GameStrategy {
 
  public String getName() {
    return this.getClass().getSimpleName();
  }
  
}