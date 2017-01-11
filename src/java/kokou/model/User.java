/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model;

/**
 *
 * @author master
 */
public class User {
    private Integer id = null;
    private Integer teacherId = null;
    private String username;
    private String password;
    private String repassword;
    
     public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getUserId() {
        return this.getId();
    }
    
    public void setUserId(Integer userId) {
        this.setId(userId);
    }
    
    public String getUsername() {
        if (this.username == null) {
            this.username = "";
        }
        return this.username;
    }
    public void setUsername(String username) {
        if (username != null) {
            username = username.trim();
        }
        this.username = username;
    }
    
    public String getPassword() {
        if (this.password == null) {
            this.password = "";
        }
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRepassword() {
        if (this.repassword == null) {
            this.repassword = "";
        }
        return this.repassword;
    }
    
    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
    
    public Integer getTeacherId() {
        return this.teacherId;
    }
    
    public void setTeacherId(Integer teacherId) {
        this.teacherId  = teacherId;
    }
}
