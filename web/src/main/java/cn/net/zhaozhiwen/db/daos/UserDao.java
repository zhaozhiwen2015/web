package cn.net.zhaozhiwen.db.daos;

import cn.net.zhaozhiwen.common.springdatajpa.ext.MyRepository;
import cn.net.zhaozhiwen.db.entities.User;

/**
 * 继承JpaRepository
 * @author zhaozhiwen
 *
 */
public interface UserDao extends MyRepository<User, Integer> {

	
}
