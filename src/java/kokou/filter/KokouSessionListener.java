/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.filter;

import java.io.File;
import javax.servlet.SessionTrackingMode;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author master
 */
public class KokouSessionListener implements HttpSessionListener, HttpSessionActivationListener{

    @Override
    public void sessionCreated(HttpSessionEvent se) {
       
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String sessionId = se.getSession().getId();
        String strRootDir  = se.getSession().getServletContext().getRealPath("/");
        strRootDir += "/reports/temp/"+sessionId;
        File rootDir = new File(strRootDir);
        deleteAll(rootDir);
    }
    
    public void deleteAll (File file) {
        if (!file.exists()) {
            return;
        }
        if (!file.isFile()) {
            file.delete();
        }
        File[] children = file.listFiles();
        for(File child : children) {
            deleteAll(child);
        }
        file.delete();
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {

    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {

    }
    
}
