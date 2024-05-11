package edu.zut.chz.system.mapper;

import java.util.List;
import edu.zut.chz.system.domain.Director;
import org.apache.ibatis.annotations.Param;

/**
 * 课程负责人管理Mapper接口
 * 
 * @author anmingnuo
 * @date 2024-05-04
 */
public interface DirectorMapper 
{
    /**
     * 查询课程负责人管理
     * 
     * @param id 课程负责人管理主键
     * @return 课程负责人管理
     */
    public Director selectDirectorById(Long id);

    /**
     * 查询课程负责人管理列表
     * 
     * @param director 课程负责人管理
     * @return 课程负责人管理集合
     */
    public List<Director> selectDirectorList(Director director);

    /**
     * 新增课程负责人管理
     * 
     * @param director 课程负责人管理
     * @return 结果
     */
    public int insertDirector(Director director);

    /**
     * 修改课程负责人管理
     * 
     * @param director 课程负责人管理
     * @return 结果
     */
    public int updateDirector(Director director);

    /**
     * 删除课程负责人管理
     * 
     * @param id 课程负责人管理主键
     * @return 结果
     */
    public int deleteDirectorById(Long id);

    /**
     * 批量删除课程负责人管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDirectorByIds(Long[] ids);

    Director selectDirectorByUserName(@Param("userName") String userName);
}
