package pers.yjw.platform.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.lang.reflect.Method;

/**
 * CGLIBInterceptory
 *
 * @author yjw
 * @date 2020-01-06
 * @time 11:40
 * @desc
 */
public class CGLIBInterceptory implements MethodInterceptor {
	@Autowired
	private PlatformTransactionManager txManager;
	
	private Object targetObject;
	public CGLIBInterceptory(Object targetObject) {
		this.targetObject=targetObject;
	}
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object obj=null;
		try {
			
			//开启事务
			TransactionStatus transactionStatus = txManager.getTransaction(new DefaultTransactionDefinition());
			
			obj=method.invoke(targetObject, args);
			
			//提交事务
			txManager.commit(transactionStatus);//提交
		}catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
