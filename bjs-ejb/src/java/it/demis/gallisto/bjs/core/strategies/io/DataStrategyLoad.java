/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.strategies.io;

import it.demis.gallisto.bjs.core.utils.Cache;
import java.io.File;
import java.io.InputStream;
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

    final String fName = this.getFileName();
    if (fName == null || fName.isEmpty()) {
      throw new DataStrategyIOException("not valid filename for strategy data");
    }

    InputStream is = null;
    try {
      synchronized (this.unmarshaller) {
        DataStrategy dataCached = null;
        if (this.cache != null) {
          dataCached = this.cache.get(fName);
        }
        if (dataCached == null) {
          is = this.getClass().getResourceAsStream(fName);
          if (is != null) {
            res = (DataStrategy) this.unmarshaller.unmarshal(this.getClass().getResourceAsStream(fName));
          } else {
            final File file = new File(fName);
            if (file.isFile()) {
              res = (DataStrategy) this.unmarshaller.unmarshal(file);
            } else {
              throw new DataStrategyIOException("not valid file: " + file.getAbsolutePath());
            }
          }
          if (res != null && this.cache != null) {
            this.cache.put(fName, res);
          }
        } else {
          res = dataCached;
        }
      }
      if (_log.isLoggable(Level.INFO)) {
        this._log.log(Level.INFO, "configuration file loaded: {0}", fName);
      }
    } catch (final JAXBException | IllegalArgumentException _e) {
      throw new DataStrategyIOException(_e);
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (final Exception _e) {
          _log.log(Level.WARNING, "exception closing data file inputstream", _e);
        }
      }
    }

    return res;
  }
}