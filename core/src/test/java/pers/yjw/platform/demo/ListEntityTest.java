package pers.yjw.platform.demo;

import lombok.Data;
import org.assertj.core.util.Lists;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * ListEntityTest
 *
 * @author yjw
 * @date 2019-10-25
 * @time 16:47
 * @desc
 */
public class ListEntityTest {
	public static List getData() {
		List<Long> list = Lists.newArrayList();
		list.add(1L);
		list.add(2L);
		list.add(2L);
		return list;
	}
	
	public static List getData2() {
		List<Long> list = Lists.newArrayList();
		list.add(1L);
		list.add(3L);
		list.add(4L);
		return list;
	}
	
	public static List getData3() {
		List<String> list = Lists.newArrayList();
//		list.add("你_好-");
//		list.add("asfdgh");
//		list.add("你_好-");
		return list;
	}
	
	public static void main (String... args) {
		
		
		List<Long> list;
//		list = getData3();
//		System.out.println(list);
//		System.out.println(list.size());
//		Long count = list.stream().distinct().count();
//		System.out.println("去重后数量count：" + count);
		
		list = getData2();
		list.add(0,2L);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list.get("+ i +"):"+list.get(i));
		}
		list.remove(1);
		System.out.println("******************");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list.get("+ i +"):"+list.get(i));
		}
		int[] brr = {};
		brr = Arrays.copyOf(brr, 10);
		System.out.println(Arrays.toString(brr));
		
		int [] arr = new int[] {1,3,4,5,6};
		System.out.println(Arrays.toString(arr));
		arr = Arrays.copyOf(arr, arr.length + 1);
		System.out.println(Arrays.toString(arr));
		
		System.arraycopy(arr, 1, arr, 1 + 1,
				5 - 1);
		System.out.println(Arrays.toString(arr));
		arr[1] = 2;
		System.out.println(Arrays.toString(arr));
//
//
//
//		Optional.ofNullable(list).orElse(com.google.common.collect.Lists.newArrayList()).forEach(it -> {
//			System.out.println(it);
//		});
//
//		List<String> list3 = Lists.newArrayList();
//		System.out.println(list3.size());
		
		
//		int num1 = 0;
//		for (int i = 0; i < 2; i++) {
//
//			int index = getIndex(num1);
//			num1 = index;
//			System.out.println("num1:"+num1);
//		}
	}
	
	public static int getIndex(int index) {
		List<String> list = Lists.newArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		list.add("h");
		list.add("i");
		list.add("j");
		list.add("K");
		list.add("L");
		list.add("M");
		list.add("N");
		for (int i = 0; i < 5; i++) {
			System.out.println(list.get(index++));
		}
		return index;
	}
	
}
