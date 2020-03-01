package com.mybatis.mapper;

import com.mybatis.pojo.SysPrivilege;
import com.mybatis.pojo.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName R
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-2-11 11:30
 **/
public interface RoleMapper {
	@Insert({
			"insert into sys_role(role_name,enabled,create_by,create_time)values(#{roleName},#{enabled},#{createBy},#{createTime ,jdbcType=TIMESTAMP})"
	})
	@SelectKey(statement = "SELECT LAST_INSERT_ID()",
			keyProperty = "id",
			resultType = long.class,
			before = false
	)
	int insert4(SysRole sysRole);

	@Insert({
			"insert into sys_role(role_name,enabled,create_by,create_time)values(#{roleName},#{enabled},#{createBy},#{createTime ,jdbcType=TIMESTAMP})"
	})
	 @Options(useGeneratedKeys = true,keyProperty = "id")
	int insert2(SysRole sysRole);

	@Insert({
			"insert into sys_role(id,role_name,enabled,create_by,create_time)values(#{id},#{roleName},#{enabled},#{createBy},#{createTime ,jdbcType=TIMESTAMP})"
	})
	@Options(useGeneratedKeys = true,keyProperty = "id")
	int insert3(SysRole sysRole);

	@Select({
		"select * from sys_role "
	})
	public List<SysRole> selectAll();

	@Delete({
			"delete from sys_role where id = #{id}"
	})
	void deleteRoleById(@Param("id") long id);

	@Update({
			"update sys_role set" +
					" role_name = #{roleName}," +
					"enabled =#{enabled}," +
					"create_by = #{createBy}," +
					"create_time = #{createTime,jdbcType=TIMESTAMP}" +
					"where id = #{id}"
	})
	int updateById(SysRole sysRole);

	@SelectProvider(type = PrivilegeProvider.class,method = "selectById")
	SysPrivilege selectById(Long id);
	@Select("select * from sys_role where id =#{id}")
	SysRole selectRoleById(Long id);
}
