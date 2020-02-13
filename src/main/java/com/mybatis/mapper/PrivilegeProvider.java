package com.mybatis.mapper;

import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName PrivilegeMapper
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-2-11 17:43
 **/
public class PrivilegeProvider {
	public String selectById(final Long id){
		return new SQL(){
			{
				SELECT("id,privilege_name privilegeName,privilege_url privilegeUrl");
				FROM("sys_privilege");
				WHERE("id = #{id}");
			}
		}.toString();
	}
}
