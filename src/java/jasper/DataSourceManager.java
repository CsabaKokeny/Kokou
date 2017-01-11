/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jasper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRXmlDataSource;

/**
 *
 * @author master
 */
public class DataSourceManager {
    
    //JRCsvDataSource
    //JRXlsDataSource
    public static JRXmlDataSource getXmlDataSource(InputStream is, String recordXPath) throws JRException {
        if (recordXPath == null || recordXPath.isEmpty()) {
            return getXmlDataSource(is);
        }
        JRXmlDataSource ds = new JRXmlDataSource(is, recordXPath);
        return ds;
    }
    
    public static JRXmlDataSource getXmlDataSource(String xmlFilename, String recordXPath) throws JRException, IOException {
        if (recordXPath == null || recordXPath.isEmpty()) {
            return getXmlDataSource(xmlFilename);
        }
        JRXmlDataSource ds = new JRXmlDataSource(xmlFilename, recordXPath);
        return ds;
    }
    
    public static JRXmlDataSource getXmlDataSource(File xmlFile, String recordXPath) throws JRException, IOException {
        if (recordXPath == null || recordXPath.isEmpty()) {
            return getXmlDataSource(xmlFile);
        }
        JRXmlDataSource ds = new JRXmlDataSource(xmlFile, recordXPath);
        return ds;
    }
    
    public static JRXmlDataSource getXmlDataSource(InputStream is) throws JRException {
        JRXmlDataSource ds = new JRXmlDataSource(is);
        return ds;
    }
    
    public static JRXmlDataSource getXmlDataSource(String xmlFilename) throws JRException, IOException {
        JRXmlDataSource ds = new JRXmlDataSource(xmlFilename);
        return ds;
    }
    
    public static JRXmlDataSource getXmlDataSource(File xmlFile) throws JRException, IOException {
        JRXmlDataSource ds = new JRXmlDataSource(xmlFile);
        return ds;
    }
    
    public static JRBeanArrayDataSource getBeanArrayDataSource(Object[] beanArray, boolean useFieldDescription) {
        JRBeanArrayDataSource ds = new JRBeanArrayDataSource(beanArray, useFieldDescription);
        return ds;
    }
    
    public static JRBeanArrayDataSource getBeanArrayDataSource(Object[] beanArray) {
        JRBeanArrayDataSource ds = new JRBeanArrayDataSource(beanArray);
        return ds;
    }
    
    public static JRBeanCollectionDataSource getBeanCollectionDataSource(Collection beanCollection, boolean useFieldDescription) {
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(beanCollection, useFieldDescription);
        return ds;
    }
    
    public static JRBeanCollectionDataSource getBeanCollectionDataSource(Collection beanCollection) {
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(beanCollection);
        return ds;
    }
}
