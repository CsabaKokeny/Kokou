/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.filter;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.helper.File_Helper;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRXmlDataSource;

/**
 *
 * @author master
 */
abstract public class ReportFilter implements Filter{

    protected FilterConfig filterConfig;
    protected FilterChain filterChain;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    
    
    protected String sessionId;
    protected String printType;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
 /*       Font font = null;
        boolean bLoad = true;
        try {
            String [] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
            for(String fontName : fontNames) {
                System.err.println(fontName);
                if (fontName.contains("MS PMincho")) {
                    bLoad = false;
                }
            }
        }catch (Exception ex) {
            
        }
        if (bLoad) {
            try {
                font = Font.createFont(Font.TRUETYPE_FONT, new File("/media/partitions/sda9/msmincho.ttc"));
                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
                String [] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
                for(String fontName : fontNames) {
                    System.err.println(fontName);
                }
            } catch (Exception ex) {
                
            }
        }
         */
    }
    
    public String getRealPath(String relative) {
        return this.filterConfig.getServletContext().getRealPath(relative);
    }
    
    public void printHtml(String report, Map params, String dsFile, String query) {
        try {
            exportHtml(report+".jasper", report+".html", params, dsFile, query);
            response.setContentType("text/html;charset=UTF-8");
            File_Helper.copy(getTempFileAbsolutePath(report+".html"),response.getOutputStream());
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    public void printDocx(String report, Map params, String dsFile, String query) {
        try {
            exportDocx(report+".jasper", report+".docx", params, dsFile, query);
            response.setContentType("application/binary");
            response.addHeader("Content-Disposition", "inline; filename=\"result.docx\"");
            File_Helper.copy(getTempFileAbsolutePath(report+".docx"),response.getOutputStream());
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    public void printRtf(String report, Map params, String dsFile, String query) {
        try {
            exportRtf(report+".jasper", report+".rtf", params, dsFile, query);
            response.setContentType("application/binary");
            response.addHeader("Content-Disposition", "inline; filename=\"result.rtf\"");
            File_Helper.copy(getTempFileAbsolutePath(report+".rtf"),response.getOutputStream());
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    public JRXmlDataSource getTempDataSource(String filename, String recordQuery) throws JRException, IOException {
        File tempDir = getTempDirectory();
        File file = new File(tempDir, filename);
        return ReportManager.getDataSource(file, recordQuery);
    }
    
    public JRXmlDataSource getTempDataSource(String filename) throws JRException, IOException {
        File tempDir = getTempDirectory();
        File file = new File(tempDir, filename);
        return ReportManager.getDataSource(file);
    }
    
    public JRXmlDataSource getDataSource(String filename, String recordQuery) throws JRException, IOException {
            return ReportManager.getDataSource(getRealPath(filename), recordQuery);
    }
    
    public JRXmlDataSource getDataSource(String filename) throws JRException, IOException {
        return ReportManager.getDataSource(getRealPath(filename));
    }
    
    public String getReportFilename(String name) {
        return getRealPath("/reports/templates/")+"/"+name;
    }
    
    public String getResultFilename(String name) {
        File tempDir = getTempDirectory();
        return tempDir.getAbsolutePath()+"/"+name;
    }
    
    public void exportDocx(String srcFilename, String destFilename, Map parameter, String dataSource, String recordQuery) throws Exception {
        exportDocx(srcFilename, destFilename, parameter, getTempDataSource(dataSource, recordQuery));
    }
    
    public void exportDocx(String srcFilename, String destFilename, Map parameter, JRXmlDataSource ds) throws Exception {
        ReportManager.exportReportToDocx(getReportFilename(srcFilename), getResultFilename(destFilename), parameter, ds);
    }
    
    public void exportRtf(String srcFilename, String destFilename, Map parameter, String dataSource, String recordQuery) throws Exception {
        exportRtf(srcFilename, destFilename, parameter, getTempDataSource(dataSource, recordQuery));
    }
    
    public void exportRtf(String srcFilename, String destFilename, Map parameter, JRXmlDataSource ds) throws Exception {
        ReportManager.exportReportToRtf(getReportFilename(srcFilename), getResultFilename(destFilename), parameter, ds);
    }
    
    public void exportHtml(String srcFilename, String destFilename, Map parameter, String dataSource, String recordQuery) throws Exception {
        exportHtml(srcFilename, destFilename, parameter, getTempDataSource(dataSource, recordQuery));
    }
    
    public void exportHtml(String srcFilename, String destFilename, Map parameter, JRXmlDataSource ds) throws Exception {
        ReportManager.exportReportToHtml(getReportFilename(srcFilename), getResultFilename(destFilename), parameter, ds);
    }
    
    public String getTempDirectoryPath() {
        String homeDirPath = getRealPath("/")+"/reports/temp/"+sessionId;
        return homeDirPath;
    }
    
    public String getTempFileAbsolutePath(String filename) {
        return getTempDirectoryPath()+"/"+filename;
    }
    
    public File getTempDirectory() {
        String homeDirPath= getTempDirectoryPath();
        File homeDir = new File(homeDirPath);
        if (!homeDir.isDirectory() || !homeDir.exists()) {
            homeDir.mkdirs();
        }
        try {
            File data;
            data = new File(homeDir,"preschool");
            if (!data.exists() || !data.isDirectory()) {
                data.mkdirs();
            }
            data = new File(homeDir,"highschool");
            if (!data.exists() || !data.isDirectory()) {
                data.mkdirs();
            }
            data = new File(homeDir,"middleschool");
            if (!data.exists() || !data.isDirectory()) {
                data.mkdirs();
            }
            data = new File(homeDir,"primaryschool");
            if (!data.exists() || !data.isDirectory()) {
                data.mkdirs();
            }
            data = new File(homeDir, "middleschool/list_of_consultant__nodata.xml");
            if (!data.exists()) {
                data.createNewFile();
                File_Helper.copy(getRealPath("/reports/templates/middleschool/list_of_consultant__nodata.xml"), data);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return homeDir;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        /*
        String [] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String fontName : fontNames) {
            System.err.println(fontName);
        }
         */
        this.request = (HttpServletRequest)request;
        this.response = (HttpServletResponse)response;
        sessionId = this.request.getSession(false).getId();
        printType = this.request.getParameter("printType");
        if (printType == null || !printType.equalsIgnoreCase("print")) {
            printType="prev";
        }
        String uri = this.request.getRequestURI();
        int start = uri.indexOf("/reports/");
        if (start > 0) {
           String filename = uri.substring(start+9);
           if (filename.endsWith(".rpt")) {
               filename = filename.replaceAll(".rpt", "");
               //response.setContentType("text/html;charset=UTF-8");
               process(filename, "html");
               return;
           } else if (filename.endsWith(".html")) {
               filename = filename.replaceAll(".html", "");
               process(filename, "html");
               return;
           } else if (filename.endsWith(".htm")){
               filename = filename.replaceAll(".htm", "");
               process(filename, "html");
               return;
           }else if (filename.endsWith(".docx")){
               filename = filename.replaceAll(".docx", "");
               process(filename, "docx");
               return;
           } else if (filename.endsWith(".rtf")){
               filename = filename.replaceAll(".rtf", "");
               process(filename, "rtf");
               return;
           }
           try {
                filename = getTempDirectoryPath()+"/"+filename;
                File_Helper.copy(new FileInputStream(filename), response.getOutputStream());
            } catch (Exception ex) {
                response.getWriter().println(ex);
            }
        } else {
            chain.doFilter(request, response);
        }
    }
    abstract public void process(String report, String printType);
    
    @Override
    public void destroy() {
        
    }
    
}
