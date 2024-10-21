import React, { useState } from 'react'
import Toolbar from './Toolbar'

/*
    여러 컴포넌트에 걸쳐서 사용하는 데이터가 있따면 이를 포괄하고 있는 상위컴포넌트에
    state 값으로 저장한 뒤 props를 통해서 전달해줘야한다. 
    또한 해당 setState 함수를 바로 전달하여 하위 컴포넌트에서 값을 변경하기 보다는
    state 를 정의한 컴포넌트에서 함수를 만들어 값을 어떻게 변경할 것인지 정의한 후 
    props 로 전달하는 것이 좋다.
*/

const LandingPage = () => {
    const [isLogin, setIsLogin] = useState(false);

    const onClickLogin = () => {
        setIsLogin(true);
    }

    const onClickLogout= () => {
        setIsLogin(false);
    }

    return(
        <div>
            <h1 style={{padding : 24}}> KH정보교육원</h1>
            <Toolbar 
                isLogin = {isLogin}
                setIsLogin = {setIsLogin}
                onClickLogin = {onClickLogin}
                onClickLogout = {onClickLogout}
            />
        </div>
    )
}

export default LandingPage