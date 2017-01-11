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
class TextElement extends Object implements Serializable {
    @XmlAttribute(name="textAlignment")
    def String textAlignment
    @XmlAttribute(name="verticalAlignment")
    def String verticalAlignment
    @XmlElement(name="font")
    def Font font;
    
    def Font getFont() {
        if (this.font==null) {
            this.font = new Font()
        }
        return this.font
    }
    
    def String getFontName() {
        return this.getFont().getFontName()
    }
    def void setFontName(String fontName) {
        this.getFont().setFontName(fontName)
    }
    
    def Integer getFontSize() {
        return this.getFont().getSize()
    }
    def void setFontSize(Integer fontSize) {
        this.getFont().setSize(fontSize)
    }
    
    def Boolean getIsBold() {
        return this.getFont().getIsBold()
    }
    def void setIsBold(Boolean isBold) {
        this.getFont().setIsBold(isBold)
    }
    
    def Boolean getIsUnderline() {
        return this.getFont().getIsUnderline()
    }
    def void setIsUnderline(Boolean isUnderline) {
        this.getFont().setIsUnderline(isUnderline)
    }
    
    def String getAlign() {
        return this.getTextAlignment()
    }
    def void setAlign(String align) {
        this.setTextAlignment(align)
    }
    
    def String getValign() {
        return this.getVerticalAlignment()
    }
    def void setValign(String valign) {
        this.setVerticalAlignment(valign)
    }
}
