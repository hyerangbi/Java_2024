import React from 'react'

const Toolbar = (props) => {
     
    const { isLogin, onclickLogin , onclickLogout } = props;

    return ( 
        <div>
            {
                isLogin ?
                <div>
                    <div style={{ padding: 24 }}> 안녕하세요 ( •̀ ω •́ )✧ </div>
                    <button onClick={onclickLogout}> 로그아웃 </button>
                </div>:
                <div>
                    <div style={{padding: 24}}> 로그인이 필요한 서비스입니다. </div>
                    <button onClick={onclickLogin}> 로그인 </button>            
                </div>
            }        
        </div>
    )
}

export default Toolbar