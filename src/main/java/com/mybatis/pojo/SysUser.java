package com.mybatis.pojo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SysUser
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-2-10 17:18
 **/
public class SysUser implements Serializable {
	private long id;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userInfo;
	private byte[] headImg;
	private Date createTime;
	private List<SysRole> roleList;

	public SysUser(){
	}

	public SysUser(long id, String userName, String userPassword, String userEmail, String userInfo, byte[] headImg, Date createTime) {
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userInfo = userInfo;
		this.headImg = headImg;
		this.createTime = createTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public byte[] getHeadImg() {
		return headImg;
	}

	public void setHeadImg(byte[] headImg) {
		this.headImg = headImg;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "SysUser{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", userPassword='" + userPassword + '\'' +
				", userEmail='" + userEmail + '\'' +
				", userInfo='" + userInfo + '\'' +
				", headImg=" + Arrays.toString(headImg) +
				", createTime=" + createTime +
				'}';
	}
}
