package com.example.heart.imagehosting.utils;

import com.example.heart.imagehosting.common.SysConstants;
import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.domain.SysResponse;
import com.example.heart.imagehosting.sdk.smms.response.SmmsBaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: SysResponseUtils
 * @Description: 系统级响应工具类
 * @Author: jayhe
 * @Date: 2019/12/30 17:13
 * @Version: v1.0
 */
public class SysResponseUtils {

    public static final Logger logger = LoggerFactory.getLogger(SysResponseUtils.class);

    public static SysResponse success() {
        return success(null);
    }

    public static SysResponse success(Object object) {
        SysResponse sysResponse = new SysResponse();
        sysResponse.setState(SysConstants.STATE_SUCCESS);
        sysResponse.setErrCode(SysErrorCode.SUCCESS.getCode());
        sysResponse.setErrMessage(SysErrorCode.SUCCESS.getMsg());
        sysResponse.setData(object);
        return sysResponse;
    }

    public static SysResponse success(Integer code, String msg) {
        SysResponse sysResponse = new SysResponse();
        sysResponse.setState(SysConstants.STATE_SUCCESS);
        sysResponse.setErrCode(code);
        sysResponse.setErrMessage(msg);
        return sysResponse;
    }

    public static SysResponse success(Integer code, String msg, Object data) {
        SysResponse sysResponse = new SysResponse();
        sysResponse.setState(SysConstants.STATE_SUCCESS);
        sysResponse.setErrCode(code);
        sysResponse.setErrMessage(msg);
        sysResponse.setData(data);
        return sysResponse;
    }

    public static SysResponse fail(Integer code, String msg) {
        return fail(code, msg, null);
    }

    public static SysResponse fail(Integer code, String msg, Object object) {
        SysResponse sysResponse = new SysResponse();
        sysResponse.setState(SysConstants.STATE_FAIL);
        sysResponse.setErrCode(code);
        sysResponse.setErrMessage(msg);
        sysResponse.setData(object);
        return sysResponse;
    }

    public static SysResponse convertSmmsResponse(SmmsBaseResponse smmsBaseResponse) {
        SysResponse sysResponse = new SysResponse();
        sysResponse.setState(smmsBaseResponse.isSuccess() ? SysConstants.STATE_SUCCESS : SysConstants.STATE_FAIL);
        sysResponse.setErrMessage(smmsBaseResponse.getMessage());
        sysResponse.setData(smmsBaseResponse.getData());
        return sysResponse;
    }
}
