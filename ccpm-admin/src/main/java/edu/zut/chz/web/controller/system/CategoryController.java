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
import edu.zut.chz.system.domain.Category;
import edu.zut.chz.system.service.ICategoryService;
import edu.zut.chz.common.utils.poi.ExcelUtil;

/**
 * 思政类别Controller
 * 
 * @author anmingnuo
 * @date 2024-05-05
 */
@RestController
@RequestMapping("/system/category")
public class CategoryController extends BaseController
{
    @Autowired
    private ICategoryService categoryService;
    @GetMapping(value = "getCategoryLibraryCount")
    public AjaxResult getCategoryLibraryCount()
    {
        return success(categoryService.getCategoryLibraryCount());
    }

    /**
     * 查询思政类别列表
     */
    @PreAuthorize("@ss.hasPermi('system:category:list')")
    @GetMapping("/list")
    public AjaxResult list(Category category)
    {
        List<Category> list = categoryService.selectCategoryList(category);
        return success(list);
    }

    /**
     * 导出思政类别列表
     */
    @PreAuthorize("@ss.hasPermi('system:category:export')")
    @Log(title = "思政类别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Category category)
    {
        List<Category> list = categoryService.selectCategoryList(category);
        ExcelUtil<Category> util = new ExcelUtil<Category>(Category.class);
        util.exportExcel(response, list, "思政类别数据");
    }

    /**
     * 获取思政类别详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(categoryService.selectCategoryById(id));
    }

    /**
     * 新增思政类别
     */
    @PreAuthorize("@ss.hasPermi('system:category:add')")
    @Log(title = "思政类别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Category category)
    {
        return toAjax(categoryService.insertCategory(category));
    }

    /**
     * 修改思政类别
     */
    @PreAuthorize("@ss.hasPermi('system:category:edit')")
    @Log(title = "思政类别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Category category)
    {
        return toAjax(categoryService.updateCategory(category));
    }

    /**
     * 删除思政类别
     */
    @PreAuthorize("@ss.hasPermi('system:category:remove')")
    @Log(title = "思政类别", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(categoryService.deleteCategoryByIds(ids));
    }
}
