/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.preschool

import kokou.report.element.*
import kokou.report.StudentJasperReport
/**
 *
 * @author master
 */
class ListOfResearch_Report {
    
    def JasperReport jasperReport;
    
    def ListOfResearch_Report() {
        jasperReport = new StudentJasperReport(
            name: "list_of_research_data",
            pageWidth: 842,
            pageHeight: 595,
            columnWidth: 802,
            orientation: "Landscape",
            columnHeader: new BandContainer(
                band: new Band(
                    height: 39,
                    elementList: [
                        new StaticText(x:11, y:16, width:58, height:22, fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true, text:"学年"),
                        new StaticText(x:71, y:16, width:92, height:22, fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true, text:"学年番号"),
                        new StaticText(x:156, y:16, width:82, height:22, fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true, text:"氏名"),
                        new StaticText(x:313, y:16, width:41, height:22, fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true, text:"性別"),
                        new StaticText(x:420, y:16, width:55, height:22, fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true, text:"生年月日"),
                        new StaticText(x:497, y:16, width:82, height:22, fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true, text:"住所")
                    ]
                )
            ),
            detailList: [
                new Band(
                    height: 23, splitType:Band.STRETCH,
                    elementList:[
                        new TextField(
                            x: 11, y: 0, width: 58, height: 20, leftPadding: 10,
                            valign: "Middle", fontName:"MS PMincho", fontSize:12, isBold: true,
                            expression:"\$V{KOKOU_SCHOOL_YEAR}"
                        ),
                        new TextField(
                            x: 71, y: 0, width: 82, height: 20, leftPadding: 10,
                            valign: "Middle", fontName:"MS PMincho", fontSize:12, isBold: true,
                            expression:"\$V{KOKOU_NO}.toString()"
                        ),
                        new TextField(
                            x: 153, y: 0, width: 160, height: 20, leftPadding: 10,
                            valign: "Middle", fontName:"MS PMincho", fontSize:12, isBold: true,
                            expression:"\$F{name}"
                        ),
                        new TextField(
                            x: 313, y: 0, width: 41, height: 20, leftPadding: 10,
                            valign: "Middle", fontName:"MS PMincho", fontSize:12, isBold: true,
                            expression:"\$V{KOKOU_SEX}"
                        ),
                        new TextField(
                            x: 420, y: 0, width: 70, height: 20, leftPadding: 10,
                            valign: "Middle", fontName:"MS PMincho", fontSize:12, isBold: true,
                            expression:"\$V{KOKOU_SHORT_BIRTHDAY}"
                        ),
                        new TextField(
                            x: 497, y: 0, width: 305, height: 20, leftPadding: 10,
                            valign: "Middle", fontName:"MS PMincho", fontSize:12, isBold: true,
                            expression:"\$F{address}"
                        )
                    ]
                )
            ]
        )
    }
    
    def void output () {
        
    }
    
}

