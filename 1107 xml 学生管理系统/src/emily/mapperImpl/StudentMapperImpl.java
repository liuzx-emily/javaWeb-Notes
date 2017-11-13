package emily.mapperImpl;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import util.Dom4jUtil;
import emily.entity.Student;

public class StudentMapperImpl implements emily.mapper.StudentMapper {
	private Dom4jUtil dom4jUtil;
	private Document document;
	
	public StudentMapperImpl(String path) throws Exception {
		this.dom4jUtil = new Dom4jUtil();
		this.dom4jUtil.setPath(path);
		this.document=this.dom4jUtil.read();
	}

	@Override
	public void add(Student student) {
		String name=student.getName();
		Integer age=student.getAge();
		Element root=this.document.getRootElement();
		Element newStudent=root.addElement("student");
		Element newName=newStudent.addElement("name");	
		newName.setText(name);
		Element newAge=newStudent.addElement("age");
		newAge.setText(age.toString());
		try {
			this.dom4jUtil.write(this.document);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public Integer query(String name) {
		// TODO Auto-generated method stub
		Student student=new Student();
		student.setName(name);
		List<Node> list=this.document.selectNodes("//name");
		Integer resultNum=0;
		for (Node node : list) {
			String value=node.getText();
			if(value.equals(name)){
				resultNum++;
				Element father=node.getParent();
				Node ageElement=father.selectSingleNode("//age");
				Integer ageValue=Integer.parseInt(ageElement.getText());
				student.setAge(ageValue);
				System.out.print("查询结果：");
				student.printInfo();
			}
		}
		if(resultNum!=0){
			System.out.println("-----共有"+resultNum+"条查询结果-----\n");
		}else{
			System.out.println("-----无查询结果-----\n");			
		}
		return resultNum;
	}

	@Override
	public Integer remove(String name) {
		List<Node> list=this.document.selectNodes("//name");
		Integer resultNum=0;
		for (Node node : list) {
			String value=node.getText();
			if(value.equals(name)){
				resultNum++;
				Element father=node.getParent();
				Element grandfather=father.getParent();
				grandfather.remove(father);
				break;				
			}
		}
		if(resultNum!=0){
			System.out.println("-----共删除了"+resultNum+"条数据-----\n");
		}else{
			System.out.println("-----无查询结果-----\n");			
		}
		try {
			this.dom4jUtil.write(this.document);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return resultNum;
	}

}
