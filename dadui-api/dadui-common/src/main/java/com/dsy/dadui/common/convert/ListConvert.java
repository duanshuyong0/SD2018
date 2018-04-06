package com.dsy.dadui.common.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class ListConvert<S, T> {

	private List<S> list;

	private List<T> result;

	private Class<T> clazz;

	public ListConvert(List<S> list, Class<T> clazz) {
		this.clazz = clazz;
		this.list = list;
		if (list == null) {
		} else {
			this.result = new ArrayList<T>();
		}
	}

	protected void fill(S source, T target) {

	}

	public List<T> get() {
		return this.result;
	}

	public List<T> convert() {
		if (this.list == null || list.isEmpty()) {
			return this.result;
		}
		T targetBean = null;
		try {
			for (S bean : list) {
				targetBean = clazz.newInstance();
				BeanUtils.copyProperties(bean, targetBean);
				this.result.add(targetBean);
			}
		} catch (Exception e) {
			throw new RuntimeException("列表转化出错");
		}
		return this.result;
	}

}
