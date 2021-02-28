package com.byung8.member.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.byung8.common.domain.Member;
import com.byung8.common.domain.MemberAuth;

@Mapper
public interface MemberMapper {
	int registerMember(Member member) throws SQLException;
	int modifyMemberAuth(MemberAuth memberAuth) throws SQLException;
	Member findMemberByEmail(String email) throws SQLException;
	Member findMemberByName(String name) throws SQLException;
	Member findMemberById(int id) throws SQLException;
	List<Member> findMemberListByEmail(String email) throws SQLException;
	List<Member> findMemberListByName(String name) throws SQLException;
	List<Member> findMemberList() throws SQLException;
	int updateMember(Member member) throws SQLException;
	int updateMemberNotUsed(Member member) throws SQLException;
	int updateMemberAvailable(Member member) throws SQLException;
}
