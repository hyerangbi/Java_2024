import React, {useRef} from 'react'

const useRefScroll = () => {
        const scrollRef = useRef([]);

        const handleScrollView = (event) => {
            const name = event.target.innerText;

            const pages = {
                " 메인 페이지 " : 0,
                " 회사 소개 " : 1,
                " 회사 이력 " : 2,
            }

            scrollRef.current[pages[name]].scrollIntoView({beghavior: "smooth"})
        }
    return (
        <>
            <div>
                <ul>
                    <li onClick={handleScrollView}> 메인 페이지</li>
                    <li onClick={handleScrollView}> 회사 소개 </li>
                    <li onClick={handleScrollView}> 회사 이력 </li>
                </ul>
            </div>
            <div>
                <div ref={el => scrollRef.current[0] = el}>
                    <h1> 메인 페이지 - 엥 ? </h1>
                    <p>
                        배고프다 뭐 먹지 비빔밥 저기 겁나 먼데요 ?
                    </p>
                </div>
                <div ref={el => scrollRef.current[1] = el}>
                    <h1> 회사 소개 </h1>
                    <p>
                        파스타 저기도 먼 거 같았는데 ? 
                    </p>
                </div>
                <div ref={el => scrollRef.current[2] = el}>
                    <h1> 회사 이력 </h1>
                    <p>
                        배고파 ;^;
                    </p>
                </div>
            </div>
        </>
    )
}