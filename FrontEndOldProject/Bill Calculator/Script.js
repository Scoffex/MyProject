const amount = document.getElementById("amount");
const percentage = document.getElementById("percentage");
const nPeople = document.getElementById("num");
const nPlus = document.getElementById("plus");
const nLess = document.getElementById("less");
const stampa = document.getElementById("final");
let nPeopleModify = 0;

const render = (where, what) => where.innerHTML = `${what}`

const calcolo = (numPeople) => {
    if(amount.value != "" && percentage.value != "" && nPeopleModify != 0){
    let final =  ((Number(amount.value) * (Number(percentage.value)/100)) + Number(amount.value))/numPeople;
        return  "$" + final.toString();
    }else 
        return "$0.00"
}
amount.onchange = () =>  render(stampa, calcolo(nPeopleModify));
percentage.onchange = () => render(stampa, calcolo(nPeopleModify));

nPlus.onclick = () => {
    nPeopleModify++;
    render(nPeople, nPeopleModify);
    render(stampa, calcolo(nPeopleModify));
}
nLess.onclick = () => {
    if(nPeopleModify>0){
        nPeopleModify--;
    }
        render(nPeople, nPeopleModify);
        render(stampa, calcolo(nPeopleModify));
}


