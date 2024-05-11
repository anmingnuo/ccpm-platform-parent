package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 班级对象 clazz
 *
 * @author anmingnuo
 * @date 2024-05-02
 */
public class Clazz extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 班级id
     */
    private Long id;

    /**
     * 班级名称
     */
    @Excel(name = "班级名称")
    private String clazzName;

    /**
     * 方向id
     */
    @Excel(name = "方向id")
    private Long directionId;

    /**
     * 年级id
     */
    @Excel(name = "年级id")
    private Long gradeId;
    private Direction direction;
    private Grade grade;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setDirectionId(Long directionId) {
        this.directionId = directionId;
    }

    public Long getDirectionId() {
        return directionId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("clazzName", getClazzName())
                .append("directionId", getDirectionId())
                .append("gradeId", getGradeId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("grade", getGrade())
                .append("direction", getDirection())
                .toString();
    }
}
