/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demis Gallisto
 */
@XmlRootElement
public class DataStrategy {

  private Logger log = Logger.getLogger(this.getClass().getName());
  private String[][] hard;
  private String[][] soft;
  private String[][] pair;
  private Map<Integer,Integer> plHardMapping = new HashMap<>();
  private Map<Integer,Integer> plSoftMapping = new HashMap<>();
  private Map<Integer,Integer> plPairMapping = new HashMap<>();
  private Map<Integer,Integer> dealerMapping = new HashMap<>();

  public Map getPlHardMapping() {
    return this.plHardMapping;
  }

  public void setPlHardMapping(final Map _plHardMapping) {
    this.plHardMapping = _plHardMapping;
  }

  public Map getPlPairMapping() {
    return this.plPairMapping;
  }

  public void setPlPairMapping(final Map _plPairMapping) {
    this.plPairMapping = _plPairMapping;
  }

  public Map getPlSoftMapping() {
    return this.plSoftMapping;
  }

  public void setPlSoftMapping(final Map _plSoftMapping) {
    this.plSoftMapping = _plSoftMapping;
  }

  public String[][] getHard() {
    return hard;
  }

  public void setHard(final String[][] _hard) {
    this.hard = _hard;
  }

  public String[][] getPair() {
    return pair;
  }

  public void setPair(final String[][] _pair) {
    this.pair = _pair;
  }

  public String[][] getSoft() {
    return soft;
  }

  public void setSoft(final String[][] _soft) {
    this.soft = _soft;
  }

  public void init() {
    this.hard = new String[10][16];
    this.soft = new String[10][8];
    this.pair = new String[10][10];

    this.hard = new String[][]{{"hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi"},
                               {"hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi"},
                               {"hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi"},
                               {"hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi"},
                               {"hi", "dh", "dh", "dh", "dh", "hi", "hi", "hi", "hi", "hi"},
                               {"dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "hi", "hi"},
                               {"dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "hi"},
                               {"hi", "hi", "st", "st", "st", "hi", "hi", "hi", "hi", "hi"},
                               {"st", "st", "st", "st", "st", "hi", "hi", "hi", "hi", "hi"},
                               {"st", "st", "st", "st", "st", "hi", "hi", "hi", "hi", "hi"},
                               {"st", "st", "st", "st", "st", "hi", "hi", "hi", "su", "hi"},
                               {"st", "st", "st", "st", "st", "hi", "hi", "su", "su", "su"},
                               {"st", "st", "st", "st", "st", "st", "st", "st", "st", "st"},
                               {"st", "st", "st", "st", "st", "st", "st", "st", "st", "st"},
                               {"st", "st", "st", "st", "st", "st", "st", "st", "st", "st"},
                               {"st", "st", "st", "st", "st", "st", "st", "st", "st", "st"}};

    this.soft = new String[][]{{"hi", "hi", "hi", "dh", "dh", "hi", "hi", "hi", "hi", "hi"},
                               {"hi", "hi", "hi", "dh", "dh", "hi", "hi", "hi", "hi", "hi"},
                               {"hi", "hi", "dh", "dh", "dh", "hi", "hi", "hi", "hi", "hi"},
                               {"hi", "hi", "dh", "dh", "dh", "hi", "hi", "hi", "hi", "hi"},
                               {"hi", "dh", "dh", "dh", "dh", "hi", "hi", "hi", "hi", "hi"},
                               {"st", "ds", "ds", "ds", "ds", "st", "st", "hi", "hi", "hi"},
                               {"st", "st", "st", "st", "st", "st", "st", "st", "st", "st"},
                               {"st", "st", "st", "st", "st", "st", "st", "st", "st", "st"}};

    this.pair = new String[][]{{"sp", "sp", "sp", "sp", "sp", "sp", "hi", "hi", "hi", "hi"},
                               {"sp", "sp", "sp", "sp", "sp", "sp", "hi", "hi", "hi", "hi"},
                               {"hi", "hi", "hi", "sp", "sp", "hi", "hi", "hi", "hi", "hi"},
                               {"dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "hi", "hi"},
                               {"sp", "sp", "sp", "sp", "sp", "hi", "hi", "hi", "hi", "hi"},
                               {"sp", "sp", "sp", "sp", "sp", "sp", "hi", "hi", "hi", "hi"},
                               {"sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp"},
                               {"sp", "sp", "sp", "sp", "sp", "st", "sp", "sp", "st", "st"},
                               {"st", "st", "st", "st", "st", "st", "st", "st", "st", "st"},
                               {"sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp"}};

    log.info("hard initialized: " + Arrays.deepToString(this.hard));
    log.info("soft initialized: " + Arrays.deepToString(this.soft));
    log.info("pair initialized: " + Arrays.deepToString(this.pair));

    for (int i = 0; i <= 10; i++) {
    }
  }
}
