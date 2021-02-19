package pers.yjw.platform.demo.util;

import pers.yjw.platform.demo.handler.ProxyHandler;

import java.lang.reflect.Proxy;

/**
 * JDKProxy
 *
 * @author yjw
 * @date 2020-01-06
 * @time 09:39
 * @desc
 */
public class JDKProxy {
	/**
	 * 专门用来获取代理对象的方法,是通过jdk给提供的api来获取代理对象
	 * @param targetObject 目标对象,就是实际业务的对象,
	 *                     比如:UserServiceImpl类的对象 就是目标对象
	 * @return Object obj 目标对象的代理对象,代理对象是跟目标对象是兄弟关系,所以目标对象所对应的类,必须有接口
	 */
	public static Object getProxyObject(Object targetObject) {
		Object obj=null;
		/**
		 * Object obj就是代理对象
		 * 一参:目标对象的类加载器,获取到类路径
		 * 二参:目标对象的接口,根据接口造出接口的对象
		 * 三参:InvocationHandler接口的回调,实际就是实际业务和额外新功能的耦合类
		 */
		obj= Proxy.newProxyInstance(
				targetObject.getClass().getClassLoader(),
				targetObject.getClass().getInterfaces(),
				new ProxyHandler(targetObject));
		
		return obj;
	}
}
