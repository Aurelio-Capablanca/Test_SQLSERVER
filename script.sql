CREATE LOGIN appManager WITH PASSWORD = 'lqr73He84Cfwer';

CREATE USER appOwner FOR LOGIN appManager;
DENY ALTER TO appOwner;
GRANT SELECT, INSERT, UPDATE ON SCHEMA::dbo TO appOwner;


CREATE TABLE EmployeeDatabase.dbo.Role_Employee (
	id_role int IDENTITY(1,1) NOT NULL,
	role_employee varchar(20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	CONSTRAINT PK__Role_Emp__3D48441DF934E5BE PRIMARY KEY (id_role)
);


CREATE TABLE EmployeeDatabase.dbo.Departments (
	id_department int IDENTITY(1,1) NOT NULL,
	department_name varchar(25) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	CONSTRAINT PK__Departme__0FC1D23F1D2955B2 PRIMARY KEY (id_department)
);

CREATE TABLE EmployeeDatabase.dbo.Employee (
	id_employee int IDENTITY(1,1) NOT NULL,
	name_employee varchar(25) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	lastname_employee varchar(25) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	code_employee varchar(8) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT '0000' NULL,
	internal_phone varchar(20) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT '(000) 000-0000' NULL,
	email_employee varchar(35) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	id_creator int NULL,
	date_created datetime DEFAULT getdate() NULL,
	id_department int NOT NULL,
	id_role int NOT NULL,
	CONSTRAINT PK__Employee__F807679C5BD81939 PRIMARY KEY (id_employee),
	CONSTRAINT FK__Employee__id_dep__3E52440B FOREIGN KEY (id_department) REFERENCES EmployeeDatabase.dbo.Departments(id_department),
	CONSTRAINT FK__Employee__id_rol__3F466844 FOREIGN KEY (id_role) REFERENCES EmployeeDatabase.dbo.Role_Employee(id_role)
);

INSERT INTO departments (id_department,department_name) VALUES
	 (1,'IT'),
	 (2,'HR'),
	 (3,'Finance'),
	 (4,'Marketing'),
	 (5,'Sales');


INSERT INTO Role_Employee (id_role,role_employee) VALUES
	 (6,'Manager'),
	 (7,'Developer'),
	 (8,'Analyst'),
	 (9,'Support'),
	 (10,'Administrator');


