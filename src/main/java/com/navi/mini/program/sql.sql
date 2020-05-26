
alter table ret_wo add IN_WHARF_CHANGER_TIMESTAMP timestamp(0) null comment "更换码头申请时间";

alter table his_ret_wo add IN_WHARF_CHANGER_TIMESTAMP timestamp(0) null comment "更换码头申请时间";
alter table his_ret_wo add APPROVAL_STATUS char(1) null comment "C待审批|A审批中|O审批结束";
alter table his_ret_wo add APPROVAL_RESULTS char(1) null comment "Y:同意|N:拒绝";
alter table his_ret_wo add APPROVAL_COMMENTS text(0) null comment "审批意见";
alter table his_ret_wo add ADD_TYPE int(1) not null comment "添加的类型：0：正常添加，1：码头更换添加，2：码头更换审批添加，3：质检添加";

alter table ret_box_emp_no add BOX_NUM int(5) not null comment "箱数";
alter table ret_box_emp_no add PALLET_NUM int(5) not null comment "托数";
alter table ret_box_emp_no add APPLY_TIME timestamp()  null comment "申请时间";
alter table ret_box_emp_no add APPROVE_TIME timestamp() null comment "审核时间";


alter table ret_box_emp_no add IS_GET char(1) not null comment "是否领取，Y：是，N：不是";
