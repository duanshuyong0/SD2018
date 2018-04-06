package com.dsy.dadui.common.beans;

/**
 * 分页查询基类
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
public class PageParam extends Entity {

	private static final long serialVersionUID = -8330572849406309226L;

	/** 查询页 */
	private Integer page = Integer.valueOf(1);

	/** 一页条数 */
	private Integer size = Integer.valueOf(10);

	/** 查询关键字 */
	private String keyword;

	/** 是否分页 */
	private Boolean paging = Boolean.TRUE;

	/** 查询起始行数 */
	private Integer offset = Integer.valueOf(0);

	/** order by */
	private String orderByClause;

	public Integer getPage() {
		return this.page;
	}

	public Integer getSize() {
		return this.size;
	}

	public void setPage(Integer page) {
		if ((page == null) || (page.intValue() < 1)) {
			page = Integer.valueOf(1);
		}
		this.page = page;
	}

	public void setSize(Integer size) {
		if ((size == null) || (size.intValue() < 1) || (size.intValue() > 1000)) {
			size = Integer.valueOf(10);
		}
		this.size = size;
	}

	public Integer getOffset() {
		this.offset = Integer.valueOf((this.page.intValue() - 1) * this.size.intValue());
		return this.offset;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Boolean getPaging() {
		return this.paging;
	}

	public void setPaging(Boolean paging) {
		this.paging = paging;
	}

	public void setQ(String q) {
		setKeyword(q);
	}

	public String getQ() {
		return getKeyword();
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 设置查询分页参数
	 * 
	 * @param queryParam
	 */
	public void setQueryParam(QueryParam queryParam) {
		if (null != queryParam) {
			setKeyword(queryParam.getKeyword());
			setPage(queryParam.getPage());
			setPaging(queryParam.getPaging());
			setSize(queryParam.getSize());
		}
	}
}
