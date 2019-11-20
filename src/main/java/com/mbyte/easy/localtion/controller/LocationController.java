package com.mbyte.easy.localtion.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.localtion.entity.Location;
import com.mbyte.easy.localtion.service.ILocationService;
import com.mbyte.easy.common.controller.BaseController;
import com.mbyte.easy.common.web.AjaxResult;
import com.mbyte.easy.util.PageInfo;
import com.mbyte.easy.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.ObjectUtils;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author          戴书博
 * @Description     位置controller
 * @Date            2019/11/11 18:43
 * @Version         1.0
 */
@Controller
@RequestMapping("/localtion/location")
public class LocationController extends BaseController  {

    private String prefix = "localtion/location/";

    @Autowired
    private ILocationService locationService;

    /**
     * @Method          index
     * @Author          戴书博
     * @Description     显示列表
     * @param model     model
     * @param pageNo    当前页
     * @param pageSize  每页的页数
     * @Return          java.lang.String
     * @Date            2019/11/11 18:02
     * @Version         1.0
     */
    @RequestMapping
    public String index(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) {
        Page<Location> page = new Page<>(pageNo, pageSize);

        IPage<Location> pageInfo = locationService.listPage(page);
        model.addAttribute("pageInfo", new PageInfo(pageInfo));
        return prefix+"list";
    }

    /**
     * @Method          addBefore
     * @Author          戴书博
     * @Description     添加跳转页面
     * @Return          java.lang.String
     * @Date            2019/11/11 18:37
     * @Version         1.0
     */
    @GetMapping("addBefore")
    public String addBefore(){
        return prefix+"add";
    }

    /**
     * @Method          add
     * @Author          戴书博
     * @Description     添加
     * @param location  位置对象
     * @Return          com.mbyte.easy.common.web.AjaxResult
     * @Date            2019/11/11 18:38
     * @Version         1.0
     */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(Location location){
        return toAjax(locationService.insertLocation(location));
    }

    /**
     * @Method          editBefore
     * @Author          戴书博
     * @Description     跳转修改页面
     * @param model     model
     * @param id        位置对象的id
     * @Return          java.lang.String
     * @Date            2019/11/11 18:38
     * @Version         1.0
     */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("location",locationService.selectByPrimaryKey(id));
        return prefix+"edit";
    }

    /**
     * @Method          edit
     * @Author          戴书博
     * @Description     修改
     * @param location  位置对象
     * @Return          com.mbyte.easy.common.web.AjaxResult
     * @Date            2019/11/11 18:39
     * @Version         1.0
     */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(Location location){
            LocalDateTime updateTime = LocalDateTime.now();
            location.setUpdateTime(updateTime);
        return toAjax(locationService.updateLocationById(location));
    }

    /**
     * @Method          delete
     * @Author          戴书博
     * @Description     根据id删除对象
     * @param id        位置对象的id
     * @Return          com.mbyte.easy.common.web.AjaxResult
     * @Date            2019/11/11 18:40
     * @Version         1.0
     */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(locationService.deleteLocationById(id));
    }

    /**
     * @Method          deleteAll
     * @Author          戴书博
     * @Description     批量删除
     * @param ids       批量删除的ids
     * @Return          com.mbyte.easy.common.web.AjaxResult
     * @Date            2019/11/11 18:41
     * @Version         1.0
     */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(locationService.deleteLocationAllByIds(ids));
    }

}

