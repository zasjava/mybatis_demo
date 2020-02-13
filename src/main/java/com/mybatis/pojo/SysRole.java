package com.mybatis.pojo;

import com.mybatis.typeEnum.Enabled;

import java.util.Date;

/**
 * @ClassName SysRole
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-2-10 17:27
 **/
public class SysRole {
	private long id;
	private String roleName;
	private Enabled enabled;
	private long createBy;
	private Date createTime;

	public SysRole() {
	}

	public SysRole(long id, String roleName, Enabled enabled, long createBy, Date createTime) {
		this.id = id;
		this.roleName = roleName;
		this.enabled = enabled;
		this.createBy = createBy;
		this.createTime = createTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Enabled getEnabled() {
		return enabled;
	}

	public void setEnabled(Enabled enabled) {
		this.enabled = enabled;
	}

	public long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SysRole{" +
				"id=" + id +
				", roleName='" + roleName + '\'' +
				", enabled=" + enabled +
				", createBy=" + createBy +
				", createTime=" + createTime +
				'}';
	}
}
