
let count = 0;
let countEl =  document.getElementById("count-el")
let saveEl = document.getElementById("save-el")
//document.getElementById("increment-btn").addEventListener("click", increment);
//document.getElementById("reset-btn").addEventListener("click", reset);
//document.getElementById("save-btn").addEventListener("click", save);
function increment() {
    count++;
    countEl.textContent = count;
  }

  function save() {
    saveEl.textContent += count + " - ";
    count=0;
    countEl.textContent = count;
  }


  /*TEXT CONTEXT PRENDE ANCHE GLI SPAZI E I CARATTERI NON LEGGIBILI DALL'UOMO
  MENTRE INNER TEXT SOLO I CARATTERI LEGGIBILI DALL'UOMO

  /*
  let welcome = document.getElementById("welcome-el")
  welcome.innerText=nome+greeting;
  */
/*
let lap1 = 34;
let lap2 = 33;
let lap3 = 36;
function somma()
{
let somma = 0;
somma = lap1 + lap2 + lap3;
console.log(somma);
}

somma();
*/

/*
let nome="Andrea"
let greeting = "Hi, my name is"
let myGreeting = greeting + ", " + nome + "!";
console.log(myGreeting)
*/
