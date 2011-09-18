/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.strategies;

import it.demis.gallisto.bjs.core.model.Hand;
import it.demis.gallisto.bjs.core.model.actors.Memory;

/**
 *
 * @author Demis Gallisto
 */
public interface GameStrategy {

  String getName();

  Advice getAdvice(Hand _playerHand, Hand _dealerHand, Memory _playerMemory) throws StrategyException;
}
