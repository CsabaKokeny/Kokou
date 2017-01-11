/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action.student.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import jaxb.Jaxb_helper;
import json.JSON_helper;
import kokou.action.DefaultAction;
import kokou.mapper.v2.StudentMapper;
import kokou.model.v2.Student;

/**
 *
 * @author master
 */
public class SaveAction extends DefaultAction {
    
    String func;
    public String getFunc() {
        return this.func;
    }
    public void setFunc(String func) {
        this.func = func;
    }
    
    Integer studentId;
    public Integer getStudentId() {
        return this.studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    
    String schoolYear;
    public String getSchoolYear() {
        return this.schoolYear;
    }
    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }
    
    String className;
    public String getClassName() {
        return this.className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    
    @XmlRootElement(name="request")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Request {
        @XmlElement(name="student")
        public Student student=new Student();
    }
    
    @XmlRootElement(name="response")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Response{
        @XmlElement(name="success")
        public boolean success;
        @XmlElement(name="student")
        public Student student;
        @XmlElement(name="errorNo")
        public int errorNo;
        @XmlElement(name="message")
        public String message;
    }
    
    public void saveClass() {
        try {
            StudentMapper mapper = new StudentMapper(getSqlSession());
            if (studentId != null) {
                if (studentId > 0) {
                    mapper.insertClass(studentId, schoolYear, className);
                    getSqlSession().commit();
                }
            }
        } catch (Exception ex) {
            getSqlSession().rollback();
            System.out.println(ex);
        }
        closeSqlSession(); 
    }
            
    public void execute() {
        if ("class".equals(this.getFunc())) {
            this.saveClass();
            return;
        }
        Request request;
        Response response = new Response();
        Student student;
        try {
            request = (Request)Jaxb_helper.unmarshal(getServletRequest().getInputStream(), Request.class);
            student = request.student;
            StudentMapper mapper = new StudentMapper(getSqlSession());
            if (mapper.checkDuplicating(student)) {
                response.success = false;
                response.errorNo = 100;
                response.message = "登録が失敗しました.<br/>学籍番号が重複されます.";
            } else {
                if(student.getId()!=null && student.getId()>0) {
                    mapper.update(student);
                } else {
                    mapper.insert(student);
                }
                getSqlSession().commit();
                response.success = true;
                response.student = mapper.getOneById(student.getId());
            }
            JSON_helper.marshal(getServletResponse().getOutputStream(), response);
        } catch (Exception ex) {
            getSqlSession().rollback();
            System.err.println(ex);
        }
        closeSqlSession(); 
    }
}
