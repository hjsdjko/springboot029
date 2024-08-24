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

import com.entity.XiangmuxinxiEntity;
import com.entity.view.XiangmuxinxiView;

import com.service.XiangmuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 项目信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-25 11:17:45
 */
@RestController
@RequestMapping("/xiangmuxinxi")
public class XiangmuxinxiController {
    @Autowired
    private XiangmuxinxiService xiangmuxinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiangmuxinxiEntity xiangmuxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("pingwei")) {
			xiangmuxinxi.setPingweizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiangmuxinxiEntity> ew = new EntityWrapper<XiangmuxinxiEntity>();

		PageUtils page = xiangmuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiangmuxinxiEntity xiangmuxinxi, 
		HttpServletRequest request){
        EntityWrapper<XiangmuxinxiEntity> ew = new EntityWrapper<XiangmuxinxiEntity>();

		PageUtils page = xiangmuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmuxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiangmuxinxiEntity xiangmuxinxi){
       	EntityWrapper<XiangmuxinxiEntity> ew = new EntityWrapper<XiangmuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiangmuxinxi, "xiangmuxinxi")); 
        return R.ok().put("data", xiangmuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiangmuxinxiEntity xiangmuxinxi){
        EntityWrapper< XiangmuxinxiEntity> ew = new EntityWrapper< XiangmuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiangmuxinxi, "xiangmuxinxi")); 
		XiangmuxinxiView xiangmuxinxiView =  xiangmuxinxiService.selectView(ew);
		return R.ok("查询项目信息成功").put("data", xiangmuxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiangmuxinxiEntity xiangmuxinxi = xiangmuxinxiService.selectById(id);
		xiangmuxinxi.setClicknum(xiangmuxinxi.getClicknum()+1);
		xiangmuxinxiService.updateById(xiangmuxinxi);
        xiangmuxinxi = xiangmuxinxiService.selectView(new EntityWrapper<XiangmuxinxiEntity>().eq("id", id));
        return R.ok().put("data", xiangmuxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiangmuxinxiEntity xiangmuxinxi = xiangmuxinxiService.selectById(id);
		xiangmuxinxi.setClicknum(xiangmuxinxi.getClicknum()+1);
		xiangmuxinxiService.updateById(xiangmuxinxi);
        xiangmuxinxi = xiangmuxinxiService.selectView(new EntityWrapper<XiangmuxinxiEntity>().eq("id", id));
        return R.ok().put("data", xiangmuxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        XiangmuxinxiEntity xiangmuxinxi = xiangmuxinxiService.selectById(id);
        if(type.equals("1")) {
        	xiangmuxinxi.setThumbsupnum(xiangmuxinxi.getThumbsupnum()+1);
        } else {
        	xiangmuxinxi.setCrazilynum(xiangmuxinxi.getCrazilynum()+1);
        }
        xiangmuxinxiService.updateById(xiangmuxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiangmuxinxiEntity xiangmuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xiangmuxinxi);
        xiangmuxinxiService.insert(xiangmuxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiangmuxinxiEntity xiangmuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xiangmuxinxi);
        xiangmuxinxiService.insert(xiangmuxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiangmuxinxiEntity xiangmuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiangmuxinxi);
        xiangmuxinxiService.updateById(xiangmuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiangmuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<XiangmuxinxiEntity> ew = new EntityWrapper<XiangmuxinxiEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("pingwei")) {
            ew.eq("pingweizhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = xiangmuxinxiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<XiangmuxinxiEntity> ew = new EntityWrapper<XiangmuxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("pingwei")) {
            ew.eq("pingweizhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = xiangmuxinxiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<XiangmuxinxiEntity> ew = new EntityWrapper<XiangmuxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("pingwei")) {
            ew.eq("pingweizhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = xiangmuxinxiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<XiangmuxinxiEntity> ew = new EntityWrapper<XiangmuxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("pingwei")) {
            ew.eq("pingweizhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = xiangmuxinxiService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<XiangmuxinxiEntity> ew = new EntityWrapper<XiangmuxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("pingwei")) {
            ew.eq("pingweizhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = xiangmuxinxiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,XiangmuxinxiEntity xiangmuxinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("pingwei")) {
            xiangmuxinxi.setPingweizhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<XiangmuxinxiEntity> ew = new EntityWrapper<XiangmuxinxiEntity>();
        int count = xiangmuxinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmuxinxi), params), params));
        return R.ok().put("data", count);
    }



}
