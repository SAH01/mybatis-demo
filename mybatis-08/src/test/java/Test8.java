import com.kuang.mapper.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IDUtils;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Test8 {
	public static void main(String[] args) {

	}
	@Test
	public void addInitBlog(){
		SqlSession sqlSession = MybatisUtils.getSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
		Blog blog = new Blog();

		blog.setId(IDUtils.getId());
		blog.setTitle("Mybatis如此简单");
		blog.setAuthor("狂神说");
		blog.setCreateTime(new Date());
		blog.setViews(9999);
		mapper.addBlog(blog);

		blog.setId(IDUtils.getId());
		blog.setTitle("Java如此简单");
		mapper.addBlog(blog);

		blog.setId(IDUtils.getId());
		blog.setTitle("Spring如此简单");
		mapper.addBlog(blog);

		blog.setId(IDUtils.getId());
		blog.setTitle("微服务如此简单");
		mapper.addBlog(blog);

		sqlSession.commit();
		sqlSession.close();
	}


	@Test
	public void testQueryBlogIf(){
		SqlSession session = MybatisUtils.getSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("title","Spring如此简单");
		map.put("author","狂神说");
		List<Blog> blogs = mapper.queryBlogIf(map);
		System.out.println(blogs);
		session.close();
	}

	//choose
	@Test
	public void testQueryBlogChoose(){
		SqlSession session = MybatisUtils.getSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title","Java如此");
		map.put("author","狂神说");
		map.put("views",9999);
		List<Blog> blogs = mapper.queryBlogChoose(map);
		for (Blog blog : blogs) {
			System.out.println(blog.toString());
		}
		session.close();
	}

	@Test
	public void testUpdateBlog(){
		SqlSession session = MybatisUtils.getSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("title","动态SQL");
		map.put("author","秦疆");
		map.put("id","5878e7c30d1742d59f2682f1d10656b5");
		mapper.updateBlog(map);
		session.commit();
		session.close();
	}
	//
	@Test
	public void testQueryBlogForeach(){
		SqlSession session = MybatisUtils.getSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		HashMap map = new HashMap();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		map.put("ids",ids);
		List<Blog> blogs = mapper.queryBlogForeach(map);
		for (Blog blog : blogs) {
			System.out.println(blog);
		}
		session.commit();
		session.close();
	}

}
