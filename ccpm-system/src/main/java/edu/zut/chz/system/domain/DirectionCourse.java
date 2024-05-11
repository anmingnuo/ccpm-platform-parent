package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 方向课程对象 direction_course
 * 
 * @author anmingnuo
 * @date 2024-05-09
 */
public class DirectionCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 方向id */
    private Long directionId;

    /** 课程id */
    private Long courseId;

    private Direction direction;
    private Course course;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setDirectionId(Long directionId)
    {
        this.directionId = directionId;
    }

    public Long getDirectionId() 
    {
        return directionId;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("directionId", getDirectionId())
            .append("courseId", getCourseId())
                .append("course",getCourse())
                .append("direction",getDirection())
            .toString();
    }
}
