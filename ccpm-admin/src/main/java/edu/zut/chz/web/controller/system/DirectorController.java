package edu.zut.chz.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import edu.zut.chz.system.domain.Course;
import org.aspectj.weaver.loadtime.Aj;
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
import edu.zut.chz.system.domain.Director;
import edu.zut.chz.system.service.IDirectorService;
import edu.zut.chz.common.utils.poi.ExcelUtil;
import edu.zut.chz.common.core.page.TableDataInfo;

/**
 * 课程负责人管理Controller
 * 
 * @author anmingnuo
 * @date 2024-05-04
 */
@RestController
@RequestMapping("/system/director")
public class DirectorController extends BaseController
{
    @Autowired
    private IDirectorService directorService;

    @GetMapping("/getCourseList")
    public AjaxResult getCourseList(Course course){
        return success(directorService.getCourseList(course));
    }
    /**
     * 查询课程负责人管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:director:list')")
    @GetMapping("/list")
    public TableDataInfo list(Director director)
    {
        startPage();
        List<Director> list = directorService.selectDirectorList(director);
        return getDataTable(list);
    }

    /**
     * 导出课程负责人管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:director:export')")
    @Log(title = "课程负责人管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Director director)
    {
        List<Director> list = directorService.selectDirectorList(director);
        ExcelUtil<Director> util = new ExcelUtil<Director>(Director.class);
        util.exportExcel(response, list, "课程负责人管理数据");
    }

    /**
     * 获取课程负责人管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:director:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(directorService.selectDirectorById(id));
    }

    /**
     * 新增课程负责人管理
     */
    @PreAuthorize("@ss.hasPermi('system:director:add')")
    @Log(title = "课程负责人管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Director director)
    {
        return toAjax(directorService.insertDirector(director));
    }

    /**
     * 修改课程负责人管理
     */
    @PreAuthorize("@ss.hasPermi('system:director:edit')")
    @Log(title = "课程负责人管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Director director)
    {
        return toAjax(directorService.updateDirector(director));
    }

    /**
     * 删除课程负责人管理
     */
    @PreAuthorize("@ss.hasPermi('system:director:remove')")
    @Log(title = "课程负责人管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(directorService.deleteDirectorByIds(ids));
    }
}
