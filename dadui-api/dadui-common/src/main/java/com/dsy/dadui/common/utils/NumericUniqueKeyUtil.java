
package com.dsy.dadui.common.utils;

import java.util.Random;

/**
 * 数字型唯一健获取工具类
 * 
 * <pre>
 * 1.主要用于订单号和店铺ID等业务场景的地方
 * 
 * </pre>
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年11月21日
 * @since 1.0
 */
public class NumericUniqueKeyUtil {

	// 2016-01-01的时间戳
	private final static long twepoch = 1451577600446L;

	// 毫秒内自增位
	private final static long sequenceBits = 12L;

	private final static long sequenceMask = -1L ^ (-1L << sequenceBits);

	private static long lastTimestamp = -1L;

	private static long sequence = 0L;

	public static Random random = new Random();

	// 随机数序列
	private final static int randBits = 16;

	private static int rand = 0;

	private static int randMask = -1 ^ (-1 << randBits);

	/**
	 * 生成主键key
	 * 
	 * 时间戳(41位) + 序列(12位) + 随机数(16位)
	 * 
	 * @author taojiagui(云启)
	 * @time 下午3:54:54
	 * @return
	 */
	public static synchronized String genUniqueKey() {
		long timestamp = timeGen();
		if (timestamp < lastTimestamp) {
			try {
				throw new Exception("Clock moved backwards.  Refusing to generate id for " + (lastTimestamp - timestamp)
						+ " milliseconds");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (lastTimestamp == timestamp) {
			// 当前毫秒内，则+1
			sequence = (sequence + 1) & sequenceMask;
			if (sequence == 0) {
				// 当前毫秒内计数满了，则等待下一秒
				timestamp = tilNextMillis(lastTimestamp);
			}

		} else {
			sequence = 0;
		}

		lastTimestamp = timestamp;

		rand = random.nextInt(randMask);

		return Long.toString((timestamp - twepoch) << 22 | sequence << 10 | rand);
	}

	private static long tilNextMillis(final long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	private static long timeGen() {
		return System.currentTimeMillis();
	}

}
