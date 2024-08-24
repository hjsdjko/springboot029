package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussxiangmuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussxiangmuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussxiangmuxinxiView;


/**
 * 项目信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-25 11:17:46
 */
public interface DiscussxiangmuxinxiService extends IService<DiscussxiangmuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxiangmuxinxiVO> selectListVO(Wrapper<DiscussxiangmuxinxiEntity> wrapper);
   	
   	DiscussxiangmuxinxiVO selectVO(@Param("ew") Wrapper<DiscussxiangmuxinxiEntity> wrapper);
   	
   	List<DiscussxiangmuxinxiView> selectListView(Wrapper<DiscussxiangmuxinxiEntity> wrapper);
   	
   	DiscussxiangmuxinxiView selectView(@Param("ew") Wrapper<DiscussxiangmuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxiangmuxinxiEntity> wrapper);

   	

}

