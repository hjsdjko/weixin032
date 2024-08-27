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


import com.cl.dao.XueshengqingjiashenqingDao;
import com.cl.entity.XueshengqingjiashenqingEntity;
import com.cl.service.XueshengqingjiashenqingService;
import com.cl.entity.view.XueshengqingjiashenqingView;

@Service("xueshengqingjiashenqingService")
public class XueshengqingjiashenqingServiceImpl extends ServiceImpl<XueshengqingjiashenqingDao, XueshengqingjiashenqingEntity> implements XueshengqingjiashenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengqingjiashenqingEntity> page = this.selectPage(
                new Query<XueshengqingjiashenqingEntity>(params).getPage(),
                new EntityWrapper<XueshengqingjiashenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengqingjiashenqingEntity> wrapper) {
		  Page<XueshengqingjiashenqingView> page =new Query<XueshengqingjiashenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XueshengqingjiashenqingView> selectListView(Wrapper<XueshengqingjiashenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengqingjiashenqingView selectView(Wrapper<XueshengqingjiashenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
