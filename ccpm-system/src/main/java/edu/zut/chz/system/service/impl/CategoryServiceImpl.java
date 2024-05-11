package edu.zut.chz.system.service.impl;

import java.util.List;
import edu.zut.chz.common.utils.DateUtils;
import edu.zut.chz.system.domain.vo.LibraryCategoryEChartsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.mapper.CategoryMapper;
import edu.zut.chz.system.domain.Category;
import edu.zut.chz.system.service.ICategoryService;

/**
 * 思政类别Service业务层处理
 * 
 * @author anmingnuo
 * @date 2024-05-05
 */
@Service
public class CategoryServiceImpl implements ICategoryService
{
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询思政类别
     * 
     * @param id 思政类别主键
     * @return 思政类别
     */
    @Override
    public Category selectCategoryById(Long id)
    {
        return categoryMapper.selectCategoryById(id);
    }

    /**
     * 查询思政类别列表
     * 
     * @param category 思政类别
     * @return 思政类别
     */
    @Override
    public List<Category> selectCategoryList(Category category)
    {
        return categoryMapper.selectCategoryList(category);
    }

    /**
     * 新增思政类别
     * 
     * @param category 思政类别
     * @return 结果
     */
    @Override
    public int insertCategory(Category category)
    {
        category.setCreateTime(DateUtils.getNowDate());
        return categoryMapper.insertCategory(category);
    }

    /**
     * 修改思政类别
     * 
     * @param category 思政类别
     * @return 结果
     */
    @Override
    public int updateCategory(Category category)
    {
        category.setUpdateTime(DateUtils.getNowDate());
        return categoryMapper.updateCategory(category);
    }

    /**
     * 批量删除思政类别
     * 
     * @param ids 需要删除的思政类别主键
     * @return 结果
     */
    @Override
    public int deleteCategoryByIds(Long[] ids)
    {
        return categoryMapper.deleteCategoryByIds(ids);
    }

    /**
     * 删除思政类别信息
     * 
     * @param id 思政类别主键
     * @return 结果
     */
    @Override
    public int deleteCategoryById(Long id)
    {
        return categoryMapper.deleteCategoryById(id);
    }

    @Override
    public List<LibraryCategoryEChartsVo> getCategoryLibraryCount() {
        return categoryMapper.getCategoryLibraryCount();
    }
}
