package edu.zut.chz.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.zut.chz.common.annotation.Log;
import edu.zut.chz.common.core.controller.BaseController;
import edu.zut.chz.common.core.domain.AjaxResult;
import edu.zut.chz.common.enums.BusinessType;
import edu.zut.chz.system.domain.Chapter;
import edu.zut.chz.system.service.IChapterService;
import edu.zut.chz.common.utils.poi.ExcelUtil;

/**
 * 章节Controller
 * 
 * @author anmingnuo
 * @date 2024-05-04
 */
@RestController
@RequestMapping("/system/chapter")
public class ChapterController extends BaseController
{
    @Autowired
    private IChapterService chapterService;

    /**
     * 查询章节列表
     */
    @PreAuthorize("@ss.hasPermi('system:chapter:list')")
    @GetMapping("/list")
    public AjaxResult list(Chapter chapter)
    {
        List<Chapter> list = chapterService.selectChapterList(chapter);
        return success(list);
    }

    /**
     * 导出章节列表
     */
    @PreAuthorize("@ss.hasPermi('system:chapter:export')")
    @Log(title = "章节", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Chapter chapter)
    {
        List<Chapter> list = chapterService.selectChapterList(chapter);
        ExcelUtil<Chapter> util = new ExcelUtil<Chapter>(Chapter.class);
        util.exportExcel(response, list, "章节数据");
    }

    /**
     * 获取章节详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:chapter:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chapterService.selectChapterById(id));
    }

    /**
     * 新增章节
     */
    @PreAuthorize("@ss.hasPermi('system:chapter:add')")
    @Log(title = "章节", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Chapter chapter)
    {
        return toAjax(chapterService.insertChapter(chapter));
    }

    /**
     * 修改章节
     */
    @PreAuthorize("@ss.hasPermi('system:chapter:edit')")
    @Log(title = "章节", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Chapter chapter)
    {
        return toAjax(chapterService.updateChapter(chapter));
    }

    /**
     * 删除章节
     */
    @PreAuthorize("@ss.hasPermi('system:chapter:remove')")
    @Log(title = "章节", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chapterService.deleteChapterByIds(ids));
    }
}
