package edu.zut.chz.system.service;

import java.util.List;
import edu.zut.chz.system.domain.Grade;

/**
 * 年级Service接口
 * 
 * @author anmingnuo
 * @date 2024-05-02
 */
public interface IGradeService
{
    /**
     * 查询年级
     * 
     * @param id 年级主键
     * @return 年级
     */
    public Grade selectGradeById(Long id);

    /**
     * 查询年级列表
     * 
     * @param grade 年级
     * @return 年级集合
     */
    public List<Grade> selectGradeList(Grade grade);

    /**
     * 新增年级
     * 
     * @param grade 年级
     * @return 结果
     */
    public int insertGrade(Grade grade);

    /**
     * 修改年级
     * 
     * @param grade 年级
     * @return 结果
     */
    public int updateGrade(Grade grade);

    /**
     * 批量删除年级
     * 
     * @param ids 需要删除的年级主键集合
     * @return 结果
     */
    public int deleteGradeByIds(Long[] ids);

    /**
     * 删除年级信息
     * 
     * @param id 年级主键
     * @return 结果
     */
    public int deleteGradeById(Long id);
}
