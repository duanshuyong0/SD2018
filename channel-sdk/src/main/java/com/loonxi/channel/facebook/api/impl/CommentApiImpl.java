package com.loonxi.channel.facebook.api.impl;

import com.loonxi.channel.facebook.api.CommentApi;
import com.loonxi.channel.facebook.api.convert.FBCommentConvert;
import com.loonxi.channel.facebook.model.FBComment;
import com.loonxi.channel.facebook.model.FBPaging;
import facebook4j.*;

/**
 * Created by xyy on 2017/1/6.
 */
public class CommentApiImpl implements CommentApi {

    private Facebook facebook;

    public CommentApiImpl(Facebook facebook) {
        this.facebook = facebook;
    }

    @Override
    public String createComment(String postId, String message) throws FacebookException {
        return facebook.commentPost(postId, message);
    }


    @Override
    public boolean deleteComment(String commentId) throws FacebookException {
        return facebook.deleteComment(commentId);
    }


    //id, attachment, comment_count,create_time,from, like acount, message, message_tags, parent, user_likes
    @Override
    public FBComment getComment(String commentId, int replyLimit) throws FacebookException {
        Reading reading = new Reading();
        reading.fields("attachment","id","can_comment","can_remove","can_like",
                "comment_count","created_time","from","like_count","message_tags","parent","user_likes","message");
        String repliesCommentsFields = "comments.limit(10){attachment,can_like,comment_count,created_time,from,id,message,like_count}";
        repliesCommentsFields = repliesCommentsFields.replace("comments.limit(10","comments.limit(" + replyLimit);
        reading.fields(repliesCommentsFields);
        Comment comment = facebook.getComment(commentId,reading);

        return new FBCommentConvert().modelConvert(comment);
    }

    @Override
    public FBPaging<FBComment> getComments(String nodeId, int commentslimit, int replieslimit) throws FacebookException {

        Reading reading = new Reading();
        reading.limit(commentslimit);
        reading.fields("attachment","id","can_comment","can_remove","can_like",
                "comment_count","created_time","from","like_count","message_tags","parent","user_likes","message");
        String repliesCommentsFields = "comments.limit(10){attachment,can_like,comment_count,created_time,from,id,message,like_count}";
        repliesCommentsFields = repliesCommentsFields.replace("comments.limit(10","comments.limit(" + replieslimit);
        reading.fields(repliesCommentsFields);
        ResponseList<Comment> comments = facebook.getCommentReplies(nodeId, reading);
        return new FBCommentConvert().pageConvert(comments);

    }

}
