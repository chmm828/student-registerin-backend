package com.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: java-jssb
 * @description: 员工实体
 * @author:  
 * @create: 2021-10-24 00:02
 **/
@Data
@ApiModel(value="管理员实体对象", description="")
public class Mallpersonnel implements UserDetails {

    @ApiModelProperty(value = "主键id")
    private Integer pId;

    @ApiModelProperty(value = "微信id")
    private String openid;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "姓名")
    private String pName;

    @ApiModelProperty(value = "性别")
    private Integer pGender;

    @ApiModelProperty(value = "身份证")
    private String pCard;

    @ApiModelProperty(value = "手机号")
    private String pPhone;

    @ApiModelProperty(value = "职业昵称")
    private String pPosition;

//    @ApiModelProperty(value = "出生年月日")
//    private String Birthday;
    @ApiModelProperty(value = "年龄")
    private Integer pAge;


    @ApiModelProperty(value = "注册时间")
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;
    @ApiModelProperty(value = "头像")

    private String image;

    @ApiModelProperty(value = "是否禁用，1 ture")
    private boolean status;

    @ApiModelProperty(value = "是否admin，1 ture")
    private boolean admin;

    @ApiModelProperty(value = "邮箱")
    private String email;


    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "角色信息")
    private List<SysRole> roles;
    /**
     *角色对应的菜单列表
     */
    @ApiModelProperty(value = "用户对应的菜单列表")
    private List<SysMenu> menus;

    /**
     *数据权限
     */
    @ApiModelProperty(value = "用户对应的数据权限")
    private List<SysPermission> permissions;

    //权限数据
    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //角色信息
        List<GrantedAuthority> list =new ArrayList<>();
        if(roles!=null && roles.size()>0){
            roles.forEach(item -> list.add(new SimpleGrantedAuthority("ROLE_"+item.getCode())));
        }
        if(permissions !=null && permissions.size()>0){
            permissions.forEach(item-> list.add(new SimpleGrantedAuthority(item.getCode())));
        }
        return  list;
    }
    //用户名
    @Override
    @JsonIgnore
    public String getUsername() {
        return pName;
    }
    //账号是否过期
    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return false;
    }
    //账号是否被锁定
    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return false;
    }
    //是否被禁用
    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return status;
    }

}