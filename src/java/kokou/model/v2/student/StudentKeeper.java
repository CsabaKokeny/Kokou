/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2.student;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import kokou.model.v2.HumanRelation;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
public class StudentKeeper extends HumanRelation {
    
    private Integer studentId;
    
    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
