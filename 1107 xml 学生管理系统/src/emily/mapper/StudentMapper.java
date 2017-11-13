package emily.mapper;

import emily.entity.Student;

public interface StudentMapper{
	
	public void add(Student student);
	
	public Integer query(String name);
	
	public Integer remove(String name);
}
