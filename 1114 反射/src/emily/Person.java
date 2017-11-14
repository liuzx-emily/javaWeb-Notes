package emily;


public class Person {
	public String name;
	private Integer age=20;

	public Person() {
		this.name ="–°∫Ï";		
	}

	public Person(String name) {
		this.name = name;		
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setAge() {
		this.age = 9999;
	}
	
	public void show(){
		System.out.println("Œ“Ω–"+this.name+"£¨Œ“"+this.age+"ÀÍ");
	}
}
