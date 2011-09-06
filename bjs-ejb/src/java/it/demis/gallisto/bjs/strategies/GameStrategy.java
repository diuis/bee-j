/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies;

import it.demis.gallisto.bjs.model.Hand;
import it.demis.gallisto.bjs.model.actors.Memory;

/**
 *
 * @author Demis Gallisto
 */
public interface GameStrategy {
  
  String getName();
  
  Advice getAdvice(Hand _playerHand, Hand _dealerHand, Memory _playerMemory);
}
