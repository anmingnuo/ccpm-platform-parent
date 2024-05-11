package edu.zut.chz.system.service;

import java.util.List;
import edu.zut.chz.system.domain.Category;
import edu.zut.chz.system.domain.vo.LibraryCategoryEChartsVo;

/**
 * 思政类别Service接口
 * 
 * @author anmingnuo
 * @date 2024-05-05
 */
public interface ICategoryService
{
    /**
     * 查询思政类别
     * 
     * @param id 思政类别主键
     * @return 思政类别
     */
    public Category selectCategoryById(Long id);

    /**
     * 查询思政类别列表
     * 
     * @param category 思政类别
     * @return 思政类别集合
     */
    public List<Category> selectCategoryList(Category category);

    /**
     * 新增思政类别
     * 
     * @param category 思政类别
     * @return 结果
     */
    public int insertCategory(Category category);

    /**
     * 修改思政类别
     * 
     * @param category 思政类别
     * @return 结果
     */
    public int updateCategory(Category category);

    /**
     * 批量删除思政类别
     * 
     * @param ids 需要删除的思政类别主键集合
     * @return 结果
     */
    public int deleteCategoryByIds(Long[] ids);

    /**
     * 删除思政类别信息
     * 
     * @param id 思政类别主键
     * @return 结果
     */
    public int deleteCategoryById(Long id);

    List<LibraryCategoryEChartsVo> getCategoryLibraryCount();
}
