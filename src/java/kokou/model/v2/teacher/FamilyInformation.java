/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2.teacher;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"familyMembers", "numberOfDependent"})
public class FamilyInformation extends Entity {
    
    private List<FamilyMember> familyMembers;
    @XmlElement(name="family")
    public List<FamilyMember> getFamilyMembers() {
        if (this.familyMembers == null) {
            this.familyMembers = new ArrayList();
        }
        return this.familyMembers;
    }
    public void setFamilyMembers(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }
    
    private Integer numberOfDependent;
    @XmlElement(name="numberOfDependent")
    public Integer getNumberOfDependent() {
        return this.numberOfDependent;
    }
    public void setNumberOfDependent(Integer numberOfDependent) {
        this.numberOfDependent = numberOfDependent;
    }
}
