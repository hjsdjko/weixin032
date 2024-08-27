package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XueshengqingjiashenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueshengqingjiashenqingView;


/**
 * 学生请假申请
 *
 * @author 
 * @email 
 * @date 2024-03-06 20:11:52
 */
public interface XueshengqingjiashenqingService extends IService<XueshengqingjiashenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengqingjiashenqingView> selectListView(Wrapper<XueshengqingjiashenqingEntity> wrapper);
   	
   	XueshengqingjiashenqingView selectView(@Param("ew") Wrapper<XueshengqingjiashenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengqingjiashenqingEntity> wrapper);
   	

}

