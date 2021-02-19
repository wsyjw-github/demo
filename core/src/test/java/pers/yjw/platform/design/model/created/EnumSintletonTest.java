package pers.yjw.platform.design.model.created;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式:枚举形式   本质上也是饿汉模式
 * 枚举类天然的在IO类与反射类方面的特殊处理，可以天然的防反射攻击，防序列化与反序列化破坏。
 *
 */
public class EnumSintletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //测试是否单例
        EnumSingleton instance = EnumSingleton.getInstance();
        EnumSingleton instance1 = EnumSingleton.getInstance();
        System.out.println(instance == instance1);

        //测试反射是否能绕过单例
        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        EnumSingleton instance2 = declaredConstructor.newInstance("INSTANCE", 0);
        System.out.println(instance == instance2);
    }
}


enum EnumSingleton {
    INSTANCE;

    private EnumSingleton() {
        System.out.println("枚举类构造方法");
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public void doBiz() {
        System.out.println(hashCode());
    }
}