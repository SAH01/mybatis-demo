import com.kuang.dao.TeacherMapper;
import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test07 {
	public static void main(String[] args) {

	}
	@Test
	public void test(){
		SqlSession sqlSession = MybatisUtils.getSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		List<Teacher> teacher = mapper.getTeacher1();
		System.out.println(teacher);
	}
	@Test
	public void testGetTeacher(){
		SqlSession session = MybatisUtils.getSession();
		TeacherMapper mapper = session.getMapper(TeacherMapper.class);
		Teacher teacher = mapper.getTeacher2(1);
		System.out.println(teacher.getName());
		System.out.println(teacher.getStudents());
	}
}

