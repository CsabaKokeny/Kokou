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
class Variable extends Object implements Serializable {
    @XmlAttribute
    def String name
    @XmlAttribute(name="class")
    def String className = "java.lang.String"
    @XmlAttribute(name="resetType")
    def String resetType
    @XmlAttribute(name="resetGroup")
    def String resetGroup
    @XmlElement
    def String variableExpression
    @XmlElement
    def String initialValueExpression
}

