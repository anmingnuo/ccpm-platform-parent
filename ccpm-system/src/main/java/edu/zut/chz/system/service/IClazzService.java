package edu.zut.chz.system.service;

import java.util.List;
import edu.zut.chz.system.domain.Clazz;
import edu.zut.chz.system.domain.Direction;
import edu.zut.chz.system.domain.Grade;

/**
 * 班级Service接口
 * 
 * @author anmingnuo
 * @date 2024-05-02
 */
public interface IClazzService
{
    /**
     * 查询班级
     * 
     * @param id 班级主键
     * @return 班级
     */
    public Clazz selectClazzById(Long id);

    /**
     * 查询班级列表
     * 
     * @param clazz 班级
     * @return 班级集合
     */
    public List<Clazz> selectClazzList(Clazz clazz);

    /**
     * 新增班级
     * 
     * @param clazz 班级
     * @return 结果
     */
    public int insertClazz(Clazz clazz);

    /**
     * 修改班级
     * 
     * @param clazz 班级
     * @return 结果
     */
    public int updateClazz(Clazz clazz);

    /**
     * 批量删除班级
     * 
     * @param ids 需要删除的班级主键集合
     * @return 结果
     */
    public int deleteClazzByIds(Long[] ids);

    /**
     * 删除班级信息
     * 
     * @param id 班级主键
     * @return 结果
     */
    public int deleteClazzById(Long id);

    List<Grade> getGradeList(Grade grade);

    List<Direction> getDirectionList(Direction direction);
}
