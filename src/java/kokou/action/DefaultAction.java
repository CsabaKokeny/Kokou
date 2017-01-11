/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action;

import com.opensymphony.xwork2.ActionContext;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import json.JSON_helper;
import my.mybatis.MybatisFactory;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

/**
 *
 * @author master
 */
public class DefaultAction implements ServletContextAware, ServletRequestAware, ServletResponseAware, SessionAware {
    
    protected HttpServletRequest httpRequest = null;
    protected HttpServletResponse httpResponse = null;
    protected ServletContext servletContext = null;
    protected Map<String, Object> sessionMap = null;
    protected SqlSession sqlSession = null;
    
    public String getRealPath(String path) {
        return getServletContext().getRealPath(path);
    }
    
    public String getSessioId() {
        return getServletRequest().getSession(false).getId();
    }
    
    public ServletContext getServletContext() {
        if (servletContext == null) {
            servletContext = ServletActionContext.getServletContext();
        }
        return servletContext;
    }
	
    public HttpServletRequest getServletRequest() {
        if (httpRequest == null) {
            httpRequest = ServletActionContext.getRequest();
        }
        return httpRequest;
    }
	
    public HttpServletResponse getServletResponse() {
        if (httpResponse == null) {
            httpResponse = ServletActionContext.getResponse(); 
        }
        return httpResponse;
    }
	
    public Map<String,Object> getSession() {
        if (sessionMap == null) {
            sessionMap = ServletActionContext.getContext().getSession();
        }
        return sessionMap;
    }

    @Override
    public void setServletContext(ServletContext sc) {
        this.servletContext = sc;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.httpRequest = hsr;
    }

    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        this.httpResponse = hsr;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap = map;
    }
    
    public Boolean isLogin() {
        Boolean bLogin = (Boolean)getSession().get("isLogin");
        return bLogin != null &&  bLogin.equals(Boolean.TRUE);
    }
    
    public SqlSession getSqlSession() {
        if (sqlSession == null) {
            sqlSession = MybatisFactory.openSqlSession();
        }
        return sqlSession;
    }
    
    public void closeSqlSession() {
        if (sqlSession != null) {
            try {
                sqlSession.close();
            } catch (Exception ex) {
                System.err.println(ex);
            }
            sqlSession = null;
        }
    }
    
    public void print_json(Object obj) {
        try {
            getServletResponse().setContentType("text/json");
            JSON_helper.marshal(getServletResponse().getOutputStream(), obj);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    public Map<String, Object> initMap() {
        return new HashMap();
    }
}
