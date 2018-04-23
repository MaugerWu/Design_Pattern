package com.cqupt.mauger.behavior;

import java.util.Arrays;

/**
 * 模板方法模式 Template Method Pattern
 * 
 * 定义：
 * 	定义一个操作中算法的框架，而将一些步骤延迟到子类中，使得子类可以不改变算法的结构，即可重定义该算法中的某些特定步骤。
 * 
 * 类型：
 * 	行为型模式
 * 
 * 结构：
 * 	模版方法模式由一个抽象类和一个（或一组）实现类通过继承结构组成，抽象类中的方法分为三种：
 * 	1）抽象方法：父类中只声明但不加以实现，而是定义好规范，然后由它的子类去实现。
 * 	2）模版方法：由抽象类声明并加以实现。一般来说，模版方法调用抽象方法来完成主要的逻辑功能，并且，模版方法大多会定义为 final 类型，
 * 	       指明主要的逻辑功能在子类中不能被重写。
 * 	3）钩子方法：由抽象类声明并加以实现。但是子类可以去扩展，子类可以通过扩展钩子方法来影响模版方法的逻辑。
 * 
 * 	抽象类的任务是搭建逻辑的框架，通常由经验丰富的人员编写，因为抽象类的好坏直接决定了程序是否稳定性。实现类用来实现细节。
 * 	抽象类中的模版方法正是通过实现类扩展的方法来完成业务逻辑。只要实现类中的扩展方法通过了单元测试，在模版方法正确的前提下，
 * 	整体功能一般不会出现大的错误。
 * 
 * 优点：
 * 	1）容易扩展。一般来说，抽象类中的模版方法是不易发生改变的部分，而抽象方法是容易发生变化的部分，因此通过增加实现类一般
 * 	       可以很容易实现功能的扩展，符合开闭原则。
 * 	2）便于维护。对于模版方法模式来说，正是由于他们的主要逻辑相同，才使用了模版方法，假如不使用模版方法，任由这些相同的代码散乱的
 * 	       分布在不同的类中，维护起来是非常不方便的。
 * 	3）比较灵活。因为有钩子方法，因此，子类的实现也可以影响父类中主逻辑的运行。但是，在灵活的同时，由于子类影响到了父类，
 * 	       违反了里氏替换原则，也会给程序带来风险。这就对抽象类的设计有了更高的要求。
 * 
 * 适用场景：
 * 	在多个子类拥有相同的方法，并且这些方法逻辑相同时，可以考虑使用模版方法模式。在程序的主框架相同，细节不同的场合下，
 * 	也比较适合使用这种模式。
 * 
 * @author Mauger
 * @date 2018年4月20日  
 * @version 1.0
 */
public class TemplateMethod extends AbstractSort {

	@Override
	protected void sort(int[] arr) {
		
	    for(int i = 0; i < arr.length - 1; i++) {
	        selectSort(arr, i);
	    }
	}

    private void selectSort(int[] array, int index) {
    	
        int minValue = 32767; // 最小值变量
        int minIndex = 0; // 最小值索引变量
        int temp; // 暂存变量
        
        for (int i = index; i < array.length; i++) {
            if (array[i] < minValue){ // 找到最小值
                minValue = array[i]; // 储存最小值
                minIndex = i; 
            }
        }
        // 交换两数值
        temp = array[index];
        array[index] = array[minIndex];
        array[minIndex] = temp;
    }
}


/**
 * 抽象类
 * @author Mauger
 * @date 2018年4月20日  
 * @version 1.0
 */
abstract class AbstractSort {
	
	/**
	 * 将数组进行正序排序
	 * @param array 数组
	 */
	protected abstract void sort(int[] array);
	
	/**
	 * 打印出排序后的数组
	 * @param array 数组
	 */
	public void showSortResult(int[] array) {
		
		this.sort(array);
		System.out.println(Arrays.toString(array));
	}
}


/**
 * 测试类
 * @author Mauger
 * @date 2018年4月20日  
 * @version 1.0
 */
class Test {
	
	public static void main(String[] args) {
		
		int[] array = { 119, 3, 9, 120, 5, 7, 2, 110 };
		AbstractSort as = new TemplateMethod();
		as.showSortResult(array);
	}
}
