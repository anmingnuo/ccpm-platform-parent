package edu.zut.chz.system.mapper;

import java.util.List;
import edu.zut.chz.system.domain.Boppps;

/**
 * bopppsMapper接口
 * 
 * @author anmingnuo
 * @date 2024-05-06
 */
public interface BopppsMapper 
{
    /**
     * 查询boppps
     * 
     * @param id boppps主键
     * @return boppps
     */
    public Boppps selectBopppsById(Long id);

    /**
     * 查询boppps列表
     * 
     * @param boppps boppps
     * @return boppps集合
     */
    public List<Boppps> selectBopppsList(Boppps boppps);

    /**
     * 新增boppps
     * 
     * @param boppps boppps
     * @return 结果
     */
    public int insertBoppps(Boppps boppps);

    /**
     * 修改boppps
     * 
     * @param boppps boppps
     * @return 结果
     */
    public int updateBoppps(Boppps boppps);

    /**
     * 删除boppps
     * 
     * @param id boppps主键
     * @return 结果
     */
    public int deleteBopppsById(Long id);

    /**
     * 批量删除boppps
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBopppsByIds(Long[] ids);
}
