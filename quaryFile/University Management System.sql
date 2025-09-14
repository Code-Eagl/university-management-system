create database university_mms;
show databases;
use university_mms;

/*login tablee*
create table login(username varchar(25),
                   password varchar(10));
insert into login values('Admin','123');

/*Student table*/
create table student(course varchar(20), branch varchar(20),
name varchar(20), fname varchar(20),rollno varchar(10),
dob varchar(20), address varchar(60), phone varchar(20),
email varchar(20),adhar varchar(20),m10 varchar(20), 
m12 varchar(20));
describe student;

/*faculty table*/
create table faculty(department varchar(20), branch varchar(20),
name varchar(20), mname varchar(20),empid varchar(10),
dob varchar(20), address varchar(60), phone varchar(20),
email varchar(40),adhar varchar(20),lab varchar(20), 
spelization varchar(20));

/*Student Leave Applivation */
create table studentleave(rollno varchar(10), date varchar(15), duration varchar(10), reason varchar(60));

/*update marks table */
create table subject(rollno varchar(10), semester varchar(10), sub_1 varchar(10), sub_2 varchar(10),sub_3 varchar(10),sub_4 varchar(10),sub_5 varchar(10));
create table marks(rollno varchar(10), semester varchar(10), marks_1 varchar(10), marks_2 varchar(10),marks_3 varchar(10),marks_4 varchar(10),marks_5 varchar(10));



drop table student;
select * from login;  
select * from student;
select * from faculty;
