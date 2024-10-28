//import { createStore } from "redux";  // ES6 모듈
const { createStore } = require('redux'); // CommonJs 모듈

// 리듀서의 정의
// 액션이 발생했을 때 새로운 상태로 기존상태를 업데이트 해주는 역할을 한다.
const reducer = (prevState, acton) => { // prevState : 이전 값
    console.log("action : ", action.type)
    switch(isAction.type){
        case 'CHANGE_AGE':
            return{ // return : store 에 저장할 값
                ...prevState,
                age: action.data,
            };
            default: 
                return prevState;
    }
}


// 전역 state (전역에서 관리하는 state)
const initialState = {
    name: "hana",
    age : 1,
    adderss: null,
}
{

}
// 스토어 생성
// 전역 state 가 저장된 저장소
const store = createStore(reducer/* 액션이 발생하였을 때 업데이트로 행동할 것 */, initialState /*state 값 */)

console.log(store.getState())


// 액션 생성 함수
const changeAge = (data) => {
    return{
        type: 'CHANGE_AGE',
        data,

    }
}

// 액션 디스패치
store.dispatch(changeAge(20))


/*
    action 의 값에 따라 store에 업데이트 값이 달라진다.
    prevState : 이전 값
*/