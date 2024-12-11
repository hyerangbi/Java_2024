package study.board.APIController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.board.domain.dto.BoardResponse;
import study.board.domain.entity.Board;
import study.board.service.BoardService;

import java.util.ArrayList;
import java.util.List;

/*
    ☁ REST API 는 REST(Representational State Transfer) 라는 라키텍처 스타일을 따르는 API이다.
      ◼ REST 는 자원을 기반으로 한 네트워크 아키텍처 설계 방식으로, 주로 HTTP 를 사용하여 클라이언트와
        서버간의 데이터 통신을 지원한다.
      ◼ REST API 는 REST의 원칙에 따라 자원을 정의하고 자원에 대한 표준 HTTP 메서드
        (GET, POT, PUT, DELETE, PATCH 등)을 사용하여 조작한다.
      ◼ URL 에는 접근할 자원의 경로를 지정합니다.
        작업은 HTTP 메서드를 사용하여 표현한다.
        ◽ GET : 자원의 조회 ( 읽기 )
        ◽ POST : 자원의 생성
        ◽ PUT : 자원의 수정 ( 전체 )
        ◽ PATCH : 자원의 수정 ( 일부 )
        ◽ DELETE : 자원의 삭제

      ◼ REST  아키텍처 스타일이지 공식이 아니다.
        따라서 설계와 구현 방식이 개발자마다 다를 수 있다.
      ◼ RESTFUL 하지 않는 방식으로 설계 되는 경우도 많다.

    (+ 들으면서 적은 내용)
    🔹 내가 url 에 접근할지만 나타내는 것
      메소드로 행위를 나눠놓은 것이 rest 방식

    🔹rest 권장 방식 : 왠만하면 rest 로 잡아놓아야
      다른 사람들도 편하게 이해하고 쓸 수 있다.
 */

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<Board>> getBoardList() {
        List<Board> boardList = boardService.findAll();
        List<BoardResponse.SimpleDTO> resultDtoList = new ArrayList<>();
        for (Board board : boardList) {
            resultDtoList.add(BoardResponse.SimpleDTO.fromSimple(board));
        }

        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }

    @GetMapping("/{boardId}")
    public void getBoard(@PathVariable Long boardId) {

    }

    @PostMapping
    public void createBoard() {

    }

    @PutMapping
    public void updateBoard() {

    }

    @DeleteMapping
    public void deleteBoard() {

    }

}
