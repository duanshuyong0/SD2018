package com.loonxi.channel.facebook.api.impl;

import com.loonxi.channel.facebook.api.convert.FBconvert;
import com.loonxi.channel.facebook.model.FBCursor;
import com.loonxi.channel.facebook.model.FBNotification;
import com.loonxi.channel.facebook.model.FBPageQuery;
import com.loonxi.channel.facebook.model.FBPaging;
import facebook4j.Paging;
import facebook4j.Reading;
import facebook4j.ResponseList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyy on 2017/1/8.
 */
public class DataConvertUtil {

    static boolean isNotBlank(String ss){

        return false;
    }

    static FBCursor convertCousor(Paging paging){
        FBCursor fbCursor = new FBCursor();
        if(paging.getPrevious()!=null){
            fbCursor.setPreveiwURL(paging.getPrevious().toString());
        }
        if(paging.getNext()!=null){
            fbCursor.setNextveiwURL(paging.getNext().toString());
        }
        return fbCursor;

    }

    public static void buildReadingByFBPageQuery(FBPageQuery fbPageQuery, Reading reading){
        if(fbPageQuery!=null){
            reading.limit(fbPageQuery.getSize()!=0 ? fbPageQuery.getSize() : 10);
            if(fbPageQuery.getSinceTime()!=null){
                reading.since(fbPageQuery.getSinceTime());
            }
            if(fbPageQuery.getUntilTime()!=null){
                reading.since(fbPageQuery.getUntilTime());
            }

        }
    }


}
