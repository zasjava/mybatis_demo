package com.mybatis.pojo;

/**
 * @ClassName SysRolePrivilege
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-2-10 17:34
 **/
public class SysRolePrivilege {
	private long roleId;
	private long privilegeId;

	public SysRolePrivilege() {
	}

	public SysRolePrivilege(long roleId, long privilegeId) {
		this.roleId = roleId;
		this.privilegeId = privilegeId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(long privilegeId) {
		this.privilegeId = privilegeId;
	}

	@Override
	public String toString() {
		return "SysRolePrivilege{" +
				"roleId=" + roleId +
				", privilegeId=" + privilegeId +
				'}';
	}
}
