package pers.yjw.platform.demo.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Intention
 *
 * @author yjw
 * @date 2020-03-17
 * @time 17:01
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Intention implements Serializable {
//	private Long id;
	private String intentionName;
//	private String description;
//	private Long nodeId;
//	private Integer status;
//	private String createdBy;
//	private String updatedBy;
//	private Date gmtCreate;
//	private Date gmtModify;
}
