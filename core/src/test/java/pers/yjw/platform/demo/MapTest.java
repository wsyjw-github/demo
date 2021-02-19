package pers.yjw.platform.demo;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Data;
import pers.yjw.platform.demo.client.enums.TaskTypeEnum;
import pers.yjw.platform.demo.util.DateUtil;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * DateTimeFormatterTest
 *
 * @author yjw
 * @date 2019-11-08
 * @time 16:49
 * @desc
 */
public class MapTest {
	
	public static void main(String... args) {
		Map<String, Integer> map = Maps.newHashMap();
		map.put("a", 1);
		map.put("b", 2);
		System.out.println(map);
		map.put("a", 3);
		System.out.println(map);
		System.out.println(map.get("b"));
		System.out.println(map.get("c"));
		
//		String partnerCode = "";
//		test(partnerCode);
//		System.out.println("partnerCode:"+partnerCode);
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for (Map.Entry<String, Integer> entry : entrySet) {
			String mapKey = entry.getKey();
			Integer mapValue = entry.getValue();
			System.out.println(mapKey+":"+mapValue);
		}
		
	}
	
	public static void test(String code){
		code = "aa";
		System.out.println("code:"+code);
	}
}

@Data
class Task {
	private TaskTypeEnum taskTypeEnum;
}