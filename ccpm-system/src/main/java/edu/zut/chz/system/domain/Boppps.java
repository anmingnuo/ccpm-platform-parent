package edu.zut.chz.system.domain;

import edu.zut.chz.common.annotation.Excel;
import edu.zut.chz.common.core.domain.BaseEntity;
import edu.zut.chz.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * boppps对象 boppps
 *
 * @author anmingnuo
 * @date 2024-05-06
 */
public class Boppps extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 课程id
     */
    @Excel(name = "课程id")
    private Long courseId;

    /**
     * 章节id
     */
    @Excel(name = "章节id")
    private Long chapterId;

    /**
     * 思政元素id
     */
    @Excel(name = "思政元素id")
    private Long libraryId;

    /**
     * 引入描述
     */
    @Excel(name = "引入描述")
    private String bridge;

    /**
     * 引入时长
     */
    @Excel(name = "引入时长")
    private Long bridgeTime;

    /**
     * 目标描述
     */
    @Excel(name = "目标描述")
    private String object;

    /**
     * 目标时长
     */
    @Excel(name = "目标时长")
    private Long objectTime;

    /**
     * 课前摸底
     */
    @Excel(name = "课前摸底")
    private String preAssessment;

    /**
     * 摸底时长
     */
    @Excel(name = "摸底时长")
    private Long preTime;

    /**
     * 参与式学习
     */
    @Excel(name = "参与式学习")
    private String praticipatoryLearning;

    /**
     * 参与时长
     */
    @Excel(name = "参与时长")
    private Long praticipatoryTime;

    /**
     * 课后测验
     */
    @Excel(name = "课后测验")
    private String postAssessment;

    /**
     * 测验时长
     */
    @Excel(name = "测验时长")
    private Long postTime;

    /**
     * 总结
     */
    @Excel(name = "总结")
    private String summary;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private String state;

    private SysUser sysUser;
    private Course course;
    private Chapter chapter;
    private Library library;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setBridge(String bridge) {
        this.bridge = bridge;
    }

    public String getBridge() {
        return bridge;
    }

    public void setBridgeTime(Long bridgeTime) {
        this.bridgeTime = bridgeTime;
    }

    public Long getBridgeTime() {
        return bridgeTime;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getObject() {
        return object;
    }

    public void setObjectTime(Long objectTime) {
        this.objectTime = objectTime;
    }

    public Long getObjectTime() {
        return objectTime;
    }

    public void setPreAssessment(String preAssessment) {
        this.preAssessment = preAssessment;
    }

    public String getPreAssessment() {
        return preAssessment;
    }

    public void setPreTime(Long preTime) {
        this.preTime = preTime;
    }

    public Long getPreTime() {
        return preTime;
    }

    public void setPraticipatoryLearning(String praticipatoryLearning) {
        this.praticipatoryLearning = praticipatoryLearning;
    }

    public String getPraticipatoryLearning() {
        return praticipatoryLearning;
    }

    public void setPraticipatoryTime(Long praticipatoryTime) {
        this.praticipatoryTime = praticipatoryTime;
    }

    public Long getPraticipatoryTime() {
        return praticipatoryTime;
    }

    public void setPostAssessment(String postAssessment) {
        this.postAssessment = postAssessment;
    }

    public String getPostAssessment() {
        return postAssessment;
    }

    public void setPostTime(Long postTime) {
        this.postTime = postTime;
    }

    public Long getPostTime() {
        return postTime;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
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
                .append("userId", getUserId())
                .append("courseId", getCourseId())
                .append("chapterId", getChapterId())
                .append("libraryId", getLibraryId())
                .append("bridge", getBridge())
                .append("bridgeTime", getBridgeTime())
                .append("object", getObject())
                .append("objectTime", getObjectTime())
                .append("preAssessment", getPreAssessment())
                .append("preTime", getPreTime())
                .append("praticipatoryLearning", getPraticipatoryLearning())
                .append("praticipatoryTime", getPraticipatoryTime())
                .append("postAssessment", getPostAssessment())
                .append("postTime", getPostTime())
                .append("summary", getSummary())
                .append("state", getState())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("sysUser", getSysUser())
                .append("course", getCourse())
                .append("library", getLibrary())
                .append("chapter", getChapter())
                .toString();
    }
}
