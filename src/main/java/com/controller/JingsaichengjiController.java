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

import com.entity.JingsaichengjiEntity;
import com.entity.view.JingsaichengjiView;

import com.service.JingsaichengjiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 竞赛成绩
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-25 11:17:46
 */
@RestController
@RequestMapping("/jingsaichengji")
public class JingsaichengjiController {
    @Autowired
    private JingsaichengjiService jingsaichengjiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingsaichengjiEntity jingsaichengji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			jingsaichengji.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("pingwei")) {
			jingsaichengji.setPingweizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();

		PageUtils page = jingsaichengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaichengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingsaichengjiEntity jingsaichengji, 
		HttpServletRequest request){
        EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();

		PageUtils page = jingsaichengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaichengji), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingsaichengjiEntity jingsaichengji){
       	EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingsaichengji, "jingsaichengji")); 
        return R.ok().put("data", jingsaichengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingsaichengjiEntity jingsaichengji){
        EntityWrapper< JingsaichengjiEntity> ew = new EntityWrapper< JingsaichengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingsaichengji, "jingsaichengji")); 
		JingsaichengjiView jingsaichengjiView =  jingsaichengjiService.selectView(ew);
		return R.ok("查询竞赛成绩成功").put("data", jingsaichengjiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingsaichengjiEntity jingsaichengji = jingsaichengjiService.selectById(id);
        return R.ok().put("data", jingsaichengji);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingsaichengjiEntity jingsaichengji = jingsaichengjiService.selectById(id);
        return R.ok().put("data", jingsaichengji);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingsaichengjiEntity jingsaichengji, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jingsaichengji);
        jingsaichengjiService.insert(jingsaichengji);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingsaichengjiEntity jingsaichengji, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jingsaichengji);
        jingsaichengjiService.insert(jingsaichengji);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingsaichengjiEntity jingsaichengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingsaichengji);
        jingsaichengjiService.updateById(jingsaichengji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingsaichengjiService.deleteBatchIds(Arrays.asList(ids));
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
        EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("pingwei")) {
            ew.eq("pingweizhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = jingsaichengjiService.selectValue(params, ew);
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
        EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("pingwei")) {
            ew.eq("pingweizhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = jingsaichengjiService.selectValue(params, ew);
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
        EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("pingwei")) {
            ew.eq("pingweizhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = jingsaichengjiService.selectTimeStatValue(params, ew);
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
        EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("pingwei")) {
            ew.eq("pingweizhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = jingsaichengjiService.selectTimeStatValue(params, ew);
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
        EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("pingwei")) {
            ew.eq("pingweizhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = jingsaichengjiService.selectGroup(params, ew);
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
    public R count(@RequestParam Map<String, Object> params,JingsaichengjiEntity jingsaichengji, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xuesheng")) {
            jingsaichengji.setXuehao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("pingwei")) {
            jingsaichengji.setPingweizhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();
        int count = jingsaichengjiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaichengji), params), params));
        return R.ok().put("data", count);
    }



}
