package com.cl.entity.view;

import com.cl.entity.XueshengqingjiashenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 学生请假申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-06 20:11:52
 */
@TableName("xueshengqingjiashenqing")
public class XueshengqingjiashenqingView  extends XueshengqingjiashenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XueshengqingjiashenqingView(){
	}
 
 	public XueshengqingjiashenqingView(XueshengqingjiashenqingEntity xueshengqingjiashenqingEntity){
 	try {
			BeanUtils.copyProperties(this, xueshengqingjiashenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
