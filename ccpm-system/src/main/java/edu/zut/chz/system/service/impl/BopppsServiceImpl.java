package edu.zut.chz.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.zut.chz.common.core.domain.entity.SysUser;
import edu.zut.chz.common.utils.DateUtils;
import edu.zut.chz.system.domain.*;
import edu.zut.chz.system.mapper.*;
import edu.zut.chz.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.service.IBopppsService;

/**
 * bopppsService业务层处理
 *
 * @author anmingnuo
 * @date 2024-05-06
 */
@Service
public class BopppsServiceImpl implements IBopppsService {
    @Autowired
    private BopppsMapper bopppsMapper;
    @Autowired
    private ChapterMapper chapterMapper;
    @Autowired
    private DirectorMapper directorMapper;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private LibraryMapper libraryMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private SelectionMapper selectionMapper;
    @Autowired
    private GoalMapper goalMapper;
    @Autowired
    private LibraryCategoryMapper libraryCategoryMapper;

    /**
     * 查询boppps
     *
     * @param id boppps主键
     * @return boppps
     */
    @Override
    public Boppps selectBopppsById(Long id) {
        return bopppsMapper.selectBopppsById(id);
    }

    /**
     * 查询boppps列表
     *
     * @param boppps boppps
     * @return boppps
     */
    @Override
    public List<Boppps> selectBopppsList(Boppps boppps) {
        return bopppsMapper.selectBopppsList(boppps);
    }

    /**
     * 新增boppps
     *
     * @param boppps boppps
     * @return 结果
     */
    @Override
    public int insertBoppps(Boppps boppps) {
        boppps.setCreateTime(DateUtils.getNowDate());
        return bopppsMapper.insertBoppps(boppps);
    }

    /**
     * 修改boppps
     *
     * @param boppps boppps
     * @return 结果
     */
    @Override
    public int updateBoppps(Boppps boppps) {
        boppps.setUpdateTime(DateUtils.getNowDate());
        if ("1".equals(boppps.getState())){
            Long courseId = boppps.getCourseId();
            Goal goal=new Goal();
            goal.setCourseId(courseId);
            List<Goal> goalList = goalMapper.selectGoalList(goal);
            for (Goal g:goalList){
                Long categoryId = g.getCategoryId();
                LibraryCategory libraryCategory=new LibraryCategory();
                libraryCategory.setCategoryId(categoryId);
                List<LibraryCategory> libraryCategorieList = libraryCategoryMapper.selectLibraryCategoryList(libraryCategory);
                Long libraryId = boppps.getLibraryId();
                for (LibraryCategory lc:libraryCategorieList){
                    if (libraryId==lc.getLibraryId()){
                        g.setState("1");
                        goalMapper.updateGoal(g);
                    }
                }

            }
        }
        return bopppsMapper.updateBoppps(boppps);
    }

    /**
     * 批量删除boppps
     *
     * @param ids 需要删除的boppps主键
     * @return 结果
     */
    @Override
    public int deleteBopppsByIds(Long[] ids) {
        return bopppsMapper.deleteBopppsByIds(ids);
    }

    /**
     * 删除boppps信息
     *
     * @param id boppps主键
     * @return 结果
     */
    @Override
    public int deleteBopppsById(Long id) {
        return bopppsMapper.deleteBopppsById(id);
    }

    @Override
    public List<Chapter> getChapterList() {
        return chapterMapper.selectChapterList(new Chapter());
    }

    @Override
    public List<SysUser> directorGetUserList(Long userId) {
        SysUser sysUser = userService.selectUserById(userId);
        Director director = directorMapper.selectDirectorByUserName(sysUser.getUserName());
        Long courseId = director.getCourseId();
        Group group = new Group();
        group.setCourseId(courseId);
        List<Group> groupList = groupMapper.selectGroupList(group);
        if (!groupList.isEmpty()) {
            List<SysUser> res = new ArrayList<>();
            for (Group g : groupList) {
                SysUser user = userService.selectUserById(g.getUserId());
                res.add(user);
            }
            return res;
        } else {
            return null;
        }
    }

    @Override
    public List<SysUser> teacherGetUserList(Long userId) {
        SysUser sysUser = userService.selectUserById(userId);
        List<SysUser> res = new ArrayList<>();
        res.add(sysUser);
        return res;
    }

    @Override
    public List<Boppps> directorListBoppps(Long userId) {
        SysUser sysUser = userService.selectUserById(userId);
        Director director = directorMapper.selectDirectorByUserName(sysUser.getUserName());
        Long courseId = director.getCourseId();
        Group group = new Group();
        group.setCourseId(courseId);
        List<Group> groupList = groupMapper.selectGroupList(group);
        if (!groupList.isEmpty()) {
            List<Boppps> res = new ArrayList<>();
            for (Group g : groupList) {
                Boppps boppps = new Boppps();
                boppps.setUserId(g.getUserId());
                List<Boppps> bopppsList = bopppsMapper.selectBopppsList(boppps);
                res.addAll(bopppsList);
            }
            return res;
        } else {
            return null;
        }
    }

    @Override
    public List<Boppps> teacherListBoppps(Long userId) {
        Boppps boppps = new Boppps();
        boppps.setUserId(userId);
        return bopppsMapper.selectBopppsList(boppps);
    }

    @Override
    public List<Course> directionGetCourseList(Long courseId) {
        Course course = courseMapper.selectCourseById(courseId);
        List<Course> res = new ArrayList<>();
        res.add(course);
        return res;
    }

    @Override
    public List<Course> teacherGetCourseList(Long userId) {
        Group group = new Group();
        group.setUserId(userId);
        List<Group> groupList = groupMapper.selectGroupList(group);
        if (groupList != null) {
            List<Course> res = new ArrayList<>();
            for (Group g : groupList) {
                Course course = courseMapper.selectCourseById(g.getCourseId());
                res.add(course);
            }
            return res;
        }
        return null;

    }

    @Override
    public List<Library> getLibraryListByCourseId(Long courseId) {
        System.out.println("111111："+courseId);
        Selection selection = new Selection();
        selection.setCourseId(courseId);
        List<Selection> selectionList = selectionMapper.selectSelectionList(selection);
        List<Library> res = new ArrayList<>();
        if (selectionList != null) {
            for (Selection s : selectionList) {
                res.add(libraryMapper.selectLibraryById(s.getLibraryId()));
            }
        }
        return res;
    }

}
