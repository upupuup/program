package com.navi.mini.program.service.retwo.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.BeanUtils;
import com.navi.mini.program.common.utils.DateUtils;
import com.navi.mini.program.common.utils.EmptyUtils;
import com.navi.mini.program.common.utils.SessionUtils;
import com.navi.mini.program.dao.retwo.RetWoDao;
import com.navi.mini.program.model.bisdata.BisData;
import com.navi.mini.program.model.biseqpt.BisEqpt;
import com.navi.mini.program.model.bisuser.BisUser;
import com.navi.mini.program.model.hisretwo.HisRetWo;
import com.navi.mini.program.model.retwo.RetWo;
import com.navi.mini.program.service.bisdata.BisDataService;
import com.navi.mini.program.service.biseqpt.BisEqptService;
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
	@Autowired
	private BisEqptService bisEqptService;
	@Autowired
	private BisDataService bisDataService;

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
		hisRetWo.setOpeEvtUsr(Constant.UserConstants.MINI);
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
		Map<String, String> orchardistMap = new HashMap<>(64);
		Map<String, String> gradeMap = new HashMap<>(64);
		Map<String, String> statusMap = new HashMap<>(64);
		// 如果不为空，那么设置送果人信息，码头信息
		if (!CollectionUtils.isEmpty(list)) {
			// 遍历所有的数据
			for (RetWo ret : list) {
				this.solveSendUser(ret, userMap);
				this.solveWharf(ret, wharfMap, Constant.RetWork.CURRENT_WHARF);
				this.solveOrchardist(ret, orchardistMap);
				this.solveGrade(ret, gradeMap);
				this.statusMap(ret, statusMap);
			}
		}
		return retWoPageInfo;
	}

	/**
	 * 查询更换码头记录
	 * @param retWo 料单对象
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 19:53
	 */
	@Override
	public PageInfo<RetWo> queryChangeWharfList(RetWo retWo) throws Exception {
//		retWo
		return this.queryList(retWo);
	}

	/**
	 * 送果历史
	 * @param retWo 料单对象
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 19:53
	 */
	@Override
	public PageInfo<RetWo> querySendFruitList(RetWo retWo) throws Exception {
		retWo.setSendUsrId(SessionUtils.getCurrentUserId());
		return this.queryList(retWo);
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
		retWo.setApprovalStatus(Constant.Approve.APPROVE_WAIT_STATUS);
		// 设置分页
		PageHelper.startPage(retWo.getPageIndex(), retWo.getPageSize());
		List<RetWo> list = this.dao.queryChangeWharfApproveList(retWo);
		// 存放码头信息
		Map<String, String> wharfMap = new HashMap<>(64);
		Map<String, String> userMap = new HashMap<>(64);
		Map<String, String> orchardistMap = new HashMap<>(64);
		Map<String, String> gradeMap = new HashMap<>(64);
		// 如果不为空，那么设置送果人信息，码头信息
		if (!CollectionUtils.isEmpty(list)) {
			// 遍历所有的数据
			for (RetWo ret : list) {
				this.solveSendUser(ret, userMap);
				this.solveWharf(ret, wharfMap, Constant.RetWork.CURRENT_WHARF);
				this.solveWharf(ret, wharfMap, Constant.RetWork.CHANGE_WHARF);
				this.solveOrchardist(ret, orchardistMap);
				this.solveGrade(ret, gradeMap);
			}
		}
		return new PageInfo<RetWo>(list);
	}

	/**
	 * 处理果农
	 * @param ret
	 * @param orchardistMap
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 13:44
	 */
	private void solveOrchardist(RetWo ret, Map<String, String> orchardistMap) throws Exception{
		// 获取字典表主键
		String orchardist = ret.getOrchardist();
		// 判断是否为空
		if (!StringUtils.isBlank(orchardist)) {
			// 判断用户信息是否已经存在map里
			if (orchardistMap.containsKey(orchardist)) {
				ret.setOrchardistName(orchardistMap.get(orchardist));
			} else {
				// 查询果农信息
				BisData bisData = bisDataService.queryByDataSeqId(orchardist);
				if (bisData != null) {
					ret.setOrchardistName(bisData.getDataDesc());
					orchardistMap.put(orchardist, bisData.getDataDesc());
				}
			}

		}
	}

	/**
	 * 处理等级
	 * @param ret
	 * @param gradeMap
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 20:25
	 */
	private void solveGrade(RetWo ret, Map<String, String> gradeMap) throws Exception {
		// 获取字典表主键
		String grade = ret.getGrade();
		// 判断是否为空
		if (!StringUtils.isBlank(grade)) {
			// 判断等级信息是否已经存在map里
			if (gradeMap.containsKey(grade)) {
				ret.setGradeName(gradeMap.get(grade));
			} else {
				// 查询等级信息
				BisData bisData = bisDataService.queryByDataSeqId(grade);
				if (bisData != null) {
					ret.setGradeName(bisData.getDataDesc());
					gradeMap.put(grade, bisData.getDataDesc());
				}
			}

		}
	}

	/**
	 * 处理状态
	 * @param ret
	 * @param statusMap
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 20:25
	 */
	private void statusMap(RetWo ret, Map<String, String> statusMap) throws Exception {
		// 获取字典表主键
		String status = ret.getStatus();
		// 判断是否为空
		if (!StringUtils.isBlank(status)) {
			// 判断状态信息是否已经存在map里
			if (statusMap.containsKey(status)) {
				ret.setStatusName(statusMap.get(status));
			} else {
				// 查询果农信息
				BisData bisData = bisDataService.queryByDataSeqId(status);
				if (bisData != null) {
					ret.setStatusName(bisData.getDataDesc());
					statusMap.put(status, bisData.getDataDesc());
				}
			}

		}
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
					ret.setInWharfChangerName(wharfMap.get(wharf));
				}
			} else {
				 // 查询码头信息
				BisEqpt bisEqpt = bisEqptService.queryByEqptId(wharf);
				if (bisEqpt != null) {
					// 设置当前码头和更换码头信息
					String eqptName = bisEqpt.getEqptName();
					if (Constant.RetWork.CURRENT_WHARF.equals(currentOrChangeWharf)) {
						ret.setInWharfName(eqptName);
					} else {
						ret.setInWharfChangerName(eqptName);
					}

					wharfMap.put(wharf, eqptName);
				}
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
			BisEqpt wharf = bisEqptService.queryByEqptId(retWo.getInWharf());
			if (wharf != null) {
				retWo.setInWharfName(wharf.getEqptName());
			}

			String inWharfChanger = retWo.getInWharfChanger();
			if (!StringUtils.isBlank(inWharfChanger)) {
				// 查询更换码头信息
				wharf = bisEqptService.queryByEqptId(retWo.getInWharfChanger());
				if (wharf != null) {
					retWo.setInWharfChangerName(wharf.getEqptName());
				}
			}

			// 设置码头信息
			BisData orchardist = bisDataService.queryByDataSeqId(retWo.getOrchardist());
			if (orchardist != null) {
				retWo.setOrchardistName(orchardist.getDataDesc());
			}

			// 等级信息
			String grade = retWo.getGrade();
			BisData bisData = bisDataService.queryByDataSeqId(grade);
			if (bisData != null) {
				retWo.setGradeName(bisData.getDataDesc());
			}
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
		// 判断是否有权限
		if (!Constant.UserType.WHARF_PERSONB.equals(SessionUtils.getUsrHeadFlg())) {
			throw new Exception("您不是码头巡检员，不能操作");
		}

		String id = retWo.getId();
		EmptyUtils.isEmpty("主键", id);
		EmptyUtils.isEmpty("审批结果", retWo.getApprovalResults());
		EmptyUtils.isEmpty("审批意见", retWo.getApprovalComments());
		EmptyUtils.isEmpty("码头信息", retWo.getInWharf());
		EmptyUtils.isEmpty("更换码头信息", retWo.getInWharfChanger());
		// 查询料单信息
		RetWo queryRetWo = this.queryById(id);
		queryRetWo.setApprovalStatus(Constant.Approve.APPROVE_WAIT_STATUS);
		queryRetWo.setApprovalComments(retWo.getApprovalComments());
		queryRetWo.setApprovalResults(retWo.getApprovalResults());
		queryRetWo.setInWharf(retWo.getInWharf());
		queryRetWo.setInWharfChanger(retWo.getInWharfChanger());
		queryRetWo.setEvtTimestamp(DateUtils.getDefaultSys(DateUtils.FORMAT_YYYYMMDD24HHMMSS));
		queryRetWo.setEvtUsr(SessionUtils.getCurrentUserId());
		queryRetWo.setAddType(Constant.RetWork.ADD_TYPE_CHANGE);
		this.saveHisRetWo(queryRetWo);

		// 在新增历史表之后，把现在的表的一下字段置空
		queryRetWo.setApprovalStatus("");
		queryRetWo.setApprovalComments("");
		queryRetWo.setApprovalResults("");
		queryRetWo.setInWharfChanger("");
		// 现在码头的
		this.update(queryRetWo);
	}
}