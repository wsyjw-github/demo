package pers.yjw.platform.demo.exception;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/1/4
 * Time: 1:31 PM
 * Description: 错误CODE
 *
 * @author zhoujunwen
 * @version 1.0
 */
public enum ErrorCode {
    SUCCESS(0, "成功"),

    // 参数
    PARAM_MISS(1000, "参数缺失"),
    PARAM_ERROR(1001, "参数错误"),
    PARAM_FORMAT_ERROR(1002, "参数格式错误"),
    EMAIL_ERROR(1004, "账号邮箱错误"),
    EMAIL_EMPTY(1005, "邮箱为空"),
    UNKOWN_ERROR(1008, "未知异常，请联系管理员"),
    REPEAT_DATA(1009, "重复插入，请确认"),
    DATABASE_ERROR(1010, "数据库操作异常"),

    // 1100 用户
    USER_ADD_FAIL(1100, "创建用户失败"),
    SEND_EMAIL_FAIL(1101, "发送邮件失败"),
    USER_NOT_EXISTS(1102, "用户不存在"),
    USER_STATUS_ERROR(1103, "用户状态非关闭状态，删除用户失败"),
    USER_GENERATE_PASSWORD_ERROR(1104, "生成用户密码失败"),
    USER_DELETE_FAIL(1105, "删除用户失败"),
    USER_MODIFY_STATUS_ERROR(1106, "修改用户状态失败"),
    ACCOUNT_PASSWORD_EMPTY(1107, "账号或密码为空"),
    ACCOUNT_PASSWORD_ERROR(1108, "账号或密码错误"),
    USER_STATUS_NOT_AVAILABLE(1109, "用户状态不可用"),
    USER_ACCOUNT_EXISTS(1110, "用户账号已存在"),
    USER_ROLE_SAVE_ERROR(1111, "用户角色保存错误"),
    USER_DELETE_FAIL_NOT_EXIST(1112, "删除用户失败，不存在该用户"),
    USER_DELETE_FAIL_NOT_ALLOW_DELETE_SELF(1113, "删除用户失败，不能删除当前用户"),
    USER_DELETE_FAIL_CANNOT_DELETE_SUPER_ADMIN(1114, "删除用户失败，不能删除预置超级管理员"),
    USER_MODIFY_FAIL_NOT_ALLOW_MODIFY_SELF(1115, "编辑用户失败，不能编辑当前用户"),
    USER_MODIFY_FAIL_CANNOT_MODIFY_SUPER_ADMIN(1116, "编辑用户失败，不能编辑预置超级管理员"),
    USER_PWD_SIGN_DECRYPT_ERROR(1117, "用户重置密码失败，密码签名解密失败"),
    USER_REVIEW_TYPE_EXISTS(1118, "用户已通过审核，无法进行审批操作"),
    USER_INOPER_EXISTS(1119, "合作方用户在OPER中已存在"),
    QUERY_OPER_USER_FAIL(1120, "获取Oper用户失败"),
    USER_REVIEW_STATUS_NOT_EXISTS(1121, "合作方用户审核状态不存在"),
    USER_REVIEW_FAIL(1122, "合作方用户审核失败"),
    OPER_REGISTER_USER_FAIL(1123, "向Oper中注册合作方用户失败"),
    USER_ID_EMPTY(1124, "合作方用户ID不能为空"),
    USER_EMAIL_EMPTY(1125, "用户email为空"),
    USER_COUNTRY_CODE_EMPTY(1126, "用户国家码为空"),
    USER_MOBILE_EMPTY(1127, "用户手机号为空"),
    USER_REAL_NAME_EMPTY(1128, "用户姓名为空"),
    USER_STATUS_EXCEPTION(1129, "用户状态异常"),
    USER_AUDIT_REASON_EMPTY(1130, "用户审核原因不能为空"),
    UER_QUERY_IN_OPER_EXCEPTION(1131, "OPER查询合作方用户账户服务异常"),
    UER_REGISTER_IN_OPER_EXCEPTION(1132, "OPER注册合作方用户服务异常"),
    USER_EMAIL_ENDWITH_ERROR(1133,"邮箱后缀为@fraudmetrix.cn或@tongdun.cn或@tongdun.net,则不允许建为用户账户"),
    // 1200 合作方
    PARTNER_INFO_EMPTY(1200, "合作方信息不能为空"),
    PARTNER_CODE_EMPTY(1201, "合作方标识不能为空"),
    PARTNER_NAME_EMPTY(1202, "合作方名称不能为空"),
    PARTNER_TYPE_EMPTY(1203, "合作方类型不能为空"),
    PARTNER_STATUS_EMPTY(1204, "合作方状态不能为空"),
    PARTNER_INFO_NOTEXISTS(1205, "合作方信息不存在"),
    PARTNER_INFO_EXISTS(1206, "合作方信息已存在"),
    PARTNER_STATUS_ACTIVE(1207, "合作方状态未禁用，不能删除"),
    PARTNER_TYPE_NOT_CORRECT(1208, "合作方类型不正确"),
    PARTNER_STATUS_NOT_CORRECT(1209, "合作方状态不正确"),
    PARTNER_NOT_EXIST(1210, "合作方不存在"),
    PARTNER_ENDTIME_NOT_CORRECT(1211, "合作方截止时间应大于当前时间"),
    PARTNER_IN_OPER_NOT_EXIST(1212, "OPER中合作方不存在,请确认运营系统已添加合作方信息"),
    PARTNER_NOT_EXIST_HERE(1213, "账户所属合作方不存在，请新建合作方"),
    PARTNER_QUERY_IN_OPER_EXCEPTION(1214, "OPER查询合作方标识服务异常"),
    // 1300 角色
    ROLE_NOT_EXISTS(1300, "选择的角色不存在"),
    ROLE_ADD_FAIL(1301, "新建角色失败"),
    ROLE_DELETE_FAIL(1302, "删除角色失败"),
    ROLE_EDIT_FAIL(1304, "编辑角色失败"),
    ROLE_DELETE_FAIL_RELATED_USER(1305, "删除角色失败，该角色有关联的用户"),
    ROLE_MODIFY_FAIL_CANNOT_MODIFY_SUPER_ROLE(1306, "编辑角色失败，不能编辑预置超级管理员角色"),
    ROLE_DELETE_FAIL_CANNOT_DELETE_SUPER_ROLE(1307, "删除角色失败，不能删除预置超级管理员角色"),
    ROLE_MODIFY_FAIL_CANNOT_MODIFY_SELF_ROLE(1308, "编辑角色失败，不能编辑当前用户所属角色"),
    ROLE_NAME_EXISTS(1309, "角色名已存在"),
    ROLE_NAME_TOLONG(1310, "角色名不能超过20个字符"),
    ROLE_ALREADY_BINGED_USER(1311, "角色已绑定用户，无法删除"),

    PARTNER_MENU_NOT_EXISTS(1400, "菜单资源不存在"),
    MENU_NOT_EXISTS(1401, "菜单不存在"),
    PARTNER_MENU_SAVE_FAIL(1402, "保存菜单失败"),
    PARTNER_MENU_DELETE_FAIL(1404, "删除菜单失败"),
    PARENT_MENU_ERROR(1405, "父菜单不能是当前菜单的子菜单"),
    MENU_TYPE_PARENT_ERROR(1406, "菜单类型和父菜单关联错误"),
    MENU_NAME_EXISTS(1407, "菜单名已存在"),

    PARTNER_END_TIME(1500, "合作方合同已到期"),
    PARTNER_ENDIME_INVALID(1501, "合作方合同已到期"),
    USER_STATUS_INACTIVE(1502, "用户状态已关闭"),
    PARTNER_STATUS_INACTIVE(1502, "合作方状态已关闭"),

    //1600 运营用户
    OPERATOR_ACCOUNT_EXISTS(1601, "运营用户账号已存在"),
    OPERATOR_ACCOUNT_EMPTY(1602, "运营用户账号为空"),
    OPERATOR_ID_EMPTY(1603, "运营用户ID为空"),
    OPERATOR_STATUS_EMPTY(1604, "运营用户状态为空"),
    OPERATOR_MODIFY_STATUS_ERROR(1605, "修改运营用户状态失败"),
    OPERATOR_DELETE_STATUS_ACTIVE_ERROR(1606, "运营用户状态非关闭状态，删除运营用户失败"),
    OPERATOR_PARTNER_ERROR(1607, "运营用户分配合作方失败"),
    OPERATOR_STATUS_ERROR(1608, "运营用户状态错误"),
    OPERATOR_ACCOUNT_NOT_EXISTS(1609, "运营用户账号不存在"),
    OPERATOR_EHR_ACCOUNT_NOT_EXISTS(1610, "运营账户不存在。请确认已开通该用户账户"),
    OPERATOR_NOT_EXISTS(1611, "运营用户不存在"),

    OPERATOR_PARTNER_ADD_FAIL(1701, "新增合作方与运营关联关系失败"),
    OPERATOR_ROLE_NOT_EXISTS(1702, "运营账户没有关联角色"),
    ;

    @Getter
    private int code;
    @Getter
    private String message;
    @Getter
    private String des = null;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public String toString() {
        if (null == des) {
            String codeStr = String.valueOf(code);
            int capacity = codeStr.length() + message.length() + 5;
            des = new StringBuilder(capacity).append(codeStr).append(", ").append(message).toString();
        }
        return des;
    }
}
