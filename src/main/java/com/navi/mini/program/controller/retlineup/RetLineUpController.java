package com.navi.mini.program.controller.retlineup;

import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.constant.Constant.ResultInfo;
import com.navi.mini.program.common.controller.BaseController;
import com.navi.mini.program.common.response.BaseResponse;
import com.navi.mini.program.model.retlineup.RetLineUp;
import com.navi.mini.program.service.retlineup.RetLineUpService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@Scope("prototype")
@RestController
@RequestMapping("/retLineUp")
public class RetLineUpController extends BaseController {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(RetLineUpController.class);

	@Autowired
	private RetLineUpService retLineUpService;
	
	/**
	 * 方法描述：查询列表
	 * @param retLineUp
	 * @return
	 */
	@PostMapping(value="/queryList", consumes="application/json", produces="application/json")
	public BaseResponse queryList(@RequestBody RetLineUp retLineUp) {
		try {
			clear();
			PageInfo<RetLineUp> pageInfo = retLineUpService.queryList(retLineUp);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/retLineUp/queryList 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}

	/**
	 * 查询送果人的排号信息
	 * @param retLineUp
	 * @return
	 */
	@PostMapping(value="/queryByUserIdAndDate", consumes="application/json", produces="application/json")
	public BaseResponse queryByUserIdAndDate() {
		try {
			clear();
			RetLineUp retLineUp = retLineUpService.queryByUserIdAndDate();
			data.put(ResultInfo.DATA, retLineUp);
		} catch (Exception e) {
			logger.info("/retLineUp/queryByUserIdAndDate 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 保存一条记录
	 * @param retLineUp
	 * @return
	 */
	@PostMapping(value="/save", consumes="application/json", produces="application/json")
	public BaseResponse save(@RequestBody RetLineUp retLineUp) {
		try {
			clear();
			retLineUpService.saveRetLineUp(retLineUp);
		} catch (Exception e) {
			logger.info("/retLineUp/save 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}
	
}