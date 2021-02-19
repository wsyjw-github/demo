package pers.yjw.platform.demo;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * FileTest
 *
 * @author yjw
 * @date 2020-03-18
 * @time 15:05
 * @desc
 */
public class FileTest {
	
	@Test
	public void test1() throws IOException {
		File file2 = new File("/Users/yjw_computer/Documents");// D;/temp 为一个目录
		File tempFile1= file2.createTempFile("msgasd", ".json",file2);
		String filePath = tempFile1.getParentFile().toPath().toString();
		System.out.println("filePath:" + filePath);
//		File tempFile2 = file2.createTempFile("msg", ".tmp");
	}
}
