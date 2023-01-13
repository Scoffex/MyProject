let myLeads = [];
const inputEl = document.getElementById("input-el");
const inputBtn = document.getElementById("input-btn");
const saveTab = document.getElementById("savetab-btn");
const ulEl = document.getElementById("ul-el");
const deleteBtn = document.getElementById("delete-btn");
const leadsFromLocalStorage = JSON.parse(localStorage.getItem("myLeads"));

if(leadsFromLocalStorage){
    myLeads = leadsFromLocalStorage;
    renderLeads(myLeads);
}

function renderLeads(index) {
    let listItems = ""
    for (let i = 0; i < index.length; i++) {
        listItems += `
            <li>
                <a target='_blank' href='${index[i]}'>
                    ${index[i]}
                </a>
            </li>
        `
    }
    ulEl.innerHTML = listItems  
}

inputBtn.addEventListener("click", function() {
    if(inputEl.value){
    myLeads.push(inputEl.value);
    setLocalStorage();
    inputEl.value = "";
    renderLeads(myLeads);}
})

saveTab.addEventListener("click", function(){
    chrome.tabs.query({active: true, currentWindow: true}, function(tabs) {
        myLeads.push(tabs[0].url);
        setLocalStorage();
        renderLeads(myLeads);
    })
})

deleteBtn.addEventListener("dblclick", function() {
    localStorage.clear();
    myLeads = [];
    renderLeads(myLeads);
})

function setLocalStorage(){
localStorage.setItem("myLeads", JSON.stringify(myLeads));
}
