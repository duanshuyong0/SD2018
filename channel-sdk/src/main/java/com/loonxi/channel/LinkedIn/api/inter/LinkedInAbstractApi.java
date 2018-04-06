package com.loonxi.channel.LinkedIn.api.inter;


import com.loonxi.channel.common.HttpClientUtil;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 14/1/17
 * @since 1.0
 */

public abstract class LinkedInAbstractApi {
    protected  String token;

    private Map<String,Object> httpHeaders = new HashMap<String,Object>();

    public LinkedInAbstractApi(String token) {
        this.token = token;
        httpHeaders.put("Authorization","Bearer "+token);
    }

    protected  Map<String,Object> getHeader(){
        return httpHeaders;
    }


}
