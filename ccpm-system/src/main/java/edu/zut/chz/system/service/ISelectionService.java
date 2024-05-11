package edu.zut.chz.system.service;

import java.util.List;
import edu.zut.chz.system.domain.Selection;
import edu.zut.chz.system.domain.vo.LibrarySectionEChartsVo;
import edu.zut.chz.system.domain.vo.SelectionVo;

/**
 * 元素选取Service接口
 * 
 * @author anmingnuo
 * @date 2024-05-06
 */
public interface ISelectionService
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

     * @return 结果
     */
    public int insertSelection(SelectionVo selectionVo);

    /**
     * 修改元素选取
     * 
     * @param selection 元素选取
     * @return 结果
     */
    public int updateSelection(Selection selection);

    /**
     * 批量删除元素选取
     * 
     * @param ids 需要删除的元素选取主键集合
     * @return 结果
     */
    public int deleteSelectionByIds(Long[] ids);

    /**
     * 删除元素选取信息
     * 
     * @param id 元素选取主键
     * @return 结果
     */
    public int deleteSelectionById(Long id);

    List<Selection> directorListSelection(Long userId, Selection selection);

    List<Selection> teacherListSelection(Long userId, Selection selection);

    List<LibrarySectionEChartsVo> getLibrarySectionECharts();
}
