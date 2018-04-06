package com.loonxi.channel.LinkedIn;

import com.google.gson.Gson;
import com.loonxi.channel.LinkedIn.api.CompanyApiImpl;
import com.loonxi.channel.LinkedIn.api.OauthApiImpl;
import com.loonxi.channel.LinkedIn.api.ShareApiImpl;
import com.loonxi.channel.LinkedIn.api.inter.CompanyApi;
import com.loonxi.channel.LinkedIn.api.inter.OauthApi;
import com.loonxi.channel.LinkedIn.api.inter.ShareApi;
import com.loonxi.channel.LinkedIn.model.*;
import com.loonxi.channel.common.HttpClientUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * LinkedIn客户端
 *
 * <pre>
 * Pattern : Value Object
 * Thread Safe : No
 *
 * Change History
 *
 * Name                 Date                    Description
 * -------              -------                 -----------------
 * Banma              2016-12-08            Create the class
 *
 * </pre>
 *
 * @author Banma
 * @version 1.0
 */
public class LinkedInClient{

    private String clientId;

    private String clientSecret;

    private String token;

    private ShareApi shareApi;

    private OauthApi oauthApi;


    private  LinkedInClient(String client_id, String client_secret) {
        this.clientId = client_id;
        this.clientSecret = client_secret;
    }

    LinkedInClient(String token, String clientId, String clientSecret){
        this.token = token;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }


    public OauthApi getOauthApi() {
        return new OauthApiImpl(clientId, clientSecret);
    }

    public ShareApi getShareApi() {
        return new ShareApiImpl(token);
    }

    public CompanyApi getCompanyApi(){
        return new CompanyApiImpl(token);
    }



    /**
     * 获取 用户信息
     * @param accessToken
     * the api result like this
     *   /**
     * 用户信息返回样例
     * {
        "emailAddress": "voellin@gmail.com",
        "firstName": "Lin",
        "headline": "Product Manager at DJ",
        "id": "H21_YwAnmb",
        "lastName": "Wang",
        "pictureUrl": "https://media.licdn.com/mpr/mprx/0_ukJ1600C429FV8ezu8x26gV24w-b4iezm_Du6y4rFm6nFbxvhCd0epuO9LtMUXWJSbRDdR6_vSYD"
        }
     * @return
     * @throws Exception
     */
    public LinkedInUserProfile userProfile(String accessToken) throws Exception{
        String apiUrl = LinkedinConfig.AUTH_HOST + "people/~:(id,first-name,last-name,headline,picture-url,email-address)";

        Map<String,Object> header = new HashMap<String,Object>();
        header.put("Authorization", "Bearer "+accessToken);
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("format","json");
        String result = HttpClientUtil.httpGetRequest(apiUrl,header,params);
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(result, Map.class);

        Object firstName = map.get("firstName");
        Object lastName = map.get("lastName");
        Object emailAddrss = map.get("emailAddress");
        Object headLine = map.get("headline");
        Object id = map.get("id");
        Object pictureUrl = map.get("pictureUrl");
        LinkedInUserProfile userProfile = new LinkedInUserProfile();
        if(firstName != null){
            userProfile.setFirstName((String)firstName);
            String username = map.get("firstName") + " " + map.get("lastName");
            userProfile.setUserName(username);
        }
        if(lastName != null){
            userProfile.setFirstName((String)lastName);
        }
        if(emailAddrss != null){
            userProfile.setEmailAddress((String)emailAddrss);
        }
        if(headLine != null){
            userProfile.setHeadLine((String)headLine);
        }
        if(id != null){
            userProfile.setId((String)id);
        }
        if(pictureUrl != null){
            userProfile.setPictureUrl((String)pictureUrl);
        }
        return userProfile;

    }




    /**
     * 返回用户管理的公司列表页
     * @param accessToken
     * @return
     * @throws Exception
     */
    public List<CompanyListResponse> getCompanyPageList(String accessToken) throws  Exception{
        String apiUrl= LinkedinConfig.AUTH_HOST + "companies:(id,name,logo-url)";
        Map<String,Object> header = new HashMap<String,Object>();
        header.put("Authorization", "Bearer "+accessToken);
        Map<String,Object> params = new HashMap<>();
        params.put("format","json");
        params.put("is-company-admin",Boolean.TRUE);

        String result =  HttpClientUtil.httpGetRequest(apiUrl,header,params);

        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(result, Map.class);
        List<Map<String,String>> valueMap = (List<Map<String,String>>)map.get("values");

        List<CompanyListResponse> companyListResponses = new ArrayList<>();

        if(valueMap != null) {
            valueMap.forEach(value -> {
                CompanyListResponse companyListResponse = new CompanyListResponse();
                companyListResponse.setId(new BigDecimal(String.valueOf(value.get("id"))).toPlainString());
                companyListResponse.setLogUrl(value.get("logoUrl"));
                companyListResponse.setName(value.get("name"));
                companyListResponses.add(companyListResponse);
            });
        }
        return companyListResponses;
    }




}
