package edu.zut.chz.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import edu.zut.chz.system.domain.Major;
import edu.zut.chz.system.domain.vo.CourseVo;
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
import edu.zut.chz.system.domain.Direction;
import edu.zut.chz.system.service.IDirectionService;
import edu.zut.chz.common.utils.poi.ExcelUtil;
import edu.zut.chz.common.core.page.TableDataInfo;

/**
 * 专业方向Controller
 * 
 * @author anmingnuo
 * @date 2024-05-02
 */
@RestController
@RequestMapping("/system/direction")
public class DirectionController extends BaseController
{
    @Autowired
    private IDirectionService directionService;
    /**
     * 查询专业列表
     */

    @PostMapping("/addDirectionCourse")
    public AjaxResult addDirectionCourse(@RequestBody CourseVo courseVo)
    {
        return success(directionService.addDirectionCourse(courseVo));
    }
    @GetMapping("/getCourseList")
    public AjaxResult getCourseList()
    {
        return success(directionService.getCourseList());
    }
    @GetMapping("/majorList")
    public AjaxResult majorList(Major major)
    {
        return success(directionService.getMajorList(major));
    }

    /**
     * 查询专业方向列表
     */
    @PreAuthorize("@ss.hasPermi('system:direction:list')")
    @GetMapping("/list")
    public TableDataInfo list(Direction direction)
    {
        startPage();
        List<Direction> list = directionService.selectDirectionList(direction);
        return getDataTable(list);
    }

    /**
     * 导出专业方向列表
     */
    @PreAuthorize("@ss.hasPermi('system:direction:export')")
    @Log(title = "专业方向", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Direction direction)
    {
        List<Direction> list = directionService.selectDirectionList(direction);
        ExcelUtil<Direction> util = new ExcelUtil<Direction>(Direction.class);
        util.exportExcel(response, list, "专业方向数据");
    }

    /**
     * 获取专业方向详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:direction:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(directionService.selectDirectionById(id));
    }

    /**
     * 新增专业方向
     */
    @PreAuthorize("@ss.hasPermi('system:direction:add')")
    @Log(title = "专业方向", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Direction direction)
    {
        return toAjax(directionService.insertDirection(direction));
    }

    /**
     * 修改专业方向
     */
    @PreAuthorize("@ss.hasPermi('system:direction:edit')")
    @Log(title = "专业方向", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Direction direction)
    {
        return toAjax(directionService.updateDirection(direction));
    }

    /**
     * 删除专业方向
     */
    @PreAuthorize("@ss.hasPermi('system:direction:remove')")
    @Log(title = "专业方向", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(directionService.deleteDirectionByIds(ids));
    }
}
