package edu.zut.chz.system.mapper;

import java.util.List;
import edu.zut.chz.system.domain.Goal;

/**
 * 思政目标Mapper接口
 * 
 * @author anmingnuo
 * @date 2024-05-06
 */
public interface GoalMapper 
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
     * 删除思政目标
     * 
     * @param id 思政目标主键
     * @return 结果
     */
    public int deleteGoalById(Long id);

    /**
     * 批量删除思政目标
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoalByIds(Long[] ids);
}
