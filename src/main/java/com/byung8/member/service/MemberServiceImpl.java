package com.byung8.member.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byung8.common.domain.Member;
import com.byung8.common.domain.MemberAuth;
import com.byung8.common.domain.Result;
import com.byung8.common.domain.SearchOption;
import com.byung8.common.exception.Byung8Exception;
import com.byung8.member.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Service("memberService")
@Slf4j
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public Result registerMember(Member member, String txid) throws Byung8Exception {
		
		Result result = null;
		try {
			int cnt = memberMapper.registerMember(member);
			result = new Result(txid, Result.OK).putValue("result", cnt > 0 ? true : false);
		} catch(SQLException e) {
			log.error("registerMember", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result modifyMemberAuth(MemberAuth memberAuth, String txid) throws Byung8Exception {
		Result result = null;
		try {
			int cnt = memberMapper.modifyMemberAuth(memberAuth);
			result = new Result(txid, Result.OK).putValue("result", cnt > 0 ? true : false);
		} catch(SQLException e) {
			log.error("modifyMemberAuth", e);
			throw new Byung8Exception(e);
		}
		return result;
	}
	
	@Override
	public Result findMemberByEmail(String email, String txid) throws Byung8Exception {
		Result result = null;
		try {
			Member member = memberMapper.findMemberByEmail(email);
			result = new Result(txid, Result.OK).putValue("member", member);
		} catch(SQLException e) {
			log.error("findMemberByEmail", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result findMemberByName(String name, String txid) throws Byung8Exception {
		Result result = null;
		try {
			Member member = memberMapper.findMemberByName(name);
			result = new Result(txid, Result.OK).putValue("member", member);
		} catch(SQLException e) {
			log.error("findMemberByName", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result findMemberById(int id, String txid) throws Byung8Exception {
		Result result = null;
		try {
			Member member = memberMapper.findMemberById(id);
			result = new Result(txid, Result.OK).putValue("member", member);
		} catch(SQLException e) {
			log.error("findMemberById", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result findMemberList(SearchOption searchOption, String txid) throws Byung8Exception {
		Result result = null;
		try {
			List<Member> list = null;
			if (log.isInfoEnabled()) {
				log.info("=========> searchOption " + searchOption);
			}
			if ("emal".equalsIgnoreCase(searchOption.getSearchField())) {
				list = memberMapper.findMemberListByEmail(searchOption.getSearchValue());
				if (log.isDebugEnabled()) {
					log.debug("findMemberListByEmail : "+list.size());
				}
			} else if ("name".equalsIgnoreCase(searchOption.getSearchField())) {
				list = memberMapper.findMemberListByName(searchOption.getSearchValue());
				if (log.isDebugEnabled()) {
					log.debug("findMemberListByName : "+list.size());
				}
			} else {
				list = memberMapper.findMemberList();
				if (log.isDebugEnabled()) {
					log.debug("findMemberList : "+list.size());
				}
			}
			
			result = new Result(txid, Result.OK).putValue("FitnessMemberList", list);
		} catch(SQLException e) {
			log.error("findMemberList", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result findMemberList(String txid) throws Byung8Exception {
		Result result = null;
		try {
			List<Member> list = null;
			list = memberMapper.findMemberList();
			if (log.isDebugEnabled()) {
				log.debug("findMemberList : "+list.size());
			}
			
			result = new Result(txid, Result.OK).putValue("FitnessMemberList", list);
		} catch(SQLException e) {
			log.error("findMemberList", e);
			throw new Byung8Exception(e);
		}
		return result;
	}
	
	@Override
	public Result modifyMember(Member member, String txid) throws Byung8Exception {
		Result result = null;
		try {
			int ret = memberMapper.updateMember(member);
			
			result = new Result(txid, Result.OK).putValue("modifyMember", ret > 0 ? true : false);
		} catch(SQLException e) {
			log.error("findMemberList", e);
			throw new Byung8Exception(e);
		}
		return result;
	}
	
	@Override
	public Result modifyMemberNotUsed(Member member, String txid) throws Byung8Exception{
		Result result = null;
		try {
			int ret = memberMapper.updateMemberNotUsed(member);
			
			result = new Result(txid, Result.OK).putValue("modifyMemberNotUsed", ret > 0 ? true : false);
		} catch(SQLException e) {
			log.error("findMemberList", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result modifyMemberAvailable(Member member, String txid) throws Byung8Exception{
		Result result = null;
		try {
			int ret = memberMapper.updateMemberAvailable(member);
			
			result = new Result(txid, Result.OK).putValue("updateMemberAvailable", ret > 0 ? true : false);
		} catch(SQLException e) {
			log.error("findMemberList", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

}
