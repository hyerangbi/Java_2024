package com.kh.member.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	public Member loginMember(String userId, String userPwd){
		Connection conn = getConnection();
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		
		close(conn);
		return m;
	}
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().insertMember(conn, m);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public Member updatePwdMember(String userId, String userPwd, String updatePwd) {
		Connection conn = getConnection();
		int result = new MemberDao().updatePwdMember(conn, userId, userPwd, updatePwd);
		
		
		Member updateMember = null;
		if (result > 0) {
			commit(conn);
			
			updateMember = new MemberDao().selectMember(conn, userId);
			// 아이디를 가져오거나 아이디와 변경된 비밀번호 둘 다 가져오거나
			
		} else {
			rollback(conn);
		}
		
		return updateMember;
	}
	
	public int deleteMember(String userId, String userPwd) {
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(conn, userId, userPwd); //dao한테 데이터 전달
		
		if(result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public Member updateMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().updateMember(conn, m);
		
		Member updateMember = null;
		if (result > 0) {
			commit(conn);
			
			updateMember = new MemberDao().selectMember(conn, m.getUserId());
			// 아이디를 가져오거나 아이디와 변경된 비밀번호 둘 다 가져오거나
			
		} else {
			rollback(conn);
		}
		
		return updateMember;
	}
}

