package com.navi.mini.program.controller.retboxemp;


import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.constant.Constant.ResultInfo;
import com.navi.mini.program.common.controller.BaseController;
import com.navi.mini.program.common.response.BaseResponse;
import com.navi.mini.program.model.retboxemp.RetBoxEmp;
import com.navi.mini.program.service.retboxemp.RetBoxEmpService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Scope("prototype")
@RestController
@RequestMapping("/retBoxEmp")
public class RetBoxEmpController extends BaseController {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(RetBoxEmpController.class);

	@Autowired
	private RetBoxEmpService retBoxEmpService;
	
	/**
	 * 方法描述：查询列表
	 * @param retBoxEmp
	 * @return
	 */
	@PostMapping(value="/queryList", consumes="application/json", produces="application/json")
	public BaseResponse queryList(@RequestBody RetBoxEmp retBoxEmp) {
		try {
			clear();
			PageInfo<RetBoxEmp> pageInfo = retBoxEmpService.queryList(retBoxEmp);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/retBoxEmp/queryList 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}

	/**
	 * 使用申请人主键查询空箱子
	 * @param retBoxEmp
	 * @return
	 */
	@PostMapping(value="/queryRetBoxEmpByUserId", consumes="application/json", produces="application/json")
	public BaseResponse queryRetBoxEmpByUserId(@RequestBody RetBoxEmp retBoxEmp) {
		try {
			clear();
			List<RetBoxEmp> retBoxEmpList = retBoxEmpService.queryRetBoxEmpByUserId(retBoxEmp.getReqUserId());
			data.put(ResultInfo.DATALIST, retBoxEmpList);
		} catch (Exception e) {
			logger.info("/retBoxEmp/queryRetBoxEmpByUserId 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 根据id获取数据对象
	 * @param id
	 * @return
	 */
//	@GetMapping(value="/queryById", produces="application/json")
//	public BaseResponse queryById(String id) {
//		try {
//			clear();
//			RetBoxEmp obj = retBoxEmpService.queryById(id);
//			data.put(ResultInfo.DATA, obj);
//		} catch (Exception e) {
//			logger.info("/retBoxEmp/queryById 异常：" + e.toString());
//			error(Constant.ERRORMSG + e.getMessage());
//		}
//
//		return returnBaseResponse();
//	}
	
	/**
	 * 方法描述： 保存一条记录
	 * @param retBoxEmp
	 * @return
	 */
	@PostMapping(value="/save", consumes="application/json", produces="application/json")
	public BaseResponse save(@RequestBody RetBoxEmp retBoxEmp) {
		try {
			clear();
			retBoxEmpService.saveRetBoxEmp(retBoxEmp);
		} catch (Exception e) {
			logger.info("/retBoxEmp/save 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}
	
}