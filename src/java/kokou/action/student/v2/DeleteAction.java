/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.action.student.v2;

import java.util.ArrayList;
import java.util.List;
import kokou.action.DefaultAction;
import kokou.mapper.v2.StudentMapper;

/**
 *
 * @author master
 */
public class DeleteAction extends DefaultAction {
    private List<Integer> studentId;
    public List<Integer> getStudentId() {
        if (studentId == null) {
            studentId = new ArrayList();
        }
        return studentId;
    }
    public void setStudentId(List<Integer> studentId) {
        this.studentId = studentId;
    }
    
    public void execute() {
        StudentMapper mapper = new StudentMapper(getSqlSession());
        for(Integer id : getStudentId()) {
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
