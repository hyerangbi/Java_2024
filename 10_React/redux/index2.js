//import { createStore } from "redux";  // ES6 모듈
const { createStore } = require('redux'); // CommonJs 모듈

// 리듀서의 정의
// 액션이 발생했을 때 새로운 상태로 기존상태를 업데이트 해주는 역할을 한다.
const reducer = (prevState, acton) => { // prevState : 이전 값
    console.log("action : ", action.type)
    switch(action.type){
        case 'LOG_IN':
            return{ // return : store 에 저장할 값
                ...prevState,
                isLoading: false,
                loginUser: action.data,
            };
        case 'LOG_OUT':
            return{ // return : store 에 저장할 값
                ...prevState,
                loginUser: null,
            };
        case 'ADD_BOARD':
            return{ // return : store 에 저장할 값
                ...prevState,
                boardList: [...prevState. boardList, action.data],
            };
        case 'LOG_IN_REQUEST':
            return{ // return : store 에 저장할 값
                ...prevState,
                isLoading: true,
            };
        case 'DELETE_BOARD':
            return{
                ...prevState,
                boardList: prevState.boardList.filter((board) => board.id != action.data),
            }

        default: 
            return prevState;
    }
}


// 전역 state (전역에서 관리하는 state)
const initialState = {
    loginUser: null,
    isLoggin: false,
    boardList: [],
}
// 스토어 생성
// 전역 state 가 저장된 저장소
const store = createStore(reducer/* 액션이 발생하였을 때 업데이트로 행동할 것 */, initialState /*state 값 */)

console.log(store.getState())


// 액션 생성 함수
const logIn = (data) => {
    return{
        type: 'LOG_IN',
        data,
    }
}

const logOut = (data) => {
    return{
        type: 'LOG_OUT',
    }
}

const addBoard = (data) => {
    return{
        type: 'DELETE_BOARD',
        data
    }
}
// --------------- 실행 -------------------

store.dispatch({
    type: "LOG_IN_REQUEST",
})

console.log("로그인 요청 중 ...")
console.log(store.getState())

store.dispatch(logIn({
    userId: "user01",
    id: 1,
    name: "20만골뜨게해주세요"
}))

console.log("로그인 완료 !")
console.log(store.getState())

store.dispatch(addBoard({
    id: 1,
    title: "안녕 리덕스 ( •̀ ω •́ )✧ !",
    content: "리덕스 쉬운가요 ? ",
}))

console.log("게시글 작성 완료 !")
console.log(store.getState())

store.dispatch(addBoard({
    id: 2,
    title: "몰?루 리덕스 ( •̀ ω •́ )✧ !!",
    content: "아직 잘 모르겠어요 ! ",
}))

console.log("게시글 작성 완료 !")
console.log(store.getState())

store.dispatch(deleteBoard(1))

console.log("게시글 삭제 완료 !")
console.log(store.getState())

store.dispatch(logOut());

console.log("로그아웃 ! ")
console.log(store.getState())

"DELETE_BOARD"