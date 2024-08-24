package com.entity.model;

import com.entity.PingweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 评委
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-25 11:17:45
 */
public class PingweiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String mima;
		
	/**
	 * 评委姓名
	 */
	
	private String pingweixingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 身份证
	 */
	
	private String shenfenzheng;
		
	/**
	 * 所属单位
	 */
	
	private String suoshudanwei;
		
	/**
	 * 职称
	 */
	
	private String zhicheng;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
				
	
	/**
	 * 设置：评委姓名
	 */
	 
	public void setPingweixingming(String pingweixingming) {
		this.pingweixingming = pingweixingming;
	}
	
	/**
	 * 获取：评委姓名
	 */
	public String getPingweixingming() {
		return pingweixingming;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：身份证
	 */
	 
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	
	/**
	 * 获取：身份证
	 */
	public String getShenfenzheng() {
		return shenfenzheng;
	}
				
	
	/**
	 * 设置：所属单位
	 */
	 
	public void setSuoshudanwei(String suoshudanwei) {
		this.suoshudanwei = suoshudanwei;
	}
	
	/**
	 * 获取：所属单位
	 */
	public String getSuoshudanwei() {
		return suoshudanwei;
	}
				
	
	/**
	 * 设置：职称
	 */
	 
	public void setZhicheng(String zhicheng) {
		this.zhicheng = zhicheng;
	}
	
	/**
	 * 获取：职称
	 */
	public String getZhicheng() {
		return zhicheng;
	}
				
	
	/**
	 * 设置：联系方式
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
			
}
