package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	//查询全部用户
	List<User> getUserList();
	//根据ID查询用户
	User getUserByID(int id);


	//insert一个用户
	int addUser(User user);
	//万能Map插入数据
	int addUser2(Map<String,Object> map);

	//update一个用户
	int updateUser(User user);
	//delete一个用户
	int deleteUser(User user);
}
