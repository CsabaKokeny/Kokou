/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2.teacher;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name="TeacherContact")
public class Contact extends kokou.model.v2.Contact {
    
    private Integer teacherId;
    
    public Integer getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
