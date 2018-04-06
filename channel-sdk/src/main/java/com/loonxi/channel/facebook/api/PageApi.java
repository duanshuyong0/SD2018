package com.loonxi.channel.facebook.api;

import com.loonxi.channel.facebook.model.*;
import facebook4j.FacebookException;

import java.util.List;

/**
 * Created by xyy on 2017/1/5.
 */
public interface PageApi {

    /**
     * 获取facebook个人用户下的主页
     * 只有个人用户的token 才能调用此方法
     * 默认查询最大 100 条；不返回分页结果
     * @param facebookUserId
     * @return
     */
    List<Homepage> getPageList(String facebookUserId) throws FacebookException;

    FBPage getPage(String pageId) throws FacebookException;

    /**
     *
     * 搜索公共主页
     *
     * <pre>
     * 说睫毛膏、：
     * 1.
     * 参数是对象，没有标明某个字段必传，则非比传
     *
     * </pre>
     *
     * @param info 关键字
     * @param fbPageQuery
     * @return
     * @throws FacebookException
     */
    FBPaging<FBPage> searchPage(String info, FBPageQuery fbPageQuery) throws FacebookException;

}
