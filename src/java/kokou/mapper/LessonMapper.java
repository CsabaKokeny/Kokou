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
import kokou.model.Lesson;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author master
 */
public class LessonMapper extends DefaultMapper{
    public String namespace = "kokou.mapper.LessonMapper.";

    public LessonMapper(SqlSession sqlSession) {
        super(sqlSession);
    }
    
    public Lesson toEntity(Map row) {
        Lesson entity = null;
        if (row != null) {
            entity = new Lesson();
            entity.setId(Integer.valueOf(row.get("lessonId").toString()));
            entity.setName((String)row.get("name"));
            entity.setNameen((String)row.get("nameen"));
            entity.setNamekr((String)row.get("namekr"));
            entity.setDepartment((String)row.get("department"));
            entity.setDepartmentLabel((String)row.get("departmentLabel"));
            entity.setLevel((Integer)row.get("level"));
            entity.setDescription((String)row.get("description"));
        }
        return entity;
    }
    
    public void getList(Object params, ResultHandler handler) {
        getSqlSession().select(namespace+"getList", params, handler);
    }
    
    public Lesson getOneById(Integer lessonId) {
        if (lessonId == null) {
            return null;
        }
        Lesson  entity = null;
        Map<String,Object> params = initMap();
        params.put("lessonId", lessonId);
        Map<?,?> row = (Map<?,?>)getSqlSession().selectOne(namespace+"getList", params);
        return toEntity(row);
    }
    
    public void insert(Lesson entity) throws Exception {
        Integer lessonId = insert(entity.getName(), entity.getNameen(), entity.getNamekr(), entity.getDepartment(), entity.getLevel(), entity.getDescription());
        entity.setId(lessonId);
    }
    
    public Integer insert(String name, String nameen, String namekr, String department, Integer level, String description) throws Exception {
        Date current = Calendar.getInstance().getTime();
        
        Map<String, Object> params = initMap();
        params.put("name", name);
        params.put("nameen", nameen);
        params.put("namekr", namekr);
        params.put("department", department);
        params.put("level", level);
        params.put("description", description);
        params.put("createTime", current);
        params.put("updateTime", current);
        params.put("description", description);
        params.put("timestamp", current.getTime());
        getSqlSession().insert(namespace+"insert", params);
        try {
            return Integer.valueOf(getSqlSession().selectOne(namespace+"getIdByTimestamp", params).toString());
        } catch(NumberFormatException ex) {
            System.err.println(ex);
        }
        throw new KokouException();
    }
    
    public Integer update(Lesson entity) throws Exception {
        return update(entity.getId(), entity.getName(), entity.getNameen(), entity.getNamekr(),  entity.getDepartment(), entity.getLevel(), entity.getDescription());
    }
    
    public Integer update(Integer lessonId, String name, String nameen, String namekr, String department, Integer level, String description) throws Exception {
        Date current = Calendar.getInstance().getTime();
        Map<String, Object> params = initMap();
        params.put("lessonId", lessonId);
        params.put("name", name);
        params.put("nameen", nameen);
        params.put("namekr", namekr);
        params.put("department", department);
        params.put("level", level);
        params.put("description", description);
        params.put("updateTime", current); 
        return getSqlSession().update(namespace+"update", params);
    }
    
    public void save(Lesson entity) throws Exception {
        if (entity.getId() == null || entity.getId() <= 0) {
            insert(entity);
        } else {
            update(entity);
        }
    }
}
