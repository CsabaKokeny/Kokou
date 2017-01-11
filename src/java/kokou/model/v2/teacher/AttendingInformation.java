/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2.teacher;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"transports", "duration", "totalCost", "driverCard"})
public class AttendingInformation extends Entity {
    
    private Float duration;
    @XmlElement(name="duration")
    public Float getDuration(){
        if (this.duration == null) {
            this.duration = 0f;
        }
        return this.duration;
    }
    public void setDuration(Float duration) {
        this.duration = duration;
    }
    
    private List<Transport> transports;
    @XmlElement(name="transport")
    public List<Transport> getTransports() {
        if (this.transports == null){
            this.transports = new ArrayList();
        }
        return this.transports;
    }
    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }
    
    private DriverCard driverCard;
    @XmlElement(name="driverCard")
    public DriverCard getDriverCard() {
        if (this.driverCard == null) {
            this.driverCard = new DriverCard();
        }
        return this.driverCard;
    }
    public void setDriverCard(DriverCard driverCard) {
        this.driverCard = driverCard;
    }
    
    @XmlElement(name="totalCost")
    public Float getTotalCost() {
        List<Transport> list = this.getTransports();
        Float cost = 0f;
        for (Transport item : list) {
            cost += item.getCost();
        }
        return cost * 20;
    }
}
