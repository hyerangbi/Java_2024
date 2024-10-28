export const logIn = (data) => {
/*
    서버에 (비동기)요청 

    서버에 전달해서 비동기로 처리하고 싶다.
    dispatch 가 action 으로 받는다

    함수면 비동기
    함수가 아니면 동기로 처리를 해준다.
*/
    return (dispatch, getState) => {
        try{
            dispatch(logInRequest(data));
            setTimeout(() => { // 로그인 정보를 받아오는데 3초 소요
                const loginInfo = {
                    userId: 1,
                    nickname: "원일이 바보"
                }

                dispatch(logInSuccess(loginInfo))
            }, 3000)            
        } catch(e){
            dispatch(logInFail(e))
        }
    }
}

const logInRequest = (data) => {
    return{
        type: "LOG_IN_REQUEST", 
        data,
    }
}

const logInSuccess = (data) => {
    return {
        type: "LOG_IN_SUCCESS",
        data,
    }
}

const logInFail = (e) => {
    return{
        type: "LOG_IN_FAIL",
        error: e,
    }
} 

export const logOut = () => {
    return{
        type:"LOG_OUT",
    }
}