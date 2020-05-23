package com.navi.mini.program.controller.bisdata;


import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.constant.Constant.ResultInfo;
import com.navi.mini.program.common.controller.BaseController;
import com.navi.mini.program.common.response.BaseResponse;
import com.navi.mini.program.model.bisdata.BisData;
import com.navi.mini.program.model.biseqpt.BisEqpt;
import com.navi.mini.program.model.common.SelectModel;
import com.navi.mini.program.service.bisdata.BisDataService;
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
@RequestMapping("/bisData")
public class BisDataController extends BaseController {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(BisDataController.class);

	@Autowired
	private BisDataService bisDataService;
	
	/**
	 * 方法描述：查询列表
	 * @param bisData
	 * @return
	 */
	@PostMapping(value="/queryList", consumes="application/json", produces="application/json")
	public BaseResponse queryList(@RequestBody BisData bisData) {
		try {
			clear();
			PageInfo<BisData> pageInfo = bisDataService.queryList(bisData);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/bisData/queryList 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 根据id获取数据对象
	 * @param id
	 * @return
	 */
	@PostMapping(value="/queryById", consumes="application/json", produces="application/json")
	public BaseResponse queryById(@RequestBody BisData bisData) {
		try {
			clear();
			BisData obj = bisDataService.queryByDataSeqId(bisData.getDataSeqId());
			data.put(ResultInfo.DATA, obj);
		} catch (Exception e) {
			logger.info("/bisData/queryById 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 保存一条记录
	 * @param bisData
	 * @return
	 */
	@PostMapping(value="/save", consumes="application/json", produces="application/json")
	public BaseResponse save(@RequestBody BisData bisData) {
		try {
			clear();
			bisDataService.saveBisData(bisData);
		} catch (Exception e) {
			logger.info("/bisData/save 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}

	@PostMapping(value="/queryAllDropList", consumes="application/json", produces="application/json")
	public BaseResponse queryAllDropList(@RequestBody BisData bisData) {
		try {
			clear();
			List<SelectModel> pageInfo = bisDataService.queryAllDropList(bisData.getDataCate());
			data.put(ResultInfo.DATALIST, pageInfo);
		} catch (Exception e) {
			logger.info("/bisData/queryAllDropList 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}
}