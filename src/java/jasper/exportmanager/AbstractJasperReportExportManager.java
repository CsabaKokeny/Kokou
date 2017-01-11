/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jasper.exportmanager;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author master
 */
abstract public class AbstractJasperReportExportManager extends AbstractJasperPrintExportManager {
    
    
    public static JasperPrint getJasperPrintFromJasperReport(JasperReport report, Map parameters, Object ds) throws Exception {
        if (ds instanceof Connection) {
            return JasperFillManager.fillReport(report, parameters, (Connection)ds);
        } else {
            return JasperFillManager.fillReport(report, parameters, getJRDataSource(ds));
        }
    }
    
    public static JasperPrint getJasperPrintFromJasperReport(InputStream is, Map parameters, Object ds) throws Exception {
        if (ds instanceof Connection) {
            return JasperFillManager.fillReport(is, parameters, (Connection)ds);
        } else {
            return JasperFillManager.fillReport(is, parameters, getJRDataSource(ds));
        }
    }
    
    public static JasperPrint getJasperPrintFromJasperReport(String srcFile, Map parameters, Object ds) throws Exception {
        if (ds instanceof Connection) {
            return JasperFillManager.fillReport(srcFile, parameters, (Connection)ds);
        } else {
            return JasperFillManager.fillReport(srcFile, parameters, getJRDataSource(ds));
        }
    }
    
    public static JasperPrint getJasperPrintFromJasperReport(File srcFile, Map parameters, Object ds) throws Exception {
        return getJasperPrintFromJasperReport(srcFile.getAbsolutePath(), parameters, ds);
    }
    
    public static JasperPrint getJasperPrint() throws Exception {
        return new JasperPrint();
    }
    
    @Override
    public void exportReport(JasperReport jasperReport, OutputStream out, Map parameters, Object ds) throws Exception  {
        JasperPrint jasperPrint = getJasperPrintFromJasperReport(jasperReport, parameters, ds);
        exportReport(jasperPrint, out);
    }
    
    @Override
    public void exportReport(JasperReport jasperReport, String destFile, Map parameters, Object ds) throws Exception  {
        JasperPrint jasperPrint = getJasperPrintFromJasperReport(jasperReport, parameters, ds);
        exportReport(jasperPrint, destFile);
    }
    
    @Override
    public void exportReport(JasperReport jasperReport, File destFile, Map parameters, Object ds) throws Exception  {
        JasperPrint jasperPrint = getJasperPrintFromJasperReport(jasperReport, parameters, ds);
        exportReport(jasperPrint, destFile);
    }
    
    @Override
    public void exportJasperReport(InputStream is, OutputStream out, Map parameters, Object ds) throws Exception  {
        JasperPrint print = getJasperPrintFromJasperReport(is, parameters, ds);
        exportReport(print, out);
    }
    
    @Override
    public void exportJasperReport(InputStream is, String destFile, Map parameters, Object ds) throws Exception  {
        JasperPrint print = getJasperPrintFromJasperReport(is, parameters, ds);
        exportReport(print, destFile);
    }
    
    @Override
    public void exportJasperReport(InputStream is, File destFile, Map parameters, Object ds) throws Exception  {
        JasperPrint print = getJasperPrintFromJasperReport(is, parameters, ds);
        exportReport(print, destFile);
    }
    
    @Override
    public void exportJasperReport(String srcFile, OutputStream out, Map parameters, Object ds) throws Exception  {
        JasperPrint print = getJasperPrintFromJasperReport(srcFile, parameters, ds);
        exportReport(print, out);
    }
    
    @Override
    public void exportJasperReport(String srcFile, String destFile, Map parameters, Object ds) throws Exception  {
        JasperPrint print = getJasperPrintFromJasperReport(srcFile, parameters, ds);
        exportReport(print, destFile);
    }
    
    @Override
    public void exportJasperReport(String srcFile, File destFile, Map parameters, Object ds) throws Exception  {
        JasperPrint print = getJasperPrintFromJasperReport(srcFile, parameters, ds);
        exportReport(print, destFile);
    }
}