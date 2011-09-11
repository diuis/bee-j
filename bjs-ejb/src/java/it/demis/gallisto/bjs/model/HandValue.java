/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model;

/**
 *
 * @author Demis Gallisto
 */
public class HandValue {

  private int value;
  private boolean soft;

  public HandValue(final int _value, final boolean _soft) {
    this.setValue(_value);
    this.setSoft(_soft);
  }

  public boolean isSoft() {
    return soft;
  }

  private void setSoft(final boolean _soft) {
    this.soft = _soft;
  }

  public int getValue() {
    return value;
  }

  private void setValue(final int _value) {
    this.value = _value;
  }
}
