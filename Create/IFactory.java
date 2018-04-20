package com.cqupt.mauger.create;

/**
 * 工厂模式 Factory Pattern
 * 
 * 类型：
 * 	创建型模式
 * 
 * 分类：
 * 	1、简单工厂模式 Simple Factory（也称静态工厂模式）
 * 		定义：
 * 			一个抽象的接口，多个抽象接口的实现类，一个工厂类，用来实例化抽象的接口。
 * 		区别：
 * 			简单工厂只有三个要素，它没有工厂接口，并且得到产品的方法一般是静态的。因为没有工厂接口，
 * 			所以在工厂实现的扩展性方面稍弱，可以算所工厂方法模式的简化版。
 * 
 * 	2、工厂方法模式 Factory Method
 * 		定义：
 * 			定义一个用于创建对象的接口，让子类决定实例化哪一个类，工厂方法使一个类的实例化延伸到其子类。
 * 			不再是由一个工厂类去实例化具体的产品，而是由抽象工厂的子类去实例化产品。
 * 		优点：
 * 			1）可以使代码结构清晰，有效地封装变化。在编程中，产品类的实例化有时候是比较复杂和多变的，通过工厂模式，
 * 			       将产品的实例化封装起来，使得调用者根本无需关心产品的实例化过程，只需依赖工厂即可得到自己想要的产品。
 * 			2）对调用者屏蔽具体的产品类。如果使用工厂模式，调用者只关心产品的接口就可以了，至于具体的实现，调用者根本无需关心。
 * 			       即使变更了具体的实现，对调用者来说没有任何影响。
 * 			3）降低耦合度。产品类的实例化通常来说是很复杂的，它需要依赖很多的类，而这些类对于调用者来说根本无需知道，
 * 			       如果使用了工厂方法，我们需要做的仅仅是实例化好产品类，然后交给调用者使用。对调用者来说，产品所依赖的类都是透明的。
 * 		四要素：
 * 			1）工厂接口。工厂接口是工厂方法模式的核心，与调用者直接交互用来提供产品。在实际编程中，有时候也会使用一个抽象类来作为
 * 			       与调用者交互的接口，其本质上是一样的。
 * 			2）工厂实现。在编程中，工厂实现决定如何实例化产品，是实现扩展的途径，需要有多少种产品，就需要有多少个具体的工厂实现。
 * 			3）产品接口。产品接口的主要目的是定义产品的规范，所有的产品实现都必须遵循产品接口定义的规范。产品接口是调用者最为关心的，
 * 			       产品接口定义的优劣直接决定了调用者代码的稳定性。同样，产品接口也可以用抽象类来代替，但要注意最好不要违反里氏替换原则。
 * 			4）产品实现。实现产品接口的具体类，决定了产品在客户端中的具体行为。
 * 		适用场景：
 * 			1）作为一种创建类模式，在任何需要生成复杂对象的地方，都可以使用工厂方法模式。
 * 			2）工厂模式是一种典型的解耦模式，迪米特法则在工厂模式中表现的尤为明显。假如调用者自己组装产品需要增加依赖关系时，
 * 			       可以考虑使用工厂模式。将会大大降低对象之间的耦合度。
 * 			3）当需要系统有比较好的扩展性时，可以考虑工厂模式，不同的产品用不同的实现工厂来组装。
 * 
 * 	3、抽象工厂模式 Abstract Factory
 * 		定义：
 * 			为创建一组相关或相互依赖的对象提供一个接口，而且无需指定他们的具体类。
 * 			与工厂方法模式不同的是，工厂方法模式中的工厂只生产单一的产品，而抽象工厂模式中的工厂生产多个产品。
 * 		优点：
 * 			除了拥有工厂方法模式的优点之外，在类的内部对产品族进行约束。所谓的产品族，一般或多或少的都存在一定的关联，
 * 			抽象工厂模式就可以在类内部对产品族的关联关系进行定义和描述，而不必专门引入一个新的类来进行管理。
 * 		缺点：
 * 			产品族的扩展将是一件十分费力的事情，假如产品族中需要增加一个新的产品，则几乎所有的工厂类都需要进行修改。
 * 			所以使用抽象工厂模式时，对产品等级结构的划分是非常重要的。
 * 		适用场景：
 * 			当需要创建的对象是一系列相互关联或相互依赖的产品族时，便可以使用抽象工厂模式。
 * 
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 * 
 * 工厂方法模式——工厂接口
 */
public interface IFactory {
	public IProduct createProduct();
}


/**
 * 工厂方法模式——工厂实现
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Factory implements IFactory {
    public IProduct createProduct() {
        return new Product();
    }
}


/**
 * 工厂方法模式——产品接口
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
interface IProduct {
    public void productMethod();
}


/**
 * 工厂方法模式——产品实现
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Product implements IProduct {
    public void productMethod() {
        System.out.println("汽车");
    }
}


/**
 * 工厂方法模式——调用类
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Client {
    public static void main(String[] args) {
        IFactory factory = new Factory();
        IProduct prodect = factory.createProduct();
        prodect.productMethod();
    }
}
/******************工厂方法模式 END********************/

/*****************抽象工厂模式 START*******************/

/**
 * 抽象工厂模式——A产品接口
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
interface IProductA {
    public void show();
}


/**
 * 抽象工厂模式——B产品接口
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
interface IProductB {
    public void show();
}


/**
 * 抽象工厂模式——A产品具体实现类
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Product1 implements IProductA {
    public void show() {
        System.out.println("这是A型产品");
    }
}


/**
 * 抽象工厂模式——B产品具体实现类
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Product2 implements IProductB {
    public void show() {
        System.out.println("这是B型产品");
    }
}


/**
 * 抽象工厂模式——抽象工厂接口
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
interface IFactory1 {
    public IProductA createProduct1();
    public IProductB createProduct2();
}


/**
 * 抽象工厂模式——抽象工厂具体实现类
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Factory1 implements IFactory1 {
    public IProductA createProduct1() {
        return new Product1();
    }
    public IProductB createProduct2() {
        return new Product2();
    }
}


/**
 * 抽象工厂模式——调用类
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Client1 {
    public static void main(String[] args){
        IFactory1 factory = new Factory1();
        factory.createProduct1().show();
        factory.createProduct2().show();
    }
}