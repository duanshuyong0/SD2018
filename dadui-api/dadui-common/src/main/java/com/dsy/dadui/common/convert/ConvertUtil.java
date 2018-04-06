package com.dsy.dadui.common.convert;

import java.util.List;

import com.dsy.dadui.common.beans.Page;


public class ConvertUtil {

	public static <S, T> Page<T> paging(Page<S> paging, Class<T> clazz) {
		return new PageConvert<S, T>(paging, clazz).convert();
	}
	
	public static <S, T> List<T> list(List<S> list, Class<T> clazz) {
		return new ListConvert<S, T>(list, clazz).convert();
	}
}
