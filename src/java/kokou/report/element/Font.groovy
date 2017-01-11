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
class Font extends Object implements Serializable {
    @XmlAttribute(name="fontName")
    def String fontName
    @XmlAttribute(name="size")
    def Integer size
    @XmlAttribute(name="isBold")
    def Boolean isBold
    @XmlAttribute(name="isUnderline")
    def Boolean isUnderline
}
