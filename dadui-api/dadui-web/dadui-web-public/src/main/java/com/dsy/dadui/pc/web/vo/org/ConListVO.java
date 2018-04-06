package com.dsy.dadui.pc.web.vo.org;

import java.util.Date;
import java.util.List;

public class ConListVO {
	
	   private Integer id;

	    private Integer orgId;

	    private Byte status;
	    

	    private String createUserId;

	    private String con;

	    public String getCon() {
			return con;
		}

		public void setCon(String con) {
			this.con = con;
		}

		private String createUserOpenid;

	    private Date createTime;

	    private Date updateTime;

	    private Byte deleteTag;
	    
	    private String userId;
	    
	    private String nickname;

	    private Byte gender;

	    private String avatarUrl;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getOrgId() {
			return orgId;
		}

		public void setOrgId(Integer orgId) {
			this.orgId = orgId;
		}

		public Byte getStatus() {
			return status;
		}

		public void setStatus(Byte status) {
			this.status = status;
		}

		public String getCreateUserId() {
			return createUserId;
		}

		public void setCreateUserId(String createUserId) {
			this.createUserId = createUserId;
		}

		public String getCreateUserOpenid() {
			return createUserOpenid;
		}

		public void setCreateUserOpenid(String createUserOpenid) {
			this.createUserOpenid = createUserOpenid;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public Date getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}

		public Byte getDeleteTag() {
			return deleteTag;
		}

		public void setDeleteTag(Byte deleteTag) {
			this.deleteTag = deleteTag;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public Byte getGender() {
			return gender;
		}

		public void setGender(Byte gender) {
			this.gender = gender;
		}

		public String getAvatarUrl() {
			return avatarUrl;
		}

		public void setAvatarUrl(String avatarUrl) {
			this.avatarUrl = avatarUrl;
		}

}
