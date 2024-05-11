package edu.zut.chz.system.service;

import java.util.List;

import edu.zut.chz.system.domain.Course;
import edu.zut.chz.system.domain.Direction;
import edu.zut.chz.system.domain.Major;
import edu.zut.chz.system.domain.vo.CourseVo;

/**
 * 专业方向Service接口
 * 
 * @author anmingnuo
 * @date 2024-05-02
 */
public interface IDirectionService
{
    /**
     * 查询专业方向
     * 
     * @param id 专业方向主键
     * @return 专业方向
     */
    public Direction selectDirectionById(Long id);

    /**
     * 查询专业方向列表
     * 
     * @param direction 专业方向
     * @return 专业方向集合
     */
    public List<Direction> selectDirectionList(Direction direction);

    /**
     * 新增专业方向
     * 
     * @param direction 专业方向
     * @return 结果
     */
    public int insertDirection(Direction direction);

    /**
     * 修改专业方向
     * 
     * @param direction 专业方向
     * @return 结果
     */
    public int updateDirection(Direction direction);

    /**
     * 批量删除专业方向
     * 
     * @param ids 需要删除的专业方向主键集合
     * @return 结果
     */
    public int deleteDirectionByIds(Long[] ids);

    /**
     * 删除专业方向信息
     * 
     * @param id 专业方向主键
     * @return 结果
     */
    public int deleteDirectionById(Long id);

    List<Major> getMajorList(Major major);

    List<Course> getCourseList();

    int addDirectionCourse(CourseVo courseVo);
}
