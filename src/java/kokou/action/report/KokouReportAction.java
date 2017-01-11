/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action.report;

/**
 *
 * @author master
 */
public class KokouReportAction extends ReportAction {

    @Override
    public void preview() throws Exception {        
        exportHtml("preschool/roll_of_class_with_PTAEmployee.jasper", "preschool/roll_of_class_with_PTAEmployee.html", null, "data.xml", "/root/student");
    }

    @Override
    public void print() throws Exception{
    }
    
}
