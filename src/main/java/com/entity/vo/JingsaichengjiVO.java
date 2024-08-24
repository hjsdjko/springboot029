package com.entity.vo;

import com.entity.JingsaichengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 竞赛成绩
 * @author 
 * @email 
 * @date 2024-04-25 11:17:46
 */
public class JingsaichengjiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 项目
	 */
	
	private String xiangmu;
		
	/**
	 * 项目类型
	 */
	
	private String xiangmuleixing;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 竞赛时间
	 */
	
	private String jingsaishijian;
		
	/**
	 * 竞赛地点
	 */
	
	private String jingsaididian;
		
	/**
	 * 学号
	 */
	
	private String xuehao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
		
	/**
	 * 指导老师
	 */
	
	private String zhidaolaoshi;
		
	/**
	 * 名次
	 */
	
	private Integer mingci;
		
	/**
	 * 成绩
	 */
	
	private Integer chengji;
		
	/**
	 * 登记时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjishijian;
		
	/**
	 * 评委账号
	 */
	
	private String pingweizhanghao;
		
	/**
	 * 评委姓名
	 */
	
	private String pingweixingming;
				
	
	/**
	 * 设置：项目
	 */
	 
	public void setXiangmu(String xiangmu) {
		this.xiangmu = xiangmu;
	}
	
	/**
	 * 获取：项目
	 */
	public String getXiangmu() {
		return xiangmu;
	}
				
	
	/**
	 * 设置：项目类型
	 */
	 
	public void setXiangmuleixing(String xiangmuleixing) {
		this.xiangmuleixing = xiangmuleixing;
	}
	
	/**
	 * 获取：项目类型
	 */
	public String getXiangmuleixing() {
		return xiangmuleixing;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：竞赛时间
	 */
	 
	public void setJingsaishijian(String jingsaishijian) {
		this.jingsaishijian = jingsaishijian;
	}
	
	/**
	 * 获取：竞赛时间
	 */
	public String getJingsaishijian() {
		return jingsaishijian;
	}
				
	
	/**
	 * 设置：竞赛地点
	 */
	 
	public void setJingsaididian(String jingsaididian) {
		this.jingsaididian = jingsaididian;
	}
	
	/**
	 * 获取：竞赛地点
	 */
	public String getJingsaididian() {
		return jingsaididian;
	}
				
	
	/**
	 * 设置：学号
	 */
	 
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
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
				
	
	/**
	 * 设置：指导老师
	 */
	 
	public void setZhidaolaoshi(String zhidaolaoshi) {
		this.zhidaolaoshi = zhidaolaoshi;
	}
	
	/**
	 * 获取：指导老师
	 */
	public String getZhidaolaoshi() {
		return zhidaolaoshi;
	}
				
	
	/**
	 * 设置：名次
	 */
	 
	public void setMingci(Integer mingci) {
		this.mingci = mingci;
	}
	
	/**
	 * 获取：名次
	 */
	public Integer getMingci() {
		return mingci;
	}
				
	
	/**
	 * 设置：成绩
	 */
	 
	public void setChengji(Integer chengji) {
		this.chengji = chengji;
	}
	
	/**
	 * 获取：成绩
	 */
	public Integer getChengji() {
		return chengji;
	}
				
	
	/**
	 * 设置：登记时间
	 */
	 
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}
				
	
	/**
	 * 设置：评委账号
	 */
	 
	public void setPingweizhanghao(String pingweizhanghao) {
		this.pingweizhanghao = pingweizhanghao;
	}
	
	/**
	 * 获取：评委账号
	 */
	public String getPingweizhanghao() {
		return pingweizhanghao;
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
			
}
