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
import kokou.model.v2.Teacher;
import kokou.model.v2.teacher.AttendingInformation;
import kokou.model.v2.teacher.Career;
import kokou.model.v2.teacher.Contact;
import kokou.model.v2.teacher.DriverCard;
import kokou.model.v2.teacher.FamilyInformation;
import kokou.model.v2.teacher.FamilyMember;
import kokou.model.v2.teacher.LastGraduation;
import kokou.model.v2.teacher.Passport;
import kokou.model.v2.teacher.PositionInformation;
import kokou.model.v2.teacher.RewardPunishment;
import kokou.model.v2.teacher.Transport;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author master
 */
public class TeacherMapper extends DefaultMapper {
    
    String namespace = "kokou.mapper.v2.TeacherMapper.";
    
    public TeacherMapper(SqlSession sqlSession) {
        super(sqlSession);
    }
    
  
    public void delete(Integer id) {
        getSqlSession().delete(namespace+"deletePositionInformation", id);
        getSqlSession().delete(namespace+"deleteLastGraduation", id);
        getSqlSession().delete(namespace+"deleteCareer", id);
        getSqlSession().delete(namespace+"deleteFamilyInformation", id);
        getSqlSession().delete(namespace+"deleteFamilyMember", id);
        getSqlSession().delete(namespace+"deletePassport", id);
        getSqlSession().delete(namespace+"deleteAttendingInformation", id);
        getSqlSession().delete(namespace+"deleteDriverCard", id);
        getSqlSession().delete(namespace+"deleteTransport", id);
        getSqlSession().delete(namespace+"deleteRewardPunishment", id);
        getSqlSession().delete(namespace+"delete", id);
    }
    
    public void insertPositionInformation(Teacher entity) {
        PositionInformation item = entity.getPositionInformation();
        item.setTeacherId(entity.getId());
        getSqlSession().delete(namespace+"deletePositionInformation", entity.getId());
        item.setTeacherId(entity.getId());
        getSqlSession().insert(namespace+"insertPositionInformation", item);
    }
    
    public void insertLastGraduation(Teacher entity) {
        LastGraduation item = entity.getLastGraduation();
        item.setTeacherId(entity.getId());
        getSqlSession().delete(namespace+"deleteLastGraduation", entity.getId());
        item.setTeacherId(entity.getId());
        getSqlSession().insert(namespace+"insertLastGraduation", item);
    }
    
    public void insertCareer(Teacher entity) {
        getSqlSession().delete(namespace+"deleteCareer",entity.getId());
        List<Career> list = entity.getCareers();
        if (list.isEmpty()) return;
        int i=0;
        for (Career item : list) {
            if (item == null) continue;
            if (item.getPlace()== null || item.getPlace().trim().isEmpty()) continue;
            item.setTeacherId(entity.getId());
            item.setSort(i++);
            getSqlSession().insert(namespace+"insertCareer", item);
        }
    }
    
    public void insertFamilyInformation(Teacher entity) {
        getSqlSession().delete(namespace+"deleteFamilyInformation", entity.getId());
        FamilyInformation info = entity.getFamilyInformation();
        info.setTeacherId(entity.getId());
        getSqlSession().insert(namespace+"insertFamilyInformation", info);
        this.insertFamilyMember(entity);
    }
    
    public void insertFamilyMember(Teacher entity) {
        getSqlSession().delete(namespace+"deleteFamilyMember",entity.getId());
        List<FamilyMember> list = entity.getFamilyInformation().getFamilyMembers();
        int i=0;
        for (FamilyMember item : list) {
            if (item == null) continue;
            if (item.getName()== null || item.getName().trim().isEmpty()) continue;
            item.setTeacherId(entity.getId());
            item.setSort(i++);
            getSqlSession().insert(namespace+"insertFamilyMember", item);
        }
    }
    
    public void insertPassport(Teacher entity) {
        Passport item = entity.getPassport();
        item.setTeacherId(entity.getId());
        getSqlSession().delete(namespace+"deletePassport", entity.getId());
        item.setTeacherId(entity.getId());
        getSqlSession().insert(namespace+"insertPassport", item);
    }
    
    public void insertContact(Teacher entity) {
        getSqlSession().delete(namespace+"deleteContact", entity.getId());
        List<Contact> list = entity.getContacts();
        if (list.isEmpty()) return;
        int i=1;
        for (Contact item : list) {
            if (item == null) continue;
            if (item.getName() == null || item.getName().trim().isEmpty()) continue;
            item.setTeacherId(entity.getId());
            item.setSort(i++);
            getSqlSession().insert(namespace+"insertContact", item);
        }
    }
    
    public void insertDriverCard(Teacher entity) {
        DriverCard item = entity.getAttendingInformation().getDriverCard();
        item.setTeacherId(entity.getId());
        getSqlSession().delete(namespace+"deleteDriverCard", entity.getId());
        item.setTeacherId(entity.getId());
        getSqlSession().insert(namespace+"insertDriverCard", item);
    }
    
    public void insertTransport(Teacher entity) {
        getSqlSession().delete(namespace+"deleteTransport", entity.getId());
        List<Transport> list = entity.getAttendingInformation().getTransports();
        if (list.isEmpty()) return;
        int i=1;
        for (Transport item : list) {
            if (item == null) continue;
            item.setTeacherId(entity.getId());
            item.setSort(i++);
            getSqlSession().insert(namespace+"insertTransport", item);
        }
    }
    
    public void insertAttendingInformation(Teacher entity) {
        AttendingInformation item = entity.getAttendingInformation();
        item.setTeacherId(entity.getId());
        getSqlSession().delete(namespace+"deleteAttendingInformation", entity.getId());
        item.setTeacherId(entity.getId());
        getSqlSession().insert(namespace+"insertAttendingInformation", item);
        this.insertDriverCard(entity);
        this.insertTransport(entity);
    }
    
    public void insertRewardPunishment (Teacher entity) {
        getSqlSession().delete(namespace+"deleteRewardPunishment", entity.getId());
        List<RewardPunishment> list = entity.getRewardPunishments();
        if (list.isEmpty()) return;
        int i = 0;
        for (RewardPunishment item : list) {
            if (item == null) continue;
            item.setTeacherId(entity.getId());
            item.setSort(i++);
            getSqlSession().insert(namespace+"insertRewardPunishment", item);
        }
    }
    
    public void insert(Teacher entity) {
        Date current = Calendar.getInstance().getTime();
        entity.setTimestamp(current.getTime());
        getSqlSession().insert(namespace+"insert", entity);
        entity.setId(Integer.valueOf(getSqlSession().selectOne(namespace+"getIdByTimestamp", entity).toString()));
        insertPositionInformation(entity);
        insertLastGraduation(entity);
        insertCareer(entity);
        insertFamilyInformation(entity);
        insertPassport(entity);
        insertContact(entity);
        insertAttendingInformation(entity);
        insertRewardPunishment(entity);
    }
    
    public void update(Teacher entity) {
        Date current = Calendar.getInstance().getTime();
        getSqlSession().update(namespace+"update", entity);
        insertPositionInformation(entity);
        insertLastGraduation(entity);
        insertCareer(entity);
        insertFamilyInformation(entity);
        insertPassport(entity);
        insertContact(entity);
        insertAttendingInformation(entity);
        insertRewardPunishment(entity);
    }
    
    public Integer getCount (Map params) {
        return getSqlSession().selectOne(namespace+"getCount", params);
    }
    
    public List<Teacher> find(Map params) {
        List<Teacher> list = getSqlSession().selectList(namespace+"find", params);
        if (list == null) {
            list = new ArrayList();
        }
        return list;
    }
    
    public List<Teacher> find(Map params, int start) {
        List<Teacher> list = getSqlSession().selectList(namespace+"find", params, new RowBounds(start, -1));
        if (list == null) {
            list = new ArrayList();
        }
        return list;
    }
    
    public List<Teacher> find(Map params, int start, int limit) {
        List<Teacher> list = getSqlSession().selectList(namespace+"find", params, new RowBounds(start, limit));
        if (list == null) {
            list = new ArrayList();
        }
        return list;
    }
    
    public Teacher getOneById(Integer id) {
        if (id == null) return null;
        Map<String, Object> params = new HashMap();
        params.put("teacherId", id);
        Teacher entity= getSqlSession().selectOne(namespace+"find", params);
        return entity;
    }
    
    public boolean checkDuplicating(Teacher entity) {
        int nCount = getSqlSession().selectOne(namespace+"checkCodeDuplicating", entity);
        return nCount > 0;
    }
}
