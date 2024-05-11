package edu.zut.chz.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.zut.chz.common.core.domain.entity.SysUser;
import edu.zut.chz.common.utils.DateUtils;
import edu.zut.chz.system.domain.Director;
import edu.zut.chz.system.domain.Group;
import edu.zut.chz.system.domain.Library;
import edu.zut.chz.system.domain.vo.LibrarySectionEChartsVo;
import edu.zut.chz.system.domain.vo.SelectionVo;
import edu.zut.chz.system.mapper.DirectorMapper;
import edu.zut.chz.system.mapper.GroupMapper;
import edu.zut.chz.system.mapper.LibraryMapper;
import edu.zut.chz.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.mapper.SelectionMapper;
import edu.zut.chz.system.domain.Selection;
import edu.zut.chz.system.service.ISelectionService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 元素选取Service业务层处理
 * 
 * @author anmingnuo
 * @date 2024-05-06
 */
@Service
public class SelectionServiceImpl implements ISelectionService
{
    @Autowired
    private SelectionMapper selectionMapper;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private DirectorMapper directorMapper;
    @Autowired
    private LibraryMapper libraryMapper;
    @Autowired
    private GroupMapper groupMapper;
    /**
     * 查询元素选取
     * 
     * @param id 元素选取主键
     * @return 元素选取
     */
    @Override
    public Selection selectSelectionById(Long id)
    {
        return selectionMapper.selectSelectionById(id);
    }

    /**
     * 查询元素选取列表
     * 
     * @param selection 元素选取
     * @return 元素选取
     */
    @Override
    public List<Selection> selectSelectionList(Selection selection)
    {
        return selectionMapper.selectSelectionList(selection);
    }

    /**
     * 新增元素选取
     * 
     * @param selectionVo 元素选取
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSelection(SelectionVo selectionVo)
    {
        Long userId = selectionVo.getUserId();
        Long libraryId = selectionVo.getLibraryId();
        SysUser sysUser = userService.selectUserById(userId);
        Director director = directorMapper.selectDirectorByUserName(sysUser.getUserName());
        Long courseId = director.getCourseId();
        Selection selection=new Selection();
        selection.setCourseId(courseId);
        selection.setLibraryId(libraryId);
        Library library = libraryMapper.selectLibraryById(libraryId);
        Long selectionCount = library.getSelectionCount();
        selectionCount++;
        library.setSelectionCount(selectionCount);
        libraryMapper.updateLibrary(library);
        return selectionMapper.insertSelection(selection);
    }

    /**
     * 修改元素选取
     * 
     * @param selection 元素选取
     * @return 结果
     */
    @Override
    public int updateSelection(Selection selection)
    {
        selection.setUpdateTime(DateUtils.getNowDate());
        return selectionMapper.updateSelection(selection);
    }

    /**
     * 批量删除元素选取
     * 
     * @param ids 需要删除的元素选取主键
     * @return 结果
     */
    @Override
    public int deleteSelectionByIds(Long[] ids)
    {
        return selectionMapper.deleteSelectionByIds(ids);
    }

    /**
     * 删除元素选取信息
     * 
     * @param id 元素选取主键
     * @return 结果
     */
    @Override
    public int deleteSelectionById(Long id)
    {
        return selectionMapper.deleteSelectionById(id);
    }

    @Override
    public List<Selection> directorListSelection(Long userId, Selection selection) {
        SysUser sysUser = userService.selectUserById(userId);
        Director director = directorMapper.selectDirectorByUserName(sysUser.getUserName());
        Long courseId = director.getCourseId();
        selection.setCourseId(courseId);
        return selectionMapper.selectSelectionList(selection);
    }

    @Override
    public List<Selection> teacherListSelection(Long userId, Selection selection) {
        List<Group> groupList = groupMapper.selectGroupListByUserId(userId);
        List<Selection> res=new ArrayList<>();
        for (Group group:groupList){
            Long courseId = group.getCourseId();
            selection.setCourseId(courseId);
            List<Selection> selectionList = selectionMapper.selectSelectionList(selection);
            res.addAll(selectionList);
        }
        return res;
    }

    @Override
    public List<LibrarySectionEChartsVo> getLibrarySectionECharts() {
        return selectionMapper.getLibrarySectionECharts();
    }
}
