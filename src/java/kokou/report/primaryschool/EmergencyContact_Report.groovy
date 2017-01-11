/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.primaryschool


import kokou.report.element.*
import kokou.report.StudentJasperReport

class EmergencyContact_Report {
    
    def JasperReport jasperReport;
    
    def EmergencyContact_Report() {
        jasperReport = new StudentJasperReport(
            name: "emergencycontact",
            orientation:"Landscape",
            pageWidth:842,pageHeight:595,columnWidth:802,
            columnHeader: new BandContainer(
                band: new Band(
                    height: 21,
                    elementList: [
                        
                        new StaticText(
                            x:5, y:0, width:30, height:20, 
                            fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true,
                            text:"学年", align: "Center"
                        ),
                        new StaticText(
                            x:35, y:0, width:70, height:20,
                            leftPadding:5,
                            fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true,
                            text:"学年番号", align: "Left"
                        ),
                        new StaticText(
                            x:105, y:0, width:70, height:20,
                            leftPadding:5,
                            fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline: true,
                            text:"氏名", align: "Left"
                        ),
                        new StaticText(
                            x:175, y:0, width:70, height:20,
                            fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true,
                            text:"ハングル氏名", align: "Left"
                        ),
                        new StaticText(
                            x:245, y:0, width:30, height:20,
                            fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true,
                            text:"性別", align: "Center"
                        ),
                        new StaticText(
                            x:275, y:0, width:110, height:20,
                            leftPadding:10,
                            fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true,
                            text:"雷話番号", align: "Left"
                        ),
                        new StaticText(
                            x:385, y:0, width:250, height:20,
                            leftPadding:10,
                            fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true,
                            text:"携帯番号", align: "Left"
                        ),
                        new StaticText(
                            x:635, y:0, width:150, height:20,
                            leftPadding:10,
                            fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true,
                            text:"住所", align: "Left"
                        )
                    ]
                )
            ),
            detailList: [
                new Band(
                    height: 25, splitType:Band.STRETCH,
                    elementList:[
                        new TextField(
                            x:5, y:0, width:30, height:20, 
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            expression:"\$F{schoolYear}", align: "Center", valign:"Bottom"
                        ),
                        new TextField(
                            x:35, y:0, width:30, height:20,
                            leftPadding: 5,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            expression:"\$F{rollNo}", align: "Left", valign:"Bottom"
                        ),
                        new TextField(
                            x:65, y:0, width:80, height:20,
                            leftPadding:5,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            expression:"\$F{name}", align: "Left",valign:"Bottom"
                        ),
                        new TextField(
                            x:145, y:0, width:100, height:20,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            expression:"\$F{nameKr}", align: "Left",valign:"Bottom"
                        ),
                        new TextField(
                            x:245, y:0, width:30, height:20,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            expression:"\$F{sex}", align: "Center",valign:"Bottom"
                        ),
                        new TextField(
                            x:275, y:0, width:110, height:20,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            expression:"\$F{phoneNo}", align: "Left",valign:"Bottom"
                        ),
                        new TextField(
                            x:385, y:0, width:215, height:20,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            expression:"\$F{emergencyContact}", align: "Left",valign:"Bottom"
                        ),
                        new TextField(
                            x:600, y:0, width:200, height:20,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            expression:"\$F{address}", align: "Left",valign:"Bottom"
                        )
                    ]
                )
            ]
        )
    }
    
    def void output () {
        
    }
    
}

