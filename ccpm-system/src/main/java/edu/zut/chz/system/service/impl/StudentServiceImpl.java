package edu.zut.chz.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.zut.chz.common.core.domain.entity.SysUser;
import edu.zut.chz.common.utils.DateUtils;
import edu.zut.chz.common.utils.SecurityUtils;
import edu.zut.chz.system.domain.Clazz;
import edu.zut.chz.system.domain.Teacher;
import edu.zut.chz.system.mapper.ClazzMapper;
import edu.zut.chz.system.mapper.SysUserRoleMapper;
import edu.zut.chz.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.mapper.StudentMapper;
import edu.zut.chz.system.domain.Student;
import edu.zut.chz.system.service.IStudentService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 学生管理Service业务层处理
 *
 * @author anmingnuo
 * @date 2024-05-03
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询学生管理
     *
     * @param id 学生管理主键
     * @return 学生管理
     */
    @Override
    public Student selectStudentById(Long id) {
        return studentMapper.selectStudentById(id);
    }

    /**
     * 查询学生管理列表
     *
     * @param student 学生管理
     * @return 学生管理
     */
    @Override
    public List<Student> selectStudentList(Student student) {
        return studentMapper.selectStudentList(student);
    }

    /**
     * 新增学生管理
     *
     * @param student 学生管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertStudent(Student student) {
        student.setCreateTime(DateUtils.getNowDate());
        SysUser sysUser=new SysUser();
        sysUser.setUserName(student.getUserName());
        sysUser.setNickName(student.getNickName());
        sysUser.setPassword(SecurityUtils.encryptPassword(student.getPassword()));
        sysUser.setSex(student.getGender());
        sysUser.setRoleIds(new Long[]{100L});
        sysUserService.insertUser(sysUser);
        return studentMapper.insertStudent(student);
    }

    /**
     * 修改学生管理
     *
     * @param student 学生管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateStudent(Student student) {
        student.setUpdateTime(DateUtils.getNowDate());
        SysUser sysUser=new SysUser();
        sysUser.setUserId(sysUserService.selectUserByUserName(student.getUserName()).getUserId());
//        sysUser.setUserName(student.getUserName());
        sysUser.setNickName(student.getNickName());
        sysUser.setPassword(SecurityUtils.encryptPassword(student.getPassword()));
        sysUser.setSex(student.getGender());
        sysUser.setRoleIds(new Long[]{100L});
        sysUserService.updateUser(sysUser);
        return studentMapper.updateStudent(student);
    }

    /**
     * 批量删除学生管理
     *
     * @param ids 需要删除的学生管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteStudentByIds(Long[] ids) {
        Long[] sysUserIds=new Long[ids.length];
        for (int i=0;i<ids.length;i++){
            Student student = studentMapper.selectStudentById(ids[i]);
            sysUserIds[i]=sysUserService.selectUserByUserName(student.getUserName()).getUserId();
        }
        sysUserService.deleteUserByIds(sysUserIds);
        return studentMapper.deleteStudentByIds(ids);
    }

    /**
     * 删除学生管理信息
     *
     * @param id 学生管理主键
     * @return 结果
     */
    @Override
    public int deleteStudentById(Long id) {
        return studentMapper.deleteStudentById(id);
    }

    @Override
    public List<Clazz> getClazzList(Clazz clazz) {
        return clazzMapper.selectClazzList(clazz);
    }
}
