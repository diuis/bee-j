/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.io;

import java.util.List;

/**
 *
 * @author Demis Gallisto
 */
public class XmlMapType {

  private List<XmlMapTypeEntry> entry;

  public List<XmlMapTypeEntry> getEntry() {
    return this.entry;
  }

  public void setEntry(final List<XmlMapTypeEntry> _entry) {
    this.entry = _entry;
  }
}
