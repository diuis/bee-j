/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.strategies;

import java.util.logging.Logger;

/**
 *
 * @author Demis Gallisto
 */
public abstract class AbstractGameStrategy implements GameStrategy {

  protected transient final Logger _log = Logger.getLogger(this.getClass().getName());

  @Override
  public String getName() {
    return this.getClass().getSimpleName();
  }
}
