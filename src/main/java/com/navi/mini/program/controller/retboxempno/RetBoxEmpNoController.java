package com.navi.mini.program.controller.retboxempno;

import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.constant.Constant.ResultInfo;
import com.navi.mini.program.common.controller.BaseController;
import com.navi.mini.program.common.response.BaseResponse;
import com.navi.mini.program.model.retboxempno.RetBoxEmpNo;
import com.navi.mini.program.service.retboxempno.RetBoxEmpNoService;
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
@RequestMapping("/retBoxEmpNo")
public class RetBoxEmpNoController extends BaseController {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(RetBoxEmpNoController.class);

	@Autowired
	private RetBoxEmpNoService retBoxEmpNoService;
	
	/**
	 * 方法描述：查询列表
	 * @param retBoxEmpNo
	 * @return
	 */
	@PostMapping(value="/queryList", consumes="application/json", produces="application/json")
	public BaseResponse queryList(@RequestBody RetBoxEmpNo retBoxEmpNo) {
		try {
			clear();
			PageInfo<RetBoxEmpNo> pageInfo = retBoxEmpNoService.queryList(retBoxEmpNo);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/retBoxEmpNo/queryList 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}

	/**
	 * 领框记录
	 * @param retBoxEmpNo
	 * @return
	 */
	@PostMapping(value="/queryBoxRecordList", consumes="application/json", produces="application/json")
	public BaseResponse queryBoxRecordList(@RequestBody RetBoxEmpNo retBoxEmpNo) {
		try {
			clear();
			PageInfo<RetBoxEmpNo> pageInfo = retBoxEmpNoService.queryBoxRecordList(retBoxEmpNo);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/retBoxEmpNo/queryBoxRecordList 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}

	/**
	 * 领框审批记录（码头巡检员）
	 * @param retBoxEmpNo
	 * @return
	 */
	@PostMapping(value="/queryBoxRecordHisList", consumes="application/json", produces="application/json")
	public BaseResponse queryBoxRecordHisList(@RequestBody RetBoxEmpNo retBoxEmpNo) {
		try {
			clear();
			PageInfo<RetBoxEmpNo> pageInfo = retBoxEmpNoService.queryBoxRecordHisList(retBoxEmpNo);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/retBoxEmpNo/queryBoxRecordHisList 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}

	/**
	 * 领框审批记录
	 * @param retBoxEmpNo
	 * @return
	 */
	@PostMapping(value="/queryBoxApproveList", consumes="application/json", produces="application/json")
	public BaseResponse queryBoxApproveList(@RequestBody RetBoxEmpNo retBoxEmpNo) {
		try {
			clear();
			PageInfo<RetBoxEmpNo> pageInfo = retBoxEmpNoService.queryBoxApproveList(retBoxEmpNo);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/retBoxEmpNo/queryBoxApproveList 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 根据id获取数据对象
	 * @param retBoxEmpNo
	 * @return
	 */
	@PostMapping(value="/queryByRetBoxEmpNo", consumes="application/json", produces="application/json")
	public BaseResponse queryByRetBoxEmpNo(@RequestBody RetBoxEmpNo retBoxEmpNo) {
		try {
			clear();
			RetBoxEmpNo obj = retBoxEmpNoService.queryByRetBoxEmpNo(retBoxEmpNo.getRetBoxEmpNo());
			data.put(ResultInfo.DATA, obj);
		} catch (Exception e) {
			logger.info("/retBoxEmpNo/queryByRetBoxEmpNo 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 保存一条记录
	 * @param retBoxEmpNo
	 * @return
	 */
	@PostMapping(value="/save", consumes="application/json", produces="application/json")
	public BaseResponse save(@RequestBody RetBoxEmpNo retBoxEmpNo) {
		try {
			clear();
			retBoxEmpNoService.saveRetBoxEmpNo(retBoxEmpNo);
		} catch (Exception e) {
			logger.info("/retBoxEmpNo/save 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}

	/**
	 * 方法描述： 确认领框
	 * @param retBoxEmpNo
	 * @return
	 */
	@PostMapping(value="/getBoxConfig", consumes="application/json", produces="application/json")
	public BaseResponse getBoxConfig(@RequestBody RetBoxEmpNo retBoxEmpNo) {
		try {
			clear();
			retBoxEmpNoService.getBoxConfig(retBoxEmpNo);
		} catch (Exception e) {
			logger.info("/retBoxEmpNo/getBoxConfig 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}

	/**
	 * 审批框
	 * @param retBoxEmpNo
	 * @return
	 */
	@PostMapping(value="/getBoxApprove", consumes="application/json", produces="application/json")
	public BaseResponse getBoxApprove(@RequestBody RetBoxEmpNo retBoxEmpNo) {
		try {
			clear();
			retBoxEmpNoService.getBoxApprove(retBoxEmpNo);
		} catch (Exception e) {
			logger.info("/retBoxEmpNo/getBoxApprove 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}

	/**
	 * 查询这个人是否有未领取的空箱
	 * @return
	 */
	@PostMapping(value="/queryHasRecordAndNotGet", consumes="application/json", produces="application/json")
	public BaseResponse queryHasRecordAndNotGet() {
		try {
			clear();
			List<RetBoxEmpNo> obj = retBoxEmpNoService.queryHasRecordAndNotGet();
			data.put(ResultInfo.DATALIST, obj);
		} catch (Exception e) {
			logger.info("/retBoxEmpNo/queryByRetBoxEmpNo 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}
	
}