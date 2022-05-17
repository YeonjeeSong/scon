package com.scon.project.admin.notice.model.dto;

import java.sql.Date;

import com.scon.project.member.model.dto.MemberDTO;

import lombok.Data;

@Data	
public class NoticeCmtDTO {
	
	private int cmtNo;
	private int brdNo;
	private int cmtPNo;
	private String memberId;
	private String cmtContent;
	private Date cmtDate;
	private Date cmtUpdate;
	private String cmtDelete;
}


/*
CMT_NO
BRD_NO
CMT_P_NO
MEMBER_ID
CMT_CONTENT
CMT_DATE
CMT_UPDATE
CMT_DELETE
*/