// todoList
let problem_count = localStorage.length;

function addEvent() {
    const problemList = document.querySelectorAll(".problemList");

    for (let i = 0; i < problemList.length; i++) {
        problemList[i].addEventListener('dblclick', () => {
            const div = document.createElement("div");
            div.classList.add("todoList_problem");
            div.append(problemList[i]);
            localStorage.setItem(`todoList${problem_count}`,div.outerHTML);
            problem_count = localStorage.length;;
            todoListLoad();
        });
        problemList[i].addEventListener('mouseover',(e)=>{
            problemList[i].style.background = '#e3f2fd';
        });
        problemList[i].addEventListener('mouseout',(e)=>{
            problemList[i].style.background = '#ffffff';
        });
    }
}

function todoListLoad(){
    if(problem_count !== 0) {
        document.querySelector("#problem_cnt").innerText = `${problem_count}개`;
        const todoListTab = document.querySelector('#todoList');
        let contents = "";
        for (let i = 0; i < problem_count; i++) {
            const result = localStorage.getItem(`todoList${i}`);
            contents += result;
        }
        if(contents !== undefined)
            todoListTab.innerHTML = contents;

        const todoList_problems_id = document.querySelectorAll(".todoList_problem div div div div .problemId");
        const todoList_problems = document.querySelectorAll(".todoList_problem");
        for(let i=0;i<todoList_problems.length;i++){
            todoList_problems[i].addEventListener('dblclick',()=>{
                window.open(`https://www.acmicpc.net/problem/${todoList_problems_id[i].innerText}`,'_blank');
            });
        }
    }
}

// reset btn
const reset = document.querySelector("#reset");

reset.addEventListener('click',()=>{
    localStorage.clear();
    window.location.href = "./problem";
});

// clock
const clockTitle = document.querySelector("#clock");

function getTime(){
    const date = new Date();
    const hours = (date.getHours()<10?'0':'') + date.getHours();
    const minutes = (date.getMinutes()<10?'0':'') + date.getMinutes();
    const seconds = (date.getSeconds()<10?'0':'') + date.getSeconds();
    clockTitle.innerText = `${hours}:${minutes}:${seconds}`;
}

function init(){
    getTime();
    todoListLoad();
    setInterval(getTime,1000);
}

init();