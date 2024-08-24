package com.dao;

import com.entity.JingsaichengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JingsaichengjiVO;
import com.entity.view.JingsaichengjiView;


/**
 * 竞赛成绩
 * 
 * @author 
 * @email 
 * @date 2024-04-25 11:17:46
 */
public interface JingsaichengjiDao extends BaseMapper<JingsaichengjiEntity> {
	
	List<JingsaichengjiVO> selectListVO(@Param("ew") Wrapper<JingsaichengjiEntity> wrapper);
	
	JingsaichengjiVO selectVO(@Param("ew") Wrapper<JingsaichengjiEntity> wrapper);
	
	List<JingsaichengjiView> selectListView(@Param("ew") Wrapper<JingsaichengjiEntity> wrapper);

	List<JingsaichengjiView> selectListView(Pagination page,@Param("ew") Wrapper<JingsaichengjiEntity> wrapper);

	
	JingsaichengjiView selectView(@Param("ew") Wrapper<JingsaichengjiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JingsaichengjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JingsaichengjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JingsaichengjiEntity> wrapper);



}
