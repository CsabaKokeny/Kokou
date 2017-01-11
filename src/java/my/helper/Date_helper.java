/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.helper;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author master
 */
public class Date_helper {
    
    public static String getDateString(String date) {
        try {
             Calendar c = Calendar.getInstance();
             c.setTime(Date.valueOf(date.replaceAll("/", "-")));
            return String.format("%1$tY/%1$tm/%1$td",c);
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return date;
    }
}
