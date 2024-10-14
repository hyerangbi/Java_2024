package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.vo.PageInfo;

public class BoardDao {
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi){
		// 마이바티스에서는 페이징처리를 위해 rowBounds라는 클래스를 제공
		// offset : 몇 개의 게시글을 건너뛰고 조회할건지
		/*
		 * curentPage : 1 	1~5 	0		5
		 * curentPage : 2 	6~10 	5		5
		 * curentPage : 3 	11~15 	10		5
		 */
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds); // 사용하고 싶은 sql, null : 전달할 파라미터 없다		
	}
	
	public int increaseCount(SqlSession sqlSession, int BoardNo) {
		return sqlSession.update("boardMapper.increaseCount", BoardNo); // 사용하고 싶은 sql, 전달하고자 하는 파라미터
	}
	
	public Board selectBoard(SqlSession sqlSession, int BoardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", BoardNo);
	}

	public ArrayList<Reply> selectReply(SqlSession sqlSession, int BoardNo) {		
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList");
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String>map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}
	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String>map, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList",map, rowBounds);				 
	}
}
