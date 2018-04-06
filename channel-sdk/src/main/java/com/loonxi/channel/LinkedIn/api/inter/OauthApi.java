package com.loonxi.channel.LinkedIn.api.inter;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 14/1/17
 * @since 1.0
 */

public interface OauthApi {
    String authUrl(String state, String redirect_uri);

    String fetchAccessToken(String code, String redirect_uri) throws Exception;
}