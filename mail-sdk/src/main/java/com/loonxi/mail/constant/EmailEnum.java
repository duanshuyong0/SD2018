package com.loonxi.mail.constant;

import java.util.Properties;

/**
 * 邮箱类型枚举类
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 5/1/17
 * @since 1.0
 */

public enum EmailEnum {

    GMAIL(0,"GMAIL"){
        @Override
        public Properties getMenuProperties() {
            Properties properties = new Properties();
            properties.setProperty(EmailLabelEnum.INBOX.getDesc(),"INBOX");
            properties.setProperty(EmailLabelEnum.SEND.getDesc(),"[Gmail]/已发邮件");
            properties.setProperty(EmailLabelEnum.TRASH.getDesc(),"[Gmail]/垃圾邮件");
            properties.setProperty(EmailLabelEnum.DELETE.getDesc(),"[Gmail]/已删除邮件");
            return properties;
        }
    },
    NETEASE_163(1,"NETEASE_163"){
        @Override
        public Properties getMenuProperties() {
            Properties properties = new Properties();
            properties.setProperty(EmailLabelEnum.INBOX.getDesc(),"INBOX");
            properties.setProperty(EmailLabelEnum.SEND.getDesc(),"已发送");
            properties.setProperty(EmailLabelEnum.TRASH.getDesc(),"垃圾邮件");
            properties.setProperty(EmailLabelEnum.DELETE.getDesc(),"已删除");
            return properties;
        }
    },
    NETEASE_126(2,"NETEASE_126"){
        @Override
        public Properties getMenuProperties() {
            Properties properties126 = new Properties();
            properties126.setProperty(EmailLabelEnum.INBOX.getDesc(),"INBOX");
            properties126.setProperty(EmailLabelEnum.SEND.getDesc(),"已发送");
            properties126.setProperty(EmailLabelEnum.TRASH.getDesc(),"垃圾邮件");
            properties126.setProperty(EmailLabelEnum.DELETE.getDesc(),"已删除");
            properties126.setProperty("other","other");
            return properties126;
        }
    },TENCENT_QQ(4,"TENCENT_QQ"){
        @Override
        public Properties getMenuProperties() {
            Properties propertiesQQ = new Properties();
            propertiesQQ.setProperty(EmailLabelEnum.INBOX.getDesc(),"INBOX");
            propertiesQQ.setProperty(EmailLabelEnum.SEND.getDesc(),"Sent Messages");
            propertiesQQ.setProperty(EmailLabelEnum.TRASH.getDesc(),"Junk");
            propertiesQQ.setProperty(EmailLabelEnum.DELETE.getDesc(),"Deleted Messages");
            return propertiesQQ;
        }
    },TENCENT_ENTERPRISE(5,"TENCENT_ENTERPRISE"){
        @Override
        public Properties getMenuProperties() {
            Properties propertiesTecent = new Properties();
            propertiesTecent.setProperty(EmailLabelEnum.INBOX.getDesc(),"INBOX");
            propertiesTecent.setProperty(EmailLabelEnum.SEND.getDesc(),"Sent Messages");
            propertiesTecent.setProperty(EmailLabelEnum.TRASH.getDesc(),"Junk");
            propertiesTecent.setProperty(EmailLabelEnum.DELETE.getDesc(),"Deleted Messages");
            propertiesTecent.setProperty("other","other");

            return propertiesTecent;
        }
    },NETEASE_ENTERPRISE(3,"NETEASE_ENTERPRISE"){
        @Override
        public Properties getMenuProperties() {
            Properties propertiesNetease = new Properties();
            propertiesNetease.setProperty(EmailLabelEnum.INBOX.getDesc(),"INBOX");
            propertiesNetease.setProperty(EmailLabelEnum.SEND.getDesc(),"已发送");
            propertiesNetease.setProperty(EmailLabelEnum.TRASH.getDesc(),"垃圾邮件");
            propertiesNetease.setProperty("other","其它");
            propertiesNetease.setProperty(EmailLabelEnum.DELETE.getDesc(),"已删除");
            return propertiesNetease;
        }
    }
    ;
    private Integer code;
    private String desc;

     EmailEnum(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public abstract Properties getMenuProperties();

}
