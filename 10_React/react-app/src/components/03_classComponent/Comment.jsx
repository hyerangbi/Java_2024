import PropTypes from 'prop-types'
import React, {Component } from 'react'

/*
    ◼ class Component
      state(필드대체) 를 가지고 있고 이를 수정할 수 있다.
      라이프사이클에 따른 생명주기 메소드를 사용할 수 있다.

    ◼ state 값이 변경 되면 리액트느 변화를 인식하고 그에 맞는 화면을 출력하기 위해 
      component 를 리랜더링한다. 하여 state 값을 변경할 때에는 state 에 어떤 숫자를 넣어서 변경하는 것이 아닌
      this.setState() 함수를 이용해서 새로운 state 값을 넣어주면 된다.

    ◼ react 의 component 라이프사이클은 생성(mount), 업데이터 (Update), 제거 (Unmount) 단계로 나누어
      각 단계마다 componentDidMount, componentDidUpdate, componentWillUnmount 같은 메소드를 사용해
      DOM 을 조작하거나 리소스를 정리할 수 있는 ;^;
*/

const styles = {
    wrapper : {
        margin: 8,
        padding: 8, 
        display: "flex",
        flexDirection: "row",
        border: "1px solid gray",
        borderRadius: 16,
    },
    commnetText:{
        fontSize : 18,
    }
}


class Commnet extends Component {
  construtor(prop){
    super(props)
    // 컴포넌트를 상속 받는다.

    // js 에서는 class 에 필드영역이 없기 때문에
    // 저장하고 싶은 데이터를 state 라는 객체에 key-value 형태로 저장한다.
    // (데이터를 state (필드) 를 만들어서 저장 하는 것이다. )
    this.state = {
        
    }    
  }
    componentDidMount(){
        console.log(`${this.props.id}의 componentDidMount 실행 됨`)
    }

    componentDidUpdate(){
        console.log(`${this.props.id}의 componentDidUpdate 실행 됨`)
    }

    componentWillUnmount(){
        console.log(`${this.props.id}의 componentWillUnmount 실행 됨`)
    }

    render(){
        return (
            <div style={styles.wrapper}> 
                <span style={styles.commnetText}>
                    {this.props.message}
                </span> 
            </div>
        )
    }
}

export default Comment