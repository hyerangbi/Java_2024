import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Routes, Route, Link} from 'react-router-dom';
import Home from './pages/Home';
import Products from './components/05_styleComponents/Products'
import Page1 from './pages/Page1';
import Page2 from './pages/Page2';

/*
  ☁ react-router-dom
     react 로 생성된 SPA 내부에서 
    페이지 이동이 가능하도록 만들어주는 라이브러리

  ☁ BrowserRouter
    history 객체를 생성하여 사용한다. 
    라우팅을 진행할 컴포넌트 상위에 BrowserRouter 컴포넌트를 생성하고 감싸주어야한다.

  ☁ Routes
    모든 Route 의 상위 경로에 존재해야하며, location 변경 시 하위에 있는 모든 Route 중에
    현재 location 에 맞는 Route를 찾아준다.
  
  ☁ Route 
    현재 브라우저의 location(window.href.location 정보를 가져온다.)
    ⇒ 상태에 따라서 매칭되는 element 를 렌더링한다.
    단일 태그로 사용하여도 된다.
    Route 로 들어오면 Home 으로 렌더링한다. 
*/

function App() {
  return (
    <BrowserRouter>
      <div className='App'>
        <nav>
            <ul>
              <li><Link to="/"> HOME </Link></li>
              <li><Link to="/p1"> Page1 로 이동 </Link></li>
              <li><Link to="/p2"> Page2 로 이동 </Link></li>
            </ul>
        </nav>

        <Routes>
          <Route path="/" element={<Products />} />
          <Route path="/p1" element={<Page1 />} />
          <Route path="/p2" element={<Page2 />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
