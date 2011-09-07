/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.strategies.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Demis Gallisto
 */
public class DataStrategyLoad {

  private volatile static DataStrategyLoad singleton;

  public static DataStrategyLoad getInstance() {
    if (DataStrategyLoad.singleton == null) {
      synchronized (DataStrategyLoad.class) {
        if (DataStrategyLoad.singleton == null) {
          DataStrategyLoad.singleton = new DataStrategyLoad();
        }
      }
    }
    return DataStrategyLoad.singleton;
  }

  public DataStrategyLoad() {
    super();
  }

  public DataStrategy load() throws DataStrategyIOException  {
    
    DataStrategy res = null;
    
    try {
      

      final Unmarshaller m = JAXBContext.newInstance(DataStrategy.class).createUnmarshaller();
      DataStrategy ds = (DataStrategy) m.unmarshal(this.getClass().getResourceAsStream("/META-INF/data_bj_basicstrategy.xml"));
      
      
    } catch (final JAXBException _e) {
      throw  new DataStrategyIOException(_e);
    }
    
    return res;
  }

  

  public static void main(String[] args) throws DataStrategyIOException {
    DataStrategy ds = DataStrategyLoad.getInstance().load();
    
  }
}
