package com.care.member.memberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
