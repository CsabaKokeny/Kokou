/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.primaryschool


import kokou.report.element.*
import kokou.report.StudentJasperReport

class PersonalNo_Report {
    
    def JasperReport jasperReport;
    
    def PersonalNo_Report() {
        jasperReport = new StudentJasperReport(
            name: "personalno",
            detailList: [
                new Band(
                    height: 250, splitType:Band.STRETCH,
                    elementList:[
                        new StaticText(
                            x:30, y:0, width:200, height:35, 
                            leftPadding:20,
                            fontName:"MS PMincho", fontSize:30, isBold:true,
                            valign: "Bottom",
                            text:"個人番号票"),
                        new TextField(
                            x:230, y:0, width:285, height:35,
                            leftPadding:20, bottomPadding:5,
                            fontName:"MS PMincho", fontSize:30, isBold:true,
                            valign: "Bottom", align: "Center",
                            expression:"\$F{name}"),
                        new StaticText(
                            x:10, y:50, width:120, height:70,
                            leftBorderWidth: 1, rightBorderWidth: 1, topBorderWidth: 1, bottomBorderWidth: 1,
                            fontName:"MS PMincho", fontSize:24, isBold:true,
                            valign: "Middle", align:"Center",
                            text:"学校名"),
                        new StaticText(
                            x:130, y:50, width:55, height:70,
                            rightBorderWidth: 1, topBorderWidth: 1, bottomBorderWidth: 1,
                            fontName:"MS PMincho", fontSize:24, isBold:true,
                            valign: "Middle", align:"Center",
                            text:"組"),
                        new StaticText(
                            x:185, y:50, width:110, height:70,
                            rightBorderWidth: 1, topBorderWidth: 1, bottomBorderWidth: 1,
                            fontName:"MS PMincho", fontSize:24, isBold:true,
                            valign: "Middle", align:"Center",
                            text:"出席番号"),
                        new StaticText(
                            x:295, y:50, width:55, height:70,
                            rightBorderWidth: 1, topBorderWidth: 1, bottomBorderWidth: 1,
                            fontName:"MS PMincho", fontSize:24, isBold:true,
                            valign: "Middle", align:"Center",
                            text:"男女"),
                        new StaticText(
                            x:350, y:50, width:165, height:70,
                            rightBorderWidth: 1, topBorderWidth: 1, bottomBorderWidth: 1,
                            fontName:"MS PMincho", fontSize:24, isBold:true,
                            valign: "Middle", align:"Center",
                            text:"個人番号"),
                        new StaticText(
                            x:10, y:120, width:120, height:70,
                            leftBorderWidth: 1, rightBorderWidth: 1, bottomBorderWidth: 1,
                            fontName:"MS PMincho", fontSize:24, isBold:true,
                            valign: "Middle", align:"Center",
                            text:"建国小学校"),
                        new TextField(
                            x:130, y:120, width:55, height:70,
                            rightBorderWidth: 1, bottomBorderWidth: 1,
                            fontName:"MS PMincho", fontSize:24, isBold:true,
                            valign: "Middle", align:"Center",
                            expression:"\$F{className}"),
                         new TextField(
                            x:185, y:120, width:110, height:70,
                            rightBorderWidth: 1, bottomBorderWidth: 1,
                            fontName:"MS PMincho", fontSize:24, isBold:true,
                            valign: "Middle", align:"Center",
                            expression:"\$F{rollNo}"),
                        new TextField(
                            x:295, y:120, width:55, height:70,
                            rightBorderWidth: 1, bottomBorderWidth: 1,
                            fontName:"MS PMincho", fontSize:24, isBold:true,
                            valign: "Middle", align:"Center",
                            expression:""),
                        new TextField(
                            x:350, y:120, width:55, height:70,
                            rightBorderWidth: 1, bottomBorderWidth: 1,
                            fontName:"MS PMincho", fontSize:24, isBold:true,
                            valign: "Middle", align:"Center",
                            expression:""),
                        new TextField(
                            x:405, y:120, width:110, height:70,
                            rightBorderWidth: 1, bottomBorderWidth: 1,
                            fontName:"MS PMincho", fontSize:24, isBold:true,
                            valign: "Middle", align:"Center",
                            expression:"\$F{rollNo}"),
                        new Break(
                            y: 200
                        )
                    ]
                )
            ]
        )
    }
    
    def void output () {
        
    }
    
}

