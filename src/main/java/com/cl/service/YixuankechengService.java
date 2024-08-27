package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YixuankechengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YixuankechengView;


/**
 * 已选课程
 *
 * @author 
 * @email 
 * @date 2024-03-06 20:11:52
 */
public interface YixuankechengService extends IService<YixuankechengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YixuankechengView> selectListView(Wrapper<YixuankechengEntity> wrapper);
   	
   	YixuankechengView selectView(@Param("ew") Wrapper<YixuankechengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YixuankechengEntity> wrapper);
   	

}

