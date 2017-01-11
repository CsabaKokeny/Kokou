/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class ClassGroup {
    private Integer id = null;
    private String name;
    private String nameen;
    private String namekr;
    private String department;
    private String departmentLabel;
    private Integer level;
    
    private String classCode;
    private String classLabel;
    
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    @XmlElement(name="classId")
    public Integer getClassId() {
        return this.getId();
    }
    public void setClassId(Integer classId) {
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
    
    @XmlElement(name="levelLabel")
    public String getLevelLabel() {
        if (this.level == null) {
            return "";
        }
        return this.level.toString();
    }
    
    @XmlElement(name="level")
    public Integer getLevel() {
        return this.level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    
    
    @XmlElement(name="classCode")
    public String getClassCode() {
        if (this.classCode == null) {
            this.classCode = "";
        }
        return this.departmentLabel;
    }
    public void setClassCode(String classCode) {
        if (classCode != null) {
            classCode = classCode.trim();
        }
        this.classCode = classCode;
    }
    
    @XmlElement(name="classLabel")
    public String getClassLabel() {
        if (this.classLabel == null) {
            this.classLabel = "";
        }
        return this.classLabel;
    }
    public void setClassLabel(String classLabel) {
        if (classLabel != null) {
            classLabel = classLabel.trim();
        }
        this.classLabel = classLabel;
    }
}
