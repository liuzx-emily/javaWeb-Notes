package emily.entity;

public class Student {
	
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void printInfo(){
		String txt="【学生信息：姓名 "+this.name+"，年龄 "+this.age+"】";
		System.out.println(txt);
	}
}
