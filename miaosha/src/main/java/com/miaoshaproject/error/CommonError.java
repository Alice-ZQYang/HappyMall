package com.miaoshaproject.error;

import com.miaoshaproject.response.CommonReturnType;

public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);
}
