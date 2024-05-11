package edu.zut.chz.system.service;

import java.util.List;
import edu.zut.chz.system.domain.Group;
import edu.zut.chz.system.domain.Teacher;

/**
 * 课程组Service接口
 * 
 * @author anmingnuo
 * @date 2024-05-05
 */
public interface IGroupService
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
     * 批量删除课程组
     * 
     * @param ids 需要删除的课程组主键集合
     * @return 结果
     */
    public int deleteGroupByIds(Long[] ids);

    /**
     * 删除课程组信息
     * 
     * @param id 课程组主键
     * @return 结果
     */
    public int deleteGroupById(Long id);

    List<Teacher> getTeacherList(Teacher teacher);

}
