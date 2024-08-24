package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XiangmuleixingEntity;
import com.entity.view.XiangmuleixingView;

import com.service.XiangmuleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 项目类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-25 11:17:45
 */
@RestController
@RequestMapping("/xiangmuleixing")
public class XiangmuleixingController {
    @Autowired
    private XiangmuleixingService xiangmuleixingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiangmuleixingEntity xiangmuleixing,
		HttpServletRequest request){
        EntityWrapper<XiangmuleixingEntity> ew = new EntityWrapper<XiangmuleixingEntity>();

		PageUtils page = xiangmuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmuleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiangmuleixingEntity xiangmuleixing, 
		HttpServletRequest request){
        EntityWrapper<XiangmuleixingEntity> ew = new EntityWrapper<XiangmuleixingEntity>();

		PageUtils page = xiangmuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmuleixing), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiangmuleixingEntity xiangmuleixing){
       	EntityWrapper<XiangmuleixingEntity> ew = new EntityWrapper<XiangmuleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiangmuleixing, "xiangmuleixing")); 
        return R.ok().put("data", xiangmuleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiangmuleixingEntity xiangmuleixing){
        EntityWrapper< XiangmuleixingEntity> ew = new EntityWrapper< XiangmuleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiangmuleixing, "xiangmuleixing")); 
		XiangmuleixingView xiangmuleixingView =  xiangmuleixingService.selectView(ew);
		return R.ok("查询项目类型成功").put("data", xiangmuleixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiangmuleixingEntity xiangmuleixing = xiangmuleixingService.selectById(id);
        return R.ok().put("data", xiangmuleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiangmuleixingEntity xiangmuleixing = xiangmuleixingService.selectById(id);
        return R.ok().put("data", xiangmuleixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiangmuleixingEntity xiangmuleixing, HttpServletRequest request){
        if(xiangmuleixingService.selectCount(new EntityWrapper<XiangmuleixingEntity>().eq("xiangmuleixing", xiangmuleixing.getXiangmuleixing()))>0) {
            return R.error("项目类型已存在");
        }
    	//ValidatorUtils.validateEntity(xiangmuleixing);
        xiangmuleixingService.insert(xiangmuleixing);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiangmuleixingEntity xiangmuleixing, HttpServletRequest request){
        if(xiangmuleixingService.selectCount(new EntityWrapper<XiangmuleixingEntity>().eq("xiangmuleixing", xiangmuleixing.getXiangmuleixing()))>0) {
            return R.error("项目类型已存在");
        }
    	//ValidatorUtils.validateEntity(xiangmuleixing);
        xiangmuleixingService.insert(xiangmuleixing);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiangmuleixingEntity xiangmuleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiangmuleixing);
        if(xiangmuleixingService.selectCount(new EntityWrapper<XiangmuleixingEntity>().ne("id", xiangmuleixing.getId()).eq("xiangmuleixing", xiangmuleixing.getXiangmuleixing()))>0) {
            return R.error("项目类型已存在");
        }
        xiangmuleixingService.updateById(xiangmuleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiangmuleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
