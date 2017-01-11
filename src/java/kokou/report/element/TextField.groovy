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
@XmlRootElement(name="textField")
class TextField extends TextDisplayable {
    @XmlAttribute(name="isBlankWhenNull")
    def Boolean isBlankWhenNull = true
    @XmlElement(name="textFieldExpression")
    def Expression textFieldExpression
    
    def getTextFieldExpression() {
        if (this.textFieldExpression==null) {
            this.textFieldExpression = new Expression()
        }
        return this.textFieldExpression
    }
    
    def String getExpression() {
        return this.getTextFieldExpression().getValue()
    }
    def void setExpression(String expression) {
        this.getTextFieldExpression().setValue(expression)
    }
}

