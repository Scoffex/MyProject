let playerChoose = "";
let botChoose = "";
let botScore = 0;
let playerScore = 0;
const stampa = document.getElementById("stampa");
const stampaPB = document.getElementById("stampaPB");
const elem = document.querySelectorAll(".square");
const restart = document.getElementById("restart");
const arr = ["ROCK", "PAPER", "SCISSOR"];
const arrImg = ["Image/rock.png", "Image/paper.png", "Image/scissor.png"];
const nome = prompt("Please enter your name").toUpperCase();

document.getElementById("welcome").innerHTML = `HI, ${nome} LET'S START TO PLAY!`;

elem.forEach((number) => number.onclick = () =>  render(number.value));

const render = (param) => { 
    stampaPB.innerHTML= "";
    playerChoose = param.toUpperCase();
    let bot = Math.floor(Math.random()*3);
    botChoose = arr[bot];
    visualImg(nome, arrImg[arr.indexOf(playerChoose)])
    visualImg("BOT", arrImg[bot]);
    score(playerChoose, botChoose);
    }

const score = (player, bot) => {
        stampa.innerHTML = "";
        if((player == "ROCK" && bot=="PAPER") || (player == "PAPER" && bot=="SCISSOR") || (player == "SCISSOR" && bot=="ROCK")){
            botScore++;
            visualTxt("BOT WIN");
        }else if(player == bot){
            visualTxt("DRAW");
        }else{
            playerScore++;
            visualTxt(`${nome} WIN`);
        }
        visualTxt(`SCORE ${nome} = ${playerScore} <br> SCORE BOT = ${botScore}`);
    }

const visualTxt = (phrases) => stampa.innerHTML+= `<p>${phrases}</p>`;

const visualImg = (scelta, param) => stampaPB.innerHTML += `<label>${scelta}<div class="square"><img src=${param}></div></label>`; 

restart.onclick = () => {
        stampaPB.innerHTML= "";
        stampa.innerHTML = "";
        botScore = 0;
        playerScore = 0;
    }

    



