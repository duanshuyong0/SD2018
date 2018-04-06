package com.dsy.dadui.common.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JSON工具工具类
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class JsonUtil {
	public final static String SHORT_DATE_PATTERN = "yyyy-MM-dd";
	public final static String LONG_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public final static String TIMSTAMP_PATTERN = "yyyy-MM-dd HH:mm:ss.SSSSSS";

	private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);
	private static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 
	 * 设定时间格式
	 * 
	 * @param pattern
	 *            时间格式
	 */
	public static void setDatePattern(final String pattern) {
		objectMapper.setDateFormat(new SimpleDateFormat(pattern, Locale.getDefault()));
	}

	/**
	 * 
	 * 把对象转化成json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJsonString(final Object obj) {
		String str = null;
		try {
			str = objectMapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			LOG.error(e.toString());
		} catch (JsonMappingException e) {
			LOG.error(e.toString());
		} catch (IOException e) {
			LOG.error(e.toString());
		}
		return str;
	}

	public static <X> X fromJsonString(final String jsonStr, final TypeReference<X> typeReference) {
		X obj = null;
		try {
			obj = objectMapper.readValue(jsonStr, typeReference);
		} catch (IOException e) {
			LOG.error(e.toString());
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * 
	 * 
	 * @param jsonStr
	 * @param clazz
	 * @return
	 */
	public static <X> X fromJsonString(final String jsonStr, final Class<X> clazz) {
		JavaType javaType = getJavaType(clazz);
		return (X) fromJsonString(jsonStr, javaType);
	}

	/**
	 * 
	 * 把Json字符串转化在对象
	 * 
	 * @param jsonStr
	 *            JOSN字符串
	 * @param javaType
	 * @return
	 */
	public static Object fromJsonString(final String jsonStr, final JavaType javaType) {
		Object obj = null;
		try {
			obj = objectMapper.readValue(jsonStr, javaType);
		} catch (IOException e) {
			LOG.error(e.toString());
			e.printStackTrace();
		}
		return obj;
	}

	public static JavaType getJavaType(final Class<?> clazz) {
		return objectMapper.getTypeFactory().constructType(clazz);
	}

	public static JavaType getCollectionJavaType(final Class<? extends Collection> collectionClass,
			final Class<?> elecmentClass) {
		return objectMapper.getTypeFactory().constructCollectionType(collectionClass, elecmentClass);
	}

	public static JavaType getCollectionJavaType(final Class<? extends Collection> collectionClass,
			final JavaType javaType) {
		return objectMapper.getTypeFactory().constructCollectionType(collectionClass, javaType);
	}

	public static JavaType getMapJavaType(final Class<? extends Map> mapClass, final Class<?> keyClass,
			final Class<?> valueClass) {
		return objectMapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
	}

	public static JavaType getMapJavaType(final Class<? extends Map> mapClass, final JavaType keyType,
			final JavaType valueType) {
		return objectMapper.getTypeFactory().constructMapType(mapClass, keyType, valueType);
	}
}
