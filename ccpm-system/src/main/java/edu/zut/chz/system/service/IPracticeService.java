package edu.zut.chz.system.service;

import java.util.List;
import edu.zut.chz.system.domain.Practice;

/**
 * 实践教学案例Service接口
 * 
 * @author anmingnuo
 * @date 2024-05-06
 */
public interface IPracticeService
{
    /**
     * 查询实践教学案例
     * 
     * @param id 实践教学案例主键
     * @return 实践教学案例
     */
    public Practice selectPracticeById(Long id);

    /**
     * 查询实践教学案例列表
     * 
     * @param practice 实践教学案例
     * @return 实践教学案例集合
     */
    public List<Practice> selectPracticeList(Practice practice);

    /**
     * 新增实践教学案例
     * 
     * @param practice 实践教学案例
     * @return 结果
     */
    public int insertPractice(Practice practice);

    /**
     * 修改实践教学案例
     * 
     * @param practice 实践教学案例
     * @return 结果
     */
    public int updatePractice(Practice practice);

    /**
     * 批量删除实践教学案例
     * 
     * @param ids 需要删除的实践教学案例主键集合
     * @return 结果
     */
    public int deletePracticeByIds(Long[] ids);

    /**
     * 删除实践教学案例信息
     * 
     * @param id 实践教学案例主键
     * @return 结果
     */
    public int deletePracticeById(Long id);
}
