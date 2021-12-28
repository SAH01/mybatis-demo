package com.kuang.pojo;

import lombok.Data;

@Data
public class Student {
	private int id;
	private String name;
	//每个学生只有一个老师
	private int tid;
}