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
public class NodeIntentionInfo implements Serializable {
	private Node node;
	private List<Intention> intentions;
}
