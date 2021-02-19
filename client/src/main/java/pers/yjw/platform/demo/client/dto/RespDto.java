package pers.yjw.platform.demo.client.dto;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpStatus;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/1/3
 * Time: 11:16 AM
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
@Setter
@Getter
public class RespDto<T> implements Serializable {
    private int code = 0;
    private String message = "success";
    private T data;

    public static RespDto ok(String msg) {
        RespDto respDto = ok();
        respDto.setMessage(msg);
        return respDto;
    }

    public static <T> RespDto<T> ok(T data) {
        RespDto respDto = new RespDto();
        respDto.setData(data);
        return respDto;
    }

    public static <T> RespDto<T> ok(int code, String message, T data) {
        RespDto r = ok(message);
        r.setCode(code);
        r.setData(data);
        return r;
    }

    public static RespDto ok() {
        return new RespDto();
    }

    public static RespDto error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static RespDto error(int code, String msg) {
        RespDto respDto = new RespDto();
        respDto.setCode(code);
        respDto.setMessage(msg);
        return respDto;
    }

    public static <T> RespDto<T> error(int code, String msg, T data) {
        RespDto respDto = error(code, msg);
        respDto.setData(data);
        return respDto;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
