package com.loonxi.channel.twitter.api;

import java.util.List;

import com.loonxi.channel.twitter.model.Status;

/**
 * 获得@消息接口
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2016年12月28日
 * @since 1.0
 *
 * https://dev.twitter.com/rest/reference/get/statuses/mentions_timeline
 */
public interface MentionsApi {
	/**
	 *
	 * @param count 返回结果数 如果不传或0， 则默认返回20条，最大值200条
	 * @return
	 * @throws Exception
	 */
	List<Status> getMentions(int count) throws Exception;

	/**
	 *
	 * @param count 返回结果数 如果不传或0， 则默认返回20条，最大值200条
	 * @param sinceId 结果中 status ID 的最小值;
	 * @return
	 * @throws Exception
	 */
	List<Status> getMentions(int count, String sinceId) throws Exception;

}
