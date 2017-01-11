/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.element

/**
 *
 * @author master
 */
import javax.xml.bind.annotation.*
import java.util.List
/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
class ColumnBreak extends Break {
    
    def ColumnBreak () {
        super()
    }
    
    def String getType() {
        return "Column"
    }
}

