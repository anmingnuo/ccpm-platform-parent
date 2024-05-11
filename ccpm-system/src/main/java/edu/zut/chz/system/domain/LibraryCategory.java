package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 思政类别对象 library_category
 * 
 * @author anmingnuo
 * @date 2024-05-05
 */
public class LibraryCategory
{

    /** 思政id */
    private Long libraryId;

    /** 类别id */
    private Long categoryId;

    public void setLibraryId(Long libraryId) 
    {
        this.libraryId = libraryId;
    }

    public Long getLibraryId() 
    {
        return libraryId;
    }
    public void setCategoryId(Long category)
    {
        this.categoryId = category;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("libraryId", getLibraryId())
            .append("categoryId", getCategoryId())
            .toString();
    }
}
