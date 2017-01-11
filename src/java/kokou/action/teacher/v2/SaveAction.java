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
import jaxb.Jaxb_helper;
import json.JSON_helper;
import kokou.action.DefaultAction;
import kokou.mapper.v2.TeacherMapper;
import kokou.model.v2.Teacher;

/**
 *
 * @author master
 */
public class SaveAction extends DefaultAction {
    @XmlRootElement(name="request")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Request {
        @XmlElement(name="teacher")
        public Teacher teacher=new Teacher();
    }
    
    @XmlRootElement(name="response")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Response{
        @XmlElement(name="success")
        public boolean success;
        @XmlElement(name="teacher")
        public Teacher teacher;
        @XmlElement(name="errorNo")
        public int errorNo;
        @XmlElement(name="message")
        public String message;
    }
    
    public void execute() {
        Request request;
        Response response = new Response();
        Teacher teacher;
        try {
            request = (Request)Jaxb_helper.unmarshal(getServletRequest().getInputStream(), Request.class);
            teacher = request.teacher;
            TeacherMapper mapper = new TeacherMapper(getSqlSession());
            
            //if (mapper.checkDuplicating(student)) {
            //    response.success = false;
            //    response.errorNo = 100;
             //   response.message = "登録が失敗しました.<br/>学籍番号が重複されます.";
            //} else {
                if(teacher.getId()!=null && teacher.getId()>0) {
                    mapper.update(teacher);
                } else {
                    mapper.insert(teacher);
                }
                getSqlSession().commit();
                response.success = true;
                response.teacher = mapper.getOneById(teacher.getId());
            //}
            JSON_helper.marshal(getServletResponse().getOutputStream(), response);
        } catch (Exception ex) {
            getSqlSession().rollback();
            System.err.println(ex);
        }
        closeSqlSession(); 
    }
}
