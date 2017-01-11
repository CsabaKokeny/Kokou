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
import kokou.action.DefaultAction;
import kokou.mapper.v2.StudentMapper;
import kokou.model.v2.Student;

/**
 *
 * @author master
 */
public class DetailAction extends DefaultAction {
    
    private Integer studentId;
    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    
    @XmlRootElement(name="response")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Response {
        @XmlElement(name="data")
        public Student data;
        @XmlElement(name="success")
        public Boolean success;
    }
    
    public void execute() {
        final Response res = new Response();
        res.success = true;
        StudentMapper studentMapper = new StudentMapper(getSqlSession());
        res.data = studentMapper.getOneById(getStudentId());
        closeSqlSession();
        getServletResponse().setCharacterEncoding("UTF-8");
        print_json(res);
    }
}
