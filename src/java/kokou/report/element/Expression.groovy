/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.element

import javax.xml.bind.annotation.*
/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
class Expression extends Object implements Serializable {
    @XmlAttribute(name="class")
    def String className = "java.lang.String"
    @XmlValue
    def String value
}

