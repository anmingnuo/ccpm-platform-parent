package edu.zut.chz.system.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import edu.zut.chz.common.core.domain.entity.SysUser;
import edu.zut.chz.common.utils.DateUtils;
import edu.zut.chz.system.domain.*;
import edu.zut.chz.system.mapper.*;
import edu.zut.chz.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.service.IGoalService;

/**
 * 思政目标Service业务层处理
 * 
 * @author anmingnuo
 * @date 2024-05-06
 */
@Service
public class GoalServiceImpl implements IGoalService
{
    @Autowired
    private GoalMapper goalMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private DirectorMapper directorMapper;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private LibraryCategoryMapper libraryCategoryMapper;

    @Autowired
    private LibraryMapper libraryMapper;
    /**
     * 查询思政目标
     * 
     * @param id 思政目标主键
     * @return 思政目标
     */
    @Override
    public Goal selectGoalById(Long id)
    {
        return goalMapper.selectGoalById(id);
    }

    /**
     * 查询思政目标列表
     * 
     * @param goal 思政目标
     * @return 思政目标
     */
    @Override
    public List<Goal> selectGoalList(Goal goal)
    {
        return goalMapper.selectGoalList(goal);
    }

    /**
     * 新增思政目标
     * 
     * @param goal 思政目标
     * @return 结果
     */
    @Override
    public int insertGoal(Goal goal)
    {
        goal.setCreateTime(DateUtils.getNowDate());
        return goalMapper.insertGoal(goal);
    }

    /**
     * 修改思政目标
     * 
     * @param goal 思政目标
     * @return 结果
     */
    @Override
    public int updateGoal(Goal goal)
    {
        goal.setUpdateTime(DateUtils.getNowDate());
        return goalMapper.updateGoal(goal);
    }

    /**
     * 批量删除思政目标
     * 
     * @param ids 需要删除的思政目标主键
     * @return 结果
     */
    @Override
    public int deleteGoalByIds(Long[] ids)
    {
        return goalMapper.deleteGoalByIds(ids);
    }

    /**
     * 删除思政目标信息
     * 
     * @param id 思政目标主键
     * @return 结果
     */
    @Override
    public int deleteGoalById(Long id)
    {
        return goalMapper.deleteGoalById(id);
    }

    @Override
    public List<Course> getAdminCourseList(Course course) {
        List<Course> courses = courseMapper.selectCourseList(course);
        for (Course c:courses){
            System.out.println(c);
        }
        return courses;
    }

    @Override
    public List<Course>  getDirectorCourseList(Long userId) {
        SysUser sysUser = userService.selectUserById(userId);
        Director director = directorMapper.selectDirectorByUserName(sysUser.getUserName());
        List<Course> res=new ArrayList<>();
        Course course = courseMapper.selectCourseById(director.getCourseId());
        res.add(course);
        return res;

    }

    @Override
    public List<Goal> getDirectorList(Long userId, Goal goal) {
        SysUser sysUser = userService.selectUserById(userId);
        Director director = directorMapper.selectDirectorByUserName(sysUser.getUserName());
        goal.setCourseId(director.getCourseId());
        return goalMapper.selectGoalList(goal);
    }

    @Override
    public List<Goal> getTeacherList(Long userId, Goal goal) {
        List<Group> groupList=groupMapper.selectGroupListByUserId(userId);
        List<Long> courseIdList = groupList.stream().map(c -> c.getCourseId()).collect(Collectors.toList());
        List<Goal> res=new ArrayList<>();
        for (Long courseId:courseIdList){
            Goal g=new Goal();
            g.setCourseId(courseId);
            List<Goal> goalList = goalMapper.selectGoalList(g);
            for (Goal goal1:goalList){
                System.out.println(goal1);
                res.add(goal1);
            }
        }
        return res;
    }

    @Override
    public List<Library> getLibraryListByGoalId(Long goalId) {
        Goal goal = goalMapper.selectGoalById(goalId);
        Long courseId = goal.getCourseId();
        Long categoryId = goal.getCategoryId();
        LibraryCategory libraryCategory=new LibraryCategory();
        libraryCategory.setCategoryId(categoryId);
        List<LibraryCategory> libraryCategorieList = libraryCategoryMapper.selectLibraryCategoryList(libraryCategory);

        List<Long> libraryList = libraryCategorieList.stream().map(c -> c.getLibraryId()).collect(Collectors.toList());
        List<Library> res=new ArrayList<>();
        for (Long libraryId:libraryList){
            Library library = libraryMapper.selectLibraryById(libraryId);
            System.out.println(library);
            res.add(library);
        }
        List<Library> collect = res.stream().filter(c -> c.getSelectionCount() < 5).collect(Collectors.toList());
        return collect;
    }
}
