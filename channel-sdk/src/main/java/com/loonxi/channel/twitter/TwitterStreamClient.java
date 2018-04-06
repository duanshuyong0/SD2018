package com.loonxi.channel.twitter;

import com.loonxi.channel.twitter.streamApi.UserListener;
import twitter4j.TwitterStream;

/**
 * Created by xyy on 2017/1/12.
 */
public class TwitterStreamClient {
    private TwitterStream twitterStream;

    public TwitterStreamClient(TwitterStream twitterStream) {
        this.twitterStream = twitterStream;
    }

    public void startUserStream(UserListener userListener){
        twitterStream.addListener(userListener); // 这里加入了listener用于处理侦听推文
        twitterStream.user();
    }
}
