/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report;

import java.awt.Color;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRLineBox;
import net.sf.jasperreports.engine.JRVariable;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignLine;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.design.JRDesignTextElement;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JRDesignVariable;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.SplitTypeEnum;
import net.sf.jasperreports.engine.util.JRBoxUtil;
import net.sf.jasperreports.engine.util.JRReportUtils;
import net.sf.jasperreports.engine.util.JRXmlUtils;
import net.sf.jasperreports.engine.xml.JRBoxFactory;
import net.sf.jasperreports.engine.xml.JRReportSaxParserFactory;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.xml.JasperDesignFactory;
import org.apache.jasper.servlet.JasperLoader;
import org.springframework.ui.jasperreports.JasperReportsUtils;

/**
 *
 * @author master
 */
public class StudentReportDesign extends AbstractReportDesign{
    
    public StudentReportDesign() throws JRException {
        super();
    }

    @Override
    protected void initQuery() {
        this.setQuery(DesignHelper.createQuery("xPath", "/root/student"));
    }

    @Override
    protected void initFields() throws JRException {
        this.addField(DesignHelper.createField("id", String.class, "id"));
        this.addField(DesignHelper.createField("name", String.class, "name"));
        this.addField(DesignHelper.createField("nameKr", String.class, "nameKr"));
        this.addField(DesignHelper.createField("sex", String.class, "sex"));
        this.addField(DesignHelper.createField("birthdayYear", String.class, "birthday/year"));
        this.addField(DesignHelper.createField("birthdayMonth", String.class, "birthday/month"));
        this.addField(DesignHelper.createField("birthdayDay", String.class, "birthday/day"));
        this.addField(DesignHelper.createField("phoneNo", String.class, "phoneNo"));
        this.addField(DesignHelper.createField("address", String.class, "address"));
        this.addField(DesignHelper.createField("residence", String.class, "residence"));
    }

    @Override
    protected void initVariables() throws JRException {
        this.addVariable(DesignHelper.createVariable("NO", Integer.class, "0", "$V{NO}+1"));
        this.addVariable(DesignHelper.createVariable("__SEX", String.class, null, "$F{sex}==null?\"\":$F{sex}.trim()"));
        this.addVariable(DesignHelper.createVariable("_SEX", String.class, null, "$V{__SEX}.isEmpty()?\"\":$V{__SEX}.substring(0,1)"));
        this.addVariable(DesignHelper.createVariable("SEX", String.class, null, "$V{_SEX}.equals(\"m\")?\"男\":$V{_SEX}.equals(\"w\")?\"女\":$V{_SEX}"));
    }
    
    @Override
    protected void initColumnHeader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void initDetails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
