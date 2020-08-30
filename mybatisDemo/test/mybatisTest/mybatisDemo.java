package mybatisTest;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.mapper.UserMapper;
import com.mybatis.po.User;

public class mybatisDemo {

	@Test
	public void  test() throws IOException {
		SqlSessionFactory  f =new SqlSessionFactoryBuilder().build
				(Resources.getResourceAsStream("sqlMapConfig.xml"));
		SqlSession openSession = f.openSession();
	  ///  List<User> selectList = openSession.selectList("test.selectUserByNameLike2","张");
		//System.out.println(selectList);
		//openSession.delete("deleteUserId",25);
		 User u =new  User();
		 u.setUsername("小宇宙111");
		 u.setSex("0");
		 u.setAddress("遨游太空");
		//openSession.update("updateUser", u);
		 //插入一条数据
		openSession.insert("inserUser",u); 
		openSession.commit(); 
	}
	
	@Test 
	public void test2() throws IOException {
	  SqlSessionFactory f = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
	   //获取动态代理方式
	   SqlSession s = f.openSession();
	  //使用动态方式查询用户
	 // UserMapper mapper = s.getMapper(UserMapper.class);
	 // User userById = mapper.getUserById(41);
	 // System.out.println(userById);
	   //查询所有用户
	   //UserMapper mapper = s.getMapper(UserMapper.class); 
	  // List<User> userAll = mapper.getUserAll();
	  // System.out.println(userAll);
	   //根据用户姓名模糊查询
	   UserMapper mapper = s.getMapper(UserMapper.class);
	   //List<User> queryUserLikeByName = mapper.queryUserLikeByName("%"+"小宇宙"+"%");
	   //System.out.println(queryUserLikeByName+"用户数量"+queryUserLikeByName.size());
	  //根据用户id查询用户信息
	  // mapper.deleteUserByUserId(44);
	  // User u =new User();
	 //  u.setUsername("星星");
//	   u.setSex("0");
//	   u.setAddress("雍和宫");
//	   mapper.saveUserInfo(u);
	   //更新用户信息
	   User userById = mapper.getUserById(45);
	   userById.setUsername("星星111");
	   userById.setAddress("雍和宫111");
	   mapper.updateUserInfoByUserId(userById);
	   s.commit();
	   
	   
		
	}
}
