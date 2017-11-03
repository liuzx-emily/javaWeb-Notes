有一系列类需特别对待：主类型Primitive，进行程序设计时要频繁用到它们。  
之所以要特别对待，是由于用new创建对象（特别是小的、简单的变量）并不是非常有效，因为new将对象置于“堆”里。对于这些类型，Java 采纳了与C和 C++相同的方法。也就是说，不是用new创建变量，而是创建一个并非句柄的“自动”变量。这个变量容纳了具体的值，并置于堆栈中，能够更高效地存取。  
Java 决定了每种主要类型的大小，这些大小并不随着机器结构的变化而变化。这种大小的不可更改正是 Java 程序具有很强移植能力的原因之一。




	主类型		  大小	  最小值 			最大值 		封装器类型
    boolean		1位										Boolean
    char 		16位 	Unicode 0 		Unicode 2^16-1	Character
    byte 		8位 		-128 			+127 			Byte  
    short 		16 位 	-2^15 			+2^15-1			Short（注释①）
    int 		32位 	-2^31			2^31-1 			Integer
    long 		64位 	-2^63 			+2^63-1			Long
    float 		32 位	IEEE754 		IEEE754 		Float
    double 		64 位 	IEEE754 		IEEE754 		Double
    Void												Void


数值类型全都是有符号（正负号）的，所以不必费劲寻找没有符号的类型。  
主数据类型也拥有自己的“封装器”（wrapper）类。这意味着假如想让堆内一个非主要对象表示那个主类
型，就要使用对应的封装器。例如：

    char c = 'x';
    Character C = new Character('c');
也可以直接使用：

    Character C = new Character('x');

---
# 2.6.3 static 关键字 #
Ordinarily, when you create a class you are describing how objects of that class look and how they will behave. You don’t actually get an object until you create one using new, and at that point storage is allocated and methods become available.

There are two situations in which this approach is not sufficient.   

- One is if you want to have only a single piece of storage for a particular field, regardless of how many objects of that class are created, or even if no objects are created. 



- The other is if you need a method that isn’t associated with any particular object of this class. That is, you need a method that you can call even if no objects are created.


为满足这两方面的要求，可使用static关键字。  

一旦将什么东西设为static，数据或方法就不会同那个类的任何对象实例联系到一起。所以尽管从未创建那个类的一个对象，仍能调用一个 static方法，或访问一些 static数据。  

由于static方法不需要创建任何对象，所以它们不可简单地调用非static成员
或方法（因为非static成员和方法必须同一个特定的对象关联到一起）。  


### 建立static

   
    class StaticTest {
		static int i = 47;		//static数据
    }

    class StaticFun {
    	static void incr() {	//static方法 
			StaticTest.i++; 
		}
    }

现在建立StaticTest对象：

    StaticTest st1 = new StaticTest();
    StaticTest st2 = new StaticTest();

现在，尽管我们建立了两个StaticTest对象，但它们仍然只占据StaticTest.i的一个存储空间。这两个对象都共享同样的i。此时，无论 st1.i还是 st2.i都有同样的值47，因为它们引用的是同样的内存区域。
### 使用static

有两个办法可引用一个 static变量：


1. 可通过一个对象使用它，如st2.i。


    	st1.i++;	//此时，无论 st1.i 还是st2.i 的值都是48。

		StaticFun sf = new StaticFun();
  		sf.incr();

1. You can also refer to it directly through its class name, something you cannot do with a non-static member.Using the class name is the preferred way to refer to a static variable. Not only does it emphasize that variable’s static nature, but in some cases it gives the compiler better opportunities for optimization.

		StaticTest.i++;

		StaticFun.incr();



Although static, when applied to a field, definitely changes the way the data is created (one for each class versus the non-static one for each object), when applied to a method it’s not so dramatic.   
An important use of static for methods is to allow you to call that method without creating an object. This is essential, as you will see, in defining the main( ) method that is the entry point for running an application.