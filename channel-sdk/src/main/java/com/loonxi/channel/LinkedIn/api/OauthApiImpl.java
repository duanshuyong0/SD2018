package com.loonxi.channel.LinkedIn.api;

import com.google.gson.Gson;
import com.loonxi.channel.LinkedIn.LinkedinConfig;
import com.loonxi.channel.LinkedIn.api.inter.LinkedInAbstractApi;
import com.loonxi.channel.LinkedIn.api.inter.OauthApi;
import com.loonxi.channel.common.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 14/1/17
 * @since 1.0
 */

public class OauthApiImpl  implements OauthApi {

    private String client_secret;
    private String client_id;

    public OauthApiImpl(String client_id, String client_secret) {
        this.client_secret = client_secret;
        this.client_id = client_id;
    }

    @Override
    public String authUrl(String state, String redirect_uri) {
        String url = LinkedinConfig.AUTH_HOST + "authorization"+
                "?response_type=code" +
                "&redirect_uri=" +redirect_uri +
                "&client_id=" + client_id +
                "&scope=r_basicprofile,r_emailaddress,rw_company_admin,w_share" +
                "&state=" + state;
        return url;
    }

    @Override
    public String fetchAccessToken(String code, String redirect_uri) throws Exception {
        String apiUrl = LinkedinConfig.AUTH_HOST + "accessToken";
        Map<String, Object> params = new HashMap<>();
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        params.put("client_id", client_id);
        params.put("client_secret", client_secret);
        params.put("redirect_uri",redirect_uri);

        String result = HttpClientUtil.httpPostRequest(apiUrl, params);
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(result, Map.class);
        if(null == map.get("access_token")){
            throw new Exception(result);
        }
        return map.get("access_token").toString();
    }
}
