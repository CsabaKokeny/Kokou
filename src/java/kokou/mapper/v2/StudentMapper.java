/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.mapper.v2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kokou.mapper.DefaultMapper;
import kokou.model.v2.Student;
import kokou.model.v2.student.StudentCareer;
import kokou.model.v2.student.StudentContact;
import kokou.model.v2.student.StudentFamilyMember;
import kokou.model.v2.student.StudentKeeper;
import kokou.model.v2.student.StudentTransport;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author master
 */
public class StudentMapper extends DefaultMapper {
    
    String namespace = "kokou.mapper.v2.StudentMapper.";
    
    public StudentMapper(SqlSession sqlSession) {
        super(sqlSession);
    }
    
  
    public void delete(Integer id) {
        getSqlSession().delete(namespace+"deleteKeeper", id);
        getSqlSession().delete(namespace+"deleteFamily", id);
        getSqlSession().delete(namespace+"deleteContact", id);
        getSqlSession().delete(namespace+"deleteCareer", id);
        getSqlSession().delete(namespace+"deleteTransport", id);
        getSqlSession().delete(namespace+"delete", id);
    }
    
    public void insertClass(Integer studentId, String schoolYear, String className) {
        getSqlSession().delete(namespace+"deleteClass", studentId);
        Map<String,Object> params = new HashMap();
        params.put("studentId", studentId);
        params.put("schoolYear", schoolYear);
        params.put("className", className);
        getSqlSession().insert(namespace+"insertClass", params);
    }
    
    public void insertKeeper(Student entity) {
        StudentKeeper keeper = entity.getKeeper();
        keeper.setStudentId(entity.getId());
        getSqlSession().delete(namespace+"deleteKeeper", entity.getId());
        if (entity.getName()==null || entity.getName().trim().isEmpty()) {
            return;
        }
        keeper.setSort(1);
        getSqlSession().insert(namespace+"insertKeeper", keeper);
    }
    
    public void insertFamily(Student entity) {
        getSqlSession().delete(namespace+"deleteFamily", entity.getId());
        List<StudentFamilyMember> list = entity.getFamilyList();
        if (list.isEmpty()) return;
        int i=1;
        for (StudentFamilyMember family : list) {
            if (family == null) continue;
            if (family.getName() == null || family.getName().trim().isEmpty()) continue;
            family.setStudentId(entity.getId());
            family.setSort(i++);
            getSqlSession().insert(namespace+"insertFamily", family);
        }
    }
    
    public void insertContact(Student entity) {
        getSqlSession().delete(namespace+"deleteContact", entity.getId());
        List<StudentContact> list = entity.getContactList();
        if (list.isEmpty()) return;
        int i=1;
        for (StudentContact item : list) {
            if (item == null) continue;
            if (item.getName() == null || item.getName().trim().isEmpty()) continue;
            item.setStudentId(entity.getId());
            item.setSort(i++);
            getSqlSession().insert(namespace+"insertContact", item);
        }
    }
    
    public void insertCareer(Student entity) {
        getSqlSession().delete(namespace+"deleteCareer",entity.getId());
        List<StudentCareer> list = entity.getCareerList();
        if (list.isEmpty()) return;
        int i=0;
        for (StudentCareer item : list) {
            if (item == null) continue;
            if (item.getSchoolName()== null || item.getSchoolName().trim().isEmpty()) continue;
            item.setStudentId(entity.getId());
            item.setSort(i++);
            getSqlSession().insert(namespace+"insertCareer", item);
        }
    }
    
    public void insertBus(Student entity) {
        getSqlSession().delete(namespace+"deleteTransport", entity.getId());
        List<StudentTransport> list = entity.getAttending().getTransportList();
        if (list.isEmpty()) return;
        int i = 0;
        for (StudentTransport item : list) {
            if (item == null) continue;
            item.setStudentId(entity.getId());
            item.setSort(i++);
            getSqlSession().insert(namespace+"insertTransport", item);
        }
    }
    
    public void insert(Student entity) {
        Date current = Calendar.getInstance().getTime();
        entity.setTimestamp(current.getTime());
        getSqlSession().insert(namespace+"insert", entity);
        entity.setId(Integer.valueOf(getSqlSession().selectOne(namespace+"getIdByTimestamp", entity).toString()));
        insertKeeper(entity);
        insertCareer(entity);
        insertFamily(entity);
        insertContact(entity);
        insertBus(entity);
    }
    
    public void update(Student entity) {
        Date current = Calendar.getInstance().getTime();
        getSqlSession().update(namespace+"update", entity);
        insertKeeper(entity);
        insertCareer(entity);
        insertFamily(entity);
        insertContact(entity);
        insertBus(entity);
    }
    
    public Integer getCount (Map params) {
        return getSqlSession().selectOne(namespace+"getCount", params);
    }
    
    public List<Student> find(Map params) {
        List<Student> list = getSqlSession().selectList(namespace+"find", params);
        if (list == null) {
            list = new ArrayList();
        }
        return list;
    }
    
    public List<Student> find(Map params, int start) {
        List<Student> list = getSqlSession().selectList(namespace+"find", params, new RowBounds(start, -1));
        if (list == null) {
            list = new ArrayList();
        }
        return list;
    }
    
    public List<Student> find(Map params, int start, int limit) {
        List<Student> list = getSqlSession().selectList(namespace+"find", params, new RowBounds(start, limit));
        if (list == null) {
            list = new ArrayList();
        }
        return list;
    }
    
    public List<Student> find_2Col(Map params) {
        List<Student> list = this.find(params);
        Map<String, Integer> counts = new HashMap();
        Map<String, Integer> indexs = new HashMap();
        int max = 0;
        for(Student item : list) {
            if (item.getEnterSchoolKind() == null) {
                item.setEnterSchoolKind("");
            }
            if (item.getSchoolYear() == null) {
                item.getSchoolClass().setSchoolYear("");
            }
            if (item.getSchoolClass().getName() == null) {
                item.getSchoolClass().setName("");
            }
            String key = item.getClassName();
            if (!counts.containsKey(key)) {
                counts.put(key, 1);
                item.setRollNo("1");
                if (1>max) max = 1;
                indexs.put(key, (int)((counts.size()+1)/2));
            } else {
                Integer count = counts.get(key);
                count++;
                counts.put(key, count);
                if (count > max) max = count;
                item.setRollNo(count.toString());
            }
            item.setReportGroupNo(indexs.get(key));
        }
        for(String key: counts.keySet()) {
            Integer count = counts.get(key);
            for(int i=count+1;i<=max;i++) {
                Student item = new Student();
                item.setClassName(key);
                item.setReportGroupNo(indexs.get(key));
                item.setRollNo(String.valueOf(i));
                list.add(item);
            }
        }
        return list;
    }
    
    public Student getOneById(Integer id) {
        Map<String, Object> params = new HashMap();
        params.put("studentId", id);
        Student entity= getSqlSession().selectOne(namespace+"find", params);
        return entity;
    }
    
    public boolean checkDuplicating(Student entity) {
        int nCount = getSqlSession().selectOne(namespace+"checkCodeDuplicating", entity);
        return nCount > 0;
    }
}
