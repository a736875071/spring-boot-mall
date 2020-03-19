package com.change.service;

import com.change.common.api.CommonResult;

/**
 * @author YangQ
 * @date 2020/3/19 11:13
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);

}


