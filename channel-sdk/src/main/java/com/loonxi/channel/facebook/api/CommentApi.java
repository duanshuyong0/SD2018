package com.loonxi.channel.facebook.api;

import com.loonxi.channel.facebook.model.FBComment;
import com.loonxi.channel.facebook.model.FBPage;
import com.loonxi.channel.facebook.model.FBPaging;
import facebook4j.Comment;
import facebook4j.FacebookException;
import facebook4j.ResponseList;

/**
 * Created by xyy on 2017/1/6.
 * 评论只先实现文字
 *
 */
public interface CommentApi {


    /**
     * 评论只能带一张图片
     * @param objectId 可以是 帖子的ID, 或者是 评论的ID
     * @param message
     * @return
     * @throws FacebookException
     * doc https://developers.facebook.com/docs/graph-api/reference/v2.8/object/comments/
     * permission：
     * publish_action
     * publish_page
     */
    String createComment(String objectId, String message) throws FacebookException;

    boolean deleteComment(String commentId) throws FacebookException;

    /**
     * 获取评论详情
     * https://developers.facebook.com/docs/graph-api/reference/v2.8/comment/
     *
     * 默认 查询出属性
     * @param commentId
     * @param replyLimit 评论回复的分页大小
     * @return
     * @throws FacebookException
     */
    FBComment getComment(String commentId, int replyLimit) throws FacebookException;

    /**
     *
     * @param limit 显示多少页面
     * @return
     *
     * 返回中包含评论，以及评论的回复
     *
     * @throws FacebookException
     *
     * 分页调用
     * comments.getPaging().getPrevious();
     */

    /**
     * 获取某个节点的评论列表；
     * @param nodeId 可以是一个POST， 也可以是一个 Comment
     * @param commentslimit 评论每页显示多少条
     * @param replieslimit 评论下的回复每页显示多少条
     * @return
     * @throws FacebookException
     */
    FBPaging<FBComment> getComments(String nodeId, int commentslimit, int replieslimit) throws FacebookException;

}
