package com.care.member.memberService;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.member.memberDTO.MemberDTO;

public interface MemberService {
	public static String FROFILE = "C:/Users/samsung/Desktop/image_repo/test";
	
	public void register(MemberDTO dto);
	public void profileUpload(MultipartHttpServletRequest mul);
	public MemberDTO getUserData(String id);
	public int loginChk(String userId, String userPw);
}
