/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action.lesson;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import kokou.action.DefaultAction;
import kokou.mapper.LessonMapper;
import kokou.model.Lesson;
/**
 *
 * @author master
 */
public class DetailAction extends DefaultAction {
    
    private Integer lessonId;
    public Integer getLessonId() {
        return lessonId;
    }
    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }
    
    @XmlRootElement(name="response")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Response {
        @XmlElement(name="data")
        public Lesson data;
        @XmlElement(name="success")
        public Boolean success;
    }
    
    public void execute() {
        final Response res = new Response();
        res.success = true;
        LessonMapper lessonMapper = new LessonMapper(getSqlSession());
        res.data = lessonMapper.getOneById(getLessonId());
        closeSqlSession();
        print_json(res);
    }
}
