package com.mybatis.mapper;

import java.util.List;

import com.mybatis.po.User;

/**
 * 动态代理方式  对用户进行增删改查
 * 
 * @author Administrator
 *
 */
public interface UserMapper {
   //根据id查询用户信息
   public User getUserById(int  id);
   //查询所有用户
   public List<User>  getUserAll();
   //根据用于姓名模糊查询
   public List<User> queryUserLikeByName(String userName);
   //根据用户id删除用户信息
   public void deleteUserByUserId(int id);
   //新增用户信息
   public void saveUserInfo(User user);
   //根据用户id更新用户信息
   public void updateUserInfoByUserId(User user);
	
}
