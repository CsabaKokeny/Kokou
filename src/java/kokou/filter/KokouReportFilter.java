/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import jaxb.Jaxb_helper;
import kokou.mapper.v2.ReportMapper;
import kokou.model.v2.Student;
import my.helper.File_Helper;
import my.mybatis.MybatisFactory;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignImage;
import net.sf.jasperreports.engine.design.JRDesignSection;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JasperDesignFactory;
import org.apache.ibatis.session.SqlSession;
/**
 *
 * @author master
 */
public class KokouReportFilter extends ReportFilter{

    
    
    @XmlRootElement(name="root")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Report {
        
        @XmlElement(name="student")
        public List<Student> studentList;
    }
    
    @Override
    public void process(String report, String printType) {
        try {
            Map params = new HashMap();  
            String query =null;
            
            String schoolKind = this.request.getParameter("schoolKind");
            String schoolYear = this.request.getParameter("schoolYear");
            String className = this.request.getParameter("className");
            
            String year = this.request.getParameter("year");
            String month = this.request.getParameter("month");
            String day = this.request.getParameter("day");
            
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Integer.valueOf(year));
            calendar.set(Calendar.MONTH, Integer.valueOf(month)-1);
            calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));
            
            Boolean data = Boolean.valueOf(this.request.getParameter("data"));
            
            String dataFilename = report+".xml";
            
            if (report.endsWith("_nodata")) {
                data = false;
            } else {
                String dataAbsoluteFilename = getResultFilename(dataFilename);
                File dataFile = new File(dataAbsoluteFilename);
                if (!dataFile.exists() || dataFile.isDirectory()) {
                    data = true;
                }
            }
            if (data) {
                SqlSession sqlSession = null;
                try {
                    sqlSession = MybatisFactory.openSqlSession();
                } catch (Exception ex) {
                    System.err.println(ex);
                }
                if (schoolKind != null) {
                    schoolKind = schoolKind.trim();
                    if (schoolKind.isEmpty()) schoolKind = null;
                }
                if (schoolYear != null) {
                    schoolYear = schoolYear.trim();
                    if (schoolYear.isEmpty()) schoolYear = null;
                }
                if (className != null){
                    className = className.trim();
                    if (className.isEmpty()) className = null;
                }
                if (schoolKind != null) {
                    params.put("schoolKind", schoolKind);
                }
                if (schoolYear != null) {
                    params.put("schoolYear", schoolYear);
                }
                if (className != null) {
                    params.put("className", className);
                }
                Report reportObj = new Report();
                List<Student> results = null;
                if (report.startsWith("preschool")) {
                    try {
                        ReportMapper mapper =new ReportMapper(sqlSession);
                        results= mapper.findForPreschool(params);
                    } catch (Exception ex) {
                        System.err.println(ex);
                    }
                } else {
                    try {
                        ReportMapper mapper =new ReportMapper(sqlSession);
                        if (report.endsWith("_double")) {
                            results = mapper.find(params);
                        } else {
                            results= mapper.findForPreschool(params);
                        }
                    } catch (Exception ex) {
                        System.err.println(ex);
                    }
                }
                if (results == null) {
                    results = new ArrayList();
                }
                reportObj.studentList = results;
                params.clear();
                try {
                    if (sqlSession != null) {
                        sqlSession.close();
                    }
                } catch (Exception ex) {
                    System.err.println(ex);
                }
                FileOutputStream output = null;
                try {
                    output = new FileOutputStream(getResultFilename(dataFilename));
                    Jaxb_helper.marshal(true, reportObj, output);
                } catch (FileNotFoundException ex)  {
                    System.err.println(ex);
                }
                try {
                    if (output!=null) {
                        output.close();
                    }
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
            
            if (report.startsWith("preschool")) {
                query ="/root/student";
            } else if (report.startsWith("primaryschool")) {
                query ="/root/student";
            } else if (report.startsWith("middleschool")) {
                if (report.endsWith("list_of_consultant__nodata")) {
                    query = "/root/record";
                } else if (report.contains("time_table")) {
                    
                } else {
                    query ="/root/student";
                }
            } else if (report.startsWith("highschool")) {
                query ="/root/student";
            }
            
            String[] weekdays= new String[]{"日","月","火","水","木","金","土"};
            
            if (report.startsWith("preschool")) {
                
                if (report.endsWith("list_of_presence_in_term") || report.endsWith("list_of_check_in_term")) {
                    List<String> dateList = new ArrayList();
                    for(int i=0;i<12;i++) {
                        dateList.add(String.format("%1$tm/%1$td",calendar)+"\n"+weekdays[calendar.get(Calendar.DAY_OF_WEEK)-1]);
                        calendar.add(Calendar.DATE, 1);
                    }
                    params.put("dateList", dateList);
                    params.put("currentDate", year);
                }
                
            } else if (report.startsWith("primaryschool")) {
                 if (report.endsWith("list_of_presence_in_term") || report.endsWith("list_of_check_in_term")) {
                    List<String> dateList = new ArrayList();
                    for(int i=0;i<12;i++) {
                        dateList.add(String.format("%1$tm/%1$td",calendar)+"\n"+weekdays[calendar.get(Calendar.DAY_OF_WEEK)-1]);
                        calendar.add(Calendar.DATE, 1);
                    }
                    params.put("dateList", dateList);
                    params.put("currentDate", year);
                }
                
            } else if (report.startsWith("middleschool")) {
                
                if (report.endsWith("list_of_consultant__nodata")) {
                    int roll= -(calendar.get(Calendar.DAY_OF_WEEK) - Calendar.FRIDAY>=0?calendar.get(Calendar.DAY_OF_WEEK) - Calendar.FRIDAY:calendar.get(Calendar.DAY_OF_WEEK) - Calendar.FRIDAY+7);
                    calendar.add(Calendar.DATE, roll);
                    
                    List<String> dateList = new ArrayList();
                    List<String> weekdayList = new ArrayList();        
                    for (int i=0;i<7;i++) {
                        dateList.add(String.valueOf(calendar.get(Calendar.MONTH)+1)+"月 "+String.valueOf(calendar.get(Calendar.DATE)+"日"));
                        weekdayList.add(weekdays[calendar.get(Calendar.DAY_OF_WEEK)-1]);
                        calendar.add(Calendar.DATE, 1);
                    }
                    params.put("KOKOU_WEEKDAY", weekdayList);
                    params.put("KOKOU_DAY", dateList);
                }
                
            } else if (report.startsWith("highschool")) {
                
            }
            
            params.put("KOKOU_GRADUATE_DATE", year+"年 "+month+"月 "+day+"日 ");
            params.put("KOKOU_YEAR", year);
            
            if (printType.equalsIgnoreCase("docx")) {
                printDocx(report, params, dataFilename, query);
            } else if (printType.equalsIgnoreCase("html")) {
                printHtml(report, params, dataFilename, query);
            } else if (printType.equalsIgnoreCase("rtf")) {
                printRtf(report, params, dataFilename, query);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
}
