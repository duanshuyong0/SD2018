package com.loonxi.channel.facebook.api;

import com.loonxi.channel.facebook.model.FacebookUserProfile;
import facebook4j.FacebookException;

/**
 * Created by xyy on 2017/1/5.
 */
public interface UserApi {
    /**
     * 获取用户详情
     * 在绑定的时候使用
     * @return
     * @throws Exception
     */
    FacebookUserProfile getProfile() throws Exception;

    boolean removeFacebookAuth(String facebookUserId) throws FacebookException;
}
