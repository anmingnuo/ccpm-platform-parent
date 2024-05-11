package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 学生管理对象 student
 *
 * @author anmingnuo
 * @date 2024-05-03
 */
public class Student extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 学生id
     */
    private Long id;

    /**
     * 学生名称
     */
    @Excel(name = "学生账号")
    private String userName;

    /**
     * 学生密码
     */
    @Excel(name = "学生密码")
    private String password;

    @Excel(name = "学生姓名")
    private String nickName;
    /**
     * 性别
     */
    @Excel(name = "性别")
    private String gender;

    /**
     * 班级id
     */
    @Excel(name = "班级id")
    private Long clazzId;
    private Clazz clazz;

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }

    public Long getClazzId() {
        return clazzId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userName", getUserName())
                .append("password", getPassword())
                .append("nickName",getNickName())
                .append("gender", getGender())
                .append("clazzId", getClazzId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("clazz", getClazz())
                .toString();
    }
}
