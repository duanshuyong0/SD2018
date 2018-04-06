package com.loonxi.channel.LinkedIn.api;

import com.google.gson.Gson;
import com.loonxi.channel.LinkedIn.LinkedinConfig;
import com.loonxi.channel.LinkedIn.api.inter.LinkedInAbstractApi;
import com.loonxi.channel.LinkedIn.api.inter.ShareApi;
import com.loonxi.channel.LinkedIn.exception.LinkedinException;
import com.loonxi.channel.LinkedIn.model.share.*;
import com.loonxi.channel.common.HttpClientUtil;
import com.loonxi.channel.common.JacksonUtil;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 14/1/17
 * @since 1.0
 */

public class ShareApiImpl extends LinkedInAbstractApi implements ShareApi {

    public ShareApiImpl(String token) {
        super(token);
    }

    @Override
    public LinkedInShareResponse personShare(String comment)throws LinkedinException {
       return this.personShare(comment,null);
    }

    @Override
    public LinkedInShareResponse personShare(String comment, LinkedInShareContentBean contentBean) throws LinkedinException {
        String apiUrl = LinkedinConfig.API_HOST+LinkedinConfig.ShareURL.SHARE_URL;
        return generateHeaderAndParams2Post(comment,contentBean,apiUrl);
    }
    @Override
    public LinkedInShareResponse companyShare(String companyId, String comment) throws LinkedinException {
        return this.companyShare(companyId,comment,null);

    }
    @Override
    public LinkedInShareResponse companyShare(String companyId, String comment, LinkedInShareContentBean contentBean) throws LinkedinException {
        String apiUrl = LinkedinConfig.API_HOST + String.format(LinkedinConfig.ShareURL.COMPANY_SHARE_URL,companyId);
        return generateHeaderAndParams2Post(comment,contentBean,apiUrl);
    }

    @Override
    public String shareIsEabled2Company(String companyId) throws LinkedinException {
        String apiUrl = LinkedinConfig.API_HOST+String.format(LinkedinConfig.ShareURL.SHARE_ENABLED_URL,companyId);
        Map<String,Object> params = this.generateParams();
        String result = null;
        try {
            result = HttpClientUtil.httpGetRequest(apiUrl,this.getHeader(),params);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public String memberIsAdmin2Company(String companyId) throws LinkedinException {
        String apiUrl = LinkedinConfig.API_HOST+String.format(LinkedinConfig.ShareURL.MEMBER_CHECK_URL,companyId);
        Map<String,Object> params = this.generateParams();
        String result = null;
        try {
            result = HttpClientUtil.httpGetRequest(apiUrl,this.getHeader(),params);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public CompanyShareListResponse fetchShareList(String companyId) throws LinkedinException {
            return this.fetchShareList(companyId,null);
    }

    @Override
    public CompanyShareListResponse fetchShareList(String companyId, CompanyUpdatesQuery companyUpdatesQuery) throws LinkedinException {
        String apiUrl = LinkedinConfig.API_HOST+String.format(LinkedinConfig.ShareURL.COMPANY_UPDATE_URL,companyId);
        Map<String,Object> params = this.generateParams();
        if(companyUpdatesQuery != null){
            if (companyUpdatesQuery.getShareTypeEnum() != null) {
                params.put("event-type", companyUpdatesQuery.getShareTypeEnum().getDesc());
            }
            params.put("count",companyUpdatesQuery.getSize());
        }
        String result = null;
        try {
            result = HttpClientUtil.httpGetRequest(apiUrl,this.getHeader(),params);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //检查结果是否包含异常
        LinkedinException.checkLinkedinError(result);
        CompanyShareListResponse response = JacksonUtil.str2Object(result,CompanyShareListResponse.class);
        return response;
    }

    @Override
    public CompanyShareLikesList fetchShareLikesList(String companyId,String updateKey) throws LinkedinException {
        String apiUrl = LinkedinConfig.API_HOST+String.format(LinkedinConfig.ShareURL.COMPANY_UPDATE_LIKES_URL,companyId,updateKey);
        Map<String,Object> params = this.generateParams();
        String result = null;
        try {
            result = HttpClientUtil.httpGetRequest(apiUrl,this.getHeader(),params);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //检查结果是否包含异常
        LinkedinException.checkLinkedinError(result);
        CompanyShareLikesList likesList = JacksonUtil.str2Object(result,CompanyShareLikesList.class);
        return likesList;
    }

    @Override
    public CompanyShareCommentList fetchShareCommentsList(String companyId,String updateKey) throws LinkedinException {
        String apiUrl = LinkedinConfig.API_HOST+String.format(LinkedinConfig.ShareURL.COMPANY_UPDATE_COMMENTS_URL,companyId,updateKey);
        Map<String,Object> params = this.generateParams();
        String result = null;
        try {
            result = HttpClientUtil.httpGetRequest(apiUrl,this.getHeader(),params);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //检查结果是否包含异常
        LinkedinException.checkLinkedinError(result);
        CompanyShareCommentList commentList = JacksonUtil.str2Object(result,CompanyShareCommentList.class);
        return commentList;
    }


    /**
     * 生成参数
     */
    public Map<String,Object> generateParams(){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("format","json");
        return params;
    }
    /**
     * 分享返回结果封装
     * @param result
     * @return
     */
    private LinkedInShareResponse result2ShareResponse(String result){
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(result, Map.class);
        System.out.println(" result info "+map);
        LinkedInShareResponse response = new LinkedInShareResponse();
        response.setUpdateKey((String)map.get("updateKey"));
        response.setUpdateKey((String)map.get("updateUrl"));
        return response;
    }

    /**
     * 组装请求头部和参数信息并发送请求
     */
    private LinkedInShareResponse generateHeaderAndParams2Post(String comment,LinkedInShareContentBean contentBean,String apiUrl) throws  LinkedinException{
        Map<String,Object> header = this.getHeader();
        header.put("Content-Type","application/json");
        header.put("x-li-format","json");
        LinkedInShareBean linkedInShareBean = null;
        if(contentBean != null){
            linkedInShareBean = new LinkedInShareComplexBean();
            ((LinkedInShareComplexBean)linkedInShareBean).setContent(contentBean);
        }else{
            linkedInShareBean = new LinkedInShareBean();
        }
        linkedInShareBean.setComment(comment);
        System.out.println(" ******** linkedin share params ********)"+JacksonUtil.toJsonStr(linkedInShareBean));
        String result = HttpClientUtil.httpPostWithEntity(apiUrl,getHeader(),JacksonUtil.toJsonStr(linkedInShareBean));
        System.out.println(" ******** linkedin share result ********)"+result);
        LinkedinException.checkLinkedinError(result);
        return result2ShareResponse(result);
    }



}
