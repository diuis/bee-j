/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.load;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    try {
      DataStrategy ds = new DataStrategy();

      String[][] hard = new String[10][16];
      String[][] soft = new String[10][8];
      String[][] pair = new String[10][10];

      hard = new String[][]{
        {"hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi"},
        {"hi", "dh", "dh", "dh", "dh", "hi", "hi", "hi", "hi", "hi"},
        {"dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "hi", "hi"},
        {"dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "hi"},
        {"hi", "hi", "st", "st", "st", "hi", "hi", "hi", "hi", "hi"},
        {"st", "st", "st", "st", "st", "hi", "hi", "hi", "hi", "hi"},
        {"st", "st", "st", "st", "st", "hi", "hi", "hi", "su", "hi"},
        {"st", "st", "st", "st", "st", "hi", "hi", "su", "su", "su"},
        {"st", "st", "st", "st", "st", "st", "st", "st", "st", "st"}};

      soft = new String[][]{
        {"hi", "hi", "hi", "dh", "dh", "hi", "hi", "hi", "hi", "hi"},
        {"hi", "hi", "dh", "dh", "dh", "hi", "hi", "hi", "hi", "hi"},
        {"hi", "dh", "dh", "dh", "dh", "hi", "hi", "hi", "hi", "hi"},
        {"st", "ds", "ds", "ds", "ds", "st", "st", "hi", "hi", "hi"},
        {"st", "st", "st", "st", "st", "st", "st", "st", "st", "st"}};

      pair = new String[][]{
        {"sp", "sp", "sp", "sp", "sp", "sp", "hi", "hi", "hi", "hi"},
        {"hi", "hi", "hi", "sp", "sp", "hi", "hi", "hi", "hi", "hi"},
        {"dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "hi", "hi"},
        {"sp", "sp", "sp", "sp", "sp", "hi", "hi", "hi", "hi", "hi"},
        {"sp", "sp", "sp", "sp", "sp", "sp", "hi", "hi", "hi", "hi"},
        {"sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp"},
        {"sp", "sp", "sp", "sp", "sp", "st", "sp", "sp", "st", "st"},
        {"st", "st", "st", "st", "st", "st", "st", "st", "st", "st"},
        {"sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp"}};

      ds.setHard(hard);
      ds.setSoft(soft);
      ds.setPair(pair);
      
      ds.getDealerMapping().put(2, 0);
      ds.getDealerMapping().put(3, 1);
      ds.getDealerMapping().put(4, 2);
      ds.getDealerMapping().put(5, 3);
      ds.getDealerMapping().put(6, 4);
      ds.getDealerMapping().put(7, 5);
      ds.getDealerMapping().put(8, 6);
      ds.getDealerMapping().put(9, 7);
      ds.getDealerMapping().put(10, 8);
      ds.getDealerMapping().put(1, 9);
      
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

      ds.getPlSoftMapping().put(2, 0);
      ds.getPlSoftMapping().put(3, 0);
      ds.getPlSoftMapping().put(3, 1);
      ds.getPlSoftMapping().put(5, 1);
      ds.getPlSoftMapping().put(6, 2);
      ds.getPlSoftMapping().put(7, 4);
      ds.getPlSoftMapping().put(8, 5);
      ds.getPlSoftMapping().put(9, 5);

      ds.getPlPairMapping().put(2, 0);
      ds.getPlPairMapping().put(3, 0);
      ds.getPlPairMapping().put(4, 1);
      ds.getPlPairMapping().put(5, 2);
      ds.getPlPairMapping().put(6, 3);
      ds.getPlPairMapping().put(7, 4);
      ds.getPlPairMapping().put(8, 5);
      ds.getPlPairMapping().put(9, 6);
      ds.getPlPairMapping().put(10, 7);
      ds.getPlPairMapping().put(1, 8);

      JAXBContext jc = JAXBContext.newInstance(DataStrategy.class);
      Marshaller m = jc.createMarshaller();
      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      m.marshal(ds, new FileOutputStream("/opt/develop/data_bj_basicstrategy.xml"));
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }

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
