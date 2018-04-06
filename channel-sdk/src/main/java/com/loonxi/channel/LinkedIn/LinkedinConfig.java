package com.loonxi.channel.LinkedIn;

/**
 * Created by xyy on 2017/1/13.
 */
public class LinkedinConfig {
    public final static String  AUTH_HOST = "https://www.linkedin.com/oauth/v2/";
    public final static String  API_HOST = "https://api.linkedin.com/v1/";

    /**
     * 分享相关
     */
    public static class ShareURL{
        /**个人分享URL**/
        public final static String SHARE_URL = "people/~/shares";
        /**企业分享URL**/
        public final static String COMPANY_SHARE_URL = "companies/%s/shares";
        /**检查是否允许分享URL**/
        public final static String SHARE_ENABLED_URL = "companies/%s/is-company-share-enabled";
        /**校验用户是否是该公司主页管理员URL**/
        public final static String MEMBER_CHECK_URL =  "companies/%s/relation-to-viewer/is-company-share-enabled";
        /**分享列表URL**/
        public final static String COMPANY_UPDATE_URL = "companies/%s/updates";
        /**分享点赞URL**/
        public final static String COMPANY_UPDATE_LIKES_URL = "companies/%s/updates/key=%s/likes";
        /**分享评论URL**/
        public final static String COMPANY_UPDATE_COMMENTS_URL = "companies/%s/updates/key=%s/update-comments";
    }
}
