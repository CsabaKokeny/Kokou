/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action.student.v2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import kokou.action.DefaultAction;
import kokou.mapper.v2.StudentMapper;
import kokou.model.v2.Student;

/**
 *
 * @author master
 */
public class ListAction extends DefaultAction {
    
    private String schoolKind;
    public String getSchoolKind() {
         if (this.schoolKind!=null && this.schoolKind.trim().isEmpty()) {
            this.schoolKind = null;
        }
        return this.schoolKind;
    }
    public void setSchoolKind(String schoolKind) {
        this.schoolKind = schoolKind;
    }
    
    private String enterSchoolKind;
    public String getEnterSchoolKind() {
        if (this.enterSchoolKind!=null && this.enterSchoolKind.trim().isEmpty()) {
            this.enterSchoolKind = null;
        }
        return this.enterSchoolKind;
    }
    public void setEnterSchoolKind(String enterSchoolKind) {
        this.enterSchoolKind = enterSchoolKind;
    }
    
    private String enterYear;
    public String getEnterYear() {
        if (this.enterYear!=null && this.enterYear.trim().isEmpty()) {
            this.enterYear = null;
        }
        return enterYear;
    }
    public void setEnterYear(String enterYear) {
        this.enterYear = enterYear;
    }
    
    private String schoolYear;
    public String getSchoolYear() {
        if (this.schoolYear!=null && this.schoolYear.trim().isEmpty()) {
            this.schoolYear = null;
        }
        return schoolYear;
    }
    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }
    
    private String className;
    public String getClassName() {
        if (this.className!=null && this.className.trim().isEmpty()) {
            this.className = null;
        }
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    
    private Integer page;
    public Integer getPage() {
        return this.page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    
    private Integer start;
    public Integer getStart() {
        if (start == null) {
            start = 0;
        }
        return this.start;
    }
    public void setStart(Integer start) {
        this.start = start;
    }
    
    private Integer limit;
    public Integer getLimit() {
        if (limit == null) {
            limit = 25;
        }
        return this.limit;
    }
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    
    @XmlRootElement(name="response")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Response {
        @XmlElement(name="data")
        public List<Student> data;
        @XmlElement(name="success")
        public Boolean success;
        @XmlElement(name="total")
        public Integer total;
        @XmlElement(name="page")
        public Integer page;
        @XmlElement(name="start")
        public Integer start;
        @XmlElement(name="limit")
        public Integer limit;
    }
    
    public void execute() {
        final Response res = new Response();
        res.success = true;
        try {
            StudentMapper studentMapper = new StudentMapper(getSqlSession());
            Map<String, Object> params = new HashMap();
            if (getSchoolKind() != null) {
                params.put("schoolKind", getSchoolKind());
            }
            if (getEnterYear() != null) {
                params.put("enterYear", getEnterYear());
            }
            if (getEnterSchoolKind()!= null) {
                params.put("enterSchoolKind", getEnterSchoolKind());
            }
            if (getSchoolYear() != null) {
                params.put("schoolYear", getSchoolYear());
            }
            if (getClassName() != null) {
                params.put("className", getClassName());
            }
            res.data = studentMapper.find(params, getStart(), getLimit());
            res.total = studentMapper.getCount(params);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        closeSqlSession();
        getServletResponse().setCharacterEncoding("UTF-8");
        print_json(res);
    }
}
