package edu.zut.chz.system.service;

import java.util.List;
import edu.zut.chz.system.domain.Major;

/**
 * 专业Service接口
 * 
 * @author anmingnuo
 * @date 2024-05-02
 */
public interface IMajorService
{
    /**
     * 查询专业
     * 
     * @param id 专业主键
     * @return 专业
     */
    public Major selectMajorById(Long id);

    /**
     * 查询专业列表
     * 
     * @param major 专业
     * @return 专业集合
     */
    public List<Major> selectMajorList(Major major);

    /**
     * 新增专业
     * 
     * @param major 专业
     * @return 结果
     */
    public int insertMajor(Major major);

    /**
     * 修改专业
     * 
     * @param major 专业
     * @return 结果
     */
    public int updateMajor(Major major);

    /**
     * 批量删除专业
     * 
     * @param ids 需要删除的专业主键集合
     * @return 结果
     */
    public int deleteMajorByIds(Long[] ids);

    /**
     * 删除专业信息
     * 
     * @param id 专业主键
     * @return 结果
     */
    public int deleteMajorById(Long id);
}
