package pers.yjw.platform.demo;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamTest
 *
 * @author yjw
 * @date 2020-03-02
 * @time 17:18
 * @desc
 */
public class StreamTest {
	
	public static void main(String... args) {
		// 当且仅当存在终端操作时，中间操作才会被执行
		Stream.of("ab", "cba", "dba").filter(o -> {
			System.out.println("filter str:" + o);
			return Objects.nonNull(o) && o.length() > 2;
		}).forEach(System.out::println);
		
		
		// 当且仅当存在终端操作时，中间操作才会被执行, anyMatch 是短路终端操作
		boolean flag = Stream.of("ab", "bba", "dba", "doyd").filter(o -> {
			System.out.println("filter str:" + o);
			return Objects.nonNull(o) && o.length() > 2;
		}).anyMatch(o -> {
			System.out.println("anyMatch: " + o);
			return o.startsWith("d");
		});
		System.out.println("flag:" + flag);
		
		
		Stream<String> stream = Stream.of("ab", "cba", "dba", "boyd").filter(o -> o.length() > 2);
		// 对流进行终端操作后，流关闭了，不能再次复用
		stream.anyMatch(o -> o.startsWith("a"));
		stream.noneMatch(o -> o.startsWith("a"));
		
		
		// Supplier包装Stream，每次调用get()返回新的Stream
		Supplier<Stream<String>> supplier = () -> Stream.of("ab", "cba", "dba", "boyd").filter(o -> o.length() > 2);
		supplier.get().anyMatch(o -> o.startsWith("a"));
		supplier.get().allMatch(o -> o.startsWith("a"));
		
		
	}
}

@Data
class Car {
	private Double speed;
	private String model;
}