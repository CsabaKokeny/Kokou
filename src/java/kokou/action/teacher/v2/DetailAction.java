/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action.teacher.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import kokou.action.DefaultAction;
import kokou.mapper.v2.TeacherMapper;
import kokou.model.v2.Student;
import kokou.model.v2.Teacher;

/**
 *
 * @author master
 */
public class DetailAction extends DefaultAction {
    
    private Integer teacherId;
    public Integer getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
    
    @XmlRootElement(name="response")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Response {
        @XmlElement(name="data")
        public Teacher data;
        @XmlElement(name="success")
        public Boolean success;
    }
    
    public void execute() {
        final Response res = new Response();
        res.success = true;
        TeacherMapper teacherMapper = new TeacherMapper(getSqlSession());
        res.data = teacherMapper.getOneById(getTeacherId());
        closeSqlSession();
        getServletResponse().setCharacterEncoding("UTF-8");
        print_json(res);
    }
}
