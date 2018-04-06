/*
 * Copyright (c) 2002-2014 Alibaba Group Holding Limited.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.loonxi.channel.twitter.model;

import java.util.List;

/**
 *
 * 图片视频信息
 * 
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2017年1月3日
 * @since 1.0
 */
public class MediaEntity {
	/** 短url,twitter中显示的url */
	private String displayURL;
	/** 访问推文的链接 */
	private String expandedURL;
	/** 图片url */
	private String mediaURL;
	/** 类型 */
	private String type;
	/** 视频信息 */
	private List<VideoVariant> videoVariants;

	public MediaEntity(String displayURL, String expandedURL, String mediaURL, String type,
			List<VideoVariant> videoVariants) {
		this.displayURL = displayURL;
		this.expandedURL = expandedURL;
		this.mediaURL = mediaURL;
		this.type = type;
		this.videoVariants = videoVariants;
	}

	public MediaEntity() {
	}

	public String getDisplayURL() {
		return displayURL;
	}

	public void setDisplayURL(String displayURL) {
		this.displayURL = displayURL;
	}

	public String getExpandedURL() {
		return expandedURL;
	}

	public void setExpandedURL(String expandedURL) {
		this.expandedURL = expandedURL;
	}

	public String getMediaURL() {
		return mediaURL;
	}

	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<VideoVariant> getVideoVariants() {
		return videoVariants;
	}

	public void setVideoVariants(List<VideoVariant> videoVariants) {
		this.videoVariants = videoVariants;
	}

}
