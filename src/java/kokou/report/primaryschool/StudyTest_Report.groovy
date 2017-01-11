/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.primaryschool


import kokou.report.element.*
import kokou.report.StudentJasperReport

class StudyTest_Report {
    
    def JasperReport jasperReport;
    
    def StudyTest_Report() {
        jasperReport = new StudentJasperReport(
            name: "studytest",
            columnHeader: new BandContainer(
                band: new Band(
                    height: 21,
                    elementList: [
                        
                        new StaticText(
                            x:30, y:0, width:50, height:20, 
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"学年", align: "Right"
                        ),
                        new StaticText(
                            x:80, y:0, width:60, height:20,
                            leftPadding:5,
                            fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true,
                            text:"学年番号", align: "Left"
                        ),
                        new StaticText(
                            x:140, y:0, width:70, height:20,
                            leftPadding:5,
                            fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline: true,
                            text:"氏名", align: "Left"
                        ),
                        new StaticText(
                            x:210, y:0, width:120, height:20,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"児童名フリガナ", align: "Left"
                        ),
                        new StaticText(
                            x:330, y:0, width:30, height:20,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"性別", align: "Center"
                        )
                    ]
                )
            ),
            detailList: [
                new Band(
                    height: 20, splitType:Band.STRETCH,
                    elementList:[
                         new TextField(
                            x:30, y:0, width:50, height:20, 
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            expression:"\$F{schoolYear}", align: "Left", valign:"Bottom"
                        ),
                        new TextField(
                            x:80, y:0, width:40, height:20,
                            leftPadding:5,
                            fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true,
                            expression:"\$F{rollNo}", align: "Center", valign:"Bottom"
                        ),
                        new TextField(
                            x:120, y:0, width:90, height:20,
                            fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline: true,
                            expression:"\$F{name}", align: "Left", valign:"Bottom"
                        ),
                        new TextField(
                            x:210, y:0, width:120, height:20,
                            leftPadding:5,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            expression:"", align: "Left", valign:"Bottom"
                        ),
                        new TextField(
                            x:330, y:0, width:30, height:20,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            expression:"\$F{sex}", align: "Center", valign:"Bottom"
                        )
                    ]
                )
            ]
        )
    }
    
    def void output () {
        
    }
    
}

