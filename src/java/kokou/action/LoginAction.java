/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import kokou.exception.KokouException;
import kokou.mapper.LoginMapper;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;

/**
 *
 * @author master
 */
public class LoginAction extends DefaultAction {
    
    private String username;
    private String password;
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String execute() {
        return show();
    }
    
    public String show() {
        return "input";
    }
  
    public String login() {
        Integer userId;
        LoginMapper loginMapper = new LoginMapper(getSqlSession());
        try {
            userId = loginMapper.login(getUsername(), getPassword());
            getSession().put("isLogin", Boolean.TRUE);
            closeSqlSession();
            return "success";
        } catch (Exception ex) {
            System.err.println(ex);
        }
        closeSqlSession();
        return "fail";
    }
}
