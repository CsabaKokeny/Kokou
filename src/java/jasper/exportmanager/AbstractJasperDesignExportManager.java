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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author master
 */
abstract public class AbstractJasperDesignExportManager extends AbstractJasperReportExportManager{
    
    public static JasperDesign getJasperDesign(InputStream is) throws Exception {
        return JRXmlLoader.load(is);
    }
    
    public static JasperDesign getJasperDesign(String filename) throws Exception {
        return JRXmlLoader.load(filename);
    }
    
    public static JasperDesign getJasperDesign(File file) throws Exception {
        return JRXmlLoader.load(file);
    }
    
    public static JasperDesign getJasperDesign() throws Exception {
        return new JasperDesign();
    }
    
    public static JasperReport getJasperReportFromJasperDesign(InputStream is) throws Exception {
        return JasperCompileManager.compileReport(is);
    }
    
    public static JasperReport getJasperReportFromJasperDesign(String filename) throws Exception {
        return JasperCompileManager.compileReport(filename);
    }
    
    public static JasperReport getJasperReportFromJasperDesign(File file) throws Exception {
        return JasperCompileManager.compileReport(file.getAbsolutePath());        
    }
    
    public static JasperReport getJasperReportFromJasperDesign(JasperDesign design) throws Exception {
        return JasperCompileManager.compileReport(design);        
    }
    
    @Override
    public void exportReport(JasperDesign jasperDesign, OutputStream out, Map parameters, Object ds) throws Exception  {
        JasperReport report = JasperCompileManager.compileReport(jasperDesign);
        exportReport(report, out, parameters, ds);
    }
    
    @Override
    public void exportReport(JasperDesign jasperDesign, String destFile, Map parameters, Object ds) throws Exception  {
        JasperReport report = JasperCompileManager.compileReport(jasperDesign);
        exportReport(report, destFile, parameters, ds);
    }
    
    @Override
    public void exportReport(JasperDesign jasperDesign, File destFile, Map parameters, Object ds) throws Exception  {
        JasperReport report = JasperCompileManager.compileReport(jasperDesign);
        exportReport(report, destFile, parameters, ds);
    }
    
    @Override
    public void exportJasperDesign(InputStream is, OutputStream out, Map parameters, Object ds) throws Exception  {
        JasperReport report = JasperCompileManager.compileReport(is);
        // JasperDsign design = JRXmlLoader.load(is);
        // report = JasperCompileManager.compileReport(design);    
        exportReport(report, out, parameters, ds);
    }
    
    @Override
    public void exportJasperDesign(InputStream is, String destFile, Map parameters, Object ds) throws Exception  {
        JasperReport report = JasperCompileManager.compileReport(is);
        // JasperDsign design = JRXmlLoader.load(is);
        // report = JasperCompileManager.compileReport(design);    
        exportReport(report, destFile, parameters, ds);
    }
    
    @Override
    public void exportJasperDesign(InputStream is, File destFile, Map parameters, Object ds) throws Exception  {
        JasperReport report = JasperCompileManager.compileReport(is);
        // JasperDsign design = JRXmlLoader.load(is);
        // report = JasperCompileManager.compileReport(design);    
        exportReport(report, destFile, parameters, ds);
    }
    
    @Override
    public void exportJasperDesign(String srcFile, OutputStream out, Map parameters, Object ds) throws Exception {
        JasperReport report = JasperCompileManager.compileReport(srcFile);
        // JasperDsign design = JRXmlLoader.load(srcFile);
        // report = JasperCompileManager.compileReport(design);    
        exportReport(report, out, parameters, ds);
    }
    
    @Override
    public void exportJasperDesign(String srcFile, String destFile, Map parameters, Object ds) throws Exception {
        JasperReport report = JasperCompileManager.compileReport(srcFile);
        // JasperDsign design = JRXmlLoader.load(srcFile);
        // report = JasperCompileManager.compileReport(design);    
        exportReport(report, srcFile, parameters, ds);
    }
    @Override
    public void exportJasperDesign(String srcFile, File destFile, Map parameters, Object ds) throws Exception  {
        JasperReport report = JasperCompileManager.compileReport(srcFile);
        // JasperDsign design = JRXmlLoader.load(srcFile);
        // report = JasperCompileManager.compileReport(design);    
        exportReport(report, srcFile, parameters, ds);
    }
    
}
