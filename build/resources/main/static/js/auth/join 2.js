const login_btn = document.querySelector("#login-btn");

const input_username = document.querySelector("#username").value;
const input_boj_username = document.querySelector("#boj_username").value;
const input_password = document.querySelector("#password").value;
const input_sno = document.querySelector("#sno").value;

login_btn.addEventListener('click',()=>{
    fetch("/auth/loginProc",{
        method:'POST', headers:{'content-type':'application/json'},
        body:JSON.stringify({username: input_username, password: input_password,
            boj_username: input_boj_username, sno: input_sno})})
        .then(response =>{
            try{
                const result = response.json();
                return result;
            }catch (error){
                alert("회원가입에 실패했습니다.");
                return false;
            }})
        .then(data=>{
            alert("회원가입 완료");
            console.log(data);
            location.href="/auth/login";
        })
});