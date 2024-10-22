import React, { useCallback, useState } from 'react'
import ViewItem from './Viewitem';

/*
    ☁ useCallback
      메모이제이션 기법으로 컴포넌트 성능을 최적화시켜주는 도구이다.
      함수를 메모이제이션 하여 불필요한 재성성을 방지한다.
      컴포넌트가 리렌더링될 때, 의존성 배열에 있는 값이 변경되지 않으면
      이전의 함수를 반환한다.
      자식 컴포넌트가 불필요하게 리렌더링 되는 것을 방지하는데 유용하다.

    ❗ 사용법
      useCallback(() => {
    
      }, [])

    ◼ 첫 번째 인자는 메모제이션하고 사용할 함수를 전달하고
    ◼ 두 번째 인자는 의존성배열을 전달한다.

    ◼ 함수 자체를 저장해서 내리면 함수가 계속 저장되고 있어서 리렌더링 되지 않아서 
      자식 컴포넌트가 리렌더링 되지 않는다.
*/

const UseCallBackText = () => {
    const [num, setNum] = useState(1);
    const [dark, setDark] = useState(false);

    // const getItems = () => {
    //     return [num, num + 1 , num + 2]
    // 

    const getItems = useCallback((addNum) => {
        return [num, num + addNum , num + addNum]
    }, [num])

    const theme = {
        backgroundColor: dark ? "#333333" : "#ffffff",
        color : dark? "#ffffff" : "#333333",
    }

    const onChangeNum = (ev) => {
        setNum(parseInt(ev.target.value))
    }

    return (
        <div style={theme}>
            <input 
                type="number" 
                value={num}
                onChange={onChangeNum}
            />
            <button
                onClick={() => {setDark(!dark)}} 
                // 짧을 경우 여기에 넣어도 된다.
            >
                테마 변경
            </button>

            <ViewItem getItems={getItems}/>
        </div>
    )
}

export default UseCallBackText

