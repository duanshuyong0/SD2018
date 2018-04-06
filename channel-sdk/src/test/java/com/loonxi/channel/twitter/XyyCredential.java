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
public class XyyCredential {
    public static String accessToken = "753471684967931904-ueeAVaEsKEo80OOSuErQtWVHESTXADi";
    public static String accessTokenSecret = "l2ZDUwPIhx74fooTEwY34qUIHqlhgqk3TE0iCUNpCwtSA";

    public static String consumerKey = "oVAWPZGzcYS4EpudcSGCHptSL";
    public static String consumerSecrect = "q03J4txA3zr115TPRQSIflAg3IaQYXj7RKdrd7eqW4yIVp8RWN";

    public static AccessToken xyyAccessToken = new AccessToken(accessToken,accessTokenSecret);

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
        twitter.setOAuthAccessToken(xyyAccessToken);
    }

}
