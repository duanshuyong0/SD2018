package com.loonxi.channel.facebook.api;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.SslUtils;
import com.loonxi.channel.facebook.FacebookClient;
import com.loonxi.channel.facebook.FacebookClientFactory;
import com.loonxi.channel.facebook.XyyCredential;
import com.loonxi.channel.facebook.XyyCredentialPageCycle;
import com.loonxi.channel.facebook.model.FBComment;
import com.loonxi.channel.facebook.model.FBPaging;
import facebook4j.Comment;
import facebook4j.ResponseList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xyy on 2017/1/6.
 */
public class CommentApiTest {
    private static CommentApi commentApi;

    @Before
    public void before() throws Exception {
        SslUtils.ignoreSsl();
    }

    static {
        FacebookClientFactory factory = new FacebookClientFactory(XyyCredential.appId,XyyCredential.appSecret);
        //个人的身份
        //FacebookClient facebookClient = factory.getInstance(XyyCredential.accessToken);
        //主页的身份
        FacebookClient facebookClient = factory.getInstance(XyyCredentialPageCycle.accessToken);
        commentApi = facebookClient.getCommentApi();
    }


    @Test
    public void createComment() throws Exception {
        String postId = "1133083050066887_1369213629787160";
        String message = "你好啊 comment by action";
        String commentId = commentApi.createComment(postId, message);
        System.out.println(commentId);
    }

    @Test
    public void replyComment() throws Exception {
        String postId = "1366608820047641_1366718180036705";
        String message = "reply to @Jingyun Chen 你好啊 comment by action";
        String commentId = commentApi.createComment(postId, message);
        System.out.println(commentId);
    }

    @Test
    public void getComment() throws Exception {
        String commentId = "1383615025013687_1383616518346871";
        FBComment comment = commentApi.getComment(commentId,10);
        //创建者的ID

        System.out.println(JSON.toJSON(comment));
    }

    @Test
    public void deleteComment() throws Exception {
        String commentId = "1369213629787160_1369213819787141";
        commentApi.deleteComment(commentId);
    }


    @Test
    public void getComments() throws Exception {
        String nodeId = "1133083050066887_1369360733105783";
        //ResponseList<Comment> comments = commentApi.getComments(commentId,10);
        FBPaging<FBComment> commentFBPaging = commentApi.getComments(nodeId, 1, 2);
        System.out.println(JSON.toJSON(commentFBPaging));
    }

}