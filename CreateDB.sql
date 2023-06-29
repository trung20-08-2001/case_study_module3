DROP DATABASE IF EXISTS caseStudyModule3;
create database caseStudyModule3;
use caseStudyModule3;


ALTER USER "root"@"localhost" IDENTIFIED BY "123456789";


create table TypeWorkingDate(
IdTypeWorkingDate int primary key,
NameWorkingDate varchar(20)
);

create table CalendarWorkingYear(
IdCalendarWorkingYear int auto_increment primary key,
Date Date,
IdTypeWorkingDate int,
foreign key (IdTypeWorkingDate) references TypeWorkingDate(IdTypeWorkingDate)
);


CREATE TABLE Positions(
IdPosition int  primary key,
NamePositions varchar(50)
);


CREATE TABLE Employee (
    IDEmployee INT auto_increment PRIMARY KEY,
    PasswordEmployee varchar(100),
    IdPosition int,
    NameEmployee VARCHAR(40),
    IdCalendarWorkingYear int,
    dateOfBirth DATE,
    phone VARCHAR(11),
    joinDate DATE,
    numberOfDependents tinyint,
    Img text,
    foreign key(IdPosition) references Positions(IdPosition),
    foreign key(IdCalendarWorkingYear) references CalendarWorkingYear(IdCalendarWorkingYear)
);



create table Department(
IdDepartment int auto_increment primary key,
NameDepartment varchar(120)
);


create table TypeAllowance(
IdTypeAllowance int auto_increment primary key,
NameTypeAllowance varchar(100)
);

create table Conditions(
IdCondition int auto_increment primary key,
NameCondition varchar(100),
ValuesAllowance int
);

create table Allowance(
IdAllowance int auto_increment primary key,
IdTypeAllowance int,
NameAllowance varchar(100),
IdCondition int,
foreign key (IdTypeAllowance) references TypeAllowance(IdTypeAllowance),
foreign key (IdCondition) references Conditions(IdCondition)
);


create table Contract(
    IDContract int auto_increment PRIMARY KEY,
	IDEmployee INT,
    IdAllowance int ,
    IdPosition INT,
    IdDepartment INT,
    basicSalary INT,
    StartDay DATE,
    EndDay DATE,
    StatusContract BOOLEAN,
	FOREIGN KEY (idEmployee) REFERENCES Employee (IDEmployee),
    FOREIGN KEY (IdPosition) REFERENCES Positions (IdPosition),
    FOREIGN KEY (idDepartment) REFERENCES department (IdDepartment)
);


create table AllowanceDetail(
IDContract int ,
IdAllowance int,
foreign key (IDContract) references Contract(IDContract),
foreign key (IdAllowance) references Allowance(IdAllowance)
);


create table WorkingDateDetail(
WorkingDate date primary key,
IDEmployee int,
HoursIn datetime,
HoursOut datetime,
foreign key(IDEmployee) references Employee(IDEmployee)
);

create table Message(
IdMessage int auto_increment primary key,
IdEmployeeSent int,
IdEmployeeReceive int,
Content longtext,
foreign key(IdEmployeeSent) references Employee(IdEmployee),
foreign key(IdEmployeeReceive) references Employee(IdEmployee),
constraint IdEmployeeDifferent check (IdEmployeeSent<>IdEmployeeReceive)
);


insert into TypeWorkingDate(IdTypeWorkingDate,NameWorkingDate) values
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

insert into Positions(IdPosition,NamePositions) values
(1,"Giám đốc"),
(2,"Quản lí"),
(3,"Nhân sự"),
(4,"Nhân viên");


insert into Employee(PasswordEmployee,IdPosition) values
("gd",1),
("ql",2),
("ns",3),
("nv",4);



























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

