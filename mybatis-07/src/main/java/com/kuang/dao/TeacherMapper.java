package com.kuang.dao;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
	//获取老师
	List<Teacher> getTeacher1();
	//获取指定老师下的所有学生以及老师的信息
	public Teacher getTeacher2(int id);
}
