package com.mybatis.test;

import com.mybatis.mapper.RoleMapper;
import com.mybatis.mapper.UserMapper;
import com.mybatis.mapper.proxy.MyMapperProxy;
import com.mybatis.pojo.SysPrivilege;
import com.mybatis.pojo.SysRole;
import com.mybatis.pojo.SysUser;
import com.mybatis.typeEnum.Enabled;
import netscape.security.Privilege;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;

import javax.management.relation.Role;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * @ClassName CountryMapperTest
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-2-10 13:00
 **/
public class CountryMapperTest extends BaseMapperTest {

	@Test
	public void testSelectAll(){
		SqlSession sqlSession = getSqlSession();
		try {
			List<SysUser> sysUserList = sqlSession.selectList("com.mybatis.mapper.UserMapper.selectAll");
			printCountryList(sysUserList);
		} finally {
			sqlSession.close();
		}

	}

	@Test
	public void testSelectById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = mapper.selectById((long) 1001);
			Assert.assertNotNull(sysUser);
			Assert.assertEquals("admin",sysUser.getUserName());
		}finally {
			sqlSession.close();
		}
	}

	@Test
	public void testSelectAllUser(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> sysUserList = mapper.selectAll();
			Assert.assertNotNull(sysUserList);
			Assert.assertTrue(sysUserList.size()>0);
		}finally {
			sqlSession.close();
		}
	}

	@Test
	public void testSelectRolesByUserId(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<SysRole> sysRoles = mapper.selectRolesByUserId(1);
			Assert.assertNotNull(sysRoles);
			Assert.assertTrue(sysRoles.size()>0);
		}finally {
			sqlSession.close();
		}
	}

	@Test
	public void insert(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@qq.com");
			user.setUserInfo("test info");
			user.setHeadImg( new byte[]{1,2,3});
			user.setCreateTime(new Date());
			int result = mapper.insert(user);
			Assert.assertEquals(1,result);
			Assert.assertNotNull(result);
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}

	@Test
	public void testUpdateById(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = mapper.selectById(1);
			Assert.assertEquals("admin",sysUser.getUserName());
			sysUser.setUserName("admin_test");
			int result = mapper.updateById(sysUser);
			Assert.assertEquals(1,result);
			Assert.assertNotNull(result);
			Assert.assertEquals("admin_test",sysUser.getUserName());
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	@Test
	public void deleteById(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			int result = mapper.deleteById(1);
			Assert.assertEquals(1,result);
			Assert.assertNotNull(result);
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	@Test
	public void testSelectById2() {
		SqlSession sqlSession = getSqlSession();
		try {
			MyMapperProxy myMapperProxy = new MyMapperProxy(UserMapper.class, sqlSession);
			UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{UserMapper.class}, myMapperProxy);
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = mapper.selectById((long) 1);
			Assert.assertNotNull(sysUser);
			Assert.assertEquals("admin_test",sysUser.getUserName());
		}finally {
			sqlSession.close();
		}
	}

	@Test
	public void insertRole(){
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
			SysRole user = new SysRole();
			user.setCreateTime(new Date());
			user.setCreateBy(1);
			user.setEnabled(Enabled.enabled);
			user.setRoleName("aa");
			mapper.insert4(user);
			System.out.println(user);
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	@Test
	public void deleteRoleById(){
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
			mapper.deleteRoleById(19);
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}

	@Test
	public void testSelectPrivilegeById(){
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
			SysPrivilege privilege = mapper.selectById((long) 1);
			System.out.println(privilege);
		}finally {
			sqlSession.close();
		}
	}

	@Test
	public void testSelectByUser(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			SysUser query = new SysUser();
			query.setUserEmail("test@mybatis.tk");
			List<SysUser> sysUserList = mapper.selectByUser(query);
			for (SysUser sysUser : sysUserList) {
				System.out.println(sysUser);
			}
		}finally {
			sqlSession.close();
		}
	}
	@Test
	public void testSelectByIdList(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<Long> idList = new ArrayList<>();
			idList.add(1L);
			idList.add(1001L);
			List<SysUser> sysUserList = mapper.selectByIdList(idList);
			for (SysUser sysUser :sysUserList) {
				System.out.println(sysUser);
			}
		}finally {
			sqlSession.close();
		}
	}

	@Test
	public void testUpdateByMap(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			Map map = new HashMap();
			map.put("id", 1L);
			map.put("user_email", "test@mybatis.ck");
			map.put("user_password", "123456789");
			mapper.updateByMap(map);
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}

	@Test
	public void testSelectUserAndRoleById(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> sysUserList = mapper.selectUserAndRole();
			for (SysUser sysUser : sysUserList) {
				System.out.println(sysUser);
			}
		}finally {
			sqlSession.close();
		}
	}

	@Test
	public void testSelectUserByID(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setId(1L);
			mapper.selectUserById(sysUser);
			System.out.println(sysUser);
		}finally {
			sqlSession.close();
		}
	}
	@Test
	public void testSelectUserPage(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			Map<String, Object> params = new HashMap<>();
			params.put("userName", "ad");
			params.put("offset", 0);
			params.put("limit", 10);
			mapper.selectUserPage(params);
		}finally {
			sqlSession.close();
		}
	}
	@Test
	public void testInsertAndDelete(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUserName("test1");
			sysUser.setUserPassword("123456");
			sysUser.setUserEmail("test@mybatis.tck");
			sysUser.setUserInfo("test info");
			sysUser.setHeadImg(new byte[]{1,2,3});
			mapper.insertUserAndRoles(sysUser, "1,2");
			sqlSession.commit();
			mapper.deleteUserById(sysUser.getId());
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	@Test
	public void testUpdateRoleById(){
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
			SysRole sysRole = mapper.selectRoleById(2L);
			Assert.assertEquals(Enabled.enabled,sysRole.getEnabled());
			sysRole.setEnabled(Enabled.enabled);
		}finally {
			sqlSession.close();
		}
	}
	private void printCountryList(List<SysUser> sysUserList) {
		for (Object obj:sysUserList) {
			System.out.println(obj);
		}
	}

}
