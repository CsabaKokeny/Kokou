/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.primaryschool


import kokou.report.element.*
import kokou.report.StudentJasperReport

class ReportForCard1_JP {
    
    def JasperReport jasperReport;
    
    def createCardNoField(Integer nLeft,String sPrefix) {
        def nTop=0, nHeight = 40, nPrefixWidth = 150, nFontSize = 20, sFontName="MS PMincho"
        def List elements = [
            new StaticText(
                x:nLeft, y:nTop, width: nPrefixWidth, height:nHeight,
                align:"Right", valign:"Bottom",
                fontName:sFontName, fontSize:nFontSize, isBold:true,
                text:sPrefix
            ),
            new StaticText(
                x:nLeft+nPrefixWidth, y:nTop, height:nHeight,width: 35,
                align:"Left", valign:"Bottom",
                fontName:sFontName, fontSize:nFontSize, isBold: true,
                text:"第"
            ),
            new TextField(
                x:nLeft+nPrefixWidth+35, y:nTop, height:nHeight,width: 35,
                align:"Center", valign:"Bottom",
                fontName:sFontName, fontSize:nFontSize, isBold: true,
                expression:"\$F{cardNo}"
            ),
            new StaticText(
                x:nLeft+nPrefixWidth+70, y:nTop, height:nHeight,width: 35,
                align:"Right", valign:"Bottom",
                fontName:sFontName, fontSize:nFontSize, isBold: true,
                text:"号"
            )
        ]
        return elements
    }
    
    def createTitleField(Integer nTop, String sTitle) {
        def nWidth = 555, nHeight = 50, nFontSize = 30, sFontName="MS PMincho"
        return [
            new StaticText(
                x:0, y:nTop, width: nWidth, height:nHeight,
                align:"Center", valign:"Bottom",
                fontName:sFontName, fontSize:nFontSize, isBold:true,
                text:sTitle
            ),
        ]
    }
    
    def createNameField(Integer nLeft, Integer nTop) {
        def nHeight=40, sFontName="MS PMincho", nFontSize=24
        def nLabelWidth=60, nFieldWidth=250
        return [
            new StaticText(
                x:nLeft, y:nTop, width: nLabelWidth, height:nHeight,
                align:"Left", valign:"Bottom",
                fontName:sFontName, fontSize:nFontSize, isBold:true,
                text: "氏名"
            ),
            new TextField(
                x:nLeft+nLabelWidth+20, y:nTop, width:nFieldWidth, height:nHeight,
                align:"Left", valign:"Bottom",
                fontName:sFontName, fontSize:nFontSize, isBold:true,
                expression: "\$F{name}"
            )
        ]
    }
    
    def createDateField(String yearExpression, String monthExpression, String dayExpression, Integer nLeft, Integer nTop, String sFontName, Integer nFontSize, Integer nYearFieldWidth, Integer nFieldWidth, Integer nFieldHeight, Integer nLabelWidth) {
        def nMonthFieldWidth = nFieldWidth, nDayFieldWidth = nMonthFieldWidth, nHeight = nFieldHeight
        return [
            new TextField(
                x:nLeft, y:nTop, width: nYearFieldWidth, height: nHeight,
                align:"Right", valign:"Bottom",
                fontName:sFontName, fontSize:nFontSize, isBold:true,
                expression:"${yearExpression}"
            ),
            new StaticText(
                x:nLeft+nYearFieldWidth, y:nTop, width: nLabelWidth, height: nHeight,
                align:"Left", valign:"Bottom",
                fontName:sFontName, fontSize:nFontSize, isBold:true,
                text:"年"
            ),
            new TextField(
                x:nLeft+nYearFieldWidth+nLabelWidth, y:nTop, width: nMonthFieldWidth, height: nHeight,
                align:"Right", valign:"Bottom",
                fontName:sFontName, fontSize:nFontSize, isBold:true,
                expression:"${monthExpression}"
            ),
            new StaticText(
                x:nLeft+nYearFieldWidth+nLabelWidth+nMonthFieldWidth, y:nTop, width: nLabelWidth, height: nHeight,
                align:"Left", valign:"Bottom",
                fontName:sFontName, fontSize:nFontSize, isBold:true,
                text:"月"
            ),
            new TextField(
                x:nLeft+nYearFieldWidth+nLabelWidth+nMonthFieldWidth+nLabelWidth, y:nTop, width: nDayFieldWidth, height: nHeight,
                align:"Right", valign:"Bottom",
                fontName:sFontName, fontSize:nFontSize, isBold:true,
                expression:"${dayExpression}"
            )
        ]
    }
    def createBirthdayField(Integer nLeft,Integer nTop) {
        def nYearFieldWidth=100, nFieldWidth = 45, nHeight=45, nLabelWidth=35
        def sFontName="MS PMincho", nFontSize=24
        def elements = createDateField("\$F{birthdayYear}","\$F{birthdayMonth}","\$F{birthdayDay}",nLeft, nTop, sFontName, nFontSize, nYearFieldWidth, nFieldWidth, nHeight, nLabelWidth)
        elements.add(new StaticText(
            x:nLeft+nYearFieldWidth+nLabelWidth+nFieldWidth+nLabelWidth+nFieldWidth, y:nTop, width: nLabelWidth, height: nHeight,
            align:"Left", valign:"Bottom",
            fontName:sFontName, fontSize:nFontSize, isBold:true,
            text:"日"
        ))
        elements.add(new StaticText(
            x:nLeft+nYearFieldWidth+nLabelWidth+nFieldWidth+nLabelWidth+nFieldWidth+nLabelWidth, y:nTop, width: nLabelWidth, height: nHeight,
            align:"Right", valign:"Bottom",
            fontName:sFontName, fontSize:nFontSize+1, isBold:true,
            text:"生"
        ))
        return elements
    }
    
    def createCurrentDateField(Integer nLeft, nTop) {
        def nYearFieldWidth=80, nHeight = 40, sFontName="MS PMincho", nFontSize=20
        def nFieldWidth = 30,nLabelWidth = 20
        def elements = createDateField("\$P{KOKOU_YEAR}","\$P{KOKOU_MONTH}","\$P{KOKOU_DAY}",nLeft, nTop, sFontName, nFontSize,nYearFieldWidth,nFieldWidth,nHeight,nLabelWidth)
        elements.add(new StaticText(
            x:nLeft+nYearFieldWidth+nLabelWidth+nFieldWidth+nLabelWidth+nFieldWidth, y:nTop, width: nLabelWidth, height: nHeight,
            align:"Left", valign:"Bottom",
            fontName:sFontName, fontSize:nFontSize, isBold:true,
            text:"日"
        ))
        return elements
    }
    
    def createPageHeader(String sHeaderText, String sTitle) {
        def elements = [];
        elements.addAll(createCardNoField(250,sHeaderText))
        elements.addAll(createTitleField(50,sTitle))
        elements.addAll(createNameField(155,130))
        elements.addAll(createBirthdayField(210,190))
        return new BandContainer(
            band: new Band(
                height: 260,
                elementList: elements
            )
        )
    }
    
    def createPageFooter() {
        def elements = []        
        elements.addAll(createCurrentDateField(250,0))
        elements.addAll([
            new StaticText(
                x:0, y:80, width:555, height:50,
                align:"Center", valign:"Bottom",
                fontName:"MS PMincho", fontSize:24, isBold:true,
                text:"学校法人  白頭学院  建国小学校"
            ),
            new StaticText(
                x:0, y:130, width:555, height:60,
                align:"Center", valign:"Bottom",
                fontName:"MS PMincho", fontSize:20, isBold:true,
                text:"〒558-0032  大阪市住吉区遠里小野2 丁目3-13"
            ),
            new StaticText(
                x:0, y:190, width:555, height:30,
                align:"Center", valign:"Bottom",
                fontName:"MS PMincho", fontSize:20, isBold:true,
                text:"電話番号  (06)  6691-1231  (代)"
            ),
            new StaticText(
                x:0, y:220, width:555, height:60,
                align:"Center", valign:"Bottom",
                fontName:"MS PMincho", fontSize:30, isBold:true,
                text:"校長　　李　　光　　衡"
            )
        ])
        return new BandContainer(
            band: new Band(
                height:290,
                elementList: elements
            )
        )
    }
    
    def ReportForCard1_JP() {
        jasperReport = new StudentJasperReport(
            name:getName(),
            pageHeader: createPageHeader(this.getCardName(),this.getTitle()),
            detailList: createDetailList(),
            pageFooter: createPageFooter()
        )
    }
    
    def void output () {
        
    }
    
    def getName(){}
    def getCardName(){}
    def getTitle(){}
    def createDetailList(){}
    
    
}

