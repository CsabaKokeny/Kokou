/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.mapper.v2;

import java.util.List;
import java.util.Map;
import kokou.mapper.DefaultMapper;
import kokou.model.v2.Student;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author master
 */
public class ReportMapper extends DefaultMapper {
    
    String namespace = "kokou.mapper.v2.StudentMapper.";
    
    public ReportMapper(SqlSession sqlSession) {
        super(sqlSession);
    }
    
    public List<Student> findForPreschool(Map params) {
        List<kokou.model.v2.Student> list = getSqlSession().selectList(namespace+"find", params);
        return list;
    }
    
    public List<Student> find(Map params) {
        StudentMapper studentMapper = new StudentMapper(getSqlSession());
        List<kokou.model.v2.Student> list = studentMapper.find_2Col(params);
        return list;
    }
}
