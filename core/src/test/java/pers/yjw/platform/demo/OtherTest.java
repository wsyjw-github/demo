package pers.yjw.platform.demo;

import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import pers.yjw.platform.demo.po.UserEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * ${name}
 *
 * @author jianwei.yao
 * @date 2019-09-30
 * @time 19:50
 * @desc
 */
public class OtherTest {
	private static final String LABELMASTER = "xue.shen@tongdun.cn,\n" +
			"kangli.zhou@tongdun.cn,\n" +
			"hui.wang@tongdun.cn,\n" +
			"xiao.li@tongdun.cn,\n" +
			"yibo.liu@tongdun.cn,\n" +
			"jiawen.hu@tongdun.cn,\n" +
			"wenwen.sun@tongdun.cn,\n" +
			"mingyue.qin@tongdun.cn,\n" +
			"xingyan.du@tongdun.cn,\n" +
			"chenlong.wu@tongdun.cn,\n" +
			"xiaoqi.sun@tongdun.cn,\n" +
			"xue.du@tongdun.cn,\n" +
			"wenhan.tang@tongdun.cn,\n" +
			"meng.wang@tongdun.cn,\n" +
			"wb-zhangnannan@tongdun.cn,\n" +
			"wb-manxin@tongdun.cn,\n" +
			"wb-luhongchang@tongdun.cn,\n" +
			"caiyun.wang@tongdun.cn,\n" +
			"man.liu@tongdun.cn,\n" +
			"xiaoming.hou@tongdun.cn,\n" +
			"hongli.li@tongdun.cn,\n" +
			"yue.wang001@tongdun.cn,\n" +
			"wenjing.sun@tongdun.cn,\n" +
			"yifei.wang@tongdun.cn,\n" +
			"xuan.feng@tongdun.cn,\n" +
			"kairan.zhao@tongdun.cn,\n" +
			"zhaoxia.li@tongdun.cn,\n" +
			"kaixin.zhao@tongdun.cn,\n" +
			"qian.zhang001@tongdun.cn,\n" +
			"xuenan.cheng@tongdun.cn,\n" +
			"xiaomeng.wang@tongdun.cn,\n" +
			"lixia.wang@tongdun.cn,\n" +
			"saisai.han@tongdun.cn,\n" +
			"ziyu.he@tongdun.cn,\n" +
			"jingya.shao@tongdun.cn,\n" +
			"ling.zheng@tongdun.cn,\n" +
			"xiaocui.li@tongdun.cn,\n" +
			"ruizhen.wu@tongdun.cn,\n" +
			"zhaohan.liu@tongdun.cn,\n" +
			"jialin.ma@tongdun.cn,\n" +
			"yakang.jiang@tongdun.cn,\n" +
			"li.xu@tongdun.cn,\n" +
			"lizhe.hu@tongdun.cn";
	
	public static void main(String... args) {
		
//		String[] strings = LABELMASTER.split(",");
//		List<String> labelMasterList = Arrays.asList(strings);
//		System.out.println(labelMasterList);

//		Integer[] integers = new Integer[]{0};
//		System.out.println(Arrays.toString(integers));
//		integers[0] = 1;
//		System.out.println(Arrays.toString(integers));
//		System.out.println(integers[0]);
//		integers[0] = 0;
//		System.out.println(Arrays.toString(integers));
//
//		Integer aaa = null;
//		BigDecimal percent = new BigDecimal(0);
//		System.out.println(Objects.equals(new BigDecimal(0), percent));
//		BigDecimal bbb = new BigDecimal(aaa);
//		System.out.println(Objects.nonNull(bbb));
//		List<String> list1 = null;
//		List<String> list2 = Lists.newArrayList();
//		List<String> list3 = Lists.newArrayList();
//		list3.add("a");
//
//		System.out.println(CollectionUtils.isEmpty(list1));
//		System.out.println(CollectionUtils.isEmpty(list2));
//		System.out.println(CollectionUtils.isEmpty(list3));
		System.out.println(false || true);
		System.out.println(new Date().getTime());
		TestArray testArray = new TestArray();
		System.out.println(testArray.getSize());
		int i = 10 >> 1;
		System.out.println(i);
	}
}
@Data
class TestArray{
	private int size;
}