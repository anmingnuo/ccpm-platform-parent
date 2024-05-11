package edu.zut.chz.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import edu.zut.chz.system.domain.Clazz;
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
import edu.zut.chz.system.domain.Student;
import edu.zut.chz.system.service.IStudentService;
import edu.zut.chz.common.utils.poi.ExcelUtil;
import edu.zut.chz.common.core.page.TableDataInfo;

/**
 * 学生管理Controller
 *
 * @author anmingnuo
 * @date 2024-05-03
 */
@RestController
@RequestMapping("/system/student")
public class StudentController extends BaseController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/getClazzList")
    public AjaxResult getClazzList(Clazz clazz) {
        return success(studentService.getClazzList(clazz));
    }


    /**
     * 查询学生管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(Student student) {
        startPage();
        List<Student> list = studentService.selectStudentList(student);
        return getDataTable(list);
    }

    /**
     * 导出学生管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:export')")
    @Log(title = "学生管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Student student) {
        List<Student> list = studentService.selectStudentList(student);
        ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
        util.exportExcel(response, list, "学生管理数据");
    }

    /**
     * 获取学生管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:student:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(studentService.selectStudentById(id));
    }

    /**
     * 新增学生管理
     */
    @PreAuthorize("@ss.hasPermi('system:student:add')")
    @Log(title = "学生管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Student student) {
        return toAjax(studentService.insertStudent(student));
    }

    /**
     * 修改学生管理
     */
    @PreAuthorize("@ss.hasPermi('system:student:edit')")
    @Log(title = "学生管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Student student) {
        return toAjax(studentService.updateStudent(student));
    }

    /**
     * 删除学生管理
     */
    @PreAuthorize("@ss.hasPermi('system:student:remove')")
    @Log(title = "学生管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(studentService.deleteStudentByIds(ids));
    }
}
