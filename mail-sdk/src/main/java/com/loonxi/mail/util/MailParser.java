package com.loonxi.mail.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

/**
 * 邮件解析类
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 6/1/17
 * @since 1.0
 */
public class MailParser {
	private Logger logger = LoggerFactory.getLogger(MailParser.class);

	private MimeMessage mimeMessage = null;
	private Map<String,InputStream> attachMap = new LinkedHashMap<>();
	private StringBuffer bodyText = new StringBuffer(); // 存放邮件内容的StringBuffer对象
	private StringBuffer bodyHtml = new StringBuffer();//存放内容
	private String dateFormat = "yy-MM-dd HH:mm"; // 默认的日前显示格式

	/**
	 * 构造函数,初始化一个MimeMessage对象
	 */
	public MailParser() {
	}

	public MailParser(MimeMessage mimeMessage) {
		this.mimeMessage = mimeMessage;

	}

	public void setMimeMessage(MimeMessage mimeMessage) {
		this.mimeMessage = mimeMessage;
	}

	public String getBodyHtml() {
		return bodyHtml.toString();
	}

	public Map<String, InputStream> getAttachMap() {
		return attachMap;
	}

	public void setAttachMap(Map<String, InputStream> attachMap) {
		this.attachMap = attachMap;
	}

	/**
	 * 　*　获得发件人的地址和姓名 　
	 */
	public String getFrom() throws Exception {
		InternetAddress address[] = (InternetAddress[]) mimeMessage.getFrom();
		String from = address[0].getAddress();
		if (from == null) {
			from = "";
		}
		String personal = address[0].getPersonal();

		if (personal == null) {
			personal = "";
		}

		String fromAddr = null;
		if (personal != null || from != null) {
			fromAddr = personal + "<" + from + ">";
		} else {
			logger.info("无法获得发送者信息.");
		}
		return fromAddr;
	}

	/**
	 * 　*　获得邮件的收件人，抄送，和密送的地址和姓名，根据所传递的参数的不同
	 * 　*　"to"----收件人　"cc"---抄送人地址　"bcc"---密送人地址 　
	 */
	public String getMailAddress(String type) throws Exception {
		String mailAddr = "";
		String addType = type.toUpperCase();

		InternetAddress[] address = null;
		if (addType.equals("TO") || addType.equals("CC") || addType.equals("BCC")) {

			if (addType.equals("TO")) {
				address = (InternetAddress[]) mimeMessage
						.getRecipients(Message.RecipientType.TO);
			} else if (addType.equals("CC")) {
				address = (InternetAddress[]) mimeMessage
						.getRecipients(Message.RecipientType.CC);
			} else {
				address = (InternetAddress[]) mimeMessage
						.getRecipients(Message.RecipientType.BCC);
			}

			if (address != null) {
				for (int i = 0; i < address.length; i++) {
					String emailAddr = address[i].getAddress();
					if (emailAddr == null) {
						emailAddr = "";
					} else {
						emailAddr = MimeUtility.decodeText(emailAddr);
					}
					String personal = address[i].getPersonal();
					if (personal == null) {
						personal = "";
					} else {
						personal = MimeUtility.decodeText(personal);
					}
					String compositeto = personal + "<" + emailAddr + ">";
					mailAddr += ";" + compositeto;
				}
				mailAddr = mailAddr.substring(1);
			}
		} else {
			throw new Exception("错误的电子邮件类型!");
		}
		return mailAddr;
	}

	/**
	 * 　*　获得邮件主题 　
	 */
	public String getSubject() throws MessagingException {
		String subject = "";
		try {
			subject = MimeUtility.decodeText(mimeMessage.getSubject());
			if (subject == null) {
				subject = "";
			}
		} catch (Exception exce) {
			exce.printStackTrace();
		}
		return subject;
	}

	/**
	 * 　*　获得邮件发送日期 　
	 */
	public Date getSentDate() throws Exception {
		Date sentDate = mimeMessage.getSentDate();
		return sentDate;
	}


	/**
	 * 获取邮件接收时间
	 * @return
	 * @throws Exception
	 */
	public Date getReceiveDate() throws Exception {
		Date receiveDate = mimeMessage.getReceivedDate();
		return receiveDate;
	}


	/**
	 * 　*　获得邮件正文内容 　
	 */
	public String getBodyText() {
		return bodyText.toString();
	}

	/**
	 * 　　*　解析邮件，把得到的邮件内容保存到一个StringBuffer对象中，解析邮件
	 * 　　*　主要是根据MimeType类型的不同执行不同的操作，一步一步的解析 　　
	 */

	public void getMailContent(Part part) throws Exception {

		String contentType = part.getContentType();
		// 获得邮件的MimeType类型
		logger.info("邮件的MimeType类型: " + contentType);
		int nameIndex = contentType.indexOf("name");
		boolean conName = false;

		if (nameIndex != -1) {
			conName = true;
		}

		logger.info("邮件内容的类型:　" + contentType);
		if (part.isMimeType("text/plain") && conName == false) {
			// text/plain 类型
			bodyText.append((String) part.getContent());
		} else if (part.isMimeType("text/html") && conName == false) {
			// text/html 类型
			bodyHtml.append((String) part.getContent());
		} else if (part.isMimeType("multipart/*")) {
			// multipart/*
			Multipart multipart = (Multipart) part.getContent();
			int counts = multipart.getCount();
			for (int i = 0; i < counts; i++) {
				getMailContent(multipart.getBodyPart(i));
			}
		} else if (part.isMimeType("message/rfc822")) {
			// message/rfc822
			getMailContent((Part) part.getContent());
		} else {

		}
	}

	/**
	 * 　　*　判断此邮件是否需要回执，如果需要回执返回"true",否则返回"false" 　
	 */
	public boolean getReplySign() throws MessagingException {

		boolean replySign = false;

		String needReply[] = mimeMessage
				.getHeader("Disposition-Notification-To");

		if (needReply != null) {
			replySign = true;
		}

		return replySign;
	}

	/**
	 *　获得此邮件的Message-ID 　　
	 */
	public String getMessageId() throws MessagingException {
		String messageID = mimeMessage.getMessageID();
		System.out.println("邮件ID: " + messageID);
		return messageID;
	}

	/**
	 * 判断此邮件是否已读，如果未读返回false,反之返回true
	 */
	public boolean isNew() throws MessagingException {
		boolean isNew = false;
		Flags flags = ((Message) mimeMessage).getFlags();
		Flags.Flag[] flag = flags.getSystemFlags();
		for (int i = 0; i < flag.length; i++) {
			if (flag[i] == Flags.Flag.SEEN) {
				isNew = true;
				// break;
			}
		}
		return isNew;
	}

	/**
	 * 判断此邮件是否包含附件
	 */
	public boolean isContainAttach(Part part) throws Exception {
		boolean attachFlag = false;
		// String contentType = part.getContentType();
		if (part.isMimeType("multipart/*")) {
			Multipart mp = (Multipart) part.getContent();
			for (int i = 0; i < mp.getCount(); i++) {
				BodyPart mPart = mp.getBodyPart(i);
				String disposition = mPart.getDisposition();
				if ((disposition != null)
						&& ((disposition.equals(Part.ATTACHMENT)) || (disposition
								.equals(Part.INLINE))))
					attachFlag = true;
				else if (mPart.isMimeType("multipart/*")) {
					attachFlag = isContainAttach((Part) mPart);
				} else {
					String conType = mPart.getContentType();

					if (conType.toLowerCase().indexOf("application") != -1)
						attachFlag = true;
					if (conType.toLowerCase().indexOf("name") != -1)
						attachFlag = true;
				}
			}
		} else if (part.isMimeType("message/rfc822")) {
			attachFlag = isContainAttach((Part) part.getContent());
		}
		return attachFlag;
	}

	/**
	 * 　*　保存附件 　
	 */

	public void saveAttachMent(Part part) throws Exception {
		String fileName = "";
		if (part.isMimeType("multipart/*")) {
			Multipart mp = (Multipart) part.getContent();
			for (int i = 0; i < mp.getCount(); i++) {
				BodyPart mPart = mp.getBodyPart(i);
				String disposition = mPart.getDisposition();
				if ((disposition != null)
						&& ((disposition.equals(Part.ATTACHMENT)) || (disposition
								.equals(Part.INLINE)))) {
					fileName = mPart.getFileName();
					if (fileName.toLowerCase().indexOf("gb2312") != -1 ||  fileName.toLowerCase().indexOf("gbk") != -1) {
						fileName = MimeUtility.decodeText(fileName);
					}
					saveFile(fileName, mPart.getInputStream());
				} else if (mPart.isMimeType("multipart/*")) {
					saveAttachMent(mPart);
				} else {
					fileName = mPart.getFileName();
					if ((fileName != null)
							&& (fileName.toLowerCase().indexOf("GB2312") != -1 || fileName.toLowerCase().indexOf("gbk") != -1)) {
						fileName = MimeUtility.decodeText(fileName);
						saveFile(fileName, mPart.getInputStream());
					}
				}
			}
		} else if (part.isMimeType("message/rfc822")) {
			saveAttachMent((Part) part.getContent());
		}
	}

	/**
	 * 　*　设置日期显示格式 　
	 */
	public void setDateFormat(String format) throws Exception {
		this.dateFormat = format;
	}



	/**
	 * 　*　真正的保存附件到指定目录里 　
	 */
	private void saveFile(String fileName, InputStream in) throws Exception {
		attachMap.put(fileName,in);
	}


}