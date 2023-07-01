DROP DATABASE IF EXISTS caseStudyModule3;
create database caseStudyModule3;
use caseStudyModule3;


ALTER USER "root"@"localhost" IDENTIFIED BY "123456789";


create table TypeWorkingDate(
Id int primary key,
Name varchar(20),
SalaryPerencentage DOUBLE
);

create table CalendarWorkingYear(
Date Date primary key,
IdTypeWorkingDate int,
foreign key (IdTypeWorkingDate) references TypeWorkingDate(Id)
);

insert into CalendarWorkingYear() values
("2023-5-6",1),
("2023-5-7",2),
("2023-5-8",3);

update CalendarWorkingYear set IdTypeWorkingDate=2 where date="2023-9-6";
select * from CalendarWorkingYear where date="2023-1-15";

CREATE TABLE Positions(
Id int  primary key,
Name varchar(50),
ValuesAllowance int
);


CREATE TABLE Employee (
    ID INT auto_increment PRIMARY KEY,
    Password varchar(100),
    Name VARCHAR(40),
    IdCalendarWorkingYear int,
    dateOfBirth DATE,
    phone VARCHAR(11),
    joinDate DATE,
    numberOfDependents tinyint,
    Img text
);



create table Department(
Id int auto_increment primary key,
Name varchar(120)
);


create table TypeAllowance(
Id int auto_increment primary key,
Name varchar(100)
);


create table Allowance(
Id int auto_increment primary key,
IdTypeAllowance int,
Name varchar(100),
ValuesAllowance int,
foreign key (IdTypeAllowance) references TypeAllowance(Id)
);


create table Contract(
    ID int auto_increment PRIMARY KEY,
	IDEmployee INT,
    IdAllowance int ,
    IdPosition INT,
    IdDepartment INT,
    basicSalary INT,
    StartDay DATE,
    EndDay DATE,
    Status BOOLEAN,
	FOREIGN KEY (idEmployee) REFERENCES Employee (ID),
    FOREIGN KEY (IdPosition) REFERENCES Positions (Id),
    FOREIGN KEY (IdDepartment) REFERENCES department (Id)
);


create table AllowanceDetail(
IDContract int ,
IdAllowance int,
foreign key (IDContract) references Contract(ID),
foreign key (IdAllowance) references Allowance(Id)
);


create table WorkingDateDetail(
WorkingDate date,
IDEmployee int,
HoursIn datetime,
HoursOut datetime,
foreign key(IDEmployee) references Employee(ID),
foreign key(WorkingDate)references CalendarWorkingYear(Date)
);

create table Message(
IdMessage int auto_increment primary key,
IdEmployeeSent int,
IdEmployeeReceive int,
Content longtext,
foreign key(IdEmployeeSent) references Employee(Id),
foreign key(IdEmployeeReceive) references Employee(Id),
constraint IdEmployeeDifferent check (IdEmployeeSent<>IdEmployeeReceive)
);


insert into TypeWorkingDate(Id,Name) values
(1,"Ngày thường"),
(2,"Ngày lễ"),
(3,"Thứ bảy,Chủ nhật");

insert into CalendarWorkingYear(Date,IdTypeWorkingDate) values
("2023-6-19",1),
("2023-6-20",1),
("2023-6-21",1),
("2023-6-22",1),
("2023-6-23",1),
("2023-6-24",3),
("2023-6-25",3);

insert into Positions(Id,Name) values
(1,"Giám đốc"),
(2,"Quản lí"),
(3,"Nhân sự"),
(4,"Nhân viên");


insert into Employee(Id,Password) values
(1,"gd123456"),
(2,"ql123456"),
(3,"ns123456"),
(4,"nv123546"),
(5,"nv123456");

insert into Contract(IDEmployee,IdPosition,Status) values
(1,1,true),
(2,2,true),
(3,3,true),
(4,4,true),
(5,4,false);
                         



















-- create table SalaryMonth(
-- Month Date primary key,
-- IDEmployee int,
-- NumberWorkDate int,
-- WeekdayOvertime double,
-- OvertimeHoursOnHolidays double,
-- OvertimeHoursOnWeekends double,
-- UpaidDayOff double,
-- PaidDayOff double,
-- InLaterOutEarly double,
-- NumberOfLeaveDays double,
-- IdAllowance int,
-- FOREIGN KEY (idEmployee) REFERENCES Employee (IDEmployee),
-- foreign key (IdAllowance) references Allowance (IdAllowance)
-- );

