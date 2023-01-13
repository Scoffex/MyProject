(async function () {
    let url= "http://localhost:8080/api/banking";
    let count = 0;



    const delElem = () => {
        let buttonDel = document.getElementsByClassName("deleteButton");
        for(let i=0; i<buttonDel.length; i++){
            buttonDel[i].addEventListener('click', async function(){
                let id = this.id;
                await deleteFunc(id);
            })
        }
        }

   
        
const viewTable = async (url, nElem, nPage) => {

    let json = await readAll(url, nElem, nPage);
    if(json.length == 0){
        count--;
        viewTable(url, 2, count);
    }

    let table = "";
     table += `<table>
               <tr><th style="width:4vw;">ID</th>
               <th>Name</th>
               <th colspan="2" class="description">Description</th>
               <th>Type</th>
               <th>Delete</th>
               </tr>`;
                                       
    for(let i=0; i<json.length; i++){
            table += `<tr ><td style="width:4vw;">${json[i]["id"]}</td>
                      <td class="sfuma">${json[i].name}</td>
                      <td colspan="2" class="description">${json[i].description}</td>
                      <td class="sfuma">${json[i].type}</td>
                      <td ><button id="${json[i]["id"]}" class="deleteButton"><img src="../img/del2.png" id="del"></button></td>
                      </tr>`
    }

    table += `</table>`
    document.getElementById("main").innerHTML = table;
    delElem();
}



//Prima funzione stampa tabella 
await viewTable(url, 2, 0);



//logica Button Next
document.getElementById("nextPage").addEventListener("click", async function() { 
    count++;
    console.log(count, "next")
    await viewTable(url, 2, count);
})



//logica Button Back
document.getElementById("backPage").addEventListener("click", async function() {
    if(count>0){
        count--;
    }
    console.log(count, "back")
    await viewTable(url, 2, count);
})



//Delete
async function deleteFunc(id) {
    try {
        let urlFinal = url + '/delete/' + id;
        let response = await fetch(buildRequest(urlFinal, 'DELETE'));
        if(response.ok) {
            location.reload();
        }
        throw({status: response.status, text: response.statusText})
    } catch (error) {
        console.log(error);
    }
}



//Get con paginable
async function readAll(url, numElem, numPage) {
    try {
        urlFinal = url + `/findAll/pageSize/${numElem}/pageNumber/${numPage}`;
        let response = await fetch(buildRequest(urlFinal));

        if(response.ok) {
            return await response.json();
        }
        throw({status: response.status, text: response.statusText})
    } catch (error) {
        console.log(error);
    }        
}



//builder della request
function buildRequest(url, method = "GET", body = null) {
    let headers = new Headers({
        "Accept": "application/json",
        "Content-Type": "application/json",
    });

    return new Request(url, {
        method: method,
        headers: headers,
        body: body
    });
}



}) ();