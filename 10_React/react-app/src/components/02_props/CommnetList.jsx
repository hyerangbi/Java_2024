import React from 'react'
import comment from './Comment'

const comments = [
    {
        id: 1, 
        name: " 치이카와 ",
        comment: "( •̀ ω •́ )✧",
        path: "https://searchad-phinf.pstatic.net/MjAyNDEwMTdfMjkg/MDAxNzI5MTI3MTUyMTgx.I1MwNOl32eNvqy0ostqId__wmTLQkXxofbVTtZoNdxIg.q_gxgJp6PResbJ8b6RnM_BlY2ZwHtkPIBx8NucBGjFEg.JPEG/115613-d850aae2-aa5b-4b7d-ba76-19bec5fb9674.jpeg?type=f160_160"

    },
    {
        id: 2, 
        name: " 하치와레 ",
        comment: "뭔가 이상한거 같은데 ?",
        path: "https://search.pstatic.net/sunny?src=https%3A%2F%2Fi.namu.wiki%2Fi%2FJNKvslt1j4AioYDmWSiZdcJBzwWD2-XibS8JYqMiQcSpF5GSUzYHVdVBsSOPElngPI5CfiAUf0oM3bXXzFr30w.webp&type=fff208_208"

    },
    {
        id: 3, 
        name: " 우사기 ",
        comment: "우나.",
        path: "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyNDAxMDVfMTA4%2FMDAxNzA0NDQ3MDExMDI5.CIkngzcwSuTPyDGh6uD8rPjYgQbKUbcqb00iddqdvQIg.wMHL9dBhHvNIlxxNBalvVHKcxt2dn2R5dx4hdhI2CPog.JPEG.ppk0817%2FIMG_4604.jpg&type=ff332_332"

    }
] // 뭔가 이상한데 ? 

/*
    js에서 
    (배열, 리스트).map(반복 시 실행할 함수)

    map() => 배열의 요소를 전부 사용하여 동일한 길이의 새로운 배열을 리턴
*/

const CommnetList = () => {
    return (
        <div>
            {/* <Comment name={comments[0].name} comment={comment[0].comment} path={comments[0].path}/>
            <Comment name={comments[1].name} comment={comment[1].comment} path={comments[1].path}/>
            <Comment name={comments[2].name} comment={comment[2].comment} path={comments[2].path}/> */}
        {
            comments.map(c => {
                return <Comment key={c.id} name={c.name} comment={c.comment} path={c.path}/>
            })
        }
        
        </div>
    )
}

export default CommnetList;