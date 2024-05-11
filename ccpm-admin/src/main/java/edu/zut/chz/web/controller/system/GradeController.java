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
import edu.zut.chz.system.domain.Grade;
import edu.zut.chz.system.service.IGradeService;
import edu.zut.chz.common.utils.poi.ExcelUtil;
import edu.zut.chz.common.core.page.TableDataInfo;

/**
 * 年级Controller
 * 
 * @author anmingnuo
 * @date 2024-05-02
 */
@RestController
@RequestMapping("/system/grade")
public class GradeController extends BaseController
{
    @Autowired
    private IGradeService gradeService;

    /**
     * 查询年级列表
     */
    @PreAuthorize("@ss.hasPermi('system:grade:list')")
    @GetMapping("/list")
    public TableDataInfo list(Grade grade)
    {
        startPage();
        List<Grade> list = gradeService.selectGradeList(grade);
        return getDataTable(list);
    }

    /**
     * 导出年级列表
     */
    @PreAuthorize("@ss.hasPermi('system:grade:export')")
    @Log(title = "年级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Grade grade)
    {
        List<Grade> list = gradeService.selectGradeList(grade);
        ExcelUtil<Grade> util = new ExcelUtil<Grade>(Grade.class);
        util.exportExcel(response, list, "年级数据");
    }

    /**
     * 获取年级详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:grade:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(gradeService.selectGradeById(id));
    }

    /**
     * 新增年级
     */
    @PreAuthorize("@ss.hasPermi('system:grade:add')")
    @Log(title = "年级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Grade grade)
    {
        return toAjax(gradeService.insertGrade(grade));
    }

    /**
     * 修改年级
     */
    @PreAuthorize("@ss.hasPermi('system:grade:edit')")
    @Log(title = "年级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Grade grade)
    {
        return toAjax(gradeService.updateGrade(grade));
    }

    /**
     * 删除年级
     */
    @PreAuthorize("@ss.hasPermi('system:grade:remove')")
    @Log(title = "年级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(gradeService.deleteGradeByIds(ids));
    }
}
