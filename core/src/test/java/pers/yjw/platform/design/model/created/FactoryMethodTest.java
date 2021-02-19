package pers.yjw.platform.design.model.created;


import java.util.Objects;

/**
 * 工厂方法模式
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        // 最初Application的getObject()不带type参数时
//        Application application = new Application();
//        ProductA product = application.getObject();
//        product.method1();

        //简单工厂模式
//        Application application = new Application();
//        Product product = application.getObject("B");
//        product.method1();


        // 工厂方法模式
        Application2 application2 = new ConcreateProductA();
        Product product2 = application2.getObject();
        product2.method1();
    }
}

interface Product {
    public void method1();
}

class ProductA implements Product {

    public void method1() {
        System.out.println("ProductA mehtod1 excuted");
    }
}

class ProductB implements Product {

    public void method1() {
        System.out.println("ProductB mehtod1 excuted");
    }
}

// 简单工厂模式(不属于设计模式，只是一种编码方式)
class SimpleFactory {
    public static Product createProduct(String type) {
        if (Objects.equals("A", type)) {
            return new ProductA();
        } else if (Objects.equals("B", type)) {
            return new ProductB();
        } else {
            return null;
        }
    }
}

class Application {
    private Product createProduct(String type) {
        // ... init
        // 业务实现
        return SimpleFactory.createProduct(type);
    }

    Product getObject(String type) {
        Product product = createProduct(type);
        // ...
        return product;
    }
}

abstract class Application2 {
    abstract Product createProduct();

    Product getObject() {
        Product product = createProduct();
        // ...
        return product;
    }
}

class ConcreateProductA extends Application2 {

    @Override
    Product createProduct() {
        // ...
        return new ProductA();
    }
}

class ConcreateProductB extends Application2 {

    @Override
    Product createProduct() {
        // ...
        return new ProductB();
    }
}