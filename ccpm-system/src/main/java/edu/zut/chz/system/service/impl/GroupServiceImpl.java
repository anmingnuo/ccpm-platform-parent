package edu.zut.chz.system.service.impl;

import java.util.List;

import edu.zut.chz.common.core.domain.entity.SysRole;
import edu.zut.chz.common.core.domain.entity.SysUser;
import edu.zut.chz.common.utils.DateUtils;
import edu.zut.chz.system.domain.Director;
import edu.zut.chz.system.domain.Teacher;
import edu.zut.chz.system.mapper.*;
import edu.zut.chz.system.service.IDirectorService;
import edu.zut.chz.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.domain.Group;
import edu.zut.chz.system.service.IGroupService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 课程组Service业务层处理
 *
 * @author anmingnuo
 * @date 2024-05-05
 */
@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 查询课程组
     *
     * @param id 课程组主键
     * @return 课程组
     */
    @Override
    public Group selectGroupById(Long id) {
        return groupMapper.selectGroupById(id);
    }

    /**
     * 查询课程组列表
     *
     * @param group 课程组
     * @return 课程组
     */
    @Override
    public List<Group> selectGroupList(Group group) {
        Group g = new Group();
        Long userId = group.getUserId();
        List<Long> list = sysRoleMapper.selectRoleListByUserId(userId);
        SysRole sysRole = sysRoleMapper.selectRoleById(list.get(0));
        if (sysRole.getRoleId()==102L||sysRole.getRoleId()==103){
            if (group.getCourseId() == null) {
                g.setUserId(group.getUserId());
            } else {
                g.setCourseId(group.getCourseId());
            }
        }
        return groupMapper.selectGroupList(g);

    }

    /**
     * 新增课程组
     *
     * @param group 课程组
     * @return 结果
     */
    @Transactional
    @Override
    public int insertGroup(Group group) {
        group.setUpdateTime(DateUtils.getNowDate());
        Teacher teacher = teacherMapper.selectTeacherById(group.getUserId());
        SysUser sysUser = userService.selectUserByUserName(teacher.getUserName());
        group.setUserId(sysUser.getUserId());
        return groupMapper.insertGroup(group);
    }

    /**
     * 修改课程组
     *
     * @param group 课程组
     * @return 结果
     */
    @Override
    public int updateGroup(Group group) {

        group.setUpdateTime(DateUtils.getNowDate());
        Teacher teacher = teacherMapper.selectTeacherById(group.getUserId());
        SysUser sysUser = userService.selectUserByUserName(teacher.getUserName());
        group.setUserId(sysUser.getUserId());
        return groupMapper.updateGroup(group);
    }

    /**
     * 批量删除课程组
     *
     * @param ids 需要删除的课程组主键
     * @return 结果
     */
    @Override
    public int deleteGroupByIds(Long[] ids) {
        return groupMapper.deleteGroupByIds(ids);
    }

    /**
     * 删除课程组信息
     *
     * @param id 课程组主键
     * @return 结果
     */
    @Override
    public int deleteGroupById(Long id) {
        return groupMapper.deleteGroupById(id);
    }

    @Override
    public List<Teacher> getTeacherList(Teacher teacher) {
        return teacherMapper.selectTeacherList(teacher);
    }
}
