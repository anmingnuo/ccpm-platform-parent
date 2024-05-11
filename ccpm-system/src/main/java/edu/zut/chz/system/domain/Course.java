package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 课程对象 course
 * 
 * @author anmingnuo
 * @date 2024-05-04
 */
public class Course extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程id */
    private Long id;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 学分 */
    @Excel(name = "学分")
    private Long credit;

    /** 学时 */
    @Excel(name = "学时")
    private Long coursePeriod;

    /** 课程类型（0：理论课，1：实践课） */
    @Excel(name = "课程类型", readConverterExp = "0=：理论课，1：实践课")
    private String type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setCredit(Long credit) 
    {
        this.credit = credit;
    }

    public Long getCredit() 
    {
        return credit;
    }
    public void setCoursePeriod(Long coursePeriod) 
    {
        this.coursePeriod = coursePeriod;
    }

    public Long getCoursePeriod() 
    {
        return coursePeriod;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("courseName", getCourseName())
            .append("credit", getCredit())
            .append("coursePeriod", getCoursePeriod())
            .append("type", getType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
