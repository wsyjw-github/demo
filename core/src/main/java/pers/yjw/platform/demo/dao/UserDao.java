package pers.yjw.platform.demo.dao;

import org.apache.ibatis.annotations.Param;
import pers.yjw.platform.demo.po.UserEntity;

import java.util.List;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.dao
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-10 15:12
 */
public interface UserDao {
	UserEntity selectByAccountName(String accountName);
	
	UserEntity selectById(Long id);
	
	int batchInsert(@Param("list") List<UserEntity> list);
	
	int insertSelective(UserEntity userEntity);
	
	int updateStatusById(@Param("id") Long id);
	
	int updateRealNameById(@Param("realName") String realName, @Param("id")Long id);
	
	List<UserEntity> selectByStatus(Integer status);
}
