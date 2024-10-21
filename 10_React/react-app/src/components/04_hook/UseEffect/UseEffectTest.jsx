import React, { useEffect, useState } from 'react'

/*
     ◼ useEffect
       컴포넌트가 렌더링 될 때 특정 작업을 실행할 수 있도록 하는 react hook
       클래스형 컴포넌트의 생명주기 메소드으의 역할을 대체한다.

    컴포넌트가 마운트 됐을 때 ( 처음 나타났을 때 ), 언마운트 됐을 때 ( 사라질 때 )
    업데이트 됐을 때 ( 특정 state, props 가 바뀌었을 때)

    ☁ 사용법 
    useEffect(effect, []) // []에는 use성 배열
    첫번째 인자 (effect) : 함수 → 특정 상황이 왔을 대 실행이 되는 함수
    두번째 인자 : 배열 → 의존성 배열
*/

const UseEffectTest = () => {
    const [name, setName] = useState("김개똥");
    const [num, setNum] = useState(0);
    
    const handleKeyUpName = (ev) => {
        setName(ev.target.value)
    }

    const handleClickNum = () => {
        setNum(ev.target.value)
    }

    /* 
        ⭐ 의존성 없는 useEffect 는 
           렌더링이 되었을 때, 그리고 state 가 변경 될 때 마다 console.log 가 실행되었다.
           componentDidMount & componentDidUpdate 의 역할을 대체할 수 있다.
    */
    useEffect(() => {
        console.log("의존성 배열이 없는 useEffect 호출")
    })

    /*
        ⭐ 빈 배열을 가지고 있는 useEffect 는
           렌더링이 되었을 때 한 번만 실행이 된다. (최초 마운트)
           (배열이 비어있어서 변경 할 점이 없음)
           componentDidMounu 의 역할을 대체하고 있따.
    */
    useEffect(() => {
        console.log("빈 배열을 의존성 배열을 가진 useEffect 호출")
    }, [])


    /*
        ⭐ 배열의 의존성을 가진 useEffect 는 
           렌더링이 되었을 때 그리고 name state 가 변경 되었을 때 호출된다.
           의존성 배열 안에 있는 state 가 변하면 해당 effect 함수를 호출해준다. 
           componentDidMount & componentDidUpdate 의 역할을 대체할 수 있다.

     */
    useEffect(() => {
        console.log(`${name} [name] 을 의존성 배열을 가진 useEffect 호출`)
    }, [name])


    /*
        ⭐ 함수를 리턴하는 useEffect 는 
            함수를 return 하면 해당 함수는 컴포넌트가 제거되기 직전에 호출된다.
            componentWillUnmount 의 역할을 대체할 수 있다.
           ❗ 함수를 리턴하는 useEffect 를 호출하려면 컴포넌트를 없애야 한다.
    */
    useEffect(() => {
        
        return () => {
            console.log(`${name} 함수를 리턴하는 useEffect 호출`)
        }        
    }, [name])

    return(
        <div> 
        
        <p>
            안녕하세요. {name}입니다.
        </p>
        <input type="text" onKeyUp={handleKeyUpName} value={name}/>

        <br />

        <p>{num}번 클릭</p>
        <button onClick={handleClickNum}> + </button>
        </div>
    )
}

export default UseEffectTest