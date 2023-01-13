const todo = document.getElementById("todo");
const dateTodo = document.getElementById("todoDate");
const hourTodo = document.getElementById("todoTime");
const buttonTodo = document.getElementById("add");
const listTodo = document.getElementById("todoUl");
const listDone = document.getElementById("doneUl");
const advice = document.getElementById("advice");
let obTodo = [];
let obDone = [];
const leadTodo = JSON.parse(localStorage.getItem("Todo"));
const leadDone = JSON.parse(localStorage.getItem("Done"));

buttonTodo.addEventListener("click", () => {
    advice.innerHTML = "";
    if(todo.value != "" && dateTodo.value!= "" && hourTodo.value!=""){
    obTodo.push({
        Activity: todo.value,
        Date: dateTodo.value,
        Hour: hourTodo.value,
        Id: Math.floor(Math.random()*100000)
    })
    todo.value = "";
    dateTodo.value = "";
    hourTodo.value = "";
    toDoLoader();
}else{
    advice.innerHTML = `<p style='color:red'>MANCANO ALCUNI ELEMENTI</p>`
}
})

const render = (list, arr, disabled, remove) => {
    setLocalStorage();
    advice.innerHTML = "";
    arr.forEach(function(element) {
        list.innerHTML +=  `<ul>
                                <li id="principal"><label>Activity:</label> ${element.Activity} </li>
                                <div id="secondary" class="flex">
                                    <li><label>Date:</label> ${element.Date} </li>
                                    <li id="ore"><label>Hours:</label> ${element.Hour} </li>
                                </div>
                                <div id="button" class="flex">
                                    <button id="switch" class="elem" onclick="switcher(${element.Id})" ${disabled}>CHECK</button>
                                    <button id="delete" class="elem" onclick="${remove}(${element.Id})">DELETE</button>
                                </div>
                            </ul>`    
    })
};

const toDoLoader = () =>{
    listTodo.innerHTML = "";
    render(listTodo, obTodo, "", "removeToDo");
}

const doneLoader = () =>{
    listDone.innerHTML = "";
    render(listDone, obDone, "style='display:none'", "removeDone");
}

const switcher = (id) => {
    obDone.push(removeToDo(id));
    doneLoader();
}

const dlt = (id, array) => {
    let del = array.splice(array.findIndex(obj=> obj.Id === id), 1)[0];
    if(array==obTodo)
        return del;
}

const removeToDo = (id)=>{
    let del = dlt(id,obTodo);
    toDoLoader();
    return del;
}

const removeDone = (id) => {
    dlt(id, obDone);
    doneLoader();
}

function setLocalStorage(){
    localStorage.setItem("Todo", JSON.stringify(obTodo));
    localStorage.setItem("Done", JSON.stringify(obDone));
    }

if(leadTodo){
    obTodo = leadTodo;
    toDoLoader();
}

if(leadDone){
    obDone = leadDone;
    doneLoader();
}