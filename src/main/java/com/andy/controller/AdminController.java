package com.andy.controller;

import com.andy.model.TourAdmin;
import com.andy.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/user")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/hello.do")
    @ResponseBody
    public String hello(String name){
        log.debug("hello");
        return "hello "+name;
    }

    @GetMapping("get/{id}")
    @ResponseBody
    public TourAdmin getUserById(@PathVariable(name = "id",required = false) Long id){
        return adminService.getUserById(id);
    }

    /**
     * Model本身不能设置页面跳转的url地址别名或者物理涂料转地址，
     * 那么我们可以通过控制器方法的返回值来设置跳转的url地址别名或者物理跳转地址
     * @param model  一个接口，其实现类为ExtendedModel，继承了ModelMap类
     * @return  跳转url地址别名或者物理跳转地址
     */
    @GetMapping("/all")
    public String users(Model model){
        List<TourAdmin> users = adminService.queryAll();
        // 放入模型
        model.addAttribute("users", users);
        // 返回模板名称（就是classpath:/templates/目录下的html文件名）
        return "users";
    }

    /**
     * ModelMap 对象主要用于传递控制方法处理数据到页面，类似于request对象的setAttribute方法的作用。用法等同于Model
     * @param model
     * @return  跳转url地址别名或者物理跳转地址
     */
    @GetMapping("/all2")
    public String users(ModelMap model){
        List<TourAdmin> list = adminService.queryAll();
        TourAdmin admin = adminService.getUserById(8L);
        TourAdmin admin2 = adminService.getUserById(9L);
        model.addAttribute("list",list);
        model.addAttribute("admin",admin);
        model.addAttribute("admin2",admin2);
        return "index";
    }

    /**
     * ModelAndView主要有两个作用：
     * 1.设置转向地址和传递控制方法处理结果数据到结果页面
     * @return  返回一个模板视图对象
     */
    @GetMapping("/queryAll")
    public ModelAndView users(){
        ModelAndView mv = new ModelAndView("index2");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("index2");
        List<TourAdmin> list = adminService.queryAll();
        mv.addObject("adminList",list);
        return mv;
    }

    /**
     * map用来存储传递控制方法处理结果数据，通过ModelAndView方法返回。
     * 当然Model，ModelMap也可以通过这种方法返回
     * @return 返回一个模板视图对象
     */
    @GetMapping("/modeAndView")
    public ModelAndView modelAndView(){
        Map<String,Object> map = new HashMap<>();
        TourAdmin user = adminService.getUserById(1L);
        map.put("modelAndView",user);
        return new ModelAndView("result",map);
    }
}
