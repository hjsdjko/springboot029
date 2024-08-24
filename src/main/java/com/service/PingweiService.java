package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PingweiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PingweiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PingweiView;


/**
 * 评委
 *
 * @author 
 * @email 
 * @date 2024-04-25 11:17:45
 */
public interface PingweiService extends IService<PingweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PingweiVO> selectListVO(Wrapper<PingweiEntity> wrapper);
   	
   	PingweiVO selectVO(@Param("ew") Wrapper<PingweiEntity> wrapper);
   	
   	List<PingweiView> selectListView(Wrapper<PingweiEntity> wrapper);
   	
   	PingweiView selectView(@Param("ew") Wrapper<PingweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PingweiEntity> wrapper);

   	

}

