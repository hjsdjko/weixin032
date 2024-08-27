package com.cl.dao;

import com.cl.entity.ChengjixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChengjixinxiView;


/**
 * 成绩信息
 * 
 * @author 
 * @email 
 * @date 2024-03-06 20:11:52
 */
public interface ChengjixinxiDao extends BaseMapper<ChengjixinxiEntity> {
	
	List<ChengjixinxiView> selectListView(@Param("ew") Wrapper<ChengjixinxiEntity> wrapper);

	List<ChengjixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChengjixinxiEntity> wrapper);
	
	ChengjixinxiView selectView(@Param("ew") Wrapper<ChengjixinxiEntity> wrapper);
	

}
