package pers.yjw.platform.demo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ProxyHandler
 *
 * @author yjw
 * @date 2020-01-06
 * @time 09:41
 * @desc
 */
public class ProxyHandler implements InvocationHandler {
	
	@Autowired
	private PlatformTransactionManager txManager;
	
	private Object targetObject;
	public ProxyHandler(Object targetObject) {
		this.targetObject=targetObject;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj=null;
		
		//开启事务
		TransactionStatus transactionStatus = txManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			
			//由目标对象调用实际的功能方法
			obj=method.invoke(targetObject, args);//targetObject.addUser();
			
			//提交事务
			txManager.commit(transactionStatus);//提交
		}catch(Exception e) {
			e.printStackTrace();
			//回滚事务
			txManager.rollback(transactionStatus);
			
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
		}
		return obj;
	}
}
