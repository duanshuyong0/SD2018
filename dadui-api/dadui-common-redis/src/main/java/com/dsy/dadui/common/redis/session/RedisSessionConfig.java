package com.dsy.dadui.common.redis.session;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Redis session配置
 * 
 * <pre>
 * 说明：
 * 测试环境设置默认超时时间为2个小时
 * 
 * 生产环境设置为1个小时即可
 * 
 * </pre>
 *
 * @author <a href="mailto:taojiagui@59store.com">云启</a>
 * @version 1.0 2016年9月26日
 * @since 1.0
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 7200)
public class RedisSessionConfig {

}
