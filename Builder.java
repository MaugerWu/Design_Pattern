package com.cqupt.mauger.create;

/**
 * 建造者模式 Builder Pattern
 * 
 * 定义：
 * 	将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * 
 * 类型：
 * 	创建型模式
 * 
 * 四要素：
 * 	1）产品类：一般是一个较为复杂的对象，也就是说创建对象的过程比较复杂，一般会有比较多的代码量。产品类是一个具体的类，而非抽象类。
 * 	       实际编程中，产品类可以是由一个抽象类与它的不同实现组成，也可以是由多个抽象类与他们的实现组成。
 * 	2）抽象建造者：引入抽象建造者的目的，是为了将建造的具体过程交与它的子类来实现。这样更容易扩展。一般至少会有两个抽象方法，
 * 	       一个用来建造产品，一个是用来返回产品。
 * 	3）建造者：实现抽象类的所有未实现的方法，具体来说一般是两项任务：组建产品；返回组建好的产品。
 * 	4）导演类：负责调用适当的建造者来组建产品，导演类一般不与产品类发生依赖关系，与导演类直接交互的是建造者类。
 * 	       一般来说，导演类被用来封装程序中易变的部分。
 * 
 * 优点：
 * 	1）建造者模式的封装性很好。使用建造者模式可以有效的封装变化，在使用建造者模式的场景中，一般产品类和建造者类是比较稳定的，因此，
 * 	       将主要的业务逻辑封装在导演类中对整体而言可以取得比较好的稳定性。
 * 	2）建造者模式很容易进行扩展。如果有新的需求，通过实现一个新的建造者类就可以完成，基本上不用修改之前已经测试通过的代码，
 * 	       因此也就不会对原有功能引入风险。
 * 
 * 与工厂模式的区别：
 * 	1）工厂模式相比，建造者模式一般用来创建更为复杂的对象，因为对象的创建过程更为复杂，因此将对象的创建过程独立出来组成一个新的类——导演类。
 * 	2）建造者模式与工厂模式类似，他们都是建造者模式，适用的场景也很相似。一般来说，如果产品的建造很复杂，那么请用工厂模式；
 * 	       如果产品的建造更复杂，那么请用建造者模式。
 * 
 * @author Mauger
 * @date 2018年4月20日  
 * @version 1.0
 * 
 * 抽象建造者类
 */
public abstract class Builder {

	public abstract void setPart(String name, String type);
    public abstract ProductB getProduct();
}


/**
 * 产品类
 * @author Mauger
 * @date 2018年4月20日  
 * @version 1.0
 */
class ProductB {
	
	private String name;
	private String type;
	
	public void showProduct() {
		
		System.out.println("名称：" + name);
		System.out.println("型号：" + type);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}


/**
 * 建造者类
 * 	实现抽象类的所有未实现的方法，任务：组建产品、返回组建好的产品。
 * @author Mauger
 * @date 2018年4月20日  
 * @version 1.0
 */
class ConcreateBuilder extends Builder {

	private ProductB product = new ProductB();
	
	@Override
	public void setPart(String name, String type) {
		
		product.setName(name);
		product.setType(type);
	}

	@Override
	public ProductB getProduct() {
		return product;
	}
}


/**
 * 导演类
 * 	负责调用适当的建造者来组建产品。
 * @author Mauger
 * @date 2018年4月20日  
 * @version 1.0
 */
class Director {
	
	private Builder builder = new ConcreateBuilder();
	
	public ProductB getAProductB() {
		
		builder.setPart("BMW", "x6");
		return builder.getProduct();
	}
	
	public ProductB getBProductB() {
		
		builder.setPart("Audi", "a6");
		return builder.getProduct();
	}
}


/**
 * 测试类
 * @author Mauger
 * @date 2018年4月20日  
 * @version 1.0
 */
class BuilderTest {
	
    public static void main(String[] args) {
    	
        Director director = new Director();
        ProductB product1 = director.getAProductB();
        product1.showProduct();

        ProductB product2 = director.getBProductB();
        product2.showProduct();
    }
}