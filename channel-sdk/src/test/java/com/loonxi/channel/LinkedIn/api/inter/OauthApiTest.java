package com.loonxi.channel.LinkedIn.api.inter;

import com.loonxi.channel.LinkedIn.LinkedInClient;
import com.loonxi.channel.LinkedIn.LinkedinClientFactory;
import com.loonxi.channel.LinkedIn.api.XyyLinkedinCredentials;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xyy on 2017/1/16.
 */
public class OauthApiTest {
    OauthApi oauthApi =
            new LinkedinClientFactory(XyyLinkedinCredentials.app_id, XyyLinkedinCredentials.app_secrect).
                    getOauApi();

    private String redirect_url = "http://localhost:8080/linkin/oauth/callback";

    @Test
    public void authUrl() throws Exception {
        System.out.println(oauthApi.authUrl("asdf",redirect_url));
    }

    @Test
    public void fetchAccessToken() throws Exception {

        String code = "AQQyCPI97bk3gW-Nx8jmE8AZLtNyOr6EjOF-kcJIwSvbY7eHczM-pyC3mPYboK7VA8hvrGmXrsJSmsL0Xf06SOC_U1H5TioYpz-H0p-dQQWdkMfKxJE";

        //String code = "AQQgNADflEGgNMBjE660B3Zc0yOV0KoDwgw4t_FXcV4AkoB9KNEFsjLyOEt4lN8DPQtlAq0dkM3K6ErlNyPjUKz7X3immTJvSN-pYNB84M-DHbT6nJk";
        System.out.println(oauthApi.fetchAccessToken(code, redirect_url));
    }

}