/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.strategies.io;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Demis Gallisto
 */
@XmlRootElement(namespace = "http://demis.gallisto.it/bjs")
public class DataStrategy implements Serializable {

  private String[][] hard;
  private String[][] soft;
  private String[][] pair;
  private Map<Integer, Integer> plHardMapping = new HashMap<>();
  private Map<Integer, Integer> plSoftMapping = new HashMap<>();
  private Map<Integer, Integer> plPairMapping = new HashMap<>();
  private Map<Integer, Integer> dealerMapping = new HashMap<>();

  @XmlJavaTypeAdapter(XmlMapTypeAdapter.class)
  public Map<Integer, Integer> getDealerMapping() {
    return dealerMapping;
  }

  public void setDealerMapping(final Map<Integer, Integer> _dealerMapping) {
    this.dealerMapping = _dealerMapping;
  }

  @XmlJavaTypeAdapter(XmlMapTypeAdapter.class)
  public Map<Integer, Integer> getPlayerHardMapping() {
    return this.plHardMapping;
  }

  public void setPlayerHardMapping(final Map<Integer, Integer> _plHardMapping) {
    this.plHardMapping = _plHardMapping;
  }

  @XmlJavaTypeAdapter(XmlMapTypeAdapter.class)
  public Map<Integer, Integer> getPlayerPairMapping() {
    return this.plPairMapping;
  }

  public void setPlayerPairMapping(final Map<Integer, Integer> _plPairMapping) {
    this.plPairMapping = _plPairMapping;
  }

  @XmlJavaTypeAdapter(XmlMapTypeAdapter.class)
  public Map<Integer, Integer> getPlayerSoftMapping() {
    return this.plSoftMapping;
  }

  public void setPlayerSoftMapping(final Map<Integer, Integer> _plSoftMapping) {
    this.plSoftMapping = _plSoftMapping;
  }

  @XmlElement
  public String[][] getHard() {
    return hard;
  }

  public void setHard(final String[][] _hard) {
    this.hard = _hard;
  }

  @XmlElement
  public String[][] getPair() {
    return pair;
  }

  public void setPair(final String[][] _pair) {
    this.pair = _pair;
  }

  @XmlElement
  public String[][] getSoft() {
    return soft;
  }

  public void setSoft(final String[][] _soft) {
    this.soft = _soft;
  }
}
