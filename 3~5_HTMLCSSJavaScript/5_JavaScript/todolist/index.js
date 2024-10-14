let todoList = localStorage.getItem("todoList") ?
                JSON.parse(localStorage.getItem("todoList")) : [];

//JSON.Stringify(객체 | 배열) -> 객체, 배열을 string으로 변환
//JSON.parse(변환된문자열) -> 원래의 객체, 배열로 변경

//localStorge.setItem("키", "벨류") -> localStorge 영역에 key, value 형태로 데이터 저장
//localStorge.getItem("키") -> localstorge 영역에 데이터를 key로 불러오는 것

// 할일을 todoList에 넣기
function addTodo(){
    // input 요소 가져오기
    const searchINput = document.querySelector("#search-bar input");
    todoList.push({
        title :searchINput.value,
        date : new Date().getTime(),
        isDone : false
    });
    localStorage.setItem('todoList',JSON.stringify(todoList));

    searchINput.value = "";
    drawTodoList();
}

// 할일목록을 ui에 나타내기
function drawTodoList(){
    const removeTodo = function(removeTodo){
        todoList = todoList.filter(t => !(t.date === removeTodo.date && removeTodo.title === t.title))
        localStorage.setItem('todoList', JSON.stringify(todoList));
        drawTodoList();
    }
    const toggleStatus = function(targetTodo){
        todoList = todoList.map(function(t){
            if(t.date === targetTodo.date && t.title === t.targetTodo.title){
                t.isDone = !t.isDone;
            }
            return t;
        })
        localStorage.setItem('todoList', JSON.stringify(todoList));
        drawTodoList();
    }
    const todoUl = document.querySelector(".todo-list");
    todoUl.innerHTML = "";

    for(let todo of todoList){
        const todoLi = document.createElement('li') //<li></li>
        todoLi.innerText = todo.title; //<li></li>
        todoLi.className = todo.isDone ? 'done' : '';
        todoUl.appendChild(todoLi);
        
        todoLi.onclick = function(){
            toggleStatus(todo);
        }

        const removeBtn = document.createElement('div');
        removeBtn.className = 'todo-remove-btn';
        removeBtn.innerHTML = '<i class="fa-solid fa-xmark"></i>';
        todoLi.appendChild(removeBtn);

        removeBtn.onclick = function(){
            removeTodo(todo)
        }  
    }

    
}


/* 
function addTodo(){
    //todo-list 영역에
    // { <li>
    //     냠냠
    //     <div class="todo-remove-btn">
    //         <i class="fa-solid fa-xmark"></i>
    //     </div>          
    // </li> }

    const searchInput = document.querySelector("#search-bar input")

    const todoLi = document.createElement('li') //<li></li>
    todoLi.innerText = searchInput.value; //<li></li>
    

    const removeBtn = document.createElement('div');
    removeBtn.className = 'todo-remove-btn';
    removeBtn.innerHTML = '<i class="fa-solid fa-xmark"></i>';
    todoLi.appendChild(removeBtn);

    removeBtn.onclick = function(){
        $(this.parentNode).remove();
    }

    const todoUl = document.querySelector(".todo-list");
    todoUl.appendChild(todoLi);
    
} */