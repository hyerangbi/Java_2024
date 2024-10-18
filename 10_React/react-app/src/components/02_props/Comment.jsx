import React from "react"

// div 태그를 사용하는 것이 아닌 컴포넌트를 사용하는 중이다.

const styles = {
    wrapper : {
        margin: 8,
        padding: 8, 
        display: "flex",
        flexDirection: "row",
        border: "1px solid gray",
        borderRadius: 16,
    },
    image: {
        width: 50,
        height: 50, 
        borderRadius: 25,
    },
    contentContainer: {
        marginLeft: 8,
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        fontSize: 16,
        alignItems: "flex-start",
        color: "blank", 
    },
    nameText:{              
        fontWright: "bold",
    }
}

function Comment(){
    return(
        <div style={styles.wrapper}>
            <div>
                <img src="https://cdn.pixabay.com/photo/2023/09/13/07/29/ghost-8250317_640.png" 
                     alt="프로필 이미지" 
                     style={styles.image}/>
            </div>
            <div style={styles.contentContainer}>
                <span style={styles.nameText}>{props.name}</span>
                <span>{props.comment}</span>
            </div>
        </div>
    )
}

export default Comment;