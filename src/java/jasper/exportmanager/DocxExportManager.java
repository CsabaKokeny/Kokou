/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jasper.exportmanager;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;

/**
 *
 * @author master
 */
public class DocxExportManager extends AbstractJasperDesignExportManager {

    @Override
    public Class<? extends JRExporter> getExporterClass() {
        return JRDocxExporter.class;
    }
    
}
