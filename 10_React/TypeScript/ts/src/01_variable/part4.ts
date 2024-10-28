// any
// 특정 변수의 타입을 확실하게 정할 수 없을 때 사용한다.

let num1: any = 10;
let num2 : number = 20;

num1 = num2; // 타입 안정성이 없다. 

let num3: unknown; 

if (typeof num3 === "number"){ // num3  가 number 일 때에만
    let num4 = num3; // num4 의 값을 넣어라
}

// void -> 함수가 아무것도 반환하지 않을 때 사용한다.
function func01(): string{
    return "하뇽 "; // 문자열 반환
}

function func02(text: string): void{
    console.log(text) // 함수가 아무것도 반환하지 않는다.
}

/*
    ◼ never
      never 은 존재하지 않는 것을 의미한다.
      절대 종료되지 않거나 값을 반환하지 않을 경우 사용한다.
*/

function func03() : never{
    while(true) {

    }
}

function func04(): never{
    throw new Error(); // 오류 발생으로 인해 함수가 종료되지 않는다.
}


let num8: never; 
/* 
    무슨 값을 넣든 에러가 발생한다. 
    그러므로 never 타입 변수에는 어떠한 값도 넣을 수 없다.
*/
