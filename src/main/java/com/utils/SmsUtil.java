package com.utils;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.BizResult;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import net.sf.json.JSONObject;

/**
 * Created by lenovo on 2016/11/23.
 */
public class SmsUtil {

    //(水滴数据)
    private static String url = "http://gw.api.taobao.com/router/rest";//固定的
    private static String appkey = "23566826";//根据app变动
    private static String secret = "6630ec1fdbccb94f8b513ef88974d8c7";//根据app变动

    public static String sendSms(String phoneNum, String smsTemplateCode, String smsParamString) throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("");//固定点
        req.setSmsType("normal");//固定的
        req.setSmsFreeSignName("水滴数据");//根据app变动
        req.setSmsParamString(smsParamString);
        req.setRecNum(phoneNum);
        req.setSmsTemplateCode(smsTemplateCode);
        AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
        String body = rsp.getBody();
        return body;
    }

    public static void main(String[] args) throws ApiException {
        String phoneNum = "15039265796";//传入手机号
        String smsTemplateCode = "SMS_33815250";//变动的
        String code = StringUtil.getSixRandom();
        JSONObject param = new JSONObject();
        param.put("code", code);//变动的
        param.put("name", phoneNum);//变动的
        String paramString = param.toString();
        String s = SmsUtil.sendSms(phoneNum, smsTemplateCode, paramString);
    }
}
