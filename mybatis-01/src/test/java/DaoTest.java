import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.omg.CORBA.OBJ_ADAPTER;

import javax.swing.text.Keymap;
import java.sql.SQLData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoTest {
	@Test
	public void test(){
		//sqlSession对象相当于是一个JDBC的PreparedStatement对象,这个对象可以执行sql语句
		//我们现在做的事情就是：获取数据库连接，得到sqlSession对象，通过这个对象去实现我们定义的数据操作接口
		//UserMapper，这个接口再通过解析我们定义的userMapper.xml文件去执行带有SQL语句的特定方法。
		SqlSession sqlSession = MybatisUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = mapper.getUserList();
		for (User user : userList)
		{
			System.out.println(user);
		}
		//根据ID取
		/*User user=mapper.getUserByID(1);
		System.out.println(user);
		sqlSession.close();*/
		//更新一条数据 id为1
//		updateUser();
		//删除一个用户
//		deleteUser();
	}
	public void addUser(){
		SqlSession sqlSession = MybatisUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		//插入一条数据
		User user = new User(4, "名字", "密码");
		int res = mapper.addUser(user);
		if (res>0){
			System.out.println("插入成功！");
		}
		//提交事务
		sqlSession.commit();
		sqlSession.close();
	}
	public void updateUser(){
		//获得连接coon和执行sql语句的对象 类似JDBC的PreparedStatement
		SqlSession sqlSession = MybatisUtils.getSession();
		//实现UserMapper接口 通过反射机制
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User(1, "修改后的名字", "resetpass01");
		userMapper.updateUser(user);
		sqlSession.commit();
		sqlSession.close();
	}

	public void deleteUser(){
		//获取连接
		SqlSession sqlSession = MybatisUtils.getSession();
		//实现接口
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//实现接口后的mapper调用自己的方法执行sql语句
		userMapper.deleteUser(new User(1,"sss","123"));
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void addUser2(){
		SqlSession sqlSession = MybatisUtils.getSession();
		//sqlSession获取mapper
		UserMapper mapper= sqlSession.getMapper(UserMapper.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid",7);
		map.put("username","hello1");
		map.put("password","1234567");
		mapper.addUser2(map);
		sqlSession.commit();
		sqlSession.close();
	}
}
