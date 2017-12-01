//数据查询语言DQL
select * from person;
SELECT ID,NAME,`PASSWORD` FROM person;
SELECT p.ID,p.NAME,p.`PASSWORD` FROM person p;
SELECT p.ID,p.NAME,p.`PASSWORD` FROM person as p;
SELECT p.ID id12345,p.NAME,p.`PASSWORD` FROM person as p;
SELECT p.ID as id12345,p.NAME,p.`PASSWORD` FROM person as p;
SELECT p.ID as "id12345",p.NAME,p.`PASSWORD` FROM person as p;
SELECT p.ID as "id12   345",p.NAME,p.`PASSWORD` FROM person as p;
SELECT p.ID  'id12  345',p.NAME,p.`PASSWORD` FROM person as p;
select CONCAT(name,password) from person
//错误
SELECT p.ID as id12   345,p.NAME,p.`PASSWORD` FROM person as p;
//数据操纵语言DML
//INSERT新增
insert into person VALUES(7,'李四','456','1');
insert into person(id,name,courseId) values(4,'赵六','2');
//UPDATE更新
update person set `PASSWORD`='123' where id='4';
update person p set `PASSWORD`='12' where p.id='4';
update person p set `PASSWORD`='12' where id='4';
//delete删除
delete from person where id=7; 
delete p from person p where p.id=7; 


//创建表DDL
Create table person2(
id varchar(255) PRIMARY KEY
);

create table person3(
id VARCHAR(255) PRIMARY KEY,
name VARCHAR(255) NOT NULL,
number int
);

//删除表DDL
drop table person3;
DROP table person2;


-----------------------我是华丽丽的分割线-------------------------------

select * from person where age=20;
select * from person where age>=25;
//日期是可以直接进行较的
select * from person where birthday>='2017-11-20'
//重点！！sql中进行null的判断
//错误的写法
select * from person where birthday = null;
//sql 中的连接语句 and OR not
select * from person where age=20 and courseId='1';
select * from person where age=20 or age=25;
select * from person where (age=20 or age=25) and courseId='1';
select * from person where  age=20 or age=25 and courseId='1';
//in
SELECT * from person where age in(20,25);
//not in
select * from person where age not in(20,25);
//between and
SELECT * from person where age between 20 and 40;

SELECT * from person where age not between 20 and 40;
//不等于的3种写法
select * from person where age !=20;
select * from person where age <>20;
select * from person where not age  =20;

//模糊查询,我们经常在搜索中能够用到
select * from person where name like '%张%';
//_下划线_代表匹配几个字符
select * from person where name like '%__%';
select * from person where password like '4_6';
//去重 distinct
select name from person；
select distinct name from person;
select distinct id,name from person;
//如果两列都是数字类型，那么两列可以相加
select *,salary+reward sumS from person;
select *,ifnull(salary,0)+ifnull(reward,0) from person;

//case when
select *, case salary When 1500 then 99 else salary end c from person;
select *, case  When salary>1500 then 99 else salary end c from person;
select *, case  When salary=1500 then 99 else salary end c from person;
//错误
select *, case salary When salary>1500 then 99 else salary end c from person;


//用case when代替ifnull，第一步
select *, case  When salary is null then 0 else salary end salary2 from person;
//用case when代替ifnull，完整版
select *, case  When salary is null then 0+(case when reward is null then 0 else reward end)
else salary+(case when reward is null then 0 else reward end) end salary2 
from person;

//排序 order by
select * from person order by age;
select * from person order by age asc;
select *,ifnull(age,99) age2 from person order by age2;
select *,age age2 from person order by ifnull(age2,99);
select * from person order by age desc;
select * from person order by age,birthday desc;

//sql中的函数
//count(*)计算总共行数
select count(*) from person;
//统计姓名不为空的人数
select count(name) from person;
//统计包含姓名为空的人数
select count(ifnull(name,1)) name from person;
//统计年龄最大的人
select max(age) FROM person;
//统计年龄最小的人
select min(age) from person;
//统计person表的平均年龄
select avg(age) from person;
//对person 表中的年龄求和
select sum(age) from person;

//分组 group BY
//统计person表中的人选了哪几门课程
select courseId from person GROUP BY courseId;
//以姓名，课程id分组
select name,courseId FROM person GROUP BY name,courseId;
//错误的写法
select name,courseId FROM person GROUP BY courseId;
//统计每门课程有多少人选
select courseId ,count(name) "人数" from person group BY courseId;
//统计每门课程有多少人选（包含空值）
select courseId,count(*) from person GROUP BY courseId;
//统计每门课程有多少年龄大于50的人
select courseId,count(name) from person where age>50 GROUP by courseId ;
//错误的写法
select courseId,count(name) from person  GROUP by courseId where age>50;

//hanving 类似where ，筛选关键字
//统计每门课程的选择者们的平均年龄
select avg(age) ,courseId from person group by courseId;
//统计每门课程的选择者们的平均年龄大于50的课程号
select avg(age) age ,courseId from person group by courseId having age>50;

//统计每门课程年龄大于50的人的人数大于等于3的课程号
//第一步，统计每门课程有多少年龄大于50的人
select courseId,count(name) from person where age>50 GROUP by courseId ;
//第二步，统计每门课程年龄大于50的人的人数大于等于3的课程号
select courseId,count(name) count from person where age>50 GROUP by courseId having count>=3;
//找出被选则人数最多的课程
//第一步，求出每门课程有多少人选
select courseId,count(name) count from person GROUP BY courseId;
//第二步，找出被选则人数最多的课程
select courseId,count(name) count from person GROUP BY courseId having count=max(count);

//重要，分页，limit
//查询前3条记录
select * from person limit 0,3;
//查询第3条，到第5条的记录
select * from person limit 2,3;


-----------------------我是华丽丽的分割线-------------------------------

//多表查询
//内连接
select * from person p inner join course c on p.courseId2=c.courseId;
//或者
select * from person p  join course c on p.courseId2=c.courseId;

//左外链接
select * from person p left join course c on p.courseId2=c.courseId;
//右外链接
select * from person p right join course c on p.courseId2=c.courseId;
//全链接，在mysql中不支持
select * from person p full  join course c on p.courseId2=c.courseId;
//全链接，可以这么写
select * from person p left  join course c on p.courseId2=c.courseId
UNION
select * from person p right  join course c on p.courseId2=c.courseId;


//多表查询依然可以写聚合函数，wheretiaojian
//多表查询，年龄大于25的人有哪些
select * from person p left join course c on p.courseId2=c.courseId where p.age>25;
//如果不加别名 默认是from后面的那个表
select * from person p left join course c on p.courseId2=c.courseId where age>25;


//多表删除
delete p from person p LEFT JOIN course on p.courseId=course.courseId where p.id=7; 
delete p from person p LEFT JOIN course c on p.courseId=c.courseId where p.id=7; 
delete p,c from person p LEFT JOIN course c on p.courseId=c.courseId where p.id=7; 



//子查询
//查询person表中年龄最大的人
select max(age) age from person;

//我如果想知道他的id呢？这样写可以吗？
//错误写法
select id, max(age) age from person;
//正确写法(where 后面的子查询)
select* from person p where p.age=(select max(age) age from person);
//查询person表中比年龄最小的人的年龄大的人
select* from person p where p.age>(select min(age) age from person);


//我还想知道person表中年龄最大的人选的课程信息呢？
select *  from person p  left join course c on p.courseId2=c.courseId 
where p.age=(select MAX(age)from person p)

//我还想知道person表中年龄最大的人选的课程信息呢？（方法二）
select *
from 
	person p 
left join 
	course c on p.courseId2=c.courseId
JOIN
 (select max(age) age from person ) p2 on p.age=p2.age


//正确写法(from 后面的子查询)
//错误的写法
  select name from (select name FROM person );
//正确的写法
  select name from (select name FROM person ) p;
