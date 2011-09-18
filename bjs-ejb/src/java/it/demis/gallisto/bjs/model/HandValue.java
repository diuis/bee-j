/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model;

import java.io.Serializable;

/**
 *
 * @author Demis Gallisto
 */
public class HandValue implements Serializable {

  private int value = 0;
  private boolean soft = false;
  private boolean pair = false;

  private HandValue() {
    super();
  }

  public HandValue(final int _value, final boolean _isSoft, final boolean _isPair) {
    super();
    this.setValue(_value);
    this.setSoft(_isSoft);
    this.setPair(_isPair);
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

  public boolean isPair() {
    return pair;
  }

  private void setPair(final boolean _pair) {
    this.pair = _pair;
  }

  @Override
  public String toString() {
    return "HandValue{" + "value=" + value + ", soft=" + soft + ", pair=" + pair + '}';
  }
}
