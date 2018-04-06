package com.dsy.dadui.common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

/**
 * Redis error handler
 *
 * @author <a href="mailto:taojiagui@59store.com">云启</a>
 * @version 1.0 2016年9月27日
 * @since 1.0
 */
public class RedisCommonErrorHandler implements CacheErrorHandler {

	private static Logger logger = LoggerFactory.getLogger(RedisCommonErrorHandler.class);

	@Override
	public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
		logger.error("cache get error: {}", exception.getMessage());
	}

	@Override
	public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
		logger.error("cache put error: {}", exception.getMessage());
	}

	@Override
	public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
		logger.error("cache evict error: {}", exception.getMessage());
	}

	@Override
	public void handleCacheClearError(RuntimeException exception, Cache cache) {
		logger.error("cache clear error: {}", exception.getMessage());
	}
}
