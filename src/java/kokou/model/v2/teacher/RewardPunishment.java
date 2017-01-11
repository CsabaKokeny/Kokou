/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2.teacher;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"date", "content"})
public class RewardPunishment extends Entity {
        
    private String date;
    private String content;

    @XmlElement(name="date")
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement(name="content")
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
