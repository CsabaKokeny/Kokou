/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jasper.exportmanager;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;

/**
 *
 * @author master
 */
public interface ExportManager {
    public Class<? extends JRExporter> getExporterClass();
    public  JRExporter getExporter();
    
    public void exportReport(JasperPrint jasperPrint, String destFile) throws Exception ;
    public void exportReport(JasperPrint jasperPrint, File destFile) throws Exception ;
    public void exportReport(JasperPrint jasperPrint, OutputStream out) throws Exception  ;
    public void exportReport(InputStream is, OutputStream out) throws Exception  ;
    public void exportReport(InputStream is, String destFile) throws Exception  ;
    public void exportReport(InputStream is, File destFile) throws Exception  ;
    public void exportReport(String srcFile, OutputStream out) throws Exception  ;
    public void exportReport(String srcFile, String destFile) throws Exception  ;
    public void exportReport(String srcFile, File destFile) throws Exception  ;
    public void exportReport(File srcFile, OutputStream out) throws Exception  ;
    public void exportReport(File srcFile, String destFile) throws Exception  ;
    public void exportReport(File srcFile, File destFile) throws Exception  ;
    
    
    public void exportReport(JasperReport jasperReport, OutputStream out, Map parameters, Object ds) throws Exception  ;
    public void exportReport(JasperReport jasperReport, String destFile, Map parameters, Object ds) throws Exception  ;
    public void exportReport(JasperReport jasperReport, File destFile, Map parameters, Object ds) throws Exception  ;
    
    public void exportJasperReport(InputStream is, OutputStream out, Map parameters, Object ds) throws Exception  ;
    public void exportJasperReport(InputStream is, String destFile, Map parameters, Object ds) throws Exception  ;
    public void exportJasperReport(InputStream is, File destFile, Map parameters, Object ds) throws Exception  ;
    public void exportJasperReport(String srcFile, OutputStream out, Map parameters, Object ds) throws Exception ;
    public void exportJasperReport(String srcFile, String destFile, Map parameters, Object ds) throws Exception ;
    public void exportJasperReport(String srcFile, File destFile, Map parameters, Object ds) throws Exception  ;
    public void exportJasperReport(File srcFile, OutputStream out, Map parameters, Object ds) throws Exception  ;
    public void exportJasperReport(File srcFile, String destFile, Map parameters, Object ds) throws Exception  ;
    public void exportJasperReport(File srcFile, File destFile, Map parameters, Object ds) throws Exception  ;
    
    
    
    public void exportReport(JasperDesign jasperDesign, OutputStream out, Map parameters, Object ds) throws Exception  ;
    public void exportReport(JasperDesign jasperDesign, String destFile, Map parameters, Object ds) throws Exception  ;
    public void exportReport(JasperDesign jasperDesign, File destFile, Map parameters, Object ds) throws Exception  ;
    
    public void exportJasperDesign(InputStream is, OutputStream out, Map parameters, Object ds) throws Exception  ;
    public void exportJasperDesign(InputStream is, String destFile, Map parameters, Object ds) throws Exception  ;
    public void exportJasperDesign(InputStream is, File destFile, Map parameters, Object ds) throws Exception  ;
    public void exportJasperDesign(String srcFile, OutputStream out, Map parameters, Object ds) throws Exception ;
    public void exportJasperDesign(String srcFile, String destFile, Map parameters, Object ds) throws Exception ;
    public void exportJasperDesign(String srcFile, File destFile, Map parameters, Object ds) throws Exception  ;
    public void exportJasperDesign(File srcFile, OutputStream out, Map parameters, Object ds) throws Exception  ;
    public void exportJasperDesign(File srcFile, String destFile, Map parameters, Object ds) throws Exception  ;
    public void exportJasperDesign(File srcFile, File destFile, Map parameters, Object ds) throws Exception  ;
    
    public void exportReport(String srcFile, OutputStream out, Map parameters, Object ds) throws Exception ;
    public void exportReport(String srcFile, String destFile, Map parameters, Object ds) throws Exception ;
    public void exportReport(String srcFile, File destFile, Map parameters, Object ds) throws Exception  ;
    public void exportReport(File srcFile, OutputStream out, Map parameters, Object ds) throws Exception  ;
    public void exportReport(File srcFile, String destFile, Map parameters, Object ds) throws Exception  ;
    public void exportReport(File srcFile, File destFile, Map parameters, Object ds) throws Exception  ;

}
