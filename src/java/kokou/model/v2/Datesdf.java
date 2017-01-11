/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"year", "month", "day"})
public class Datesdf extends Object{
    
    private Integer year, month, day;
            
    
    public Datesdf() {
        super();
    }
    
    public Datesdf(Calendar c) {
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        day = c.get(Calendar.DATE);
    }
    
    public Datesdf(String value) {
        super();
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(java.sql.Date.valueOf(value.replaceAll("/", "-")));
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH) + 1;
            day = c.get(Calendar.DATE);
        } catch (Exception ex) {
            
        }
    }
    
    public String getValue() {
        StringBuilder builder = new StringBuilder();
        if (year != null) {
            builder.append(year);
        }
        if (month!=null && month>0 && month<13) {
            builder.append("/");
            if (month<10) {
                builder.append(0);
            }
            builder.append(month);
        }
        if (day != null && day>0 && day<32) {
            builder.append("/");
            if (day < 10) {
                builder.append(0);
            }
            builder.append(day);
        }
        return builder.toString();
    }
        
    public void setValue(String value) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(java.sql.Date.valueOf(value.replaceAll("/", "-")));
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH) + 1;
            day = c.get(Calendar.DATE);
        } catch (Exception ex) {
            year = null;
            month = null;
            day = null;
        }
    }
    
    @XmlElement(name="year")
    public Integer getYear() {
        return this.year;
    }
    
    
    @XmlElement(name="month")
    public Integer getMonth() {
        return this.month;
    }
    
    
    @XmlElement(name="day")
    public Integer getDay() {
        return this.day;
    }
    
    @Override
    public String toString() {
        return this.getValue();
    }
    
    /*
    public static Date getNewInstance() {
        return new GeneralDatesdf();
    }*/
}
