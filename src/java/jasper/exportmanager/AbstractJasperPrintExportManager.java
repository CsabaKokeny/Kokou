/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jasper.exportmanager;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.xml.JRPrintXmlLoader;

/**
 *
 * @author master
 */
abstract public class AbstractJasperPrintExportManager extends AbstractExportManager {
    
    public static JasperPrint getJaspserPrint(InputStream is) throws Exception {
        return JRPrintXmlLoader.load(is);
    }
    
    public static JasperPrint getJaspserPrint(String filename) throws Exception {
        return JRPrintXmlLoader.load(filename);
    }
    
    public static JasperPrint getJaspserPrint(File file) throws Exception {
        return JRPrintXmlLoader.load(file.getAbsolutePath());
    }
    
    public static JasperPrint getJaspserPrint() throws Exception {
        return new JasperPrint();
    }
    
    @Override
    public void exportReport(JasperPrint jasperPrint, String destFile) throws Exception {
        JRExporter exporter = getExporter();
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile);
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.exportReport();
    }
    
    @Override
    public void exportReport(JasperPrint jasperPrint, File destFile) throws Exception {
        JRExporter exporter = getExporter();
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, destFile);
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.exportReport();
    }
    
    @Override
    public void exportReport(JasperPrint jasperPrint, OutputStream out) throws Exception  {
        JRExporter exporter = getExporter();
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.exportReport();
    }
    
    @Override
    public void exportReport(InputStream is, OutputStream out) throws Exception  {
        JasperPrint print = JRPrintXmlLoader.load(is);
        exportReport(print, out);
    }
    
    @Override
    public void exportReport(InputStream is, String destFile) throws Exception  {
        JasperPrint print = JRPrintXmlLoader.load(is);
        exportReport(print, destFile);
    }
    
    @Override
    public void exportReport(InputStream is, File destFile) throws Exception  {
        JasperPrint print = JRPrintXmlLoader.load(is);
        exportReport(print, destFile);
    }
    
    @Override
    public void exportReport(String srcFile, OutputStream out) throws Exception  {
        JasperPrint print = JRPrintXmlLoader.load(srcFile);
        exportReport(print, out);
    }
    
    @Override
    public void exportReport(String srcFile, String destFile) throws Exception  {
        JasperPrint print = JRPrintXmlLoader.load(srcFile);
        exportReport(print, destFile);
    }
    
    @Override
    public void exportReport(String srcFile, File destFile) throws Exception  {
        JasperPrint print = JRPrintXmlLoader.load(srcFile);
        exportReport(print, destFile);
    }
}
