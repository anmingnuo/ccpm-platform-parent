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
import edu.zut.chz.system.domain.Practice;
import edu.zut.chz.system.service.IPracticeService;
import edu.zut.chz.common.utils.poi.ExcelUtil;
import edu.zut.chz.common.core.page.TableDataInfo;

/**
 * 实践教学案例Controller
 * 
 * @author anmingnuo
 * @date 2024-05-06
 */
@RestController
@RequestMapping("/system/practice")
public class PracticeController extends BaseController
{
    @Autowired
    private IPracticeService practiceService;

    /**
     * 查询实践教学案例列表
     */
    @PreAuthorize("@ss.hasPermi('system:practice:list')")
    @GetMapping("/list")
    public TableDataInfo list(Practice practice)
    {
        startPage();
        List<Practice> list = practiceService.selectPracticeList(practice);
        return getDataTable(list);
    }

    /**
     * 导出实践教学案例列表
     */
    @PreAuthorize("@ss.hasPermi('system:practice:export')")
    @Log(title = "实践教学案例", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Practice practice)
    {
        List<Practice> list = practiceService.selectPracticeList(practice);
        ExcelUtil<Practice> util = new ExcelUtil<Practice>(Practice.class);
        util.exportExcel(response, list, "实践教学案例数据");
    }

    /**
     * 获取实践教学案例详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:practice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(practiceService.selectPracticeById(id));
    }

    /**
     * 新增实践教学案例
     */
    @PreAuthorize("@ss.hasPermi('system:practice:add')")
    @Log(title = "实践教学案例", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Practice practice)
    {
        return toAjax(practiceService.insertPractice(practice));
    }

    /**
     * 修改实践教学案例
     */
    @PreAuthorize("@ss.hasPermi('system:practice:edit')")
    @Log(title = "实践教学案例", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Practice practice)
    {
        return toAjax(practiceService.updatePractice(practice));
    }

    /**
     * 删除实践教学案例
     */
    @PreAuthorize("@ss.hasPermi('system:practice:remove')")
    @Log(title = "实践教学案例", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(practiceService.deletePracticeByIds(ids));
    }
}
