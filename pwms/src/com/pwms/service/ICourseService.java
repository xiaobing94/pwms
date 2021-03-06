package com.pwms.service;

import com.pwms.pojo.CoureseGroup;
import com.pwms.pojo.Course;
import com.pwms.pojo.UserCourseRecord;

public interface ICourseService {
	//获取实体
	public Course getCourse(Integer id);
	//保存对象
	public void save(Course course);
	//更新对象
	public void updateById(Course course);
	//添加课程到组
	public void addGroup(CoureseGroup group, Course course);
	//上课记录,如果有这个记录，那么久更新记录，始终保存最新的上课记录
	public void addRecord(Course course, UserCourseRecord record);
}
