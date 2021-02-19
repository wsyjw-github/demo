package pers.yjw.platform.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pers.yjw.platform.demo.client.dto.RespDto;
import pers.yjw.platform.demo.client.dto.UserInfo;
import pers.yjw.platform.demo.client.service.UserService;
import pers.yjw.platform.demo.model.AdminUserDetails;
import pers.yjw.platform.demo.vo.RespVo;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName com.example.demo.web
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-09 23:14
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {
	@Resource
	private UserService userService;

	@PreAuthorize("hasAnyAuthority('CAN_SEARCH')")
	@GetMapping("/getInfo")
	public RespVo<UserInfo> getUserInfo(String accountName) {
		AdminUserDetails adminUserDetails =
				(AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		log.info("adminUserDetails: {}", adminUserDetails);
		RespDto<UserInfo> respDto = userService.selectByAccountName(accountName);
		if (Objects.equals("0", respDto.getCode())) {
			return new RespVo<UserInfo>().setData(respDto.getData());
		}
		return new RespVo<UserInfo>().setCode(String.valueOf(respDto.getCode())).setData(respDto.getData());
	}

	@GetMapping("/insert1")
	@ResponseBody
	public RespVo<Boolean> insertBatch1() {
		RespDto<Boolean> respDto = userService.batchInsert1();
		if (Objects.equals("0", respDto.getCode())) {
			return new RespVo<Boolean>().setData(respDto.getData());
		}
		return new RespVo<Boolean>().setCode(String.valueOf(respDto.getCode())).setData(respDto.getData());
	}

	@GetMapping("/insert2")
	@ResponseBody
	public RespVo<Boolean> insertBatch() {
		RespDto<Boolean> respDto = userService.batchInsert2();
		if (Objects.equals("0", respDto.getCode())) {
			return new RespVo<Boolean>().setData(respDto.getData());
		}
		return new RespVo<Boolean>().setCode(String.valueOf(respDto.getCode())).setData(respDto.getData());
	}
	
		@GetMapping("/tradition/test")
	@ResponseBody
	public RespVo<Boolean> traditionTest(Integer status, Integer type) {
		RespDto<Boolean> respDto = userService.traditionTest(status, type);
		if (Objects.equals("0", respDto.getCode())) {
			return new RespVo<Boolean>().setData(respDto.getData());
		}
		return new RespVo<Boolean>().setCode(String.valueOf(respDto.getCode())).setData(respDto.getData());
	}

}
