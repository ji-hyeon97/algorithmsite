const pb = document.querySelector("#problems");
window.onload = async ()=>{

    let solvedNum = await getSolvedNum();

    pb.innerHTML = await make_html(problems,solvedNum);
    addEvent();
};

setInterval(leftTime,1000);
function leftTime(){
    const now = new Date();
    const st = new Date(contest.startTime);
    const et = new Date(contest.endTime);
    if(now.getTime()<st.getTime()){
        let lt = st.getTime() - now.getTime();
        lt /= 1000;
        const seconds = parseInt(lt%60);
        const minutes = parseInt(lt/60) % 60;
        const hours = parseInt(lt/3600) % 24;
        const days = parseInt(lt/3600/24);
        left_time.innerText = `시작까지 ${days}일 ${hours<10 ? '0'+hours : hours}시간 ${minutes<10 ? '0'+minutes : minutes}분 ${seconds<10 ? '0'+seconds : seconds}초`;
        pb.setAttribute('style','display:none;');
    }
    else if(now.getTime()<et.getTime()){
        let lt = et.getTime() - now.getTime();
        lt /= 1000;
        const seconds = parseInt(lt%60);
        const minutes = parseInt(lt/60) % 60;
        const hours = parseInt(lt/3600) % 24;
        const days = parseInt(lt/3600/24);
        left_time.innerText = `종료까지 ${days}일 ${hours<10 ? '0'+hours : hours}시간 ${minutes<10 ? '0'+minutes : minutes}분 ${seconds<10 ? '0'+seconds : seconds}초`;
        pb.setAttribute('style','display:block;');
    }
    else{
        pb.setAttribute('style','display:block;');
         left_time.innerText =`종료`;
    }
}


async function make_html(items,solvedNum){
    let result ="";

    for(let i=0;i<items.length;i++){

                        let str = `<div class="box problemList" ><div>
                           <div class="content container">
                           <div class="row align-col-center">
                           <div class="col-md-1 text-center"><img src="https://d2gd6pc034wcta.cloudfront.net/tier/${items[i].level}.svg" height="25px" width="47px"></div>
                           <div class="col-md-2 problemId">${items[i].problem_number}</div>
                        <div class="col-md-7">${items[i].problem_name}</div>
                        <div class="col-md-2"><ion-icon name="people-outline"></ion-icon>&nbsp;${solvedNum[i]}</div>
                        </div>
                        </div></div></div>`;

                        result += str;
    }
    return result;
}

function addEvent() {
    const problemList = document.querySelectorAll(".problemList");
    for(let i=0;i<problemList.length;i++){
        problemList[i].addEventListener('dblclick', () => {
            window.open(`https://www.acmicpc.net/problem/${problems[i].problem_number}`,'_blank');
        });
        problemList[i].addEventListener('mouseover',(e)=>{
            problemList[i].style.background = '#e3f2fd';
        });
        problemList[i].addEventListener('mouseout',(e)=>{
            problemList[i].style.background = '#ffffff';
        });
    }
}

async function getSolvedNum(){
    let result = new Array();
    for(let j = 0; j<problems.length;j++){   result.push(0);}
    for(let i=0;i<bojs.length;i++){
        await fetch("https://solved.ac/api/v3/search/problem?query="+`%40` + bojs[i])
                    .then((response) => {return response.json()})
                    .then((json) => json.items)
                    .then((items) => {
                        for(let i=0;i<items.length;i++){
                            for(let j = 0; j<problems.length;j++){
                                if(problems[j].problem_number===items[i].problemId){ result[j]++;}
                            }
                        }});
    }
    return result;
}