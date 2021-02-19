package pers.yjw.platform.demo;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import pers.yjw.platform.demo.po.UserEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * OptionalTest
 *
 * @author yjw
 * @date 2019-11-01
 * @time 09:51
 * @desc
 */
@Slf4j
public class OptionalTest {
	public static void main (String... args) {
		UserEntity entity1 = new UserEntity();
		UserEntity entity2 = UserEntity.builder().
				createBy("system").
				updateBy("system").
				accountName("test1").
				realName("tt").
				status(1).
				build();
		UserEntity entity3 = UserEntity.builder().
				createBy("system").
				updateBy("system").
				realName("tt").
				status(1).
				build();
		
		Optional<UserEntity> opt =  Optional.ofNullable(entity2);
		/**
		 *  get()：从 Optional 实例中取回实际值对象
		 */
		log.info("opt.get():{}", opt.get());
		
		/**
		 * isPresent()：检查是否有值
		 */
		log.info("opt.isPresent():{}", opt.isPresent());
		opt.ifPresent(u -> log.info(""));
		opt.ifPresent(u -> {
			if (Objects.equals("test", u.getAccountName())) {
				System.out.println("OK");
			}
		});
		
		
		//Optional 类提供了 API 用以返回对象值
		/**
		 * orElse()和orElseGet()：
		 * 当entity1为空时，都会执行createUser()。
		 * 区别：当entity1不为空时，orElse() 方法仍然执行了createUser()。与之相反，orElseGet() 方法不执行——————性能差异
		 */
		entity1 = new UserEntity();
		log.info("使用orElse");
		UserEntity userEntity1 = Optional.ofNullable(entity1).orElse(createUser("orElse"));
		log.info("使用orElseGet");
		UserEntity userEntity2 = Optional.ofNullable(entity1).orElseGet(() -> createUser("orElseGet"));
		
		
		/**
		 * orElseThrow() 可以决定抛出什么样的异常(用处：可使用自定义异常)
		 */
		UserEntity userEntity3 = Optional.ofNullable(entity1).orElseThrow(() -> new NullPointerException());
		
		/**
		 * .map()
		 */
		String accountName = Optional.ofNullable(entity3).map(e -> e.getAccountName()).orElse("defaultName");
		String accountName1 =
				Optional.ofNullable(entity2).map(e -> {
					String name = "";
					if (Objects.equals("test", e.getAccountName())) {
						name = "testCheck";
					} else {
						name = null;
					}
					return name;
				}).orElse("default");
		log.info("accountName:{}", accountName);
		log.info("accountName1:{}",accountName1);
		
		/**
		 * .filter()
		 */
		Optional opt3 = Optional.ofNullable(entity3).filter(e -> e.getRealName()!= null);
		log.info("opt3:{}",opt3);
		UserEntity entity4 = null;
		Optional opt4 = Optional.ofNullable(entity4).filter(Objects::nonNull);
		log.info("opt4:{}",opt4);
		
		
		/**
		 *
		 */
		List<UserEntity> list = Lists.newArrayList();
//		list.add(entity1);
//		list.add(entity2);
		list.add(entity3);
		list.add(entity4);
		
		List<UserEntity> userEntityList = Optional.ofNullable(list).orElse(Lists.newArrayList())
				.stream().filter(Objects::nonNull).collect(Collectors.toList());
		log.info("userEntityList:{}", userEntityList);
	}
	
	
	
	public static UserEntity createUser(String msg) {
		log.info("Use {} creating New User", msg);
		return UserEntity.builder().
				createBy("system").
				updateBy("system").
				accountName("test").
				realName("tt").
				status(1).
				build();
	}
	
}
