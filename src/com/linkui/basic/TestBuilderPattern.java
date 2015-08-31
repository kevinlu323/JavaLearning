package com.linkui.basic;

class Starbucks {
    private String size;
    private String drink;
 
    public void setSize(String size) {
        this.size = size;
    }
 
    public void setDrink(String drink) {
        this.drink = drink;
    }
}
 
//抽象builder
abstract class StarbucksBuilder {
    protected Starbucks starbucks;
 
    public Starbucks getStarbucks() {
        return starbucks;
    }
 
    public void createStarbucks() {
        starbucks = new Starbucks();
        System.out.println("a drink is created");
    }
 
    public abstract void buildSize();
    public abstract void buildDrink();
}
 
// 泡茶builder
class TeaBuilder extends StarbucksBuilder {
    public void buildSize() {
        starbucks.setSize("large");
        System.out.println("build large size");
    }
 
    public void buildDrink() {
        starbucks.setDrink("tea");
        System.out.println("build tea");
    }
 
}
 
// 泡咖啡builder
class CoffeeBuilder extends StarbucksBuilder {
    public void buildSize() {
        starbucks.setSize("medium");
        System.out.println("build medium size");
    }
 
    public void buildDrink() {
        starbucks.setDrink("coffee");
        System.out.println("build coffee");
    }
}
 
//指导如何封装builder
class Waiter {
    private StarbucksBuilder starbucksBuilder;
 
    public void setStarbucksBuilder(StarbucksBuilder builder) {
        starbucksBuilder = builder;
    }
 
    public Starbucks getstarbucksDrink() {
        return starbucksBuilder.getStarbucks();
    }
 
    public void constructStarbucks() {
        starbucksBuilder.createStarbucks();
        starbucksBuilder.buildDrink();
        starbucksBuilder.buildSize();
    }
}
 
//客户
public class TestBuilderPattern { //Custom
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        StarbucksBuilder coffeeBuilder = new CoffeeBuilder();
 
        //也可以用泡茶builder沏茶
        //StarbucksBuilder teaBuilder = new TeaBuilder();
 
        waiter.setStarbucksBuilder(coffeeBuilder);
        waiter.constructStarbucks();
 
        //取到饮料
        Starbucks drink = waiter.getstarbucksDrink();
 
    }
}