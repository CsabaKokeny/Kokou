/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.filter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;

/**
 *
 * @author master
 */
public class ReportManager {
    
    public static JRXmlDataSource getDataSource(InputStream is, String recordXPath) throws JRException {
        if (recordXPath == null || recordXPath.isEmpty()) {
            return getDataSource(is);
        }
        JRXmlDataSource ds = new JRXmlDataSource(is, recordXPath);
        return ds;
    }
    
    public static JRXmlDataSource getDataSource(String xmlFilename, String recordXPath) throws JRException, IOException {
        if (recordXPath == null || recordXPath.isEmpty()) {
            return getDataSource(xmlFilename);
        }
        JRXmlDataSource ds = new JRXmlDataSource(xmlFilename, recordXPath);
        return ds;
    }
    
    public static JRXmlDataSource getDataSource(File xmlFile, String recordXPath) throws JRException, IOException {
        if (recordXPath == null || recordXPath.isEmpty()) {
            return getDataSource(xmlFile);
        }
        JRXmlDataSource ds = new JRXmlDataSource(xmlFile, recordXPath);
        return ds;
    }
    
    public static JRXmlDataSource getDataSource(InputStream is) throws JRException {
        JRXmlDataSource ds = new JRXmlDataSource(is);
        return ds;
    }
    
    public static JRXmlDataSource getDataSource(String xmlFilename) throws JRException, IOException {
        JRXmlDataSource ds = new JRXmlDataSource(xmlFilename);
        return ds;
    }
    
    public static JRXmlDataSource getDataSource(File xmlFile) throws JRException, IOException {
        JRXmlDataSource ds = new JRXmlDataSource(xmlFile);
        return ds;
    }
    
    public static void exportReportToRtf(String sourceFile, String desFile, Map parameters, JRDataSource ds) throws Exception {
        JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFile, parameters, ds);
        JRRtfExporter exporter = new JRRtfExporter();
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, desFile);
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.exportReport();
    }
    
    public static void exportReportToRtf(String sourceFile, Map parameters, JRDataSource ds) throws Exception {
        exportReportToRtf(sourceFile, sourceFile.replaceAll(".jasper", ".rtf"), parameters, ds);
    }
    
    public static void exportReportToDocx(String sourceFile, String desFile, Map parameters, JRDataSource ds) throws Exception {
        JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFile, parameters, ds);
        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, desFile);
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.exportReport();
    }
    
    public static void exportReportToDocx(String sourceFile, Map parameters, JRDataSource ds) throws Exception {
        exportReportToDocx(sourceFile, sourceFile.replaceAll(".jasper", ".docx"), parameters, ds);
    }
    
    public static void exportReportToHtml(String sourceFile, String desFile, Map parameters, JRDataSource ds) throws JRException{
        JasperRunManager.runReportToHtmlFile(sourceFile, desFile, parameters, ds);
    }
    
    public static void exportReportToHtml(String sourceFile, Map parameters, JRDataSource ds) throws JRException{
        JasperRunManager.runReportToHtmlFile(sourceFile, parameters, ds);
    }
}
