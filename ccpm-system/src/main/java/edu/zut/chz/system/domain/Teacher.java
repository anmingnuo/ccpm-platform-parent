package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 教师管理对象 teacher
 * 
 * @author anmingnuo
 * @date 2024-05-04
 */
public class Teacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教师id */
    private Long id;

    /** 教师账号 */
    @Excel(name = "教师账号")
    private String userName;

    /** 教师密码 */
    @Excel(name = "教师密码")
    private String password;

    /** 教师名字 */
    @Excel(name = "教师名字")
    private String nickName;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userName", getUserName())
            .append("password", getPassword())
            .append("nickName", getNickName())
            .append("gender", getGender())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
