package study.board.domain.entity;

import lombok.*;

import java.time.LocalDateTime;

// @Data 를 사용하면 안되는 이유 : 붙이는 순간 접근제한자(정보은닉)의 의미가 사라진다.
// 기본생성자를 만들어줘야 하는 이유 : 꼭 내가 안 만들 수도 있다. spring 이 만들어준다거나 그럴 수 있따.
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // access 의 레벨을 정할 수 있따.
@AllArgsConstructor
@Builder // 무조건 생성자를 써야하는데 어떤 값을 넣어야 할 줄 모를때
@Setter
public class Board {
    private Long boardId;
    private String title;
    private String contents;
    private String fileName;
    private String memberEmail;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

//    public static Builder builder() {
//        return new Builder();
//    }
//
//    public static class Builder {
//        private Board board = new Board();
//
//        public Builder setBoardId(Long boardId) {
//            this.board.setBoardId(boardId);
//            return this;
//        }
//
//        public Builder setTitle(String title) {
//            this.board.setTitle(title);
//            return this;
//        }
//
//        public Board build(){
//            return this.board;
//        }
//    }
}
