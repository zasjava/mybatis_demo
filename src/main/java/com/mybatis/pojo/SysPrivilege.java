package com.mybatis.pojo;

/**
 * @ClassName SysPrivilege
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-2-10 17:31
 **/
public class SysPrivilege {
	private long id;
	private String privilegeName;
	private String privilegeUrl;

	public SysPrivilege() {
	}

	public SysPrivilege(long id, String privilegeName, String privilegeUrl) {
		this.id = id;
		this.privilegeName = privilegeName;
		this.privilegeUrl = privilegeUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getPrivilegeUrl() {
		return privilegeUrl;
	}

	public void setPrivilegeUrl(String privilegeUrl) {
		this.privilegeUrl = privilegeUrl;
	}

	@Override
	public String toString() {
		return "SysPrivilege{" +
				"id=" + id +
				", privilegeName='" + privilegeName + '\'' +
				", privilegeUrl='" + privilegeUrl + '\'' +
				'}';
	}
}
