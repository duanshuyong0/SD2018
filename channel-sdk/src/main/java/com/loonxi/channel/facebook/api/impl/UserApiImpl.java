package com.loonxi.channel.facebook.api.impl;

import com.google.gson.Gson;
import com.loonxi.channel.common.HttpClientUtil;
import com.loonxi.channel.facebook.FacebookConfig;
import com.loonxi.channel.facebook.api.UserApi;
import com.loonxi.channel.facebook.model.FacebookUserProfile;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.User;

import java.util.Map;

/**
 * Created by xyy on 2017/1/5.
 */
public class UserApiImpl implements UserApi {
    private Facebook facebook;

    public UserApiImpl(Facebook facebook) {
        this.facebook = facebook;
    }

    @Override
    public FacebookUserProfile getProfile() throws Exception {
        User user = facebook.getMe();
        FacebookUserProfile profile = new FacebookUserProfile();
        profile.setAccountId(user.getId());
        String attarUrl = FacebookConfig.FACEBOOK_API_URL + "/" + user.getId() + "/picture";
        profile.setAvatar(attarUrl);
        profile.setEmail(user.getEmail());
        profile.setName(user.getName());
        profile.setToken(facebook.getOAuthAccessToken().getToken());
        return profile;
    }

    @Override
    public boolean removeFacebookAuth(String facebookUserId) throws FacebookException {
        try {
            removeFacebookAuth(facebook.getOAuthAccessToken().getToken(),facebookUserId);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     *
     * @describe 解除授权
     * @author guoxubin
     * @date 2016年10月11日
     *
     * @param userToken
     * @param facebookUserId
     * @return
     * @throws Exception
     */
    public boolean removeFacebookAuth(String userToken, String facebookUserId) throws Exception {
        String url = FacebookConfig.FACEBOOK_API_URL + "/" + facebookUserId + "/permissions?access_token=" + userToken;
        String result = HttpClientUtil.httpDeleteRequest(url);
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(result, Map.class);
        if (null != map.get("success")) {

            return (Boolean) map.get("success");
        }
        throw new Exception(result);
    }
}
