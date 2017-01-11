/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Lesson {
    private Integer id = null;
    private String name;
    private String nameen;
    private String namekr;
    private String department;
    private String departmentLabel;
    private Integer level;
    private String levelLabel;
    private String description;
    
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    @XmlElement(name="lessonId")
    public Integer getLessonId() {
        return this.getId();
    }
    public void setLessonId(Integer classId) {
        this.setId(classId);
    }
    
    @XmlElement(name="name")
    public String getName() {
        if (this.name == null) {
            this.name = "";
        }
        return this.name;
    }
    public void setName(String name) {
        if (name != null) {
            name = name.trim();
        }
        this.name = name;
    }
    
    @XmlElement(name="nameen")
    public String getNameen() {
        if (this.nameen == null) {
            this.nameen = "";
        }
        return this.nameen;
    }
    public void setNameen(String nameen) {
        if (nameen != null) {
            nameen = nameen.trim();
        }
        this.nameen = nameen;
    }
    
    @XmlElement(name="namekr")
    public String getNamekr() {
        if (this.namekr == null) {
            this.namekr = "";
        }
        return this.namekr;
    }
    public void setNamekr(String namekr) {
        if (namekr != null) {
            namekr = namekr.trim();
        }
        this.namekr = namekr;
    }
    
    @XmlElement(name="department")
    public String getDepartment() {
        if (this.department == null) {
            this.department = "";
        }
        return this.department;
    }
    public void setDepartment(String department) {
        if (department != null) {
            department = department.trim();
        }
        this.department = department;
    }
    
    @XmlElement(name="departmentLabel")
    public String getDepartmentLabel() {
        if (this.departmentLabel == null) {
            this.departmentLabel = "";
        }
        return this.departmentLabel;
    }
    public void setDepartmentLabel(String departmentLabel) {
        if (departmentLabel != null) {
            departmentLabel = departmentLabel.trim();
        }
        this.departmentLabel = departmentLabel;
    }
    
    @XmlElement(name="level")
    public Integer getLevel() {
        return this.level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    
    @XmlElement(name="levelLabel")
    public String getLevelLabel() {
        if (this.level == null) {
            return "";
        }
        return this.level.toString();
    }
    public void setLevelLabel(String levelLabel) {
        this.levelLabel = levelLabel;
    }
    
    @XmlElement(name="description")
    public String getDescription() {
        if (this.description == null) {
            return "";
        }
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}