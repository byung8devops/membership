package com.byung8.member.service;

import com.byung8.common.domain.Member;
import com.byung8.common.domain.MemberAuth;
import com.byung8.common.domain.Result;
import com.byung8.common.domain.SearchOption;
import com.byung8.common.exception.Byung8Exception;

public interface MemberService {
	Result registerMember(Member member, String txid) throws Byung8Exception;
	Result modifyMemberAuth(MemberAuth memberAuth, String txid) throws Byung8Exception;
	Result findMemberByEmail(String email, String txid) throws Byung8Exception;
	Result findMemberByName(String name, String txid) throws Byung8Exception;
	Result findMemberById(int id, String txid) throws Byung8Exception;
	Result findMemberList(SearchOption searchOption, String txid) throws Byung8Exception;
	Result findMemberList(String txid) throws Byung8Exception;
	Result modifyMember(Member member, String txid) throws Byung8Exception;
	Result modifyMemberNotUsed(Member member, String txid) throws Byung8Exception;
	Result modifyMemberAvailable(Member member, String txid) throws Byung8Exception;
}
