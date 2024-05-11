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
import edu.zut.chz.system.domain.Major;
import edu.zut.chz.system.service.IMajorService;
import edu.zut.chz.common.utils.poi.ExcelUtil;
import edu.zut.chz.common.core.page.TableDataInfo;

/**
 * 专业Controller
 * 
 * @author anmingnuo
 * @date 2024-05-02
 */
@RestController
@RequestMapping("/system/major")
public class MajorController extends BaseController
{
    @Autowired
    private IMajorService majorService;

    /**
     * 查询专业列表
     */
    @PreAuthorize("@ss.hasPermi('system:major:list')")
    @GetMapping("/list")
    public TableDataInfo list(Major major)
    {
        startPage();
        List<Major> list = majorService.selectMajorList(major);
        return getDataTable(list);
    }

    /**
     * 导出专业列表
     */
    @PreAuthorize("@ss.hasPermi('system:major:export')")
    @Log(title = "专业", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Major major)
    {
        List<Major> list = majorService.selectMajorList(major);
        ExcelUtil<Major> util = new ExcelUtil<Major>(Major.class);
        util.exportExcel(response, list, "专业数据");
    }

    /**
     * 获取专业详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:major:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(majorService.selectMajorById(id));
    }

    /**
     * 新增专业
     */
    @PreAuthorize("@ss.hasPermi('system:major:add')")
    @Log(title = "专业", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Major major)
    {
        return toAjax(majorService.insertMajor(major));
    }

    /**
     * 修改专业
     */
    @PreAuthorize("@ss.hasPermi('system:major:edit')")
    @Log(title = "专业", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Major major)
    {
        return toAjax(majorService.updateMajor(major));
    }

    /**
     * 删除专业
     */
    @PreAuthorize("@ss.hasPermi('system:major:remove')")
    @Log(title = "专业", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(majorService.deleteMajorByIds(ids));
    }
}
