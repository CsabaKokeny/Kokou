/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action.report.preschool;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import kokou.filter.ReportManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.ibatis.io.Resources;
import org.apache.struts2.ServletActionContext;
import org.springframework.ui.jasperreports.JasperReportsUtils;

/**
 *
 * @author master
 */
public class ReportAction_ListForPrimarySchool {
    
    public void execute() {
        try {
            InputStream is = Resources.getResourceAsStream("kokou/report/xml/preschool/list_for_primary_school.jrxml");
            JasperDesign design = JRXmlLoader.load(is);
            JasperReport report = JasperCompileManager.compileReport(design);
            Writer writer = ServletActionContext.getResponse().getWriter();
            JasperReportsUtils.renderAsHtml(report, null, ReportManager.getDataSource("D:\\projects\\Kokou\\src\\server\\reports\\data.xml"), writer);
        } catch (IOException | JRException ex) {
            
        }
    }
    
}
