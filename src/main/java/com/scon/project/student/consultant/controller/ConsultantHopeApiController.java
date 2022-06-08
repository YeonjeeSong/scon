//package com.scon.project.student.consultant.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.scon.project.admin.consultant.model.dto.ConsultantDTO;
//import com.scon.project.common.paging.Criteria;
//import com.scon.project.member.model.dto.UserImpl;
//import com.scon.project.student.consultant.model.service.ConsultantHopeService;
//
//import lombok.extern.slf4j.Slf4j;
//
//@RestController
//@RequestMapping("/student")
//@Slf4j
//public class ConsultantHopeApiController {
//
//	private ConsultantHopeService consultantHopeService;
//	
//	@Autowired
//	public ConsultantHopeApiController(ConsultantHopeService consultantHopeService) {
//		this.consultantHopeService = consultantHopeService;
//	}
//	
//	/* 상담 신청 내역 조회용 */
//	/* http://127.0.0.1:8001/student/consultants?pageNo=1, 2, 3, ... pageNo 바꿔가면서 조회해 본 결과 내역 조회 OK */
//	@GetMapping("/consultants")
//	public ResponseEntity<List<ConsultantDTO>> selectAllConsultantList(@ModelAttribute Criteria cri, @AuthenticationPrincipal UserImpl user) throws Exception {
//		
//		cri.setMemberId(user.getId());
//		log.info("접속한 userId : {}", cri.getMemberId());
//		
//		List<ConsultantDTO> consultantList = consultantHopeService.selectAllConsultantList(cri);
//		log.info("상담 신청 내역 : {}", consultantList);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(consultantList);
//	}
//	
//	/* 상담 신청 등록용 */
//	/* http://127.0.0.1:8001/student/consultant 등록 OK */
//	@PostMapping("/consultant")
//	public ResponseEntity<Map<String, String>> insertConsultant(@RequestBody ConsultantDTO con, @AuthenticationPrincipal UserImpl user) throws Exception {
//		
//		log.info("로그인 유저 : {} ", user);
//		con.setMemberId(user.getId());
//		
//		String message = consultantHopeService.insertConsultant(con) == true ? "상담이 등록되었습니다" : "상담 등록에 실패하였습니다";
//		
//		Map<String, String> result = new HashMap<>();
//		result.put("message", message);
//		
//		return ResponseEntity.ok(result);
//	}
//	
//	/* 상담 신청 상세 조회용 */
//	/* http://127.0.0.1:8001/student/consultant/461, 454, ... 번호 바꿔가면서 조회해 본 결과 상세 조회 OK */
//	@GetMapping("/consultant/{no}")
//	public ResponseEntity<ConsultantDTO> selectDetailPage(@PathVariable int no) throws Exception {
//		
//		log.info("API 상담 신청 상세 조회 번호 : {}", no);
//		
//		ConsultantDTO consultantDetail = consultantHopeService.selectConsultantDetail(no);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(consultantDetail);
//	}
//	
//	/* 상담 신청 수정용 */
//	/* http://127.0.0.1:8001/student/consultant/462, 461, ... 번호 바꿔가면서 수정해 본 결과 OK */
//	@PutMapping("/consultant/{no}")
//	public ResponseEntity<Map<String, String>> modifyConsultant(@PathVariable int no, @RequestBody ConsultantDTO con) throws Exception {
//		
//		con.setNo(no);
//		
//		log.info("API 수정할 상담 신청 번호 : {}", no);
//		
//		String message = consultantHopeService.modifyConsultant(con) > 0 ? "상담 내용이 수정되었습니다" : "상담 내용 수정에 실패하였습니다";
//		
//		Map<String, String> result = new HashMap<>();
//		result.put("message", message);
//		
//		return ResponseEntity.ok(result);
//	}
//	
//	/* 상담 신청 삭제용 */
//	/* http://127.0.0.1:8001/student/consultant/462, 461, ... 번호 바꿔가면서 삭제해 본 결과 OK */
//	@DeleteMapping("/consultant/{no}")
//	public ResponseEntity<Map<String, String>> deleteConsultant(@PathVariable int no) throws Exception {
//		
//		log.info("API 상담 신청 삭제 번호 : {}", no);
//		
//		String message = consultantHopeService.deleteConsultant(no) > 0 ? "상담이 삭제되었습니다" : "상담 삭제에 실패하였습니다";
//		
//		Map<String, String> result = new HashMap<>();
//		result.put("message", message);
//		
//		return ResponseEntity.ok(result);
//	}
//	
//}
