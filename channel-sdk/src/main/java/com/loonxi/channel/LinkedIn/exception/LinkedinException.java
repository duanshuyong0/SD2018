package com.loonxi.channel.LinkedIn.exception;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by xyy on 2017/1/17.
 * 访问Linkedin出错的异常
 */
public class LinkedinException extends Exception {
    public LinkedinException(String message) {
        super(message);
    }

    /**
     * 如果错误就直接抛出异常
     * @param result
     */
    public static void checkLinkedinError(String result) throws LinkedinException {
        JSONObject object = JSONObject.parseObject(result);
        if(object.size()==5 && object.containsKey("errorCode") && object.containsKey("requestId")){
            throw new LinkedinException("访问Linkedin接口出错"  + result);
        }
    }
}
