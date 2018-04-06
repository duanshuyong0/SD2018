package com.loonxi.channel.LinkedIn.modelConvertRes;

/**
 * Created by xyy on 2017/1/14.
 */
public interface ModelConvert<T> {
    T convert(String res);
}
