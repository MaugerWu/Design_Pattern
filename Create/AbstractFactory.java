package com.cqupt.mauger.create;

/**
 * 抽象工厂模式 Abstract Factory Pattern
 * 
 * 定义：
 * 	为创建一组相关或相互依赖的对象提供一个接口，而且无需指定他们的具体类。
 * 	与工厂方法模式不同的是，工厂方法模式中的工厂只生产单一的产品，而抽象工厂模式中的工厂生产多个产品。
 * 	
 * 优点：
 * 	除了拥有工厂方法模式的优点之外，在类的内部对产品族进行约束。所谓的产品族，一般或多或少的都存在一定的关联，
 * 	抽象工厂模式就可以在类内部对产品族的关联关系进行定义和描述，而不必专门引入一个新的类来进行管理。
 * 
 * 缺点：
 * 	产品族的扩展将是一件十分费力的事情，假如产品族中需要增加一个新的产品，则几乎所有的工厂类都需要进行修改。
 * 	所以使用抽象工厂模式时，对产品等级结构的划分是非常重要的。
 * 
 * 适用场景：
 * 	当需要创建的对象是一系列相互关联或相互依赖的产品族时，便可以使用抽象工厂模式。
 * 
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
public interface AbstractFactory
{
	public IProductA createProduct1();
    public IProductB createProduct2();
}

/**
 * 抽象工厂模式——A产品接口
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
interface IProductA
{
    public void show();
}


/**
 * 抽象工厂模式——B产品接口
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
interface IProductB
{
    public void show();
}


/**
 * 抽象工厂模式——A产品具体实现类
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Product1 implements IProductA
{
    public void show()
    {
        System.out.println("这是A型产品");
    }
}


/**
 * 抽象工厂模式——B产品具体实现类
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Product2 implements IProductB
{
    public void show()
    {
        System.out.println("这是B型产品");
    }
}


/**
 * 抽象工厂模式——抽象工厂具体实现类
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class Factory1 implements AbstractFactory
{
    public IProductA createProduct1()
    {
        return new Product1();
    }
    
    public IProductB createProduct2()
    {
        return new Product2();
    }
}


/**
 * 测试类
 * @author Mauger
 * @date 2018年4月19日  
 * @version 1.0
 */
class AbstractFactoryTest
{
    public static void main(String[] args)
    {
    	AbstractFactory factory = new Factory1();
        factory.createProduct1().show();
        factory.createProduct2().show();
    }
}