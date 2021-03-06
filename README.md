## 一、设计模式简介

&emsp;&emsp;简介：设计模式是一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结。使用设计模式是为了可重用代码、让代码更容易被他人理解、保证代码可靠性。

## 二、设计模式三大分类

### 1. 创建型模式（共5种）
  - [工厂方法模式（Factory Method Pattern）](https://github.com/MaugerWu/Design_Pattern/blob/master/Create/FactoryMethod.java)
  - [抽象工厂模式（Abstract Factory Pattern）](https://github.com/MaugerWu/Design_Pattern/blob/master/Create/AbstractFactory.java)
  - [单例模式（Singleton Pattern）](https://github.com/MaugerWu/Design_Pattern/blob/master/Create/Singleton.java)
  - [建造者模式（Builder Pattern）](https://github.com/MaugerWu/Design_Pattern/blob/master/Create/Builder.java)
  - [原型模式（Prototype Pattern）](https://github.com/MaugerWu/Design_Pattern/blob/master/Create/Prototype.java)
  
### 2. 结构型模式（共7种）
  - 适配器模式（Adapter Pattern）
  - 装饰者模式（Decorator Pattern）
  - 代理模式（Proxy Pattern）
  - 外观模式（Facade Pattern）
  - 桥接模式（Bridge Pattern）
  - 组合模式（Composite Pattern）
  - 享元模式（Flyweight Pattern）
  
### 3. 行为型模式（共11种）
  - [策略模式（Strategy Pattern）](https://github.com/MaugerWu/Design_Pattern/blob/master/Behavior/Strategy.java)
  - [模板方法模式（Template Method Pattern）](https://github.com/MaugerWu/Design_Pattern/blob/master/Behavior/TemplateMethod.java)
  - 观察者模式（Observer Pattern）
  - 迭代器模式（Iterator Pattern）
  - 责任链模式（Chain Of Responsibility Pattern）
  - 命令模式（Command Pattern）
  - 备忘录模式（Memento Pattern）
  - 状态模式（Status Pattern）
  - 访问者模式（Visitor Pattern）
  - 中介者模式（Mediator Pattern）
  - 解释器模式（Interpreter Pattern）

## 三、设计模式六大原则

**1. 单一职责原则（Single Responsibility Principle, SRP）：** 一个类只负责一个功能领域中的相应职责，或者可以定义为：就一个类而言，应该只有一个引起它变化的原因。

&emsp;&emsp;单一职责原则是最简单的面向对象设计原则，它用于控制类的粒度大小。单一职责原则是实现高内聚、低耦合的指导方针，它是最简单但又最难运用的原则，需要设计人员发现类的不同职责并将其分离，而发现类的多重职责；需要设计人员具有较强的分析设计能力和相关实践经验。

**2. 里氏替换原则（Liskov Substitution Principle, LSP）：** 所有引用基类（父类）的地方必须能透明地使用其子类的对象。

&emsp;&emsp;任何基类可以出现的地方，子类一定可以出现。里氏替换原则是继承复用的基石，只有当衍生类可以替换基类，软件单位的功能不受到影响时，基类才能真正被复用，而衍生类也能够在基类的基础上增加新的行为。

&emsp;&emsp;里氏替换原则是对“开-闭”原则的补充。实现“开闭”原则的关键步骤就是抽象化。而基类与子类的继承关系就是抽象化的具体实现，所以里氏替换原则是对实现抽象化的具体步骤的规范。里氏替换原则中，子类对父类的方法尽量不要重写和重载。因为父类代表了定义好的结构，通过这个规范的接口与外界交互，子类不应该随便破坏它。

**3. 依赖倒转原则（Dependence Inversion Principle, DIP）：** 抽象不应该依赖于细节，细节应当依赖于抽象。换言之，要针对接口编程，而不是针对实现编程。

&emsp;&emsp;面向接口编程，依赖于抽象而不依赖于具体。在用到具体类时，不与具体类交互，而与具体类的上层接口交互。

&emsp;&emsp;依赖倒转原则要求我们在程序代码中传递参数时或在关联关系中，尽量引用层次高的抽象层类，即使用接口和抽象类进行变量类型声明、参数类型声明、方法返回类型声明，以及数据类型的转换等，而不要用具体类来做这些事情。为了确保该原则的应用，一个具体类应当只实现接口或抽象类中声明过的方法，而不要给出多余的方法，否则将无法调用到在子类中增加的新方法。

&emsp;&emsp;在引入抽象层后，系统将具有很好的灵活性，在程序中尽量使用抽象层进行编程，而将具体类写在配置文件中，这样一来，如果系统行为发生变化，只需要对抽象层进行扩展，并修改配置文件，而无须修改原有系统的源代码，在不修改的情况下来扩展系统的功能，满足开闭原则的要求。

&emsp;&emsp;在实现依赖倒转原则时，我们需要针对抽象层编程，而将具体类的对象通过依赖注入(DependencyInjection, DI)的方式注入到其他对象中，依赖注入是指当一个对象要与其他对象发生依赖关系时，通过抽象来注入所依赖的对象。常用的注入方式有三种，分别是：构造注入，设值注入（Setter注入）和接口注入。构造注入是指通过构造函数来传入具体类的对象，设值注入是指通过Setter方法来传入具体类的对象，而接口注入是指通过在接口中声明的业务方法来传入具体类的对象。这些方法在定义时使用的是抽象类型，在运行时再传入具体类型的对象，由子类对象来覆盖父类对象。

**4. 接口隔离原则（Interface Segregation Principle, ISP）：** 使用多个专门的接口，而不使用单一的总接口，即客户端不应该依赖那些它不需要的接口。

&emsp;&emsp;每个接口中不存在子类用不到却必须实现的方法，若存在，就要将接口拆分。使用多个隔离的接口，比使用单个接口（多个接口方法集合到一个的接口）要好。

**5. 迪米特法则（Demeter Principle, DP)：** 一个软件实体应当尽可能少地与其他实体发生相互作用。

&emsp;&emsp;迪米特法则又称为**最少知识原则(LeastKnowledge Principle, LKP)**。 一个类对自己依赖的类知道的越少越好。无论被依赖的类多么复杂，都应该将逻辑封装在方法的内部，通过public方法提供给外部。这样当被依赖的类变化时，才能最小的影响该类。

&emsp;&emsp;最少知道原则的另一个表达方式是：只与直接的朋友通信。类之间只要有耦合关系，就叫朋友关系。耦合分为依赖、关联、聚合、组合等。我们称出现为成员变量、方法参数、方法返回值中的类为直接朋友。局部变量、临时变量则不是直接的朋友。我们要求陌生的类不要作为局部变量出现在类中。

&emsp;&emsp;如果一个系统符合迪米特法则，那么当其中某一个模块发生修改时，就会尽量少地影响其他模块，扩展会相对容易，这是对软件实体之间通信的限制，迪米特法则要求限制软件实体之间通信的宽度和深度。迪米特法则可降低系统的耦合度，使类与类之间保持松散的耦合关系。

&emsp;&emsp;迪米特法则要求我们在设计系统时，应该尽量减少对象之间的交互，如果两个对象之间不必彼此直接通信，那么这两个对象就不应当发生任何直接的相互作用，如果其中的一个对象需要调用另一个对象的某一个方法的话，可以通过第三者转发这个调用。简言之，就是通过引入一个合理的第三者来降低现有对象之间的耦合度。

&emsp;&emsp;在将迪米特法则运用到系统设计中时，要注意下面的几点：在类的划分上，应当尽量创建松耦合的类，类之间的耦合度越低，就越有利于复用，一个处在松耦合中的类一旦被修改，不会对关联的类造成太大波及；在类的结构设计上，每一个类都应当尽量降低其成员变量和成员函数的访问权限；在类的设计上，只要有可能，一个类型应当设计成不变类；在对其他类的引用上，一个对象对其他对象的引用应当降到最低。

**6. 开闭原则（Open Closed Principle, OCP）：** 一个软件实体如类、模块和函数应该对扩展开放，对修改关闭。

&emsp;&emsp;开闭原则是面向对象的可复用设计的第一块基石，它是最重要的面向对象设计原则。在开闭原则的定义中，软件实体可以指一个软件模块、一个由多个类组成的局部结构或一个独立的类。

## 四、设计模式之间的关系图

![](https://github.com/MaugerWu/Design_Pattern/blob/master/img/23dp.jpg)
