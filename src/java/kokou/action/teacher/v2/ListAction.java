/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action.teacher.v2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import kokou.action.DefaultAction;
import kokou.mapper.v2.TeacherMapper;
import kokou.model.v2.Teacher;

/**
 *
 * @author master
 */
public class ListAction extends DefaultAction {
    
    private String schoolKind;
    public String getSchoolKind() {
        return schoolKind;
    }
    public void setSchoolKind(String schoolKind) {
        this.schoolKind = schoolKind;
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
        public List<Teacher> data;
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
            TeacherMapper teacherMapper = new TeacherMapper(getSqlSession());
            Map<String, Object> params = new HashMap();
            res.data = teacherMapper.find(params, getStart(), getLimit());
            res.total = teacherMapper.getCount(params);
        } catch (Exception ex) {
            System.err.println(ex);
        }
        closeSqlSession();
        getServletResponse().setCharacterEncoding("UTF-8");
        print_json(res);
    }
}
