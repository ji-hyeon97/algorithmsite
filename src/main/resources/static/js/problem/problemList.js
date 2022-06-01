const pb = document.querySelector("#problems");
const search = document.querySelector("#search_btn");
const additional_search = document.querySelector("#additional_search");
const search_text = document.querySelector("#example-search-input");

search_text.addEventListener('click',()=>{
    additional_search.setAttribute('style','display:block;');
})

document.addEventListener('click',(e)=>{
    if(!e.target.closest('#search_form'))
        additional_search.setAttribute('style','display:none;');
});

search.addEventListener('click',async ()=>{
    pb.innerHTML = "";
    const problem_number = document.querySelector("#example-search-input").value;
    const inputTag = document.querySelector("#inputTag").value+"%20";
    const inputTier = document.querySelector("#inputTier").value+"%20";
    let randomSort = document.querySelector("#randomSort").value;
    let doNotSolve = document.querySelector("#doNotSolve").value;
    if(!document.querySelector("#randomSort").checked)  randomSort = "";
    if(!document.querySelector("#doNotSolve").checked)  doNotSolve = "";
    else                                                doNotSolve = "!%40" + doNotSolve + "%20";

    let solved_problems;
    const boj_id = document.querySelector("#doNotSolve").value;
    let sol_api = `https://solved.ac/api/v3/search/problem?query=${inputTier}${inputTag}`+ `%40` + boj_id + `%20`+ `${problem_number}`;
    if(document.querySelector("#doNotSolve").checked||boj_id===null)    solved_problems = new Set();
    else    solved_problems = await get_solved(sol_api);

    const api = `https://solved.ac/api/v3/search/problem?query=${inputTier}${inputTag}${doNotSolve}${problem_number}${randomSort}`;
    pb.innerHTML += await make_html(solved_problems,api);
    addEvent();
});

window.onload = async ()=>{
    const api_front = "https://solved.ac/api/v3/search/problem?query=";
    const api_back = "&page=1";
    const boj_id = document.querySelector("#doNotSolve").value;

    let solved_problems;
    const sol_api = api_front + "%40" + boj_id + api_back;
    if(boj_id===null)    solved_problems = new Set();
    else                 solved_problems = await get_solved(sol_api);

    pb.innerHTML += await make_html(solved_problems,api_front+api_back);
    addEvent();
};

async function get_solved(api){
    let result = new Set();
    await fetch(api)
        .then((response) => {return response.json()})
        .then((json) => json.items)
        .then((items) => {
            for(let i=0;i<items.length;i++){
                result.add(items[i].problemId);
            }})
    return result;
}

async function make_html(solved, api){
    const html_no_result = "<div style='height: 50px;'></div><div style='text-align: center;font-weight: bold;color: gray'>No Search Result.</div>";
    let result = "";

    await fetch(api)
        .then((response) => {return response.json()})
        .then((json) => json.items)
        .then((items) => {
            if(items.length === 0){
                result = html_no_result;
            }else {
                for(let i=0;i<items.length;i++){

                    let str = `<div class="box problemList"><div>
                       <div class="content container">
                       <div class="row align-col-center">
                       <div class="col-md-1 text-center"><img src="https://d2gd6pc034wcta.cloudfront.net/tier/${items[i].level}.svg" height="20px" width="37px"></div>
                       <div class="col-md-2 problemId"`;

                    if(solved.has(items[i].problemId))  str += `style="color:green;font-weight:bold;"`;

                    str += `>${items[i].problemId}</div>
                    <div class="col-md-8">${items[i].titleKo}</div>
                    <div class="col-md-1 text-center"></div>
                    </div>
                    <div class="row" style="margin-top: 10px;color:#1496DF; font-weight: bold; font-size: 15px">`;

                    for(let j=0;j<items[i].tags.length;j++)
                        str += `#${items[i].tags[j].displayNames[0].name} `;
                    str += `</div></div></div></div>`;

                    result += str;
                }}})
    return result;
}