package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.TreeEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 章节对象 chapter
 * 
 * @author anmingnuo
 * @date 2024-05-04
 */
public class Chapter extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 章节id */
    private Long id;

    /** 章节名称 */
    @Excel(name = "章节名称")
    private String chapterName;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setChapterName(String chapterName) 
    {
        this.chapterName = chapterName;
    }

    public String getChapterName() 
    {
        return chapterName;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parentId", getParentId())
            .append("chapterName", getChapterName())
            .append("orderNum", getOrderNum())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
