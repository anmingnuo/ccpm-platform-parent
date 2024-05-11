package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.BaseEntity;
import edu.zut.chz.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.userdetails.User;

/**
 * 课程组对象 group
 *
 * @author anmingnuo
 * @date 2024-05-05
 */
public class Group extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 课程组id
     */
    private Long id;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 课程id
     */
    @Excel(name = "课程id")
    private Long courseId;

    private Course course;
    private SysUser user;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public Long getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("courseId", getCourseId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("course", getCourse())
                .append("user", getUser())
                .toString();
    }
}
