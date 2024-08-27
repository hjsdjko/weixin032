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


import com.cl.dao.YixuankechengDao;
import com.cl.entity.YixuankechengEntity;
import com.cl.service.YixuankechengService;
import com.cl.entity.view.YixuankechengView;

@Service("yixuankechengService")
public class YixuankechengServiceImpl extends ServiceImpl<YixuankechengDao, YixuankechengEntity> implements YixuankechengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YixuankechengEntity> page = this.selectPage(
                new Query<YixuankechengEntity>(params).getPage(),
                new EntityWrapper<YixuankechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YixuankechengEntity> wrapper) {
		  Page<YixuankechengView> page =new Query<YixuankechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YixuankechengView> selectListView(Wrapper<YixuankechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YixuankechengView selectView(Wrapper<YixuankechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
