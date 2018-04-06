package com.dsy.dadui.common.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮箱工具类
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
public class MailUtil {

	/** 邮箱用户名，也是发件箱 */
	private static final String MAIL_USERNAME = "onloon@loonxi.com";
	private static final String MAIL_USERNAME_PASSWORD = "mimamima12XYY";

	/** SMTP服务器地址 */
	private static final String MAIL_SMTP_HOST = "smtp.mxhichina.com";
	/** SMTP服务器地址 */
	private static final String MAIL_SMTP_PORT = "25";

	public static void send(String email, String subject, String body) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", MAIL_SMTP_HOST);
		props.put("mail.smtp.port", MAIL_SMTP_PORT);

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MAIL_USERNAME, MAIL_USERNAME_PASSWORD);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("onloon@loonxi.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(subject);
			// message.setText(content);
			message.setContent(body, "text/html;charset = gbk");
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
