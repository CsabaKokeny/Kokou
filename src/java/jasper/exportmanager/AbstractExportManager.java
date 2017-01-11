/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jasper.exportmanager;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import org.w3c.dom.Document;

/**
 *
 * @author master
 */
abstract public class AbstractExportManager implements ExportManager  {
    private JRExporter mExporter = null;
   
    public static JRDataSource getJRDataSource(Object ds) throws Exception {
        JRDataSource datasource = null;
        if (ds instanceof JRDataSource) {
            datasource = (JRDataSource)ds;
        } else if (ds instanceof String) {
            datasource = new JRXmlDataSource ((String)ds);
        } else if (ds instanceof File) {
            datasource = new JRXmlDataSource ((File)ds);
        } else if (ds instanceof InputStream) {
            datasource = new JRXmlDataSource ((InputStream)ds);
        } else if (ds instanceof Document) {
            datasource = new JRXmlDataSource ((Document)ds);
        } else if (ds instanceof Collection) {
            datasource = new JRBeanCollectionDataSource((Collection)ds);
        } else if (ds instanceof Object[]) {
            datasource = new JRBeanArrayDataSource((Object[])ds);
        }
        return datasource;
    }
    
    public static JRDataSource getJRDataSource(Object ds, String selectExpression) throws Exception {
        JRDataSource datasource = null;
        if (ds instanceof JRDataSource) {
            datasource = (JRDataSource)ds;
        } else if (ds instanceof String) {
            datasource = new JRXmlDataSource ((String)ds, selectExpression);
        } else if (ds instanceof File) {
            datasource = new JRXmlDataSource ((File)ds, selectExpression);
        } else if (ds instanceof InputStream) {
            datasource = new JRXmlDataSource ((InputStream)ds, selectExpression);
        } else if (ds instanceof Document) {
            datasource = new JRXmlDataSource ((Document)ds, selectExpression);
        } else if (ds instanceof Collection) {
            datasource = new JRBeanCollectionDataSource((Collection)ds);
        } else if (ds instanceof Object[]) {
            datasource = new JRBeanArrayDataSource((Object[])ds);
        }
        return datasource;
    }
    
    public static JRDataSource getJRDataSource(Object ds, boolean isUseFieldDescription) throws Exception {
        JRDataSource datasource = null;
        if (ds instanceof JRDataSource) {
            datasource = (JRDataSource)ds;
        } else if (ds instanceof String) {
            datasource = new JRXmlDataSource ((String)ds);
        } else if (ds instanceof File) {
            datasource = new JRXmlDataSource ((File)ds);
        } else if (ds instanceof InputStream) {
            datasource = new JRXmlDataSource ((InputStream)ds);
        } else if (ds instanceof Document) {
            datasource = new JRXmlDataSource ((Document)ds);
        } else if (ds instanceof Collection) {
            datasource = new JRBeanCollectionDataSource((Collection)ds, isUseFieldDescription);
        } else if (ds instanceof Object[]) {
            datasource = new JRBeanArrayDataSource((Object[])ds, isUseFieldDescription);
        }
        return datasource;
    }
    
    public static JRDataSource getJRDataSource(Object ds, String selectExpression ,boolean isUseFieldDescription) throws Exception {
        JRDataSource datasource = null;
        if (ds instanceof JRDataSource) {
            datasource = (JRDataSource)ds;
        } else if (ds instanceof String) {
            datasource = new JRXmlDataSource ((String)ds, selectExpression);
        } else if (ds instanceof File) {
            datasource = new JRXmlDataSource ((File)ds, selectExpression);
        } else if (ds instanceof InputStream) {
            datasource = new JRXmlDataSource ((InputStream)ds, selectExpression);
        } else if (ds instanceof Document) {
            datasource = new JRXmlDataSource ((Document)ds, selectExpression);
        } else if (ds instanceof Collection) {
            datasource = new JRBeanCollectionDataSource((Collection)ds, isUseFieldDescription);
        } else if (ds instanceof Object[]) {
            datasource = new JRBeanArrayDataSource((Object[])ds, isUseFieldDescription);
        }
        return datasource;
    }
    
    @Override
    public  JRExporter getExporter()  {
        if (mExporter == null) {
            Class clazz = getExporterClass();
            try {
                mExporter = (JRExporter)clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException ex){
                System.err.println(ex);
            }
        }
        return mExporter;
    }
    
    @Override
    public void exportReport(File srcFile, OutputStream out) throws Exception  {
        exportReport(srcFile.getAbsolutePath(), out);
    }
    
    @Override
    public void exportReport(File srcFile, String destFile) throws Exception  {
        exportReport(srcFile.getAbsolutePath(), destFile);
    }
    
    @Override
    public void exportReport(File srcFile, File destFile) throws Exception  {
        exportReport(srcFile.getAbsolutePath(), destFile);
    }
    
    @Override
    public void exportJasperReport(File srcFile, OutputStream out, Map parameters, Object ds) throws Exception  {
        exportJasperReport(srcFile.getAbsolutePath(), out, parameters, ds);
    }
    
    @Override
    public void exportJasperReport(File srcFile, String destFile, Map parameters, Object ds) throws Exception  {
        exportJasperReport(srcFile.getAbsolutePath(), destFile, parameters, ds);
    }
    
    @Override
    public void exportJasperReport(File srcFile, File destFile, Map parameters, Object ds) throws Exception  {
        exportJasperReport(srcFile.getAbsolutePath(), destFile, parameters, ds);
    }
    
    @Override
    public void exportJasperDesign(File srcFile, OutputStream out, Map parameters, Object ds) throws Exception  {
        exportJasperDesign(srcFile.getAbsolutePath(), out, parameters, ds);
        
    }
    @Override
    public void exportJasperDesign(File srcFile, String destFile, Map parameters, Object ds) throws Exception  {
        exportJasperDesign(srcFile.getAbsolutePath(), destFile, parameters, ds);
    }
    
    @Override
    public void exportJasperDesign(File srcFile, File destFile, Map parameters, Object ds) throws Exception  {
        exportJasperDesign(srcFile.getAbsolutePath(), destFile, parameters, ds);
    }
    
    @Override
    public void exportReport(String srcFile, OutputStream out, Map parameters, Object ds) throws Exception {
        String filename = srcFile.toLowerCase();
        if (filename.endsWith(".jasper")) {
            exportJasperReport(srcFile, out, parameters, ds);
        } else if (filename.endsWith(".jrxml")) {
            exportJasperDesign(srcFile, out, parameters, ds);
        }
    }
    
    @Override
    public void exportReport(String srcFile, String destFile, Map parameters, Object ds) throws Exception {
        String filename = srcFile.toLowerCase();
        if (filename.endsWith(".jasper")) {
            exportJasperReport(srcFile, destFile, parameters, ds);
        } else if (filename.endsWith(".jrxml")) {
            exportJasperDesign(srcFile, destFile, parameters, ds);
        }
    }
    
    @Override
    public void exportReport(String srcFile, File destFile, Map parameters, Object ds) throws Exception  {
        String filename = srcFile.toLowerCase();
        if (filename.endsWith(".jasper")) {
            exportJasperReport(srcFile, destFile, parameters, ds);
        } else if (filename.endsWith(".jrxml")) {
            exportJasperDesign(srcFile, destFile, parameters, ds);
        }
    }
    
    @Override
    public void exportReport(File srcFile, OutputStream out, Map parameters, Object ds) throws Exception  {
        exportReport(srcFile.getAbsolutePath(), out, parameters, ds);
    }
    
    @Override
    public void exportReport(File srcFile, String destFile, Map parameters, Object ds) throws Exception  {
        exportReport(srcFile.getAbsolutePath(), destFile, parameters, ds);
    }
    
    @Override
    public void exportReport(File srcFile, File destFile, Map parameters, Object ds) throws Exception  {
        exportReport(srcFile.getAbsolutePath(), destFile, parameters, ds);
    }
}
