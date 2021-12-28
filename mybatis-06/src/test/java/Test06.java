import com.kuang.dao.StudentMapper;
import com.kuang.dao.TeacherMapper;
import com.kuang.pojo.Student;
import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test06 {
	public static void main(String[] args) {
		SqlSession sqlSession = MybatisUtils.getSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		Teacher teacher = mapper.getTeacher(1);
		System.out.println(teacher);
		sqlSession.close();
	}
	@Test
	public void testStudent(){
		SqlSession sqlSession = MybatisUtils.getSession();
		//实例化mapper获取sqlSession连接
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> students = studentMapper.getStudent2();
		for (Student student : students) {
			System.out.println(student);
		}
//		TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
//		Teacher teacher = teacherMapper.getTeacher(1);
//		System.out.println(teacher);
	}
}
