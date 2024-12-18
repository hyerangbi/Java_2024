let members = [
    "최지원",
    "김지원",
    "이지원",
    "박지원",
    "남중지원"
]

// push
console.log(members.push("신지원")) // 값을 미리 넣고 길이 반환
console.log(members)

// splice(인덱스, 갯수) -> 원본에 영향을 준다
// console.log(members.splice(1,3)) //1번째 배열로 부터 3개를 가져온다
// console.log(members) // splice로 인해 남겨진 배열들

// slice(인덱스, 마지막 인덱스-1) -> 원본에 영향을 주지 않는다.
console.log(members.slice(1,5))
console.log(members)

members = [
    "최지원",
    "김지원",
    "이지원",
    "박지원",
    "남중지원"
]

let member2 = [
    ...members
]

let choi = {
    name : "jiwon",
    age : 21 ,
    gender : "남"
}

choi = {
    ...choi,
    age : 20
}

/* let choi2 = [
    ...choi
] */

// console.log(choi2)

console.log("---------------------------------------------------")

// join() -> 배열을 문자열로 변경해준다.
console.log(member2.join())
console.log(member2.join('/'))
console.log(member2.join(' '))

// sort
member2.sort();
console.log(member2)
console.log(member2.reverse())

let numbers = [1, 9, 7, 5, 3]
console.log(numbers);

// a, b를 비교한다
// 1) a를 b보다 나중에 정렬 하고싶다면 (뒤에 두고 싶다면) 0보다 큰 수를 반환
// 2) a를 b보다 먼저 정렬하려면 (앞에 두려면) 0보다 작은 숫자를 반환
// 3) 원래 순서를 유지하고 싶다면 0을 반환
numbers.sort((a,b)=> {
    // return a > b ? 1 : -1; //오름차순정렬
    return a < b ? 1 : -1; // 내림차순 정렬
});
console.log("---------------------------------------------");

// map
// 기존배열의 요소를전부 반복하면서
// return 된 값으로 새로운 배열을 만들어주는 함수
// 기존의 배열을 이용해 새로운 배열을 만들어준다.
// let tmpMember = member2.map(function(m, i){return m;}) // [0,1,2,3,4]

let userList = [
    {
        userKey : 1,
        userName : "최지원", 
        age : 22,
    },
    {
        userKey : 2,
        userName : "김수민", 
        age : 47,
    },
    {
        userKey : 3,
        userName : "박지수", 
        age : 35,
    }
]
let buyHisory = [
    {
        userKey : 2,
        productName : "TV",
        price : 50000
    },
    {
        userKey : 2,
        productName : "모니터",
        price : 20000
    },
    {
        userKey : 1,
        productName : "컴퓨터",
        price : 150000
    },
    {
        userKey : 3,
        productName : "냉장고",
        price : 10000
    },
    {
        userKey : 1,
        productName : "가습기",
        price : 7500
    },
]

buyHisory = buyHisory.map(history => {
    for(let user of userList){
        if (user.userKey === history.userKey ){
            return {
                ...user,
                ...history
            }
        }
    }
})

buyHisory = buyHisory.map((h,i) =>{
    return {
        ...h,
        index : i + 1,
    }
})

console.log(buyHisory)

console.log("------------------------------------------------")

// filter
// return 값이 flase요소를 제거하고 true 인 요소만 가져올 때

let number2 = [1, 6, 7, 9, 10, 21];
let tmp2 = [];

// for (let n of number2){
//     if(n%2 === 0){
//         tmp2.push(n);
//     }
// }

tmp2 = number2.filter(n => n % 2 === 0);
console.log(tmp2)

// 내가 삭제하고자 하는 게 userKey === 2 인것

buyHisory = buyHisory.filter(h=> h.userKey !== 2)
console.log(buyHisory)

// find()
// return 되는 조건에 값이 true인 첫 요소를 반환
// 모든 요소가 조건에 부합하지 않는다면 (false 를 리턴한다면) undefinde를 반환
console.log(tmp2.find(function(n){
    return n%2 === 0;
}));

// find()
// return 되는 조건에 값이 true인 첫 요소를 반환
// 모든 요소가 조건에 부합하지 않는다면 (false 를 리턴한다면) -1을 반환
console.log(tmp2.findIndex(function(n){
    return n%2 === 1;
}));