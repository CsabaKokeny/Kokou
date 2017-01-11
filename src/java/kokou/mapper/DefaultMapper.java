/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.mapper;

import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;

public class DefaultMapper {
    private SqlSession sqlSession = null;
    
    public DefaultMapper(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    
    public SqlSession getSqlSession() {
        return this.sqlSession;
    }
    
    public void closeSqlSession() {
        this.sqlSession.close();
        this.sqlSession = null;
    }
    
    public Map<String, Object> initMap() {
        return new HashMap();
    }
}
