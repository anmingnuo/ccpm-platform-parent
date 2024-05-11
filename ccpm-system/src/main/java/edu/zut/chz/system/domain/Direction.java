package edu.zut.chz.system.domain;

import com.alibaba.fastjson2.JSONObject;
import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.BaseEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Arrays;
import java.util.List;

/**
 * 专业方向对象 direction
 *
 * @author anmingnuo
 * @date 2024-05-02
 */
public class Direction extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 方向id
     */
    private Long id;

    /**
     * 方向名称
     */
    @Excel(name = "方向名称")
    private String directionName;

    /**
     * 专业id
     */
    @Excel(name = "专业id")
    private Long majorId;
    private Major major;


    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public Long getMajorId() {
        return majorId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("directionName", getDirectionName())
                .append("majorId", getMajorId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("major", getMajor())
                .toString();
    }
}
