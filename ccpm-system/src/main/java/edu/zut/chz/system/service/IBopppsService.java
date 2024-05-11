package edu.zut.chz.system.service;

import java.util.List;

import edu.zut.chz.common.core.domain.AjaxResult;
import edu.zut.chz.common.core.domain.entity.SysUser;
import edu.zut.chz.system.domain.Boppps;
import edu.zut.chz.system.domain.Chapter;
import edu.zut.chz.system.domain.Course;
import edu.zut.chz.system.domain.Library;

/**
 * bopppsService接口
 * 
 * @author anmingnuo
 * @date 2024-05-06
 */
public interface IBopppsService
{
    /**
     * 查询boppps
     * 
     * @param id boppps主键
     * @return boppps
     */
    public Boppps selectBopppsById(Long id);

    /**
     * 查询boppps列表
     * 
     * @param boppps boppps
     * @return boppps集合
     */
    public List<Boppps> selectBopppsList(Boppps boppps);

    /**
     * 新增boppps
     * 
     * @param boppps boppps
     * @return 结果
     */
    public int insertBoppps(Boppps boppps);

    /**
     * 修改boppps
     * 
     * @param boppps boppps
     * @return 结果
     */
    public int updateBoppps(Boppps boppps);

    /**
     * 批量删除boppps
     * 
     * @param ids 需要删除的boppps主键集合
     * @return 结果
     */
    public int deleteBopppsByIds(Long[] ids);

    /**
     * 删除boppps信息
     * 
     * @param id boppps主键
     * @return 结果
     */
    public int deleteBopppsById(Long id);

    List<Chapter> getChapterList();

    List<SysUser> directorGetUserList(Long userId);

    List<SysUser> teacherGetUserList(Long userId);

    List<Boppps> directorListBoppps(Long userId);

    List<Boppps> teacherListBoppps(Long userId);

    List<Course> directionGetCourseList(Long courseId);

    List<Course> teacherGetCourseList(Long userId);

    List<Library> getLibraryListByCourseId(Long courseId);
}
