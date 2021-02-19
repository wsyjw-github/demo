package pers.yjw.platform.design.model.created;
/**
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 主要解决：一个全局使用的类频繁地创建与销毁。
 * 使用场景： 1、要求生产唯一序列号。 2、WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。 3、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。
 * Singleton的饿汉模式：线程安全的
 * 触发初始化的方式有好几种：访问静态成员变量、静态方法、main函数所在类作为启动类、反射
 *
 */
public class HungrySingletonTest {
    public static void main(String[] args) {
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance == instance2);
    }
}

class HungrySingleton {

    private static String name = "aaa";

    static{
        System.out.println("静态语句块");
    }

    // 私有的、静态的成员保存唯一的实例
    // 在类被第一次使用的时候，就已经完成了加载。类的加载过程，系统保证线程安全。
    private static HungrySingleton instance = new HungrySingleton();
    // 私有构造器，避免被别人创建实例
    private HungrySingleton(){
        //防止反射调用构造函数，但无法防止第一次时用反射调用
        if (instance != null) {
            throw new RuntimeException("单例不允许多个实例");
        }

        System.out.println("构造器方法");
    }

    public static HungrySingleton getInstance(){
        return instance;
    }

    public static void test(){
        System.out.println("调用test方法");
    }
}