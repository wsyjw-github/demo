package pers.yjw.platform.design.model.created;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式：静态内部类的形式
 * 也是依赖JVM的加载机制保证其线程安全
 */
public class InnerClassSingletonTest {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, IOException, ClassNotFoundException {
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        System.out.println(instance);

        //测试反射是否能绕过单例创建成功
//        Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
//        declaredConstructor.setAccessible(true);
//        InnerClassSingleton newInstance = declaredConstructor.newInstance();
//        InnerClassSingleton instance = InnerClassSingleton.getInstance();
//        System.out.println(newInstance == instance);


        // 序列化与反序列化(若不添加readResolve()方法反序列化后不会调用这个类定义的构造函数，会从字节流中拿取数据进行初始化；还需要加serialVersionUID保证版本一致)
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("InnerClassSingleton.txt"));
        oos.writeObject(instance);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("InnerClassSingleton.txt"));
        InnerClassSingleton instance2 = (InnerClassSingleton) ois.readObject();
        ois.close();
        System.out.println(instance == instance2);
    }
}

class InnerClassSingleton implements Serializable {
    // 不加版本号时，如果序列化后再对这个类进行修改，运行就会报错
    private static final long serialVersionUID = 6113916649496207022L;

    static {
        System.out.println("InnerClassSingleton");
    }

    private static class SingletonHolder {
        static {
            System.out.println("SingletonHolder");
        }
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton () {
        //防止反射调用构造函数，但无法防止第一次时用反射调用
        if (InnerClassSingleton.getInstance() != null) {
            throw new RuntimeException("单例不允许多个实例……");
        }
    }

    public static InnerClassSingleton getInstance(){
        return SingletonHolder.instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致(没有这个方法，反序列化时不会调用这个类定义的构造函数) */
    public Object readResolve() {
        return SingletonHolder.instance;
    }
}