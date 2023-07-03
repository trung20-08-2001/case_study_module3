DROP DATABASE IF EXISTS caseStudyModule3;
create database caseStudyModule3;
use caseStudyModule3;


ALTER USER "root"@"localhost" IDENTIFIED BY "123456789";


create table TypeWorkingDate(
IdTypeWorkingDate int auto_increment primary key,
NameTypeWorkingDate varchar(20),
SalaryPerencentage DOUBLE
);


create table CalendarWorkingYear(
DateWorking Date primary key,
IdTypeWorkingDate int,
foreign key (IdTypeWorkingDate) references TypeWorkingDate(IdTypeWorkingDate)
);


CREATE TABLE Positions(
IdPosition int auto_increment primary key,
NamePosition varchar(50),
ValuesAllowance int default 0
);


CREATE TABLE Employee (
    IDEmployee INT auto_increment PRIMARY KEY,
    PasswordEmployee varchar(100),
    NameEmployee VARCHAR(40),
    dateOfBirthEmployee DATE,
    phoneEmployee VARCHAR(11),
    joinDateEmployee DATE,
    numberOfDependentsEmployee tinyint default 0,
    ImgEmployee text
);


create table Department(
IdDepartment int auto_increment primary key,
NameDepartment varchar(120)
);


create table TypeAllowance(
IdTypeAllowance int auto_increment primary key,
NameTypeAllowance varchar(100)
);


create table AllowanceSeniority(
IdAllowanceSeniority int auto_increment primary key,
IdTypeAllowance int,
NumberMonth int,
ValueAllowanceSeniority double,
foreign key(IdTypeAllowance) references TypeAllowance(IdTypeAllowance)
);


create table AllowanceChange(
IdAllowanceChange int auto_increment primary key,
IdTypeAllowance int,
NameAllowanceChange varchar(100),
ValuesAllowanceChange double,
foreign key (IdTypeAllowance) references TypeAllowance(IdTypeAllowance)
);


create table Contract(
    IDContract int auto_increment PRIMARY KEY,
	IDEmployee INT,
    IdPosition INT,
    IdDepartment INT,
    basicSalary INT,
    StartDayContract DATE,
    EndDayContract DATE,
    StatusContract BOOLEAN,
	FOREIGN KEY (idEmployee) REFERENCES Employee (IDEmployee),
    FOREIGN KEY (IdPosition) REFERENCES Positions (IdPosition),
    FOREIGN KEY (IdDepartment) REFERENCES department (Iddepartment)
);


create table WorkingDateDetail(
WorkingDate date,
IDEmployee int,
HoursIn datetime,
HoursOut datetime,
foreign key(IDEmployee) references Employee(IDEmployee),
foreign key(WorkingDate)references CalendarWorkingYear(DateWorking)
);


create table Message(
IdMessage int auto_increment primary key,
IdEmployeeSent int,
IdEmployeeReceive int,
Content longtext,
StatusMessage boolean,
foreign key(IdEmployeeSent) references Employee(IdEmployee),
foreign key(IdEmployeeReceive) references Employee(IdEmployee),
constraint IdEmployeeDifferent check (IdEmployeeSent<>IdEmployeeReceive)
);


DELIMiTER //

CREATE TRIGGER insert_WorkingDate BEFORE INSERT ON WorkingDateDetail FOR EACH ROW
BEGIN
   SET NEW.WorkingDate = DATE(NEW.HoursIn);
END //

DELIMITER ;


-- tạo trigger khi tạo hợp đồng đẩu tiên thì điền vào cột joinDate của nv
      
      
insert into TypeWorkingDate(IdTypeWorkingDate,NameTypeWorkingDate) values
(1,"Ngày thường"),
(2,"Ngày lễ"),
(3,"Cuối tuần"),
(4,"Nghỉ bù");


insert into Positions values
(1,"Giám đốc",0),
(2,"Quản lí",0),
(3,"Nhân sự",0),
(4,"Nhân viên",0);


insert into Employee(IdEmployee,PasswordEmployee,NameEmployee,dateOfBirthEmployee,phoneEmployee,numberOfDependentsEmployee,ImgEmployee) values
(1,"gd123456","Lý Giám đốc","1985-2-3","0314523695",2,"https://iphonecugiare.com/wp-content/uploads/2020/03/90072494_1148106232202126_7381238139576123392_o.jpg"),
(2,"ql123456","Lê Văn Quản lí","1990-3-9","0456963125",1,"https://iphonecugiare.com/wp-content/uploads/2020/03/90072494_1148106232202126_7381238139576123392_o.jpg"),
(3,"ns123456","Lê Thị Nhân Sự","1990-5-6","0236412365",3,"https://upanh123.com/wp-content/uploads/2021/01/anh-chan-dung26-683x1024.jpg"),
(4,"nv123546","Lê Nhân Viên Một","1995-5-9","0236974139",2,"https://iphonecugiare.com/wp-content/uploads/2020/03/90072494_1148106232202126_7381238139576123392_o.jpg"),
(5,"nv123456","Lê Văn Nhân Viên Hai","1999-5-2","0123698745",0,"https://iphonecugiare.com/wp-content/uploads/2020/03/90072494_1148106232202126_7381238139576123392_o.jpg");


insert into Department values
(1,"Director"),
(2,"Software Development"),
(3,"Sale&Markiting"),
(4,"Customer Service"),
(5,"Administration(Admin,HR,Accounting)");


insert into TypeAllowance values
(1,"Không dóng thuế"),
(2,"Có đóng thuế");


insert into  AllowanceSeniority() values
(1,2,60,1000000),
(2,2,120,2000000);


insert into AllowanceChange (IdTypeAllowance,NameAllowanceChange,ValuesAllowanceChange)  values
(1,"Đi lại",500000),
(2,"Ăn trưa",600000);


insert into Contract(IDEmployee,IdPosition,IdDepartment,basicSalary,StartDayContract,EndDayContract,StatusContract) values
(1,1,1,0,"2015-12-3","2999-12-31",true),
(2,2,2,10000000,"2018-3-2","2026-2-3",true),
(3,3,5,10000000,"2017-5-2","2024-5-20",true),
(4,4,2,10000000,"2020-10-6","2024-6-6",true),
(5,4,2,10000000,"2021-12-2","2023-12-15",false);


insert into WorkingDateDetail(IDEmployee,HoursIn,HoursOut) values
(3,"2023-1-1 7:50:00","2023-1-1 17:30:00"),
(3,"2023-1-2 7:50:00","2023-1-2 17:30:00"),
(3,"2023-1-3 7:50:00","2023-1-3 19:30:00"),
(3,"2023-1-4 9:00:00","2023-1-4 17:30:00"),
(3,"2023-1-5 7:50:00","2023-1-5 14:30:00"),
(3,"2023-1-6 7:50:00","2023-1-6 17:30:00"),
(3,"2023-1-7 7:50:00","2023-1-7 18:30:00"),
(3,"2023-1-8 7:50:00","2023-1-8 19:30:00"),
(3,"2023-1-19 10:00:00","2023-1-19 17:30:00");









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

