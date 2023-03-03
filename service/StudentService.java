package com.server.service;

import com.server.entity.Mallpersonnel;
import com.server.entity.Student;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import com.server.vo.LoginVo;
import com.server.vo.WxLoginVo;
import org.springframework.web.bind.annotation.RequestBody;

public interface StudentService {

    /**
     * 登录接口
     * @param wxLoginVo 登录参数 账号和密码
     * @return 返回Token，用token去获取资源
     */
    Result login(@RequestBody WxLoginVo wxLoginVo);

    /**
     * 获取学生个人信息接口
     *
     */

    Result getStudentInfo(String studentId);
    /**
     * 分页查找学生信息
     * @param queryInfo
     * @return
     */
    Result findPage(QueryInfo queryInfo);

    /**
     * 根据用户名获取用户信息
     * @param
     * @return
     */
    Student findByUserName(String username);

    /**
     * 添加学生数据
     * @param student
     * @return
     */
    Result insert (Student student);

    /**
     * 删除学生数据
     * @param student
     * @return
     */
    Result delete(Student student);

    /**
     * 修改学生数据
     * @param student
     * @return
     */
    Result update(Student student);

    /**
     * 修改学生数据是否展示
     * @param student
     * @return
     */
    Result updateShow(Student student);
}
