package com.mybatis.pojo;

/**
 * @ClassName SysUserRole
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-2-10 17:22
 **/
public class SysUserRole {
	private long userId;
	private long roleId;

	public SysUserRole() {
	}

	public SysUserRole(long userId, long roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "SysUserRole{" +
				"userId=" + userId +
				", roleId=" + roleId +
				'}';
	}
}
