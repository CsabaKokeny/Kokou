/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**

 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"id"})
public class Entity extends Object{
    
    private Integer id;
    private Date createTime;
    private Date updateTime;
    private Long timestamp;
    private Integer sort;
    
    @XmlElement(name="id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Date getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getUpdateTime() {
        return this.updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public Long getTimestamp() {
        return this.timestamp;
    }
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    
    public Integer getSort() {
        return this.sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
