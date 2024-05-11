package edu.zut.chz.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import edu.zut.chz.system.domain.Teacher;
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
import edu.zut.chz.system.domain.Group;
import edu.zut.chz.system.service.IGroupService;
import edu.zut.chz.common.utils.poi.ExcelUtil;
import edu.zut.chz.common.core.page.TableDataInfo;

/**
 * 课程组Controller
 * 
 * @author anmingnuo
 * @date 2024-05-05
 */
@RestController
@RequestMapping("/system/group")
public class GroupController extends BaseController
{
    @Autowired
    private IGroupService groupService;


    @GetMapping("getTeacherList")
    public AjaxResult getTeacherList(Teacher teacher){
        return success(groupService.getTeacherList(teacher));
    }
    /**
     * 查询课程组列表
     */
    @PreAuthorize("@ss.hasPermi('system:group:list')")
    @GetMapping("/list")
    public TableDataInfo list(Group group)
    {
        startPage();
        List<Group> list = groupService.selectGroupList(group);
        for (Group g:list){
            System.out.println(g);
        }
        return getDataTable(list);
    }

    /**
     * 导出课程组列表
     */
    @PreAuthorize("@ss.hasPermi('system:group:export')")
    @Log(title = "课程组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Group group)
    {
        List<Group> list = groupService.selectGroupList(group);
        ExcelUtil<Group> util = new ExcelUtil<Group>(Group.class);
        util.exportExcel(response, list, "课程组数据");
    }

    /**
     * 获取课程组详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:group:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(groupService.selectGroupById(id));
    }

    /**
     * 新增课程组
     */
    @PreAuthorize("@ss.hasPermi('system:group:add')")
    @Log(title = "课程组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Group group)
    {

        return toAjax(groupService.insertGroup(group));
    }

    /**
     * 修改课程组
     */
    @PreAuthorize("@ss.hasPermi('system:group:edit')")
    @Log(title = "课程组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Group group)
    {
        return toAjax(groupService.updateGroup(group));
    }

    /**
     * 删除课程组
     */
    @PreAuthorize("@ss.hasPermi('system:group:remove')")
    @Log(title = "课程组", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(groupService.deleteGroupByIds(ids));
    }
}
