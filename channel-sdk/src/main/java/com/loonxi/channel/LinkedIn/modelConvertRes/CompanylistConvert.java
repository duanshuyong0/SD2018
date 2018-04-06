package com.loonxi.channel.LinkedIn.modelConvertRes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.loonxi.channel.LinkedIn.model.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyy on 2017/1/17.
 *
 *
 {
 "_total": 2,
 "values":  [
 {
 "id": 13247844,
 "name": "严式炒饭研究所"
 },
 {
 "id": 13215002,
 "name": "Hangzhou AliLong cor.,Ltd"
 }
 ]
 }
 *
 */
public class CompanylistConvert implements ModelConvert<List<Company>> {
    @Override
    public List<Company> convert(String res) {

        JSONObject object = JSON.parseObject(res);
        //这一步是没有转的，object.get("values")对象还是没有转成的这个 List<Company> 对象的
        //List<Company> companies = (List<Company>) object.get("values");
        List<JSONObject> jsonObject1 = (List<JSONObject>) object.get("values");
        List<Company> companies = new ArrayList<>();
        jsonObject1.stream().forEach(e->companies.add(new CompanyConvert().convert(e.toJSONString())));
        return companies;
    }
}
