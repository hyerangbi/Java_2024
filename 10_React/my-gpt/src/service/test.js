// const testAPI = (data, callback) => {
//     setTimeout(() => { // 비동기 실행
//         callback("안녕 ! ヾ(•ω•`)o")
//     }, 2000)
// }

import { resolve } from "path";

// testAPI({prompt: "안녕"}, (response)=>{
//     console.log(response);
// });

/*
    function ajax(requestJson){
        let xhr = new XMLHttpRequest();

        requestJson.method = requestJson.method ? requestJson.method : "GET";

        xhr.open(requestJson.method, requestJson.url, true);

        // 응답이 왔을 때 실행하는 이벤트 핸들러
        xhr.onreadystatechange = function(){
            if(xhr.readyState === XMLHttpRequest.DONE){
                if(xhr.status === 200){
                 let result = JSON.parse(xht.responseText)
                 requestJson.success(result)
                } else{
                    requesetJson.error(xht.status)
                }
            }
        }
    }
*/


const getPromise = function(seconds){
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("완료")
        }, seconds * 1000)
    })
}

getPromise(2).then((res) => {
    console.log(res) // 완료
    console.log("도착") 
})

// async 키워드가 선언된 함수에서는 await 를 사용할 수 있다
// await 키워드를 사용하면 비동기통신을 마치 동기코드처럼 사용할 수 있다.
const runner = async () => {
    const res1 = await getPromise(1); // getpromise 가 리턴이 될 때 까지 기다린다.
    // resolve 의 결과를 밑에 담아준다.
    console.log(res1)

}

// const TestAPI2 = new Promise((resolve, reject) => {
//     setTimeout(() => { // 비동기 실행
//         resolve("안녕 !")

//         // 실패 시 reject();
//     }, 2000);
// })

// TestAPI2().then((res) => {
//     console.log(res) // 성공 했을 땐 then , 
// }).catch(() => { // 실패 했을 땐 catch 로 들어온다.

// })