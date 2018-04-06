package com.dsy.dadui.common.utils.captcha;

import com.octo.captcha.image.ImageCaptcha;

public interface CaptchaEngine {

	void initialFactories();

	void setWidth(int width);

	void setHeight(int height);

	ImageCaptcha getNextImageCaptcha();
}
