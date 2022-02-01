package com.care.member.memberController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.member.memberDTO.MemberDTO;
import com.care.member.memberService.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService ms;
	
	@GetMapping("user/registerForm")
	public String resgitserForm() {
		return "user/registerForm";
	}
	
	@PostMapping("user/register")
	public String register(@RequestParam() String id,
							@RequestParam() String pw,
									@RequestParam("addr1") String address,
										@RequestParam() String email) {
		
		email = email.substring(0, email.length()-1); //마지막 쉼표가 추가 되는것을 없애주는 작업을 합니다.
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setAddress(address);
		dto.setEmail(email);
		dto.setImageFileName("nan");
		
		ms.register(dto);
		return "user/profilePhoto";
	}
	
	@PostMapping("user/profileUpload")
	public String profileUpload(MultipartHttpServletRequest mul) {
		String id = mul.getParameter("id");
		
		System.out.println("service : " + mul.getParameter("id"));
		MultipartFile file = mul.getFile("imageFileName");
		System.out.println("service : " + file.getOriginalFilename());
	
		ms.profileUpload(mul);
		
		return "redirect:/loginPopup";
	}
	
}
