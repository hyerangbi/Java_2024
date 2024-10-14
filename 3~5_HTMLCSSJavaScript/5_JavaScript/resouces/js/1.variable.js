console.log("Hello Wolrd");

/**
 * js의 변수 선언
 * 
 * 1) var - 사용하지 않는다.
 * 2) let
 * 3) const
 */

var name = "김이름";
var age = 123;
var height = 165.3;
var isTrue = true;

var name = "이하나";
console.log(name + " " + age + " " + height + " " + isTrue)

/**
 * let 은 var에서 같은 이름의 중복생을 하지 못하게 만든 자료형
 * 다만 let과 var는 모두 값을 변경하는 것은 가능하다.
 */

let name1 = "김이름";

name = "한명더";

/**
 * const는 상수를 표현하기 위한 자료형
 * 값을 변경할 수 없다.
 */

const name2 = "김이름";

//name2 = "짜잔";

/**
 * js 네이밍 규칙
 * 
 * 변수이름 지을 때
 * 1) 일반적으로 영어를 사용하며 문자와 숫자 모두 사용할 수 있다.
 * 2) 특수문자는 언더스코어 와 달러 를 사용할 수 있다.
 * 3) 숫자로 시작하면 안 된다.
 * 4) 키워드를 변수 명으로 사용하면 안 된다.
 * 
 * 네이밍 타입
 * 1) camelCase ➡ 대부분의 언어에서 많이 사용하며 단어의 시작마다 대문자로 구분해준다.
 * 2) snake_case ➡ 파이썬에서 주로 사용하며 단어의 시작마다 _로 구분해준다.
 * 3) PascalcCase ➡ C# 및 ms 계열의 언어에서 많이 사용하며 매단어 시작은 무조건 대문자로 한다.
 */

let $name = "김마리"
let _name = "오징어"


/**
 * Data Types
 * 
 * 여섯 개의 원시타입과 한 개의 Object타입이 있다.
 * 
 * 1) Number
 * 2) String
 * 3) Boolean
 * 4) underfined
 * 5) null
 * 6) Symbol
 * 
 * 7) Object
 *    - Function
 *    - Array
 *    - Object
 * ...
 */

// Number 타입
const age2 = 55;
const tampature = -10
const pi = 3.14

// console.log(age2, tempature, pi)
console.log(typeof age2)
console.log(typeof tampature)
console.log(typeof pi)

console.log(typeof Infinity)
console.log(typeof -Infinity)

// String 타입
const name4 = "최지원 66살"
const num1 = 55
console.log(num1 == "55")
console.log(num1 === "55")

console.log("안녕하세요 저는 최지원입니다. \n \t 나이는 51살 입니다.")

// Boolean 타입
const isTrue2 = true;
const isFalse = false;
console.log(typeof isTrue2)
console.log(typeof isFalse)

/**
 * underfined
 * 
 * 개발자가 직접 값을 초기화 하지 않았을 때
 * 지정되는 값이다.
 * 
 * underfined를 직접 넣어주는 것은 지양해야한다.
 */

let num2;
console.log(num2 === undefined);

/**
 * null 타입
 * underfined와 동일하기 값이 없음을 표시
 * 다만 js에서는 개발자가 직접 명시적으로 없는 값을 초기화할 때 사용
 */

let init = null;
console.log(null);

if(!init){
    console.log("null이 아니다.")
}

/**
 * Symbol 타입
 * 
 * 유잉ㄹ무이한 값을 생성할 때
 * 다른 원시 값들과 다르게 Symbol함수를 호출해서 사용한다.
 */

const tmp1 = '1';
const tmp2 = '1';
console.log(tmp1 === tmp2)

const symbol1 = Symbol('1');
const symbol2 = Symbol('1');
console.log(symbol1, symbol2)
console.log(symbol1 === symbol2)

/**
 * Object타입
 * 
 * 키 : 벨류 쌍으로 이루어져 있다.
 * key : value
 */

const man = {
    name : "최지원",
    age : 47,
    address : "경기도",
    value : "강사",
    printInfo : function(){
        console.log(this.name + "입니다.")
        return 10;
    }
}

 man.value = "무직";
 let func1 = man.printInfo();
 let func2 = man.printInfo;
 let value2= func2();

console.log(typeof man);

/**
 * Array 타입
 * 
 * 값을 리스트로 나열할 수 있는 타입
 */

const arr = [];
arr.push("빨간색");
arr.push("파란색");
arr.push("하얀색");
arr.pop();
console.log(arr.pop());
console.log(arr[0], arr[1])


