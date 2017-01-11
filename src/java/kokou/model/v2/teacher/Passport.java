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
@XmlType(name="TeacherPassport")
public class Passport extends kokou.model.v2.Passport {
    private Integer teacherId;
    
    public Integer getTeacherId() {
        return this.teacherId;
    }
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
