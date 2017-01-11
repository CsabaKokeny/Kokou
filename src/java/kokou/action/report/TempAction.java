/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action.report;

import java.io.IOException;
import jaxb.Jaxb_helper;
import org.apache.struts2.ServletActionContext;
import org.eclipse.jdt.internal.compiler.util.Util;

/**
 *
 * @author master
 */
public class TempAction {
    public void execute() {
        /*JasperDesign p = new JasperDesign();
        try {
            Jaxb_helper.marshal(true, p, ServletActionContext.getResponse().getOutputStream());
            System.err.flush();
        } catch (Exception ex) {
            System.err.println(ex);
        }*/
        /*
        try {
            InputStream is = Resources.getResourceAsStream("kokou/report/xml/preschool/list_for_primary_school.jrxml");
            JasperDesign design = JRXmlLoader.load(is);
            net.sf.jasperreports.engine.JasperReport report = JasperCompileManager.compileReport(design);
            //ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
            //ServletActionContext.getResponse().setContentType("binary");
            ServletActionContext.getResponse().setContentType("application/binary");
            ServletActionContext.getResponse().addHeader("Content-Disposition", "inline; filename=\"result.pdf\"");
            //Writer writer = ServletActionContext.getResponse().getWriter();
            JasperReportsUtils.renderAsPdf(report, null, ReportManager.getDataSource("D:\\projects\\Kokou\\src\\server\\reports\\data.xml", "/root/student"), ServletActionContext.getResponse().getOutputStream());
        } catch (IOException | JRException ex) {
           System.err.println(ex);
        }*/
        try {
            kokou.report.primaryschool.StudyTest_Report p = new kokou.report.primaryschool.StudyTest_Report();
            Jaxb_helper.marshal( true, p.getJasperReport(), ServletActionContext.getResponse().getOutputStream());
        } catch (Exception ex) {
            try {
                ServletActionContext.getResponse().getWriter().println(ex);
            } catch (Exception ex1){}
        }
    }
}
