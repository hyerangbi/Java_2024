import React, { Component } from 'react'

const serverCommnets =[
    {
        id: 1,
        message : "안녕하세요"
    },

    {
        id: 1,
        message : "안녕하세요"
    },

    {
        id: 1,
        message : "안녕하세요"
    }
]

class CommentList extends Component{
    constructor(props) {
        super(props)

        this.state = {
            commentList: [],
        }
    }

    componentDidMount(){
        // const commentList = this. state.commentList
        // 위 아래 같은 코드이다
        // 위 와 같은 코드를 사용하면 여러 개 변수르 만들어야한다. 
        const { commentList }= this.state; // 비구조할당
        // 중괄호 안에 있는 애가 변수로 들어간다.
        // 하지만 {} 를 사용한 것은 {} 안에 변수만 넣고, 새로 생성하지 않아도 된다.
        // ( 밑으로 쭈르륵 나열 할 필요 없이, {} 안에 변수 이름만 넣으면 된다.)

        // state 는 절대 수정하면 안된다. 왜냐하면 절대 수정되지 않기 때문이다. ( 으음 ? )
        
        /*
            state 주소를 바꾸려면 
            다른 값으로 덮어 씌운다 
            ex_ state = {age : 100}
        */

        // setInterval : 일정시간마다 특정 함수를 반복해서 실행
       setInterval(() => {
            if(commentList.length < serverCommnets.length){ // 3초가 지나면 다시 실행
                //더미데이터 길이만금 state 내의 데이터가 추가되면 그만하기 위한 조건
                const index = commentList.length; // 0 1 2
                commentList.push(serverCommnets[index]); 
                // serverComment의 값 0번째가 추가된다 
                // 객체 형태로 되어 있어서 인식하지 못한다.
                this.setState({
                    commentList : commentList 
                                // : 부터 생략 가능 어차피 똑같다. 'ㅁ'
                                // 
                    
                })
            } else{
                this.setState({
                    commentList : [] // 빈칸으로 만든다 (다 비움)
                })
            }
       }, 3000);
    }
    
    render(){ // 
        return (
            <div>
                {
                    this.state.commentList.map(c => {
                        return (
                            <Comment key={c.id}
                                     id={c.id}
                                     message={c.message}
                            />
                        )
                    })
                }
            </div>
        )
    }
}

export default ComponentList