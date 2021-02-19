package pers.yjw.platform.demo.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.yjw.platform.demo.client.dto.RespDto;
import pers.yjw.platform.demo.client.dto.UserInfo;
import pers.yjw.platform.demo.client.service.UserService;
import pers.yjw.platform.demo.dao.UserDao;
import pers.yjw.platform.demo.exception.ErrorCode;
import pers.yjw.platform.demo.po.UserEntity;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.service
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-10 17:57
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private Mapper mapper;
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;

//	@Resource
//	private SqlSession sqlSession;
	
	@Override
	public RespDto<UserInfo> selectByAccountName(String accountName) {
		UserEntity userEntity = userDao.selectByAccountName(accountName);
		log.info("userEntity：{}", userEntity);
		
		if (Objects.nonNull(userEntity)) {
			UserInfo userInfo = mapper.map(userEntity, UserInfo.class);
			return RespDto.ok(userInfo);
		}
		return RespDto.error(ErrorCode.USER_NOT_EXISTS.getCode(), ErrorCode.USER_NOT_EXISTS.getMessage());
	}
	
	@Override
	public RespDto<Boolean> batchInsert1() {
		Long startTime = System.currentTimeMillis();
		List<UserEntity> list = Lists.newArrayList();
		for (int i = 2016; i < 2100; i++) {
			UserEntity userEntity = UserEntity.builder().
					createBy("system").
					updateBy("system").
					accountName("test" + i).
					realName("tt" + i).
					status(1).
					build();
			list.add(userEntity);
		}
		System.out.println("list:" + JSON.toJSONString(list));
		if (CollectionUtils.isNotEmpty(list)) {
			userDao.batchInsert(list);
		}
		System.out.println(JSON.toJSONString(list));
		Long endTime = System.currentTimeMillis();
		log.info("批量插入耗时：{}", (endTime - startTime));
		return RespDto.ok(Boolean.TRUE);
	}
	
	@Override
	public RespDto<Boolean> batchInsert2() {
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
//		List<UserEntity> list = Lists.newArrayList();
		UserDao userDao1 = sqlSession.getMapper(UserDao.class);
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < 2000; i++) {
			UserEntity userEntity = UserEntity.builder().
					createBy("system").
					updateBy("system").
					accountName("test" + i).
					realName("tt" + i).
					status(1).
					build();
//			list.add(userEntity);
			userDao1.insertSelective(userEntity);
			if (i % 1000 == 999) {//每1000条提交一次防止内存溢出
				sqlSession.commit();
				sqlSession.clearCache();
			}
		}
		
		sqlSession.commit();
		sqlSession.clearCache();


//		userDao1.batchInsert(list);
		Long endTime = System.currentTimeMillis();
		log.info("批量插入耗时：{}", (endTime - startTime));
		return RespDto.ok(Boolean.TRUE);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation =
			Isolation.DEFAULT)
	public RespDto<Boolean> traditionTest(Integer status, Integer type) {
		List<Long> ids = Lists.newArrayList();
		List<UserEntity> list = userDao.selectByStatus(1);
		for (UserEntity entity : list) {
			ids.add(entity.getId());
		}
		for (int i = 0; i < list.size(); i++) {
			ids.add(list.get(i).getId());
		}
		log.info("ids:{}", JSON.toJSONString(ids));
//		log.info("status:{}", status);
//		log.info("type{}", type);
//		String accountName = "user1";
//		UserEntity userEntity1 = userDao.selectByAccountName(accountName);
//		userDao.updateStatusById(userEntity1.getId());
//		updateUserInfo(userEntity1.getId());
//		UserEntity userEntity2 = userDao.selectById(userEntity1.getId());
////		UserEntity userEntity3 = userDao.selectById(userEntity1.getId());
////		Integer.parseInt("ss");
		Boolean flag = Boolean.FALSE;
//		if (Objects.equals(userEntity1.getStatus(), userEntity2.getStatus())) {
//			flag = Boolean.TRUE;
//		}
		return RespDto.ok(flag);
	}
	
	
	private void updateUserInfo(Long id) {
		String realName = "YJW1";
		userDao.updateRealNameById(realName, id);
//		Integer.parseInt("ss");
	}
}
