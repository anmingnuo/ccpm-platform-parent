package edu.zut.chz.system.service.impl;

import java.util.List;
import edu.zut.chz.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.mapper.MajorMapper;
import edu.zut.chz.system.domain.Major;
import edu.zut.chz.system.service.IMajorService;

/**
 * 专业Service业务层处理
 * 
 * @author anmingnuo
 * @date 2024-05-02
 */
@Service
public class MajorServiceImpl implements IMajorService
{
    @Autowired
    private MajorMapper majorMapper;

    /**
     * 查询专业
     * 
     * @param id 专业主键
     * @return 专业
     */
    @Override
    public Major selectMajorById(Long id)
    {
        return majorMapper.selectMajorById(id);
    }

    /**
     * 查询专业列表
     * 
     * @param major 专业
     * @return 专业
     */
    @Override
    public List<Major> selectMajorList(Major major)
    {
        return majorMapper.selectMajorList(major);
    }

    /**
     * 新增专业
     * 
     * @param major 专业
     * @return 结果
     */
    @Override
    public int insertMajor(Major major)
    {
        major.setCreateTime(DateUtils.getNowDate());
        return majorMapper.insertMajor(major);
    }

    /**
     * 修改专业
     * 
     * @param major 专业
     * @return 结果
     */
    @Override
    public int updateMajor(Major major)
    {
        major.setUpdateTime(DateUtils.getNowDate());
        return majorMapper.updateMajor(major);
    }

    /**
     * 批量删除专业
     * 
     * @param ids 需要删除的专业主键
     * @return 结果
     */
    @Override
    public int deleteMajorByIds(Long[] ids)
    {
        return majorMapper.deleteMajorByIds(ids);
    }

    /**
     * 删除专业信息
     * 
     * @param id 专业主键
     * @return 结果
     */
    @Override
    public int deleteMajorById(Long id)
    {
        return majorMapper.deleteMajorById(id);
    }
}
