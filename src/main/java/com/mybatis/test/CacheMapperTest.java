package com.mybatis.test;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @ClassName CacheMapperTest
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-2-13 13:45
 **/
public class CacheMapperTest extends BaseMapperTest {
	@Test
	public void testCache(){
		SqlSession sqlSession = getSqlSession();
		SysUser sysUser = null;
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			sysUser = mapper.selectById(1L);
			sysUser.setUserName("user_test");
			SysUser newSysUser = mapper.selectById(1L);
			Assert.assertEquals(sysUser,newSysUser);
		} finally {
			sqlSession.close();
		}

		sqlSession = getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser2 = mapper.selectById(1L);
			sysUser2.setUserName("aa");
			SysUser sysUser3 = mapper.selectById(1L);
			System.out.println(sysUser);
			System.out.println(sysUser2);
			System.out.println(sysUser3);
		} finally {
			sqlSession.close();
		}
	}

}
