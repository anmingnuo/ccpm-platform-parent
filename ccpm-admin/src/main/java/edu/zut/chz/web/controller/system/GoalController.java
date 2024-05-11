package edu.zut.chz.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import edu.zut.chz.system.domain.Course;
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
import edu.zut.chz.system.domain.Goal;
import edu.zut.chz.system.service.IGoalService;
import edu.zut.chz.common.utils.poi.ExcelUtil;
import edu.zut.chz.common.core.page.TableDataInfo;

/**
 * 思政目标Controller
 * 
 * @author anmingnuo
 * @date 2024-05-06
 */
@RestController
@RequestMapping("/system/goal")
public class GoalController extends BaseController
{
    @Autowired
    private IGoalService goalService;
    @GetMapping("/getLibraryListByGoalId/{goalId}")
    public AjaxResult getLibraryListByGoalId(@PathVariable("goalId")Long goalId)
    {
        return success(goalService.getLibraryListByGoalId(goalId));
    }
    @GetMapping("/list")
    public TableDataInfo list(Goal goal)
    {
        startPage();
        List<Goal> list = goalService.selectGoalList(goal);
        return getDataTable(list);
    }
    @GetMapping("/getTeacherList/{userId}")
    public TableDataInfo getTeacherList(@PathVariable("userId")Long userId, Goal goal)
    {
        startPage();
        List<Goal> list = goalService.getTeacherList(userId,goal);
        return getDataTable(list);
    }

    @GetMapping("/getDirectorList/{userId}")
    public TableDataInfo getDirectorList(@PathVariable("userId")Long userId, Goal goal)
    {
        startPage();
        List<Goal> list = goalService.getDirectorList(userId,goal);
        return getDataTable(list);
    }
    @GetMapping("/getAdminCourseList")
    public AjaxResult getAdminCourseList(Course course)
    {
        return success(goalService.getAdminCourseList(course));
    }
    @GetMapping("/getDirectorCourseList/{userId}")
    public AjaxResult getDirectorCourseList(@PathVariable("userId") Long userId)
    {
        return success(goalService.getDirectorCourseList(userId));
    }

    /**
     * 导出思政目标列表
     */
    @PreAuthorize("@ss.hasPermi('system:goal:export')")
    @Log(title = "思政目标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Goal goal)
    {
        List<Goal> list = goalService.selectGoalList(goal);
        ExcelUtil<Goal> util = new ExcelUtil<Goal>(Goal.class);
        util.exportExcel(response, list, "思政目标数据");
    }

    /**
     * 获取思政目标详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:goal:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(goalService.selectGoalById(id));
    }

    /**
     * 新增思政目标
     */
    @PreAuthorize("@ss.hasPermi('system:goal:add')")
    @Log(title = "思政目标", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Goal goal)
    {
        System.out.println(goal);
        return toAjax(goalService.insertGoal(goal));
    }

    /**
     * 修改思政目标
     */
    @PreAuthorize("@ss.hasPermi('system:goal:edit')")
    @Log(title = "思政目标", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Goal goal)
    {

        return toAjax(goalService.updateGoal(goal));
    }

    /**
     * 删除思政目标
     */
    @PreAuthorize("@ss.hasPermi('system:goal:remove')")
    @Log(title = "思政目标", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(goalService.deleteGoalByIds(ids));
    }
}
