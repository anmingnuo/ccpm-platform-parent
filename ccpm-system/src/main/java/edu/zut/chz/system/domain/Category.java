package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.TreeEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 思政类别对象 category
 * 
 * @author anmingnuo
 * @date 2024-05-05
 */
public class Category extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 类别id */
    private Long id;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String categoryName;

    /** 级别 */
    @Excel(name = "级别")
    private Long categoryType;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCategoryName(String categoryName) 
    {
        this.categoryName = categoryName;
    }

    public String getCategoryName() 
    {
        return categoryName;
    }
    public void setCategoryType(Long categoryType) 
    {
        this.categoryType = categoryType;
    }

    public Long getCategoryType() 
    {
        return categoryType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parentId", getParentId())
            .append("categoryName", getCategoryName())
            .append("orderNum", getOrderNum())
            .append("categoryType", getCategoryType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
