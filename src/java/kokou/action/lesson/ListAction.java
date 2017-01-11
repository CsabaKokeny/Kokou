/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kokou.action.lesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import kokou.action.DefaultAction;
import kokou.mapper.LessonMapper;
import kokou.model.Lesson;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

/**
 *
 * @author sinjs
 */
public class ListAction extends DefaultAction {
    
    @XmlRootElement(name="response")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Response {
        @XmlElement(name="data")
        public List<Lesson> lessonList;
        @XmlElement(name="success")
        public Boolean success;
    }
    
    public void execute() {
        final Response res = new Response();
        res.success = true;
        res.lessonList = new ArrayList<>();
        Map<String, Object> params = this.initMap();
        try {
            final LessonMapper lessonMapper = new LessonMapper(getSqlSession());
            lessonMapper.getList(params, new ResultHandler() {
                @Override
                public void handleResult(ResultContext rc) {
                    Map<?,?> row = (Map<?,?>)rc.getResultObject();
                    try {
                        Lesson item = lessonMapper.toEntity(row);
                        if (item != null) {
                            res.lessonList.add(item);
                        }
                    } catch (Exception ex) {
                        System.err.println(ex);
                    }
                }
            } );
        } catch (Exception ex) {
            System.err.println(ex);
        }
        closeSqlSession();
        print_json(res);
    }
    
}
