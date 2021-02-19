package pers.yjw.platform.demo.util;

import org.springframework.cglib.proxy.Enhancer;
import pers.yjw.platform.demo.interceptor.CGLIBInterceptory;

/**
 * CGLIBProxy
 *
 * @author yjw
 * @date 2020-01-06
 * @time 11:38
 * @desc
 */
public class CGLIBProxy {
	/**
	 * 专门用来获取代理对象的方法,是通过jdk给提供的api来获取代理对象
	 * @param targetObject 目标对象,就是实际业务的对象,
	 *                     比如:UserServiceImpl类的对象 就是目标对象
	 * @return Object obj 目标对象的代理对象,代理对象是跟目标对象是父子关系,目标对象是长辈, 代理对象小辈。所以目标对象所对应的类,不能是final的。
	 */
	public static Object getProxyObject(Object targetObject) {
		Object obj;
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(targetObject.getClass());
		enhancer.setCallback(new CGLIBInterceptory(targetObject));
		obj=enhancer.create();
		return obj;
	}
}
