package com.loonxi.channel.LinkedIn.modelConvertRes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.loonxi.channel.LinkedIn.model.Company;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by xyy on 2017/1/14.
 */
public class CompanyConvert implements ModelConvert<Company>{

    @Override
    public Company convert(String res) {
        JSONObject object = JSON.parseObject(res);
        Company company = new Company();



       /* if(object.get("companyType")!=null){
            JSONObject companyType = (JSONObject)object.get("companyType");
            company.setCompanyType(new CodeAndName((String) companyType.get("code"),(String) companyType.get("name")));
        }

        if(object.get("websiteUrl")!=null){
            company.setWebsiteUrl((String) object.get("websiteUrl"));
        }*/

        try {
            company = JSONConvert.convert(object, Company.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return company;
    }


}
