/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.strategies.io;

/**
 *
 * @author Demis Gallisto
 */
public class DataStrategyIOException extends Exception {

  public DataStrategyIOException(final Throwable _e) {
    super(_e);
  }

  public DataStrategyIOException(final String _message) {
    super(_message);
  }
}
