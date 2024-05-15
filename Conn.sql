create database accountingmanagementsystem;

show databases;

use accountingmanagementsystem;

create table account(username varchar(20),name varchar(20),password varchar(20),security varchar(100),answer varchar(50));

create table customer(name varchar(20),destination varchar(20), travel_on date, id varchar(30),email varchar(40),phno varchar(15));
 
create table employee(name varchar(20),fname varchar(20),dob varchar(30),salary varchar(20),address varchar(100),phone varchar(20),email varchar(40),education varchar(20),designation varchar(30),aadhar varchar(25),empId varchar(15));

select * from employee 

create table bills(name varchar(20),billdate varchar(30),Amount varchar(20),BillId varchar(15));