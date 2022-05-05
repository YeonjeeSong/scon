package com.scon.project.admin.consultant.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.scon.project.admin.consultant.model.dto.ConsultantDTO;
import com.scon.project.config.SconApplication;

@SpringBootTest
@ContextConfiguration(classes = {SconApplication.class})
public class ConsultantServiceTests {

	@Autowired
	private ConsultantService consultantService;
	
	// success
	@Test
	@Disabled
	@DisplayName("의존성 주입 테스트")
	public void testInit() {
		
		assertNotNull(consultantService);
	}
	
	// success
	@Test
	@Disabled
	@DisplayName("상담 신청 내역 조회용 서비스 메소드 테스트")
	public void testSelectConsultantHope() {
		
		// when
		List<ConsultantDTO> consultantHopeList = consultantService.selectAllConsultantHopeList();
		
		// then
		assertNotNull(consultantHopeList);
	}
	
	// success
	@Test
	@Disabled
	@DisplayName("상담 신청 상세 조회용 서비스 메소드 테스트")
	public void testSelectConsultantHopeDetail() {
		
		// given
		int no = 22;
		
		// when
		ConsultantDTO consultantHopeDetail = consultantService.selectConsultantHopeDetail(no);
		
		// then
		assertNotNull(consultantHopeDetail);
	}
	
	// success
	@Test
	@Disabled
	@DisplayName("상담 일지 내역 조회용 서비스 메소드 테스트")
	public void testSelectConsultantList() {
		
		// when
		List<ConsultantDTO> consultantList = consultantService.selectAllConsultantList();
		
		// then
		assertNotNull(consultantList);
	}
	
	// success
	@Test
	@Disabled
	@DisplayName("상담 일지 등록용 서비스 메소드 테스트")
	public void testInsertConsultant() {
		
		// given
		ConsultantDTO con = new ConsultantDTO();
		con.setConNo(36);
		con.setConDate("2022-05-05");
		con.setConType("학업 문제");
		con.setConWay("개인 면담");
		con.setConImp(5);
		con.setConContent("개인 면담 진행");
		
		// when
		int result = consultantService.insertConsultant(con);
		
		// then
		assertEquals(1, result);
	}

}
