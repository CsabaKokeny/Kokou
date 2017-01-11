/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jasper.exportmanager;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;

/**
 *
 * @author master
 */
public class RtfExportManager extends AbstractJasperDesignExportManager{

    @Override
    public Class<? extends JRExporter> getExporterClass() {
        return JRRtfExporter.class;
    }
    
}
