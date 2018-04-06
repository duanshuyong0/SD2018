package com.loonxi.channel.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * Created by xieda on 9/12/16.
 */
public class JacksonUtil {

    public static String toJsonStr(Object obj){
        String jsonStr = "";
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            jsonStr = objectMapper.writeValueAsString(obj);

        }catch (Exception e){

        }
       return jsonStr;
    }

    public static <T> T str2Object(String jsonStr,Class<T> clazz){
        T t = null;
        try{
           Gson gson = new Gson();
           t = gson.fromJson(jsonStr,clazz);
        }catch (Exception e){
            System.out.println(" jsonStr to Object change fail "+e.getMessage());
        }
        return t;
    }


}
