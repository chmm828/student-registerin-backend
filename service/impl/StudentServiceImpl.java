package com.server.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.server.config.security.service.UserDetailServiceImp;
import com.server.config.security.service.WxUserDetailServiceImpl;
import com.server.entity.ClassEntity;
import com.server.entity.Mallpersonnel;
import com.server.entity.Student;
import com.server.mapper.ClassMapper;
import com.server.mapper.StudentMapper;
import com.server.service.StudentService;
import com.server.utils.*;
import com.server.vo.WxLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class StudentServiceImpl  implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenUtil tokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private WxUserDetailServiceImpl wxUserDetailService;

    @Override
    public Result login(WxLoginVo wxLoginVo) {
        log.info("1.开始登录");
        UserDetails userDetails = wxUserDetailService.loadUserByUsername(wxLoginVo.getStudentId());
        log.info("2.判断用户是否存在，密码是否正确");
        if (userDetails==null || !passwordEncoder.matches(wxLoginVo.getPassword(),userDetails.getPassword())){
            return Result.fail("账号或者密码错误,请重新输入！");
        }
        if(!userDetails.isEnabled()){
            return Result.fail("账号被禁止使用，请联系管理员！");
        }
        log.info("3.登录成功，在security对象中存入登录者信息");
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        log.info("4.根据登录信息获取token");
        String token =tokenUtil.generateToken(userDetails);
        //给前端返回数据
        Map<String,String> map =new HashMap<>(2);
        map.put("tokenHead",tokenHead);
        map.put("token",token);
        return Result.success("微信用户登录成功",map);
    }

    @Override
    public Result getStudentInfo(String studentId) {
        return Result.success("获取学生个人信息成功",studentMapper.getStudentInfo(studentId));
    }

    @Override
    public Result findPage(QueryInfo queryInfo) {
        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
        Page<Student> page = studentMapper.findPage(queryInfo.getQueryString());
        long total =page.getTotal();
        List<Student> result = page.getResult();
        return new PageResult(total,result);
    }

    @Override
    public Result insert(Student student) {
        studentMapper.insert(student);
        return  Result.success("添加学生数据成功");
    }

    @Override
    public Result delete(Student student) {
        studentMapper.delete(student);
        return  Result.success("删除学生数据成功");
    }

    @Override
    public Result update(Student student) {
        if(student.getStudentPassword()!= null) { student.setStudentPassword(passwordEncoder.encode(student.getStudentPassword()));}
        studentMapper.update(student);
        return Result.success("修改学生数据成功");
    }

    @Override
    public Result updateShow(Student student) {
        studentMapper.updateShow(student);
        return Result.success("修改学生数据成功");
    }

    @Override
    public Student findByUserName(String username) {
        return studentMapper.findByUserName(username);
    }
}
