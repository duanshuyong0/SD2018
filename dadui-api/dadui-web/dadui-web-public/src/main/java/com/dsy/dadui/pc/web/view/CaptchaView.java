package com.dsy.dadui.pc.web.view;

import java.awt.image.BufferedImage;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

import com.dsy.dadui.common.utils.captcha.CaptchaEngine;
import com.dsy.dadui.common.utils.captcha.CaptchaEngineImpl;
import com.dsy.dadui.common.utils.captcha.EngineFactory;
import com.dsy.dadui.pc.web.utils.CaptchaUtil;
import com.octo.captcha.image.ImageCaptcha;

/**
 * 验证码图片生成
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月20日
 * @since 1.0
 */
public class CaptchaView extends ModelAndView {

	private int width;
	private int height;
	private String captchaGroupId;
	private Class<? extends CaptchaEngine> engineClazz;

	public CaptchaView(String captchaGroupId) {
		this();
		this.captchaGroupId = captchaGroupId;
	}

	public CaptchaView() {
		this(200, 70);
	}

	public CaptchaView(int width, int height) {
		this(width, height, CaptchaEngineImpl.class);
	}

	public CaptchaView(int width, int height, Class<? extends CaptchaEngine> engineClazz) {
		super.setView(view);
		this.width = width;
		this.height = height;
		this.engineClazz = engineClazz;
	}

	public void save(HttpServletRequest request, String captchaGroupId, String code) {
		CaptchaUtil.saveSession(request, captchaGroupId, code);
	}

	private AbstractUrlBasedView view = new AbstractUrlBasedView() {
		@Override
		protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			response.setDateHeader("Expires", 0);
			// Set standard HTTP/1.1 no-cache headers.
			response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
			response.addHeader("Cache-Control", "post-check=0, pre-check=0");
			// Set standard HTTP/1.0 no-cache header.
			response.setHeader("Pragma", "no-cache");
			// return a jpeg
			response.setContentType("image/jpeg");
			// create the image with the text

			ImageCaptcha imageCaptcha = EngineFactory.getCaptchaEngine(width, height, engineClazz)
					.getNextImageCaptcha();
			String code = imageCaptcha.getTextChallenge();

			String groupId;
			if (captchaGroupId == null) {
				groupId = CaptchaUtil.getCaptchaGroupId(request);
			} else {
				groupId = captchaGroupId;
			}
			// CaptchaUtil.saveSession(request, groupId, code);

			save(request, groupId, code);
			// System.out.println("session:" + session.getId() + " code:" + code
			// + " captchaGroupId:" + captchaGroupId + " url:" +
			// request.getRequestURI());

			BufferedImage bi = imageCaptcha.getImageChallenge();
			// BufferedImage bi =
			// imageCaptchaService.getImageChallengeForID(sessionId);
			ServletOutputStream out = response.getOutputStream();
			ImageIO.write(bi, "jpg", out);
			try {
				out.flush();
			} finally {
				out.close();
			}
		}
	};

}
