package com.loonxi.channel.LinkedIn;

import com.loonxi.channel.LinkedIn.api.OauthApiImpl;
import com.loonxi.channel.LinkedIn.api.inter.OauthApi;

/**
 * Created by xyy on 2017/1/13.
 */
public class LinkedinClientFactory {

    private String appId;
    private String appSecret;

    public LinkedinClientFactory(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public LinkedInClient getInstance(String token){
        return new LinkedInClient(token, this.appId, this.appSecret);
    }

    public OauthApi getOauApi(){
        return new OauthApiImpl(appId, appSecret);
    }

}
