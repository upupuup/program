package com.navi.mini.program.service.retwo.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.BeanUtils;
import com.navi.mini.program.common.utils.DateUtils;
import com.navi.mini.program.common.utils.EmptyUtils;
import com.navi.mini.program.dao.retwo.RetWoDao;
import com.navi.mini.program.model.bisuser.BisUser;
import com.navi.mini.program.model.hisretwo.HisRetWo;
import com.navi.mini.program.model.retwo.RetWo;
import com.navi.mini.program.service.bisuser.BisUserService;
import com.navi.mini.program.service.hisretwo.HisRetWoService;
import com.navi.mini.program.service.retwo.RetWoService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RetWoServiceImpl extends BaseServiceImpl<RetWo, RetWoDao> implements RetWoService {
	@Autowired
	private BisUserService bisUserService;
	@Autowired
	private HisRetWoService hisRetWoService;

	/**
	 * 保存
	 * @param retWo 料单信息
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/21 22:06
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
    public void saveRetWo(RetWo retWo) throws Exception{
		String id = retWo.getId();
		if (StringUtils.isBlank(id)) {
			
			this.insert(retWo);
			this.saveHisRetWo(retWo);
		} else {
			this.update(retWo);
			this.saveHisRetWo(retWo);
		}
    }

	/**
	 * 保存历史表
	 * @param retWo 料单表
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/21 22:01
	 */
	@Transactional(rollbackFor = Exception.class)
	public void saveHisRetWo(RetWo retWo) throws Exception {
		HisRetWo hisRetWo = new HisRetWo();
		BeanUtils.copyProperties(retWo, hisRetWo, false);
		hisRetWoService.saveHisRetWo(hisRetWo);
	}

	/**
	 * 分页查询数据
	 * @param retWo 料单对象
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/21 14:27
	 */
    @Override
	public PageInfo<RetWo> queryList(RetWo retWo) throws Exception {
		EmptyUtils.isEmpty("用户主键", retWo.getSendUsrId());
		// 查询料单信息
		PageInfo<RetWo> retWoPageInfo = super.queryList(retWo);
		List<RetWo> list = retWoPageInfo.getList();

		// 存放码头信息
		Map<String, String> wharfMap = new HashMap<>(64);
		Map<String, String> userMap = new HashMap<>(64);
		// 如果不为空，那么设置送果人信息，码头信息
		if (!CollectionUtils.isEmpty(list)) {
			// 遍历所有的数据
			for (RetWo ret : list) {
				this.solveSendUser(ret, userMap);
				this.solveWharf(ret, wharfMap, Constant.RetWork.CURRENT_WHARF);
			}
		}
		return retWoPageInfo;
	}

	/**
	 * 查询更换码头待审批
	 * @param retWo 料单对象
	 * @return
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/21 15:28
	 */
	@Override
	public PageInfo<RetWo> queryChangeWharfApproveList(RetWo retWo) throws Exception {
		retWo.solvePageIndexAndPageSize(retWo.getPageIndex(), retWo.getPageSize());
		retWo.setApprovalStatus(Constant.RetWork.APPROVA_WAIT_STATUS);
		PageHelper.startPage(retWo.getPageIndex(), retWo.getPageSize());
		List<RetWo> list = this.dao.queryChangeWharfApproveList(retWo);
		// 存放码头信息
		Map<String, String> wharfMap = new HashMap<>(64);
		Map<String, String> userMap = new HashMap<>(64);
		// 如果不为空，那么设置送果人信息，码头信息
		if (!CollectionUtils.isEmpty(list)) {
			// 遍历所有的数据
			for (RetWo ret : list) {
				this.solveSendUser(ret, userMap);
				this.solveWharf(ret, wharfMap, Constant.RetWork.CURRENT_WHARF);
				this.solveWharf(ret, wharfMap, Constant.RetWork.CHANGE_WHARF);
			}
		}
		return new PageInfo<RetWo>(list);
	}

	/**
	 * 设置码头信息
	 * @param ret 料单
	 * @param wharfMap 码头map
	 * @param currentOrChangeWharf 当前码头还是申请更换的码头
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/21 14:26
	 */
	private void solveWharf(RetWo ret, Map<String, String> wharfMap, String currentOrChangeWharf) throws Exception {
		String wharf = "";
		if (Constant.RetWork.CURRENT_WHARF.equals(currentOrChangeWharf)) {
			wharf = ret.getInWharf();
		} else {
			wharf = ret.getInWharfChanger();
		}

		// 判断是否为空
		if (!StringUtils.isBlank(wharf)) {
			// 判断码头信息是否已经存在map里
			if (wharfMap.containsKey(wharf)) {
				if (Constant.RetWork.CURRENT_WHARF.equals(currentOrChangeWharf)) {
					ret.setInWharfName(wharfMap.get(wharf));
				} else {
					ret.setInWharfChanger(wharfMap.get(wharf));
				}
			} else {
				// 查询码头信息
//				BisUser bisUser = bisUserService.queryByUserId(wharf);
//				if (bisUser != null) {
//					ret.setSendUserName(bisUser.getUsrName());
//					wharfMap.put(wharf, bisUser.getUsrName());
//				}
			}

		}
	}

	/**
	 * 处理送果人信息
	 * @param ret 料单
	 * @param userMap 送果人map
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/21 14:27
	 */
	private void solveSendUser(RetWo ret, Map<String, String> userMap) throws Exception {
    	// 获取用户主键
		String sendUsrId = ret.getSendUsrId();
		// 判断是否为空
		if (!StringUtils.isBlank(sendUsrId)) {
			// 判断用户信息是否已经存在map里
			if (userMap.containsKey(sendUsrId)) {
				ret.setSendUserName(userMap.get(sendUsrId));
			} else {
				// 查询送果人信息
				BisUser bisUser = bisUserService.queryByUserId(sendUsrId);
				if (bisUser != null) {
					ret.setSendUserName(bisUser.getUsrName());
					userMap.put(sendUsrId, bisUser.getUsrName());
				}
			}

		}
	}

	/**
	 * 根据id查询料单
	 * @param id
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/21 19:59
	 */
	@Override
	public RetWo queryById(String id) throws Exception {
		EmptyUtils.isEmpty("主键", id);
		RetWo retWo = this.dao.queryById(id);
		if (retWo != null) {
			// 查询送果人信息
			BisUser bisUser = bisUserService.queryByUserId(retWo.getSendUsrId());
			if (bisUser != null) {
				retWo.setSendUserName(bisUser.getUsrName());
			}
			// 查询码头信息
		}
		return retWo;
	}

	/**
	 * 审批更换码头
	 * @param retWo
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/21 21:41
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void changeWharfApprove(RetWo retWo) throws Exception {
		String id = retWo.getId();
		EmptyUtils.isEmpty("主键", id);
		EmptyUtils.isEmpty("审批结果", retWo.getApprovalResults());
		EmptyUtils.isEmpty("审批意见", retWo.getApprovalComments());
		// 查询料单信息
		RetWo queryRetWo = this.queryById(id);
		queryRetWo.setApprovalStatus(Constant.RetWork.APPROVA_END_STATUS);
		queryRetWo.setApprovalComments(retWo.getApprovalComments());
		queryRetWo.setApprovalResults(retWo.getApprovalResults());
		queryRetWo.setEvtTimestamp(DateUtils.getDefaultSys(DateUtils.FORMAT_YYYYMMDD24HHMMSS));
		this.saveRetWo(queryRetWo);
	}
}