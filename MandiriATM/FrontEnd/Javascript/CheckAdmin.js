const pass = document.getElementById("pass");
const btn = document.getElementById("accesso");

btn.onclick = () => {

if(pass.value=="1234"){
    window.location.href = "AdminHomePage.html";
}else{
    window.location.href = "BlockSystem.html";
}
}