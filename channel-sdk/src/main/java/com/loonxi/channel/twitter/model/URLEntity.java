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

/**
 * 超链接信息
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2017年1月3日
 * @since 1.0
 */
public class URLEntity {
	/** 短url */
	private String displayURL;
	/** 长url */
	private String expandedURL;
	/** twitter中显示的url */
	private String uRL;

	public URLEntity(String displayURL, String expandedURL, String uRL) {
		this.displayURL = displayURL;
		this.expandedURL = expandedURL;
		this.uRL = uRL;
	}

	public URLEntity() {
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

	public String getuRL() {
		return uRL;
	}

	public void setuRL(String uRL) {
		this.uRL = uRL;
	}

}
