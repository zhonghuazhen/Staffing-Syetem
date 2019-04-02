Mysql��Ŀʹ�õ������ݿ�

drop database if exists system;
create database system;
use system;


create table department(

did varchar(10) primary key,
dname varchar(20) not null,
hidden int(1)

);

create table staff(

did varchar(10),
sid varchar(10) primary key,  
sname varchar(20) not null,   
spass varchar(20) not null,   
sex varchar(2),               
age int,                      
zhiwu varchar(10),            
tel int,                      
email varchar(30),           
superuser int, 
hidden int(1), 
foreign key(did) references department(did)
);


create table salary(

sid varchar(10) primary key,
sname varchar(20) not null,
basic float,                   
bonus float,                   
subvention float,              
penalty float,
date varchar(30), 
hidden int(1),                
foreign key(sid) references staff(sid)
);

create table time(
sid varchar(10) primary key,
worktime int,                 
vacate int,                   
rest int,
hidden int(1),                    
foreign key(sid) references staff(sid)
);

insert into department values('d01','������',0);
insert into department values('d02','�ƹ㲿',0);
insert into department values('d03','�ͷ���',0);
insert into department values('d04','������',0);
insert into department values('d05','����',0);

insert into staff values('d01','s01','��һ','123456789','��',24,'����������',123456789,'1234567890@qq.com',2,0);
insert into staff values('d01','s02','�Ŷ�','123456789','Ů',22,'������ְԱ',123456789,'1234567891@qq.com',1,0);
insert into staff values('d02','s03','��һ','123456789','��',24,'�ƹ㲿����',123456789,'1234567892@qq.com',2,0);
insert into staff values('d02','s04','���','123456789','Ů',22,'�ƹ㲿ְԱ',123456789,'1234567893@qq.com',1,0);
insert into staff values('d03','s05','��һ','123456789','Ů',22,'�ͷ�������',123456789,'1234567894@qq.com',2,0);
insert into staff values('d03','s06','����','123456789','��',24,'�ͷ���ְԱ',123456789,'1234567895@qq.com',1,0);
insert into staff values('d04','s07','��һ','123456789','��',24,'����������',123456789,'1234567896@qq.com',2,0);
insert into staff values('d04','s08','�Զ�','123456789','��',22,'������ְԱ',123456789,'1234567897@qq.com',1,0);
insert into staff values('d05','s09','��һ','123456789','Ů',22,'���񲿾���',123456789,'1234567898@qq.com',2,0);
insert into staff values('d05','s10','����','123456789','��',24,'����ְԱ',123456789,'1234567899@qq.com',1,0);

insert into salary values('s01','��һ','8000.00',0.40,0.20,0,'2018-10-1',0);
insert into salary values('s02','�Ŷ�','6000.00',0.30,0.10,0,'2018-10-1',0);
insert into salary values('s03','��һ','8000.00',0.40,0.20,0,'2018-10-1',0);
insert into salary values('s04','���','6000.00',0.30,0.10,600,'2018-10-1',0);
insert into salary values('s05','��һ','8000.00',0.40,0.20,0,'2018-10-1',0);
insert into salary values('s06','����','6000.00',0.30,0.10,300,'2018-10-1',0);
insert into salary values('s07','��һ','8000.00',0.40,0.20,0,'2018-10-1',0);
insert into salary values('s08','�Զ�','6000.00',0.30,0.10,0,'2018-10-1',0);
insert into salary values('s09','��һ','8000.00',0.40,0.20,300,'2018-10-1',0);
insert into salary values('s10','����','6000.00',0.30,0.10,0,'2018-10-1',0);

insert into time values('s01',30,4,8,0);
insert into time values('s02',30,3,8,0);
insert into time values('s03',30,4,8,0);
insert into time values('s04',28,3,10,0);
insert into time values('s05',30,4,8,0);
insert into time values('s06',29,3,9,0);
insert into time values('s07',30,4,8,0);
insert into time values('s08',30,3,8,0);
insert into time values('s09',29,4,9,0);
insert into time values('s10',30,3,8,0);