package com.dao;

import com.entity.PingweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PingweiVO;
import com.entity.view.PingweiView;


/**
 * 评委
 * 
 * @author 
 * @email 
 * @date 2024-04-25 11:17:45
 */
public interface PingweiDao extends BaseMapper<PingweiEntity> {
	
	List<PingweiVO> selectListVO(@Param("ew") Wrapper<PingweiEntity> wrapper);
	
	PingweiVO selectVO(@Param("ew") Wrapper<PingweiEntity> wrapper);
	
	List<PingweiView> selectListView(@Param("ew") Wrapper<PingweiEntity> wrapper);

	List<PingweiView> selectListView(Pagination page,@Param("ew") Wrapper<PingweiEntity> wrapper);

	
	PingweiView selectView(@Param("ew") Wrapper<PingweiEntity> wrapper);
	

}
