/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action.print;

import kokou.action.DefaultAction;

/**
 *
 * @author master
 */
public class PanelAction extends DefaultAction {
    
    private String report;
    private String type;
    private String frameName;
    
    public String getReport() {
        return this.report;
    }
    public void setReport(String report) {
        this.report = report;
    }
    
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    public String getFrameName() {
        return this.frameName;
    }
    public void setFrameName(String frameName) {
        this.frameName = frameName;
    }
    
    public String execute() {
        getServletRequest().setAttribute("type", getType());
        getServletRequest().setAttribute("report", getReport());
        getServletRequest().setAttribute("frameName", getFrameName());
        return "success";
    }
}
