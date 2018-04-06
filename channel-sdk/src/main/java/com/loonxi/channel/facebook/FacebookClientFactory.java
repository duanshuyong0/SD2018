package com.loonxi.channel.facebook;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * a factory class for facebook
 * Created by xyy on 2017/1/5.
 */
public class FacebookClientFactory {
    private FacebookFactory facebookFactory;
    private String appId;


    /**
     *
     * @param appId
     * @param appSecret
     */
    public FacebookClientFactory(String appId, String appSecret) {
        facebook4j.conf.ConfigurationBuilder configurationBuilder = new facebook4j.conf.ConfigurationBuilder();
        configurationBuilder.setOAuthAppId(appId);
        configurationBuilder.setOAuthAppSecret(appSecret);
        FacebookFactory facebookFactory = new FacebookFactory(configurationBuilder.build());
        this.facebookFactory = facebookFactory;
        this.appId = appId;
    }

    /**
     *
     * @param appId
     * @param appSecret
     * @param proxyHost
     * @param proxyPort
     */
    public FacebookClientFactory(String appId, String appSecret, String proxyHost, int proxyPort) {
        facebook4j.conf.ConfigurationBuilder configurationBuilder = new facebook4j.conf.ConfigurationBuilder();
        configurationBuilder.setOAuthAppId(appId);
        configurationBuilder.setOAuthAppSecret(appSecret);
        configurationBuilder.setHttpProxyHost(proxyHost);
        configurationBuilder.setHttpProxyPort(proxyPort);
        FacebookFactory facebookFactory = new FacebookFactory(configurationBuilder.build());
        this.facebookFactory = facebookFactory;
        this.appId = appId;
    }

    /**
     *
     * @param token
     * @return
     */
    public FacebookClient getInstance(String token){
        Facebook facebook = facebookFactory.getInstance(new AccessToken(token, 5183752L));
        FacebookClient facebookClient = new FacebookClient(facebook);
        return facebookClient;
    }


    public String authURL(String redirectUri, String scope) throws UnsupportedEncodingException {

        redirectUri = URLEncoder.encode(redirectUri, "UTF-8");

        String loginAndauthUrl = FacebookConfig.FACEBOOK_URL + FacebookConfig.FACEBOOK_LOGIN_PREFIX;
        loginAndauthUrl = loginAndauthUrl + "?" + "client_id=" + appId + "&redirect_uri=" + redirectUri + "&scope="
                + scope + "&display=popup&auth_type=rerequest";
        return loginAndauthUrl;
    }

    /**
     * 授权url
     *
     * @author guoxubin
     * @time 下午6:13:35
     * @param redirectUri
     * @return
     * @throws UnsupportedEncodingException
     */
    public String authURL(String redirectUri) throws UnsupportedEncodingException {

        String scope = "manage_pages,email,publish_actions,publish_pages";
        return authURL(redirectUri, scope);
    }

    /**
     *
     * @describe 获取 userToken
     * @author guoxubin
     * @date 2016年10月11日
     *
     * @param code
     * @param redirectUri
     *            必须在facebook应用后台添加
     * @return
     * @throws Exception
     */
    public String getUserTokenByCode(String code, String redirectUri) throws Exception {
        AccessToken accessToken = facebookFactory.getInstance().getOAuthAccessToken(code,redirectUri);
        return accessToken.getToken();
    }


}
