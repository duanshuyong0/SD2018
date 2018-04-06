package com.loonxi.channel.LinkedIn.api;

import com.loonxi.channel.LinkedIn.LinkedinConfig;
import com.loonxi.channel.LinkedIn.Reading;
import com.loonxi.channel.LinkedIn.api.inter.CompanyApi;
import com.loonxi.channel.LinkedIn.api.inter.LinkedInAbstractApi;
import com.loonxi.channel.LinkedIn.exception.LinkedinException;
import com.loonxi.channel.LinkedIn.model.Company;
import com.loonxi.channel.LinkedIn.modelConvertRes.CompanyConvert;
import com.loonxi.channel.LinkedIn.modelConvertRes.CompanylistConvert;
import com.loonxi.channel.common.HttpClientUtil;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xyy on 2017/1/13.
 */
public class CompanyApiImpl  extends LinkedInAbstractApi implements CompanyApi {
    private static Reading reading = new Reading();;
    static {
        reading.fields("id","name","universal-name");
        reading.fields("logo-url");
        reading.fields("company-type");//公司类型
        reading.fields("ticker");//股票代码
        reading.fields("website-url");//网站
        reading.fields("industries");//
        reading.fields("locations");
        reading.fields("foundedYear");//成立年
        reading.fields("employee-count-range");
        reading.fields("specialties");
    }

    public CompanyApiImpl(String token) {
        super(token);
    }

    @Override
    public List<Company> listCompanies() throws LinkedinException {
        String apiUrl= LinkedinConfig.API_HOST + "companies:" + reading.getQueryString();
        Map<String,Object> header = new HashMap<>();
        header.put("Authorization", "Bearer "+ token);
        Map<String,Object> params = new HashMap<>();
        params.put("format","json");
        params.put("is-company-admin",Boolean.TRUE);

        String result = null;
        try {
            result = HttpClientUtil.httpGetRequest(apiUrl,header,params);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //判断是否返回正确结果
        LinkedinException.checkLinkedinError(result);

        List<Company> companies = new CompanylistConvert().convert(result);
        return companies;
    }

    @Override
    public Company get(String companyId) throws LinkedinException {
        String apiUrl= LinkedinConfig.API_HOST + "companies/" + companyId + ":" + reading.getQueryString();
        Map<String,Object> header = new HashMap<>();
        header.put("Authorization", "Bearer "+ token);
        Map<String,Object> params = new HashMap<>();
        params.put("format","json");
        params.put("is-company-admin",Boolean.TRUE);
        String result = null;
        try {
            result = HttpClientUtil.httpGetRequest(apiUrl,header,params);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //判断是否返回正确结果
        LinkedinException.checkLinkedinError(result);
        Company company = new CompanyConvert().convert(result);
        return company;
    }
}
