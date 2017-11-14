package emily;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Reflect {

	public static void main(String[] args) throws Exception{
		

		Class c1 = Class.forName("emily.Person");
		
		// 操作无参数的构造函数
		Person p1=(Person) c1.newInstance();
		
		// 操作有参数的构造函数
		Constructor cs1=c1.getConstructor(String.class);
		Person p2=(Person) cs1.newInstance("小黑黑");
		
		// 操作非private的属性
		Field f1=c1.getDeclaredField("name");
		f1.set(p1, "乌龟");		
		// 操作private的属性
		Field f2=c1.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p1, 37);
		p1.show();
		
		// 操作普通方法
		Method m1=c1.getDeclaredMethod("setAge",Integer.class);
		// m1.setAccessible(true);
		m1.invoke(p2, -200);
		p2.show();
		
		// 操作static的属性、方法：对象的位置写null
		// f3.set(null 37);
		// m3.invoke(null, -200);
	}

}
