package com.loonxi.channel.facebook.api.convert;

import com.loonxi.channel.facebook.FacebookConfig;
import com.loonxi.channel.facebook.model.FBPage;
import facebook4j.Page;

/**
 * Created by xyy on 2017/1/9.
 */
public class FBPageConvert implements FBconvert<Page, FBPage> {

    @Override
    public FBPage modelConvert(Page page) {
        FBPage FBPage = new FBPage();
        FBPage.setId(page.getId());
        //FBPage.setAttar(page.getPicture().toString());
        //头像主页的获取
        String avatar = FacebookConfig.FACEBOOK_API_URL + "/" + page.getId() + "/picture";
        FBPage.setAttar(avatar);

        FBPage.setAbout(page.getAbout());
        FBPage.setCreatedTime(page.getCreatedTime());
        FBPage.setDescription(page.getCompanyOverview());
        FBPage.setCategory(page.getCategory());
        FBPage.setWebsite(page.getWebsite());
        FBPage.setName(page.getName());
        FBPage.setUserName(page.getUsername());
        FBPage.setPhone(page.getPhone());
        FBPage.setLikes(page.getLikes()!=null?page.getLikes():0);

        /*com.loonxi.channel.facebook.model.Location location = new com.loonxi.channel.facebook.model.Location();
        facebook4j.Place.Location loc = page.getLocation();
        // 公司邮箱
        // 公司产品
        //location.setCity(loc.getCity());
        location.setCountry(loc.getCountry());
        location.setPostCode(loc.getZip());
        location.setLatitude(loc.getLatitude());
        location.setLongitude(loc.getLongitude());
        FBPage.setLocation(location);*/

        FBPage.setHomePage("https://www.facebook.com/" + page.getId());
        return FBPage;
    }

    @Override
    public Class getSourceClass() {
        return Page.class;
    }
}
