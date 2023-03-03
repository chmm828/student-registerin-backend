package com.server.mapper;

import com.github.pagehelper.Page;
import com.server.entity.Major;
import com.server.entity.Mallpersonnel;
import com.server.entity.Student;

import java.util.List;

public interface StudentMapper {
    /**
     * 分页查询 学生信息
     * @param queryString 分页查询字符串
     * @return 返回分页数据
     */
    Page<Student> findPage(String queryString);

    /**
     * 根据用户名获取用户对象
     * @param username
     * @return
     */
    Student findByUserName(String username);

    /**
     * 添加班级信息
     * @param student 学生数据
     */
    void insert(Student student);

    /**
     * 修改班级信息
     * @param student 学生数据
     */
    void update(Student student);

    /**
     * 修改班级信息是否展示
     * @param student 学生数据
     */
    void updateShow(Student student);
    /**
     * 删除班级数据(软删除）
     * @param student
     */
    void delete(Student student);

    /**
     * 获取个人信息
     */
    List<Student> getStudentInfo(String studentId);
}
