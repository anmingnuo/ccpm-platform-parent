package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 年级对象 grade
 * 
 * @author anmingnuo
 * @date 2024-05-02
 */
public class Grade extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 年级id */
    private Long id;

    /** 年级名称 */
    @Excel(name = "年级名称")
    private String gradeName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGradeName(String gradeName) 
    {
        this.gradeName = gradeName;
    }

    public String getGradeName() 
    {
        return gradeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("gradeName", getGradeName())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
