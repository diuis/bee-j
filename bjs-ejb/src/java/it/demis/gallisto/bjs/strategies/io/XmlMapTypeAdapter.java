/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.io;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Demis Gallisto
 */
public class XmlMapTypeAdapter extends XmlAdapter<XmlMapType, Map<Integer, Integer>> {

  @Override
  public Map unmarshal(final XmlMapType _xmlMapType) throws Exception {
    Map res = null;
    if (_xmlMapType != null) {
      res = new HashMap();
      if (_xmlMapType.getEntry() != null) {
        for (final XmlMapTypeEntry entry : _xmlMapType.getEntry()) {
          if (entry != null) {
            res.put(entry.getKey(), entry.getVal());
          }
        }
      }
    }
    return res;
  }

  @Override
  public XmlMapType marshal(final Map<Integer, Integer> _map) throws Exception {
    XmlMapType res = null;
    if (_map != null) {
      res = new XmlMapType();
      if (_map.size() > 0) {
        res.setEntry(new LinkedList<XmlMapTypeEntry>());
        for (final Integer key : _map.keySet()) {
          res.getEntry().add(new XmlMapTypeEntry(key, _map.get(key)));
        }
      }
    }
    return res;
  }
}
