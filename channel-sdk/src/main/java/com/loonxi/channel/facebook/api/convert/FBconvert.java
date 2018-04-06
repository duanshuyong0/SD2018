package com.loonxi.channel.facebook.api.convert;

import com.loonxi.channel.facebook.model.FBCursor;
import com.loonxi.channel.facebook.model.FBPaging;
import facebook4j.PagableList;
import facebook4j.ResponseList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyy on 2017/1/9.
 */
public interface FBconvert<S, T> {
    /**
     *
     * @param s facebok4j 的模型转换成自己的模型
     * @return T 自己的模型
     */
    T modelConvert(S s);

    default FBPaging<T> pageConvert(PagableList<S> soucePage){
        List<T> list = new ArrayList<>();
        soucePage.stream().forEach(e -> list.add(modelConvert(e)));
        FBCursor fbCursor = new FBCursor();
        if(soucePage.getPaging()!=null){
            fbCursor.setNextveiwURL(soucePage.getPaging().getNext()!=null?soucePage.getPaging().getNext().toString():null);
            fbCursor.setPreveiwURL(soucePage.getPaging().getPrevious()!=null?soucePage.getPaging().getPrevious().toString():null);
        }
        FBPaging<T> fbNotificationFBPaging = new FBPaging(fbCursor,list);
        return fbNotificationFBPaging;
    }

    Class getSourceClass();
}
