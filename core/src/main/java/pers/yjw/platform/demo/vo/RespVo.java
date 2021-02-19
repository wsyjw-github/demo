package pers.yjw.platform.demo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pers.yjw.platform.demo.enmus.ResultCode;

import java.io.Serializable;


public class RespVo<T> implements Serializable {
    private String code = ResponseCode.OK.getCode();
    private String msg = "Ok";
    private T data;

    public static enum ResponseCode {
        OK("0000"),
        FAIL("9999"), //失败
        FAIL_RETRY("1000"),//失败可以重试
        LABOR("2000") //失败(人工)
        ;
        private String code;

        ResponseCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public RespVo() {
    }

    public RespVo(ResultCode resultCode) {
        this.code = resultCode.code().toString();
        this.msg  = resultCode.message();
    }

    public RespVo(ResponseCode responseCode) {
        this.code = responseCode.getCode();
    }

    public RespVo(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public RespVo(T data) {
        this.data = data;
    }

    public RespVo(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RespVo(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public RespVo<T> fail(T data) {
        this.code = ResponseCode.FAIL.code;
        this.data = data;
        this.msg = "失败";
        return this;
    }

    public RespVo<T> fail() {
        this.code = ResponseCode.FAIL.code;
        this.msg = "失败";
        return this;
    }

    public RespVo<T> ok(T data) {
        this.code = ResponseCode.OK.code;
        this.data = data;
        return this;
    }

    public RespVo<T> ok() {
        this.code = ResponseCode.OK.code;
        return this;
    }

    @JsonIgnore
    public boolean isOk() {
        return ResponseCode.OK.code.equals(this.code);
    }

    @JsonIgnore
    public boolean isFail() {
        return !ResponseCode.OK.code.equals(this.code);
    }

    public RespVo<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public RespVo<T> setCode(ResponseCode code) {
        this.code = code.getCode();
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespVo<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RespVo<T> setData(T data) {
        this.data = data;
        return this;
    }
}
