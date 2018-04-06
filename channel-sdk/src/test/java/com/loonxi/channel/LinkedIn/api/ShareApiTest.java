package com.loonxi.channel.LinkedIn.api;
import com.loonxi.channel.LinkedIn.LinkedInClient;
import com.loonxi.channel.LinkedIn.LinkedinClientFactory;
import com.loonxi.channel.LinkedIn.api.inter.ShareApi;
import com.loonxi.channel.LinkedIn.exception.LinkedinException;
import com.loonxi.channel.LinkedIn.model.share.*;
import com.loonxi.channel.common.JacksonUtil;
import org.junit.Test;
/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 16/1/17
 * @since 1.0
 */

public class ShareApiTest {

    LinkedInClient client =
            new LinkedinClientFactory(BanmaLinkedinCredentials.app_id, BanmaLinkedinCredentials.app_secrect).
                    getInstance(BanmaLinkedinCredentials.token);
    ShareApi shareApi = client.getShareApi();


    @Test
    public void fetchUpdateList(){
        try {
            CompanyUpdatesQuery query = new CompanyUpdatesQuery();
            query.setShareTypeEnum(ShareTypeEnum.STATUS_UPDATE);
            CompanyShareListResponse response =  shareApi.fetchShareList("13247844",query);
            System.out.print(JacksonUtil.toJsonStr(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fetchUpdateComment(){
        try{
            CompanyShareCommentList commentList = shareApi.fetchShareCommentsList("13247844","UPDATE-c13247844-6225922283337289728");
            System.out.println(commentList.get_total());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void fetchUpdateLike(){
        try{
            CompanyShareLikesList likesList = shareApi.fetchShareLikesList("13247844","UPDATE-c13247844-6225922283337289728");
            System.out.println(JacksonUtil.toJsonStr(likesList));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void personSimpleShare(){
        try {
            shareApi.personShare("发送第一波进攻");
        } catch (LinkedinException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void personComplexShare(){
        try {
            LinkedInShareContentBean contentBean = new LinkedInShareContentBean();
            contentBean.setTitle("程序首次测试分享");
            contentBean.setDescription("相应投诉将反馈至商家，消费者投诉");
            contentBean.setSubmittedImageUrl("https://img.onloon.co/product/20161108111407606604543.jpg");
            contentBean.setSubmittedUrl("https://server.onloon.com.cn/b2b_pc/static/view/detail.html?productId=f190da4900f749b1a878447acf9d3320");
            shareApi.personShare("第二波来袭",contentBean);
        } catch (LinkedinException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void companyShare(){
        try {
            shareApi.companyShare("13247844","主页第一波进攻");
        } catch (LinkedinException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void companyComplexShare(){
        try {
            LinkedInShareContentBean contentBean = new LinkedInShareContentBean();
            contentBean.setTitle("程序首次测试分享");
            contentBean.setDescription("相应222投诉将反馈至商家，消费者投诉");
            contentBean.setSubmittedImageUrl("https://img.onloon.co/product/20161108111407606604543.jpg");
            contentBean.setSubmittedUrl("https://server.onloon.com.cn/b2b_pc/static/view/detail.html?productId=f190da4900f749b1a878447acf9d3320");
            shareApi.companyShare("13247844","第二波来袭",contentBean);
        } catch (LinkedinException e) {
            e.printStackTrace();
        }
    }

}
