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

import com.cl.entity.YixuankechengEntity;
import com.cl.entity.view.YixuankechengView;

import com.cl.service.YixuankechengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 已选课程
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-06 20:11:52
 */
@RestController
@RequestMapping("/yixuankecheng")
public class YixuankechengController {
    @Autowired
    private YixuankechengService yixuankechengService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YixuankechengEntity yixuankecheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			yixuankecheng.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YixuankechengEntity> ew = new EntityWrapper<YixuankechengEntity>();

		PageUtils page = yixuankechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yixuankecheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YixuankechengEntity yixuankecheng, 
		HttpServletRequest request){
        EntityWrapper<YixuankechengEntity> ew = new EntityWrapper<YixuankechengEntity>();

		PageUtils page = yixuankechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yixuankecheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YixuankechengEntity yixuankecheng){
       	EntityWrapper<YixuankechengEntity> ew = new EntityWrapper<YixuankechengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yixuankecheng, "yixuankecheng")); 
        return R.ok().put("data", yixuankechengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YixuankechengEntity yixuankecheng){
        EntityWrapper< YixuankechengEntity> ew = new EntityWrapper< YixuankechengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yixuankecheng, "yixuankecheng")); 
		YixuankechengView yixuankechengView =  yixuankechengService.selectView(ew);
		return R.ok("查询已选课程成功").put("data", yixuankechengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YixuankechengEntity yixuankecheng = yixuankechengService.selectById(id);
		yixuankecheng = yixuankechengService.selectView(new EntityWrapper<YixuankechengEntity>().eq("id", id));
        return R.ok().put("data", yixuankecheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YixuankechengEntity yixuankecheng = yixuankechengService.selectById(id);
		yixuankecheng = yixuankechengService.selectView(new EntityWrapper<YixuankechengEntity>().eq("id", id));
        return R.ok().put("data", yixuankecheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YixuankechengEntity yixuankecheng, HttpServletRequest request){
    	yixuankecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yixuankecheng);
        yixuankechengService.insert(yixuankecheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YixuankechengEntity yixuankecheng, HttpServletRequest request){
    	yixuankecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yixuankecheng);
        yixuankechengService.insert(yixuankecheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YixuankechengEntity yixuankecheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yixuankecheng);
        yixuankechengService.updateById(yixuankecheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yixuankechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
