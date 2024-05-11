package edu.zut.chz.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import edu.zut.chz.system.domain.Direction;
import edu.zut.chz.system.domain.Grade;
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
import edu.zut.chz.system.domain.Clazz;
import edu.zut.chz.system.service.IClazzService;
import edu.zut.chz.common.utils.poi.ExcelUtil;
import edu.zut.chz.common.core.page.TableDataInfo;

/**
 * 班级Controller
 * 
 * @author anmingnuo
 * @date 2024-05-02
 */
@RestController
@RequestMapping("/system/clazz")
public class ClazzController extends BaseController
{
    @Autowired
    private IClazzService clazzService;

    /**
     * 查询年级列表
     */
    @GetMapping("/gradeList")
    public AjaxResult gradeList(Grade grade)
    {

        return success(clazzService.getGradeList(grade));
    }
    /**
     * 查询方向列表
     */
    @GetMapping("/directionList")
    public AjaxResult directionList(Direction direction)
    {
        return success(clazzService.getDirectionList(direction));
    }
    /**
     * 查询班级列表
     */
    @PreAuthorize("@ss.hasPermi('system:clazz:list')")
    @GetMapping("/list")
    public TableDataInfo list(Clazz clazz)
    {
        startPage();
        List<Clazz> list = clazzService.selectClazzList(clazz);
        return getDataTable(list);
    }

    /**
     * 导出班级列表
     */
    @PreAuthorize("@ss.hasPermi('system:clazz:export')")
    @Log(title = "班级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Clazz clazz)
    {
        List<Clazz> list = clazzService.selectClazzList(clazz);
        ExcelUtil<Clazz> util = new ExcelUtil<Clazz>(Clazz.class);
        util.exportExcel(response, list, "班级数据");
    }

    /**
     * 获取班级详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:clazz:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(clazzService.selectClazzById(id));
    }

    /**
     * 新增班级
     */
    @PreAuthorize("@ss.hasPermi('system:clazz:add')")
    @Log(title = "班级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Clazz clazz)
    {
        return toAjax(clazzService.insertClazz(clazz));
    }

    /**
     * 修改班级
     */
    @PreAuthorize("@ss.hasPermi('system:clazz:edit')")
    @Log(title = "班级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Clazz clazz)
    {
        return toAjax(clazzService.updateClazz(clazz));
    }

    /**
     * 删除班级
     */
    @PreAuthorize("@ss.hasPermi('system:clazz:remove')")
    @Log(title = "班级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(clazzService.deleteClazzByIds(ids));
    }
}
