/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action.classgroup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import kokou.action.DefaultAction;
import kokou.mapper.ClassMapper;
import kokou.model.ClassGroup;
/**
 *
 * @author master
 */
public class DetailAction extends DefaultAction {
    
    private Integer classId;
    public Integer getClassId() {
        return classId;
    }
    public void setClassId(Integer classId) {
        this.classId = classId;
    }
    
    @XmlRootElement(name="response")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Response {
        @XmlElement(name="data")
        public ClassGroup data;
        @XmlElement(name="success")
        public Boolean success;
    }
    
    public void execute() {
        final Response res = new Response();
        res.success = true;
        ClassMapper classMapper = new ClassMapper(getSqlSession());
        res.data = classMapper.getOneById(getClassId());
        closeSqlSession();
        print_json(res);
    }
}
