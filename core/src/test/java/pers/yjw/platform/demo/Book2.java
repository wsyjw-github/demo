package pers.yjw.platform.demo;

/**
 * Book2
 *
 * @author yjw
 * @date 2020-01-20
 * @time 11:54
 * @desc
 */
public class Book2 {
	public static  void main(String... args) {
		Book.staticFunction();
	}
}


class Book {
	static Book book = new Book();
	
	static {
		System.out.println("书的静态代码块");
	}
	
	{
		System.out.println("书的普通代码块");
	}
	
	Book() {
		System.out.println("书的构造方法");
		System.out.println("price=" + price + ",amount=" + amount);
	}
	
	public static void staticFunction() {
		System.out.println("书的静态方法");
	}
	
	int price = 110;
	static int amount = 112;
}