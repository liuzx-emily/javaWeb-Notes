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
		String txt="��ѧ����Ϣ������ "+this.name+"������ "+this.age+"��";
		System.out.println(txt);
	}
}
