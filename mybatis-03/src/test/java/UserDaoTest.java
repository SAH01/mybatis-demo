import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.kuang.*;
import java.util.HashMap;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
	static Logger logger = Logger.getLogger(UserDaoTest.class);
	@Test
	public void test(){
		//sqlSession对象相当于是一个JDBC的PreparedStatement对象,这个对象可以执行sql语句
		//我们现在做的事情就是：获取数据库连接，得到sqlSession对象，通过这个对象去实现我们定义的数据操作接口
		//UserMapper，这个接口再通过解析我们定义的userMapper.xml文件去执行带有SQL语句的特定方法。
		SqlSession sqlSession = MybatisUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		//根据ID取
		User user=mapper.getUserByID(2);
		System.out.println(user);
		sqlSession.close();
		//更新一条数据 id为1
//		updateUser();
		//删除一个用户
//		deleteUser();
	}
	@Test
	public void testLog4j(){
		logger.info("info：进入selectUser方法");
		logger.debug("debug：进入selectUser方法");
		logger.error("error: 进入selectUser方法");
		SqlSession session = MybatisUtils.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> userList= mapper.selectUser();
		for (User user: userList){
			System.out.println(user);
		}
		session.close();
	}
}

