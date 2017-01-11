/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.element

/**
 *
 * @author master
 */
import javax.xml.bind.annotation.*
import java.util.List
/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
class Group extends Object implements Serializable {
    @XmlAttribute(name="name")
    def String name
    @XmlElement(name="groupExpression")
    def String groupExpression
    @XmlElementWrapper(name="groupHeader")
    @XmlElement(name="band")
    def List<Band> groupHeaderList
    @XmlElementWrapper(name="groupFooter")
    @XmlElement(name="band")
    def List<Band> groupFooterList
}

