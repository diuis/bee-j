/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.impl;

import it.demis.gallisto.bjs.strategies.Advice;
import it.demis.gallisto.bjs.strategies.GameStrategy;

/**
 *
 * @author Demis Gallisto
 */
@PlayerQualifier
public class BlackjackBasicStrategy extends AbstractGameStrategy {

  @Override
  public Advice giveAdvice() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public String toString() {
    return "BlackjackBasicStrategy{" + '}';
  }
  
  
}
