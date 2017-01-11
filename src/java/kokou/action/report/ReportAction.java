/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action.report;

import kokou.filter.ReportManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import kokou.action.DefaultAction;
import my.helper.File_Helper;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
/**
 *
 * @author master
 */
abstract public class ReportAction extends DefaultAction {
    
    private String reportType;
    private String printType;
    
    public String getReportType() {
        return reportType;
    }
    public void setReportType(String reportType) {
        this.reportType=reportType;
    }
    
    public String getPrintType() {
        return printType;
    }
    
    public void setPrintType(String printType) {
        this.printType = printType;
    }
    
    public JRXmlDataSource getTempDataSource(String filename, String recordQuery) throws JRException, IOException {
        File tempDir = getTempDirectory();
        File file = new File(tempDir, filename);
        return ReportManager.getDataSource(new FileInputStream(file), recordQuery);
    }
    
    public JRXmlDataSource getDataSource(String filename, String recordQuery) throws JRException, IOException {
        return ReportManager.getDataSource(getRealPath(filename), recordQuery);
    }
    
    public String getReportFilename(String name) {
        return getRealPath("/")+"reports/templates/"+name;
    }
    
    public String getResultFilename(String name) {
        File tempDir = getTempDirectory();
        return tempDir.getAbsolutePath()+name;
    }
    
    public void exportDocx(String srcFilename, String destFilename, Map parameter, String dataSource, String recordQuery) throws Exception {
        exportDocx(srcFilename, destFilename, parameter, getTempDataSource(dataSource, recordQuery));
    }
    
    public void exportDocx(String srcFilename, String destFilename, Map parameter, JRXmlDataSource ds) throws Exception {
        ReportManager.exportReportToDocx(getReportFilename(srcFilename), getResultFilename(destFilename), parameter, ds);
    }
    
    public void exportHtml(String srcFilename, String destFilename, Map parameter, String dataSource, String recordQuery) throws Exception {
        exportHtml(srcFilename, destFilename, parameter, getTempDataSource(dataSource, recordQuery));
    }
    
    public void exportHtml(String srcFilename, String destFilename, Map parameter, JRXmlDataSource ds) throws Exception {
        ReportManager.exportReportToHtml(getReportFilename(srcFilename), getResultFilename(destFilename), parameter, ds);
    }
    
    public String getTempDirectoryPath() {
        String homeDirPath = getRealPath("/")+"reports/temp/"+this.getSessioId();
        return homeDirPath;
    }
    
    public File getTempDirectory() {
        String homeDirPath= getTempDirectoryPath();
        File homeDir = new File(homeDirPath);
        if (!homeDir.isDirectory() || !homeDir.exists()) {
            homeDir.mkdirs();
        }
        try {
            File data = new File(homeDir, "data.xml");
            if (!data.exists()) {
                data.createNewFile();
                File_Helper.copy(getRealPath("reports/templates/preschool/data.xml"), data);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return homeDir;
    }
            
    abstract public void preview() throws Exception;
    
    abstract public void print() throws Exception;
    
    public void execute() {
        try {
            if (getPrintType()!=null && getPrintType().equalsIgnoreCase("prev")) {
                preview();
            } else {
                print();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    
    
}
