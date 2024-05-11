package edu.zut.chz.system.service.impl;

import java.util.List;
import edu.zut.chz.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.mapper.PracticeMapper;
import edu.zut.chz.system.domain.Practice;
import edu.zut.chz.system.service.IPracticeService;

/**
 * 实践教学案例Service业务层处理
 * 
 * @author anmingnuo
 * @date 2024-05-06
 */
@Service
public class PracticeServiceImpl implements IPracticeService
{
    @Autowired
    private PracticeMapper practiceMapper;

    /**
     * 查询实践教学案例
     * 
     * @param id 实践教学案例主键
     * @return 实践教学案例
     */
    @Override
    public Practice selectPracticeById(Long id)
    {
        return practiceMapper.selectPracticeById(id);
    }

    /**
     * 查询实践教学案例列表
     * 
     * @param practice 实践教学案例
     * @return 实践教学案例
     */
    @Override
    public List<Practice> selectPracticeList(Practice practice)
    {
        return practiceMapper.selectPracticeList(practice);
    }

    /**
     * 新增实践教学案例
     * 
     * @param practice 实践教学案例
     * @return 结果
     */
    @Override
    public int insertPractice(Practice practice)
    {
        practice.setCreateTime(DateUtils.getNowDate());
        return practiceMapper.insertPractice(practice);
    }

    /**
     * 修改实践教学案例
     * 
     * @param practice 实践教学案例
     * @return 结果
     */
    @Override
    public int updatePractice(Practice practice)
    {
        practice.setUpdateTime(DateUtils.getNowDate());
        return practiceMapper.updatePractice(practice);
    }

    /**
     * 批量删除实践教学案例
     * 
     * @param ids 需要删除的实践教学案例主键
     * @return 结果
     */
    @Override
    public int deletePracticeByIds(Long[] ids)
    {
        return practiceMapper.deletePracticeByIds(ids);
    }

    /**
     * 删除实践教学案例信息
     * 
     * @param id 实践教学案例主键
     * @return 结果
     */
    @Override
    public int deletePracticeById(Long id)
    {
        return practiceMapper.deletePracticeById(id);
    }
}
