package edu.zut.chz.system.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import edu.zut.chz.common.core.domain.entity.SysUser;
import edu.zut.chz.common.utils.DateUtils;
import edu.zut.chz.common.utils.SecurityUtils;
import edu.zut.chz.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.mapper.TeacherMapper;
import edu.zut.chz.system.domain.Teacher;
import edu.zut.chz.system.service.ITeacherService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 教师管理Service业务层处理
 * 
 * @author anmingnuo
 * @date 2024-05-04
 */
@Service
public class TeacherServiceImpl implements ITeacherService
{
    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private ISysUserService sysUserService;
    /**
     * 查询教师管理
     * 
     * @param id 教师管理主键
     * @return 教师管理
     */
    @Override
    public Teacher selectTeacherById(Long id)
    {
        return teacherMapper.selectTeacherById(id);
    }

    /**
     * 查询教师管理列表
     * 
     * @param teacher 教师管理
     * @return 教师管理
     */
    @Override
    public List<Teacher> selectTeacherList(Teacher teacher)
    {
        return teacherMapper.selectTeacherList(teacher);
    }

    /**
     * 新增教师管理
     * 
     * @param teacher 教师管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertTeacher(Teacher teacher)
    {
        teacher.setCreateTime(DateUtils.getNowDate());
        SysUser sysUser=new SysUser();
        sysUser.setUserName(teacher.getUserName());
        sysUser.setPassword(SecurityUtils.encryptPassword(teacher.getPassword()));
        sysUser.setNickName(teacher.getNickName());
        sysUser.setSex(teacher.getGender());
        sysUser.setRoleIds(new Long[]{103L});
        sysUserService.insertUser(sysUser);
        return teacherMapper.insertTeacher(teacher);
    }

    /**
     * 修改教师管理
     * 
     * @param teacher 教师管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateTeacher(Teacher teacher)
    {
        teacher.setUpdateTime(DateUtils.getNowDate());
        SysUser sysUser=new SysUser();
        sysUser.setUserId(sysUserService.selectUserByUserName(teacher.getUserName()).getUserId());
//        sysUser.setUserName(teacher.getUserName());
        sysUser.setPassword(SecurityUtils.encryptPassword(teacher.getPassword()));
        sysUser.setNickName(teacher.getNickName());
        sysUser.setSex(teacher.getGender());
        sysUser.setRoleIds(new Long[]{103L});
        sysUserService.updateUser(sysUser);
        return teacherMapper.updateTeacher(teacher);
    }

    /**
     * 批量删除教师管理
     * 
     * @param ids 需要删除的教师管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTeacherByIds(Long[] ids)
    {
        Long[] sysUserIds=new Long[ids.length];
        for (int i=0;i<ids.length;i++){
            Teacher teacher = teacherMapper.selectTeacherById(ids[i]);
            sysUserIds[i]=sysUserService.selectUserByUserName(teacher.getUserName()).getUserId();
        }
        sysUserService.deleteUserByIds(sysUserIds);
        return teacherMapper.deleteTeacherByIds(ids);
    }

    /**
     * 删除教师管理信息
     * 
     * @param id 教师管理主键
     * @return 结果
     */
    @Override
    public int deleteTeacherById(Long id)
    {
        return teacherMapper.deleteTeacherById(id);
    }
}
