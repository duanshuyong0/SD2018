package com.dsy.dadui.pc.web.utils;

import com.dsy.dadui.common.utils.DecimalUtil;
import com.dsy.dadui.pc.web.constants.Constant;

/**
 * 金额转换
 * 
 * <pre>
 * 说明：
 * 1.元转化为分
 * 2.分转化为元
 * 
 * </pre>
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年10月23日
 * @since 1.0
 */
public class AmountConvertUtil {

	private AmountConvertUtil() {

	}

	/**
	 * 元转化为分
	 * 
	 * <pre>
	 * 说明：
	 * 金额传入值最多小数点后两位
	 * 一般应用场景将前端传入的金额转化为分持久化
	 * 
	 * </pre>
	 * 
	 * @author taojiagui(云启)
	 * @time 下午1:32:59
	 * @param amount
	 * @return
	 */
	public static Long yuan2fen(Double amount) {
		if (amount == null) {
			return 0l;
		}
		double fen = DecimalUtil.multiply(amount, Constant.YUAN2FEN_MULTIPLE);
		return Double.valueOf(fen).longValue();
	}

	/**
	 * 分转化为元
	 * 
	 * <pre>
	 * 说明：
	 * 1.一般应用场景：后端金额需要在前端显示
	 * 
	 * </pre>
	 * 
	 * @author taojiagui(云启)
	 * @time 下午1:36:46
	 * @param amount
	 * @return
	 */
	public static double fen2yuan(Long amount) {
		if (amount == null) {
			return 0d;
		}

		return DecimalUtil.divide(amount, Constant.YUAN2FEN_MULTIPLE, Constant.AMOUNT_SCALE);
	}
}
