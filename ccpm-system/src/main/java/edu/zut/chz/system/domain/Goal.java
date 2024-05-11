package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.BaseEntity;
import edu.zut.chz.system.mapper.CourseMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 思政目标对象 goal
 *
 * @author anmingnuo
 * @date 2024-05-06
 */
public class Goal extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 目标id
     */
    private Long id;

    /**
     * 课程id
     */
    @Excel(name = "课程id")
    private Long courseId;

    /**
     * 类别id
     */
    @Excel(name = "类别id")
    private Long categoryId;
    private Course course;
    private Category category;
    private Long firstCategoryId;
    private Long secondCategoryId;
    /**
     * 是否完成（0：未完成，1：完成）
     */
    @Excel(name = "是否完成", readConverterExp = "0=：未完成，1：完成")
    private String state;

    public Long getFirstCategoryId() {
        return firstCategoryId;
    }

    public void setFirstCategoryId(Long firstCategoryId) {
        this.firstCategoryId = firstCategoryId;
    }

    public Long getSecondCategoryId() {
        return secondCategoryId;
    }

    public void setSecondCategoryId(Long secondCategoryId) {
        this.secondCategoryId = secondCategoryId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("courseId", getCourseId())
                .append("categoryId", getCategoryId())
                .append("state", getState())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("category", getCategory())
                .append("course", getCourse())
                .append("firstCategoryId",getFirstCategoryId())
                .append("secondCategoryId",getSecondCategoryId())
                .toString();
    }
}
