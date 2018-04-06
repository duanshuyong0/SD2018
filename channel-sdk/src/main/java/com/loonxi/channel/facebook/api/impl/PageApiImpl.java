package com.loonxi.channel.facebook.api.impl;

import com.loonxi.channel.facebook.FacebookConfig;
import com.loonxi.channel.facebook.api.PageApi;
import com.loonxi.channel.facebook.api.convert.FBPageConvert;
import com.loonxi.channel.facebook.model.*;
import facebook4j.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyy on 2017/1/5.
 */
public class PageApiImpl implements PageApi {
    private Facebook facebook;

    private String[] readingFields = {"id", "picture", "about", "access_token", "birthday",
            "awards", "company_overview", "description", "category", "location", "website", "emails", "name",
            "phone", "products", "username", "founded"};

    public PageApiImpl(Facebook facebook) {
        this.facebook = facebook;
    }


    @Override
    public List<Homepage> getPageList(String facebookUserId) throws FacebookException {
        Reading reading = new Reading();
        reading.limit(100);
        reading.fields(readingFields);
        ResponseList<Account> accounts = facebook.getAccounts(reading);
        List<Homepage> list = new ArrayList<Homepage>();
        for (Account account : accounts) {
            Homepage facebookHomepage = new Homepage();
            facebookHomepage.setHomepageId(account.getId());
            facebookHomepage.setPageToken(account.getAccessToken());
            facebookHomepage.setName(account.getName());
            // 头像地址,为域名+pageId+"picture"
            // https://graph.facebook.com/v2.7/1133083050066887/picture
            String avatar = FacebookConfig.FACEBOOK_API_URL + "/" + account.getId() + "/picture";
            facebookHomepage.setAvatar(avatar);
            list.add(facebookHomepage);
        }
        return list;
    }

    @Override
    public FBPage getPage(String pageId) throws FacebookException {
        Reading reading = new Reading();
        reading.fields(readingFields);
        Page page = facebook.getPage(pageId, reading);
        return new FBPageConvert().modelConvert(page);
    }

    @Override
    public FBPaging<FBPage> searchPage(String info, FBPageQuery fbPageQuery) throws FacebookException {
        Reading reading = new Reading();
        DataConvertUtil.buildReadingByFBPageQuery(fbPageQuery, reading);
        reading.fields(readingFields);
        ResponseList<Page> pages = facebook.searchPages(info,reading);
        return new FBPageConvert().pageConvert(pages);
    }

}
