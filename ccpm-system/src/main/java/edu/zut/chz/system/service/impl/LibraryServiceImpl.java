package edu.zut.chz.system.service.impl;

import java.util.List;
import edu.zut.chz.common.utils.DateUtils;
import edu.zut.chz.system.domain.Category;
import edu.zut.chz.system.domain.LibraryCategory;
import edu.zut.chz.system.domain.vo.LibraryViewEChartsVo;
import edu.zut.chz.system.mapper.CategoryMapper;
import edu.zut.chz.system.mapper.LibraryCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.mapper.LibraryMapper;
import edu.zut.chz.system.domain.Library;
import edu.zut.chz.system.service.ILibraryService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 思政库Service业务层处理
 * 
 * @author anmingnuo
 * @date 2024-05-05
 */
@Service
public class LibraryServiceImpl implements ILibraryService
{
    @Autowired
    private LibraryMapper libraryMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private LibraryCategoryMapper libraryCategoryMapper;
    /**
     * 查询思政库
     * 
     * @param id 思政库主键
     * @return 思政库
     */
    @Override
    public Library selectLibraryById(Long id)
    {
        return libraryMapper.selectLibraryById(id);
    }

    /**
     * 查询思政库列表
     * 
     * @param library 思政库
     * @return 思政库
     */
    @Override
    public List<Library> selectLibraryList(Library library)
    {
        return libraryMapper.selectLibraryList(library);
    }

    /**
     * 新增思政库
     * 
     * @param library 思政库
     * @return 结果
     */
    @Transactional
    @Override
    public int insertLibrary(Library library)
    {
        library.setCreateTime(DateUtils.getNowDate());
        int rows = libraryMapper.insertLibrary(library);
        LibraryCategory libraryCategory=new LibraryCategory();
        libraryCategory.setCategoryId(library.getSecondCategoryId());
        libraryCategory.setLibraryId(library.getId());
        libraryCategoryMapper.insertLibraryCategory(libraryCategory);
        return rows;
    }

    /**
     * 修改思政库
     * 
     * @param library 思政库
     * @return 结果
     */
    @Transactional
    @Override
    public int updateLibrary(Library library)
    {
        library.setUpdateTime(DateUtils.getNowDate());
        int rows = libraryMapper.updateLibrary(library);
        LibraryCategory libraryCategory = libraryCategoryMapper.selectLibraryCategoryByLibraryId(library.getId());
        libraryCategory.setCategoryId(library.getSecondCategoryId());
        libraryCategoryMapper.updateLibraryCategory(libraryCategory);
        return rows;
    }

    /**
     * 批量删除思政库
     * 
     * @param ids 需要删除的思政库主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteLibraryByIds(Long[] ids)
    {
        libraryCategoryMapper.deleteLibraryCategoryByLibraryIds(ids);
        return libraryMapper.deleteLibraryByIds(ids);
    }

    /**
     * 删除思政库信息
     * 
     * @param id 思政库主键
     * @return 结果
     */
    @Override
    public int deleteLibraryById(Long id)
    {
        return libraryMapper.deleteLibraryById(id);
    }

    @Override
    public List<Category> getFirstCategoryList(Category category) {
        category.setCategoryType(0L);
        return categoryMapper.selectCategoryList(category);
    }

    @Override
    public List<Category> getSecondCategoryList(Long firstCategoryId) {
        Category category=new Category();
        category.setParentId(firstCategoryId);
        category.setCategoryType(1L);
        return categoryMapper.selectCategoryList(category);
    }

    @Override
    public Library viewLibrary(Long id) {
        Library library = libraryMapper.selectLibraryById(id);
        Long views = library.getViews();
        views++;
        library.setViews(views);
        libraryMapper.updateLibrary(library);
        return library;
    }

    @Override
    public List<LibraryViewEChartsVo> getLibraryViewECharts() {
        return libraryMapper.getLibraryViewECharts();
    }
}
