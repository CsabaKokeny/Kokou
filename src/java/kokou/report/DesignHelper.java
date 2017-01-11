/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report;

import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JRDesignVariable;

/**
 *
 * @author master
 */
public class DesignHelper {
    
    static public JRDesignQuery  createQuery(String language, String text) {
        JRDesignQuery query = new JRDesignQuery();
        query.setLanguage(language);
        query.setText(text);
        return query;
    }
    static public JRDesignVariable createVariable(String name, Class clazz, String initExpression, String variableExpression) {
        JRDesignVariable v;
        JRDesignExpression ex;
        v = new JRDesignVariable();
        v.setName(name);
        v.setValueClass(clazz);
        if (initExpression != null) {
            ex = new JRDesignExpression();
            ex.setText(initExpression);
            v.setInitialValueExpression(ex);
        }
        if (variableExpression != null) {
            ex = new JRDesignExpression();
            ex.setText(variableExpression);
            v.setExpression(ex);
        }
        return v;
    }
    
    static public JRDesignField createField(String name, Class clazz, String description) {
        JRDesignField field = new JRDesignField();
        field.setName(name);
        field.setValueClass(clazz);
        field.setDescription(description);
        return field;
    }
}
