package com.loonxi.channel.facebook.api.convert;

import com.loonxi.channel.facebook.model.FBComment;
import com.loonxi.channel.facebook.model.FBPost;
import com.loonxi.channel.facebook.model.FBbaseProfile;
import facebook4j.Comment;
import facebook4j.PagableList;
import facebook4j.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * post 转换规则，会将post下的评论和评论的回复的查询出来
 * Created by xyy on 2017/1/9.
 */
public class FBPostConvert implements FBconvert<Post, FBPost>{
    @Override
    public FBPost modelConvert(Post post) {
        return convertPost(post);
    }

    @Override
    public Class getSourceClass() {
        return Post.class;
    }

    private FBPost convertPost(Post post){
        FBPost fbPost = new FBPost();
        fbPost.setId(post.getId());
        fbPost.setMessage(post.getMessage());
        fbPost.setCreatedTime(post.getCreatedTime());
        fbPost.setFrom(new FBbaseProfile(post.getFrom().getId(), post.getFrom().getName()));
        //POST中的图片链接
        List<Post.Attachment> attachments = post.getAttachments();
        List<String> photoUrls = new ArrayList<>();
        List<String> videoUrls = new ArrayList<>();

        //图片链接
        if(attachments.size()>0) {
            for (Post.Attachment attachment : attachments) {

                //附件属性是相册
                if (attachment.getType().equals("album")) {
                    List<Post.Attachment> subAttachments = attachment.getSubattachments();
                    if (subAttachments.size() > 0) {
                        for (Post.Attachment attachment1 : subAttachments) {
                            // 附件属性是 phpoto 照片
                            if (attachment1.getType().equals("photo")) {
                                photoUrls.add(attachment1.getUrl());
                            }
                        }
                    }
                }
                //一张图片的情况下
                if(attachment.getType().equals("photo")){
                    photoUrls.add(attachment.getUrl());
                }
                //视屏的情况下
                if(attachment.getType().equals("video_autoplay")){
                    videoUrls.add(attachment.getUrl());
                }
            }

        }
        fbPost.setPhotoUrls(photoUrls);
        fbPost.setVedioUrls(videoUrls);

        //Comment
        PagableList<Comment> comments = post.getComments();
        if(comments.size()>0){
            fbPost.setComments(new FBCommentConvert().pageConvert(comments));
        }

        //引用帖子的内容
        if(post.getParentId()!=null && !"".equals(post.getParentId())){
            fbPost.setQuotePost(new FBPost(post.getParentId()));
        }
        return fbPost;
    }
}
