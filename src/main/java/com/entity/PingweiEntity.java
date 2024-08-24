package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 评委
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-25 11:17:45
 */
@TableName("pingwei")
public class PingweiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PingweiEntity() {
		
	}
	
	public PingweiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId
    private Long id;
	/**
	 * 评委账号
	 */
					
	private String pingweizhanghao;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
