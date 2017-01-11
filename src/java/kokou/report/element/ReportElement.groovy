/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.element

import javax.xml.bind.annotation.*
import java.util.List
/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
class ReportElement extends Object implements Serializable {
    @XmlAttribute
    def Integer x;
    @XmlAttribute
    def Integer y;
    @XmlAttribute
    def Integer width;
    @XmlAttribute
    def Integer height;
    @XmlElement(name="printWhenExpression")
    def String printWhenExpression
}

