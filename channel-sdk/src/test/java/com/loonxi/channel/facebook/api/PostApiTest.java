package com.loonxi.channel.facebook.api;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.SslUtils;
import com.loonxi.channel.facebook.*;
import com.loonxi.channel.facebook.model.FBPageQuery;
import com.loonxi.channel.facebook.model.FBPaging;
import com.loonxi.channel.facebook.model.FBPost;
import com.loonxi.channel.facebook.model.FBbaseProfile;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by xyy on 2017/1/6.
 */
public class PostApiTest {
    private static PostApi postApi;

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
        postApi = facebookClient.getPostApi();
    }


    /**
     * 448178982058476 tie
     *
     * @throws Exception
     */
    @Test
    public void createPost() throws Exception {
        String pageId = "1133083050066887";
        String message = "hehe asdf";
        System.out.println(postApi.createPost(pageId, message));
    }

    @Test
    public void deletePost() throws Exception {
        String postId = "1133083050066887_1369158553126001";
        postApi.delete(postId);
    }


    /**
     * 带图片的很多回复和评论的帖子
     1133083050066887_1367145513327305

     引用的帖子
     448178982058476_531381100404930
     * @throws Exception
     */
    @Test
    public void getPost() throws Exception {
        String postId = "1133083050066887_1367145513327305";
        FBPost post = postApi.getPost(postId);
        System.out.println(JSON.toJSON(post));
    }

    @Test
    public void getPageTermline() throws Exception {
        String postId = "1133083050066887";
        FBPageQuery query = new FBPageQuery();
        query.setSize(20);
        FBPaging<FBPost> posts = postApi.pageTimeline(postId,query);
        System.out.println(JSON.toJSON(posts));
    }

    @Test
    public void searchTest() throws Exception{
        System.out.println(postApi.search("ss", null));
    }


    @Test
    public void like() throws Exception {
        String postId = "1133083050066887_1369209879787535";
        postApi.like(postId);
    }

    @Test
    public void unlike() throws Exception {
        String postId = "1133083050066887_1369209879787535";
        postApi.unlike(postId);
    }

    @Test
    public void likes() throws Exception {
        String postId = "1133083050066887_1369209879787535";
        List<FBbaseProfile> list = postApi.likes(postId);
        System.out.println(JSON.toJSON(list));
    }



}