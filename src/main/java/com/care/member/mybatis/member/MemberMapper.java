package com.care.member.mybatis.member;

import com.care.member.memberDTO.MemberDTO;

public interface MemberMapper {
	public void insertUser(MemberDTO dto);
	public void profileUpload(MemberDTO dto);

}
