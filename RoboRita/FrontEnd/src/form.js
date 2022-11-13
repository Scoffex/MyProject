(function (){
  let div = document.createElement("div");
  div.innerHTML = `<form>
    <label for="fname">First name:</label><br>
    <input type="text" id="fname" name="fname"><br>
    <label for="lname">Last name:</label><br>
    <input type="text" id="lname" name="lname">
  </form>
  <br>
  <button type="button" id="clicca">Clicca Qui</button>
  <div id="finale"></div>`;
  document.body.appendChild(div);
  document.getElementById('clicca').addEventListener('click', () => {
  let nome = document.getElementById('fname').value;
  let cognome = document.getElementById('lname').value;
  document.getElementById('finale').innerHTML=`<p>Nome: ${nome} \n Cognome: ${cognome}</p>`;
  })
  document.body.appendChild(div2);
  })();

/*

(function () {
let myDiv=document.createElement("div");

//let dynamicId = 'myDiv2';
//myDiv.id = "myDiv";
myDiv.innerHTML =  createInputWithId('input', 'myInput', 'nome', 'text') + "<br><br>" + 
createInputWithId('input', 'myInput2', 'cognome', 'text') +"<br><br>" + createButtonWithId('button', 'myButton', undefined, 'Clicca qui');

//myDiv.innerHTML = "<div id=' " + dynamicId + "'></div>";
document.body.appendChild(myDiv);

let myButton = document.getElementById('myButton');
//addEventListner prende come parametri l'evento e la funzione che esegue quando viene eseguito l'evento.
let finale = document.createElement("div");
myButton.addEventListener('click', () => {
    let testo1=document.getElementById('myInput').value;
    let testo2=document.getElementById('myInput2').value;
    finale.innerHTML = `<p>${testo1} and ${testo2}`;
    //lo scope dell'arrow function è quello del chiamante. 
    document.body.appendChild(finale);
})

function createButtonWithId(tag, id, className="myClass", text = ''){
    let myClass= className ? `class="${className}"` : '';
    
return  `<${tag} id="${id}" ${className}>${text}</${tag}>`;//string litteral, ci aiuta con la composizione dinamica delle stringhe.
}
function createInputWithId(tag, id, name, type){
    return `<${tag} type="${type}" name="${name}" id="${id}"></${tag}>`;
}
})();
*/

