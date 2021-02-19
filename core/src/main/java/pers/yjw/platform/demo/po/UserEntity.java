package pers.yjw.platform.demo.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.po
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-10 15:13
 * @Builder注解 会默认为类加上全参构造函数，且提供以建造器模式构造对象的方法。
 * 但此时因为显示声明了构造器，默认的无参构造器就失效了，就不能通过new Obj()的方式创建对象。
 * 但是如果只显式声明@NoArgsConstructor，lombok就不会生成全参构造函数，而@Builder中会用到全参构造函数，运行冲突。
 *
 * 若要修改原对象的属性值，则要求实体上添加@Builder(toBuilder=true),
 * 属性修改方法：userEntity = userEntity.toBuilder().accountName("asdf").build();
 * 直接写userEntity.toBuilder().accountName("asdf").build()，该属性不会被修改
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserEntity extends BaseEntity {
	/**
	 * 创建者
	 */
	private String createBy;
	
	/**
	 * 修改者
	 */
	private String updateBy;
	
	/**
	 * 账户
	 */
	private String accountName;
	
	/**
	 * 真实姓名
	 */
	private String realName;
	
	/**
	 * 角色
	 */
	private String role;
	
	/**
	 * 状态
	 */
	private Integer status;
	
}
