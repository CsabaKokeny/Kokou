/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kokou.action.classgroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import kokou.action.DefaultAction;
import kokou.mapper.ClassMapper;
import kokou.model.ClassGroup;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

/**
 *
 * @author sinjs
 */
public class ListAction extends DefaultAction {
    
    private String classId;
    private String schoolKind;
    private String schoolYear;
    
    public String getClassId() {
        return this.classId;
    }
    public void setClassId(String classId) {
        this.classId = classId;
    }
    public String getSchoolKind() {
        return this.schoolKind;
    }
    public void setSchoolKind(String schoolKind) {
        this.schoolKind = schoolKind;
    }
    public String getSchoolYear() {
        return this.schoolYear;
    }
    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }
    
    @XmlRootElement(name="response")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Response {
        @XmlElement(name="data")
        public List<ClassGroup> groupList;
        @XmlElement(name="success")
        public Boolean success;
    }
    
    public void execute() {
        final Response res = new Response();
        res.success = true;
        res.groupList = new ArrayList<>();
        Map<String, Object> params = this.initMap();
        params.put("classId", this.getClassId());
        params.put("schoolYear", this.getSchoolYear());
        params.put("schoolKind", this.getSchoolKind());
        try {
            final ClassMapper classMapper = new ClassMapper(getSqlSession());
            classMapper.getList(params, new ResultHandler() {
                @Override
                public void handleResult(ResultContext rc) {
                    Map<?,?> row = (Map<?,?>)rc.getResultObject();
                    try {
                        ClassGroup item = classMapper.toEntity(row);
                        if (item != null) {
                            res.groupList.add(item);
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
