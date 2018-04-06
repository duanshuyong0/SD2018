package com.loonxi.channel.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 * xxx.
 *
 * @author xyy
 * @Date 2016/12/8
 */
public class CjyCredential {
    public static String accessToken = "809277942979248128-5aT5TfoKLHCwApjsoPfqT41IML5pOsy";
    public static String accessTokenSecret = "oW0SGosCkXEQEozPg8ZHafZjgBQ5pdRCOamPkAvqabd7k";

    public static String consumerKey = "ZktAO26yF6qiQMraGTYNhdUxL";
    public static String consumerSecrect = "cZXxIewgx5DLLit5w0ejcDlmDR0Hl4eU7xJaiLNl2Km1RduFZT";

    public static AccessToken cjyAccessToken = new AccessToken(accessToken,accessTokenSecret);

    public static Twitter twitter ;

    static {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setIncludeEmailEnabled(true);
        /*configurationBuilder.setHttpProxyHost("127.0.0.1");
        configurationBuilder.setHttpProxyPort(8888);
        configurationBuilder.set*/

        TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
        twitter = twitterFactory.getInstance();
        twitter.setOAuthConsumer(consumerKey,consumerSecrect);
        twitter.setOAuthAccessToken(cjyAccessToken);
    }

}
