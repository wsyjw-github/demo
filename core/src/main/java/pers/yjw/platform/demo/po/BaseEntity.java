package pers.yjw.platform.demo.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.dao
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-10 15:12
 */
@Data
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = -8992563457365604525L;
	
	protected Long id;
	/**
	 * 逻辑删除标记：0-正常，1-删除
	 */
	protected Integer isDelete = 0;
	/**
	 * 删除时间戳
	 */
	protected Long delTimestamp = 0L;
	/**
	 * 创建时间
	 */
	protected Date gmtCreate = new Date();
	/**
	 * 修改时间
	 */
	protected Date gmtModify = new Date();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		BaseEntity other = (BaseEntity) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		
		return true;
	}
	
}
