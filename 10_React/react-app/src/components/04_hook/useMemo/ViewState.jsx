import React, { useMemo } from 'react'

const getNumber = (num) => {
    console.log("숫자가 변경되었다.")
    return num;
}

const getText = (text) => {
    console.log("문자가 변경되었다.")
    return text;
}

const ViewState = ({num, text}) => {

    // const viewNum = getNumber(num);
    // const viewText = getText(text);

    const viewNum = useMemo(() => getNumber(num), [num]) 
    // 값이 변하지 않는 이상 계속 사용하겠다.
    const viewText = useMemo(() => getText(text), [text])

    // useMemo 의 기능 : 값을 기억해 두었다가 사용하는 것
    // 성능을 올려줄 때 사용한다.
    
    return (
        <div>
            {viewNum}
              <br />
            {viewText}
        </div>
    )
}

export default ViewState