package kokou.report.element

import javax.xml.bind.annotation.*
import javax.xml.bind.annotation.XmlAnyElement
import java.util.List
/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
class Pen extends Object implements Serializable {
    @XmlAttribute
    def Float lineWidth
    @XmlAttribute
    def String lineStyle
}
