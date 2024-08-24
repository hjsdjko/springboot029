package com.entity.view;

import com.entity.JingsaichengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 竞赛成绩
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-25 11:17:46
 */
@TableName("jingsaichengji")
public class JingsaichengjiView  extends JingsaichengjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JingsaichengjiView(){
	}
 
 	public JingsaichengjiView(JingsaichengjiEntity jingsaichengjiEntity){
 	try {
			BeanUtils.copyProperties(this, jingsaichengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
