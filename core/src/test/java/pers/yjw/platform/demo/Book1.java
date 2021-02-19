package pers.yjw.platform.demo;

/**
 * Book1
 *
 * @author yjw
 * @date 2020-01-20
 * @time 11:50
 * @desc
 */
public class Book1 {
	public static void main(String[] args) {
		staticFunction();
	}
	
	static Book1 book1 = new Book1();
	
	static {
		System.out.println("书的静态代码块");
	}
	
	{
		System.out.println("书的普通代码块");
	}
	
	Book1() {
		System.out.println("书的构造方法");
		System.out.println("price=" + price + ",amount=" + amount);
	}
	
	public static void staticFunction() {
		System.out.println("书的静态方法");
	}
	
	int price = 110;
	static int amount = 112;
}
