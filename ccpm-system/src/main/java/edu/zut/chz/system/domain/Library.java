package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 思政库对象 library
 *
 * @author anmingnuo
 * @date 2024-05-05
 */
public class Library extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 思政库id
     */
    private Long id;

    /**
     * 思政标题
     */
    @Excel(name = "思政标题")
    private String title;

    /**
     * 思政描述
     */
    @Excel(name = "思政描述")
    private String description;

    /**
     * 选取次数
     */
    @Excel(name = "选取次数")
    private Long selectionCount;

    /**
     * 浏览量
     */
    @Excel(name = "浏览量")
    private Long views;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Long state;

    private Long firstCategoryId;
    private Long secondCategoryId;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setSelectionCount(Long selectionCount) {
        this.selectionCount = selectionCount;
    }

    public Long getSelectionCount() {
        return selectionCount;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getViews() {
        return views;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getState() {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("description", getDescription())
                .append("selectionCount", getSelectionCount())
                .append("views", getViews())
                .append("state", getState())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("firstCategoryId", getFirstCategoryId())
                .append("secondCategoryId", getSecondCategoryId())
                .toString();
    }
}
