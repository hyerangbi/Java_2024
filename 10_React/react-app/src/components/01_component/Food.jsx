// jsx : 리액트에서 사용하는 기본적인 문법체계
//       자바스크립트와 HTML을 함께 사용한다.
//       HTML을 사용하던 중 스크립트를 사용하고 싶을 때는 {} 를 통해서 사용하면 된다. ( <%%> 와 동일하다고 생각하면 된다. _

// react 는 모두 컴포넌트로 되어있따.
// 함수형을 많이 사용한다.  


// Component : 하나의 함수형 컴포넌트는 무조건 하나의 태그를 리턴한다.
//             재사용할 수 있는  가장 작은 단위의 Element 이다 .

// react 에서 함수는 무조건 첫글자는 대문자로 해야한다.
// 그 이유는 컴포넌트 라는 것을 알아보기 위해서 이다.
// 왜냐하면 모두 다 컴포넌트로 이루어져있기 때문이다. (음 ? 먼가 문장이 이상한데)

// react 에서는 function 보다는 화살표를 더 많이 사용한다.
// react 에서넌 this 를 많이 사용하지 않는다. 
// this 를 안 만든다는 것은 spoce를 만들어지면서 가리키는 것인데  
// 그 메모리를 하나 만들 때마다 사라진다. 
// 화살표 함수가 일반 함수에 비해서 많이 가볍다

/*
    태그 하나만 return 가능하다.
*/

// props : 부모컴포넌트에서 자식컴포넌트에 데이터를 전달하는 방식
//         컴퓨넌트의 속성 = 값 으로 전달할 수 있다.
//         props 가 변하면 자식요소는 리렌더링을 한다.

const Food = (props) => {

    return (
        <div>
            <h1> 이 음식의 이름은 {props.name} 입니다. </h1>
            <h1> 이 음식은 1인분에 {props.price} 원 입니다. </h1>
        </div>
    )
}

export default Food; 
// export default : 하나의 파일에서 단일 항목만 기본으로 내보내고 싶을 때 
//              -> 모듈에 특정 함수나 변수를 등록하는 명령어 라고 생각하면 된다.
//              -> 모듈에 등록하면 import를 통해서 어디서든 가져와 사용할 수 있다.