package emily.serviceImpl;

import java.util.Scanner;

import emily.entity.Student;
import emily.mapper.StudentMapper;
import emily.mapperImpl.StudentMapperImpl;
import emily.service.StudentService;

public class StudentServiceImpl  implements StudentService{
	

	private StudentMapper mapper;
	
	public StudentServiceImpl(){
		try {
			mapper=new StudentMapperImpl("src/students.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("添加学生，请输入信息：");
		Student student = new Student();
		Scanner sc=new Scanner(System.in);
		System.out.print("\t姓名：");
		String name=sc.next();
		student.setName(name);
		System.out.print("\t年龄：");
		Integer age=Integer.parseInt(sc.next());
		student.setAge(age);	
		this.mapper.add(student);
		System.out.print("信息添加成功：");
		student.printInfo();
		
	}

	@Override
	public void query() {
		// TODO Auto-generated method stub
		System.out.print("请输入要查询的学生姓名：");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		this.mapper.query(name);
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		System.out.println("请输入要删除的学生姓名");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		this.mapper.remove(name);	
		
	}

	
	
}
