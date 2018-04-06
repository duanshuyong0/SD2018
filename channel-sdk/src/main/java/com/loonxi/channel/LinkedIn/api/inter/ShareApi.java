package com.loonxi.channel.LinkedIn.api.inter;

import com.loonxi.channel.LinkedIn.exception.LinkedinException;
import com.loonxi.channel.LinkedIn.model.share.*;

import java.net.URISyntaxException;

/**
 * LinkedIn个人分享与公司主页分享
 *
 * Person:
 * https://api.linkedin.com/v1/people/~/shares?format=json
 *
     {
         "comment": "Check out developer.linkedin.com!",
         "content": {
             "title": "LinkedIn Developers Resources",
             "description": "Leverage LinkedIn's APIs to maximize engagement",
             "submitted-url": "https://developer.linkedin.com",
             "submitted-image-url": "https://example.com/logo.png"
             },
         "visibility": {
            "code": "anyone"
            }
     }
 * Company:
 * https://api.linkedin.com/v1/companies/{companyId}/shares?format=json
 *
     *{
         "visibility": {
            "code": "anyone"
            },
         "comment": "Testing a full company share!",
         "content": {
             "submitted-url": "https://www.linkedin.com/pulse/always-learning-linkedin-acquire-lyndacom-jeff-weiner",
             "title": "Test Share with Content",
             "description": "content description",
             "submitted‐image-­url": "https://spdy.linkedin.com/mpr/mpr/jc/AAEAAQAAAAAAAALgAAAAJGMxYzIyZGRiLTA4NjYtNDlhYi1hNjQxLTQ2NWNkOTNmNGQyNQ.png"
            },
        "shareTargetReach": {
             "shareTargets": {
             "shareTarget": {
                 "tvalues": {
                    "tvalue": "na"
                 },
             "code": "geos"
                }
             }
            }
     }
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 14/1/17
 * @since 1.0
 */

public interface ShareApi {


    /**
     *
     * Share via a comment containing a URL
     * @param comment
     * @return
     */
    LinkedInShareResponse  personShare(String comment) throws LinkedinException;

    /**
     *Share with full value
     * @param comment
     * @param contentBean
     * @return
     */
    LinkedInShareResponse  personShare(String comment, LinkedInShareContentBean contentBean) throws LinkedinException;

    /**
     * The company Share via a comment containing a URL
     * @param companyId
     * @param comment
     * @return
     */
    LinkedInShareResponse  companyShare(String companyId,String comment) throws LinkedinException;


    /**
     * The company Share with full value
     * @param companyId
     * @param comment
     * @param contentBean
     * @return
     */
    LinkedInShareResponse  companyShare(String companyId,String comment,LinkedInShareContentBean contentBean) throws LinkedinException;

    /**
     * 公司是否允许分享
     * @param companyId
     * @return
     */
    String shareIsEabled2Company(String companyId) throws LinkedinException;

    /**
     * 当前用户是否具备该公司管理员身份
     * @param companyId
     * @return
     */
    String memberIsAdmin2Company(String companyId) throws LinkedinException;

    /**
     * 获取公司的分享动态
     * @param companyId
     * Only the most recent 50 updates for events of type status-update will be returned.
     */
    CompanyShareListResponse  fetchShareList(String companyId) throws LinkedinException;

    /**
     * 获取公司的分享动态
     * @param companyId
     * Only the most recent 50 updates for events of type status-update will be returned.
     *
     *
     * https://developer.linkedin.com/docs/company-pages#company_updates
     * 对于 status-update 这种类型的 update 只能获取前50条，该接口不支持分页
     *
     */
    CompanyShareListResponse  fetchShareList(String companyId,CompanyUpdatesQuery companyUpdatesQuery) throws LinkedinException;

    /**
     * 获取分享点赞人数
     * @param companyId
     */
    CompanyShareLikesList fetchShareLikesList(String companyId,String updateKey) throws LinkedinException;

    /**
     * 获取分享评论
     * @param companyId
     */
    CompanyShareCommentList fetchShareCommentsList(String companyId,String updateKey) throws LinkedinException;


}
