package com.hello.spring;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2023/9/2 22:22
 */
class UserServiceProxy extends UserService {
	UserService target;

	public void test() {
		// Spring事务切面逻辑
		// @Transactional
		// 开启Spring事务
		//利用事务管理器 DataSource对象 新建一个数据库连接conn ThreadLocal<Map<DataSource对象，conn>>
		// conn.autocommit=false
		// target,test() // UerService普通对象,test() jdbcTemplate 执行sql1Isql2
		// conn.rollback() conn.commit()
	}
}


