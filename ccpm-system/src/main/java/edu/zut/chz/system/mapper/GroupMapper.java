package edu.zut.chz.system.mapper;

import java.util.List;
import edu.zut.chz.system.domain.Group;
import org.apache.ibatis.annotations.Param;

/**
 * 课程组Mapper接口
 * 
 * @author anmingnuo
 * @date 2024-05-05
 */
public interface GroupMapper 
{
    /**
     * 查询课程组
     * 
     * @param id 课程组主键
     * @return 课程组
     */
    public Group selectGroupById(Long id);

    /**
     * 查询课程组列表
     * 
     * @param group 课程组
     * @return 课程组集合
     */
    public List<Group> selectGroupList(Group group);

    /**
     * 新增课程组
     * 
     * @param group 课程组
     * @return 结果
     */
    public int insertGroup(Group group);

    /**
     * 修改课程组
     * 
     * @param group 课程组
     * @return 结果
     */
    public int updateGroup(Group group);

    /**
     * 删除课程组
     * 
     * @param id 课程组主键
     * @return 结果
     */
    public int deleteGroupById(Long id);

    /**
     * 批量删除课程组
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGroupByIds(Long[] ids);

    List<Group> selectGroupListByUserId(@Param("userId") Long userId);

}
