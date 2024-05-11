package edu.zut.chz.system.service;

import java.util.List;

import edu.zut.chz.common.core.domain.AjaxResult;
import edu.zut.chz.system.domain.Course;
import edu.zut.chz.system.domain.Goal;
import edu.zut.chz.system.domain.Library;

/**
 * 思政目标Service接口
 * 
 * @author anmingnuo
 * @date 2024-05-06
 */
public interface IGoalService
{
    /**
     * 查询思政目标
     * 
     * @param id 思政目标主键
     * @return 思政目标
     */
    public Goal selectGoalById(Long id);

    /**
     * 查询思政目标列表
     * 
     * @param goal 思政目标
     * @return 思政目标集合
     */
    public List<Goal> selectGoalList(Goal goal);

    /**
     * 新增思政目标
     * 
     * @param goal 思政目标
     * @return 结果
     */
    public int insertGoal(Goal goal);

    /**
     * 修改思政目标
     * 
     * @param goal 思政目标
     * @return 结果
     */
    public int updateGoal(Goal goal);

    /**
     * 批量删除思政目标
     * 
     * @param ids 需要删除的思政目标主键集合
     * @return 结果
     */
    public int deleteGoalByIds(Long[] ids);

    /**
     * 删除思政目标信息
     * 
     * @param id 思政目标主键
     * @return 结果
     */
    public int deleteGoalById(Long id);

    List<Course> getAdminCourseList(Course course);

    List<Course> getDirectorCourseList(Long userId);

    List<Goal> getDirectorList(Long userId, Goal goal);

    List<Goal> getTeacherList(Long userId, Goal goal);

    List<Library> getLibraryListByGoalId(Long goalId);
}
