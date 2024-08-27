package com.cl.entity.view;

import com.cl.entity.YixuankechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 已选课程
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-06 20:11:52
 */
@TableName("yixuankecheng")
public class YixuankechengView  extends YixuankechengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YixuankechengView(){
	}
 
 	public YixuankechengView(YixuankechengEntity yixuankechengEntity){
 	try {
			BeanUtils.copyProperties(this, yixuankechengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
