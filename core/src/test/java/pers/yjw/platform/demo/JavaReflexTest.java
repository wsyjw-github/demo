package pers.yjw.platform.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName com.example.demo
 * @description:
 * @author: YaoJianwei
 * @create: 2019-07-18 09:39
 */
public class JavaReflexTest {
	
	public static void main(String... args) throws Exception {
		Person p = new Person("1.0.0", "jack", 10);
		//获取对象的成员方法的信息
//        printClassMethodMessage(p);
		//获取对象的成员变量的信息
//        printFieldMessage(p);
		//对象的构造函数的信息
//        printConMessage(p);
		
		
		Object obj = p;
		Field field = obj.getClass().getField("version");
		field.setAccessible(true);//设置为可访问,version为public，这里没必要用
		Object value = field.get(obj); //获得值。字段不是静态字段的话,要传入反射类的对象。如果字段是静态字段的话,传入任何对象都是可以的,包括null
		System.out.println(value instanceof String);
		System.out.println("value:" + value);
		
		Field field2 = obj.getClass().getDeclaredField("name");
		field2.setAccessible(true);//设置为可访问(在用反射时允许访问私有变量)
		Object value2 = field2.get(obj);
		System.out.println("value2:" + value2);
		field2.set(obj, "Jhon");
		System.out.println("obj:" + obj + ",name:" + field2.get(obj));
		
		
		//B继承A
//        A aa = new A();
//        System.out.println(Objects.equals(aa.getClass(), A.class));//true
//
//        A aaa = new B();
//        System.out.println(Objects.equals(aaa.getClass(), A.class));//false
//        System.out.println(Objects.equals(aaa.getClass(), B.class));//true
		
		
		/**
		 * getMethod()中第二个参数Class<?>... parameterTypes 为执行该方法的所有参数(按顺序)的类类型，没有参数则为null
		 * 获取某个具体方法
		 */
//        Method getInfoMethod = obj.getClass().getMethod("getInfo", String.class, Integer.class);
		Method getInfoMethod = obj.getClass().getMethod("getAge", String.class, Integer.class);
//        System.out.println(getInfoMethod.getName());
		Object result = getInfoMethod.invoke(obj, "Alies", 21);//invoke返回值为具体方法的返回值
		System.out.println(result);
	}
	
	/**
	 * 获取Class类的三种方式
	 *
	 * @throws ClassNotFoundException
	 */
	public void getClassForThreeMethod() throws ClassNotFoundException {
		// 1、Class类的forName方法
		Class<?> clazz1 = Class.forName("pers.yjw.platform.demo.Person");
		
		// 2、通过一个类的对象的getClass()方法
		Class<?> clazz2 = new Person().getClass();
		
		// 3、Class字面常量
		Class<Person> clazz3 = Person.class;
	}
	
	@Test
	public void CreateObject() throws IllegalAccessException, InstantiationException, InvocationTargetException,
			NoSuchMethodException {
		Class<Person> pClass = Person.class;
		// 1、使用Class对象的newInstance()方法来创建该Class对象对应类的实例(这种方式要求该Class对象的对应类有默认构造器)。
		Person p = pClass.newInstance();
		System.out.println(p);
		// 2、先使用Class对象获取指定的Constructor对象, 再调用Constructor对象的newInstance()方法来创建该Class对象对应类的实例(通过这种方式可以选择指定的构造器来创建实例)。
		Constructor<Person> constructor = pClass.getDeclaredConstructor(
				String.class, Integer.class);
		Person person2 = constructor.newInstance("zhangsan", 20);
		System.out.println(person2);
		
	}
	
	/**
	 * 获取对象的成员方法的信息
	 *
	 * @param obj
	 */
	public static void printClassMethodMessage(Object obj) throws NoSuchMethodException, InvocationTargetException,
			IllegalAccessException {
		// 要获取类的信息 首先要获取类的类类型,传递的是哪个子类的对象 c就是该子类的类类型
		Class c = obj.getClass();
//        Method getInfoMethod = c.getMethod("getInfo", String.class, Integer.class);//获取某个具体方法
//		getInfoMethod.invoke(obj, null);//调用某个具体方法
		// 获取类的名称
		System.out.println("类的名称是:" + c.getName());
		/*
		 * Method类，方法对象 一个成员方法就是一个Method对象
		 * getMethods()方法获取的是所有的public的函数，包括父类继承而来的
		 * getDeclaredMethods()获取的是所有该类自己声明的方法，不问访问权限
		 */
		// c.getDeclaredMethods()
		Method[] ms = c.getMethods();
		for (int i = 0; i < ms.length; i++) {
			// 得到方法的返回值类型的类类型
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName() + " ");
			// 得到方法的名称
			System.out.print(ms[i].getName() + "(");
			// 获取参数类型--->得到的是参数列表的类型的类类型
			Class[] paramTypes = ms[i].getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				Class class1 = paramTypes[j];
				if (j < paramTypes.length - 1) {
					System.out.print(class1.getName() + ",");
				} else {
					System.out.print(class1.getName());
				}
			}
			System.out.println(")");
		}
	}
	
	/**
	 * 获取对象的成员变量的信息
	 *
	 * @param obj
	 */
	public static void printFieldMessage(Object obj) {
		Class c = obj.getClass();
		/*
		 * 成员变量也是对象 java.lang.reflect.Field Field类封装了关于成员变量的操作
		 * getFields()方法获取的是所有的public的成员变量的信息，包括父类的。
		 * getDeclaredFields获取的是该类自己声明的成员变量的信息，包括public，protected，private。
		 */
		// Field[] fs = c.getFields();
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			// 得到成员变量的类型的类类型
//            Class fieldType = field.getType();
			String typeName = field.getType().getName();
			// 得到成员变量的名称
			String fieldName = field.getName();
			System.out.println(typeName + " " + fieldName);
		}
	}
	
	/**
	 * 打印对象的构造函数的信息
	 *
	 * @param obj
	 */
	public static void printConMessage(Object obj) {
		Class c = obj.getClass();
		/*
		 * 构造函数也是对象 java.lang. Constructor中封装了构造函数的信息
		 * getConstructors获取所有的public的构造函数 getDeclaredConstructors得到所有的构造函数
		 */
		// Constructor[] cs = c.getConstructors();
		Constructor[] cs = c.getDeclaredConstructors();
		for (Constructor constructor : cs) {
			System.out.print(constructor.getName() + "(");
			// 获取构造函数的参数列表--->得到的是参数列表的类类型
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");
		}
	}
	
}

/**
 * Data注解：
 * 1、所有属性的get和set方法
 * 2、toString 方法
 * 3、hashCode方法
 * 4、equals方法
 * <p>
 * AllArgsConstructor注解：（全部参数的）有参构造
 */
@Data
@AllArgsConstructor
class Person {
	public String version;
	private String name;
	private Integer age;
	
	public Person() {
	}
	
	
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public String getInfo(String name, Integer age) {
		System.out.println("name is:" + name + ",age is:" + age);
		return "name:" + name + ",age:" + age;
	}
	
	public Integer getAge(String name, Integer age) {
		return age;
	}
	
	
	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
	
}