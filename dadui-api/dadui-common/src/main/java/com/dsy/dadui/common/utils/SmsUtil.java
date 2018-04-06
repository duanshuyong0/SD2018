package com.dsy.dadui.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 短信发送工具类
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
public abstract class SmsUtil {

	private static Map<Long, String> MESSAGE_MAP = new HashMap<Long, String>();
	static {
		MESSAGE_MAP.put(-1L, "用户名或者密码不正确.");
		MESSAGE_MAP.put(-2L, "必填选项为空.");
		MESSAGE_MAP.put(-4L, "0个有效号码.");
		MESSAGE_MAP.put(-5L, "余额不够.");
		MESSAGE_MAP.put(-10L, "用户被禁用.");
		MESSAGE_MAP.put(-11L, "短信内容超过500个字.");
		MESSAGE_MAP.put(-13L, "IP校验出错.");
	}

	private static final String username = "clylxwl";
	private static final String password = "10ha5fdf";
	private static final String smsUrl = "http://sms-cly.cn/smsSend.do?";

	/**
	 * 短信发送
	 */
	public static boolean send(String mobile, String content) {
		String pwd = EncryptUtil.md5(username + EncryptUtil.md5(password));
		String result = "";
		// http://202.104.102.54:6688/smsSend.do?

		BufferedReader in = null;
		StringBuffer sb = new StringBuffer(smsUrl);
		sb.append("username=" + username);
		sb.append("&password=" + pwd);
		sb.append("&msgid=" + CommonKeyUtil.genUniqueKey());
		sb.append("&mobile=" + mobile);
		try {
			sb.append("&content=" + URLEncoder.encode(content, "utf-8"));
			sb.append("&dstime=");
			URL url = new URL(sb.toString());
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.connect();
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line + "\n";
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}

		result = result.trim();
		long status = Long.parseLong(result);
		if (status > 0) {
			return true;
		}
		String message = MESSAGE_MAP.get(status);
		if (message == null) {
			throw new RuntimeException("未知错误[" + status + "].");
		}
		throw new RuntimeException("短信发送出错");
	}
}
