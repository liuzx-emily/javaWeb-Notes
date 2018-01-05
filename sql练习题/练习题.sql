1.查询出部门编号为30的所有员工 
-- SELECT * FROM emp WHERE deptno=30;

2.所有销售员的姓名、编号和部门编号。 
-- SELECT e.ename,e.empno,e.deptno FROM emp e WHERE e.job=’销售员’;

3.找出奖金高于工资的员工。 
-- SELECT * FROM emp WHERE COMM>sal;

4.找出奖金高于工资60%的员工。 
-- SELECT * from emp where COMM>sal*0.6;

5.找出部门编号为10中所有经理，和部门编号为20中所有销售员的详细资料。 
-- SELECT * FROM emp where (deptno=10 and job=’经理’) or (deptno=20 and job=’销售员’);

6.找出部门编号为10中所有经理，部门编号为20中所有销售员， 
还有即不是经理又不是销售员但其工资大或等于20000的所有员工详细资料。 
-- SELECT * FROM emp where (deptno=10 and job=’经理’) or (deptno=20 and job=’销售员’) 
-- or (job NOT IN (‘销售员’,’经理’) AND sal>=20000);

7.有奖金的工种。 
-- SELECT DISTINCT job FROM emp where COMM is not NULL ;

8.无奖金或奖金低于1000的员工。 
-- SELECT * from emp WHERE COMM is NULL or emp.COMM<1000;

9.查询名字由三个字组成的员工。 
-- select * from emp where ename LIKE ‘_‘;

10.查询2000年入职的员工。 
-- select * from emp where hiredate LIKE ‘2000%’;

11.查询所有员工详细信息，用编号升序排序 
-- SELECT * FROM emp ORDER BY empno ASC ;

12.查询所有员工详细信息，用工资降序排序，如果工资相同使用入职日期升序排序 
-- select * from emp ORDER BY sal desc,hiredate asc;

13.查询每个部门的平均工资 
-- select deptno,avg(sal) from emp GROUP BY deptno;

14.求出每个部门的雇员数量。 
-- select deptno,count(1) from emp GROUP BY deptno;

15.查询每种工作的最高工资、最低工资、人数 
-- SELECT job,max(sal),min(sal),count(1) from emp group by job;

16.显示非销售人员工作名称以及从事同一工作雇员的月工资的总和，并且要满足从事同一工作的雇员的月工资合计大于50000，输出结果按月工资的合计升序排列 
-- select job,sum(sal) from emp where job<>’销售员’ GROUP BY job HAVING sum(sal)>50000 ORDER BY sum(sal) asc;



/*
	1. 查出至少有一个员工的部门。显示部门编号、部门名称、部门位置、部门人数。
*/

SELECT
	d.*, z1.cnt
FROM
	dept d,
	(
		SELECT
			deptno,
			COUNT(*) cnt
		FROM
			emp
		GROUP BY
			deptno
	) z1
WHERE
	d.deptno = z1.deptno 

/*
	2. 列出所有员工的姓名及其直接上级的姓名。
*/
	SELECT
		e.ename,
		t.ename
	FROM
		emp e
	LEFT JOIN emp t ON e.mgr = t.empno


/*
	3. 列出受雇日期早于直接上级的所有员工的编号、姓名、部门名称。
*/
	SELECT
		e.empno,
		e.ename,
		d.dname
	FROM
		emp e LEFT JOIN dept d ON d.deptno = e.deptno,
 		emp t
	WHERE
		e.mgr = t.empno
	AND e.hiredate < t.hiredate

/*
	4. 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。
*/
	SELECT
		d.dname,
		e.*
	FROM
		dept d
	LEFT JOIN emp e ON d.deptno = e.deptno

/*
	5. 列出最低薪金大于15000的各种工作及从事此工作的员工人数。
*/
	SELECT
		job,
		COUNT(*)
	FROM
		emp e
	GROUP BY
		job
	HAVING
		MIN(sal) > 15000
/*
	6. 列出在销售部工作的员工的姓名，假定不知道销售部的部门编号。
*/
	SELECT
		*
	FROM
		emp e
	WHERE
		e.deptno = (
			SELECT
				deptno
			FROM
				dept
			WHERE
				dname = '销售部'
		)
/*
	7. 列出薪金高于公司平均薪金的所有员工信息，所在部门名称，上级领导，工资等级。
*/
	
	SELECT
		e.*, d.dname,
		m.ename,
		s.grade
	FROM
		emp e
	LEFT OUTER JOIN dept d ON e.deptno = d.deptno
	LEFT OUTER JOIN emp m ON e.mgr = m.empno
	LEFT OUTER JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal
	WHERE
		e.sal > (SELECT AVG(sal) FROM emp) SELECT
			*
		FROM
			emp;


/*
	10.列出与庞统从事相同工作的所有员工及部门名称。
*/
	SELECT
		e.*, d.dname
	FROM
		emp e
	LEFT JOIN dept d ON e.deptno = d.deptno
	WHERE
		e.job = (
			SELECT
				job
			FROM
				emp
			WHERE
				ename = "庞统"
		) 

/*
	11.列出薪金高于在部门30工作的所有员工的薪金的员工姓名和薪金、部门名称。
*/
	SELECT
		e.ename,
		e.sal,
		d.dname
	FROM
		emp e
	LEFT JOIN dept d ON e.deptno = d.deptno
	WHERE
		e.sal > ALL (
			SELECT
				sal
			FROM
				emp
			WHERE
				deptno = 30
		)
/*
	12.查出年份、利润、年度增长比
*/
	SELECT
		tb. YEAR,
		tb.zz,
		CONCAT(IFNULL(tb.zz / t.zz - 1, 0)*100,"%") "增长比"
	FROM
		tb
	LEFT JOIN tb t ON tb. YEAR - 1 = t. YEAR

