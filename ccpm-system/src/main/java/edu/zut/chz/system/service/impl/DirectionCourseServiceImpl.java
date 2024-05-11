package edu.zut.chz.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.mapper.DirectionCourseMapper;
import edu.zut.chz.system.domain.DirectionCourse;
import edu.zut.chz.system.service.IDirectionCourseService;

/**
 * 方向课程Service业务层处理
 * 
 * @author anmingnuo
 * @date 2024-05-09
 */
@Service
public class DirectionCourseServiceImpl implements IDirectionCourseService
{
    @Autowired
    private DirectionCourseMapper directionCourseMapper;

    /**
     * 查询方向课程
     * 
     * @param directionId 方向课程主键
     * @return 方向课程
     */
    @Override
    public DirectionCourse selectDirectionCourseByDirectionId(Long directionId)
    {
        return directionCourseMapper.selectDirectionCourseByDirectionId(directionId);
    }

    /**
     * 查询方向课程列表
     * 
     * @param directionCourse 方向课程
     * @return 方向课程
     */
    @Override
    public List<DirectionCourse> selectDirectionCourseList(DirectionCourse directionCourse)
    {
        return directionCourseMapper.selectDirectionCourseList(directionCourse);
    }

    /**
     * 新增方向课程
     * 
     * @param directionCourse 方向课程
     * @return 结果
     */
    @Override
    public int insertDirectionCourse(DirectionCourse directionCourse)
    {
        return directionCourseMapper.insertDirectionCourse(directionCourse);
    }

    /**
     * 修改方向课程
     * 
     * @param directionCourse 方向课程
     * @return 结果
     */
    @Override
    public int updateDirectionCourse(DirectionCourse directionCourse)
    {
        return directionCourseMapper.updateDirectionCourse(directionCourse);
    }

    /**
     * 批量删除方向课程
     * 
     * @param directionIds 需要删除的方向课程主键
     * @return 结果
     */
    @Override
    public int deleteDirectionCourseByDirectionIds(Long[] directionIds)
    {
        return directionCourseMapper.deleteDirectionCourseByDirectionIds(directionIds);
    }

    /**
     * 删除方向课程信息
     * 
     * @param directionId 方向课程主键
     * @return 结果
     */
    @Override
    public int deleteDirectionCourseByDirectionId(Long directionId)
    {
        return directionCourseMapper.deleteDirectionCourseByDirectionId(directionId);
    }
}
