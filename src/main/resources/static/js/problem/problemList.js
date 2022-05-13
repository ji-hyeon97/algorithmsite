const pb = document.querySelector("#problems");
const search = document.querySelector("#search_btn");

search.addEventListener('click',()=>{
    pb.innerHTML = "";
    const problem_number = document.querySelector("#example-search-input").value;
    fetch(`https://solved.ac/api/v3/search/problem?query=${problem_number}`)
        .then((response) => {return response.json()})
        .then((json) => json.items)
        .then((items) => {
    if(items.length === 0){
        pb.innerHTML = "<div style='height: 50px;'></div><div style='text-align: center;font-weight: bold;color: gray'>No Search Result.</div>";
    }else {
    for (let i = 0; i < items.length; i++) {
        let str = `
                    <div class="box problemList"><div>
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
            str += `</div></div></div></div>`;
            pb.innerHTML += str;
        }
    }
    addEvent();
})
});



window.onload(
    fetch("https://solved.ac/api/v3/search/problem?query=&page=1")
    .then((response) => {return response.json()})
    .then((json) => json.items)
    .then((items) => {
    for(let i=0;i<items.length;i++){
        let str = `
                    <div class="box problemList"><div>
                        <div class="content container">
                            <div class="row align-col-center">
                                <div class="col-md-1 text-center"><img src="https://d2gd6pc034wcta.cloudfront.net/tier/${items[i].level}.svg" height="20px" width="37px"></div>
                                <div class="col-md-2 problemId">${items[i].problemId}</div>
                                <div class="col-md-8">${items[i].titleKo}</div>
                                <div class="col-md-1 text-center"></div>
                            </div>
                            <div class="row" style="margin-top: 10px;color:#1496DF; font-weight: bold; font-size: 15px">`
        for(let j=0;j<items[i].tags.length;j++)
            str += `#${items[i].tags[j].displayNames[0].name} `;
        str += `</div></div></div></div>`;
        pb.innerHTML += str;
    }
    addEvent();
}));