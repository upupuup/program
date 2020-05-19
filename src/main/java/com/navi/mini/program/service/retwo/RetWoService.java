package com.navi.mini.program.service.retwo;


import com.navi.mini.program.common.service.BaseService;
import com.navi.mini.program.model.retwo.RetWo;

public interface RetWoService extends BaseService<RetWo> {
	void saveRetWo(RetWo retWo) throws Exception;
}