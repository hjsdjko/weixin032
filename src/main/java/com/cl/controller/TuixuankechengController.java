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

import com.cl.entity.TuixuankechengEntity;
import com.cl.entity.view.TuixuankechengView;

import com.cl.service.TuixuankechengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 退选课程
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-06 20:11:52
 */
@RestController
@RequestMapping("/tuixuankecheng")
public class TuixuankechengController {
    @Autowired
    private TuixuankechengService tuixuankechengService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TuixuankechengEntity tuixuankecheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			tuixuankecheng.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TuixuankechengEntity> ew = new EntityWrapper<TuixuankechengEntity>();

		PageUtils page = tuixuankechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuixuankecheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TuixuankechengEntity tuixuankecheng, 
		HttpServletRequest request){
        EntityWrapper<TuixuankechengEntity> ew = new EntityWrapper<TuixuankechengEntity>();

		PageUtils page = tuixuankechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuixuankecheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TuixuankechengEntity tuixuankecheng){
       	EntityWrapper<TuixuankechengEntity> ew = new EntityWrapper<TuixuankechengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tuixuankecheng, "tuixuankecheng")); 
        return R.ok().put("data", tuixuankechengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TuixuankechengEntity tuixuankecheng){
        EntityWrapper< TuixuankechengEntity> ew = new EntityWrapper< TuixuankechengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tuixuankecheng, "tuixuankecheng")); 
		TuixuankechengView tuixuankechengView =  tuixuankechengService.selectView(ew);
		return R.ok("查询退选课程成功").put("data", tuixuankechengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TuixuankechengEntity tuixuankecheng = tuixuankechengService.selectById(id);
		tuixuankecheng = tuixuankechengService.selectView(new EntityWrapper<TuixuankechengEntity>().eq("id", id));
        return R.ok().put("data", tuixuankecheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TuixuankechengEntity tuixuankecheng = tuixuankechengService.selectById(id);
		tuixuankecheng = tuixuankechengService.selectView(new EntityWrapper<TuixuankechengEntity>().eq("id", id));
        return R.ok().put("data", tuixuankecheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TuixuankechengEntity tuixuankecheng, HttpServletRequest request){
    	tuixuankecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuixuankecheng);
        tuixuankechengService.insert(tuixuankecheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TuixuankechengEntity tuixuankecheng, HttpServletRequest request){
    	tuixuankecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuixuankecheng);
        tuixuankechengService.insert(tuixuankecheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TuixuankechengEntity tuixuankecheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuixuankecheng);
        tuixuankechengService.updateById(tuixuankecheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tuixuankechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
