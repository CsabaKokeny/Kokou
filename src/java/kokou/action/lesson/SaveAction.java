/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kokou.action.lesson;

import com.opensymphony.xwork2.ModelDriven;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import kokou.action.DefaultAction;
import kokou.exception.KokouException;
import kokou.mapper.LessonMapper;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author sinjs
 */
public class SaveAction extends DefaultAction implements ModelDriven<SaveAction.Model> {
    
    public final String MESSAGE_SUCCESS="登録されました.";
    public final String MESSAGE_FAIL="失敗しました.";
    
    private Model model = null;
    
    public static class Model extends kokou.model.Lesson {
        private SqlSession sqlSession;
        public Model(SqlSession sqlSession) {
            this.sqlSession = sqlSession;
        }
        public Boolean isValid() {
            if (getName().isEmpty()) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        
        public void save() throws Exception {
            if (isValid()) {
                LessonMapper lessonMapper = new LessonMapper(sqlSession);
                lessonMapper.save(this); 
            } else {
                 throw new KokouException();
            }
         }
    }
    
    @XmlRootElement(name="response")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Response {
        @XmlElement(name="success")
        public Boolean success = true;
        @XmlElement(name="error")
        public Integer error;
        @XmlElement(name="msg")
        public String message;
        @XmlElement(name="lessonId")
        public Integer lessonId;
    }
    
    @Override
    public Model getModel() {
        if (this.model == null) {
            this.model = new Model(getSqlSession());
        }
        return this.model;
    }
    
    public void print_success() {
        Response res = new Response();
        res.error = 0;
        res.message = MESSAGE_SUCCESS;
        res.lessonId = getModel().getLessonId();
        print_json(res);
    }
    
    public void print_fail() {
        Response res = new Response();
        res.error = 1;
        res.message = MESSAGE_FAIL;
        print_json(res);
    }
    
    public void execute() {
        try {
            getModel().save();
            getSqlSession().commit();
            closeSqlSession(); 
            print_success();
        } catch (Exception ex) {
            getSqlSession().rollback();
            System.err.println(ex);
            print_fail();
        }
    }
}
