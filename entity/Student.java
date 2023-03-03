package com.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@ApiModel(value="学生实体对象", description="")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student implements  UserDetails {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学号，11位数")
    private String studentId;

    @ApiModelProperty(value = "辅导员外键")
    private Integer counselorId;

    @ApiModelProperty(value = "班主任外键")
    private Integer teacherId;

    @ApiModelProperty(value = "年级外键")
    private Integer gradeId;

    @ApiModelProperty(value = "专业外键")
    private Integer majorId;

    @ApiModelProperty(value = "班级id")
    private Integer classId;

    @ApiModelProperty(value = "学生名字")
    private String studentName;

    @ApiModelProperty(value = "性别")
    private Integer studentSex;

    @ApiModelProperty(value = "密码,默认为123456")
    private String studentPassword;

    @ApiModelProperty(value = "图片,默认为https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png")
    private String studentImg;

    @ApiModelProperty(value = "个人联系方式")
    private String studentPhone;

    @ApiModelProperty(value = "注册时间")
    private String studentCreateTime;

    @ApiModelProperty(value = "是否报道，0未报道 1报道。")
    private Boolean isReport;

    @ApiModelProperty(value = "报道时间")
    private String reportTime;

    @ApiModelProperty(value = "宿舍名字")
    private String dormitoryName;

    @ApiModelProperty(value = "身份证")
    private String studentIdCard;

    @ApiModelProperty(value = "家庭联系方式")
    private String studentHomePhone;

    @ApiModelProperty(value = "家庭地址")
    private String studentHome;

    @ApiModelProperty(value = "籍贯")
    private String  studentNativePlace;

    @ApiModelProperty(value = "宗教")
    private String  studentReligion;


    @ApiModelProperty(value = "0 未禁用 1禁用")
    private Boolean studentStatus;

    @ApiModelProperty(value = "0未删除，1删除")
    private Boolean studentIsDelete;

    @ApiModelProperty(value = "辅导员")
    private List<Counselor> counselors;

    @ApiModelProperty(value = "班主任")
    private List<Teacher> teachers;

    @ApiModelProperty(value = "所在年级")
    private List<Grade> grades;

    @ApiModelProperty(value = "所在班级")
    private List<ClassEntity> classEntities;

    @ApiModelProperty(value = "所在专业")
    private List<Major> majors;

    @ApiModelProperty(value = "所在学院")
    private List<College> colleges;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return studentPassword;
    }

    @Override
    public String getUsername() {
        return studentId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return studentStatus;
    }
}
