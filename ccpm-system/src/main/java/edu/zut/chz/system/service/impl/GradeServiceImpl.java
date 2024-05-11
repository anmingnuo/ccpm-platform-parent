package edu.zut.chz.system.service.impl;

import java.util.List;
import edu.zut.chz.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.mapper.GradeMapper;
import edu.zut.chz.system.domain.Grade;
import edu.zut.chz.system.service.IGradeService;

/**
 * 年级Service业务层处理
 * 
 * @author anmingnuo
 * @date 2024-05-02
 */
@Service
public class GradeServiceImpl implements IGradeService
{
    @Autowired
    private GradeMapper gradeMapper;

    /**
     * 查询年级
     * 
     * @param id 年级主键
     * @return 年级
     */
    @Override
    public Grade selectGradeById(Long id)
    {
        return gradeMapper.selectGradeById(id);
    }

    /**
     * 查询年级列表
     * 
     * @param grade 年级
     * @return 年级
     */
    @Override
    public List<Grade> selectGradeList(Grade grade)
    {
        return gradeMapper.selectGradeList(grade);
    }

    /**
     * 新增年级
     * 
     * @param grade 年级
     * @return 结果
     */
    @Override
    public int insertGrade(Grade grade)
    {
        grade.setCreateTime(DateUtils.getNowDate());
        return gradeMapper.insertGrade(grade);
    }

    /**
     * 修改年级
     * 
     * @param grade 年级
     * @return 结果
     */
    @Override
    public int updateGrade(Grade grade)
    {
        grade.setUpdateTime(DateUtils.getNowDate());
        return gradeMapper.updateGrade(grade);
    }

    /**
     * 批量删除年级
     * 
     * @param ids 需要删除的年级主键
     * @return 结果
     */
    @Override
    public int deleteGradeByIds(Long[] ids)
    {
        return gradeMapper.deleteGradeByIds(ids);
    }

    /**
     * 删除年级信息
     * 
     * @param id 年级主键
     * @return 结果
     */
    @Override
    public int deleteGradeById(Long id)
    {
        return gradeMapper.deleteGradeById(id);
    }
}
