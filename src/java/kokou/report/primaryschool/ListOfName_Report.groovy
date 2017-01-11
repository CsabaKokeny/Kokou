/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.primaryschool


import kokou.report.element.*
import kokou.report.StudentJasperReport

class ListOfName_Report {
    
    def JasperReport jasperReport;
    
    def ListOfName_Report() {
        jasperReport = new StudentJasperReport(
            name: "list_of_name",
            pageHeader: new BandContainer(
                band: new Band (
                    height: 21,
                    elementList: [
                        new StaticText(x:160, y:0, width:100, height:20, fontName:"MS PMincho", fontSize:12, isBold:true, text:"学年児童名簿"),
                        new StaticText(x:295, y:0, width:200, height:20, fontName:"MS PMincho", fontSize:12, isBold:true, text:"名前のところに○印をして下さい。",
                            box:new Box( 
                                bottomPen: new Pen(
                                    lineWidth:1f,
                                    lineStyle:"Dashed"
                                )
                            )
                        )
                    ]
                )
            ),
            columnHeader: new BandContainer(
                band: new Band(
                    height: 21,
                    elementList: [
                        new StaticText(x:50, y:0, width:60, height:20, fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true, text:"学年番号"),
                        new StaticText(x:115, y:0, width:30, height:20, fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true, text:"氏名"),
                        new StaticText(x:160, y:0, width:100, height:20, fontName:"MS PMincho", fontSize:12, isBold:true, isUnderline:true, text:"ハングル氏名")
                    ]
                )
            ),
            detailList: [
                new Band(
                    height: 20, splitType:Band.STRETCH,
                    elementList:[
                        new TextField(
                            x: 50, y: 0, width: 25, height: 20, leftPadding: 5,
                            valign: "Middle", fontName:"MS PMincho", fontSize:10, isBold: true,
                            expression:"\$F{rollNo}",
                            leftBorderWidth: 1, topBorderWidth:1, rightBorderWidth:1, bottomBorderWidth:1
                        ),
                        new TextField(
                            x: 75, y: 0, width: 80, height: 20, leftPadding: 5,
                            valign: "Middle", fontName:"MS PMincho", fontSize:10, isBold: true,
                            expression:"\$F{name}",
                            topBorderWidth:1, bottomBorderWidth:1
                        ),
                        new TextField(
                            x: 155, y: 0, width: 100, height: 20, leftPadding: 5,
                            valign: "Middle", fontName:"DotumChe", fontSize:10, isBold: true,
                            expression:"\$F{nameKr}",
                            topBorderWidth:1, bottomBorderWidth:1, rightBorderWidth:1
                        ),
                        new StaticText(
                            x: 255, y: 0, width: 70, height: 20, text:"",
                            fontName:"MS PMincho", fontSize:12, isBold: true,
                            topBorderWidth:1, rightBorderWidth:1, bottomBorderWidth:1
                        )
                    ]
                )
            ]
        )
    }
    
    def void output () {
        
    }
    
}

