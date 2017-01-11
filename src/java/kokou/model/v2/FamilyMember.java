/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"with"
})
public class FamilyMember extends HumanRelation {
    private Boolean _with = null;
    @XmlElement(name="with")
    public Boolean getWith() {
        if (this._with == null) {
            this._with = Boolean.FALSE;
        }
        return this._with;
    }
    public void setWith(Boolean b) {
        this._with = b;
    }
}
