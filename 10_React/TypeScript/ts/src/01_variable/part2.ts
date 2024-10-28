// 배열
let numArr : number[] = [10, 20, 30];

// * 규칙이 없다면 무슨 타입이 들어가는 지 알 수 없다. 그러므로 비슷한(?) 타입끼리 하는게 좋다.

let strArr1: string[] = ["my", "name", "is", "name"];

// 제네릭으로 설정할 수도 있다
let strArr2: Array<string> = ["my", "name", "is", "name"];

// 배열에 들어가는 타입이 두 가지 이상일 경우
let multiArr:(string | number)[] = [10, "name", 20];

// 튜플
let tup1: [boolean, string, number] = [true, "two", 30];

// 객체
// let user = {
//     name: "name",
//     age: 20,
//     address : "경기도 어디시",
// }

// 위의 코드를 아래와 같이 쓸 수 있다.
let user:{
    name: string,
    age: number; // , 를 사용해도 되고, ; 를 사용해도 된다.
    address?: string, 
    // 변수 뒤에 ? 를 적으면 있을 수도 있고,
    // 없을수도 있다 라는 의미 가진 선택적 속성이다.
} = {
    name: "이름",
    age: 20,
    // address: "경기도 어딘가"
}


let math: {
    readonly pi: number; // 읽기만 가능하며, 변경은 불가하다.
} = {
    pi: 3.14
}

// math.pi = 4;