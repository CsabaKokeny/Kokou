/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.primaryschool

import kokou.report.element.*
import kokou.report.StudentJasperReport

class BeingInSchoolCard_Report extends ReportForCard1_JP {
    
    def BeingInSchoolCard_Report(){
        super()
    }
    
    def getName() {
        return "beinginschoolcard_jp"
    }
    
    def getCardName() {
        return "建小在証"
    }
    def getTitle() {
        return "在 学 証 明 書"
    }
    
    def createDetailList() {
        return [
            new Band(
                height: 150,
                elementList: [
                    new TextField(
                        x:0, y:0, width:555, height:140,
                        leftPadding:50, topPadding:50, isBold:true,
                        align:"Left", fontName:"MS PMincho", fontSize:24,
                        expression: "\"上記のものは  \"+\$P{KOKOU_YEAR}+\"年  \"+\$P{KOKOU_MONTH}+\"月本校  \"+\$F{schoolYear}+\"  学年に\\n\\n在学中であることを証明します\""
                    ),
                    new Break(y:91)
                ]
            )
        ]
    }
}

