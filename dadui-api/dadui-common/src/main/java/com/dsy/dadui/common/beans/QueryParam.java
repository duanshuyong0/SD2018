package com.dsy.dadui.common.beans;

/**
 * 查询参数接收对象
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
public class QueryParam extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2549447200076711584L;

	/** 查询页 */
	private Integer page = Integer.valueOf(1);

	/** 一页条数 */
	private Integer size = Integer.valueOf(10);

	/** 查询关键字 */
	private String keyword;

	/** 是否分页 */
	private Boolean paging = Boolean.FALSE;
	
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private String sign;

    private String time;
    

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Boolean getPaging() {
		return paging;
	}

	public void setPaging(Boolean paging) {
		this.paging = paging;
	}

}
