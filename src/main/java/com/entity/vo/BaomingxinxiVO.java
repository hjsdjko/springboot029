package com.entity.vo;

import com.entity.BaomingxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 报名信息
 * @author 
 * @email 
 * @date 2024-04-25 11:17:46
 */
public class BaomingxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 项目名称
	 */
	
	private String xiangmumingcheng;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 项目类型
	 */
	
	private String xiangmuleixing;
		
	/**
	 * 竞赛时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jingsaishijian;
		
	/**
	 * 竞赛地点
	 */
	
	private String jingsaididian;
		
	/**
	 * 报名
	 */
	
	private Integer baoming;
		
	/**
	 * 评委账号
	 */
	
	private String pingweizhanghao;
		
	/**
	 * 评委姓名
	 */
	
	private String pingweixingming;
		
	/**
	 * 报名时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date baomingshijian;
		
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
	 * 竞赛进度
	 */
	
	private String jingsaijindu;
		
	/**
	 * 跨表用户id
	 */
	
	private Long crossuserid;
		
	/**
	 * 跨表主键id
	 */
	
	private Long crossrefid;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：项目名称
	 */
	 
	public void setXiangmumingcheng(String xiangmumingcheng) {
		this.xiangmumingcheng = xiangmumingcheng;
	}
	
	/**
	 * 获取：项目名称
	 */
	public String getXiangmumingcheng() {
		return xiangmumingcheng;
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
	 * 设置：竞赛时间
	 */
	 
	public void setJingsaishijian(Date jingsaishijian) {
		this.jingsaishijian = jingsaishijian;
	}
	
	/**
	 * 获取：竞赛时间
	 */
	public Date getJingsaishijian() {
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
	 * 设置：报名
	 */
	 
	public void setBaoming(Integer baoming) {
		this.baoming = baoming;
	}
	
	/**
	 * 获取：报名
	 */
	public Integer getBaoming() {
		return baoming;
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
				
	
	/**
	 * 设置：报名时间
	 */
	 
	public void setBaomingshijian(Date baomingshijian) {
		this.baomingshijian = baomingshijian;
	}
	
	/**
	 * 获取：报名时间
	 */
	public Date getBaomingshijian() {
		return baomingshijian;
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
	 * 设置：竞赛进度
	 */
	 
	public void setJingsaijindu(String jingsaijindu) {
		this.jingsaijindu = jingsaijindu;
	}
	
	/**
	 * 获取：竞赛进度
	 */
	public String getJingsaijindu() {
		return jingsaijindu;
	}
				
	
	/**
	 * 设置：跨表用户id
	 */
	 
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
				
	
	/**
	 * 设置：跨表主键id
	 */
	 
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
