package kokou.report.element

import javax.xml.bind.annotation.*
import javax.xml.bind.annotation.XmlAnyElement
import java.util.List
/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
class Parameter extends Object implements Serializable {
    @XmlAttribute
    def String name
    @XmlAttribute(name="class")
    def String className
    @XmlElement
    def String defaultValueExpression
}
