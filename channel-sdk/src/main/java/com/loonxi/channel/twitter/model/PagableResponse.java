package com.loonxi.channel.twitter.model;

import java.util.List;

/**
 * 好友列表分页
 * 
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2017年1月6日
 * @since 1.0
 */
public class PagableResponse<T> {
	/** 是否存在上一页 */
	private boolean hasPrevious;
	/** 获得上一页游标 */
	private long previousCursor;
	/** 是否存在下一页 */
	private boolean hasNext;

	/** 获得下一页游标 */
	private long nextCursor;
	/** 当前请求返回列表 */
	List<T> profiles;

	public boolean isHasPrevious() {
		return hasPrevious;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public long getPreviousCursor() {
		return previousCursor;
	}

	public void setPreviousCursor(long previousCursor) {
		this.previousCursor = previousCursor;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public long getNextCursor() {
		return nextCursor;
	}

	public void setNextCursor(long nextCursor) {
		this.nextCursor = nextCursor;
	}

	public List<T> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<T> profiles) {
		this.profiles = profiles;
	}

}
