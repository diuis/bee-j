/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.strategies.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
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
      
      ds.getPlayerHardMapping().put(5, 0);
      ds.getPlayerHardMapping().put(6, 0);
      ds.getPlayerHardMapping().put(7, 0);
      ds.getPlayerHardMapping().put(8, 0);
      ds.getPlayerHardMapping().put(9, 1);
      ds.getPlayerHardMapping().put(10, 2);
      ds.getPlayerHardMapping().put(11, 3);
      ds.getPlayerHardMapping().put(12, 4);
      ds.getPlayerHardMapping().put(13, 5);
      ds.getPlayerHardMapping().put(14, 5);
      ds.getPlayerHardMapping().put(15, 6);
      ds.getPlayerHardMapping().put(16, 7);
      ds.getPlayerHardMapping().put(17, 8);
      ds.getPlayerHardMapping().put(18, 8);
      ds.getPlayerHardMapping().put(19, 8);
      ds.getPlayerHardMapping().put(20, 8);

      ds.getPlayerSoftMapping().put(2, 0);
      ds.getPlayerSoftMapping().put(3, 0);
      ds.getPlayerSoftMapping().put(4, 1);
      ds.getPlayerSoftMapping().put(5, 1);
      ds.getPlayerSoftMapping().put(6, 2);
      ds.getPlayerSoftMapping().put(7, 3);
      ds.getPlayerSoftMapping().put(8, 4);
      ds.getPlayerSoftMapping().put(9, 4);

      ds.getPlayerPairMapping().put(2, 0);
      ds.getPlayerPairMapping().put(3, 0);
      ds.getPlayerPairMapping().put(4, 1);
      ds.getPlayerPairMapping().put(5, 2);
      ds.getPlayerPairMapping().put(6, 3);
      ds.getPlayerPairMapping().put(7, 4);
      ds.getPlayerPairMapping().put(8, 5);
      ds.getPlayerPairMapping().put(9, 6);
      ds.getPlayerPairMapping().put(10, 7);
      ds.getPlayerPairMapping().put(1, 8);

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
