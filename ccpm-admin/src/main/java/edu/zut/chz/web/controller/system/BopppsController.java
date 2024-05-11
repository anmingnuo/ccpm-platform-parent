package edu.zut.chz.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import edu.zut.chz.system.domain.Course;
import edu.zut.chz.system.domain.Library;
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
import edu.zut.chz.system.domain.Boppps;
import edu.zut.chz.system.service.IBopppsService;
import edu.zut.chz.common.utils.poi.ExcelUtil;
import edu.zut.chz.common.core.page.TableDataInfo;

/**
 * bopppsController
 * 
 * @author anmingnuo
 * @date 2024-05-06
 */
@RestController
@RequestMapping("/system/boppps")
public class BopppsController extends BaseController
{
    @Autowired
    private IBopppsService bopppsService;

    @GetMapping("getLibraryListByCourseId/{courseId}")
    public AjaxResult getLibraryListByCourseId(@PathVariable("courseId")Long courseId){
        List<Library> libraryList = bopppsService.getLibraryListByCourseId(courseId);
        System.out.println(libraryList);
        return success(libraryList);
    }

    @GetMapping("teacherGetCourseList/{userId}")
    public AjaxResult teacherGetCourseList(@PathVariable("userId")Long userId){
        List<Course> courses = bopppsService.teacherGetCourseList(userId);
        return success(courses);
    }
    @GetMapping("directionGetCourseList/{courseId}")
    public AjaxResult directionGetCourseList(@PathVariable("courseId")Long courseId){
        return success(bopppsService.directionGetCourseList(courseId));
    }
    @GetMapping("teacherGetUserList/{userId}")
    public AjaxResult teacherGetUserList(@PathVariable("userId")Long userId){
        return success(bopppsService.teacherGetUserList(userId));
    }

    @GetMapping("directorGetUserList/{userId}")
    public AjaxResult directorGetUserList(@PathVariable("userId")Long userId){
        return success(bopppsService.directorGetUserList(userId));
    }

    @GetMapping("getChapterList")
    public AjaxResult getChapterList(){
        return success(bopppsService.getChapterList());
    }
    @GetMapping("/directorListBoppps")
    public TableDataInfo directorListBoppps(Boppps boppps)
    {
        startPage();
        List<Boppps> list = bopppsService.directorListBoppps(boppps.getUserId());
        return getDataTable(list);
    }

    @GetMapping("/teacherListBoppps")
    public TableDataInfo teacherListBoppps(Boppps boppps)
    {
        startPage();
        List<Boppps> list = bopppsService.teacherListBoppps(boppps.getUserId());
        return getDataTable(list);
    }
    /**
     * 查询boppps列表
     */
    @PreAuthorize("@ss.hasPermi('system:boppps:list')")
    @GetMapping("/list")
    public TableDataInfo list(Boppps boppps)
    {
        startPage();
        List<Boppps> list = bopppsService.selectBopppsList(boppps);
        return getDataTable(list);
    }


    /**
     * 导出boppps列表
     */
    @PreAuthorize("@ss.hasPermi('system:boppps:export')")
    @Log(title = "boppps", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Boppps boppps)
    {
        List<Boppps> list = bopppsService.selectBopppsList(boppps);
        ExcelUtil<Boppps> util = new ExcelUtil<Boppps>(Boppps.class);
        util.exportExcel(response, list, "boppps数据");
    }

    /**
     * 获取boppps详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:boppps:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bopppsService.selectBopppsById(id));
    }

    /**
     * 新增boppps
     */
    @PreAuthorize("@ss.hasPermi('system:boppps:add')")
    @Log(title = "boppps", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Boppps boppps)
    {
        return toAjax(bopppsService.insertBoppps(boppps));
    }

    /**
     * 修改boppps
     */
    @PreAuthorize("@ss.hasPermi('system:boppps:edit')")
    @Log(title = "boppps", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Boppps boppps)
    {
        return toAjax(bopppsService.updateBoppps(boppps));
    }

    /**
     * 删除boppps
     */
    @PreAuthorize("@ss.hasPermi('system:boppps:remove')")
    @Log(title = "boppps", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bopppsService.deleteBopppsByIds(ids));
    }
}
