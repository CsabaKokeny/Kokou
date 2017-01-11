/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType

@XmlAccessorType(XmlAccessType.NONE)
public class Date {
    
    @XmlElement(name="year")
    def Integer year
    @XmlElement(name="month")
    def Integer month
    @XmlElement(name="day")
    def Integer day
    
    def Date () {
        
    }
    
    def Date (Calendar c) {
        setValues(c)
    }
    
    def Date(String str) {
        setValue(str)
    }
    
    def getValue() {
        def clo = {v->v?v<10?"0${v}":"${v}":""}
        def gett = {y,m,d->"${clo(y)}/${clo(m)}/${clo(d)}"}
        gett(this.year, this.month, this.day)
    }
    
    def void setValue(value) {
        def calendar;
        if (value instanceof String) {
            try {
                calendar = Calendar.getInstance()
                calendar.setTime(java.sql.Date.valueOf(value.replaceAll("/", "-")))
            } catch (Exception ex) {
                println(ex)
            }
        } else {
            calendar = value
        }
        try {
            if (calendar) {
                year = calendar.get(Calendar.YEAR)
                month = calendar.get(Calendar.MONTH) + 1
                day = calendar.get(Calendar.DATE)
            }
        } catch (Exception ex) {
            println(ex)
        }
    }
    
    def String toString() {
        return this.getValue();
    }
}

