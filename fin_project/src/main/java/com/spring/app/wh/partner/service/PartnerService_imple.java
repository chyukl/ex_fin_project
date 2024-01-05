package com.spring.app.wh.partner.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring.app.common.AES256;
import com.spring.app.expedia.domain.ChatVO;
import com.spring.app.expedia.domain.HostVO;
import com.spring.app.wh.partner.model.PartnerDAO;

@Service
public class PartnerService_imple implements PartnerService {

	@Autowired
	private PartnerDAO dao;
	
	@Autowired
	private AES256 aES256;

	
	// 로그인 처리하기
	@Override
	public HostVO getLoginHost(Map<String, String> paraMap) {
		HostVO loginhost = dao.getLoginHost(paraMap);
		
		return loginhost;
	}

	// 회원가입 시 입력한 아이디 값이 기존에 가입한 회원에 존재하는지 확인해주는 메소드
	@Override
	public int idDuplicateCheck(String userid) {
		int isExists = dao.idDuplicateCheck(userid);
		return isExists;
	}
	
	
	
	// tbl_host 에 HostVO 에 저장된 정보를 insert 해주는 메소드
	@Override
	public int registerHost(HostVO host) {

		int n = dao.registerHost(host);
		return n;
	}

	
	// 월별 객실등급별 예약 인원 수 가져오기
	@Override
	public List<Map<String, String>> useLodgeCnt(Map<String, String> paraMap) {
		List<Map<String, String>> useLodgeCntList = dao.useLodgeCnt(paraMap);
		return useLodgeCntList;
	}

	
	// tbl_host 에 저장된 판매자의 정보를 update 해주는 메소드
	@Override
	public int editHost(Map<String, String> paraMap) {
		int n = dao.editHost(paraMap);
		return n;
	}

	
	// 채팅방 불러오기
	@Override
	public ChatVO selectChat(String lodge_id) {
		ChatVO chatvo = dao.selectChat(lodge_id);
		return chatvo;
	}

	

	
	


}