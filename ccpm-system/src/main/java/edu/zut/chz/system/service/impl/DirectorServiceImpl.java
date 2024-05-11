package edu.zut.chz.system.service.impl;

import java.util.List;

import edu.zut.chz.common.core.domain.entity.SysUser;
import edu.zut.chz.common.utils.DateUtils;
import edu.zut.chz.common.utils.SecurityUtils;
import edu.zut.chz.system.domain.Course;
import edu.zut.chz.system.domain.Student;
import edu.zut.chz.system.mapper.CourseMapper;
import edu.zut.chz.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.mapper.DirectorMapper;
import edu.zut.chz.system.domain.Director;
import edu.zut.chz.system.service.IDirectorService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 课程负责人管理Service业务层处理
 * 
 * @author anmingnuo
 * @date 2024-05-04
 */
@Service
public class DirectorServiceImpl implements IDirectorService
{
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private DirectorMapper directorMapper;
    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询课程负责人管理
     * 
     * @param id 课程负责人管理主键
     * @return 课程负责人管理
     */
    @Override
    public Director selectDirectorById(Long id)
    {
        return directorMapper.selectDirectorById(id);
    }

    /**
     * 查询课程负责人管理列表
     * 
     * @param director 课程负责人管理
     * @return 课程负责人管理
     */
    @Override
    public List<Director> selectDirectorList(Director director)
    {
        return directorMapper.selectDirectorList(director);
    }

    /**
     * 新增课程负责人管理
     * 
     * @param director 课程负责人管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertDirector(Director director)
    {
        director.setCreateTime(DateUtils.getNowDate());
        SysUser sysUser=new SysUser();
        sysUser.setUserName(director.getUserName());
        sysUser.setNickName(director.getNickName());
        sysUser.setPassword(SecurityUtils.encryptPassword(director.getPassword()));
        sysUser.setSex(director.getGender());
        sysUser.setRoleIds(new Long[]{102L});
        sysUserService.insertUser(sysUser);
        return directorMapper.insertDirector(director);
    }

    /**
     * 修改课程负责人管理
     * 
     * @param director 课程负责人管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateDirector(Director director)
    {
        director.setUpdateTime(DateUtils.getNowDate());
        SysUser sysUser=new SysUser();
        sysUser.setUserId(sysUserService.selectUserByUserName(director.getUserName()).getUserId());
//        sysUser.setUserName(director.getUserName());
        sysUser.setNickName(director.getNickName());
        sysUser.setPassword(SecurityUtils.encryptPassword(director.getPassword()));
        sysUser.setSex(director.getGender());
        sysUser.setRoleIds(new Long[]{102L});
        sysUserService.updateUser(sysUser);
        return directorMapper.updateDirector(director);
    }

    /**
     * 批量删除课程负责人管理
     * 
     * @param ids 需要删除的课程负责人管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDirectorByIds(Long[] ids)
    {
        Long[] sysUserIds=new Long[ids.length];
        for (int i=0;i<ids.length;i++){
            Director director = directorMapper.selectDirectorById(ids[i]);
            sysUserIds[i]=sysUserService.selectUserByUserName(director.getUserName()).getUserId();
        }
        sysUserService.deleteUserByIds(sysUserIds);
        return directorMapper.deleteDirectorByIds(ids);
    }

    /**
     * 删除课程负责人管理信息
     * 
     * @param id 课程负责人管理主键
     * @return 结果
     */
    @Override
    public int deleteDirectorById(Long id)
    {
        return directorMapper.deleteDirectorById(id);
    }

    @Override
    public List<Course> getCourseList(Course course) {
        return courseMapper.selectCourseList(course);
    }

    @Override
    public Director selectDirectorByUserName(String userName) {
        Director director = directorMapper.selectDirectorByUserName(userName);
        return director;
    }
}
