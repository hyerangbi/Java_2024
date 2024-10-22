import React from 'react'
/*' 
    useContext
    데이터를 부모 컴포넌트에서 자식 컴포넌트 단계적으로 전달할 때는 props를 사용한다.
    이 때 react context 를 사용하면 리액트앱에서 전역 데이터를 쉽게 공유하고 관리할 수 있다.
    props 로 data 를 일일이 내려 보내주지 않아도, 하위 컴포넌트에서 context에 있는 데이터에
    언제든지 접근할 수 있다.

    여러 컴포넌트가 사용해야하는 전역적인 제이터를 관리할 때 사용한다.
*/
const ThemeContext = React.createContext();

export default ThemeContext