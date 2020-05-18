package com.navi.mini.program.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.constant.Constant.ResultInfo;
import com.navi.mini.program.common.controller.BaseController;
import com.navi.mini.program.common.response.BaseResponse;
import com.navi.mini.program.model.bisuser.BisUser;
import com.navi.mini.program.service.BisUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;


@Scope("prototype")
@RestController
@RequestMapping("/bisUser")
public class BisUserController extends BaseController {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(BisUserController.class);

	@Autowired
	private BisUserService bisUserService;
	
	/**
	 * 方法描述：查询列表
	 * @param bisUser
	 * @return
	 */
	@PostMapping(value="/queryList", consumes="application/json", produces="application/json")
	public BaseResponse queryList(@RequestBody BisUser bisUser) {
		try {
			clear();
			PageInfo<BisUser> pageInfo = bisUserService.queryList(bisUser);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/bisUser/queryList 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}

	/**
	 * 使用openid查询用户
	 * @param bisUser
	 * @return
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/12 21:52
	 */
	@PostMapping(value="/queryByToken", consumes="application/json", produces="application/json")
	public BaseResponse queryByToken(@RequestBody BisUser bisUser) {
		try {
			clear();
			bisUser = bisUserService.queryByToken(bisUser.getToken());
			data.put(ResultInfo.DATA, bisUser);
		} catch (Exception e) {
			logger.info("/bisUser/queryByToken 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}

	/**
	 * 获取token
	 * @return
	 */
	@RequestMapping("/getToken/{code}")
	public BaseResponse getToken(@PathVariable String code) {
		try {
			JSONObject jsonObject = bisUserService.getToken(code);
			data.put(Constant.ResultInfo.DATALIST, jsonObject);
		} catch (Exception e) {
			logger.info("/bisUser/queryByToken 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}

	/**
	 * 登录
	 * @param bisUser 用户实体类
	 * @return
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/18 10:12
	 */
	@RequestMapping("/login")
	public BaseResponse login(@RequestBody BisUser bisUser) {
		try {
			bisUserService.login(bisUser);
		} catch (Exception e) {
			logger.info("/bisUser/login 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}

	/**
	 * 注册
	 * @param bisUser 用户实体类
	 * @return
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/18 10:12
	 */
	@RequestMapping("/register")
	public BaseResponse register(@RequestBody BisUser bisUser) {
		try {
			bisUserService.register(bisUser);
		} catch (Exception e) {
			logger.info("/bisUser/register 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 根据id删除一条记录
	 * @param id
	 * @return
	 */
	@GetMapping(value="/deleteById", produces="application/json")
	public BaseResponse deleteById(Long id) {
		try {
			clear();
			bisUserService.deleteById(id);
		} catch (Exception e) {
			logger.info("/bisUser/deleteById 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 批量删除
	 * @param ids
	 * @return
	 */
	@GetMapping(value="/deleteByIds", produces="application/json")
	public BaseResponse deleteByIds(String ids) {
		try {
			clear();
			bisUserService.deleteByIds(ids);
		} catch (Exception e) {
			logger.info("/bisUser/deleteByIds 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 根据id获取数据对象
	 * @param id
	 * @return
	 */
	@GetMapping(value="/queryById", produces="application/json")
	public BaseResponse queryById(Long id) {
		try {
			clear();
			BisUser obj = bisUserService.queryById(id);
			data.put(ResultInfo.DATA, obj);
		} catch (Exception e) {
			logger.info("/bisUser/queryById 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 保存一条记录
	 * @param bisUser
	 * @return
	 */
	@PostMapping(value="/save", consumes="application/json", produces="application/json")
	public BaseResponse save(@RequestBody BisUser bisUser) {
		try {
			clear();
			bisUserService.saveBisUser(bisUser);
		} catch (Exception e) {
			logger.info("/bisUser/save 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}
	
}