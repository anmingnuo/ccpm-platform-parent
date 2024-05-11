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
import edu.zut.chz.system.domain.DirectionCourse;
import edu.zut.chz.system.service.IDirectionCourseService;
import edu.zut.chz.common.utils.poi.ExcelUtil;
import edu.zut.chz.common.core.page.TableDataInfo;

/**
 * 方向课程Controller
 * 
 * @author anmingnuo
 * @date 2024-05-09
 */
@RestController
@RequestMapping("/system/directionCourse")
public class DirectionCourseController extends BaseController
{
    @Autowired
    private IDirectionCourseService directionCourseService;

    /**
     * 查询方向课程列表
     */
    @PreAuthorize("@ss.hasPermi('system:directionCourse:list')")
    @GetMapping("/list")
    public TableDataInfo list(DirectionCourse directionCourse)
    {
        startPage();
        List<DirectionCourse> list = directionCourseService.selectDirectionCourseList(directionCourse);
        return getDataTable(list);
    }

    /**
     * 导出方向课程列表
     */
    @PreAuthorize("@ss.hasPermi('system:directionCourse:export')")
    @Log(title = "方向课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DirectionCourse directionCourse)
    {
        List<DirectionCourse> list = directionCourseService.selectDirectionCourseList(directionCourse);
        ExcelUtil<DirectionCourse> util = new ExcelUtil<DirectionCourse>(DirectionCourse.class);
        util.exportExcel(response, list, "方向课程数据");
    }

    /**
     * 获取方向课程详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:directionCourse:query')")
    @GetMapping(value = "/{directionId}")
    public AjaxResult getInfo(@PathVariable("directionId") Long directionId)
    {
        return success(directionCourseService.selectDirectionCourseByDirectionId(directionId));
    }

    /**
     * 新增方向课程
     */
    @PreAuthorize("@ss.hasPermi('system:directionCourse:add')")
    @Log(title = "方向课程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DirectionCourse directionCourse)
    {
        return toAjax(directionCourseService.insertDirectionCourse(directionCourse));
    }

    /**
     * 修改方向课程
     */
    @PreAuthorize("@ss.hasPermi('system:directionCourse:edit')")
    @Log(title = "方向课程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DirectionCourse directionCourse)
    {
        return toAjax(directionCourseService.updateDirectionCourse(directionCourse));
    }

    /**
     * 删除方向课程
     */
    @PreAuthorize("@ss.hasPermi('system:directionCourse:remove')")
    @Log(title = "方向课程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{directionIds}")
    public AjaxResult remove(@PathVariable Long[] directionIds)
    {
        return toAjax(directionCourseService.deleteDirectionCourseByDirectionIds(directionIds));
    }
}
