//package com.scon.project.admin.consultant.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
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
//import com.scon.project.admin.consultant.model.service.ConsultantService;
//import com.scon.project.common.paging.Criteria;
//
//import lombok.extern.slf4j.Slf4j;
//
//@RestController
//@RequestMapping("/admin")
//@Slf4j
//public class ConsultantApiController {
//
//	private ConsultantService consultantService;
//	
//	@Autowired
//	public ConsultantApiController(ConsultantService consultantService) {
//		this.consultantService = consultantService;
//	}
//	
//	/* 상담 신청 내역 조회용 */
//	/* http://127.0.0.1:8001/admin/consultant/hopes?pageNo=1, 2, 3, ... pageNo 바꿔가면서 조회해 본 결과 내역 조회 OK */
//	@GetMapping("/consultant/hopes")
//	public ResponseEntity<List<ConsultantDTO>> selectAllConsultantHopeList(@ModelAttribute Criteria cri) throws Exception {
//		
//		List<ConsultantDTO> consultantHopeList = consultantService.selectAllConsultantHopeList(cri);
//		
//		log.info("API 상담 신청 내역 : {}", consultantHopeList);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(consultantHopeList);
//	}
//	
//	/* 상담 신청 상세 조회용 */
//	/* http://127.0.0.1:8001/admin/consultant/hope/460, 459, ... 번호 바꿔가면서 조회해 본 결과 상세 조회 OK */
//	@GetMapping("/consultant/hope/{no}")
//	public ResponseEntity<ConsultantDTO> selectHopeDetailPage(@PathVariable int no) throws Exception {
//		
//		log.info("API 신청 상세 조회 번호 : {}", no);
//		
//		ConsultantDTO consultantHopeDetail = consultantService.selectConsultantHopeDetail(no);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(consultantHopeDetail);
//	}
//	
//	/* 상담 일지 내역 조회용 */
//	/* http://127.0.0.1:8001/admin/consultants 조회해 본 결과 내역 조회 OK */
//	@GetMapping("/consultants")
//	public ResponseEntity<List<ConsultantDTO>> selectAllConsultantList(@ModelAttribute Criteria cri) throws Exception {
//		
//		List<ConsultantDTO> consultantList = consultantService.selectAllConsultantList(cri);
//		
//		log.info("API 상담 일지 내역 : {}", consultantList);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(consultantList);
//	}
//	
//	/* 상담 일지 등록용 */	
//	/* http://127.0.0.1:8001/admin/consultant/454, 453, ... 번호 바꿔가면서 등록해 본 결과 OK */
//	@PostMapping("/consultant/{no}")
//	public ResponseEntity<Map<String, String>> insertConsultant(@PathVariable int no, @RequestBody ConsultantDTO con) throws Exception {
//		
//		con.setNo(no);
//		
//		log.info("API 상담 신청 번호 : {}", no);
//		
//		String message = consultantService.insertConsultant(con) > 0 ? "상담 일지가 등록되었습니다" : "상담 일지 등록에 실패하였습니다";
//		
//		Map<String, String> result = new HashMap<>();
//		result.put("message", message);
//		
//		return ResponseEntity.ok(result);
//	}
//	
//	/* 상담 일지 상세 조회용 */
//	/* http://127.0.0.1:8001/admin/consultant/454, 446, ... 번호 바꿔가면서 조회해 본 결과 상세 조회 OK */
//	@GetMapping("/consultant/{no}")
//	public ResponseEntity<ConsultantDTO> selectDetailPage(@PathVariable int no) throws Exception {
//		
//		log.info("API 일지 상세 조회 번호 : {}", no);
//		
//		ConsultantDTO consultantDetail = consultantService.selectConsultantDetail(no);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(consultantDetail);
//	}
//	
//	/* 상담 일지 수정용 */	
//	/* http://127.0.0.1:8001/admin/consultant/454, 446, ... 번호 바꿔가면서 수정해 본 결과 OK */
//	@PutMapping("/consultant/{no}")
//	public ResponseEntity<Map<String, String>> modifyConsultant(@PathVariable int no, @RequestBody ConsultantDTO con) throws Exception {
//		
//		con.setNo(no);
//		
//		log.info("API 수정할 상담 일지 번호 : {}", no);
//		
//		String message = consultantService.modifyConsultant(con) > 0 ? "상담 일지가 수정되었습니다" : "상담 일지 수정에 실패하였습니다";
//		
//		Map<String, String> result = new HashMap<>();
//		result.put("message", message);
//		
//		return ResponseEntity.ok(result);
//	}
//	
//	/* 상담 일지 삭제용 */
//	/* http://127.0.0.1:8001/admin/consultant/454, 446, ... 번호 바꿔가면서 삭제해 본 결과 OK */
//	@DeleteMapping("/consultant/{no}")
//	public ResponseEntity<Map<String, String>> deleteConsultant(@PathVariable int no) throws Exception {
//		
//		log.info("API 상담 일지 삭제 번호 : {}", no);
//		
//		String message = consultantService.deleteConsultant(no) > 0 ? "상담 일지가 삭제되었습니다" : "상담 일지 삭제에 실패하였습니다";
//		
//		Map<String, String> result = new HashMap<>();
//		result.put("message", message);
//		
//		return ResponseEntity.ok(result);
//	}
//	
//}
