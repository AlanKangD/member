package com.care.member.memberService;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.member.memberDTO.MemberDTO;
import com.care.member.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberMapper mapper;

	@Override
	public void register(MemberDTO dto) {
//		System.out.println(dto.getId());
//		System.out.println(dto.getPw());
//		System.out.println(dto.getEmail());
//		System.out.println(dto.getAddress()); 디버깅 과정 controller에서 값이 잘들어오는지를 확인하기 위해
		mapper.insertUser(dto);
		
	}

	@Override
	public void profileUpload(MultipartHttpServletRequest mul) {
		System.out.println(mul.getParameter("id"));
		MultipartFile file = mul.getFile("imageFileName");
		System.out.println(file.getOriginalFilename());
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss-");
		Calendar calendar = Calendar.getInstance();
	
		MemberDTO dto = new MemberDTO();
		dto.setId(mul.getParameter("id"));
		
		if(file.getSize() != 0) {
			String sysFileName = format.format(calendar.getTime());
			sysFileName += file.getOriginalFilename();
			
			File saveFile = new File(FROFILE + "/" + sysFileName);
			
			dto.setImageFileName(sysFileName);
			
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			dto.setImageFileName("nan");
		}
	
 		
		mapper.profileUpload(dto);
	}

	@Override
	public MemberDTO getUserData(String id) {
		
		return mapper.getUserData(id);
	}

	@Override
	public int loginChk(String userId, String userPw) {
		MemberDTO dto = mapper.getUserData(userId);
		if(dto != null) {
			if(dto.getPw().equals(userPw)) {
				return 1; //비밀 번호 승인
			}else {
				return 0; //비밀 번호가 맞지 않음
			}
		}else {
			return 2; //아이디 없음
		}
		//이렇게 번호를 부여한 이유는 메시지를 주기 위한 용도 메시지를 주게 되면 주석은 없애주겠습니다.
	}


	

}
