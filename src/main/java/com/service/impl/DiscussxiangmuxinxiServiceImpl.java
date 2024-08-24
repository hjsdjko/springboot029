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


import com.dao.DiscussxiangmuxinxiDao;
import com.entity.DiscussxiangmuxinxiEntity;
import com.service.DiscussxiangmuxinxiService;
import com.entity.vo.DiscussxiangmuxinxiVO;
import com.entity.view.DiscussxiangmuxinxiView;

@Service("discussxiangmuxinxiService")
public class DiscussxiangmuxinxiServiceImpl extends ServiceImpl<DiscussxiangmuxinxiDao, DiscussxiangmuxinxiEntity> implements DiscussxiangmuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxiangmuxinxiEntity> page = this.selectPage(
                new Query<DiscussxiangmuxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussxiangmuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxiangmuxinxiEntity> wrapper) {
		  Page<DiscussxiangmuxinxiView> page =new Query<DiscussxiangmuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussxiangmuxinxiVO> selectListVO(Wrapper<DiscussxiangmuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxiangmuxinxiVO selectVO(Wrapper<DiscussxiangmuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxiangmuxinxiView> selectListView(Wrapper<DiscussxiangmuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxiangmuxinxiView selectView(Wrapper<DiscussxiangmuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
