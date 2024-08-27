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

import com.cl.entity.ChengjixinxiEntity;
import com.cl.entity.view.ChengjixinxiView;

import com.cl.service.ChengjixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 成绩信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-06 20:11:52
 */
@RestController
@RequestMapping("/chengjixinxi")
public class ChengjixinxiController {
    @Autowired
    private ChengjixinxiService chengjixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChengjixinxiEntity chengjixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			chengjixinxi.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			chengjixinxi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChengjixinxiEntity> ew = new EntityWrapper<ChengjixinxiEntity>();

		PageUtils page = chengjixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengjixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChengjixinxiEntity chengjixinxi, 
		HttpServletRequest request){
        EntityWrapper<ChengjixinxiEntity> ew = new EntityWrapper<ChengjixinxiEntity>();

		PageUtils page = chengjixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengjixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChengjixinxiEntity chengjixinxi){
       	EntityWrapper<ChengjixinxiEntity> ew = new EntityWrapper<ChengjixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chengjixinxi, "chengjixinxi")); 
        return R.ok().put("data", chengjixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChengjixinxiEntity chengjixinxi){
        EntityWrapper< ChengjixinxiEntity> ew = new EntityWrapper< ChengjixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chengjixinxi, "chengjixinxi")); 
		ChengjixinxiView chengjixinxiView =  chengjixinxiService.selectView(ew);
		return R.ok("查询成绩信息成功").put("data", chengjixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChengjixinxiEntity chengjixinxi = chengjixinxiService.selectById(id);
		chengjixinxi = chengjixinxiService.selectView(new EntityWrapper<ChengjixinxiEntity>().eq("id", id));
        return R.ok().put("data", chengjixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChengjixinxiEntity chengjixinxi = chengjixinxiService.selectById(id);
		chengjixinxi = chengjixinxiService.selectView(new EntityWrapper<ChengjixinxiEntity>().eq("id", id));
        return R.ok().put("data", chengjixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChengjixinxiEntity chengjixinxi, HttpServletRequest request){
    	chengjixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chengjixinxi);
        chengjixinxiService.insert(chengjixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChengjixinxiEntity chengjixinxi, HttpServletRequest request){
    	chengjixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chengjixinxi);
        chengjixinxiService.insert(chengjixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChengjixinxiEntity chengjixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chengjixinxi);
        chengjixinxiService.updateById(chengjixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chengjixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
