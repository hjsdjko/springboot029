package com.entity.view;

import com.entity.DiscussxiangmuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 项目信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-25 11:17:46
 */
@TableName("discussxiangmuxinxi")
public class DiscussxiangmuxinxiView  extends DiscussxiangmuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussxiangmuxinxiView(){
	}
 
 	public DiscussxiangmuxinxiView(DiscussxiangmuxinxiEntity discussxiangmuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussxiangmuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
