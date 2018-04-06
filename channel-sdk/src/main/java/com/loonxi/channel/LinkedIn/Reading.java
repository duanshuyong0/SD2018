package com.loonxi.channel.LinkedIn;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/**
 * https://api.linkedin.com/v1/companies/13215002:(id,name,ticker,description,industry,companyType)?format=json
 *
 * Linkedin中获取数据的格式，会把字段接在资源ID后面作为地址一部分。
 *
 * 封装Linkedin的请求参数
 * Created by xyy on 2017/1/14.
 */
public class Reading {
    private StringBuilder stringBuilder = new StringBuilder();

    public Reading fields(String ... fileds){
        Arrays.stream(fileds).forEach(filed -> stringBuilder.append(filed).append(","));
        return this;
    }

    public String getQueryString(){
        //System.out.println(stringBuilder.toString());
        stringBuilder.insert(0,"(");
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.insert(stringBuilder.length(),")");
        return stringBuilder.toString();
    }
}
