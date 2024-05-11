package edu.zut.chz.system.service.impl;

import java.util.List;
import edu.zut.chz.common.utils.DateUtils;
import edu.zut.chz.system.domain.Direction;
import edu.zut.chz.system.domain.Grade;
import edu.zut.chz.system.mapper.DirectionMapper;
import edu.zut.chz.system.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.mapper.ClazzMapper;
import edu.zut.chz.system.domain.Clazz;
import edu.zut.chz.system.service.IClazzService;

/**
 * 班级Service业务层处理
 * 
 * @author anmingnuo
 * @date 2024-05-02
 */
@Service
public class ClazzServiceImpl implements IClazzService
{
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private DirectionMapper directionMapper;

    @Autowired
    private GradeMapper gradeMapper;

    /**
     * 查询班级
     * 
     * @param id 班级主键
     * @return 班级
     */
    @Override
    public Clazz selectClazzById(Long id)
    {
        return clazzMapper.selectClazzById(id);
    }

    /**
     * 查询班级列表
     * 
     * @param clazz 班级
     * @return 班级
     */
    @Override
    public List<Clazz> selectClazzList(Clazz clazz)
    {
        return clazzMapper.selectClazzList(clazz);
    }

    /**
     * 新增班级
     * 
     * @param clazz 班级
     * @return 结果
     */
    @Override
    public int insertClazz(Clazz clazz)
    {
        clazz.setCreateTime(DateUtils.getNowDate());
        return clazzMapper.insertClazz(clazz);
    }

    /**
     * 修改班级
     * 
     * @param clazz 班级
     * @return 结果
     */
    @Override
    public int updateClazz(Clazz clazz)
    {
        clazz.setUpdateTime(DateUtils.getNowDate());
        return clazzMapper.updateClazz(clazz);
    }

    /**
     * 批量删除班级
     * 
     * @param ids 需要删除的班级主键
     * @return 结果
     */
    @Override
    public int deleteClazzByIds(Long[] ids)
    {
        return clazzMapper.deleteClazzByIds(ids);
    }

    /**
     * 删除班级信息
     * 
     * @param id 班级主键
     * @return 结果
     */
    @Override
    public int deleteClazzById(Long id)
    {
        return clazzMapper.deleteClazzById(id);
    }

    @Override
    public List<Grade> getGradeList(Grade grade) {
        return gradeMapper.selectGradeList(grade);
    }

    @Override
    public List<Direction> getDirectionList(Direction direction) {
        return directionMapper.selectDirectionList(direction);
    }
}
