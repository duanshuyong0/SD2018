package com.loonxi.mail.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 各个邮箱服务器配置信息
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 5/1/17
 * @since 1.0
 */

public class EmailProperties {

    public static Map<String,Map<String,String>>  emailProperties = new HashMap<>() ;

    static{
        //谷歌邮箱配置
        Map<String,String> gmail = new HashMap<String,String>();
        gmail.put("imap_host","imap.gmail.com");
        gmail.put("smtp_host","smtp.gmail.com");
        gmail.put("imap_port","993");
        gmail.put("smtp_port","465");

        //网易163邮箱配置
        Map<String,String>  netease163= new HashMap<String,String>();
        netease163.put("imap_host","imap.163.com");
        netease163.put("smtp_host","smtp.163.com");
        netease163.put("imap_port","993");
        netease163.put("smtp_port","465");


        //网易126邮箱配置
        Map<String,String>  netease126= new HashMap<String,String>();
        netease126.put("imap_host","imap.126.com");
        netease126.put("smtp_host","smtp.126.com");
        netease126.put("imap_port","993");
        netease126.put("smtp_port","465");

        //QQ邮箱配置
        Map<String,String>  tencentQQ= new HashMap<String,String>();
        tencentQQ.put("imap_host","imap.qq.com");
        tencentQQ.put("smtp_host","smtp.qq.com");
        tencentQQ.put("imap_port","993");
        tencentQQ.put("smtp_port","465");

        //腾讯企业邮箱配置
        Map<String,String>  tencentEnter= new HashMap<String,String>();
        tencentEnter.put("imap_host","imap.exmail.qq.com");
        tencentEnter.put("smtp_host","smtp.exmail.qq.com");
        tencentEnter.put("imap_port","993");
        tencentEnter.put("smtp_port","465");

        //网易企业邮箱配置
        Map<String,String>  neteaseEnter= new HashMap<String,String>();
        neteaseEnter.put("imap_host","imap.ym.163.com");
        neteaseEnter.put("smtp_host","smtp.ym.163.com");
        neteaseEnter.put("imap_port","993");
        neteaseEnter.put("smtp_port","994");


        emailProperties.put("GMAIL",gmail);
        emailProperties.put("NETEASE_163",netease163);
        emailProperties.put("NETEASE_126",netease126);
        emailProperties.put("TENCENT_QQ",tencentQQ);
        emailProperties.put("TENCENT_ENTERPRISE",tencentEnter);
        emailProperties.put("NETEASE_ENTERPRISE",neteaseEnter);

    }
}
