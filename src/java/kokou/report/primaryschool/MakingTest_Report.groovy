/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.primaryschool


import kokou.report.element.*
import kokou.report.StudentJasperReport

class MakingTest_Report {
    
    def JasperReport jasperReport;
    
    def MakingTest_Report() {
        jasperReport = new StudentJasperReport(
            name: "makingtest",
            columnHeader: new BandContainer(
                band: new Band(
                    height: 140,
                    elementList: [
                        new StaticText(
                            x:20, y:0, width:150, height:20, 
                            leftBorderWidth:1, rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:16, isBold:true,
                            text:"", align:"Center"
                        ),
                        new StaticText(
                            x:170, y:0, width:20, height:20, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"①", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:190, y:0, width:20, height:20, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:210, y:0, width:20, height:20, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"②", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:230, y:0, width:20, height:20, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:250, y:0, width:20, height:20, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"③", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:270, y:0, width:20, height:20, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:290, y:0, width:20, height:20, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"④",align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:310, y:0, width:20, height:20, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:330, y:0, width:20, height:20, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:350, y:0, width:20, height:20, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"⑤", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:370, y:0, width:20, height:20, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:390, y:0, width:20, height:20, 
                            rightBorderWidth:1, topBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"⑥", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:20, y:20, width:150, height:30, 
                            leftBorderWidth:1, rightBorderWidth:1,
                            topPadding: 5,
                            fontName:"MS PMincho", fontSize:16, isBold:true,
                            align:"Center",
                            text:"図工作品チェック表"
                            
                        ),
                        new TextField(
                            x:20, y:50, width:150, height:30, 
                            leftBorderWidth:1, rightBorderWidth:1,
                            topPadding: 5,
                            fontName:"MS PMincho", fontSize:16, isBold:true,
                            align:"Center",
                            expression:"\"締め切り\"+\$P{KOKOU_MONTH}+\"/\"+\$P{KOKOU_DAY}+\"（月）\""
                            
                        ),
                        new StaticText(
                            x:20, y:80, width:150, height:30, 
                            leftBorderWidth:1, rightBorderWidth:1,
                            topPadding: 5,
                            fontName:"MS PMincho", fontSize:16, isBold:true,
                            align:"Center",
                            text:"提\t出"
                        ),
                        new StaticText(
                            x:20, y:110, width:150, height:30, 
                            leftBorderWidth:1, rightBorderWidth:1, bottomBorderWidth:1,
                            topPadding: 5,
                            fontName:"MS PMincho", fontSize:16, isBold:true,
                            align:"Center",
                            text:""
                        ),
                        new StaticText(
                            x:170, y:20, width:20, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12,
                            text:"卜\nン\nボ\n・\n四\n切", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:190, y:20, width:20, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12,
                            text:""
                        ),
                        new StaticText(
                            x:210, y:20, width:20, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:10,
                            text:"未\n来\nの\nく\nら\nし\n・\n四\n切", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:230, y:20, width:20, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12,
                            text:""
                        ),
                        new StaticText(
                            x:250, y:20, width:20, height:90, 
                            rightBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12,
                            text:"お\n盆\nの\n思\nい\n出", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:250, y:110, width:20, height:30, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:8,
                            text:"四\nつ\n切", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:270, y:20, width:20, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12,
                            text:""
                        ),
                        new StaticText(
                            x:290, y:20, width:20, height:90, 
                            rightBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12,
                            text:"二\n科\n展", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:290, y:110, width:20, height:30, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:8,
                            text:"四\nつ\n切", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:310, y:20, width:20, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:14,
                            text:"出\n品\n料\n四\n百\n円", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:330, y:20, width:20, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12,
                            text:""
                        ),
                        new StaticText(
                            x:350, y:20, width:20, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12,
                            text:"み\nど\nり\nの\n絵\n・\n四\n切",align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:370, y:20, width:20, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12,
                            text:""
                        ),
                        new StaticText(
                            x:390, y:20, width:20, height:120, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12,
                            text:"33\n海\nと\n魚\n・\n四\n切",align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:412, y:2, width:130, height:125,
                            leftPadding: 5,
                            rightBorderWidth:1, bottomBorderWidth:1, leftBorderWidth:1, topBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12,
                            align:"Left", valign:"Middle",
                            text:"1) ニ科展出品料(400円)\n が,そろわない場合は、学級費で立て替えて下さい\n2) 必ず作品裏の記入サイズを確認して下さい。\n3) 作品数と提出確認数が合っているかを確認して下さい。"
                        )
                        
                    ]
                )
            ),
            detailList: [
                new Band(
                    height: 20, splitType:Band.STRETCH,
                    elementList:[
                         new TextField(
                            x:20, y:0, width:30, height:20, 
                            leftBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            expression:"\$F{rollNo}", align:"Center", valign:"Middle"
                        ),
                        new TextField(
                            x:50, y:0, width:60, height:20, 
                            bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            expression:"\$F{name}",  align:"Center", valign:"Middle"
                        ),
                        new TextField(
                            x:110, y:0, width:60, height:20, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"GulimChe", fontSize:12, isBold:true,
                            expression:"\$F{nameKr}", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:170, y:0, width:20, height:20, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:190, y:0, width:20, height:20, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:210, y:0, width:20, height:20, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:230, y:0, width:20, height:20, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:250, y:0, width:20, height:20, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:270, y:0, width:20, height:20, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:290, y:0, width:20, height:20, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"",align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:310, y:0, width:20, height:20, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:330, y:0, width:20, height:20, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:350, y:0, width:20, height:20, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                        new StaticText(
                            x:370, y:0, width:20, height:20, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:""
                        ),
                        new StaticText(
                            x:390, y:0, width:20, height:20, 
                            rightBorderWidth:1, bottomBorderWidth:1,
                            fontName:"MS PMincho", fontSize:12, isBold:true,
                            text:"", align:"Center", valign:"Middle"
                        ),
                    ]
                )
            ]
        )
    }
    
    def void output () {
        
    }
    
}

