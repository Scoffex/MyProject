

( async function (){
    'use strict';
    const uri= "http://localhost/FarmaciRESTFinale/farmaco";
    var token = sessionStorage.getItem("token");
    //CREATE
    document.getElementById('add').addEventListener('click', async() => {
        let nome = document.getElementById('nome').value;
        let descrizione = document.getElementById('descrizione').value;
        let quantita = document.getElementById('quantita').value;
        let datascadenza = document.getElementById('datascadenza').value;
        let datarifornimento = document.getElementById('datarifornimento').value;
        if (nome !== "" && descrizione !== "" && quantita != "" && datascadenza != "" && datarifornimento != "") {
                let farmaco = createFarmaco(nome, descrizione, quantita, datascadenza, datarifornimento);
                document.getElementById('finale').innerHTML = `<p>Farmaco aggiunto correttamente</p>`;
                console.log(farmaco);
        }else {
            document.getElementById('finale').innerHTML = `<p style="color:red">Attenzione ERRORE: Farmaco non aggiunto campi vuoti</p>`;
        }
    })

    //DELETE
    document.getElementById('elimina').addEventListener('click', () => {
        let id = document.getElementById('identificativo').value;
        if(id!=""){
        let farmaco = deleteFaramco(id);
        document.getElementById('finale').innerHTML = `<p>Farmaco eliminato</p>`;
        console.log(farmaco);
        }else {
        document.getElementById('finale').innerHTML = `<p style="color:red">Attenzione ERRORE: Farmaco impossibile da eliminare id mancante</p>`;
        }
    })

    //READ
    document.getElementById('read').addEventListener('click', async () => {
       let read = await readFarmaco();
       let array = read['farmaco'];
       let html=
        `
         <table id="tableFarmaci">
         <tr id="RigaFarmaci1">
         <th>Id</th>
         <th>Nome</th>
         <th>Descrizione</th>
         <th>Quantita</th>
         <th>Data Rifornimento</th>
         <th>Data Scadenza</th>
         </tr>`;
        for (let i = 0; i < array.length; i++) {
            html += `
         <tr>
         <td>${array[i].id}</td>
         <td>${array[i].nome}</td>
         <td>${array[i].descrizione}</td>
         <td>${array[i].quantita}</td>
         <td>${array[i].datarifornimento}</td>
         <td>${array[i].datascadenza}</td>
         </tr>`
        }
        document.getElementById('finale').innerHTML = html + `</table>`;
    })

    //UPDATE
    document.getElementById('update').addEventListener('click', async() => {
        let nome = document.getElementById('nome').value;
        let descrizione = document.getElementById('descrizione').value;
        let quantita = document.getElementById('quantita').value;
        let datascadenza = document.getElementById('datascadenza').value;
        let datarifornimento = document.getElementById('datarifornimento').value;
        let id = document.getElementById('identificativo').value;
        if (nome !== "" && descrizione !== "" && quantita != 0 && datascadenza != "" && datarifornimento != "" && id!=0) {
                let farmaco = updateFarmaco(id, nome, descrizione, quantita, datascadenza, datarifornimento);
                console.log(farmaco);
                document.getElementById('finale').innerHTML = `<p>Farmaco aggiornato correttamente</p>`;
        }else {
            document.getElementById('finale').innerHTML = `<p style="color:red">Attenzione ERRORE: Farmaco non aggiornato campi vuoti</p>`;
        }
    })

    try{
        // user = await readFarmaco();
        //let farmaco = await createFarmaco('oki', 'ciaociao', 15, '2022-06-20', '2022-08-20');
        //let farmaco = await deleteFaramco(1);
        //let farmaco = await updateFarmaco(11, 'Ciao', 'CiaoCiao', 30, '2022-06-21', '2022-06-25');
        //console.log(user);
        
        //console.log(farmaco);
    }catch(error){
        console.log(error);
    }

    async function createFarmaco(nome, descrizione, quantita, datascadenza, datarifornimento) {
        try {
            let body = { nome, descrizione, quantita, datascadenza, datarifornimento}; //sarebbe name=name, email=email, gender=gender, status=status la sintassi permette di evitare ciò scrivendo le variabili come se le aspetta l'oggetto
            let response = await fetch(buildRequest(`${uri}/create.php`, 'POST', JSON.stringify(body)));
            if (response.ok) {
                return await response.json();
            }
            throw ({ status: response.status, text: response.status })
        } catch (error) {
            console.log(error);
        }

    }
    async function readFarmaco(){
    try {
        let url = `${uri}/read.php`;
        let response = await fetch(buildRequest(url));
        if(response.ok){
            return await response.json();
        }
        throw({status: response.status, text: response.status})
    }catch (error){
        console.log(error);
    }
    /*
    Tramite la funzione async noi implementiamo l'await che ci permette di evitare di "introdurre" all'interno del nostro codice le due callback della promise.
    Il tutto viene sostituito da un try and catch.
    quella che ora è "response" => let  myPromise = fetch(buildRequest(uri)); //per eseguire una request usiamo un api del brawser che si chiama fetch
    myPromise.then((response) => console.log(response));
    myPromise.catch((error) => console.log(error));
    console.log("fine metodo"); */
    }
    //la fatch è una xml http request implementata come promise. 
    //la promise rappresenta l'esecuzione in toto di un task asincrono che lancia due callback, una callback in caso il task asincrono
    //che perfomiamo va ok, e viene interciettate tramite il comando "THAN" il suo nome è FULLFILL e può essere intercettata nell'oggetto mediante il punto then "promise.than", La seconda callback che si chiama reget e viene intercettata
    //mediante l'API CATCH e che viene intercettata quando il comando fallisce "promise.catch" lancia reget. 
    async function deleteFaramco(id){
        try {
            let body = {id};
            let response = await fetch(buildRequest(`${uri}/delete.php`, 'DELETE', JSON.stringify(body)));
            if(response.ok){
                return "farmaco eliminato";
            }
        } catch (error) {
           console.log(error);
        }

    }
    async function updateFarmaco(id, nome, descrizione, quantita, datascadenza, datarifornimento){
        try {
            let body = {id, nome, descrizione, quantita, datascadenza, datarifornimento}; //sarebbe name=name, email=email, gender=gender, status=status la sintassi permette di evitare ciò scrivendo le variabili come se le aspetta l'oggetto
            let response = await fetch(buildRequest(`${uri}/update.php`, 'PATCH', JSON.stringify(body)));
            if (response.ok) {
                return await response.json();
            }
            throw ({ status: response.status, text: response.status })
        } catch (error) {
            console.log(error);
        }
    }

    function buildRequest(url, method = "GET", body = null){
        let headers = new Headers({
            "Accept":"application/json",
            "Content-Type":"application/json",
            "Authorization":`Basic ${token}`
        });

        return new Request(url, {
            method: method,
            headers: headers,
            body: body
        })
    }
})();