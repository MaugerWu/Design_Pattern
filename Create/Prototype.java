package com.cqupt.mauger.create;

import java.util.ArrayList;

/**
 * 原型模式 Prototype Pattern
 * 
 * 定义：
 * 	用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象。
 * 	-原型模式主要用于对象的复制，它的核心是就是类图中的原型类 Prototype。
 * 	-原型模式是一种比较简单的模式，也非常容易理解，实现一个接口，重写一个方法即完成了原型模式。在实际应用中，原型模式很少单独出现。
 * 	经常与其他模式混用，他的原型类 Prototype 也常用抽象类来替代。
 * 
 *  类型：
 * 	创建型模式
 * 
 * 原型类需具备两条件：
 * 	1）实现 Cloneable 接口。在 Java 语言有一个 Cloneable 接口，它的作用只有一个，就是在运行时通知虚拟机可以安全地
 * 	       在实现了此接口的类上使用 clone 方法。在 Java 虚拟机中，只有实现了这个接口的类才可以被拷贝，否则在运行时会抛出 
 * 	  CloneNotSupportedException 异常。
 * 	2）重写 Object 类中的 clone 方法。Java 中，所有类的父类都是 Object 类，Object 类中有一个 clone 方法，
 * 	       作用是返回对象的一个拷贝，但是其作用域 protected 类型的，一般的类无法调用，因此，Prototype 类需要将 clone 
 *    方法的作用域修改为 public 类型。
 *    
 * 实现：
 * 	原型模式是一种比较简单的模式，也非常容易理解，实现一个接口，重写一个方法即完成了原型模式。在实际应用中，原型模式很少单独出现。
 * 	经常与其他模式混用，他的原型类 Prototype 也常用抽象类来替代。
 * 
 * 优点：
 * 	1）使用原型模式创建对象比直接 new 一个对象在性能上要好的多，因为 Object 类的 clone 方法是一个本地方法，
 * 	       它直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显。
 * 	2）使用原型模式的另一个好处是简化对象的创建，使得创建对象就像我们在编辑文档时的复制粘贴一样简单。
 * 
 * 使用场景：
 * 	因为以上优点，所以在需要重复地创建相似对象时可以考虑使用原型模式。比如需要在一个循环体内创建对象，假如对象创建过程比较复杂
 *  或者循环次数很多的话，使用原型模式不但可以简化创建过程，而且可以使系统的整体性能提高很多。
 * 
 * 注意事项：
 * 	1）使用原型模式复制对象不会调用类的构造方法。因为对象的复制是通过调用 Object 类的 clone 方法来完成的，它直接在内存中复制数据，
 * 	       因此不会调用到类的构造方法。不但构造方法中的代码不会执行，甚至连访问权限都对原型模式无效。还记得单例模式吗？单例模式中，只要将构造方法
 * 	       的访问权限设置为private型，就可以实现单例。但是clone方法直接无视构造方法的权限，所以，单例模式与原型模式是冲突的，
 * 	       在使用时要特别注意。
 * 	2）深拷贝与浅拷贝。Object 类的 clone 方法只会拷贝对象中的基本的数据类型，对于数组、容器对象、引用对象等都不会拷贝，这就是浅拷贝。
 * 	       如果要实现深拷贝，必须将原型模式中的数组、容器对象、引用对象等另行拷贝。
 * 	3）由于 ArrayList 不是基本类型，所以成员变量 list，不会被拷贝，需要我们自己实现深拷贝，幸运的是 Java 提供的大部分的容器类
 * 	       都实现了 Cloneable 接口。所以实现深拷贝并不是特别困难。
 * 	4）深拷贝与浅拷贝问题中，会发生深拷贝的有 Java 中的8中基本类型以及他们的封装类型，另外还有 String 类型。其余的都是浅拷贝。
 * 	5）Java 中的8中基本类型及其封装类型：
 * 		字符型：char（Character）
 * 		数值型：
 * 			整数型：byte（Byte）、short（Short）、int（Integer）、long（Long）
 * 			浮点型：float（Float）、double（Double）
 * 		布尔型：boolean（Boolean）
 * 
 * @author Mauger
 * @date 2018年4月20日  
 * @version 1.0
 */
public class Prototype implements Cloneable {

	public Prototype clone() {
		
		Prototype prototype = null;
		try {
			prototype = (Prototype) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return prototype;
	}
}


/**
 * 原型实现类
 * @author Mauger
 * @date 2018年4月20日  
 * @version 1.0
 */
class ConcreatePrototype extends Prototype {
	
	public void show() {
		System.out.println("Prototype Implemention Class.");
	}
}


/**
 * 测试类
 * @author Mauger
 * @date 2018年4月20日  
 * @version 1.0
 */
class PrototypeTest {
	
	public static void main(String[] args) {
		
		ConcreatePrototype cp = new ConcreatePrototype();
		for (int i = 0; i < 10; i++) {
			ConcreatePrototype clonecp = (ConcreatePrototype) cp.clone();
			clonecp.show();
		}
	}
}


/**
 * 深拷贝
 * @author Mauger
 * @date 2018年4月21日  
 * @version 1.0
 */
class PrototypeClone implements Cloneable {
	
	@SuppressWarnings("rawtypes")
	private ArrayList list = new ArrayList();
	
	@SuppressWarnings("rawtypes")
	public PrototypeClone clone() {
		PrototypeClone pc = null;
		try {
			PrototypeClone pclone = (PrototypeClone) super.clone();
			pclone.list = (ArrayList) this.list.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return pc;
	}
}