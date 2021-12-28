package com.kuang.mapper;

import com.kuang.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
	//新增一个博客
	int addBlog(Blog blog);
	List<Blog> queryBlogIf(Map map);
	List<Blog> queryBlogChoose(Map map);
	int updateBlog(Map map);
	//for each
	List<Blog> queryBlogForeach(Map map);
}
