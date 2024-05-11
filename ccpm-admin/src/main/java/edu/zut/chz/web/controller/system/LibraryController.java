package edu.zut.chz.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import edu.zut.chz.system.domain.Category;
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
import edu.zut.chz.system.domain.Library;
import edu.zut.chz.system.service.ILibraryService;
import edu.zut.chz.common.utils.poi.ExcelUtil;
import edu.zut.chz.common.core.page.TableDataInfo;

/**
 * 思政库Controller
 *
 * @author anmingnuo
 * @date 2024-05-05
 */
@RestController
@RequestMapping("/system/library")
public class LibraryController extends BaseController {
    @Autowired
    private ILibraryService libraryService;

    @GetMapping("getLibraryViewECharts")
    public AjaxResult getLibraryViewECharts() {
        ;
        return success(libraryService.getLibraryViewECharts());
    }
    @GetMapping("getSecondCategoryList/{firstCategoryId}")
    public AjaxResult getSecondCategoryList(@PathVariable("firstCategoryId")Long firstCategoryId) {
        List<Category> categoryList = libraryService.getSecondCategoryList(firstCategoryId);
        return success(categoryList);
    }
    @GetMapping("viewLibrary/{id}")
    public AjaxResult viewLibrary(@PathVariable("id")Long id) {
        return success(libraryService.viewLibrary(id));
    }
    @GetMapping("getFirstCategoryList")
    public AjaxResult getFirstCategoryList(Category category) {
        return success(libraryService.getFirstCategoryList(category));
    }

    /**
     * 查询思政库列表
     */
    @PreAuthorize("@ss.hasPermi('system:library:list')")
    @GetMapping("/list")
    public TableDataInfo list(Library library) {
        startPage();
        List<Library> list = libraryService.selectLibraryList(library);
        return getDataTable(list);
    }

    /**
     * 导出思政库列表
     */
    @PreAuthorize("@ss.hasPermi('system:library:export')")
    @Log(title = "思政库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Library library) {
        List<Library> list = libraryService.selectLibraryList(library);
        ExcelUtil<Library> util = new ExcelUtil<Library>(Library.class);
        util.exportExcel(response, list, "思政库数据");
    }

    /**
     * 获取思政库详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:library:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(libraryService.selectLibraryById(id));
    }

    /**
     * 新增思政库
     */
    @PreAuthorize("@ss.hasPermi('system:library:add')")
    @Log(title = "思政库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Library library) {
        return toAjax(libraryService.insertLibrary(library));
    }

    /**
     * 修改思政库
     */
    @PreAuthorize("@ss.hasPermi('system:library:edit')")
    @Log(title = "思政库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Library library) {
        return toAjax(libraryService.updateLibrary(library));
    }

    /**
     * 删除思政库
     */
    @PreAuthorize("@ss.hasPermi('system:library:remove')")
    @Log(title = "思政库", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(libraryService.deleteLibraryByIds(ids));
    }
}
