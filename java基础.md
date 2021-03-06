## 变量

变量是内存中的小容器，用来存储数据。

最小信息单元叫"位(bit)"，最小存储单元叫"字节(byte)"，一个字节是由连续的8个位组成。
当程序需要使用存储空间时，操作系统最小会分派给程序1字节，而不是1位。

1B(字节) = 1byte = 8bit = 8b
1KB = 1024B
1MB = 1024KB
1GB = 1024MB
1TB = 1024GB
1PB = 1024TB



---



## java中的数据类型

#### 基本数据类型：四类八种	
|         |       |                                      |
| ------- | ----- | ------------------------------------ |
| byte    | 1字节 | -128～127                            |
| short   | 2字节 | -32768～32767                        |
| int     | 4字节 | -2147483648～2147483648              |
| long    | 8字节 | -3.403E38～3.403E38                  |
| float   | 4字节 | -2^63～2^63-1                        |
| double  | 8字节 | -1.798E308～1.798E308                |
| char    | 2字节 | 0~65535 表示一个字符，如'a' '0' '家' |
| boolean | 1字节 | 只有两个值true与false                |


八种基本类型都有对应的包装类：包装类是对象，可以是null，可以有属性和方法。

集合中只能存储引用类型，所以不能用int，要用Integer

虽然int和float都是4字节，但运算标准不同，所以取值范围不同。（java中浮点数采用IEEE 754标准）


#### 引用数据类型: 数组、类、接口、枚举
Collection、Map是interface

ArrayList、HashSet、HashMap是 class



---



## 数据类型转换
- 自动： 范围小 -> 范围大 
- 手动：强制  范围大 -> 范围小
  ```java
  float f1 = 1.5;        // 报错
  float f2 = (float)1.5;
  ```
- boolean类型不能进行任何类型转换


例：打印a-z
```java
char c='a';
for(int i=0;i<26;i++){
  System.out.println(c);
  // c=c+1;	// 报错
  c++;	// 不报错，等价于c=(char)c+1;
}
```


---


## 逻辑运算符

位运算符：与（&）、非（~）、或（|）、异或（^）

- !	非
- &&	短路与
- ||	短路或

短路：左边能判断出结果，则右边的部分就不再运行



---



## Scanner类：输入
包：java.util.Scanner;

```java
Scanner sc = new Scanner(System.in);
String str = sc.next();
int n = sc.nextInt();
double d = sc.nextDouble();
```


---




## Random类：随机数
包：java.util.Random;
```java
Random r = new Random(); 
// nextInt 随机整数 [0,n)
int i = r.nextInt(100); 
// nextDouble 随机小数 [0.0,1.0)
double d = r.nextDouble(); 
``` 


---



## switch语句
```java
switch (表达式){
	case 目标值1:
		执行语句1
		break;
	．．．．．．
	default:
		执行语句n+1
		break;
}
```
表达式只能是：byte、short、char、int类型和对应包装类的值  
jdk5.0+：枚举  
jdk7.0+：String


---



## 数组

```java
int[] arr1 = new int[100];	// arr中每个元素都是默认值
int[] arr2={1,2,3,4};
// 二维数组
int[][] arr3 = new int[3][4];
int[][] arr4 = {{1,2},{3,4,5,6},{7,8,9}};
```

| 数据类型            | 默认初始化值          |
| ------------------- | ------------------ |
| byte short int long | 0                  |
| float double        | 0.0                |
| char                | 一个空格，即’\u0000’ |
| boolean             | false              |
| 引用类型             | null               |


- 数组是引用类型，arr中存的是数组第一个元素的首地址。
- 数组的长度在定义时确定，之后不能更改。
- 数组的元素必须是同一个类型，是在定义时指定的。


#### 复制数组
System类中的静态方法：  
`System.arraycopy(Object src,int srcPos,Object dest,int destPos,int length)`  
将源数组的部分元素复制到目标数组的指定位置
```java
int[] src = {1,2,3,4,5};
int[] dest = {6,7,8,9,10};
System.arraycopy(src,0,dest,0,3); 	//dest:[1,2,3,9,10]
```



---




## Arrays类
此类包含用来操作数组的各种方法

```java
// sort：升序排序
int[] arr1 = {1,5,9,3,7};
Arrays.sort(arr1);					// arr1:{1,3,5,7,9}

// toString 只有转一维数组时好用。转多维数组的结果是 [地址,地址,地址]
int[] arr2 = {1,5,9,3,7};
String str = Arrays.toString(arr2); 	// str:[1, 3, 5, 7, 9]

// binarySearch：查找给定元素值出现的位置。若没有查询到，返回值为负。要求该数组必须是个有序的数组。
int[] arr3 = {1,3,4,5,6};
int index = Arrays.binarySearch(arr3, 4); // 2
int index2= Arrasy.binarySearch(arr3, 7); // -6
```

Collections中提供了很多静态方法，是对Collection的操作

Arrays中提供了很多静态方法，是对数组的操作




---



## 长度的3种表示
-	数组.length
-	字符串.length()
-	集合.size()



---




## 方法重载

根据参数不同来区分。和返回值无关

`System.out.println()`就是重载



---




## new的时候发生了什么？

`Phone p=new Phone();`内存中发生了什么？
1. JVM在堆内存中开辟了一块空间，存储新new的对象
2. 属性也跟着进入堆内存，赋予默认值
3. JVM把这块内存的地址，传递给p



---




## 集合

#### 集合和数组的区别
| 集合 | 数组 |
| --- | --- |
| 长度固定 | 长度可变 |
| 基本、引用都能存 | 只能存引用 |
| 存储的元素必须是同一个数据类型 | 存储的对象可以是不同数据类 |



#### Collection接口中的方法
- `Object[] toArray()` 集合转成数组
- `boolean contains(Object o)` 判断对象是否存在于集合中。实现类中都是用equals逐个判断
- `void clear()` 清空集合中的所有元素
- `boolean remove(Object o)` 移除集合中指定的元素（有多个的话只移除第一个）



#### 集合继承关系图

collection接口
- List接口
  - ArrayList类
  - LinkedList类
- Set接口
  - HashSet类
    - LinkedHashSet类


										
---



## List接口

```java
List<String> list = new ArrayList<String>();

add(Object e)
add(int index, Object e)

remove(Object e) 			// 返回值为被删除的元素
remove(int index) 			// 返回值为被删除的元素

set(int index, Object e)	// 替换

get(int index)
```

遍历：
```java
// 普通for
for(int i=0;i<list.size();i++){
  
}
// 增强for（底层用的是迭代器）
for (String txt : list) {
  
}
// 迭代器
Iterator<String> it=list.iterator();
while(it.hasNext()){
	// it.next()			
}
```

Iterator的并发修改异常：`java.util.ConcurrentModificationException`
在迭代时，不要改变集合的长度。
```java
Iterator<String> it = list.iterator();	//包含"a" "b" "c"
while(it.hasNext()){
  String str = it.next();
  if("b".equals(str)){
    list.add("123");	// 该操作会导致程序出错
  }
}
```
增强for底层也是使用迭代器，所以也会报错。 
普通for没有用Interator，所以不会报错



---



## set集合
不能有重复，通过元素的`equals`方法，来判断是否为重复元素

遍历方法：
- 增强for
- 迭代器
  ```java
  Iterator<String> it=set.iterator();
  while(it.hasNext()){
    // it.next();
  }
  ```


---



## HashSet
此类实现Set接口，采用哈希表结构存储数据（实际上是一个HashMap集合）
哈希表：链表数组结合体。存取、查询都快，线程不安全。

HashSet集合不能保证迭代顺序与元素存储顺序相同。

#### 如何保证元素唯一性？
`hashCode()`和`equals()`  
这两个方法都在Object类中。因为Object是所有类的父类，so所有类都有这两个方法。  
在向哈希表中存放对象时，会调用对象的hashCode方法，算出对象在表中的存放位置。如果两个对象hashCode方法算出结果一样("哈希冲突")，这时会调用对象的equals方法，比较这两个对象是不是同一个对象。

java的内置类(String类、Integer类)已经重写过这两个方法，所以向HashSet中存储内置类时，不需要重写这两个方法。  
但是存放自定类的对象时，若想要建立自己的比较方式，必须重写hashCode和equals方法

```java
Set<String> set =new HashSet<String>();
set.add("aaa");
set.add("bbb");		// 返回true
set.add("ccc");
set.add("ddd");
set.add("bbb");		// 返回false
for (String string : set) {
  System.out.print(string+'\t');
}
```
输出结果:	`aaa	ddd	ccc	bbb`

说明：
String类重写了hashCode方法，是通过包含的所有字符计算出来的。所以两个"bbb"计算出来的hashCode相同。
哈希冲突，为了判断它们是不是相同元素，会调用equals方法去比较两个对象。
因为String类重写了equals方法，比较的不是地址，而是字符，所以返回true。
set就认为这两个"bbb"是相同的，不重复存储。


HashSet有一个子类LinkedHashSet，它能保证元素的存入和取出的顺序一致。





-----------------Collections-----------------
Collections是集合工具类，用来对集合进行操作。部分方法如下：

1 sort(List)	// 对List升序
	Collections.sort(list);	//[33,11,77,55] -> [11,33,55,77]


2 shuffle(List) // 对List打乱存储顺序
	//list集合元素 [11,33,55,77]
	Collections.shuffle(list);
	//使用shuffle方法后，集合中的元素为[77,33,11,55]，每次执行该方法，集合中存储的元素位置都会随机打乱


3 emptyList()、emptySet()、emptyMap()
	如果你想new一个空List，并且以后也不打算再添加元素，那么就用 Collections.emptyList()。
	new ArrayList() 或者 new LinkedList() 在创建的时候有会有初始大小，浪费内存


【
	Collections中提供了很多静态方法，是对Collection的操作
	Arrays中提供了很多静态方法，是对Array的操作
】





-----------------map接口-----------------
collection中的元素是"单身"的，map中的元素是"成对"的。collection和map之间没有任何继承关系。

map<K,V>接口
	———HashMap<K,V> 最常用的Map实现。只是将一个键和值相对应，并没有其他的功能。
		———LinkedHashMap<K,V> 可以保证元素的存取顺序一致

如果键是自定义对象，为了保证唯一性，需要重写键的hashCode()、equals()方法。

	Map<String,Integer> map = new HashMap<String,Integer>();
	
	put()
	get()


遍历方法：
	1 获取所有的key，通过key得到value【利用key的唯一性】
		Set<String> keySet=map.keySet();
		for(String key:keySet){
			Integer value=map.get(key);		
		}
	2 Entry是Map中用来保存一个键值对的，而Map实际上就是多个Entry的集合。
		Set<Entry<String,Integer>> entrySet=map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			String key=entry.getKey();
			Integer value=entry.getValue();
		}





【20180330】



--------------抽象类 抽象方法----------------

	abstract class Worker {
		public abstract void work();
	}

1 抽象方法只能定义在抽象类中。
2 abstract不可以和哪些关键字共存？	
	private	final static




--------------接口----------------
	public interface Animal{
		void eat();
	}

1 接口中的方法：
	只能是public abstract的，可以省略不写
	接口中：void eat();		// 等价于public abstract void eat();
	
  接口中的成员变量：
	只能是public static final的，可以省略不写，
  	接口中：int a=1; 		// 等价于public static final int a=1;
  	可以直接：接口.a

2 多个接口之间可以使用extends进行继承。
	interface Fu1{
		void show1();
	}
	interface Fu2{
		void show2();
	}
	interface Zi extends Fu1,Fu2{
		void show3();
	}

3 接口没有构造方法




---------------抽象类&接口-----------------
共同点：
	不可以new
	子类/实现类，如果没有重写所有抽象方法，那么子类仍然是抽象类

区别：
	class 缉毒犬 extends 犬科 implements 缉毒
	1 使用动机。使用抽象类是为了代码的复用，使用接口是为了实现多态性
	2 抽象类和它的子类之间应该是一般和特殊的关系，而接口仅仅是它的子类应该实现的一组规则。
	3 不能多继承（安全问题：如果两个父类都有a()，用谁的？），可以多实现




--------------------------------
java三大特征：继承 + 封装 + 多态





----------------多态----------------
多态：Animal a = new Cat();
	好处：提高了程序的扩展性。
	弊端：不可以访问Cat类中特有的方法。


当子父类中出现同名的成员，多态调用时：
	field编译看左边，运行看左边
	method编译看左边，运行看右边

	Fu f = new Zi();
	System.out.println(f.num);	// Fu中的num的值（多态调用）
	Zi z = new Zi();
	System.out.println(z.num);	// Zi中的num的值（不是多态调用）


	Fu f = new Zi();
	f.show();	// Zi中的show()（多态调用）
	





----------------instanceof----------------

	Person p1 = new Student();
	boolean flag1 = p1 instanceof Student; 	// true
	boolean flag2 = p1 instanceof Teacher; 	// false
	boolean flag3 = p1 instanceof Person; 	// true






----------------构造方法----------------
1 如果没有写构造方法，在编译时，编译器会自动添加默认的空构造方法
  如果我们手动给出了构造方法，则编译器不会再自动添加

2 一个类中可以有多个构造方法，多个构造方法是以重载的形式存在的
  构造方法之间的调用，可以通过this关键字来完成。

3 调用其他构造方法的语句必须定义在构造方法的第一行。
  可以使用this调用本类的其他构造方法，也可以使用super调用父类的构造方法
  super() 与 this() 不能同时在构造方法中存在

4 在构造方法中，默认的第一条语句为 super();
  它是用来访问父类中的空参数构造方法，进行父类成员的初始化操作

5 当父类中没有空参数构造方法的时候，怎么办？
	a: 通过super(参数) 显示访问父类有参数的构造方法
	b: 通过this(参数)访问本类中的其他构造方法，其他构造方法需要调用了有参super

6 构造方法可以被private修饰，作用：其他程序无法创建该类的对象





----------------this super---------------
1 this：
	一个构造方法调用另一个构造方法
	this.field

2 super：
	1 创建子类对象时，父类的构造方法会先执行，因为子类中所有构造方法的第一行有默认的隐式super();语句。
		当父类中没有空参数构造方法时，子类的构造方法必须有显示的super语句。
		
		如果子类的构造方法第一行写了this调用了子类的其他构造方法，那么就不会有默认的super()了

		父类构造方法中是否有隐式的super呢？
			也是有的。记住：只要是构造方法默认第一行都是super();
		父类的父类是谁呢？super调用的到底是谁的构造方法呢？
			Object类

	2 子父类中如果有重名成员，默认用子类的，想要用父类需要super.xxx




----------------继承中的构造方法---------------

1 如果我们没写任何的构造方法，编译器提供给我们一个空参数构造方法
  如果我们手动给出了构造方法，编译器不会再给我们提供默认的空参数构造方法

2 在构造方法中，默认的第一条语句为 super();
  它是用来访问父类中的空参数构造方法，进行父类成员的初始化操作

3 当父类中没有空参数构造方法的时候，怎么办？
	a: 通过 super(参数) 访问父类有参数的构造方法
	b: 通过 this(参数) 访问本类中其他构造方法，其他构造方法需要调用了有参super

4 super(参数) 与 this(参数) 不能同时在构造方法中存在






----------------final---------------
final是个修饰符，它可以用来修饰：
	类：不可以被继承
	field：常量，只能赋值一次。在编译生成.class文件后，变为常量值。
	method：不可以被覆盖
	局部变量



注：final修饰的成员变量filed，需要在创建对象前赋值，否则报错。
	class Demo {
		// 可以声明时直接赋值
		final int m = 100;
		
		final int n; 
		public Demo(){
			// 也可以在构造方法赋值
			n = 2016;
		}
	}





----------------static---------------
特点：
	被所有的对象所共享
	可以通过类名直接调用

注意事项：
	static的成员，随着类的加载而加载，优先于对象存在
	在static方法中，不能使用this super
	在static方法中，不能调用非static的变量、方法


使用public static final来定义静态常量。变量名全大写，多个单词使用下划线连接。
	public static final String COMPANY_NAME = "Tencent";

	





----------------匿名内部类---------------
内部类是为了应对更为复杂的类间关系。查看源代码中会涉及到，而在日常业务中很难遇到
最常用到的就是匿名内部类

	public abstract class Person{
		public abstract void eat();
	}
	Person  p = new Person(){
		public void eat() {
			System.out.println("eat.....");
		}
	};
	p.eat();

写多线程时常用




----------------权限修饰符---------------

					public	protected	默认的	private
在当前类中			Y		Y			Y		Y
同一包中的其他类	Y		Y			Y
不同包中的子类		Y		Y	
不同包中的其他类	Y

归纳一下：
	仅能在本类中访问：private
	本包中的类都可以访问：不加修饰符
	本包中的类与其他包中的子类可以访问：protected
	所有包中的所有类都可以访问：public

易错：不写修饰符的，在其他包中的子类里不能用




----------------protected---------------
protected：
	1 同一包中的类可以用
	2 其他包中的子类可以用

	public class A{
		protected void func(){}
	}
	
	// 另一个包中：
	public class B extends A{
		void func2(){
			func();				// ok
			new A().func();		// 报错
		}
		public static void main(String[] args){
			new B().func();		// ok
			new A().func();		// 报错
		}
	}



-----------------jdk-----------------
jdk版本：1.1   1.2   1.3   1.4   5.0（变化很大，所以不叫1.5，叫5.0）
jdk5.0新特性：
	泛型
	枚举
	自动拆装箱
	增强for
	可变参数



-----------------jdk5.0新特性：泛型-----------------
好处：
	1 提高代码的复用性
	2 提供了类型检查，减少了数据的强转类型转换，同时保证了类型安全

1 在集合、Map中使用泛型
	
2 在类中使用泛型
	例如：查看API
	class ArrayList<E>{ 
		public boolean add(E e){...}
    	public E get(int index){...}
	}

	ArrayList<String> list = new ArrayList<String>();

3 在方法中使用泛型
	例如，API中的ArrayList集合中的方法：
	public <T> T[] toArray(T[] a){...}

	ArrayList<String> list = new ArrayList<String>();
	Integer[] arr = new Integer[100];
	Integer[] result = list.toArray(arr);

4 泛型擦除
	泛型只存在于源代码中，编译后就不存在了（就像final的变量，在编译后就变为常量了）

5 泛型的限定
	interface Animal{
		void eat();
	}
	class 猫 extends Animal{
		void eat(){};
	}
	class 狗 extends Animal{
		void eat(){};
	}

	ArrayList<猫> list1 = new ArrayList<猫>();
	ArrayList<狗> list2 = new ArrayList<狗>();

	现在需要写一个通用方法，能遍历集合并调用eat()

	分析：
		如果用通配符?，得到的是Object类型，想要调用eat()还要强制转换为Animal类型，不安全
		要想办法控制方法的参数，让其只能接收"Animal对象或它的子类对象"
		泛型的限定：
		  ? extends Animal：可以传递Animal和子类对象
		  ? super   Animal：可以传递Animal和父类对象
		
		void myIterator(ArrayList<? extends Animal> arr){
			for(Animal animal:arr){
				animal.eat();
			}
		}

	说明：为什么不能直接用List<Animal>？
		参数类型为Animal的地方，可以传类型为Cat的对象
		参数类型为List<Animal>的地方，不可以传类型为List<Cat>的对象
		因为Cat是Animal的子类，但List<Cat>不是List<Animal>的子类

	注意：不能向List<? extends Animal>添加任意对象，除了null。
		  原因：http://blog.csdn.net/baple/article/details/25056169


6 泛型的通配符 ?
	1 当方法是使用原始的Object类型作为参数时，如下：
		void printList(List<Object> list) {}只能传List<Obejct>类型，不能传List<其他类>类型
		可以选择改为：
		void printList(List<?> list) {}	这样可以传List

	2 方法的业务逻辑与泛型类型无关时，如List.size(),List.clear()
		<T>表示确定的java类型，每次调用时就知道类型了
		<?>表示不确定的java类型，每次调用时也不知道，都是Object类型

	注意：
		List<Object>与List<?>并不等同，List<Object>是List<?>的子类。
		不能向List<?> list里添加任意对象，除了null。





-----------------jdk5.0新特性：枚举-----------------

枚举是一种特殊的类。
枚举类中声明的每一个枚举值，都是枚举类的一个实例对象。

http://blog.csdn.net/qq_27093465/article/details/52180865







-----------------jdk5.0新特性：自动拆装箱-----------------
基本类型 <----> 包装类 自动转换

	Integer i=10;	// 自动装箱
	int j=i;		// 自动拆箱

jdk1.4-中不能自动转换，上面的写法会报错，需要：
	Integer i=new Integer(10);
	int j=i.intValue();






-----------------jdk5.0新特性：增强for循环-----------------
为什么要引入增强for？
	为了替代Iterator。增强for的底层实现就是使用Iterator

谁能使用增强for？
	数组；实现了Iterator接口的集合

在集合中使用增强for遍历：
	list set实现了Iterator接口，所以可以使用增强for
	map没有实现Iterator接口，不可以使用增强for






-----------------jdk5.0新特性：可变参数-----------------
本质就是一个数组

	public static void main(String[] args) {
		add(1,2);
		add(2,3,4);		
	}
	public static void add(int...nums){
		int sum=0;
		for (int i : nums) {
			sum+=i;
		}
		return sum;
	}

可变参数必须放在最后；只能有一个可变参数





-----------------反射-----------------
框架，大多数都是使用反射来实现的

在框架开发中，都是基于配置文件开发
	在配置文件中配置了类，可以通过反射得到类中的所有内容：属性、构造方法、普通方法(private的也可以)

反射的原理：
	首先需要把java文件保存到本地硬盘 .java
	编译：.java -> .class文件
	使用jvm，把class文件通过类加载到内存中。class文件在内存中使用Class类表示

	当使用反射的时候，首先需要获取到Class类。得到了这个类之后，就可以操作class文件里面的所有内容

获取Class类的最常用方法：
	Class c1=Class.forName("emily.Person");	// 把class文件加载到内存中，并获取Class对象
	Person p1=(Person)c1.newInstance();		// 创建实例类





-----------------java画图-----------------		
生成验证码：
	
	// 得到图片缓冲区
	BufferedImage bi=new BufferedImage(70, 30, BufferedImage.TYPE_INT_RGB);
	
	// 得到绘制环境
	Graphics2D g2=(Graphics2D) bi.getGraphics();
	
	// 设置颜色
	g2.setColor(Color.PINK);		
	// 画一个矩形，填充整张图片（相当于设置了背景色）
	g2.fillRect(0, 0, 70, 30);
	

	// 设置颜色
	g2.setColor(Color.BLACK);	
	// 设置字体
	g2.setFont(new Font("微软雅黑",Font.ITALIC,16));
	// 写字
	g2.drawString("hello", 15,20);
	
	// 保存图片
	try {
		ImageIO.write(bi, "JPEG", new FileOutputStream("E:/hello.jpg"));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}




-----------------Object类-----------------
Object类是Java语言中的根类，即所有类的父类。
单根结构的优点：所有对象都有一个通用接口，所以它们最终都属于相同类型。

1 Object中的equals方法：	
	// 比较的是地址
	public boolean equals(Object obj) {
        return (this == obj);
    }

2 Object中的toString方法：返回对象的类型+@+内存地址值	
  在输出语句中，如果写的是对象，那么会默认调用对象的toString方法:
	syso(p);	// 等价于syso(p.toString());






## String类
Java 程序中的所有字符串字面值(如"abc")都是String类的对象


String是一个非可变类（immutable）。非可变类的实例是不能被修改的，每个实例中包含的信息都必须在该实例创建的时候就提供出来，并且在对象的整个生存周期内固定不变。
```java
String str1=new String("abc");
String str2="abc";
```
虽然两个语句都是返回一个String对象的引用，但是jvm对两者的处理方式是不一样的。  
对于第一种，jvm会马上在heap中创建一个String对象，然后将该对象的引用返回给用户。  
对于第二种，jvm首先会在内部维护的strings pool中通过String的 equels 方法查找是对象池中是否存放有该String对象
  - 如果有，则返回已有的String对象给用户，而不会在heap中重新创建一个新的String对象；
  - 如果对象池中没有该String对象，jvm则在heap中创建新的String对象，将其引用返回给用户，同时将该引用添加至strings pool中。
注意：使用第一种方法创建对象时，jvm是不会主动把该对象放到strings pool里面的，除非程序调用 String的intern方法。看下面的例子：




为什么输出str没有显示地址？
	————因为String类重写了toString()

字符串的值在创建之后不能更改。就是说一旦这个字符串确定了，那么在内存区域中就生成了这个字符串，字符串本身不能改变。
"abc"这个对象不能改变，但是变量str中的地址是可以改变的。
	String str="abc";
	str="def";	// "abc"对象不变。新建了一个String类对象"def"，把它的地址给str

通过使用双引号的方式创建对象与new的方式创建对象，有什么不同呢？
	String s3 = "abc";
	String s4 = new String("abc");
	System.out.println(s3==s4); //false
	System.out.println(s3.equals(s4)); //true,因为String重写了equals方法

	s3创建，在内存中只有一个对象"abc"。这个对象在字符串常量池中
	s4创建，在内存中有两个对象。一个new的对象在堆中，一个字符串本身对象"abc"在字符串常量池中

	length()

	substring(int beginindex)
	substring(int beginindex,int endIndex) [起,尾) 返回新字符串

	boolean startsWith(String prefix);
	boolean endsWith(String suffix);
	boolean contains(String s);
	int indexOf(String str);	// 查找第一次出现的索引，没有就-1
	int indexOf(String str,int fromIndex);

	char[] toCharArray();	// 转成字符数组

	booleans equals(Object anObject);
	booleans equalsIgnoreCase(String anotherString);

	String replace(char old,char new);
	String replace(String old,String new);
	String trim() 去除字符串两端空格，中间的不会去除，返回一个新字符串
	String toLowerCase();
	String toUpperCase();

```java
String s1 = "1";
String s2 = "1";
System.out.println("1" == "1"); // true
System.out.println(s1 == s2); // true
System.out.println(s1 == "1"); // true
```


-----------------StringBuilder-----------------
String浪费内存，所以使用StringBuilder

StringBuilder类：字符串缓冲区，速度快，线程不安全，用在字符串缓冲区被单个线程使用的时候(这种情况很普遍)
StringBuffer类：也是字符串缓冲区，速度慢，线程安全。不建议用

	append(String str)
	insert(int offset,String str)
	deleteCharAt(int index)
	delete(int start,int end)
	replace(int start,int end,String str)
	reverse()
	substring(int start) 
	substring(int start,int end) 





-----------------正则-----------------
String类中正则相关的方法：
	boolean matches(String regex);
	String[] split(String regex);
	String replaceAll(String regex,String replacement);


	String s = "Hello123World678";
	String regex = "\\d";
	String result = s.replaceAll(regex, "*");	// Hello***World***




-----------------Date-----------------
时间和日期类：java.util.Date  

毫秒的0点: 1970年1月1日 0:00:00
	System.currentTimeMillis() 获取当前日期的毫秒值
	long time = System.currentTimeMillis();


重要: 时间和日期的计算,必须依赖毫秒值


	Date date = new Date();		// 当前操作系统中的时间和日期

	/*
	 * 构造方法(long)
	 */
	Date date = new Date(0); 	
	System.out.println(date);	// Thu Jan 01 08:00:00 CST 1970

	/*
	 *  setTime(long)
	 */
	Date date = new Date();
	date.setTime(0);

	
	/*
	 *  getTime()
	 */
	Date date = new Date();
	long time = date.getTime();




-----------------Date转String-----------------
格式化输出Date:
	/*
	 * 如何对日期格式化
	 *  步骤:
	 *    1. 创建SimpleDateFormat对象
	 *       在类构造方法中,写入字符串的日期格式 (自己定义)
	 *    2. SimpleDateFormat调用format()对日期进行格式化
	 *         String format(Date date)
	 *    日期模式:
	 *       yyyy    年份
	 *       MM      月份
	 *       dd      月中的天数
	 *       HH      0-23小时
	 *       mm      分钟
	 *       ss      秒
	 */
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分钟ss秒");
	String date = sdf.format(new Date());
	System.out.println(date);





-----------------String转Date----------------
	/*
	 *  DateFormat类方法 parse
	 */
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date = sdf.parse("1995-5-6");
	System.out.println(date);




-----------------Calendar类----------------
	/*
	 *   日历类 java.util.Calendar
	 *   抽象类,使用他的子类对象
	 *   
	 *   Calendar类的静态方法 getInstance() 直接返回子类对象
	 */
	Calendar c = Calendar.getInstance();
	System.out.println(c);
	

	/*
	 * int get(int field)
	 */
	// 获取年份
	int year = c.get(Calendar.YEAR);
	// 获取月份
	int month = c.get(Calendar.MONTH) + 1;
	// 获取天数
	int day = c.get(Calendar.DAY_OF_MONTH);
	System.out.println(year + "年" + month + "月" + day + "日");


	/*
	 * set(int field,int value)
	 * set(int year,int month,int day)
	 */
	// 设置到10月
	c.set(Calendar.MONTH, 9);
	// 设置到2019年5月1日
	c.set(2019, 4, 1);


	/*
	 * add(int field, int value)：进行整数的偏移 
	 */
	// 向后偏移280天
	c.add(Calendar.DAY_OF_MONTH, 280);
	

	/*
	 * getTime() ：把日历对象,转成Date日期对象
	 */
	Date date = c.getTime();
	



-----------------包装类Integer----------------
String转int：
	int Interger.parseInt(String s);
	int Interger.parseInt(String s,int radix);	// 进制

int转String：
	int i=3;
	String s1=i+"";
	String s2=Integer.toString(i);	// 麻烦




-----------------System类----------------

static long currentTimeMillis() 获取当前系统时间的毫秒值(1970)
static void exit(int status) 结束正在运行的Java程序。参数传入一个数字即可。通常传入0记为正常状态，其他为异常状态
static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length) 将源数组的部分元素复制到目标数组的指定位置
	int[] src = new int[]{1,2,3,4,5};
	int[] dest = new int[]{6,7,8,9,10};
	System.arraycopy(src,0,dest,0,3); 	//dest:[1,2,3,9,10]







-----------------BigInteger----------------
java中long型为最大整数类型，对于超过long型的数据如何去表示呢？
	用BigInteger去模拟
	加减乘除是调用方法，而不是直接用运算符。

	BigInteger big1 = new BigInteger("123456789098765432154210");
	BigInteger big2 = new BigInteger("98765432101234567890");
	BigInteger res1 = big1.add(big2);
	subtract
	multiply
	divide



-----------------BigDecimal----------------
    syso(0.09 + 0.01);	//0.09999999999999999
    syso(1.0 - 0.32);	//0.6799999999999999
    syso(1.015 * 100);	//101.49999999999999
    syso(1.301 / 100);	//0.013009999999999999

double和float类型在运算中很容易丢失精度，造成数据的不准确性，Java提供BigDecimal类可以实现浮点数据的高精度运算。

	BigDecimal big1 = new BigDecimal("0.09");
    BigDecimal big2 = new BigDecimal("0.01");
    //add
    BigDecimal bigAdd = big1.add(big2);
    
   	subtract
    multiply
    divide：除法，可以指定保留位数，和保留方式






-----------------异常-----------------
异常就是一个类。产生了一个异常，就是产生了一个类的对象

Throwable
	---Error
	---Exception
		---非RuntimeExcetion
		---RuntimeException

Error错误：只会出现在【运行期】。通常没有具体的处理方式，程序将会结束运行。Error错误的发生往往都是系统级别的问题，都是jvm所在系统发生的，并反馈给jvm的。我们无法针对处理，只能修正代码。
	int[] arr = new int[1024*1024*100];	//outOfMemoryError

Exception异常：出现在编译、运行期间。可以对异常进行具体的处理。若不处理异常，程序将会结束运行。
	比如：ArrayIndexOutOfBoundsException


区分throw和throws：
	throw：抛出异常 throw new Exception();
	throws：声明异常 throws Exception

处理异常的方法：throws和try...catch

（1）处理异常：throws
	public static void main(String[] args) throws Exception {
		myException();
	}
	public static int myException() throws Exception {
		throw new Exception("异常演示");		
	}
	说明：
		myException方法内新建一个异常对象，并且抛出给它的调用者main。
		main把异常抛出给jvm。
		jvm在控制台打印错误信息，中止程序运行。

（2）处理异常：try..catch
	try {
		...
	}catch(异常类 变量) {
		...
	}finally {
		...
	}
	finally：无论异常是否发生，都一定会执行的语句。即使try、catch中有return或者抛出新异常，那么finally中的语句还是会"顽强"地执行。除非碰上System.exit(0)。常用于：释放资源

	public static void main(String[] args){
		try{
			myException();			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static int myException() throws Exception {
		throw new Exception("异常演示");		
	}
	说明：
		myException方法内新建一个异常对象，并且抛出给它的调用者main。
		因为main函数有try..catch，所以接到的异常不抛给虚拟机，而是在对应的catch中处理。处理之后接着运行程序。


多catch：有顺序。所以父类异常写后面的catch里，子类写前面的。


异常分为:
	运行异常: RuntimeException类和其子类
	编译异常: Exception中所有的其他类

运行异常的特点:	【不需要处理：不用throws，也不用try catch】
	设计原因：运行异常一旦发生，不要处理，请你修改源代码。运行异常一旦发生,后面的代码没有执行的意义
	public static void main(String[] args){
         myRuntimeException();
    }
    public static void myRuntimeException(){
        throw new RuntimeException();
    }

继承后,在子类重写父类方法的时候,异常处理
  父类的方法如果抛出异常A,子类重写后
    可以不抛出异常
    也可以抛出异常,但是,如果子类要抛,抛出的异常必须是A或A的子类
      
  父类的方法没有抛出异常,子类重写后也不能抛出异常

Throwable类中的方法:
  void printStackTrace() 将异常信息追踪到标准的错误流(JVM默认调用的就是这个方法)


如果Java没有提供你需要的异常，则可以自定义异常类。
编译时异常继承Exception，运行时异常继承RuntimeException。在构造方法中,用super将异常信息传递给父类





-----------------File-----------------
Java中把"文件"或者"目录"（文件夹）都封装成File对象。

构造函数：
	File(File parent, String child) 
	File(String pathname) 
	File(String parent, String child) 
例子：
	File f1 = new File("e:\\abc\\hello.java");	
	File f2 = new File("e:\\abc","hello.java");	
	File f3 = new File(new File("e:\\abc"),"hello.java");


	/*
	 *  删除：boolean delete()
	 *  不走回收站,直接从硬盘中删除
	 */
	File file = new File("c:\\a.txt");
	boolean b = file.delete();

	/*
	 *  创建文件夹：boolean mkdirs() 可以创建多级文件夹
	 *  如果文件夹已经存在了,不再重新创建
	 */
	File file = new File("c:\\abc\\def");
	boolean b = file.mkdirs();

	/*
	 *  创建文件：boolean createNewFile()
	 *  如果文件已经存在了,不再重新创建
	 */
	File file = new File("c:\\a.txt");
	boolean b = file.createNewFile();

	/*
	* 获取父路径
	* String getParent()
	* File getParentFile()
	*/
	File file = new File("d:\\eclipse\\eclipse.exe");
	File parent = file.getParentFile();

	/*
	* 获取绝对路径
	* String getAbsolutePath() 返回String对象
	* File   getAbsoluteFile() 返回File对象
	* eclipse环境中,写的是一个相对路径,则默认是在项目的根目录
	*/
	File file = new File("src");
	File absolute = file.getAbsoluteFile();

	/*
	* 获取文件的大小(字节数)：long length()
	*/
	File file = new File("d:\\eclipse\\eclipse.exe");
	long length = file.length();

	/*
	*  获取文件或者文件夹名：String getName()
	*/
	File file = new File("d:\\eclipse\\eclipse.exe");
	String name = file.getName();

	/*
	*  判断是不是文件夹：boolean isDirectory()
	*  判断是不是文件：boolean isFile()
	*  不存在，则都返回false
	*/
	File file = new File("d:\\eclipse\\eclipse.exe");
	if(file.exists()){
		boolean b = file.isDirectory();
	}

	/*
	*  判断文件、路径是否存在：boolean exists()
	*/
	File file = new File("src");
	boolean b = file.exists();

	/*
	*  File类的获取功能
	*  String[] list()
	*  File[] listFiles()
	*  File[] listFiles(FilenameFilter filter)：【筛选】
	*/

	File f = new File("E:\\liuzx-emily\\2 javaWeb学习笔记");
	File[] listFiles = f.listFiles(new FilenameFilter() {			
		@Override
		public boolean accept(File dir, String name) {
			return name.toLowerCase().endsWith(".txt");
		}
	});
	for (File file : listFiles) {
		System.out.println(file);
	}



-----------------IO流--------------------
流对象使用步骤：
	1. 创建流对象，指定操作文件
	2. write()/read()
	3. close()

流对象特点：自己不做,依赖操作系统

（一）字节流
	操作的是字节，所以可以操作任意类型的文件：文本、图片、音频...。每次只操作一个字节
	常用实现类：FileOutputStream FileInputStream

（二）字符流
	操作的是字符，只能操作文本文件
	因为中文可能占多个字节，所以用字符流比较好
	常用实现类：OutputStreamWriter InputStreamWriter（"转换流"，可以指定编码）

字节流：
	InputStream（抽象类）
	   FileInputStream
	   BufferedInputStream
	 
	OuputStream（抽象类）
		FileOutputStream
		BufferedOuputStream

字符流：
	Writer（抽象类）
		OutputStreamWriter
		BufferedWriter

	Reader（抽象类）
		InputStreamReader
		BufferedReader



-----------------FileOutputStream类--------------------
父类OutputStream：抽象类，是表示字节输出流的所有类的超类
	write(int b)：写入字节
	write(byte[] b)：写入字节数组
	write(byte[] b,int off, int len)：写入字节数组，偏移量off，长度len
	flush()：刷新此输出流，并强制写出所有缓冲的输出字节。
	close()：关闭此输出流，并释放所有相关的系统资源。

抽象类OutputStream
	---FileOutputStream类

构造函数：
	FileOutputStream(File file) ：将字节写入文件开始处。如果文件已存在，则直接覆盖
	FileOutputStream(File file,boolean append) ：将字节写入文件末尾处。不会覆盖已有内容
	FileOutputStream(String name) 
	FileOutputStream(String name,boolean append)	

	public static void main(String[] args)throws IOException {
		FileOutputStream out = new FileOutputStream("e:\\a.txt",true);		
		byte[] bytes = {65,66,67,68};		
		out.write(bytes, 1, 2); 	//写入：BC		
		out.write("hello\n".getBytes()); 	//写入：hello换行
		out.close();		
	}

异常处理：
	FileOutputStream fos = null;
	try{
		fos = new FileOutputStream("d:\\a.txt");
		fos.write(100);
	}catch(IOException ex){
		ex.printStackTrace();
		throw new RuntimeException("文件写入失败,重试");
	}finally{
		try{
			if(fos!=null){	// 如果对象建立失败，则不需要关闭资源
		    	fos.close();
			}
		}catch(IOException ex){
			throw new RuntimeException("关闭资源失败");
		}
	}




-----------------FileInputStream类--------------------
父类InputStream：抽象类，是表示字节输入流的所有类的超类
	int  read()：读取1个字节。返回值：读取到的字节, 读取到结尾返回-1
	int  read(byte[] b)：读取一定量的字节,存储到数组中。返回值：读取到的有效字节数
	void close()

抽象类InputStream
	---FileInputStream类

构造函数：	
	FileInputStream(File file)
	FileInputStream(String name) 

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("c:\\a.txt");
		//1kb
		byte[] b = new byte[1024];		
		int len = 0 ;
		while( (len = fis.read(b)) !=-1){
			System.out.print(new String(b,0,len));
		}
		fis.close();
	}




-----------------转换流--------------------
可以指定编码表

	/*
	 * InputStreamReader：读取字节，使用指定的编码表将其解码为字符
	 * 继承Reader
	 * 
	 */
	public static void read() throws Exception {
		// 字节流
		InputStream fis = new FileInputStream("E:\\笔记.txt");
		// 转换流
		Reader isr = new InputStreamReader(fis, "utf-8");
		char[] cbuf = new char[1024];
		int len = 0;
		while ((len = isr.read(cbuf)) != -1) {
			System.out.print(new String(cbuf, 0, len));
		}
		isr.close();
	}

	/*
	 *  OutputStreamWriter：使用指定的编表，将要写入流中的字符编码成字节
	 *  继承Writer
	 *
	 */
	public static void write() throws Exception {
		// 字节流
		OutputStream fos = new FileOutputStream("E:\\abc.txt");
		// 转换流
		Writer osw = new OutputStreamWriter(fos, "utf-8");
		osw.write("你好呀~");
		osw.close();
	}





-----------------缓冲流--------------------
缓冲流：提高IO流的读写速度，分类：字节缓冲流与字符缓冲流。

	/*
	 *  BufferedInputStream：字节 输入 缓冲流
	 *  继承InputStream
	 *  构造方法：可以传递任意的字节输入流(InputStream的子类)
	 */
	public static void read() throws Exception {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				"c:\\buffer.txt"));
		byte[] bytes = new byte[10];
		int len = 0;
		while ((len = bis.read(bytes)) != -1) {
			System.out.print(new String(bytes, 0, len));
		}
		bis.close();
	}

	/*
	 *  BufferedOuputStream：字节 输出 缓冲流
	 *  继承OutputStream
	 *  构造方法：可以传递任意的字节输出流(OutputStream的子类)
	 */
	public static void write() throws Exception {
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("c:\\buffer.txt"));
		bos.write(55);
		byte[] bytes = "HelloWorld".getBytes();
		bos.write(bytes);
		bos.write(bytes, 3, 2);
		bos.close();
	}

	/*
	 *  BufferedReader：字符 输入 缓冲流
	 *  继承Reader
	 *  构造方法：可以传递任意的字符输入流(Reader的子类)
	 *  【特有的方法：String readLine()
	 *   	读取文本行。返回的每一行的有效字符不包括\r\n
	 *   	如果到流末尾,返回null】
	 */
	public static void read() throws Exception {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream("c:\\a.txt")));
		String line = null;
		while ((line = bfr.readLine()) != null) {
			System.out.println(line);
		}
		bfr.close();
	}

	/*
	 *  BufferedWriter：字符 输出 缓冲流
	 *  继承Writer
	 *  构造方法：可以传递任意的字符输出流(Writer的子类)
	 *  【特有的方法：void newLine() 换行(平台无关)】
	 */
	public static void write() throws Exception {
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:\\a.txt")));
		bfw.write("你好");
		bfw.newLine();
		bfw.flush();
		bfw.write("大家好");
		bfw.close();
	}





-----------------实例：复制文件--------------------

目的：复制mp4文件
分析：
	1 不是文本，所以用字节流
	2 为了提高速度：①读数组 ②用缓冲流
说明：为了结构清晰，把异常throws出去，不写try catch了

	private static void copy_1() throws IOException {

		BufferedInputStream in = new BufferedInputStream(new FileInputStream("E:\\movie.mp4"));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("D:\\movie.mp4"));

		byte[] bytes = new byte[1024];
		int len = 0;
		while ((len = in.read(bytes)) != -1) {
			out.write(bytes, 0, len);
		}
		in.close();
		out.close();
	}




-----------------多线程--------------------
程序运行原理：
	分时调度：平均
	抢占式调度：优先级（Java用这种）

	CPU使用抢占式调度模式在多个线程间高速切换。对于CPU的一个核而言，某个时刻，只能执行一个线程。因为切换速度极快，所以感觉上是多个应用同时运行。


jvm启动后，有一个执行路径(线程)从main方法开始的，一直执行到main方法结束，这个线程在java中称之为主线程。

多线程执行时，每一个执行线程都有独立的栈内存空间。




-----------------Thread类--------------------

创建新线程:
	方法一：
		继承Thread，重写run()。
		创建对象，调用start()
	方法二：
		实现Runnable，重写run()。
		创建Thread对象传参，调用start()
	方法三：
		通过线程池，实现Callable/Runnable接口

继承树： Runnable接口 -- Thread类

start()方法：开启线程,并且让jvm调用run()。其它线程的run()相当于主线程的main()

	private static void tryThread(){
		// 方法一：继承Thread
		Thread myThread1=new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("thread1: "+i);
				}
			}
		};
		myThread1.start();
		// 方法二：实现Runnable
		Runnable myThread2=new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("thread2: "+i);
				}
			}
		};
		new Thread(myThread2).start();
	}

方法二"实现Runnable"的好处：
	1 可以继承别的
	2 更加符合"面向对象思想"：线程对象、线程任务解耦
	3 操作同一文件时共享

获取线程的名字：Thread.currentThread().getName()

让线程休眠：Thread.sleep(毫秒); //main也能休。会抛异常





-----------------线程池--------------------
创建、销毁线程，消耗巨大，so线程池。

使用线程池
	Runnable接口
	Callable接口

(一)Runnable接口：
	private static void tryThread() {
		// 创建线程池对象，包含5个线程
		ExecutorService service = Executors.newFixedThreadPool(5);
		// 创建Runnable实例对象
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("hi");
			}
		};
		// 从线程池中获取线程对象,然后调用r中的run()
		service.submit(r);
		// 再获取个线程对象，调用r中的run()
		service.submit(r);
		// 关闭线程池
		service.shutdown();
	}

(二):Callable接口
	特点：与Runnable接口功能相似。其中的call()方法有返回值，可以抛出异常
		  返回值用Future来接收

	public class Demo {
		public static void main(String[] args) throws Exception {
			tryThread();
		}
		private static void tryThread() throws Exception {
			ExecutorService service = Executors.newFixedThreadPool(5);

			Future<Integer> f1 = service.submit(new MyCallable(50));
			Future<Integer> f2 = service.submit(new MyCallable(100));

			System.out.println(f1.get());	// 1275
			System.out.println(f2.get());	// 5050

			service.shutdown();
		}
	}
	class MyCallable implements Callable<Integer> {
		int n = 0;
		public MyCallable(int n) {this.n = n;}
		@Override
		public Integer call() {
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				sum += i;
			}
			return sum;
		}
	}





-----------------线程安全--------------------
多线程，修改同一资源，有危险。

java中提供了"线程同步机制"：
	方式1：同步代码块
			synchronized (锁对象){}

	方式2：同步方法
			public synchronized void method(){}
			同步方法中的对象锁：
				非static方法：本类对象的引用this
				static方法：类名.class

	class Ticket implements Runnable {
		// 共100张票
		int ticket = 100;
		@Override
		public void run() {
			sellTicket();
		}
		synchronized void sellTicket() {
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "卖票:"+ ticket);
				ticket--;
			}
		}
	}

操作同一资源的线程，想要保证安全，必须用同一个锁。

死锁：你拿着我的锁，我拿着你的锁，只能无限期等着。




-----------------Lock接口--------------------
同步的缺点：如果出现异常，锁就不归还了。

JDK1.5中提供了Lock接口：lock() unlock()

class Ticket implements Runnable {	
	Lock lock = new ReentrantLock();
	@Override
	public void run() {
		try {
			lock.lock();
			// 其他代码
		} catch (Exception e) {			
		} finally {
			lock.unlock();
		}
	}
}




-----------------等待唤醒机制--------------------
线程之间的通信：多个线程在处理同一个资源，但是处理的动作（线程的任务）不同。

wait :等待【释放锁对象，释放CPU使用权】
notify：唤醒在此对象锁上等待的任意某个线程
notifyAll： 唤醒全部在此对象锁上等待的线程



为什么wait、notify、notifyAll等方法都定义在Object类中？
	因为锁对象可以是任意类型的对象


sleep和wait的区别？
	sleep在Thread类中，wait在Object类中。
	sleep不会导致锁行为的改变，如果当前线程是拥有锁的，那么sleep不会让线程释放锁。wait会释放锁。
	sleep和wait都会暂停当前的线程，释放CPU资源。调用wait后，需要别的线程执行notify notifyAll才能够重新获得CPU执行时间。





-------------------JDBC原理-------------------
JDBC：Java Data Base Connectivity

Java提供的"访问数据库规范"称为"JDBC"，而数据库生产厂商提供的"JDBC规范的实现类"称为"驱动"。
	



-------------------JDBC开发步骤：-------------------
（1）执行insert delete update：用executeUpdate
	// 0.导入jar包

	// 1.注册驱动
	Class.forName("com.mysql.jdbc.Driver");

	// 2.连接数据库
	String url = "jdbc:mysql://localhost:3306/liuzx";
	String username = "root";
	String password = "123456";
	Connection con = DriverManager.getConnection(url, username, password);

	// 3.执行sql语句
	String sql = "INSERT INTO student(id,name,age) VALUES(?,?,?)";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, 1);
	ps.setString(2, "Alice");
	ps.setInt(3, 14);
	ps.executeUpdate();

	// 4.处理结果

	// 5.释放资源
	ps.close();
	con.close();

（2）执行select：用executeQuery

	// 3.执行sql语句
	String sql = "select * from student where id=?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, 2);
	ResultSet rs = ps.executeQuery();
	
	// 4.处理结果
	while(rs.next()){
		System.out.println(rs.getString("name"));
	}	
		
	// 5.释放资源
	rs.close();
	ps.close();
	con.close();


预处理对象prepareStatement：高效+防SQL注入攻击
SQL注入攻击：
	假设登录的sql语句如下:
		select * from user where name = 用户输入的用户名 and password = 用户输的密码;
	当用户输入的密码为：xxx or 1=1 时，则真正执行的代码变为：
		select * from 用户表 where name = 'xxx' and password ='xxx' or 1=1;
	上述语句永远可以查询出结果，那么用户就直接登录成功了。
	

连接池：实际开发中"获得连接"或"释放资源"是非常消耗系统资源的两个过程，为了解决此类性能问题，通常情况我们采用连接池技术。
常见的连接池：DBCP、C3P0




-------------------使用Properties配置文件-------------------
开发中，连接数据库的4个参数（驱动、URL、用户名、密码），通常都存在配置文件中，方便后期修改。
通常情况下，我们习惯使用properties文件，此文件我们将做如下要求：
	1.文件位置：任意，建议src下
	2.文件名称：任意，扩展名为properties
	3.文件内容：一行一组数据，格式是“key=value”.
		a)key命名自定义，如果是多个单词，习惯使用点分隔。例如：jdbc.driver
		b)value值不支持中文





-------------------概念：事务-------------------
比如：存钱
	1 把钱交出去 现金-100
	2 核对信息
	3 账户记录+100

把这三件事情当做一件事情来处理。要么都成功，要么都失败
都成功了，就提交：commit
有的失败了，那么所有都变成原样，回退：rollback





-------------------概念：javaBean-------------------
符合一定规范编写的Java类，不是一种技术，而是一种规范。大家针对这种规范，总结了很多开发技巧、工具函数。符合这种规范的类，可以被其它的程序员或者框架使用。
	1、所有属性为private
	2、提供默认构造方法
	3、提供getter和setter
	4、实现serializable接口


---


