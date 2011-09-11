/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Demis Gallisto
 */
public class DataStrategySave extends DataStrategyIO {

  private volatile static DataStrategySave singleton;

  private Marshaller marshaller;

  private DataStrategySave() {
    super();
    try {
      this.setFileName(System.getProperty("bjs.datastrategy.save.filename", "/opt/develop/data_bj_basicstrategy.xml"));
      this.marshaller = JAXBContext.newInstance(DataStrategy.class).createMarshaller();
      this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    } catch (final JAXBException _e) {
      throw new IllegalStateException("problems on creation a new instance of DataStrategySave", _e);
    }
  }

  public static DataStrategySave getInstance() {
    if (DataStrategySave.singleton == null) {
      synchronized (DataStrategySave.class) {
        if (DataStrategySave.singleton == null) {
          DataStrategySave.singleton = new DataStrategySave();
        }
      }
    }
    return DataStrategySave.singleton;
  }

  public void save() throws DataStrategyIOException {
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

      synchronized (this.marshaller) {
        this.marshaller.marshal(ds, new FileOutputStream(this.getFileName()));
      }
      if (_log.isLoggable(Level.INFO)) {
        this._log.log(Level.INFO, "configuration file saved: {0}", this.getFileName());
      }

    } catch (final FileNotFoundException | JAXBException _e) {
      throw new DataStrategyIOException(_e);
    }

  }

}
