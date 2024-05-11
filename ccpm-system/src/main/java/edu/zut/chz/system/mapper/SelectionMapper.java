package edu.zut.chz.system.mapper;

import java.util.List;
import edu.zut.chz.system.domain.Selection;
import edu.zut.chz.system.domain.vo.LibrarySectionEChartsVo;

/**
 * 元素选取Mapper接口
 * 
 * @author anmingnuo
 * @date 2024-05-06
 */
public interface SelectionMapper 
{
    /**
     * 查询元素选取
     * 
     * @param id 元素选取主键
     * @return 元素选取
     */
    public Selection selectSelectionById(Long id);

    /**
     * 查询元素选取列表
     * 
     * @param selection 元素选取
     * @return 元素选取集合
     */
    public List<Selection> selectSelectionList(Selection selection);

    /**
     * 新增元素选取
     * 
     * @param selection 元素选取
     * @return 结果
     */
    public int insertSelection(Selection selection);

    /**
     * 修改元素选取
     * 
     * @param selection 元素选取
     * @return 结果
     */
    public int updateSelection(Selection selection);

    /**
     * 删除元素选取
     * 
     * @param id 元素选取主键
     * @return 结果
     */
    public int deleteSelectionById(Long id);

    /**
     * 批量删除元素选取
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSelectionByIds(Long[] ids);

    List<LibrarySectionEChartsVo> getLibrarySectionECharts();
}
