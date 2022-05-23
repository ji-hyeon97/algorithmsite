const valid_btn = document.querySelector("#valid-btn");

valid_btn.addEventListener('click',()=>{
   const username = document.querySelector("#boj_username").value;
   const valid = document.querySelector("#valid-boj");

   fetch(`https://solved.ac/api/v3/user/show?handle=${username}`)
       .then(()=>{
           return fetch(`/auth/valid_boj?id=${username}`);
       })
       .then((response) => {return response.json()})
       .then((json) => {
           if(json.data === false){ // 생성가능
               valid.innerText = "사용할 수 있는 아이디입니다.";
               valid.style.color = "#4caf50";
           }
       })
       .catch(()=>{
         valid.innerText = "존재하지 않는 아이디입니다.";
          valid.style.color="#e53935";
          setTimeout(()=>{
            valid.innerText="";
            },4000);
       });
});