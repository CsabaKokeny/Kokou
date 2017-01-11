/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.primaryschool


import kokou.report.element.*
import kokou.report.StudentJasperReport

class Mangsomul_Report {
    
    def JasperReport jasperReport;
    
    def Mangsomul_Report() {
        jasperReport = new StudentJasperReport(
            name: "mangsomul",
            columnHeader: new BandContainer(
                band: new Band(
                    height: 145,
                    elementList: [
                        new StaticText(
                            x:20, y:0, width:170, height:25, 
                            leftBorderWidth:1, rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:16, isBold:true,
                            text:"", align:"Center"
                        ),
                        new StaticText(
                            x:190, y:0, width:25, height:25, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:215, y:0, width:25, height:25, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:240, y:0, width:25, height:25, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:265, y:0, width:25, height:25, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:290, y:0, width:25, height:25, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:315, y:0, width:25, height:25, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:340, y:0, width:25, height:25, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"",align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:365, y:0, width:25, height:25, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:390, y:0, width:25, height:25, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:415, y:0, width:25, height:25, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:440, y:0, width:25, height:25, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:465, y:0, width:25, height:25, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:20, y:25, width:170, height:120, 
                            leftBorderWidth:1, rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:16, isBold:true,
                            text:"", align:"Center"
                        ),
                        new StaticText(
                            x:190, y:25, width:25, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:215, y:25, width:25, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:240, y:25, width:25, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:265, y:25, width:25, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:290, y:25, width:25, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:315, y:25, width:25, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:340, y:25, width:25, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"",align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:365, y:25, width:25, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:390, y:25, width:25, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:415, y:25, width:25, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:440, y:25, width:25, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:465, y:25, width:25, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        )
                    ]
                )
            ),
            detailList: [
                new Band(
                    height: 25, splitType:Band.STRETCH,
                    elementList:[
                        new TextField(
                            x:20, y:0, width:30, height:25, 
                            leftBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:10, isBold:true,
                            expression:"\$F{rollNo}", align:"Center", valign:"Middle"
                        ),
                        new TextField(
                            x:50, y:0, width:140, height:25, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:10, isBold:true,
                            expression:"\$F{name}", align:"Left", valign:"Middle"
                        ),
                        new StaticText(
                            x:190, y:0, width:25, height:25, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:215, y:0, width:25, height:25, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:240, y:0, width:25, height:25, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:265, y:0, width:25, height:25, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:290, y:0, width:25, height:25, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:315, y:0, width:25, height:25, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:340, y:0, width:25, height:25, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"",align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:365, y:0, width:25, height:25, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:390, y:0, width:25, height:25, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:415, y:0, width:25, height:25, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:440, y:0, width:25, height:25, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:465, y:0, width:25, height:25, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        )
                    ]
                )
            ]
        )
    }
    
    def void output () {
        
    }
    
}

