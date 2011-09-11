/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies;

import it.demis.gallisto.bjs.strategies.io.DataStrategyIOException;

/**
 *
 * @author Demis Gallisto
 */
public class StrategyException extends Exception {

  public StrategyException(final String _message, final DataStrategyIOException _e) {
    super(_message, _e);
  }

  public StrategyException(final String _message) {
    super(_message);
  }
}
