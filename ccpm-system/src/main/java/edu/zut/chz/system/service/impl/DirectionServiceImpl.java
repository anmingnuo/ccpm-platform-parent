package edu.zut.chz.system.service.impl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import edu.zut.chz.common.utils.DateUtils;
import edu.zut.chz.system.domain.Course;
import edu.zut.chz.system.domain.DirectionCourse;
import edu.zut.chz.system.domain.Major;
import edu.zut.chz.system.domain.vo.CourseVo;
import edu.zut.chz.system.mapper.CourseMapper;
import edu.zut.chz.system.mapper.DirectionCourseMapper;
import edu.zut.chz.system.mapper.MajorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.mapper.DirectionMapper;
import edu.zut.chz.system.domain.Direction;
import edu.zut.chz.system.service.IDirectionService;

/**
 * 专业方向Service业务层处理
 * 
 * @author anmingnuo
 * @date 2024-05-02
 */
@Service
public class DirectionServiceImpl implements IDirectionService
{
    @Autowired
    private DirectionMapper directionMapper;

    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private DirectionCourseMapper directionCourseMapper;
    /**
     * 查询专业方向
     * 
     * @param id 专业方向主键
     * @return 专业方向
     */
    @Override
    public Direction selectDirectionById(Long id)
    {
        return directionMapper.selectDirectionById(id);
    }

    /**
     * 查询专业方向列表
     * 
     * @param direction 专业方向
     * @return 专业方向
     */
    @Override
    public List<Direction> selectDirectionList(Direction direction)
    {
        return directionMapper.selectDirectionList(direction);
    }

    /**
     * 新增专业方向
     * 
     * @param direction 专业方向
     * @return 结果
     */
    @Override
    public int insertDirection(Direction direction)
    {
        direction.setCreateTime(DateUtils.getNowDate());
        return directionMapper.insertDirection(direction);
    }

    /**
     * 修改专业方向
     * 
     * @param direction 专业方向
     * @return 结果
     */
    @Override
    public int updateDirection(Direction direction)
    {
        direction.setUpdateTime(DateUtils.getNowDate());
        return directionMapper.updateDirection(direction);
    }

    /**
     * 批量删除专业方向
     * 
     * @param ids 需要删除的专业方向主键
     * @return 结果
     */
    @Override
    public int deleteDirectionByIds(Long[] ids)
    {
        return directionMapper.deleteDirectionByIds(ids);
    }

    /**
     * 删除专业方向信息
     * 
     * @param id 专业方向主键
     * @return 结果
     */
    @Override
    public int deleteDirectionById(Long id)
    {
        return directionMapper.deleteDirectionById(id);
    }

    @Override
    public List<Major> getMajorList(Major major) {
        return majorMapper.selectMajorList(major);
    }

    @Override
    public List<Course> getCourseList() {
        return courseMapper.selectCourseList(new Course());
    }

    @Override
    public int addDirectionCourse(CourseVo courseVo) {
        List<Long> courseIdList = courseVo.getCourseIdList();
        Long directionId = courseVo.getDirectionId();
        int count=0;
        for (Long courseId:courseIdList){

            if (directionCourseMapper.getOne(courseId,directionId)==0){
                DirectionCourse directionCourse=new DirectionCourse();
                directionCourse.setCourseId(courseId);
                directionCourse.setDirectionId(directionId);
                count+= directionCourseMapper.insertDirectionCourse(directionCourse);
            }
        }
        return count;
    }

}
