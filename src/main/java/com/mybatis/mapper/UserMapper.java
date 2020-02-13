package com.mybatis.mapper;

import com.mybatis.pojo.SysRole;
import com.mybatis.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-2-10 18:13
 **/
public interface UserMapper {
	SysUser selectById(long id);
	List<SysUser> selectAll();
	List<SysRole> selectRolesByUserId(long userId);
	int insert(SysUser sysUser);
	int updateById(SysUser sysUser);
	int deleteById(long id);
	List<SysUser> selectByUser(SysUser sysUser);
	List<SysUser> selectByIdList(List<Long> idList);
	int updateByMap(Map map);
	List<SysUser> selectUserAndRole();
	void selectUserById(SysUser sysUser);
	void selectUserPage(Map<String,Object> params);
	int insertUserAndRoles(@Param("user")SysUser sysUser,@Param("roleIds")String roleIds);
	int deleteUserById(Long id);
}
