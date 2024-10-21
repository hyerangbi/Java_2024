import React, {useState} from 'react'

/*
     Hook 이란
     함수형 컴포넌트에서 react state 와 생명주기 메소드의 기능을 사용할 수 있게 해주는 함수이다. 
     hook 은 class 안에서 동작하지 않는다. 대신 class 없이 react 를 사용할 수 있게 해준다. 

     ◼ state : 컴포넌트의 상대 값
     ◼ useState : 컴포넌트의 상태를 생성하고 관리할 수 있게 해주는 react hook
    
         → 컴포넌트는 state 값이 변경되면 이를 확인하고 요소를 리렌더링 해준다.

     ◼ const [변수 명, setState변수 명] = useState(초기 값);
       변수 명 : 원하는 state 명을 설정
       set 변수 명 : 해당 state 값을 변경할 함수

*/


const UseStateTest = () => {
    // let num = 0;
    const [num, setNum] = useState(0);

    
    const onClick1 = () => {
        // num += 1 ;
        setNum(num + 1);
        console.log("num : " + num);
    }
    
    const onClick2 = () => {
        // num -= 1;
        setNum(num - 1);
        console.log("num : " + num);
    }

    return (
        <div>
            <span> Count : {num} </span>
            <button> onClick1 = {onclick1} + </button>
            <button> onClick1 = {onclick2} - </button>
        </div>
    )
}

export default UseStateTest