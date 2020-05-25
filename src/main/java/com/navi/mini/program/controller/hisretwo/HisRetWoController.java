package com.navi.mini.program.controller.hisretwo;

import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.constant.Constant.ResultInfo;
import com.navi.mini.program.common.controller.BaseController;
import com.navi.mini.program.common.response.BaseResponse;
import com.navi.mini.program.model.hisretwo.HisRetWo;
import com.navi.mini.program.service.hisretwo.HisRetWoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
@Scope("prototype")
@RestController
@RequestMapping("/hisRetWo")
public class HisRetWoController extends BaseController {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(HisRetWoController.class);

	@Autowired
	private HisRetWoService hisRetWoService;
	
	/**
	 * 方法描述：查询列表
	 * @param hisRetWo
	 * @return
	 */
	@PostMapping(value="/queryList", consumes="application/json", produces="application/json")
	public BaseResponse queryList(@RequestBody HisRetWo hisRetWo) {
		try {
			clear();
			PageInfo<HisRetWo> pageInfo = hisRetWoService.queryList(hisRetWo);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/hisRetWo/queryList 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}

	/**
	 * 根据质检员查询记录
	 * @param hisRetWo
	 * @return
	 */
	@PostMapping(value="/queryByInspectionPerson", consumes="application/json", produces="application/json")
	public BaseResponse queryByInspectionPerson(@RequestBody HisRetWo hisRetWo) {
		try {
			clear();
			PageInfo<HisRetWo> pageInfo = hisRetWoService.queryByInspectionPerson(hisRetWo);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/hisRetWo/queryByInspectionPerson 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}

	/**
	 * 更换码头记录（送果人）
	 * @param hisRetWo
	 * @return
	 */
	@PostMapping(value="/queryChangeWharf", consumes="application/json", produces="application/json")
	public BaseResponse queryChangeWharf(@RequestBody HisRetWo hisRetWo) {
		try {
			clear();
			PageInfo<HisRetWo> pageInfo = hisRetWoService.queryChangeWharf(hisRetWo);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/hisRetWo/queryChangeWharf 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}

	/**
	 * 更换码头记录（码头巡视员）
	 * @param hisRetWo
	 * @return
	 */
	@PostMapping(value="/queryChangeWharfHis", consumes="application/json", produces="application/json")
	public BaseResponse queryChangeWharfHis(@RequestBody HisRetWo hisRetWo) {
		try {
			clear();
			PageInfo<HisRetWo> pageInfo = hisRetWoService.queryChangeWharfHis(hisRetWo);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/hisRetWo/queryChangeWharf 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 根据id获取数据对象
	 * @param hisRetWo
	 * @return
	 */
	@PostMapping(value="/queryById", consumes="application/json", produces="application/json")
	public BaseResponse queryById(@RequestBody HisRetWo hisRetWo) {
		try {
			clear();
			HisRetWo obj = hisRetWoService.queryById(hisRetWo.getId());
			data.put(ResultInfo.DATA, obj);
		} catch (Exception e) {
			logger.info("/hisRetWo/queryById 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}

		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 保存一条记录
	 * @param hisRetWo
	 * @return
	 */
	@PostMapping(value="/save", consumes="application/json", produces="application/json")
	public BaseResponse save(@RequestBody HisRetWo hisRetWo) {
		try {
			clear();
			hisRetWoService.saveHisRetWo(hisRetWo);
		} catch (Exception e) {
			logger.info("/hisRetWo/save 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}
	
}