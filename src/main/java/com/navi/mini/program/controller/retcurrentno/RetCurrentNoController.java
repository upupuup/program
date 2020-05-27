package com.navi.mini.program.controller.retcurrentno;

import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.constant.Constant.ResultInfo;
import com.navi.mini.program.common.controller.BaseController;
import com.navi.mini.program.common.response.BaseResponse;
import com.navi.mini.program.model.retcurrentno.RetCurrentNo;
import com.navi.mini.program.service.retcurrentno.RetCurrentNoService;
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
@RequestMapping("/retCurrentNo")
public class RetCurrentNoController extends BaseController {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(RetCurrentNoController.class);

	@Autowired
	private RetCurrentNoService retCurrentNoService;
	
	/**
	 * 方法描述：查询列表
	 * @param retCurrentNo
	 * @return
	 */
	@PostMapping(value="/queryList", consumes="application/json", produces="application/json")
	public BaseResponse queryList(@RequestBody RetCurrentNo retCurrentNo) {
		try {
			clear();
			PageInfo<RetCurrentNo> pageInfo = retCurrentNoService.queryList(retCurrentNo);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/retCurrentNo/queryList 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}

	/**
	 * 方法描述：查询所有的看板信息
	 * @return
	 */
	@PostMapping(value="/queryAllList", consumes="application/json", produces="application/json")
	public BaseResponse queryAllList() {
		try {
			clear();
			List<RetCurrentNo> list = retCurrentNoService.queryAllList();
			data.put(ResultInfo.DATALIST, list);
		} catch (Exception e) {
			logger.info("/retCurrentNo/queryAllList 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 保存一条记录
	 * @param retCurrentNo
	 * @return
	 */
	@PostMapping(value="/save", consumes="application/json", produces="application/json")
	public BaseResponse save(@RequestBody RetCurrentNo retCurrentNo) {
		try {
			clear();
			retCurrentNoService.saveRetCurrentNo(retCurrentNo);
		} catch (Exception e) {
			logger.info("/retCurrentNo/save 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}
	
}