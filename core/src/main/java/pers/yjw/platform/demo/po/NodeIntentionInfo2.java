package pers.yjw.platform.demo.po;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * NodeIntentionInfo
 *
 * @author yjw
 * @date 2020-03-17
 * @time 17:04
 * @desc
 */
@Data
public class NodeIntentionInfo2 implements Serializable {
	private String nodeName;
	private List<String> intentions;
}
