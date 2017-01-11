/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "no", "sector", "sectorLabel", "startStation", "endStation", "type", "typeLabel", "cost"})
public class Transport extends Entity {
    
    private String sector;
    private String fromStation;
    private String toStation;
    private String type;
    private Float cost;
    
    private String sectorLabel;
    private String typeLabel;
    
    @XmlElement(name="no")
    public String getNo() {
        return getSectorLabel();
    }
    public void setNo(String no) {
        setSectorLabel(no);
    }
    
    @XmlElement(name="sector")
    public String getSector() {
        return this.sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
    
    @XmlElement(name="sectorLabel")
    public String getSectorLabel() {
        return this.sectorLabel;
    }
    public void setSectorLabel(String sectorLabel) {
        this.sectorLabel = sectorLabel;
    }
    
    @XmlElement(name="startStation")
    public String getStartStation() {
        return this.fromStation;
    }
    public void setStartStation(String fromStation) {
        this.fromStation = fromStation;
    }
    
    @XmlElement(name="endStation")
    public String getEndStation() {
        return this.toStation;
    }
    public void setEndStation(String toStation) {
        this.toStation = toStation;
    }
    
    @XmlElement(name="type")
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    @XmlElement(name="typeLabel")
    public String getTypeLabel() {
        return this.typeLabel;
    }
    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }
    
    @XmlElement(name="cost")
    public Float getCost() {
        if (this.cost == null) {
            this.cost = 0f;
        }
        return this.cost;
    }
    public void setCost(Float cost) {
        this.cost = cost;
    }
    
}
