package pers.yjw.platform.demo.client.service;

import pers.yjw.platform.demo.client.dto.RespDto;
import pers.yjw.platform.demo.client.dto.UserInfo;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.client.service
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-10 17:22
 */
public interface UserService {
	RespDto<UserInfo> selectByAccountName(String accountName);
	
	RespDto<Boolean> batchInsert1();
	
	RespDto<Boolean> batchInsert2();
	
	RespDto<Boolean> traditionTest(Integer status, Integer type);
}
