package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 课程负责人管理对象 director
 *
 * @author anmingnuo
 * @date 2024-05-04
 */
public class Director extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 课程负责人di
     */
    private Long id;

    /**
     * 负责人账号
     */
    @Excel(name = "负责人账号")
    private String userName;

    /**
     * 负责人密码
     */
    @Excel(name = "负责人密码")
    private String password;

    /**
     * 负责人名称
     */
    @Excel(name = "负责人名称")
    private String nickName;

    /**
     * 负责人性别
     */
    @Excel(name = "负责人性别")
    private String gender;

    /**
     * 课程id
     */
    @Excel(name = "课程id")
    private Long courseId;
    private Course course;

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

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userName", getUserName())
                .append("password", getPassword())
                .append("nickName", getNickName())
                .append("gender", getGender())
                .append("courseId", getCourseId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("course", getCourse())
                .toString();
    }
}
