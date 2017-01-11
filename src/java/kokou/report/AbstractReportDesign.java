/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRSection;
import net.sf.jasperreports.engine.design.JRDesignSection;
import net.sf.jasperreports.engine.design.JasperDesign;

/**
 *
 * @author master
 */
abstract public class AbstractReportDesign extends JasperDesign {
    
    public AbstractReportDesign() throws JRException {
        super();
        //A4
        this.setPageHeight(842);
        this.setPageWidth(595);
        this.init();
    }
    
    private void init() throws JRException {
        this.initParmeters();
        this.initQuery();
        this.initFields();
        this.initSortFields();
        this.initVariables();
        this.initFilters();
        this.initBackground();
        this.initTitle();
        this.initPageHeader();
        this.initColumnHeader();
        this.initDetails();
        this.initColumnFooter();
        this.initPageFooter();
        this.initLastPageFooter();
        this.initSummary();
        this.initNoData();
    }
    
    protected void initParmeters() {
        
    }
    
    abstract protected void initQuery();
    
    abstract protected void initFields() throws JRException ;
    
    protected void initSortFields() {
        
    }
    
    protected void initVariables() throws JRException{
        
    }
    
    protected void initFilters() {
        
    }
    
    protected void initBackground() {
        
    }
    
    protected void initTitle() {
        
    }
    
    protected void initPageHeader() {
        
    }
    
    abstract protected void initColumnHeader();
    
    abstract protected void initDetails();
    
    protected void initColumnFooter() {
        
    }
    
    protected void initPageFooter() {
        
    }
    
    protected void initLastPageFooter() {
        
    }
    
    protected void initSummary() {
        
    }
    
    protected void initNoData() {
        
    }
    
    @Override
    public JRDesignSection getDetailSection() {
        JRSection section = super.getDetailSection();
        return (JRDesignSection)section;
    }
    
}
