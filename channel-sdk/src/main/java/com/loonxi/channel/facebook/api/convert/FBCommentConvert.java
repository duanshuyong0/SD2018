package com.loonxi.channel.facebook.api.convert;

import com.loonxi.channel.facebook.model.FBComment;
import com.loonxi.channel.facebook.model.FBPaging;
import com.loonxi.channel.facebook.model.FBbaseProfile;
import facebook4j.Comment;
import facebook4j.PagableList;

/**
 * Created by xyy on 2017/1/16.
 */
public class FBCommentConvert implements FBconvert<Comment, FBComment>{

    @Override
    public FBComment modelConvert(Comment comment) {
        FBComment fbComment = new FBComment();
        fbComment.setId(comment.getId());
        fbComment.setFrom(new FBbaseProfile(comment.getFrom().getId(),comment.getFrom().getName()));
        fbComment.setMessage(comment.getMessage());
        fbComment.setCreatedTime(comment.getCreatedTime());
        fbComment.setParent(comment.getParent()!=null?new FBCommentConvert().modelConvert(comment.getParent()):null);


        if(comment.getAttachment()!=null){
            if(comment.getAttachment().getType().equals("video_autoplay")){
                fbComment.setVedioUrl(comment.getAttachment().getUrl());
            }else if(comment.getAttachment().getType().equals("photo")){
                fbComment.setPhotoUrl(comment.getAttachment().getMedia().getImage().getSource().toString());
            }
        }

        //评论的回复内容
        PagableList<Comment> replies = comment.getComments();
        if(replies.size()>0){
            FBPaging<FBComment> fbreplies = new FBCommentConvert().pageConvert(replies);
            fbComment.setReplies(fbreplies);
        }
        return fbComment;
    }

    @Override
    public Class getSourceClass() {
        return Comment.class;
    }
}
