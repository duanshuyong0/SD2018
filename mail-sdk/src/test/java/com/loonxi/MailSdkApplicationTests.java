package com.loonxi;

import com.loonxi.mail.api.MailClientApi;
import com.loonxi.mail.constant.EmailEnum;
import com.loonxi.mail.constant.EmailLabelEnum;
import com.loonxi.mail.constant.EmailStatusEnum;
import com.loonxi.mail.entity.UserAuthentication;
import com.onloon.scrm.common.utils.JsonUtil;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MailSdkApplication.class)
public class MailSdkApplicationTests {

	@Autowired
	private JavaMailSenderImpl mailSender;
	@Autowired
	private VelocityEngine velocityEngine;

	private MailClientApi mailClientApi;

	@Before
	public void init(){
		UserAuthentication userAuthentication = new UserAuthentication();
		userAuthentication.setUserName("coder_da@163.com");
		userAuthentication.setPassWord("XIEda1307736");
		//userAuthentication.setUserName("445832453@qq.com");
		//userAuthentication.setPassWord("bvidntfjroaqbhbb");
		mailClientApi = new MailClientApi(userAuthentication, EmailEnum.NETEASE_163);
	}
//<20170106150857.E5AF0C0009D@webmail.sinamail.sina.com.cn>

	@Test
	public void test(){
		String str = "";
		String str2 = null;
		System.out.println(str.compareTo(str2));
	}
	@Test
	public void moveEmail(){
		System.out.println(JsonUtil.toJsonString(mailClientApi.moveEmail(EmailLabelEnum.INBOX,EmailLabelEnum.SEND,new String[]{"1483603712","1483603704"})));

	}
	@Test
	public void deleteMail(){
		String messageId = "1483603713";
		System.out.println(JsonUtil.toJsonString(mailClientApi.deleteMail(messageId,EmailLabelEnum.INBOX)));
	}
	@Test
	public void updateMail(){
		String messageId = "1381588690";
		System.out.println(JsonUtil.toJsonString(mailClientApi.changeMail(messageId,EmailLabelEnum.INBOX, EmailStatusEnum.READ)));
	}
	@Test
	public void fowardEmail(){
		String messageId = "1483603719";
		System.out.println(JsonUtil.toJsonString(mailClientApi.fowardMail(messageId,new String[]{"445832453@qq.com"},"你可以看看",EmailLabelEnum.INBOX)));

	}
	@Test
	public void replyMessage(){
		String messageId = "364";
		String text = "126回复测试223!!!";
		System.out.println(JsonUtil.toJsonString(mailClientApi.replyMail(messageId,text,EmailLabelEnum.INBOX)));
	}

	@Test
	public void mailInbox(){
		System.out.println(JsonUtil.toJsonString(mailClientApi.mailList(EmailLabelEnum.INBOX,"")));
	}
	@Test
	public void sendAttachMail() throws Exception {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("coder_da@126.com");
		message.setTo("445832453@qq.com");
		message.setSubject("QQ邮件带附件 - ReplyTo");
		message.setText("测试附件");
		File file = new File("annie_08.jpg");
		System.out.println(JsonUtil.toJsonString(mailClientApi.sendAttachmentsMail(message,file)));
	}

	@Test
	public void sendSimpleMail() throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("coder_da@126.com");
		message.setCc("445832453@qq.com");
		message.setSubject("来自QQ的一封信 - ReplyTo");
		message.setText("测试");
		mailClientApi.sendSimple(message);
	}

	@Test
	public void checkEmailUser(){
		System.out.println(" result : "+ JsonUtil.toJsonString(mailClientApi.checkAuth()));
	}

	@Test
	public void checkEmail(){
		System.out.println(" result : "+ JsonUtil.toJsonString(mailClientApi.mailIsExists("1381588690",EmailLabelEnum.SEND)));
	}

}
