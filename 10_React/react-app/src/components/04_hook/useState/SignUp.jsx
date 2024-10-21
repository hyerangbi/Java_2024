import React from 'react'

// 제출버튼 클릭 시 alert 을 이용하여 이름과 성별을 보여주는 팝업을 나타나게 하자.
const SignUp = () => {
    // let name = "", gender = "";  // 이걸 사용하면 value 에선 메소드 이름으로 지정된 상태로 된다.
    const [name, setName] = useState("");
    const [gender, setGender] = useState("");

    const handleChangeName = (ev) => {
        setName(ev.target.value);
    }

    const handleChangeGender = (ev) => {
        setGender(ev.target.value);
    }

    const handleSubmit = (ev) => {
        alert(`이름 : ${name}, 성별 : ${gender}`);
        ev.preventDefault(); // 이 명령어 이후로 이벤트를 실행하지 마라 (이벤트 요청 취소)
    }
    
    return(
        <form onSubmit={handleSubmit}>
            <label>
                이름 :
                <input type="text" value={name} onChange={handleChangeName}/>
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
        </form>
    )
}

export default SignUp