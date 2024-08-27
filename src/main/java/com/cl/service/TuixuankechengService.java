package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TuixuankechengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TuixuankechengView;


/**
 * 退选课程
 *
 * @author 
 * @email 
 * @date 2024-03-06 20:11:52
 */
public interface TuixuankechengService extends IService<TuixuankechengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuixuankechengView> selectListView(Wrapper<TuixuankechengEntity> wrapper);
   	
   	TuixuankechengView selectView(@Param("ew") Wrapper<TuixuankechengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuixuankechengEntity> wrapper);
   	

}

