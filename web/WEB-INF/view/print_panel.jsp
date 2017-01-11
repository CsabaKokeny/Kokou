<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String report = (String)request.getAttribute("report");
    String type = (String)request.getAttribute("type");
    String frameName = (String)request.getAttribute("frameName");
    String schoolKind = request.getParameter("schoolKind");
    Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH) + 1;
    int day = c.get(Calendar.DAY_OF_MONTH);
    
    
    int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int last_day = days[month-1];
    
    if (month == 2) {
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                last_day = 29;
            }
        } else if (year % 4 == 0) {
            last_day = 29;
        }
    }
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <style>
            * {
                font-family: 'MS PMincho';
            }
            select {
                background-color:#2B94D0;
                border-width:1px;
                border-style:solid;
                border-color:#2B9000;
                position:relative;
                padding-top:5px;
                padding-bottom:5px;
                width:80px;
                height:30px;
                vertical-align:middle;
            }
            .btn {
                display:inline-block;
                background-color:#2B94D0;
                border-width:1px;
                border-style:solid;
                border-color:#2B9000;
                position:relative;
                text-align:center;
                vertical-align:middle;
                padding-top:10px;;
                width:80px;
                height:20px;
            }
            .label {
                position:relative;
                display:inline-block;
                height:20px;
                padding-top:10px;
                top:20px;
            }
        </style>
        <script src="../jquery/jquery-1.11.1.js"></script>
        <script>
            function changedSchoolKind() {
                //$('#hData').val(true);
                //loadClassList();
            }
            function changedSchoolYear() {
                //$('#hData').val(true);
                //loadClassList();
            }
            function loadClassList() {
               // var schoolKind = $("#selSchoolKind").val();
                var schoolKind = "<%=schoolKind%>";
                alert(schoolKind);
                var schoolYear = $("#selSchoolYear").val();
                var className = $("#selClass").val();
                var data = {"schoolYear": schoolYear, "schoolKind": schoolKind, "className": className};
                $.post('../class/list', data, function (response){
                    if (!response.data) {
                        response.data = [];
                    }
                    if (!response.data.push) {
                        response.data = [response.data];
                    }
                    var content = '<option value="0">전체</option>';
                    for(var i=0;i<response.data.length;i++) {
                        content+='<option value="'+response.data[i].classId+'">';
                        content+=response.data[i].name;
                        content+='</option>';
                    }
                    $('#selClass').html(content);
                    
                }, 'json');
            }
        </script>
    </head>
    <body>
        <form target="<%=frameName%>" id="form1" action="../reports/<%=report%>.rpt">
            <input id="hData" type="hidden" name="data" value="true"/>
            <input type="hidden" name="schoolKind" value="<%=schoolKind%>"/>
            <select name="schoolYear" id="selSchoolYear" style="left:80px;top:15px;" onchange="changedSchoolYear()">
                <option value="">全体</option>
                <% if ("H".equals(schoolKind) || "J".equals(schoolKind)) { %>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                <% } else if ("P".equals(schoolKind)) { %>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                <% } else if ("E".equals(schoolKind)) { %>
                    <option value="장미반">장미반</option>
                    <option value="무궁화반">무궁화반</option>
                    <option value="진달래반">진달래반</option>
                    <option value="개나리반">개나리반</option>
                <% } else { %>
                <% } %>
            </select>
            <div class="label" style="left:80px;">学年</div>
            <select name="className" id="selClass"  style="left:90px;top:15px;">
                <option value="">全体</option>
                <% if ("H".equals(schoolKind) || "J".equals(schoolKind) || "P".equals(schoolKind)) { %>
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="C">C</option>
                    <option value="D">D</option>
                <% } %>
                <% if ("E".equals(schoolKind)) { %>
                <% } else { %>
                <% } %>
                
            </select>
            <div class="label" style="left:80px;width:30px;"></div>
            <select name="year" id="selYear"  style="left:90px;top:15px;">
                <% for(int i=1980;i<2100;i++) { %>
                    <option value="<%=i%>" <%=(year==i?"selected":"")%>><%=i%></option>
                <% } %>
            </select>
            <div class="label" style="left:90px;">年</div>
            <select name="month" id="selMonth"  style="left:90px;top:15px;width:40px">
                <% for(int i=1;i<13;i++) { %>
                    <option value="<%=i%>" <%=(month==i?"selected":"")%>><%=i%></option>
                <% } %>
            </select>
            <div class="label" style="left:90px;">月</div>
            <select name="day" id="selDay"  style="left:90px;top:15px;width:40px">
                <% for(int i=1;i<=last_day;i++) { %>
                    <option value="<%=i%>" <%=(day==i?"selected":"")%>><%=i%></option>
                <% } %>
            </select>
            <div class="label" style="left:90px;">日</div>
            <a onclick="preview()" style="cursor:pointer;"><div align="center" class="btn" style="left:110px;top:15px;">プレビュー</div></a>
            <a onclick="print()" style="cursor:pointer;"><div align="center" class="btn" style="left:130px;top:15px;">印刷</div></a>
        </form>
        <script>
            function preview() {
                $('#hData').val(true);
                $('#form1').submit();
                $('#hData').val(false);
            }
            function print() {
                var href="../reports/<%=report+"."+type%>";
                var target = "<%=frameName%>_down";
                var old_target = $("#form1").prop("target");
                var old_href = $("#form1").prop("action");
                
                $('#hData').val(false);
                $('#form1').prop("target", target);
                $('#form1').prop("action", href);
                $('#form1').submit();
                $('#form1').prop("target", old_target);
                $('#form1').prop("action", old_href);
            }
            
            
            $("#selYear").bind("change", function () {
                adjust();
            });
            $("#selMonth").bind("change", function () {
                adjust();
            })
            function adjust() {
               var year = parseInt($("#selYear").val());
               var month = parseInt($("#selMonth").val());
               var date = parseInt($("#selDay").val());
               var days = [31,28,31,30,31,30,31,31,30,31,30,31];
               var last_day = days[month-1];
               if (parseInt(month) === 2) {
                   if (year % 100 === 0) {
                       if (year % 400 === 0) {
                           last_day = 29;
                       }
                   } else if (year % 4 === 0){
                       last_day = 29;
                   }
               }
               var text = "";
               for (var i=1;i<=last_day;i++) {
                   if (i===date) {
                       text+='<option value="'+i+'" selected>'+i+'</option>';
                   } else {
                       text+='<option value="'+i+'">'+i+'</option>';
                   }
                   
               }
               $("#selDay").html(text);
            }
        </script>
   </body>
</html>
