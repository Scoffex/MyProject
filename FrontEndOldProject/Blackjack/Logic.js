/*
QUERY SELECTOR
let sumEl = document.querySelector("#sum-el");
Simile al getElementById ma possiamo selezionare anche classi o tag html 
in caso di una classe diverebbe così: let sumEl = document.querySelector(".sum-el");
*/
//TASTIERA ROTTA: <>
let cards = [];
let sum = 0;
let blackjack = false;
let isAlive = false;
let message = "";
let messageEl = document.getElementById("message-el");
let sumEl = document.getElementById("sum-el");
let cardEl = document.getElementById("card-el");
let playerEl = document.getElementById("name-el");

player = {
    Name : "Andrea",
    Chips : 145
}

playerEl.textContent = " " + player.Name + " " + player.Chips + "$";

function getRandomCard(){
    let numberRandom = Math.floor(Math.random()*13)+1;
    if(numberRandom === 1){
        numberRandom = 11;
    } else if(numberRandom>10){
        numberRandom = 10;
    }
    return numberRandom
}

function startGame(){
    isAlive = true;
    let firstCard = getRandomCard();
    let secondCard = getRandomCard();
    cards = [firstCard, secondCard]
    sum = firstCard + secondCard
    renderGame();
}

function renderGame() {
    cardEl.textContent = "Cards: ";
    for(let i=0; i<cards.length; i++){
        cardEl.textContent += cards[i] + " ";
    }
    sumEl.textContent = "Sum: " + sum;
    if(sum<=20){
        message = "Do you want to draw a new card?";
    } 
    else if(sum===21){
        message="you have got a BlackJack";
        blackjack=true;
    }   
    else {
        message="you are out of the game";
        isAlive = false;
    }
    messageEl.textContent = message;
  
}

function newCard(){
    if(isAlive === true && blackjack === false){
    let card = getRandomCard();
    sum += card;
    cards.push(card); //add a item on array
    //cards.pop(card); Remove last item of array
    renderGame();
    console.log(blackjack);
    } else if (blackjack===true){
        blackjack = false;
    }
}
     
