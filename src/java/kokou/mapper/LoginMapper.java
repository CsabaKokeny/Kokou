/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.mapper;

import java.util.HashMap;
import java.util.Map;
import kokou.exception.KokouException;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author master
 */
public class LoginMapper extends DefaultMapper{
    
    public String namespace = "kokou.mapper.LoginMapper.";

    public LoginMapper(SqlSession sqlSession) {
        super(sqlSession);
    }
    
    public Integer login (String username, String password) throws KokouException {
        SqlSession sqlSession = null;
        Map<String, Object> params;
        Integer userId = null;
        if (username == null) {
            throw new KokouException();
        }
        if (username.isEmpty()) {
            throw new KokouException();
        } else {
            username = username.trim();
            if (username.isEmpty()) {
                throw new KokouException();
            }
        }
        if (password == null) {
            password = "";
        }
        try {
            sqlSession = getSqlSession();
            params = new HashMap();
            params.put("userName", username);
            params.put("userPassword", password);
            userId = Integer.valueOf((String)sqlSession.selectOne(namespace + "login",params));
        } catch (NumberFormatException ex) {
            System.err.println(ex);
        }
        if (userId == null) {
            throw new KokouException();
        }
        return userId;
    }
    
    public Boolean isUserInOffice(String userId) {
        return Boolean.TRUE;
    }
    
    public Boolean isUserInPreSchool(String userId) {
        return Boolean.TRUE;
    }
    
    public Boolean isUserInPrimarySchool(String userId) {
        return Boolean.TRUE;
    }
    
    public Boolean isUserInMiddleSchool(String userId) {
        return Boolean.TRUE;
    }
    
    public Boolean isUserInHighSchool(String userId) {
        return Boolean.TRUE;
    }
}
