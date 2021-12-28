package com.kuang.dao;

import com.kuang.pojo.Student;

import java.util.List;

public interface StudentMapper {
	//查询所有学生信息
	public List<Student> getStudent();
	public List<Student> getStudent2();
}
