/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.impl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

/**
 *
 * @author Demis Gallisto
 */
public class DataStrategyLoader {

  private volatile static DataStrategyLoader singleton;

  public static DataStrategyLoader getInstance() {
    if (DataStrategyLoader.singleton == null) {
      synchronized (DataStrategyLoader.class) {
        if (DataStrategyLoader.singleton == null) {
          DataStrategyLoader.singleton = new DataStrategyLoader();
        }
      }
    }
    return DataStrategyLoader.singleton;
  }

  public DataStrategyLoader() {
    super();
  }

  public DataStrategy load() {
    DataStrategy res = null;

    return res;
  }

  public void save() throws PropertyException, JAXBException {
    DataStrategy ds = new DataStrategy();
    ds.init();
    ds.getPlHardMapping().put(5, 0);
    ds.getPlHardMapping().put(6, 0);
    ds.getPlHardMapping().put(7, 0);
    ds.getPlHardMapping().put(8, 0);
    ds.getPlHardMapping().put(9, 1);
    ds.getPlHardMapping().put(10, 2);
    ds.getPlHardMapping().put(11, 3);
    ds.getPlHardMapping().put(12, 4);
    ds.getPlHardMapping().put(13, 5);
    ds.getPlHardMapping().put(14, 5);
    ds.getPlHardMapping().put(15, 6);
    ds.getPlHardMapping().put(16, 7);
    ds.getPlHardMapping().put(17, 8);
    ds.getPlHardMapping().put(18, 8);
    ds.getPlHardMapping().put(19, 8);
    ds.getPlHardMapping().put(20, 8);


    JAXBContext jc = JAXBContext.newInstance(DataStrategy.class);
    Marshaller m = jc.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    m.marshal(ds, System.out);

  }

  public static void main(String[] args) {
    try {
      DataStrategyLoader.getInstance().save();
    } catch (PropertyException ex) {
      ex.printStackTrace();
    } catch (JAXBException ex) {
      ex.printStackTrace();
    }
  }
}
