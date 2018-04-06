package com.loonxi.channel.LinkedIn.api.inter;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.LinkedIn.LinkedInClient;
import com.loonxi.channel.LinkedIn.LinkedinClientFactory;
import com.loonxi.channel.LinkedIn.api.XyyLinkedinCredentials;
import com.loonxi.channel.LinkedIn.model.Company;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xyy on 2017/1/16.
 */
public class CompanyApiTest {
    LinkedInClient client =
            new LinkedinClientFactory(XyyLinkedinCredentials.app_id, XyyLinkedinCredentials.app_secrect).
                    getInstance(XyyLinkedinCredentials.token);

    @Test
    public void listCompanies() throws Exception {
        CompanyApi companyApi = client.getCompanyApi();
        List<Company> companyList = companyApi.listCompanies();
        System.out.println(JSON.toJSON(companyList));
    }

    @Test
    public void get() throws Exception {
        CompanyApi companyApi = client.getCompanyApi();
        System.out.println(JSON.toJSON(companyApi.get("13247844")));
    }

}