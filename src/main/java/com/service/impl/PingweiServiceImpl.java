package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.PingweiDao;
import com.entity.PingweiEntity;
import com.service.PingweiService;
import com.entity.vo.PingweiVO;
import com.entity.view.PingweiView;

@Service("pingweiService")
public class PingweiServiceImpl extends ServiceImpl<PingweiDao, PingweiEntity> implements PingweiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PingweiEntity> page = this.selectPage(
                new Query<PingweiEntity>(params).getPage(),
                new EntityWrapper<PingweiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PingweiEntity> wrapper) {
		  Page<PingweiView> page =new Query<PingweiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PingweiVO> selectListVO(Wrapper<PingweiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PingweiVO selectVO(Wrapper<PingweiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PingweiView> selectListView(Wrapper<PingweiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PingweiView selectView(Wrapper<PingweiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
