package com.navi.mini.program.controller.biseqpt;


import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.constant.Constant.ResultInfo;
import com.navi.mini.program.common.controller.BaseController;
import com.navi.mini.program.common.response.BaseResponse;
import com.navi.mini.program.model.biseqpt.BisEqpt;
import com.navi.mini.program.model.common.SelectModel;
import com.navi.mini.program.service.biseqpt.BisEqptService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Scope("prototype")
@RestController
@RequestMapping("/bisEqpt")
public class BisEqptController extends BaseController {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(BisEqptController.class);

	@Autowired
	private BisEqptService bisEqptService;
	
	/**
	 * 方法描述：查询列表
	 * @param bisEqpt
	 * @return
	 */
	@PostMapping(value="/queryList", consumes="application/json", produces="application/json")
	public BaseResponse queryList(@RequestBody BisEqpt bisEqpt) {
		try {
			clear();
			PageInfo<BisEqpt> pageInfo = bisEqptService.queryList(bisEqpt);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/bisEqpt/queryList 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}

	/**
	 * 查询所有码头
	 * @param bisEqpt
	 * @return
	 */
	@PostMapping(value="/queryAllDropList", consumes="application/json", produces="application/json")
	public BaseResponse queryAllDropList(@RequestBody BisEqpt bisEqpt) {
		try {
			clear();
			List<SelectModel> pageInfo = bisEqptService.queryAllDropList(bisEqpt);
			data.put(ResultInfo.DATALIST, pageInfo);
		} catch (Exception e) {
			logger.info("/bisEqpt/queryAllDropList 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}

	/**
	 * 方法描述： 根据id获取数据对象
	 * @param bisEqpt
	 * @return
	 */
	@PostMapping(value="/queryById", consumes="application/json", produces="application/json")
	public BaseResponse queryById(@RequestBody BisEqpt bisEqpt) {
		try {
			clear();
			BisEqpt obj = bisEqptService.queryByEqptId(bisEqpt.getEqptId());
			data.put(ResultInfo.DATA, obj);
		} catch (Exception e) {
			logger.info("/bisEqpt/queryById 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 保存一条记录
	 * @param bisEqpt
	 * @return
	 */
	@PostMapping(value="/save", consumes="application/json", produces="application/json")
	public BaseResponse save(@RequestBody BisEqpt bisEqpt) {
		try {
			clear();
			bisEqptService.saveBisEqpt(bisEqpt);
		} catch (Exception e) {
			logger.info("/bisEqpt/save 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}
	
}