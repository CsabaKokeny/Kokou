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
class TextDisplayable extends BoxDisplayable {
    @XmlElement(name="textElement")
    def TextElement textElement
    
    def TextElement getTextElement() {
        if (this.textElement == null) {
            this.textElement = new TextElement(
                fontName: "MS PMincho",
                fontSize: 12
            )
        }
        return this.textElement
    }
    
    def String getFontName() {
        return this.getTextElement().getFontName()
    }
    def void setFontName(String fontName) {
        this.getTextElement().setFontName(fontName)
    }
    
    def Integer getFontSize() {
        return this.getTextElement().getFontSize()
    }
    def void setFontSize(Integer fontSize) {
        this.getTextElement().setFontSize(fontSize)
    }
    
    def Boolean getIsBold() {
        return this.getTextElement().getIsBold()
    }
    def void setIsBold(Boolean isBold) {
        this.getTextElement().setIsBold(isBold)
    }
    
    def Boolean getIsUnderline() {
        return this.getTextElement().getIsUnderline()
    }
    def void setIsUnderline(Boolean isUnderline) {
        this.getTextElement().setIsUnderline(isUnderline)
    }
    
    def String getAlign() {
        return this.getTextElement().getTextAlignment()
    }
    def void setAlign(String align) {
        this.getTextElement().setTextAlignment(align)
    }
    
    def String getValign() {
        return this.getTextElement().getVerticalAlignment()
    }
    def void setValign(String valign) {
        this.getTextElement().setVerticalAlignment(valign)
    }
}

