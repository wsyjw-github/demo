package pers.yjw.platform.demo.client.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.client.dto
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-11 17:09
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Model implements Serializable {
}

