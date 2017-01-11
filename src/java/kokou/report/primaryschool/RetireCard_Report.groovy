/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.primaryschool

import kokou.report.element.*
import kokou.report.StudentJasperReport

class RetireCard_Report extends ReportForCard1_JP {
    
    def RetireCard_Report(){
        super()
    }
    
    def getName() {
        return "entercard_jp"
    }
    
    def getCardName() {
        return "建小退証"
    }
    def getTitle() {
        return "退 学 証 明 書"
    }
    
    def createDetailList() {
        return [
            new Band(
                height: 185,
                elementList: [
                    new TextField(
                        x:0, y:0, width:555, height:120,
                        leftPadding:50, isBold:true,
                        align:"Left", valign:"Bottom",
                        fontName:"MS PMincho", fontSize:24,
                        expression: "\"上記のものは  \"+\$P{KOKOU_YEAR}+\"年  \"+\$P{KOKOU_MONTH}+\"月\"+\$P{KOKOU_DAY}+\"日付けで\\n\\n本校\"+\$F{schoolYear}+\"学年を退学したことを証明します\\n\""
                    ),
                   new StaticText(
                        x:0, y:120, width:555, height:60,
                        leftPadding:55, isBold:true,
                        align:"Left", valign:"Top",
                        fontName:"MS PMincho", fontSize:20,
                        text: "(合わせて,独立行政法人日本スポーツ振興センター\n\nに加入していることを証明します）"
                    ),
                    new Break(y:181)
                ]
            )
        ]
    }
}

