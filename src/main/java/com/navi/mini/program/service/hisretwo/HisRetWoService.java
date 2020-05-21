package com.navi.mini.program.service.hisretwo;

import com.navi.mini.program.common.service.BaseService;
import com.navi.mini.program.model.hisretwo.HisRetWo;

public interface HisRetWoService extends BaseService<HisRetWo> {
	void saveHisRetWo(HisRetWo hisRetWo) throws Exception;
}