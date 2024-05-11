package edu.zut.chz.system.service.impl;

import java.util.List;
import edu.zut.chz.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.zut.chz.system.mapper.ChapterMapper;
import edu.zut.chz.system.domain.Chapter;
import edu.zut.chz.system.service.IChapterService;

/**
 * 章节Service业务层处理
 * 
 * @author anmingnuo
 * @date 2024-05-04
 */
@Service
public class ChapterServiceImpl implements IChapterService
{
    @Autowired
    private ChapterMapper chapterMapper;

    /**
     * 查询章节
     * 
     * @param id 章节主键
     * @return 章节
     */
    @Override
    public Chapter selectChapterById(Long id)
    {
        return chapterMapper.selectChapterById(id);
    }

    /**
     * 查询章节列表
     * 
     * @param chapter 章节
     * @return 章节
     */
    @Override
    public List<Chapter> selectChapterList(Chapter chapter)
    {
        return chapterMapper.selectChapterList(chapter);
    }

    /**
     * 新增章节
     * 
     * @param chapter 章节
     * @return 结果
     */
    @Override
    public int insertChapter(Chapter chapter)
    {
        chapter.setCreateTime(DateUtils.getNowDate());
        return chapterMapper.insertChapter(chapter);
    }

    /**
     * 修改章节
     * 
     * @param chapter 章节
     * @return 结果
     */
    @Override
    public int updateChapter(Chapter chapter)
    {
        chapter.setUpdateTime(DateUtils.getNowDate());
        return chapterMapper.updateChapter(chapter);
    }

    /**
     * 批量删除章节
     * 
     * @param ids 需要删除的章节主键
     * @return 结果
     */
    @Override
    public int deleteChapterByIds(Long[] ids)
    {
        return chapterMapper.deleteChapterByIds(ids);
    }

    /**
     * 删除章节信息
     * 
     * @param id 章节主键
     * @return 结果
     */
    @Override
    public int deleteChapterById(Long id)
    {
        return chapterMapper.deleteChapterById(id);
    }
}
