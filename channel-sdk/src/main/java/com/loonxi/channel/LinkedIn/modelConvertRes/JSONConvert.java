package com.loonxi.channel.LinkedIn.modelConvertRes;

import com.alibaba.fastjson.JSONObject;
import com.loonxi.channel.LinkedIn.model.CodeAndName;
import com.loonxi.channel.LinkedIn.model.Company;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by xyy on 2017/1/16.
 *
 *
 * JOSNObject 是不能直接转化成
 *
 */
public class JSONConvert {
    public static  <T> T  convert(JSONObject object, Class<T> tClass) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        /*if(1==1){
            return JSONObject.toJavaObject(object,tClass);
        }*/

        //先获取私有属性
        T objectResult = tClass.newInstance();
        Field[] fields = tClass.getDeclaredFields();
        for (Field field : fields){
            String fieldName = field.getName();
            Class fieldType = field.getType();
            Object target = object.get(fieldName);
            //如果 json 返回体中没有这个字段则继续
            if(target==null){
                continue;
            }

            String setMethodName = getSetMethodName(fieldName);
            Method setMethod = tClass.getMethod(setMethodName, fieldType);

            //处理 codeAndName 这种情况
            if(fieldType.equals(CodeAndName.class)){
                JSONObject jsonObject = (JSONObject)target;
                setMethod.invoke(objectResult, new CodeAndName((String) jsonObject.get("code"), (String) jsonObject.get("name")));
                continue;
            }

            //处理 industries codeAndName 集合的情况
            if(tClass.equals(Company.class) && (fieldName.equals("industries") || fieldName.equals("specialties"))){
                System.out.println(target.getClass());
                JSONObject jsonObject = (JSONObject)target;
                //List<CodeAndName> list = (List<CodeAndName>) ((JSONObject) target).get("values");
                System.out.println(((JSONObject) target).get("values").getClass());
                setMethod.invoke(objectResult, ((JSONObject) target).get("values"));
                continue;
            }

            //处理 company 地址 公司类型
            if(tClass.equals(Company.class) && fieldName.equals("locations")){
                JSONObject jsonObject = (JSONObject)target;
                List<Company.CompanyLocation> list = (List<Company.CompanyLocation>) ((JSONObject) target).get("values");
                setMethod.invoke(objectResult, list);
                continue;
            }

            //类型转换问题
            setMethod.invoke(objectResult, target);

        }
        return objectResult;
    }


    private static String getSetMethodName(String filedName){
        //String methodName = "set" +  filedName.replace(0,"xx")
        filedName = filedName.replaceFirst(filedName.substring(0, 1),filedName.substring(0, 1).toUpperCase());
        String methodName = "set" + filedName;
        return methodName;
    }
}
