package com.care.member.memberService;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.member.memberDTO.MemberDTO;

public interface MemberService {
	public static String FROFILE = "C:/Users/samsung/Desktop/image_repo/test";
	
	public void register(MemberDTO dto);
	public void profileUpload(MultipartHttpServletRequest mul);
}
