package pers.yjw.platform.demo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @projectName vint
 * @version: 1.0
 * @packageName cn.tongdun.ai.platform.vint.model.dto
 * @description:
 * @author: YaoJianwei
 * @create: 2019-04-09 16:51
 */
@Data
public class PartnerModify2Dto implements Serializable {

    /**
     * 合作方标识
     */
    private String partnerCode = "DyyTest";

    /**
     * 合作方状态
     */
    private Integer status = 1;

}
