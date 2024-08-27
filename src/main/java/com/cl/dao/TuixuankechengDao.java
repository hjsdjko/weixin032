package com.cl.dao;

import com.cl.entity.TuixuankechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TuixuankechengView;


/**
 * 退选课程
 * 
 * @author 
 * @email 
 * @date 2024-03-06 20:11:52
 */
public interface TuixuankechengDao extends BaseMapper<TuixuankechengEntity> {
	
	List<TuixuankechengView> selectListView(@Param("ew") Wrapper<TuixuankechengEntity> wrapper);

	List<TuixuankechengView> selectListView(Pagination page,@Param("ew") Wrapper<TuixuankechengEntity> wrapper);
	
	TuixuankechengView selectView(@Param("ew") Wrapper<TuixuankechengEntity> wrapper);
	

}
