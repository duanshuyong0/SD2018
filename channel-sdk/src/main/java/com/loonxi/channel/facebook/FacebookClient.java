package com.loonxi.channel.facebook;

import com.loonxi.channel.facebook.api.*;
import com.loonxi.channel.facebook.api.convert.*;
import com.loonxi.channel.facebook.api.impl.*;
import com.loonxi.channel.facebook.model.FBCursorDirection;
import com.loonxi.channel.facebook.model.FBCursorMode;
import com.loonxi.channel.facebook.model.FBPaging;
import facebook4j.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @describe facebook外部接口类
 * @author guoxubin
 * @date 2016年10月11日
 *
 */
public class FacebookClient {
	private Facebook facebook;

	PostApi postApi;
	UserApi userApi;
	CommentApi commentApi;
	PageApi pageApi;
	NotificationApi notificationApi;
	MessageApi messageApi;

	FacebookClient(Facebook facebook) {
		this.facebook = facebook;
		postApi = new PostApiImpl(facebook);
		userApi = new UserApiImpl(facebook);
		commentApi = new CommentApiImpl(facebook);
		pageApi = new PageApiImpl(facebook);
		notificationApi = new NotificationApiImpl(facebook);
		messageApi = new MessageApiImpl(facebook);
	}

	public PageApi getPageApi() {
		return pageApi;
	}

	public CommentApi getCommentApi() {
		return commentApi;
	}

	public UserApi getUserApi() {
		return userApi;
	}

	public PostApi getPostApi() {
		return postApi;
	}

	public NotificationApi getNotificationApi() {
		return notificationApi;
	}

	public MessageApi getMessageApi() {
		return messageApi;
	}

	/**
	 * 分页查询 page
	 * @param cursorMode
	 * @return
	 * @throws FacebookException
	 */
	public FBPaging navigatePage(FBCursorMode cursorMode) throws FacebookException{
		return navigate(cursorMode, new FBPageConvert());
	}
	public FBPaging navigateNotification(FBCursorMode cursorMode) throws FacebookException{
		return navigate(cursorMode, new FBNotificationConvert());
	}
	public FBPaging navigatePost(FBCursorMode cursorMode) throws FacebookException{
		return navigate(cursorMode, new FBPostConvert());
	}
	public FBPaging navigateConversation(FBCursorMode cursorMode) throws FacebookException{
		return navigate(cursorMode, new FBConversationConvert());
	}
	public FBPaging navigateMessage(FBCursorMode cursorMode) throws FacebookException{
		return navigate(cursorMode, new FBMessageConvert());
	}

	public FBPaging navigateComment(FBCursorMode cursorMode) throws FacebookException{
		return navigate(cursorMode, new FBCommentConvert());
	}

	private FBPaging navigate(FBCursorMode cursorMode, FBconvert fBconvert) throws FacebookException {
		try {
			final URL pagego = new URL(cursorMode.getValue());
			final Class aClass = fBconvert.getSourceClass();
			if(cursorMode.getCursorDirection().equals(FBCursorDirection.AFTER)){
				Paging paging = new Paging() {
					@Override
					public Class<?> getJSONObjectType() {
						return aClass;
					}

					@Override
					public Cursors getCursors() {
						return null;
					}

					@Override
					public URL getPrevious() {
						return null;
					}

					@Override
					public URL getNext() {
						return pagego;
					}
				};
				ResponseList<Page> pages = facebook.fetchNext(paging);
				return fBconvert.pageConvert(pages);
			}else{
				Paging<Page> paging = new Paging<Page>() {
					@Override
					public Class<?> getJSONObjectType() {
						return Page.class;
					}

					@Override
					public Cursors getCursors() {
						return null;
					}

					@Override
					public URL getPrevious() {
						return pagego;
					}

					@Override
					public URL getNext() {
						return null;
					}
				};
				ResponseList<Page> pages = facebook.fetchPrevious(paging);
				return fBconvert.pageConvert(pages);
			}


		} catch (MalformedURLException e) {
			throw new RuntimeException("分页地址错误： " + cursorMode.getValue(), e);
		}
	}
}
