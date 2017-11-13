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
		System.out.println("���ѧ������������Ϣ��");
		Student student = new Student();
		Scanner sc=new Scanner(System.in);
		System.out.print("\t������");
		String name=sc.next();
		student.setName(name);
		System.out.print("\t���䣺");
		Integer age=Integer.parseInt(sc.next());
		student.setAge(age);	
		this.mapper.add(student);
		System.out.print("��Ϣ��ӳɹ���");
		student.printInfo();
		
	}

	@Override
	public void query() {
		// TODO Auto-generated method stub
		System.out.print("������Ҫ��ѯ��ѧ��������");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		this.mapper.query(name);
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		System.out.println("������Ҫɾ����ѧ������");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		this.mapper.remove(name);	
		
	}

	
	
}
