package edu.zut.chz.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import edu.zut.chz.system.domain.vo.LibrarySectionEChartsVo;
import edu.zut.chz.system.domain.vo.SelectionVo;
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
import edu.zut.chz.system.domain.Selection;
import edu.zut.chz.system.service.ISelectionService;
import edu.zut.chz.common.utils.poi.ExcelUtil;
import edu.zut.chz.common.core.page.TableDataInfo;

/**
 * 元素选取Controller
 *
 * @author anmingnuo
 * @date 2024-05-06
 */
@RestController
@RequestMapping("/system/selection")
public class SelectionController extends BaseController {
    @Autowired
    private ISelectionService selectionService;

    @PreAuthorize("@ss.hasPermi('system:selection:list')")
    @GetMapping("/directorListSelection/{userId}")
    public TableDataInfo directorListSelection(@PathVariable("userId") Long userId,
                                               Selection selection) {
        startPage();
        List<Selection> list = selectionService.directorListSelection(userId, selection);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('system:selection:list')")
    @GetMapping("/teacherListSelection/{userId}")
    public TableDataInfo teacherListSelection(@PathVariable("userId") Long userId,
                                              Selection selection) {
        startPage();
        List<Selection> list = selectionService.teacherListSelection(userId, selection);
        return getDataTable(list);
    }

    /**
     * 查询元素选取列表
     */

    @PreAuthorize("@ss.hasPermi('system:selection:list')")
    @GetMapping("/list")
    public TableDataInfo list(Selection selection) {
        startPage();
        List<Selection> list = selectionService.selectSelectionList(selection);
        return getDataTable(list);
    }

    /**
     * 导出元素选取列表
     */
    @PreAuthorize("@ss.hasPermi('system:selection:export')")
    @Log(title = "元素选取", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Selection selection) {
        List<Selection> list = selectionService.selectSelectionList(selection);
        ExcelUtil<Selection> util = new ExcelUtil<Selection>(Selection.class);
        util.exportExcel(response, list, "元素选取数据");
    }

    @PreAuthorize("@ss.hasPermi('system:selection:query')")
    @GetMapping(value = "{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(selectionService.selectSelectionById(id));
    }

    /**
     * 获取元素选取详细信息
     */
    @GetMapping(value = "getLibrarySectionECharts")
    public AjaxResult getLibrarySectionECharts() {
        List<LibrarySectionEChartsVo> librarySectionECharts = selectionService.getLibrarySectionECharts();
        System.out.println(librarySectionECharts);
        return success(librarySectionECharts);
    }

    /**
     * 新增元素选取
     */
    @PreAuthorize("@ss.hasPermi('system:selection:add')")
    @Log(title = "元素选取", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelectionVo selectionVo) {
        return toAjax(selectionService.insertSelection(selectionVo));
    }

    /**
     * 修改元素选取
     */
    @PreAuthorize("@ss.hasPermi('system:selection:edit')")
    @Log(title = "元素选取", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Selection selection) {
        return toAjax(selectionService.updateSelection(selection));
    }

    /**
     * 删除元素选取
     */
    @PreAuthorize("@ss.hasPermi('system:selection:remove')")
    @Log(title = "元素选取", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(selectionService.deleteSelectionByIds(ids));
    }
}
