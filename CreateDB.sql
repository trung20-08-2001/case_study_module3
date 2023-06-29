drop database if exists caseStudyModul3;
create database caseStudyModul3;
use caseStudyModul3;

create table TypeWorkingDate(
IdTypeWorkingDate int auto_increment primary key,
NameWorkingDate varchar(20)
);

create table CalendarWorkingYear(
IdCalendarWorkingYear int auto_increment primary key,
Date Date,
IdTypeWorkingDate int,
foreign key (IdTypeWorkingDate) references TypeWorkingDate(IdTypeWorkingDate)
);

CREATE TABLE Employee (
    IDEmployee INT auto_increment PRIMARY KEY,
    PasswordEmployee varchar(100),
    IdCalendarWorkingYear int,
    NameEmployee VARCHAR(40),
    dateOfBirth DATE,
    phone VARCHAR(11),
    joinDate DATE,
    numberOfDependents tinyint,
    Img text,
    foreign key(IdCalendarWorkingYear) references CalendarWorkingYear(IdCalendarWorkingYear)
);


CREATE TABLE Positions(
IdPosition int auto_increment primary key,
NamePositions varchar(50)
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
    basicSalary BIGINT,
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
HoursInt datetime,
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

