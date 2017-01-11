/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.mapper;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import kokou.exception.KokouException;
import kokou.model.User;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author master
 */
public class UserMapper extends DefaultMapper {
    
    public String namespace = "kokou.mapper.UserMapper.";

    public UserMapper(SqlSession sqlSession) {
        super(sqlSession);
    }
    
    public Boolean isDuplicated(String userName) {
        if (userName == null) {
            userName = "";
        } else {
            userName = userName.trim();
        }
        if (userName.isEmpty()) {
            return Boolean.TRUE;
        }
        Map<String, Object> params = initMap();
        params.put("userName", userName);
        if (getSqlSession().selectOne(namespace+"isDuplicated", params) == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    
    public Boolean isTeacherExisted(Integer teacherId) {
        if (teacherId == null) {
            return Boolean.TRUE;
        }
        Map<String, Object> params = initMap();
        params.put("teacherId", teacherId);
        if (getSqlSession().selectOne(namespace+"isTeacherExisted", params) == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    
    public void insert(User entity) throws Exception {
        Integer userId = insert(entity.getUsername(), entity.getPassword(), entity.getTeacherId());
        entity.setUserId(userId);
    }
    
    public Integer insert(String username, String password, Integer teacherId) throws Exception {
        Date current = Calendar.getInstance().getTime();
        if (isDuplicated(username)) {
            throw new KokouException();
        }
        Map<String,Object> params = initMap();
        params.put("userName", username);
        params.put("userPassword", password);
        params.put("createTime", current);
        params.put("updateTime", current);
        params.put("teacherId", teacherId);
        params.put("timestamp", current.getTime());
        getSqlSession().insert(namespace+"insert", params);
        try {
            return Integer.valueOf(getSqlSession().selectOne(namespace+"getIdByTimestamp", params).toString());
        } catch (NumberFormatException ex) {
            System.err.println(ex);
        }
        throw new KokouException();
    }
    
    public Integer update(User entity) throws Exception {
        return update(entity.getUserId(), entity.getUsername(), entity.getPassword());
    }
            
    public Integer update(Integer userId, String username, String password) throws Exception {
        Date current = Calendar.getInstance().getTime();
        Map<String,Object> params = initMap();
        params.put("userId", userId);
        params.put("userName", username);
        params.put("userPassword", password);
        params.put("updateTime", current);
        return getSqlSession().update(namespace+"update", params);
    }
    
    
}
