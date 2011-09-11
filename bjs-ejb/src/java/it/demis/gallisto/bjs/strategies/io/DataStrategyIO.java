/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.io;

import java.util.logging.Logger;

/**
 *
 * @author Demis Gallisto
 */
public abstract class DataStrategyIO {

  protected Logger _log = Logger.getLogger(this.getClass().getName());
  private String fileName;

  public String getFileName() {
    return fileName;
  }

  protected void setFileName(final String _fileName) {
    this.fileName = _fileName;
  }
}
