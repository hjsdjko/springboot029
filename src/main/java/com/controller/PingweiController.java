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

import com.entity.PingweiEntity;
import com.entity.view.PingweiView;

import com.service.PingweiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 评委
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-25 11:17:45
 */
@RestController
@RequestMapping("/pingwei")
public class PingweiController {
    @Autowired
    private PingweiService pingweiService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		PingweiEntity u = pingweiService.selectOne(new EntityWrapper<PingweiEntity>().eq("pingweizhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"pingwei",  "评委" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody PingweiEntity pingwei){
    	//ValidatorUtils.validateEntity(pingwei);
    	PingweiEntity u = pingweiService.selectOne(new EntityWrapper<PingweiEntity>().eq("pingweizhanghao", pingwei.getPingweizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		pingwei.setId(uId);
        pingweiService.insert(pingwei);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        PingweiEntity u = pingweiService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	PingweiEntity u = pingweiService.selectOne(new EntityWrapper<PingweiEntity>().eq("pingweizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        pingweiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PingweiEntity pingwei,
		HttpServletRequest request){
        EntityWrapper<PingweiEntity> ew = new EntityWrapper<PingweiEntity>();

		PageUtils page = pingweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingwei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PingweiEntity pingwei, 
		HttpServletRequest request){
        EntityWrapper<PingweiEntity> ew = new EntityWrapper<PingweiEntity>();

		PageUtils page = pingweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingwei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PingweiEntity pingwei){
       	EntityWrapper<PingweiEntity> ew = new EntityWrapper<PingweiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( pingwei, "pingwei")); 
        return R.ok().put("data", pingweiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PingweiEntity pingwei){
        EntityWrapper< PingweiEntity> ew = new EntityWrapper< PingweiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( pingwei, "pingwei")); 
		PingweiView pingweiView =  pingweiService.selectView(ew);
		return R.ok("查询评委成功").put("data", pingweiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PingweiEntity pingwei = pingweiService.selectById(id);
        return R.ok().put("data", pingwei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PingweiEntity pingwei = pingweiService.selectById(id);
        return R.ok().put("data", pingwei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PingweiEntity pingwei, HttpServletRequest request){
        if(pingweiService.selectCount(new EntityWrapper<PingweiEntity>().eq("pingweizhanghao", pingwei.getPingweizhanghao()))>0) {
            return R.error("评委账号已存在");
        }
    	pingwei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingwei);
    	PingweiEntity u = pingweiService.selectOne(new EntityWrapper<PingweiEntity>().eq("pingweizhanghao", pingwei.getPingweizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		pingwei.setId(new Date().getTime());
        pingweiService.insert(pingwei);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PingweiEntity pingwei, HttpServletRequest request){
        if(pingweiService.selectCount(new EntityWrapper<PingweiEntity>().eq("pingweizhanghao", pingwei.getPingweizhanghao()))>0) {
            return R.error("评委账号已存在");
        }
    	pingwei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingwei);
    	PingweiEntity u = pingweiService.selectOne(new EntityWrapper<PingweiEntity>().eq("pingweizhanghao", pingwei.getPingweizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		pingwei.setId(new Date().getTime());
        pingweiService.insert(pingwei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PingweiEntity pingwei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(pingwei);
        if(pingweiService.selectCount(new EntityWrapper<PingweiEntity>().ne("id", pingwei.getId()).eq("pingweizhanghao", pingwei.getPingweizhanghao()))>0) {
            return R.error("评委账号已存在");
        }
        pingweiService.updateById(pingwei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        pingweiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
