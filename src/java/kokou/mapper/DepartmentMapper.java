/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.mapper;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author master
 */
public class DepartmentMapper extends DefaultMapper {
    public String namespace = "kokou.mapper.DepartmentMapper.";

    public DepartmentMapper(SqlSession sqlSession) {
        super(sqlSession);
    }
    
    public void getAll(ResultHandler handler) {
        getSqlSession().select(namespace+"getList", handler);
    }
    
    public void getAll(Object params, ResultHandler handler) {
        if(params != null) {
            getSqlSession().select(namespace+"getList", params, handler);
        } else {
            getSqlSession().select(namespace+"getList", handler);
        }
    }
}
