package com.care.member.memberController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		
		System.out.println("controller : " + mul.getParameter("id"));
		MultipartFile file = mul.getFile("imageFileName");
		System.out.println("controller : " + file.getOriginalFilename()); 
		//상단의 코드는 디버깅을 위한 작업입니다. 
		
	
		ms.profileUpload(mul);
		
		return "redirect:/loginPopup";
	}
	
	@GetMapping(value = "user/idChk",produces="application/json; charset=utf-8")
	@ResponseBody
	public String idChk(@RequestParam("id") String id) {
		System.out.println("idChk : " + id);
		MemberDTO dto = ms.getUserData(id);
		if(dto != null) {
			return "{\"result\" : 1}";
		}
		
		return "{\"result\":0}";
	}
	
	@PostMapping("user/loginChk")
	public String loginChk(Model model,
							@RequestParam("userId") String userId, 
								@RequestParam("userPw") String userPw) {
		int loginFun = ms.loginChk(userId, userPw);
		
		if(loginFun == 1) {
			model.addAttribute("userId",userId);
			return "redirect:loginSuccess";
		}
		
		return "redirect:loginPopup";
	}
	
	@GetMapping("user/loginSuccess")
	public String loginSuccess(HttpSession session,
								@RequestParam("userId") String id) {
		session.setAttribute("userId", id);

		
		return "redirect:/loginPopup";
	}
	
	@GetMapping("user/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/loginPopup";
	}
	
}
