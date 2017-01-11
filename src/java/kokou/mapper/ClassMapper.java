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
import kokou.model.ClassGroup;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author master
 */
public class ClassMapper extends DefaultMapper {
    public String namespace = "kokou.mapper.ClassMapper.";

    public ClassMapper(SqlSession sqlSession) {
        super(sqlSession);
    }
    
    public ClassGroup toEntity(Map row) {
        ClassGroup entity = null;
        if (row != null) {
            entity = new ClassGroup();
            entity.setId(Integer.valueOf(row.get("classId").toString()));
            entity.setName((String)row.get("name"));
            entity.setNameen((String)row.get("nameen"));
            entity.setNamekr((String)row.get("namekr"));
            entity.setDepartment((String)row.get("department"));
            entity.setDepartmentLabel((String)row.get("departmentLabel"));
            entity.setLevel((Integer)row.get("level"));
        }
        return entity;
        
    }
    
    public void getList(Object params, ResultHandler handler) {
        getSqlSession().select(namespace+"getList", params, handler);
    }
    
    public ClassGroup getOneById(Integer classId) {
        if (classId == null) {
            return null;
        }
        ClassGroup  entity = null;
        Map<String,Object> params = initMap();
        params.put("classId", classId);
        Map<?,?> row = (Map<?,?>)getSqlSession().selectOne(namespace+"getList", params);
        entity = toEntity(row);
        return entity;
    }
    
    public void insert(ClassGroup entity) throws Exception {
        Integer classId = insert(entity.getName(), entity.getNameen(), entity.getNamekr(), entity.getDepartment(), entity.getLevel());
        entity.setId(classId);
    }
    
    public Integer insert(String name, String nameen, String namekr, String department, Integer level) throws Exception {
        Date current = Calendar.getInstance().getTime();
        
        Map<String, Object> params = initMap();
        params.put("name", name);
        params.put("nameen", nameen);
        params.put("namekr", namekr);
        params.put("department", department);
        params.put("level", level);
        params.put("createTime", current);
        params.put("updateTime", current);
        params.put("timestamp", current.getTime());
        getSqlSession().insert(namespace+"insert", params);
        try {
            return Integer.valueOf(getSqlSession().selectOne(namespace+"getIdByTimestamp", params).toString());
        } catch(NumberFormatException ex) {
            System.err.println(ex);
        }
        throw new KokouException();
    }
    
    public Integer update(ClassGroup entity) throws Exception {
        return update(entity.getId(), entity.getName(), entity.getNameen(), entity.getNamekr(),  entity.getDepartment(), entity.getLevel());
    }
    
    public Integer update(Integer classId, String name, String nameen, String namekr, String department, Integer level) throws Exception {
        Date current = Calendar.getInstance().getTime();
        Map<String, Object> params = initMap();
        params.put("classId", classId);
        params.put("name", name);
        params.put("nameen", nameen);
        params.put("namekr", namekr);
        params.put("department", department);
        params.put("level", level);
        params.put("updateTime", current);
        return getSqlSession().update(namespace+"update", params);
    }
    
    public void save(ClassGroup entity) throws Exception {
        if (entity.getId() == null || entity.getId() <= 0) {
            insert(entity);
        } else {
            update(entity);
        }
    }
}
