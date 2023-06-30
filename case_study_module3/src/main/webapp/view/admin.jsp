<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 6/29/2023
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Lịch năm 2023</h1>
<table>
    <thead>
    <tr>

        <th>Tháng</th>
    </tr>
    <tr>
        <th>CN</th>
        <th>T2</th>
        <th>T3</th>
        <th>T4</th>
        <th>T5</th>
        <th>T6</th>
        <th>T7</th>
    </tr>
    </thead>
    <tbody>
    <c:out value="a"></c:out>
    <%
        int year = 2023;
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.clear();
        calendar.set(java.util.Calendar.YEAR, year);
        for (int month = 0; month < 12; month++) {
            calendar.set(java.util.Calendar.MONTH, month);
            int maxDay = calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
//            out.write("<tr>");
//            out.printf("<td>Tháng %d</td>", month + 1);
            for (int day = 1; day <= maxDay; day++) {
                calendar.set(java.util.Calendar.DAY_OF_MONTH, day);
                int dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
                if (day == 1) {
                    for (int i = 1; i < dayOfWeek; i++) {
//                        out.write("<td></td>");
                    }
                }
//                out.printf("<td>%d</td>", day);
                if (dayOfWeek == java.util.Calendar.SATURDAY) {
//                    out.println();
                }
            }
//            out.write("</tr>");
        }
    %>
    </tbody>
</table>
</body>
</html>
