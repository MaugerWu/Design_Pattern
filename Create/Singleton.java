package com.cqupt.mauger.create;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式 Singleton Pattern
 * 
 * 定义：
 * 	确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。
 * 
 * 类型：
 * 	创建型模式
 * 
 * 分类：
 * 	1、懒汉式单例
 * 	2、饿汉式单例
 * 	3、登记式单例，可继承。
 * 
 * 特点：
 * 	1、单例类只能有一个实例。
 * 	2、单例类必须自己创建自己的唯一实例。
 * 	3、单例类必须给所有其他对象提供这一实例。
 * 	4、在内存中只有一个对象，节省内存空间。
 * 	5、避免频繁的创建销毁对象，可以提高性能。
 * 	6、避免对共享资源的多重占用。
 * 	7、可以全局访问。
 * 
 * 使用场景：
 * 	1、需要频繁实例化然后销毁的对象。
 * 	2、创建对象时耗时过多或者耗资源过多，但又经常用到的对象。
 * 	3、有状态的工具类对象。
 * 	4、频繁访问数据库或文件的对象。
 * 	5、在计算机系统中，线程池、缓存、日志对象、应用配置、对话框、打印机、显卡的驱动程序对象常被设计成单例。
 * 
 * 注意事项：
 * 	1、只能使用单例类提供的方法得到单例对象，不要使用反射，否则将会实例化一个新对象。
 * 	2、多线程使用单例使用共享资源时，注意线程安全问题。
 * 
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 * 
 * 饿汉式写法
 */
public class Singleton {
	
	private static Singleton instance = new Singleton();
	private Singleton() {}
	
	public static Singleton getInstance() {
		return instance;
	}
}


/** 
 * 懒汉式写法——非线程安全
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Singleton0 {

	private static Singleton0 instance;
	private Singleton0() {}
	
	public static Singleton0 getInstance() {
		if (instance == null) {
			instance = new Singleton0();
		}
		return instance;
	}
}


/** 
 * 懒汉式写法——线程安全
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Singleton1 {

	private static Singleton1 instance;
	private Singleton1() {}
	
	public static synchronized Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}


/**
 * 静态内部类写法
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Singleton2 {
	
	private static class SingletonHolder {
		
		private static final Singleton2 INSTANCE = new Singleton2();
	}
	
	private Singleton2() {}
	
	public static Singleton2 getInstance() {
		return SingletonHolder.INSTANCE;
	}
}


/**
 * 枚举
 * 	枚举类型是一种特殊数据类型，能够为一个变量定义一组预定义的常量。变量必须等于为其预定义的值之一。
 * 	枚举是特殊的类，可以拥有成员变量和方法。
 * 
 * 	单例的枚举实现在《Effective Java》中有提到，因为其功能完整、使用简洁、无偿地提供了序列化机制、在面对复杂的序列化
 * 或者反射攻击时仍然可以绝对防止多次实例化等优点，单元素的枚举类型被作者认为是实现Singleton的最佳方法。
 * 
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
enum Singleton3 {
	INSTANCE;
	private Singleton3() {}
	
	public void doSomething() {}
}


/**
 * 模拟一个数据库连接类
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class DBConnection {}


/**
 * 声明一个枚举，用于获取数据库连接
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
enum DataSourceEnum {
    DATASOURCE;
    private DBConnection conn;
    private DataSourceEnum() {
        conn = new DBConnection();
    }
    
    public DBConnection getConnection() {
        return conn;
    }
}


/**
 * 测试
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class enumTest {
	
	public static void main(String[] args) {
		DBConnection conn1 = DataSourceEnum.DATASOURCE.getConnection();
		DBConnection conn2 = DataSourceEnum.DATASOURCE.getConnection();
		System.out.println(conn1 == conn2); // 返回 true
	}
}

/**
 * 双重校验锁
 * 	第一个if (instance == null)是为了解决 Singleton1 中的效率问题，只有 instance 为 null 的时候，才进入 synchronized 的代码段。
 * 	第二个if (instance == null)则是跟 Singleton1 一样，是为了防止可能出现多个实例的情况。
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Singleton4 {
	
	private static Singleton4 instance;
	private Singleton4() {}
	
	public static Singleton4 getInstance() {
		if (instance == null) {
			synchronized(Singleton4.class) {
				if (instance == null) {
					instance = new Singleton4();
				}
			}
		}
		return instance;
	}
}


/**
 * volatile
 * 	volatile 关键字的一个作用是禁止指令重排;
 * 	volatile 阻止的不是 singleton = new Singleton()这句话内部[1-2-3]的指令重排，
 * 而是保证了在一个写操作（[1-2-3]）完成之前，去执行读操作（if (instance == null)）。
 * 
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Singleton5 {
	
	private static volatile Singleton5 instance;
	private Singleton5() {}
	
	public static Singleton5 getInstance() {
		if (instance == null) {
			synchronized(Singleton5.class) {
				if (instance == null) {
					instance = new Singleton5();
				}
			}
		}
		return instance;
	}
}


/**
 * 登记式单例写法
 * 	登记式单例实际上维护了一组单例类的实例，将这些实例存放在一个Map（登记薄）中，对于已经登记过的实例，则从Map直接返回，对于没有登记的，则先登记，然后返回。
 * 
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class RegisterSingleton {
	
	private static Map<String, RegisterSingleton> map = new HashMap<String, RegisterSingleton>();
	static {
		map.put(RegisterSingleton.class.getName(), new RegisterSingleton());
	}
	
	protected RegisterSingleton() {}
	
	@SuppressWarnings("unchecked")
	public static <T>T getInstance(T t) {
		
		String className = t.getClass().getName();
		if (RegisterSingleton.class.getName() == null) {
			try {
				Constructor<?> constructor = Class.forName(className).getDeclaredConstructor();
				constructor.setAccessible(true);
				map.put(className, (RegisterSingleton)constructor.newInstance());
			} catch (Exception e) {
				className = RegisterSingleton.class.getName();
			}
		}
		return (T)map.get(className);
	}
}


/**
 * 登记式单例
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class RegSingleton {
	
	private static Map<String, RegSingleton> regMap = new HashMap<String, RegSingleton>();
	static {
		RegSingleton instance = new RegSingleton();
		regMap.put(instance.getClass().getName(), instance);
	}
	protected RegSingleton() {}
	
	public static RegSingleton getInstance(String className) {
		
		if (className == null) {
			className = RegSingleton.class.getName();
		}
		
		if (regMap.get(className) == null) {
			try {
				regMap.put(className, (RegSingleton) Class.forName(className).newInstance());
			} catch (Exception e) {
				className = RegisterSingleton.class.getName();
			}
		}
		return regMap.get(className);
	}
	
	public String getStr() {
		return "Hello World!";
	}
}