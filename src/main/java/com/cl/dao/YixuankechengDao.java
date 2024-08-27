package com.cl.dao;

import com.cl.entity.YixuankechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YixuankechengView;


/**
 * 已选课程
 * 
 * @author 
 * @email 
 * @date 2024-03-06 20:11:52
 */
public interface YixuankechengDao extends BaseMapper<YixuankechengEntity> {
	
	List<YixuankechengView> selectListView(@Param("ew") Wrapper<YixuankechengEntity> wrapper);

	List<YixuankechengView> selectListView(Pagination page,@Param("ew") Wrapper<YixuankechengEntity> wrapper);
	
	YixuankechengView selectView(@Param("ew") Wrapper<YixuankechengEntity> wrapper);
	

}
