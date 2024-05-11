package edu.zut.chz.system.service;

import java.util.List;
import edu.zut.chz.system.domain.DirectionCourse;

/**
 * 方向课程Service接口
 * 
 * @author anmingnuo
 * @date 2024-05-09
 */
public interface IDirectionCourseService
{
    /**
     * 查询方向课程
     * 
     * @param directionId 方向课程主键
     * @return 方向课程
     */
    public DirectionCourse selectDirectionCourseByDirectionId(Long directionId);

    /**
     * 查询方向课程列表
     * 
     * @param directionCourse 方向课程
     * @return 方向课程集合
     */
    public List<DirectionCourse> selectDirectionCourseList(DirectionCourse directionCourse);

    /**
     * 新增方向课程
     * 
     * @param directionCourse 方向课程
     * @return 结果
     */
    public int insertDirectionCourse(DirectionCourse directionCourse);

    /**
     * 修改方向课程
     * 
     * @param directionCourse 方向课程
     * @return 结果
     */
    public int updateDirectionCourse(DirectionCourse directionCourse);

    /**
     * 批量删除方向课程
     * 
     * @param directionIds 需要删除的方向课程主键集合
     * @return 结果
     */
    public int deleteDirectionCourseByDirectionIds(Long[] directionIds);

    /**
     * 删除方向课程信息
     * 
     * @param directionId 方向课程主键
     * @return 结果
     */
    public int deleteDirectionCourseByDirectionId(Long directionId);
}
