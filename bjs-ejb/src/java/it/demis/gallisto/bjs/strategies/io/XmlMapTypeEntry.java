/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.io;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author Demis Gallisto
 */
public class XmlMapTypeEntry {

  private Integer key;
  private Integer val;

  public XmlMapTypeEntry() {
    super();
  }

  public XmlMapTypeEntry(final Integer _key, final Integer _val) {
    if (_key == null || _val == null) {
      throw new IllegalArgumentException("not valid parameters key a/o val");
    }
    this.setKey(_key);
    this.setVal(_val);
  }

  @XmlAttribute
  public Integer getKey() {
    return this.key;
  }

  public void setKey(final Integer _key) {
    this.key = _key;
  }

  @XmlValue
  public Integer getVal() {
    return this.val;
  }

  public void setVal(final Integer _val) {
    this.val = _val;
  }
}
