package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 元素选取对象 selection
 *
 * @author anmingnuo
 * @date 2024-05-06
 */
public class Selection extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 选取id
     */
    private Long id;

    /**
     * 课程id
     */
    @Excel(name = "课程id")
    private Long courseId;

    /**
     * 元素库id
     */
    @Excel(name = "元素库id")
    private Long libraryId;

    private Course course;
    private Library library;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
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

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("courseId", getCourseId())
                .append("libraryId", getLibraryId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("course", getCourse())
                .append("library", getLibrary())
                .toString();
    }
}
