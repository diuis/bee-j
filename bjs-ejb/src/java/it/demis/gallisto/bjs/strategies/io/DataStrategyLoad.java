/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.io;

import it.demis.gallisto.bjs.utils.Cache;
import java.util.logging.Level;
import javax.inject.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Demis Gallisto
 */
public class DataStrategyLoad extends DataStrategyIO {

  private volatile static DataStrategyLoad singleton;
  private Unmarshaller unmarshaller;
  @Singleton
  private Cache<String, DataStrategy> cache;

  public static DataStrategyLoad getInstance() {
    if (DataStrategyLoad.singleton == null) {
      synchronized (DataStrategyLoad.class) {
        if (DataStrategyLoad.singleton == null) {
          try {
            DataStrategyLoad.singleton = new DataStrategyLoad();
          } catch (final JAXBException _e) {
            throw new IllegalStateException("jaxb unmarshaller not created", _e);
          }
        }
      }
    }
    return DataStrategyLoad.singleton;
  }

  private DataStrategyLoad() throws JAXBException {
    super();
    this.setFileName(System.getProperty("bjs.datastrategy.load.filename", "/META-INF/data_bj_basicstrategy.xml"));
    this.unmarshaller = JAXBContext.newInstance(DataStrategy.class).createUnmarshaller();
  }

  public DataStrategy load() throws DataStrategyIOException {

    DataStrategy res = null;

    try {
      synchronized (this.unmarshaller) {
        DataStrategy dataCached = null;
        if (this.cache != null) {
          dataCached = this.cache.get(this.getClass().getName());
        }
        if (dataCached == null) {
          res = (DataStrategy) this.unmarshaller.unmarshal(this.getClass().getResourceAsStream(this.getFileName()));
          if (res != null && this.cache != null) {
            this.cache.put(this.getClass().getName(), res);
          }
        } else {
          res = dataCached;
        }
      }
      if (_log.isLoggable(Level.INFO)) {
        this._log.log(Level.INFO, "configuration file loaded: {0}", this.getFileName());
      }
    } catch (final JAXBException _e) {
      throw new DataStrategyIOException(_e);
    }

    return res;
  }
}