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
class BoxDisplayable extends Displayable{
    @XmlElement(name="box")
    def @Delegate Box box
    
    def Integer getLeftPadding() {
        return box==null||box.getLeftPadding()==null?0:box.getLeftPadding()
    }
    def void setLeftPadding(Integer padding) {
        if (box==null) box=new Box()
        box.setLeftPadding(padding)
    }
    
    def Integer getRightPadding() {
        return box==null||box.getRightPadding()==null?0:box.getRightPadding()
    }
    def void setRightPadding(Integer padding) {
        if (box==null) box=new Box()
        box.setRightPadding(padding)
    }
    
    def Integer getTopPadding() {
        return box==null||box.getTopPadding()==null?0:box.getTopPadding()
    }
    def void setTopPadding(Integer padding) {
        if (box==null) box=new Box()
        box.setTopPadding(padding)
    }
    
    def Integer getBottomPadding() {
        return box==null||box.getBottomPadding()==null?0:box.getBottomPadding()
    }
    def void setBottomPadding(Integer padding) {
        if (box==null) box=new Box()
        box.setBottomPadding(padding)
    }
    
    def Float getTopBorderWidth () {
        return this.box==null?0f:this.box.getTopBorderWidth()
    }
    def void setTopBorderWidth (Float topBorder) {
        if (this.box==null) this.box=new Box();
        this.box.setTopBorderWidth(topBorder);
    }
    
    def Float getBottomBorderWidth () {
        return this.box==null?0f:this.box.getBottomBorderWidth()
    }
    def void setBottomBorderWidth (Float bottomBorder) {
        if (this.box==null) this.box=new Box();
        this.box.setBottomBorderWidth(bottomBorder);
    }
    
    def Float getLeftBorderWidth () {
        return this.box==null?0f:this.box.getLeftBorderWidth()
    }
    def void setLeftBorderWidth (Float leftBorder) {
        if (this.box==null) this.box=new Box();
        this.box.setLeftBorderWidth(leftBorder);
    }
    
    def Float getRightBorderWidth () {
        return this.box==null?0f:this.box.getRightBorderWidth()
    }
    def void setRightBorderWidth (Float rightBorder) {
        if (this.box==null) this.box=new Box();
        this.box.setRightBorderWidth(rightBorder);
    }
}

