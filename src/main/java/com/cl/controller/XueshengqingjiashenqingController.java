package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.XueshengqingjiashenqingEntity;
import com.cl.entity.view.XueshengqingjiashenqingView;

import com.cl.service.XueshengqingjiashenqingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 学生请假申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-06 20:11:52
 */
@RestController
@RequestMapping("/xueshengqingjiashenqing")
public class XueshengqingjiashenqingController {
    @Autowired
    private XueshengqingjiashenqingService xueshengqingjiashenqingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueshengqingjiashenqingEntity xueshengqingjiashenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xueshengqingjiashenqing.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueshengqingjiashenqingEntity> ew = new EntityWrapper<XueshengqingjiashenqingEntity>();

		PageUtils page = xueshengqingjiashenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengqingjiashenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueshengqingjiashenqingEntity xueshengqingjiashenqing, 
		HttpServletRequest request){
        EntityWrapper<XueshengqingjiashenqingEntity> ew = new EntityWrapper<XueshengqingjiashenqingEntity>();

		PageUtils page = xueshengqingjiashenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengqingjiashenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueshengqingjiashenqingEntity xueshengqingjiashenqing){
       	EntityWrapper<XueshengqingjiashenqingEntity> ew = new EntityWrapper<XueshengqingjiashenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueshengqingjiashenqing, "xueshengqingjiashenqing")); 
        return R.ok().put("data", xueshengqingjiashenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueshengqingjiashenqingEntity xueshengqingjiashenqing){
        EntityWrapper< XueshengqingjiashenqingEntity> ew = new EntityWrapper< XueshengqingjiashenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueshengqingjiashenqing, "xueshengqingjiashenqing")); 
		XueshengqingjiashenqingView xueshengqingjiashenqingView =  xueshengqingjiashenqingService.selectView(ew);
		return R.ok("查询学生请假申请成功").put("data", xueshengqingjiashenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueshengqingjiashenqingEntity xueshengqingjiashenqing = xueshengqingjiashenqingService.selectById(id);
		xueshengqingjiashenqing = xueshengqingjiashenqingService.selectView(new EntityWrapper<XueshengqingjiashenqingEntity>().eq("id", id));
        return R.ok().put("data", xueshengqingjiashenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueshengqingjiashenqingEntity xueshengqingjiashenqing = xueshengqingjiashenqingService.selectById(id);
		xueshengqingjiashenqing = xueshengqingjiashenqingService.selectView(new EntityWrapper<XueshengqingjiashenqingEntity>().eq("id", id));
        return R.ok().put("data", xueshengqingjiashenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengqingjiashenqingEntity xueshengqingjiashenqing, HttpServletRequest request){
    	xueshengqingjiashenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengqingjiashenqing);
        xueshengqingjiashenqingService.insert(xueshengqingjiashenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueshengqingjiashenqingEntity xueshengqingjiashenqing, HttpServletRequest request){
    	xueshengqingjiashenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengqingjiashenqing);
        xueshengqingjiashenqingService.insert(xueshengqingjiashenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueshengqingjiashenqingEntity xueshengqingjiashenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueshengqingjiashenqing);
        xueshengqingjiashenqingService.updateById(xueshengqingjiashenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XueshengqingjiashenqingEntity> list = new ArrayList<XueshengqingjiashenqingEntity>();
        for(Long id : ids) {
            XueshengqingjiashenqingEntity xueshengqingjiashenqing = xueshengqingjiashenqingService.selectById(id);
            xueshengqingjiashenqing.setSfsh(sfsh);
            xueshengqingjiashenqing.setShhf(shhf);
            list.add(xueshengqingjiashenqing);
        }
        xueshengqingjiashenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueshengqingjiashenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
