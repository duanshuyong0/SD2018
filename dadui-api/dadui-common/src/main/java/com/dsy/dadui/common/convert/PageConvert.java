package com.dsy.dadui.common.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.dsy.dadui.common.beans.Page;

/**
 * 分页转化
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
public class PageConvert<S, T> {

	private Page<S> paging;

	private Page<T> result;

	private Class<T> clazz;

	public PageConvert(Page<S> paging, Class<T> clazz) {
		this.paging = paging;
		this.clazz = clazz;
		if (paging != null) {
			result = new Page<T>();
			result.setKeyword(paging.getKeyword());
			result.setPage(paging.getPage());
			result.setPaging(paging.getPaging());
			result.setSize(paging.getSize());
			result.setTotalCount(paging.getTotalCount());
		}
	}

	protected void fill(S source, T target) throws Exception {

	}

	public Page<T> get() {
		return this.result;
	}

	public Page<T> convert() {
		if (this.paging == null || CollectionUtils.isEmpty(this.paging.getRecords())) {
			return this.result;
		}
		T targetBean = null;
		try {
			for (S bean : paging.getRecords()) {
				targetBean = clazz.newInstance();
				BeanUtils.copyProperties(bean, targetBean);
				this.result.getRecords().add(targetBean);
			}
		} catch (Exception e) {
			throw new RuntimeException("分页转化出错");
		}

		return this.result;
	}

}
