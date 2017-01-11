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
@XmlRootElement(name="image")
class Image extends BoxDisplayable {
    @XmlAttribute(name="hAlign")
    def String align
    @XmlAttribute(name="vAlign")
    def String valign
    @XmlElement(name="imageExpression")
    def Expression imageExpression
    
    def Expression getImageExpression() {
        if (this.imageExpression==null) {
            this.imageExpression = new Expression()
        }
        return this.imageExpression
    }
    
    def String getExpression() {
        return this.getImageExpression().getValue()
    }
    def void setExpression(String expression) {
        this.getImageExpression().setValue(expression)
    }
}

