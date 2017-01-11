/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report

import javax.xml.bind.annotation.*
import kokou.report.element.*
import java.util.List
/**
 *
 * @author master
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="jasperReport")
class StudentJasperReport extends JasperReport {
    
    def StudentJasperReport() {
        queryString = new QueryString(
            language: "xPath", value: "/root/student"
        )
        parameterList = [
            new Parameter(name:"KOKOU_CURRENT_CALENDAR", className:"java.util.Calendar", defaultValueExpression:"java.util.Calendar.getInstance()"),
            new Parameter(name:"KOKOU_BIRTHDAY_DELIMETER", className:"java.lang.String", defaultValueExpression:"\"${birthdayDelimeter}\""),
            new Parameter(name:"KOKOU_KEEPER_BIRTHDAY_DELIMETER", className:"java.lang.String", defaultValueExpression:"\"${keeperBirthdayDelimeter}\""),
            new Parameter(name:"KOKOU_YEAR", className:"java.lang.String", defaultValueExpression:"String.valueOf(\$P{KOKOU_CURRENT_CALENDAR}.get(java.util.Calendar.YEAR))"),
            new Parameter(name:"KOKOU_MONTH", className:"java.lang.String", defaultValueExpression:"String.valueOf(\$P{KOKOU_CURRENT_CALENDAR}.get(java.util.Calendar.MONTH)+1)"),
            new Parameter(name:"KOKOU_DAY", className:"java.lang.String", defaultValueExpression:"String.valueOf(\$P{KOKOU_CURRENT_CALENDAR}.get(java.util.Calendar.DATE))")
        ]
        variableList = [
            new Variable(name:"KOKOU_NO", className:"java.lang.Integer", variableExpression:"\$V{KOKOU_NO}+1", initialValueExpression:"0"),
            new Variable(name:"KOKOU_SEX_", className:"java.lang.String", variableExpression:"(\$F{sex}!=null && \$F{sex}.length()>0)?\$F{sex}.substring(0,1):\"\""),
            new Variable(name:"KOKOU_SEX", className:"java.lang.String", variableExpression:"\$V{KOKOU_SEX_}.equals(\"m\")?\"男\":\$V{KOKOU_SEX_}.equals(\"w\")?\"女\":\$V{KOKOU_SEX_}"),
            new Variable(name:"KOKOU_SCHOOL_YEAR", className:"java.lang.String", variableExpression:"\$F{schoolYear}!=null&&\$F{schoolYear}.length()>0?\$F{schoolYear}.substring(0,1):\"\""),
            new Variable(name:"KOKOU_BIRTHDAY_YEAR", className:"java.lang.String", variableExpression:"\$F{birthdayYear}==null?\"\":\$F{birthdayYear}.trim()"),
            new Variable(name:"KOKOU_BIRTHDAY_SHORT_YEAR", className:"java.lang.String", variableExpression:"\$V{KOKOU_BIRTHDAY_YEAR}.length()>2?\$V{KOKOU_BIRTHDAY_YEAR}.substring(2):\$V{KOKOU_BIRTHDAY_YEAR}"),
            new Variable(name:"KOKOU_BIRTHDAY_MONTH", className:"java.lang.String", variableExpression:"\$F{birthdayMonth}==null?\"\":\$F{birthdayMonth}.trim()"),
            new Variable(name:"KOKOU_BIRTHDAY_DAY", className:"java.lang.String", variableExpression:"\$F{birthdayDay}==null?\"\":\$F{birthdayDay}.trim()"),
            new Variable(name:"KOKOU_BIRTHDAY", className:"java.lang.String", variableExpression:"\$V{KOKOU_BIRTHDAY_YEAR}.isEmpty() && \$V{KOKOU_BIRTHDAY_MONTH}.isEmpty() && \$V{KOKOU_BIRTHDAY_DAY}.isEmpty()?\"\":\$V{KOKOU_BIRTHDAY_YEAR}+\$P{KOKOU_BIRTHDAY_DELIMETER}+\$V{KOKOU_BIRTHDAY_MONTH}+\$P{KOKOU_BIRTHDAY_DELIMETER}+\$V{KOKOU_BIRTHDAY_DAY}"),
            new Variable(name:"KOKOU_SHORT_BIRTHDAY", className:"java.lang.String", variableExpression:"\$V{KOKOU_BIRTHDAY_SHORT_YEAR}.isEmpty() && \$V{KOKOU_BIRTHDAY_MONTH}.isEmpty() && \$V{KOKOU_BIRTHDAY_DAY}.isEmpty()?\"\":\$V{KOKOU_BIRTHDAY_SHORT_YEAR}+\$P{KOKOU_BIRTHDAY_DELIMETER}+\$V{KOKOU_BIRTHDAY_MONTH}+\$P{KOKOU_BIRTHDAY_DELIMETER}+\$V{KOKOU_BIRTHDAY_DAY}"),
            new Variable(name:"KOKOU_KEEPER_BIRTHDAY_YEAR", className:"java.lang.String", variableExpression:"\$F{keeperBirthdayYear}==null?\"\":\$F{keeperBirthdayYear}.trim()"),
            new Variable(name:"KOKOU_KEEPER_BIRTHDAY_MONTH", className:"java.lang.String", variableExpression:"\$F{keeperBirthdayMonth}==null?\"\":\$F{keeperBirthdayMonth}.trim()"),
            new Variable(name:"KOKOU_KEEPER_BIRTHDAY_DAY", className:"java.lang.String", variableExpression:"\$F{keeperBirthdayDay}==null?\"\":\$F{keeperBirthdayDay}.trim()"),
            new Variable(name:"KOKOU_KEEPER_BIRTHDAY", className:"java.lang.String", variableExpression:"\$V{KOKOU_KEEPER_BIRTHDAY_YEAR}.isEmpty() && \$V{KOKOU_KEEPER_BIRTHDAY_MONTH}.isEmpty() && \$V{KOKOU_KEEPER_BIRTHDAY_DAY}.isEmpty()?\"\":\$V{KOKOU_KEEPER_BIRTHDAY_YEAR}+\$P{KOKOU_KEEPER_BIRTHDAY_DELIMETER}+\$V{KOKOU_KEEPER_BIRTHDAY_MONTH}+\$P{KOKOU_KEEPER_BIRTHDAY_DELIMETER}+\$V{KOKOU_KEEPER_BIRTHDAY_DAY}")
        ]
        fieldList = [
            new Field(name:"name"),
            new Field(name:"nameKr"),
            new Field(name:"sex"),
            new Field(name:"rollNo"),
            new Field(name:"birthdayYear", fieldDescription:"birthday/year"),
            new Field(name:"birthdayMonth", fieldDescription:"birthday/month"),
            new Field(name:"birthdayDay", fieldDescription:"birthday/day"),
            new Field(name:"enterYear"),
            new Field(name:"enterMonth"),
            new Field(name:"enterDay"),
            new Field(name:"enterSchoolYear"),
            new Field(name:"schoolYear"),
            new Field(name:"address"),
            new Field(name:"phoneNo"),
            new Field(name:"emergencyContact"),
            new Field(name:"postalCode"),
            new Field(name:"cardNo", fieldDescription:"cardNo"),
            new Field(name:"className", fieldDescription:"class/name"),
            new Field(name:"keeperName", fieldDescription:"keeper/name"),
            new Field(name:"keeperNameKr", fieldDescription:"keeper/nameKr"),
            new Field(name:"keeperBirthdayYear", fieldDescription:"keeper/birthday/year"),
            new Field(name:"keeperBirthdayMonth", fieldDescription:"keeper/birthday/month"),
            new Field(name:"keeperBirthdayDay", fieldDescription:"keeper/birthday/day")
        ]
    }
    def String birthdayDelimeter = "."
    def String keeperBirthdayDelimeter = "."   
}

