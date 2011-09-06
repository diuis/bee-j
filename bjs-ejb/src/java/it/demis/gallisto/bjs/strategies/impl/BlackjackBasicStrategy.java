/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.impl;

import it.demis.gallisto.bjs.strategies.AbstractGameStrategy;
import it.demis.gallisto.bjs.model.Hand;
import it.demis.gallisto.bjs.model.actors.Memory;
import it.demis.gallisto.bjs.strategies.Advice;

/**
 *
 * @author Demis Gallisto
 */
@PlayerQualifier
public class BlackjackBasicStrategy extends AbstractGameStrategy {

  public BlackjackBasicStrategy() {
    super();
  }
  
  public String toString() {
    return "BlackjackBasicStrategy{" + '}';
  }

  @Override
  public Advice getAdvice(final Hand _playerHand, final Hand _dealerHand, final Memory _playerMemory) {
    // TODO to be implemented...
    Advice res = null;
    if (_dealerHand.totalCards() >= 17) {
      res = Advice.STAY;
    } else {
      res = Advice.HIT;
    }
    return res;
  }
  
  
}
