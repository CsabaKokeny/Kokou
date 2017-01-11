package kokou.report.element

import javax.xml.bind.annotation.*
import java.util.List
/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
class BandContainer extends Object implements Serializable {
    @XmlElement(name="band")
    def Band band
}
