package edu.zut.chz.web.controller.system;

import java.util.List;
import java.util.Set;

import edu.zut.chz.common.core.domain.entity.SysMenu;
import edu.zut.chz.common.core.domain.entity.SysUser;
import edu.zut.chz.common.core.domain.model.LoginBody;
import edu.zut.chz.system.domain.Course;
import edu.zut.chz.system.domain.Director;
import edu.zut.chz.system.service.ICourseService;
import edu.zut.chz.system.service.IDirectorService;
import edu.zut.chz.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import edu.zut.chz.common.constant.Constants;
import edu.zut.chz.common.core.domain.AjaxResult;
import edu.zut.chz.common.utils.SecurityUtils;
import edu.zut.chz.framework.web.service.SysLoginService;
import edu.zut.chz.framework.web.service.SysPermissionService;

/**
 * 登录验证
 * 
 * @author anmingnuo
 */
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IDirectorService directorService;

    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);

        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        Director director=directorService.selectDirectorByUserName(user.getUserName());
        if (director!=null){
            Course course = courseService.selectCourseById(director.getCourseId());
            if (course!=null){
                ajax.put("course",course);
            }
        }


        return ajax;
    }

    /**
     * 获取路由信息
     * 
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}
