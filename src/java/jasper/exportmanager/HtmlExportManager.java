/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jasper.exportmanager;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;

/**
 *
 * @author master
 */
public class HtmlExportManager extends AbstractJasperDesignExportManager{

    @Override
    public Class<? extends JRExporter> getExporterClass() {
        return JRHtmlExporter.class;
    }
    
}
