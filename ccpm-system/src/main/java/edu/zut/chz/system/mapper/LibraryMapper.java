package edu.zut.chz.system.mapper;

import java.util.List;
import edu.zut.chz.system.domain.Library;
import edu.zut.chz.system.domain.vo.LibraryViewEChartsVo;
import org.apache.ibatis.annotations.Param;

/**
 * 思政库Mapper接口
 * 
 * @author anmingnuo
 * @date 2024-05-05
 */
public interface LibraryMapper 
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
     * 删除思政库
     * 
     * @param id 思政库主键
     * @return 结果
     */
    public int deleteLibraryById(Long id);

    /**
     * 批量删除思政库
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLibraryByIds(Long[] ids);

    Library selectLibraryNameAndIdById(@Param("libraryId") Long libraryId);

    List<LibraryViewEChartsVo> getLibraryViewECharts();
}
