package pers.yjw.platform.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.assertj.core.util.Lists;
import org.junit.Test;
import pers.yjw.platform.demo.po.Intention;
import pers.yjw.platform.demo.po.Node;
import pers.yjw.platform.demo.po.NodeIntentionInfo;
import pers.yjw.platform.demo.po.NodeIntentionInfo2;

import java.util.List;

/**
 * NodeTest
 *
 * @author yjw
 * @date 2020-03-17
 * @time 17:05
 * @desc
 */
public class NodeTest {

	@Test
	public void test1() {
		List<NodeIntentionInfo> nodeIntentionInfos = Lists.newArrayList();
		
		for (int j = 0; j < 3; j++) {
			Integer a = j + 1;
			Long nodeId = a.longValue();
			
			NodeIntentionInfo vo = new NodeIntentionInfo();
			Node node = Node.builder().nodeName("节点" + nodeId).build();
			List<Intention> intentionEntities = Lists.newArrayList();
			for (int i = 0; i < 3; i++) {
				Integer b = i + 1;
				Long intentionId = b.longValue();
				Intention intention = Intention.builder().intentionName("意图" + intentionId).build();
				intentionEntities.add(intention);
			}
			
			vo.setNode(node);
			vo.setIntentions(intentionEntities);
			
			nodeIntentionInfos.add(vo);
		}
		
		System.out.println(JSON.toJSONString(nodeIntentionInfos));
		
	}
	
	@Test
	public void test2() {
		String json = "[\n" +
				"\t{\n" +
				"\t\t\"node\": {\n" +
				"\t\t\t\"nodeName\": \"节点1\"\n" +
				"\t\t},\n" +
				"\t\t\"intentions\": [\n" +
				"\t\t\t{\n" +
				"\t\t\t\t\"intentionName\": \"意图a\"\n" +
				"\t\t\t}, {\n" +
				"\t\t\t\t\"intentionName\": \"意图b\"\n" +
				"\t\t\t}, {\n" +
				"\t\t\t\t\"intentionName\": \"意图c\"\n" +
				"\t\t\t}\n" +
				"\t\t]\n" +
				"\t}, \n" +
				"\t{\n" +
				"\t\t\"node\": {\n" +
				"\t\t\t\"nodeName\": \"节点2\"\n" +
				"\t\t},\n" +
				"\t\t\"intentions\": [\n" +
				"\t\t\t{\n" +
				"\t\t\t\t\"intentionName\": \"意图a\"\n" +
				"\t\t\t}, {\n" +
				"\t\t\t\t\"intentionName\": \"意图e\"\n" +
				"\t\t\t}, {\n" +
				"\t\t\t\t\"intentionName\": \"意图f\"\n" +
				"\t\t\t}\n" +
				"\t\t]\n" +
				"\t}, \n" +
				"\t{\n" +
				"\t\t\"node\": {\n" +
				"\t\t\t\"nodeName\": \"节点3\"\n" +
				"\t\t},\n" +
				"\t\t\"intentions\": [\n" +
				"\t\t\t{\n" +
				"\t\t\t\t\"intentionName\": \"意图a\"\n" +
				"\t\t\t}, {\n" +
				"\t\t\t\t\"intentionName\": \"意图h\"\n" +
				"\t\t\t}, {\n" +
				"\t\t\t\t\"intentionName\": \"意图i\"\n" +
				"\t\t\t}\n" +
				"\t\t]\n" +
				"\t}\n" +
				"]";
		String json2 = "[\n" +
				"    {\n" +
				"        \"nodeName\": \"节点1\",\n" +
				"        \"intentions\": [\"意图a\", \"意图b\", \"意图c\"]\n" +
				"    }, \n" +
				"    {\n" +
				"        \"nodeName\": \"节点2\",\n" +
				"        \"intentions\": [\"意图a\", \"意图e\", \"意图f\"]\n" +
				"    }, \n" +
				"    {\n" +
				"        \"nodeName\": \"节点3\",\n" +
				"        \"intentions\": [\"意图d\", \"意图f\", \"意图g\"]\n" +
				"    }\n" +
				"]";
//		List<NodeIntentionInfo> nodeIntentionVOS = JSONObject.parseObject(json, List.class);
		List<NodeIntentionInfo2> list = JSONObject.parseArray(json2, NodeIntentionInfo2.class);
		System.out.println(list);
		System.out.println(list.get(0).getNodeName());
		System.out.println(list.get(0).getIntentions());
//		List<Intention> intentions = list.get(1).getIntentions();
//		System.out.println(intentions);
//		System.out.println(list.get(2).getNode().getNodeName());
//		System.out.println(list.get(1).getIntentions().get(1).getIntentionName());
	}
}
