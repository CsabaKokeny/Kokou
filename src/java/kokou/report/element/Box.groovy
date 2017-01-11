package kokou.report.element

import javax.xml.bind.annotation.*
import java.util.List
/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
class Box extends Object implements Serializable {
    @XmlAttribute(name="leftPadding")
    def Integer leftPadding
    @XmlAttribute(name="rightPadding")
    def Integer rightPadding
    @XmlAttribute(name="topPadding")
    def Integer topPadding
    @XmlAttribute(name="bottomPadding")
    def Integer bottomPadding
    @XmlElement(name="topPen")
    def Pen topPen
    @XmlElement(name="leftPen")
    def Pen leftPen
    @XmlElement(name="bottomPen")
    def Pen bottomPen
    @XmlElement(name="rightPen")
    def Pen rightPen
    
    def private Pen setBorderWidth (Pen pen, Float width) {
        if (pen == null) {
            pen = new Pen()
        }
        pen.setLineWidth(width)
        return pen
    }
    
    def private void getBorderWidth(Pen pen) {
        pen==null?0f:pen.getLineWidth()
    }
    
    
    def Float getTopBorderWidth () {
        return this.getBorderWidth(this.topPen) 
    }
    def void setTopBorderWidth (Float topBorder) {
        this.topPen = this.setBorderWidth(this.topPen, topBorder)
    }
    
    def Float getBottomBorderWidth () {
        return this.getBorderWidth(this.bottomPen) 
    }
    def void setBottomBorderWidth (Float bottomBorder) {
        this.bottomPen = this.setBorderWidth(this.bottomPen, bottomBorder)
    }
    
    def Float getLeftBorderWidth () {
        return this.getBorderWidth(this.leftPen) 
    }
    def void setLeftBorderWidth (Float leftBorder) {
        this.leftPen = this.setBorderWidth(this.leftPen, leftBorder)
    }
    
    def Float getRightBorderWidth () {
        return this.getBorderWidth(this.rightBorder) 
    }
    def void setRightBorderWidth (Float rightBorder) {
        this.rightPen = this.setBorderWidth(this.rightPen, rightBorder)
    }
}
