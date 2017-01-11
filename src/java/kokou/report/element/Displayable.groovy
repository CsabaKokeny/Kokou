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
abstract class Displayable extends Object implements Serializable {
    @XmlElement(name="reportElement")
    def ReportElement reportElement
    
    def ReportElement getReportElement() {
        if (this.reportElement==null) {
            this.reportElement = new ReportElement()
        }
        return this.reportElement
    }
    
    def String getPrintWhenExpression() {
        return this.getReportElement().getPrintWhenExpression()
    }
    def void setPrintWhenExpression(String printWhenExpression) {
        this.getReportElement().setPrintWhenExpression(printWhenExpression)
    }
    
    def Integer getX() {
        return this.getReportElement().getX()
    }
    def void setX(Integer x) {
        this.getReportElement().setX(x)
    }
    
    def Integer getY() {
        return this.getReportElement().getY()
    }
    def void setY(Integer y) {
        this.getReportElement().setY(y)
    }
    
    def Integer getWidth() {
        return this.getReportElement().getWidth()
    }
    def void setWidth(Integer width) {
        this.getReportElement().setWidth(width)
    }
    
    def Integer getHeight() {
        return this.getReportElement().getHeight()
    }
    def void setHeight(Integer height) {
        this.getReportElement().setHeight(height)
    }
    
    
}

