package com.navi.mini.program.controller.retwo;

import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.constant.Constant.ResultInfo;
import com.navi.mini.program.common.controller.BaseController;
import com.navi.mini.program.common.response.BaseResponse;
import com.navi.mini.program.model.retwo.RetWo;
import com.navi.mini.program.service.retwo.RetWoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
@Scope("prototype")
@RestController
@RequestMapping("/retWo")
public class RetWoController extends BaseController {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(RetWoController.class);

	@Autowired
	private RetWoService retWoService;
	
	/**
	 * 方法描述：查询列表
	 * @param retWo
	 * @return
	 */
	@PostMapping(value="/queryList", consumes="application/json", produces="application/json")
	public BaseResponse queryList(@RequestBody RetWo retWo) {
		try {
			clear();
			PageInfo<RetWo> pageInfo = retWoService.queryList(retWo);
			data.put(ResultInfo.PAGE, pageInfo);
		} catch (Exception e) {
			logger.info("/retWo/queryList 异常：" + e.toString());
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
			retWoService.deleteById(id);
		} catch (Exception e) {
			logger.info("/retWo/deleteById 异常：" + e.toString());
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
			RetWo obj = retWoService.queryById(id);
			data.put(ResultInfo.DATA, obj);
		} catch (Exception e) {
			logger.info("/retWo/queryById 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}
	
	/**
	 * 方法描述： 保存一条记录
	 * @param retWo
	 * @return
	 */
	@PostMapping(value="/save", consumes="application/json", produces="application/json")
	public BaseResponse save(@RequestBody RetWo retWo) {
		try {
			clear();
			retWoService.saveRetWo(retWo);
		} catch (Exception e) {
			logger.info("/retWo/save 异常：" + e.toString());
			error(Constant.ERRORMSG + e.getMessage());
		}
		
		return returnBaseResponse();
	}
	
}