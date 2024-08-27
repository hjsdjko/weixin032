package com.cl.dao;

import com.cl.entity.XueshengqingjiashenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueshengqingjiashenqingView;


/**
 * 学生请假申请
 * 
 * @author 
 * @email 
 * @date 2024-03-06 20:11:52
 */
public interface XueshengqingjiashenqingDao extends BaseMapper<XueshengqingjiashenqingEntity> {
	
	List<XueshengqingjiashenqingView> selectListView(@Param("ew") Wrapper<XueshengqingjiashenqingEntity> wrapper);

	List<XueshengqingjiashenqingView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengqingjiashenqingEntity> wrapper);
	
	XueshengqingjiashenqingView selectView(@Param("ew") Wrapper<XueshengqingjiashenqingEntity> wrapper);
	

}
