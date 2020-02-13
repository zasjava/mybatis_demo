package com.mybatis.mapper.proxy;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @ClassName MyMapperProxy
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-2-11 9:44
 **/
public class MyMapperProxy<T> implements InvocationHandler {
	private Class<T> mapperInterface;
	private SqlSession sqlSession;

	public MyMapperProxy(Class<T> mapperInterface, SqlSession sqlSession) {
		this.mapperInterface = mapperInterface;
		this.sqlSession = sqlSession;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		List<T> lists = sqlSession.selectList(mapperInterface.getCanonicalName() + "." + method.getName());
		return lists;
	}
}
