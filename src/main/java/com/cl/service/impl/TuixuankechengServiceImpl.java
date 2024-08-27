package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.TuixuankechengDao;
import com.cl.entity.TuixuankechengEntity;
import com.cl.service.TuixuankechengService;
import com.cl.entity.view.TuixuankechengView;

@Service("tuixuankechengService")
public class TuixuankechengServiceImpl extends ServiceImpl<TuixuankechengDao, TuixuankechengEntity> implements TuixuankechengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuixuankechengEntity> page = this.selectPage(
                new Query<TuixuankechengEntity>(params).getPage(),
                new EntityWrapper<TuixuankechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuixuankechengEntity> wrapper) {
		  Page<TuixuankechengView> page =new Query<TuixuankechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TuixuankechengView> selectListView(Wrapper<TuixuankechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuixuankechengView selectView(Wrapper<TuixuankechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
