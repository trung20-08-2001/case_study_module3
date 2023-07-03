<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.example.case_study_module3.enums.WorkingDateType" %>
<%@ page import="com.example.case_study_module3.dao.CalendarWorkingYearDAO" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.example.case_study_module3.dao.CalendarWorkingYearDAO" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.example.case_study_module3.model.Employee" %>

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
    <title>Admin</title>
    <link rel="stylesheet" type="text/css" href="/view/css/styleadmin.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<% HttpSession httpSession = request.getSession();
    Employee employee = (Employee) httpSession.getAttribute("employee");
%>
<body class="w3-light-grey">

<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
    <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i
            class="fa fa-bars"></i>  Menu
    </button>
    <span class="w3-bar-item w3-right">Logo</span>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
    <div class="w3-container w3-row">
        <div class="w3-col s4">
            <img src="<%=employee.getImg()%>" class="w3-circle w3-margin-right" style="width:46px">
        </div>
        <div class="w3-col s8 w3-bar">
            <span>Welcome, <strong><%=employee.getName()%></strong></span><br>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-envelope"></i></a>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
        </div>
    </div>
    <hr>
    <div class="w3-container">
        <h5>Dashboard</h5>
    </div>
    <div class="w3-bar-block">
        <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black"
           onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
        <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fas fa-fingerprint"></i>  Thông tin tài khoản</a>
        <a href="#workingDate" class="w3-bar-item w3-button w3-padding"><i class="fa fa-calendar-check-o"></i>   Xem,sửa
            lịch làm việc</a>
        <a href="#clickFingerprint" class="w3-bar-item w3-button w3-padding"><i class="fas fa-fingerprint"></i>  Chấm
            công</a>
        <a href="/viewTimeRecord?id=<%=employee.getId()%>" class="w3-bar-item w3-button w3-padding"><i
                class="fa fa-clock-o"></i>  Xem TimeRecord</a>
        <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-diamond fa-fw"></i>  Orders</a>
        <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bell fa-fw"></i>  News</a>
        <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bank fa-fw"></i>  General</a>
        <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-history fa-fw"></i>  History</a>
        <a href="/logout" class="w3-bar-item w3-button w3-padding"><i
                class="fa fa-cog fa-fw"></i>  Log out</a><br><br>
    </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer"
     title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

    <!-------------------------------------------------------------

                          VIEW INFORMATION ACCOUNT

  ---------------------------------------------------------------->

    <div id="information">
        <div class="container mt-4 mb-4 p-3 d-flex justify-content-center">
            <div class="card p-4">
                <div class=" image d-flex flex-column justify-content-center align-items-center">
                    <h1 class="text-success text-center">Thông tin tài khoản</h1>
                    <img src="<%=employee.getImg()%>" height="200" width="200"/>
                    <div class="d-flex flex-row justify-content-center align-items-center mt-3">
                        <span><%=employee.getName()%></span></div>
                    <div class="d-flex flex-row justify-content-center align-items-center mt-3">
                        <span>Mã nhân viên: <%=employee.getId()%></span></div>
                    <div class="d-flex flex-row justify-content-center align-items-center mt-3">
                        <span>Vị trí: <%=employee.getNamePosition()%></span></div>
                    <div class="d-flex flex-row justify-content-center align-items-center mt-3">
                        <span>Phòng: <%=employee.getNameDepartment()%></span></div>
                    <div class="d-flex flex-row justify-content-center align-items-center mt-3">
                        <span>Ngày sinh: <%=employee.getBirthday()%></span></div>
                    <div class="d-flex flex-row justify-content-center align-items-center mt-3">
                        <span>SDT: <%=employee.getPhone()%></span></div>
                    <div class="d-flex flex-row justify-content-center align-items-center mt-3">
                        <span>Ngày vào công ty: <%=employee.getJoinDate()%></span></div>
                </div>
            </div>
        </div>


    </div>


    <!-------------------------------------------------------------

                            CREATE,VIEW  CALENDAR

    ---------------------------------------------------------------->

    <div id="workingDate">
        <br><br><br>
        <h1 class="text-center text-success">Xem, sửa lịch làm việc</h1>
        <hr>
        <%
            int year = LocalDate.now().getYear();
            TreeMap<Date, Integer> treeMap = new CalendarWorkingYearDAO().getCalendarWorkingYear(year);
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(Calendar.YEAR, year);
        %>
        <h1 style="text-align: center">Calendar <%=year%>
        </h1>
        <div class="slice">
            <div class="arrow">

                <i class="	fa fa-arrow-circle-left" style="font-size:36px" onclick="prev()"></i>
                <i class="	fa fa-arrow-circle-right" style="font-size:36px" onclick="next()"></i>

            </div>
            <div class="calendar">
                <%
                    for (int month = 0; month < 12; month++) {
                        calendar.set(Calendar.MONTH, month);
                        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                %>

                <table class="month<%=month%>" style="text-align: center">
                    <tr>
                        <th colspan="7">Tháng <%=(month + 1)%>
                        </th>
                    </tr>
                    <tr>
                        <th>Sun</th>
                        <th>Mon</th>
                        <th>Tue</th>
                        <th>Wed</th>
                        <th>Thu</th>
                        <th>Fri</th>
                        <th>Sat</th>
                    </tr>
                    <%
                        for (int day = 1; day <= maxDay; day++) {
                            calendar.set(Calendar.DAY_OF_MONTH, day);
                            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                            if (day == 1) {
                    %>
                    <tr>
                        <%
                            for (int i = 1; i < dayOfWeek; i++) {
                        %>
                        <td></td>
                        <%
                                }
                            }
                            Date date = new Date(year - 1900, month, day);
                            int idWorkingDateType = treeMap.get(date);
                            if (idWorkingDateType == WorkingDateType.NORMAL.getValue()) {
                        %>
                        <td>
                            <button style="border:none ; color: black"
                                    onclick="showWorkingDateType(<%=day%>,<%=month%>)"><%=day%>
                            </button>
                            <ul id="typeWorkingDate<%=day%><%=month%>" class="allDay" style="display: none">
                                <li>
                                    <a style="color: red"
                                       href="/editCalendar?year=<%=year%>&month=<%=month%>&day=<%=day%>&type=<%=WorkingDateType.HOLIDAY.getValue()%>">Nghỉ
                                        lễ </a></li>
                                <li>
                                    <a style="color: blue"
                                       href="/editCalendar?year=<%=year%>&month=<%=month%>&day=<%=day%>&type=<%=WorkingDateType.COMPENSATORY_LEAVE.getValue()%>">Nghỉ
                                        bù</a></li>
                            </ul>
                        </td>
                        <%
                            }
                            if (idWorkingDateType == WorkingDateType.HOLIDAY.getValue()) {
                        %>
                        <td>
                            <button style="border: 1px solid red; border-radius: 50%"
                                    onclick="showWorkingDateType(<%=day%>,<%=month%>)"><%=day%>
                            </button>
                            <ul id="typeWorkingDate<%=day%><%=month%>" class="allDay" style="display: none">
                                <li>
                                    <a style="color: red"
                                       href="/editCalendar?year=<%=year%>&month=<%=month%>&day=<%=day%>&type=<%=WorkingDateType.HOLIDAY.getValue()%>">Nghỉ
                                        lễ </a></li>
                                <li>
                                    <a style="color: blue"
                                       href="/editCalendar?year=<%=year%>&month=<%=month%>&day=<%=day%>&type=<%=WorkingDateType.COMPENSATORY_LEAVE.getValue()%>">Nghỉ
                                        bù</a></li>
                            </ul>
                        </td>
                        <%
                            }
                            if (idWorkingDateType == WorkingDateType.WEEKEND.getValue()) {
                        %>
                        <td>
                            <button style="border: 1px solid green; border-radius: 50%"
                                    onclick="showWorkingDateType(<%=day%>,<%=month%>)"><%=day%>
                            </button>
                            <ul id="typeWorkingDate<%=day%><%=month%>" class="allDay" style="display: none">
                                <li>
                                    <a style="color: red"
                                       href="/editCalendar?year=<%=year%>&month=<%=month%>&day=<%=day%>&type=<%=WorkingDateType.HOLIDAY.getValue()%>">Nghỉ
                                        lễ </a></li>
                                <li>
                                    <a style="color: blue"
                                       href="/editCalendar?year=<%=year%>&month=<%=month%>&day=<%=day%>&type=<%=WorkingDateType.COMPENSATORY_LEAVE.getValue()%>">Nghỉ
                                        bù</a></li>
                            </ul>
                        </td>
                        <%
                            }
                            if (idWorkingDateType == WorkingDateType.COMPENSATORY_LEAVE.getValue()) {
                        %>
                        <td>
                            <button style="border: 1px solid blue; border-radius: 50% "
                                    onclick="showWorkingDateType(<%=day%>,<%=month%>)"><%=day%>
                            </button>
                            <ul id="typeWorkingDate<%=day%><%=month%>" class="allDay" style="display: none">
                                <li>
                                    <a style="color: red"
                                       href="/editCalendar?year=<%=year%>&month=<%=month%>&day=<%=day%>&type=<%=WorkingDateType.HOLIDAY.getValue()%>">Nghỉ
                                        lễ </a></li>
                                <li>
                                    <a style="color: blue"
                                       href="/editCalendar?year=<%=year%>&month=<%=month%>&day=<%=day%>&type=<%=WorkingDateType.COMPENSATORY_LEAVE.getValue()%>">Nghỉ
                                        bù</a></li>
                            </ul>
                        </td>
                        <%
                            }
                            if (dayOfWeek == Calendar.SATURDAY) {
                        %>
                    </tr>
                    <%
                            }

                        }
                    %>
                </table>

                <%
                    }

                %>
            </div>
        </div>
        <div class="row">
            <div class="col-6 d-flex justify-content-center">
                <label class="text-warning" style="margin-left: 30px;font-size: 30px">Chú thích</label>
                <ul>
                    <li>
                        <button style="border: 1px solid red; border-radius: 50%; width: 20px;height: 20px"></button>
                        Ngày nghỉ lễ
                    </li>
                    <li>
                        <button style="border: 1px solid green; border-radius: 50%;  width: 20px;height: 20px"></button>
                        Ngày nghỉ cuối tuần
                    </li>
                    <li>
                        <button style="border: 1px solid blue; border-radius: 50%;  width: 20px;height: 20px"></button>
                        Ngày nghỉ bù
                    </li>
                </ul>
            </div>
            <%--            <div class="col-6">--%>
            <%--                <label for="my-select" class="text-warning" style="font-size: 30px">Chọn năm</label>--%>
            <%--                <br>--%>
            <%--                <select id="my-select" size="3">--%>
            <%--                    <%--%>
            <%--                        for (int i = 1900; i < 3000; i++) {--%>
            <%--                    %>--%>
            <%--                    <option><a href="/viewCalendar?year=<%=i%>"><%=i%></a></option>--%>
            <%--                    <%--%>
            <%--                        }%>--%>
            <%--                </select>--%>
            <%--            </div>--%>
        </div>
    </div>
    <hr>

    <!-------------------------------------------------------------

                             BẤM VÂN TAY

    ---------------------------------------------------------------->

    <div id="clickFingerprint">
        <br><br><br>
        <h1 class="text-success text-center">Chấm công</h1>
        <div class="d-flex justify-content-center">
            <a href="/checkHour?id=${employee.getId()}"><i class="fas fa-fingerprint" style="font-size:36px"></i></a>
        </div>
        <c:if test="${message!=null}">
            <h3 class="text-success text-center">${message}</h3>
        </c:if>


        <%--        <!-- The Modal -->--%>
        <%--        <div id="myModal">--%>
        <%--            <div class="modal-dialog">--%>
        <%--                <div class="modal-content">--%>
        <%--                    <!-- Modal body -->--%>
        <%--                    <div class="modal-body">--%>
        <%--                        <h1 class="text-center">${message}</h1>--%>
        <%--                    </div>--%>
        <%--                    <!-- Modal footer -->--%>
        <%--                    <div class="modal-footer">--%>
        <%--                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>--%>
        <%--                    </div>--%>

        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </div>--%>
    </div>
    <hr>


    <!-------------------------------------------------------------


                       VIEW TIME RECORD


    --------------------------------------------------------------->
    <div>
        <div class="d-flex justify-content-center">
            <c:if test="${timeRecordList!=null}">
                <table style="text-align: center">
                    <tr>
                        <th>Ngày</th>
                        <th>Loại</th>
                        <th>Giờ vào</th>
                        <th>Giờ ra</th>
                        <th>Số làm hành chính</th>
                        <th>Số giờ làm thêm</th>
                        <th>Trạng thái</th>
                        <th>Giải trình</th>
                    </tr>
                    <c:forEach items="${timeRecordList}" var="timeRecord">
                        <tr>
                            <td>${timeRecord.workingDate}</td>
                            <td>${timeRecord.nameWorkingDateType}</td>
                            <td>${timeRecord.getCheckInTime()}</td>
                            <td>${timeRecord.getCheckOutTime()}</td>
                            <td>${timeRecord.workingHours}</td>
                            <td>${timeRecord.overTimeHours}</td>
                            <td><c:if test="${timeRecord.status==false}"><c:out value="Thiếu giờ"></c:out></c:if>
                                <c:if test="${timeRecord.status==true&&timeRecord.overTimeHours==0}"><c:out value="Ok"></c:out></c:if>
                                <c:if test="${timeRecord.overTimeHours!=0}"><c:out value="Tăng ca"></c:out></c:if>
                            </td>
                            <td>
                                <c:if test="${timeRecord.status==false||timeRecord.overTimeHours!=0}">
                                    <button type="button" class="btn btn-primary" data-toggle="modal"
                                            data-target="#reason">
                                        Giải trình
                                    </button>
                                </c:if>
                                <c:if test="${timeRecord.status==true&&timeRecord.overTimeHours==0}">
                                    <button type="button" class="btn btn-secondary">
                                        Giải trình
                                    </button>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <!-- The Modal -->
            <div class="modal fade" id="reason">
                <div class="modal-dialog">
                    <div class="modal-content" style="width: 700px;height: 300px;">
                        <form action="/reason" method="get">
                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title text-center">Lí do mà bạn muốn giải trình</h4>
                                <button type="button" class="close" data-dismiss="modal"></button>
                            </div>

                            <!-- Modal body -->
                            <div>
                            <input type="text" name="reason" class="form-control" rows="5"
                                      placeholder="Nhập lí do">
                            </div>

                            <!-- Modal footer -->
                            <div>
                                <div class="row">
                                    <div class="col-6">
                                        <button type="button" class="btn btn-danger "
                                                style="position: absolute;left: 50%" data-dismiss="modal">Close
                                        </button>
                                    </div>
                                    <div class="col-6">
                                        <button type="submit" class="btn btn-success "
                                                style="position: absolute;left: 50%;">Gửi
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="w3-container">
        <h5>General Stats</h5>
        <p>New Visitors</p>
        <div class="w3-grey">
            <div class="w3-container w3-center w3-padding w3-green" style="width:25%">+25%</div>
        </div>

        <p>New Users</p>
        <div class="w3-grey">
            <div class="w3-container w3-center w3-padding w3-orange" style="width:50%">50%</div>
        </div>

        <p>Bounce Rate</p>
        <div class="w3-grey">
            <div class="w3-container w3-center w3-padding w3-red" style="width:75%">75%</div>
        </div>
    </div>
    <hr>

    <div class="w3-container">
        <h5>Countries</h5>
        <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
            <tr>
                <td>United States</td>
                <td>65%</td>
            </tr>
            <tr>
                <td>UK</td>
                <td>15.7%</td>
            </tr>
            <tr>
                <td>Russia</td>
                <td>5.6%</td>
            </tr>
            <tr>
                <td>Spain</td>
                <td>2.1%</td>
            </tr>
            <tr>
                <td>India</td>
                <td>1.9%</td>
            </tr>
            <tr>
                <td>France</td>
                <td>1.5%</td>
            </tr>
        </table>
        <br>
        <button class="w3-button w3-dark-grey">More Countries  <i class="fa fa-arrow-right"></i></button>
    </div>
    <hr>
    <div class="w3-container">
        <h5>Recent Users</h5>
        <ul class="w3-ul w3-card-4 w3-white">
            <li class="w3-padding-16">
                <img src="/w3images/avatar2.png" class="w3-left w3-circle w3-margin-right" style="width:35px">
                <span class="w3-xlarge">Mike</span><br>
            </li>
            <li class="w3-padding-16">
                <img src="/w3images/avatar5.png" class="w3-left w3-circle w3-margin-right" style="width:35px">
                <span class="w3-xlarge">Jill</span><br>
            </li>
            <li class="w3-padding-16">
                <img src="/w3images/avatar6.png" class="w3-left w3-circle w3-margin-right" style="width:35px">
                <span class="w3-xlarge">Jane</span><br>
            </li>
        </ul>
    </div>
    <hr>

    <div class="w3-container">
        <h5>Recent Comments</h5>
        <div class="w3-row">
            <div class="w3-col m2 text-center">
                <img class="w3-circle" src="/w3images/avatar3.png" style="width:96px;height:96px">
            </div>
            <div class="w3-col m10 w3-container">
                <h4>John <span class="w3-opacity w3-medium">Sep 29, 2014, 9:12 PM</span></h4>
                <p>Keep up the GREAT work! I am cheering for you!! Lorem ipsum dolor sit amet, consectetur adipiscing
                    elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><br>
            </div>
        </div>

        <div class="w3-row">
            <div class="w3-col m2 text-center">
                <img class="w3-circle" src="/w3images/avatar1.png" style="width:96px;height:96px">
            </div>
            <div class="w3-col m10 w3-container">
                <h4>Bo <span class="w3-opacity w3-medium">Sep 28, 2014, 10:15 PM</span></h4>
                <p>Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><br>
            </div>
        </div>
    </div>
    <br>
    <div class="w3-container w3-dark-grey w3-padding-32">
        <div class="w3-row">
            <div class="w3-container w3-third">
                <h5 class="w3-bottombar w3-border-green">Demographic</h5>
                <p>Language</p>
                <p>Country</p>
                <p>City</p>
            </div>
            <div class="w3-container w3-third">
                <h5 class="w3-bottombar w3-border-red">System</h5>
                <p>Browser</p>
                <p>OS</p>
                <p>More</p>
            </div>
            <div class="w3-container w3-third">
                <h5 class="w3-bottombar w3-border-orange">Target</h5>
                <p>Users</p>
                <p>Active</p>
                <p>Geo</p>
                <p>Interests</p>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="w3-container w3-padding-16 w3-light-grey">
        <h4>FOOTER</h4>
        <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
    </footer>

    <!-- End page content -->
</div>
</body>

<script>
    // Get the Sidebar
    var mySidebar = document.getElementById("mySidebar");

    // Get the DIV with overlay effect
    var overlayBg = document.getElementById("myOverlay");

    // Toggle between showing and hiding the sidebar, and add overlay effect
    function w3_open() {
        if (mySidebar.style.display === 'block') {
            mySidebar.style.display = 'none';
            overlayBg.style.display = "none";
        } else {
            mySidebar.style.display = 'block';
            overlayBg.style.display = "block";
        }
    }

    // Close the sidebar with the close button
    function w3_close() {
        mySidebar.style.display = "none";
        overlayBg.style.display = "none";
    }
</script>
</html>
<script>
    let sizeTable = document.getElementsByClassName("slice")[0].clientWidth - 0.3;
    let calendar = document.getElementsByClassName("calendar")[0];
    let move = 0;

    function next() {
        if (move < sizeTable * 11) {
            move += sizeTable;
            calendar.style.marginLeft = "-" + move + "px";
        } else {
            move = move;
        }
    }

    function prev() {
        if (calendar.style.marginLeft === ("-" + sizeTable + "px") || calendar.style.marginLeft === 0 + "px") {
            calendar.style.marginLeft = 0 + "px";
        } else {
            move -= sizeTable;
            calendar.style.marginLeft = "-" + move + "px";
        }
    }

    function showWorkingDateType(day, month) {
        let allDay = document.getElementsByClassName("allDay");
        let selectWorkingDateType = document.getElementById("typeWorkingDate" + day + month)
        for (let i = 0; i < allDay.length; i++) {
            allDay[i].style.display = "none";
        }
        if (selectWorkingDateType.style.display === "none") {
            selectWorkingDateType.style.display = "block";
        } else {
            selectWorkingDateType.style.display = "none";
        }
    }
</script>