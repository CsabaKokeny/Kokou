/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action.phone_type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import kokou.action.DefaultAction;
import kokou.mapper.PhoneTypeMapper;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

/**
 *
 * @author master
 */
public class ListAction extends DefaultAction {
    
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Phone_type {
        @XmlElement(name="code")
        public String code;
        @XmlElement(name="label")
        public String label;
    }
    
    @XmlRootElement(name="response")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Response {
        @XmlElement(name="data")
        public List<Phone_type> dataList;
        @XmlElement(name="success")
        public Boolean success;
    }
    
    public void execute() {
        PhoneTypeMapper mapper = new PhoneTypeMapper(getSqlSession());
        final Response res = new Response();
        res.success = true;
        res.dataList = new ArrayList();
        mapper.getAll(new ResultHandler() {
            @Override
            public void handleResult(ResultContext rc) {
                if (rc != null) {
                    Map<?,?> row = (Map<?,?>)rc.getResultObject();
                    if (row != null) {
                        Phone_type item = new Phone_type();
                        item.code = (String)row.get("code");
                        item.label = (String)row.get("name");
                        res.dataList.add(item);
                    }
                }
            }
        });
        print_json(res);
        closeSqlSession();
    }
    
}
