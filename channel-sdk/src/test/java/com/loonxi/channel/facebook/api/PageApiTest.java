package com.loonxi.channel.facebook.api;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.SslUtils;
import com.loonxi.channel.facebook.FacebookClient;
import com.loonxi.channel.facebook.FacebookClientFactory;
import com.loonxi.channel.facebook.XyyCredential;
import com.loonxi.channel.facebook.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by xyy on 2017/1/7.
 */
public class PageApiTest {

    private static PageApi pageApi;

    @Before
    public void before() throws Exception {
        SslUtils.ignoreSsl();
    }

    static {
        FacebookClientFactory factory = new FacebookClientFactory(XyyCredential.appId,XyyCredential.appSecret);
        //个人的身份
        FacebookClient facebookClient = factory.getInstance(XyyCredential.accessToken);


        //主页的身份 1133083050066887
        //FacebookClient facebookClient = factory.getInstance(XyyCredentialPageCycle.accessToken);
        pageApi = facebookClient.getPageApi();
    }

    @Test
    public void getPageList() throws Exception {
        List<Homepage>  homepages = pageApi.getPageList("208809049544668");
        System.out.println(JSON.toJSON(homepages));
    }

    @Test
    public void getPage() throws Exception {
        String pageId = "1133083050066887";
        FBPage FBPage = pageApi.getPage(pageId);
        System.out.println(JSON.toJSON(FBPage));
    }

    @Test
    public void searchPage() throws Exception {
        FBPageQuery query = new FBPageQuery();
        query.setSize(10);
        //query.setFbCursorMode(new FBCursorMode("OQZDZD", FBCursorDirection.AFTER));
        FBPaging<FBPage> fbPaging = pageApi.searchPage("chengzixi0113",query);
        System.out.println(JSON.toJSON(fbPaging));
    }


}