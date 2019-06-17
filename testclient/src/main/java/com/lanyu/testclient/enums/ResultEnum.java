package com.lanyu.testclient.enums;

import lombok.Getter;

/**
 * Description  枚举异常类
 *
 * @Author: 朱佳明
 * Created by  朱佳明
 * Date: 2018-06-05 上午 9:38
 */
@Getter
public enum ResultEnum {
    /**
     * 枚举异常类
     */
    PARAM_ERROR(1,"参数不正确"),

    INSERT_ERROR(2,"添加出现错误"),

    UPDATE_ERROR(3,"修改出现错误"),

    LIST_ERROR(4,"获取数据出现错误"),

    PARAM_FORMAT_ERROR(5,"参数格式错误"),

    PARAM_NULL(6,"上传参数为空"),

    LOGIN_RESULT_ERROR(7,"没有该用户信息"),

    BACKEND_ERROR(8,"后端程序出现异常，请联系开发人员！"),

    POWER_ERROR(9,"您没有权限进行操作，请联系管理员！"),

    RECEIVINGADDRESS_ERROR(10,"没有查询到你的收货地址！"),

    DELETE_ERROR(11,"删除出现错误"),

    SEND_VALIDATION_FAILED(12,"发送验证失败"),

    PHONE_FORMAT_ERROR(13,"手机号码格式错误"),

    PRODUCT_STATUS_FALSE(14,"商品已下架"),

    PRODUCT_STOCK_FALSE(15,"商品库存不足"),

    UPLOAD_PICTURE_ERROR(16,"图片上传失败"),

    NO_PAY_MONEY(17,"余额不足"),

    INPUT(18,"myMessage");



    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
