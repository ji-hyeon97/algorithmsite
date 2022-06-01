const sel_btn = document.querySelector("#sel-btn");

// 문제 리스트
let pb_List = [];

function isRandom(){
    const sel_isRandom = document.querySelector("#sel-isRandom");
    const search_name = document.querySelector("#search-name");
    const search_number = document.querySelector("#search-number");

    if(sel_isRandom.value !== ""){
        search_name.readOnly = true;
        search_number.readOnly = true;
    }else{
        search_name.readOnly = false;
        search_number.readOnly = false;
    }

}

// pb_List 추가하기
function addPb_List(){
    const select_problem_box = document.querySelector("#select-problem-box");

    select_problem_box.innerHTML = '';
    for(let i=0;i<pb_List.length;i++){
        select_problem_box.innerHTML += pb_List[i];
    }
}

// problemList mouseover, out EventListener
function addEvent() {
    const problemList = document.querySelectorAll(".problemList");

    for (let i = 0; i < problemList.length; i++) {
        problemList[i].addEventListener('dblclick', (e)=>{
            const tier = problemList[i].childNodes[1].childNodes[0].childNodes[1].childNodes[1].childNodes[1].childNodes[0].src;
            const name = problemList[i].childNodes[1].childNodes[0].childNodes[1].childNodes[1].childNodes[3].childNodes[0].data;
            const number = problemList[i].childNodes[1].childNodes[0].childNodes[1].childNodes[1].childNodes[5].childNodes[0].data;;

            const object = `<tr>
                    <td><img src="${tier}" height="20px" width="37px"></td>
                    <td>${name}</td>
                    <td>${number}</td>
                </tr>`;
            pb_List.push(object);
            addPb_List();
        });

        problemList[i].addEventListener('mouseover',(e)=>{
            problemList[i].style.background = '#e3f2fd';
        });
        problemList[i].addEventListener('mouseout',(e)=>{
            problemList[i].style.background = '#ffffff';
        });
    }
}

sel_btn.addEventListener('click',()=>{
    const sel_algorithm = document.querySelector("#sel-algorithm").value;
    const sel_tier = document.querySelector("#sel-tier").value;
    const sel_isRandom = document.querySelector("#sel-isRandom").value;
    const search_name = document.querySelector("#search-name").value;
    const search_number = document.querySelector("#search-number").value;//"%26id%3A"+

    let search = search_name + search_number;
    if(search_name !== '' && search_number !== ''){
        search = search_name + "%26id%3A" + search_number;
    }

    const pb = document.querySelector("#problems");
    pb.innerHTML = "";

    fetch(`https://solved.ac/api/v3/search/problem?query=${search}${sel_algorithm}${sel_tier}${sel_isRandom}`)
        .then((response) => {return response.json()})
        .then((json) => json.items)
        .then((items) => {
            if (items.length === 0) {
                pb.innerHTML = "<div style='height: 50px;'></div><div style='text-align: center;font-weight: bold;color: gray'>No Search Result.</div>";
            } else {
                for (let i = 0; i < items.length; i++) {
                    let str = `
                    <div class="row problemList" style="margin:0 auto; width: 700px;height: 65px; background-color: white;box-shadow: 0px 10px 20px rgb(0 0 0 / 20%);border-radius: 10px; padding:5px;">
                    <div class="box"><div>
                        <div class="content container">
                            <div class="row align-col-center">
                                <div class="col-md-1 text-center"><img src="https://d2gd6pc034wcta.cloudfront.net/tier/${items[i].level}.svg" height="20px" width="37px"></div>
                                <div class="col-md-2 problemId">${items[i].problemId}</div>
                                <div class="col-md-8">${items[i].titleKo}</div>
                                <div class="col-md-1 text-center"></div>
                            </div>
                            <div class="row" style="margin-top: 10px; color:#1496DF; font-weight: bold; font-size: 15px">`
                    for (let j = 0; j < items[i].tags.length; j++)
                        str += `#${items[i].tags[j].displayNames[0].name} `;
                    str += `</div></div></div></div></div><div style="height: 30px;"></div>`;
                    pb.innerHTML += str;
                }
            }})
        .then(()=>{addEvent()});
});