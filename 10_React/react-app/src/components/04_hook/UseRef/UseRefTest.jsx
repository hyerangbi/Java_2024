import React,{useRef, useState} from 'react'

/*
    ☁ useRef ( •̀ ω •́ )✧
     useRef 는 React 에서 DOM 요소에 직접 접근하거나 컴포넌트 렌더링 간 상태 변화 없이
     값을 저장하는데 사용된다.
     state 와 다르게 변경되어도 컴포넌트가 리렌더링 되지 않고
     초기화 되지 않고 참조 값을 유지한다. 주로 DOM 요소 포커스나 스크롤 위치를 추천하거나
     또는 이전 값을 기억하는데 유용하다.
*/

const UseRefTest = () => {
    const [name, setName] = useState("");
    // const [beforeName, setBeforName] =useState("");
    const [gender, setGender] = useState("");

    const beforeName = useRef("");
    const useInput = useRef(null);

    const handleChangeName = (ev) => {
        // setBeforName(name)
        beforeName.current = name;
        setName(ev.target.value);
    }

    const handleChangeGender = (ev) => {
        setGender(ev.target.value);
    }

    const handleSubmit = (ev) => {
        alert(`이름 : ${name}, 성별 : ${gender}`);
        ev.preventDefault(); // 이 명령어 이후로 이벤트를 실행하지 마라 (이벤트 요청 취소)
    }

    const handleReset = (ev) => {
        setName("")
        setGender("man")
        useInput.current.focus();
    }
    
    return(
        <form onSubmit={handleSubmit}>
            <label>
                이름 :
                <input 
                    type="text" 
                    value={name} 
                    onChange={handleChangeName}
                    ref={useInput}                    
                    /*
                        원래 이 안에 함수를 사용했었따 ? 인가 ?
                        ref={(el) => useInput = el}
                    */
                />
            </label>
            <label>
                이전 이름 : {beforeName.current}
            </label>
            <br /><br />
            <label>
                성별 :
                <select value={gender} onChange={handleChangeGender}>
                    <option value="man"> 남자 </option>
                    <option value="woman"> 여자 </option>
                </select>
            </label>
            <br /><br />
            <button type='submit'> 제출 </button>

            <button type='button' onClick={handleReset}> 초기화 </button>
        </form>
    )
}

export default UseRefTest