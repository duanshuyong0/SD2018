package com.loonxi.channel.facebook;

import com.loonxi.channel.common.SslUtils;
import facebook4j.Facebook;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xyy on 2017/1/5.
 */
public class FacebookClientFactoryTest {
    private FacebookClientFactory factory = new FacebookClientFactory(XyyCredential.appId, XyyCredential.appSecret);
    private String redirectUrl = "http://localhost/xx";

    @Before
    public void before() throws Exception {
        SslUtils.ignoreSsl();
    }

    @Test
    public void authURL() throws Exception {
        String scope = "manage_pages,email,publish_actions,publish_pages,read_page_mailboxes";
        String url = factory.authURL(redirectUrl,scope);
        System.out.println(url);
    }

    @Test
    public void authURL1() throws Exception {
        String url = factory.authURL(redirectUrl);
        System.out.println(url);
    }

    @Test
    public void getUserTokenByCode() throws Exception {
        String code = "AQDu2_efPFryv56vCxCzze576aN4hbyxq3KJ0_lsNdGIXQFrige_3b5VQC-Rvs5cDDoLDGqrYY9OEYbaBbhTbWURMDqWghd8RPq_TPTxQI-tYkaqZSMzsdctYGdfJaNI-RgBFFCBgFM5vChC6_lhpxaOcAbuVDi9-IL3mrxhszyZNu_EuzTeX3Eak3W9iC3Jqz-tUEvDdqC3XwRYHUyx-Ms5GrJIP_BGKuiMCvaXVovduk46upYML6Dl3W7JwH_3Jo7aLg2vKpad4DWPxqUwYFdLxNqFmIoC04J980iolwxfCHKcIue26YqGOQi4klEXzY9vBx0lFJK1X35yuNkIyRQ6T2_R-e_Vfs1NcT5HfUf7WA#_=_";
        String token = factory.getUserTokenByCode(code, redirectUrl);
        System.out.println(token);
    }

}