package com.dsy.dadui.common.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 分页对象
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
public class Page<T> extends PageParam {

	private static final long serialVersionUID = -4823821284451323361L;
	private List<T> records = new ArrayList<T>();

	private Integer totalCount = Integer.valueOf(0);

	private Integer totalPages = Integer.valueOf(1);

	public Page() {
	}

	public Page(PageParam param) {
		if (param != null) {
			setKeyword(param.getKeyword());
			setPage(param.getPage());
			setPaging(param.getPaging());
			setSize(param.getSize());
		}
	}

	public List<T> getRecords() {
		return this.records;
	}

	public Integer getTotalCount() {
		return this.totalCount;
	}

	public Integer getTotalPages() {
		return this.totalPages;
	}

	public void setRecords(List<T> records) {
		if (records == null) {
			records = Collections.emptyList();
		}
		this.records = records;
	}

	public void setTotalCount(Integer totalCount) {
		if ((totalCount == null) || (totalCount.intValue() < 0)) {
			totalCount = Integer.valueOf(0);
		}
		this.totalCount = totalCount;
		setTotalPages(Integer.valueOf(this.totalCount.intValue() / getSize().intValue()
				+ (this.totalCount.intValue() % getSize().intValue() == 0 ? 0 : 1)));
	}

	public void setTotalPages(Integer totalPages) {
		if ((totalPages == null) || (totalPages.intValue() < 0)) {
			totalPages = Integer.valueOf(0);
		}
		this.totalPages = totalPages;
	}
}
