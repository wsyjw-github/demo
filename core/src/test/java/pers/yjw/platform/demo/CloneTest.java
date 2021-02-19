package pers.yjw.platform.demo;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * CloneTest
 *
 * @author yjw
 * @date 2020-03-06
 * @time 15:58
 * @desc 总结：
 * 1.浅克隆：只复制基本类型的数据，引用类型的数据只复制了引用的地址，引用的对象并没有复制，在新的对象中修改引用类型的数据会影响原对象中的引用。
 * 2.深克隆：是在引用类型的类中也实现了cloneable，是clone的嵌套，复制后的对象与原对象之间完全不会影响。
 * 3.使用序列化也能完成深复制的功能：对象序列化后写入流中，此时也就不存在引用什么的概念了，再从流中读取，生成新的对象，新对象和原对象之间也是完全互不影响的。
 * 4.使用clone实现的深克隆其实是浅克隆中嵌套了浅克隆，与toString方法类似
 */
public class CloneTest {
	
	//浅复制
	@Test
	public void testBook() {
		Chapter chapter1 = new Chapter("第一章", 2500, 15);
		Chapter chapter2 = new Chapter("第二章", 2600, 16);
		MyBook book = new MyBook(1l, "三国演义", "罗贯中", Lists.newArrayList(chapter1, chapter2));
		MyBook cloneBook = (MyBook) book.clone();
		System.out.println(book == cloneBook);  //false
		System.out.println(book.getChapterList() == cloneBook.getChapterList()); //true
		//给book对象的chapterList加一个元素，可以看到cloneBook的chapter也变化了
		book.getChapterList().add(new Chapter("第三章", 2500, 15));
		System.out.println(cloneBook.getChapterList().size()); //3
	}
	
	//深复制
	@Test
	public void testDeepClone() throws Exception {
		Chapter chapter1 = new Chapter("第一章", 2500, 15);
		Chapter chapter2 = new Chapter("第二章", 2600, 16);
		MyBook book = new MyBook(1l, "三国演义", "罗贯中", Lists.newArrayList(chapter1, chapter2));
		
		MyBook cloneBook = (MyBook) CloneTest.deepCloneObject(book);
		
		System.out.println(book == cloneBook);
		System.out.println(book.getChapterList() == cloneBook.getChapterList());
		
	}
	
	
	public static Object deepCloneObject(Object obj) throws IOException, ClassNotFoundException {
		//将对象转换为字节流写入流中
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteOut);
		out.writeObject(obj);
		//从流里读出来
		ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
		ObjectInputStream in = new ObjectInputStream(byteIn);
		
		return in.readObject();
	}
}


@Getter
class MyBook implements Cloneable, Serializable {
	
	private Long id;
	
	private String bookname;
	
	private String author;
	
	private List<Chapter> chapterList;
	
	public MyBook() {
	}
	
	public MyBook(Long id, String bookname, String author, List<Chapter> chapterList) {
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.chapterList = chapterList;
	}
	
	
	/**
	 * 重写Object的clone方法
	 */
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

@Getter
class Chapter implements Serializable {
	
	//章节的名称
	private String name;
	
	//章节的字数
	private Integer size;
	
	//章节的页数
	private Integer pageQty;
	
	public Chapter() {
	}
	
	public Chapter(String name, Integer size, Integer pageQty) {
		this.name = name;
		this.size = size;
		this.pageQty = pageQty;
	}
	
}