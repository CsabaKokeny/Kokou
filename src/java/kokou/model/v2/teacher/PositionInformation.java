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
@XmlType(propOrder = {"take", "retire", "change", "currentPosition"})
public class PositionInformation extends Entity {
    
    private Item take;
    private Item retire;
    private Item change;
    
    @XmlElement(name="take")
    public Item getTake() {
        if (this.take == null) {
            this.take = new Item();
        }
        return this.take;
    }
    public void setTake(Item take) {
        this.take = take;
    }
    
    @XmlElement(name="retire")
    public Item getRetire() {
        if (this.retire == null) {
            this.retire = new Item();
        }
        return this.retire;
    }
    public void setRetire(Item retire) {
        this.retire = retire;
    }
    
    @XmlElement(name="change")
    public Item getChange() {
        if (this.change == null) {
            this.change = new Item();
        }
        return this.change;
    }
    public void setChange(Item change) {
        this.change = change;
    }
    
    @XmlAccessorType(XmlAccessType.NONE)
    @XmlType(propOrder = {"content", "date"})
    public static class Item {
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
    
    private String currentPosition;
    @XmlElement(name="currentPosition")
    public String getCurrentPosition() {
        return this.currentPosition;
    }
    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }
}
