package emily;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Reflect {

	public static void main(String[] args) throws Exception{
		

		Class c1 = Class.forName("emily.Person");
		
		// �����޲����Ĺ��캯��
		Person p1=(Person) c1.newInstance();
		
		// �����в����Ĺ��캯��
		Constructor cs1=c1.getConstructor(String.class);
		Person p2=(Person) cs1.newInstance("С�ں�");
		
		// ������private������
		Field f1=c1.getDeclaredField("name");
		f1.set(p1, "�ڹ�");		
		// ����private������
		Field f2=c1.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p1, 37);
		p1.show();
		
		// ������ͨ����
		Method m1=c1.getDeclaredMethod("setAge",Integer.class);
		// m1.setAccessible(true);
		m1.invoke(p2, -200);
		p2.show();
		
		// ����static�����ԡ������������λ��дnull
		// f3.set(null 37);
		// m3.invoke(null, -200);
	}

}
