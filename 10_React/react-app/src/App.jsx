import logo from './logo.svg';
import './App.css';
import Menu from './components/01_component/Food';
import Comment from './components/02_props/Comment';
import Commnet from './components/03_classComponent/Comment';
import CommnetList from './components/03_classComponent/CommentList'
import UseStateTest from './components/04_hook/useState/UseStateTest';
import SignUp from './components/04_hook/useState/SignUp';
import Toolbar from './components/04_hook/useState/Toolbar';
import LandingPage from './components/04_hook/useState/LandingPage';
import UseEffectTest from './components/04_hook/UseEffect/UseEffectTest';
import { useState } from 'react';
import UseRefTest from './components/04_hook/UseRef/useRefTest';

function App() {
  const [isComponent, setIsComponent] = useState(true)
  return (
    <div className='App'>
      {/* <Menu /> */}
      {/* <Comment /> */}
      {/* <CommentList /> */}
      {/* <Comment /> */}
      {/* <CommnetList /> */}
      {/* <UseStateTest /> */}
      {/* <SignUp /> */}
      {/* <Toolbar /> */}
      {/* <LandingPage /> */}
      {/* {isComponent ? <UseEffectTest /> : <span> 사라짐 </span>}
        setTimeout(() => {
          setIsComponent(false)
        }, 3000) 
      }*/}
      <UseRefTest />
    </div>
  );
}

export default App;
