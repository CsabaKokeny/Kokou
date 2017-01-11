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
@XmlRootElement(name="jasperReport")
class JasperReport extends Object implements Serializable {
    
    @XmlAttribute(name="xmlns")
    def String xmlns = "http://jasperreports.sourceforge.net/jasperreports"
    @XmlAttribute(name="xmlns:xsi")
    def String xmlnsXsi = "http://www.w3.org/2001/XMLSchema-instance"
    @XmlAttribute(name="xsi:schemaLocation")
    def String xsiSchemaLocation
    @XmlAttribute(name="name")
    def String name
    @XmlAttribute(name="columnCount")
    def Integer columnCount
    @XmlAttribute(name="printOrder")
    def String printOrder
    @XmlAttribute(name="pageWidth")
    def Integer pageWidth=595
    @XmlAttribute(name="pageHeight")
    def Integer pageHeight=842
    @XmlAttribute(name="orientation")
    def String orientation
    @XmlAttribute(name="columnWidth")
    def Integer columnWidth=555
    @XmlAttribute(name="leftMargin")
    def Integer leftMargin=20
    @XmlAttribute(name="rightMargin")
    def Integer rightMargin=20
    @XmlAttribute(name="topMargin")
    def Integer topMargin=20
    @XmlAttribute(name="bottomMargin")
    def Integer bottomMargin=20
    @XmlElement(name="property")
    def List<Property> propertyList = [
        new Property(name:"ireport.zoom", value:"1.0"),
        new Property(name:"ireport.x", value:"0"),
        new Property(name:"ireport.y", value:"0")
    ]
    @XmlElement(name="parameter")
    def List<Parameter> parameterList = []
    @XmlElement(name="queryString")
    def QueryString queryString 
    @XmlElement(name="field")
    def List<Field> fieldList = []
    @XmlElement(name="variable")
    def List<Variable>variableList = []
    @XmlElement(name="filterExpression")
    def String filterExpression
    @XmlElement(name="group")
    def List<Group> groupList = []
    @XmlElement(name="background")
    def BandContainer background
    @XmlElement(name="pageHeader")
    def BandContainer pageHeader
    @XmlElement(name="columnHeader")
    def BandContainer columnHeader
    @XmlElementWrapper(name="detail")
    @XmlElement(name="band")
    def List<Band> detailList = []
    @XmlElement(name="columnFooter")
    def BandContainer columnFooter
    @XmlElement(name="pageFooter")
    def BandContainer pageFooter
    @XmlElement(name="lastPageFooter")
    def BandContainer lastPageFooter
    @XmlElement(name="summary")
    def BandContainer summary
    @XmlElement(name="noData")
    def BandContainer noData
}
