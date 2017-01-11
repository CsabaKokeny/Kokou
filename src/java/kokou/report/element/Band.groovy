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
@XmlType(propOrder=["height", "splitType", "printWhenExpression", "elementList"])
class Band extends Object implements Serializable {
    
    public static final STRETCH = "Stretch"
    public static final IMMEDIATE = "Immediate"
    public static final PREVENT = "Prevent"
    
    @XmlAttribute(name="height")
    def Integer height
    @XmlAttribute(name="splitType")
    def String splitType
    @XmlElement(name="printWhenExpression")
    def String printWhenExpression
    //@XmlElementRef()
    @XmlElements([
        @XmlElement(name="staticText", type=StaticText.class),
        @XmlElement(name="textField", type=TextField.class),
        @XmlElement(name="break", type=Break.class),
        @XmlElement(name="image", type=Image.class)
    ])
    def List elementList = []
    
    def Band() {
    }
}

