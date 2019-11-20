package com.mbyte.easy.publish.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.publish.entity.Publish;
import com.mbyte.easy.publish.service.IPublishService;
import com.mbyte.easy.common.controller.BaseController;
import com.mbyte.easy.common.web.AjaxResult;
import com.mbyte.easy.util.PageInfo;
import com.mbyte.easy.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.ObjectUtils;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * @Author                   戴书博
 * @Description              出版社
 * @Date                     2019/11/11
 * @Version                  1.0
 */

@Slf4j
@Controller
@RequestMapping("/publish/publish")
public class PublishController extends BaseController  {

    private String prefix = "publish/publish/";

    @Autowired
    private IPublishService publishService;

    /**
    * 查询列表
    *
    * @param model
    * @param pageNo
    * @param pageSize
    * @param publish
    * @return
    */
    @RequestMapping
    public String index(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, Publish publish) {
        Page<Publish> page = new Page<>(pageNo, pageSize);

        IPage<Publish> pageInfo = publishService.listPage(page,publish);
        log.info("datas => {}",pageInfo.getRecords());
        model.addAttribute("searchInfo", publish);
        model.addAttribute("pageInfo", new PageInfo(pageInfo));
        return prefix+"list";
    }

    /**
     * @Method addBefore
     * @Author 戴书博
     * @Description     返回添加页面
     * @Return java.lang.String
     * @Date 2019/11/2 14:51
     * @Version  1.0
     */
    @GetMapping("addBefore")
    public String addBefore(){
        return prefix+"add";
    }

    /**
     * @Method add
     * @Author 戴书博
     * @Description     添加
     * @param publish   出版社
     * @Return com.mbyte.easy.common.web.AjaxResult
     * @Date 2019/11/2 14:52
     * @Version  1.0
     */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(Publish publish){
        log.info("public name => {}",publish.getName());
        return toAjax(publishService.insertPublic(publish));
    }

    /**
     * @Method editBefore
     * @Author 戴书博
     * @Description     编辑页面
     * @param model
     * @param id        出版社的id
     * @Return java.lang.String
     * @Date 2019/11/2 14:52
     * @Version  1.0
     */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("publish",publishService.selectByPrimaryKey(id));
        return prefix+"edit";
    }

    /**
     * @Method edit
     * @Author 戴书博
     * @Description     编辑
     * @param publish   出版社
     * @Return com.mbyte.easy.common.web.AjaxResult
     * @Date 2019/11/2 14:52
     * @Version  1.0
     */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(Publish publish){
        return toAjax(publishService.updatePublicById(publish));
    }

    /**
     * @Method delete
     * @Author 戴书博
     * @Description     删除单个
     * @param id        出版社id
     * @Return com.mbyte.easy.common.web.AjaxResult
     * @Date 2019/11/2 14:53
     * @Version  1.0
     */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(publishService.deletePublicById(id));
    }


    /**
     * @Method deleteAll
     * @Author 戴书博
     * @Description     批量删除
     * @param ids       出版社们的id
     * @Return com.mbyte.easy.common.web.AjaxResult
     * @Date 2019/11/2 14:53
     * @Version  1.0
     */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(publishService.deletePublicAllByIds(ids));
    }

}

