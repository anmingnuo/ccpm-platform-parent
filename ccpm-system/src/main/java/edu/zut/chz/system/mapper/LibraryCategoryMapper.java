package edu.zut.chz.system.mapper;

import java.util.List;
import edu.zut.chz.system.domain.LibraryCategory;

/**
 * 思政类别Mapper接口
 * 
 * @author anmingnuo
 * @date 2024-05-05
 */
public interface LibraryCategoryMapper 
{
    /**
     * 查询思政类别
     * 
     * @param libraryId 思政类别主键
     * @return 思政类别
     */
    public LibraryCategory selectLibraryCategoryByLibraryId(Long libraryId);

    /**
     * 查询思政类别列表
     * 
     * @param libraryCategory 思政类别
     * @return 思政类别集合
     */
    public List<LibraryCategory> selectLibraryCategoryList(LibraryCategory libraryCategory);

    /**
     * 新增思政类别
     * 
     * @param libraryCategory 思政类别
     * @return 结果
     */
    public int insertLibraryCategory(LibraryCategory libraryCategory);

    /**
     * 修改思政类别
     * 
     * @param libraryCategory 思政类别
     * @return 结果
     */
    public int updateLibraryCategory(LibraryCategory libraryCategory);

    /**
     * 删除思政类别
     * 
     * @param libraryId 思政类别主键
     * @return 结果
     */
    public int deleteLibraryCategoryByLibraryId(Long libraryId);

    /**
     * 批量删除思政类别
     * 
     * @param libraryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLibraryCategoryByLibraryIds(Long[] libraryIds);
}
