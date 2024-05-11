package edu.zut.chz.system.service;

import java.util.List;

import edu.zut.chz.system.domain.Category;
import edu.zut.chz.system.domain.Library;
import edu.zut.chz.system.domain.vo.LibraryViewEChartsVo;

/**
 * 思政库Service接口
 * 
 * @author anmingnuo
 * @date 2024-05-05
 */
public interface ILibraryService
{
    /**
     * 查询思政库
     * 
     * @param id 思政库主键
     * @return 思政库
     */
    public Library selectLibraryById(Long id);

    /**
     * 查询思政库列表
     * 
     * @param library 思政库
     * @return 思政库集合
     */
    public List<Library> selectLibraryList(Library library);

    /**
     * 新增思政库
     * 
     * @param library 思政库
     * @return 结果
     */
    public int insertLibrary(Library library);

    /**
     * 修改思政库
     * 
     * @param library 思政库
     * @return 结果
     */
    public int updateLibrary(Library library);

    /**
     * 批量删除思政库
     * 
     * @param ids 需要删除的思政库主键集合
     * @return 结果
     */
    public int deleteLibraryByIds(Long[] ids);

    /**
     * 删除思政库信息
     * 
     * @param id 思政库主键
     * @return 结果
     */
    public int deleteLibraryById(Long id);

    List<Category> getFirstCategoryList(Category category);

    List<Category> getSecondCategoryList(Long firstCategoryId);

    Library viewLibrary(Long id);

    List<LibraryViewEChartsVo> getLibraryViewECharts();
}
