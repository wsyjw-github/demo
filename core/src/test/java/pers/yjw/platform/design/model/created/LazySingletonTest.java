package pers.yjw.platform.design.model.created;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 主要解决：一个全局使用的类频繁地创建与销毁。
 * 使用场景： 1、要求生产唯一序列号。 2、WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。 3、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。
 * 单例（Singleton）模式：某个类只能生成一个实例，该类提供了一个全局访问点供外部获取该实例，其拓展是有限多例模式。
 * 这个属于懒汉模式：非线程安全的
 */
public class LazySingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(instance);

        // 通过反射可调用私有构造方法
		Class obj = LazySingleton.class;
		Constructor constructor= obj.getDeclaredConstructor();
		constructor.setAccessible(true);
		LazySingleton newInstance = (LazySingleton)constructor.newInstance();

		System.out.println(newInstance);
// 		System.out.println(instance == newInstance);


        // 序列化与反序列化(若不添加readResolve()方法反序列化时不会调用这个类定义的构造函数，会从字节流中拿取数据进行初始化；需要加serialVersionUID保证版本一致
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\TDResource\\TD\\Works\\Projects\\yjw\\LazySingleton.txt"));
//        oos.writeObject(instance);
//        oos.close();
//
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\TDResource\\TD\\Works\\Projects\\yjw\\LazySingleton.txt"));
//        LazySingleton instance1 = (LazySingleton) ois.readObject();
//        ois.close();
//        System.out.println(instance == instance1);
    }
}


class LazySingleton implements Serializable {
    // 不加版本号时，如果序列化后再对这个类进行修改，运行就会报错
    private static final long serialVersionUID = 8677939764648461531L;

    static{
        System.out.println("静态语句块");
    }

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private volatile static LazySingleton instance = null;

    /* 私有构造方法，防止被实例化 */
    private LazySingleton() {
        //防止反射调用构造函数，但无法防止第一次时用反射调用
        if (instance != null) {
            throw new RuntimeException("单例不允许多个实例");
        }
        System.out.println("构造器方法");
    }

    /* 静态工程方法，创建实例 */
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    //指令重排序可能会让2 3两步顺序调换 。可让方法用volatile修饰
                    // 1、堆分配空间
                    // 2、初始化
                    // 3、instance指向内存空间地址(引用赋值)
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }


    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return instance;
    }

    public static void test(){
        System.out.println("调用test()方法");
    }

}
