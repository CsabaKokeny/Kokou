/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action.teacher.v2;

import java.util.ArrayList;
import java.util.List;
import kokou.action.DefaultAction;
import kokou.mapper.v2.TeacherMapper;

/**
 *
 * @author master
 */
public class DeleteAction extends DefaultAction {
    private List<Integer> teacherId;
    public List<Integer> getTeacherId() {
        if (teacherId == null) {
            teacherId = new ArrayList();
        }
        return teacherId;
    }
    public void setTeacherId(List<Integer> teacherId) {
        this.teacherId = teacherId;
    }
    
    public void execute() {
        TeacherMapper mapper = new TeacherMapper(getSqlSession());
        for(Integer id : getTeacherId()) {
            try {
                mapper.delete(id);
                getSqlSession().commit();
            } catch (Exception ex) {
                getSqlSession().rollback();
                System.err.println(ex);
            }
        }
        closeSqlSession();
    }
}
