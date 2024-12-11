package study.board.service;

import org.springframework.stereotype.Service;
import study.board.domain.entity.Board;
import study.board.mapper.BoardMapper;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public List<Board> findAll() {
        return boardMapper.findAll();
    }
}
