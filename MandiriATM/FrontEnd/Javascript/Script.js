(async function () {

    const btn = document.getElementById("next");
    const indietro = document.getElementById("back");
    const input = document.getElementById("pan");
    const bankCode = document.getElementById("bankCode");
    const main = document.getElementById("content");
    const arrElem = ["pan", "bankCode", "peripherals"];
    const audioWelcome = document.getElementById("welcome");
    const audioErrore = document.getElementById("error");
    const audioErroreCheck = document.getElementById("errorComp")
    const audioAccesso = document.getElementById("accesso");
    const checkBox = [...document.querySelectorAll('input[type=checkbox]')];
    const regex = /^[0-9]{5}$/;
    const regex2 = /^[0-9]{5}$/;
    let arr = [];
    let arrValue = [];
    let boolAudioCheck = true;
    const url = "http://localhost:8080/api/banking/findByPanAtmBank";
    const messError = `<h1 class="errorJson" >ERRORE: LA TUA CARTA NON E' ABILITATA PRESSO IL NOSTRO ATM<br>Contattare un operatore per assistenza</h1>`
    const AdminIcon = document.getElementById("AdminSem");
    const footer = document.getElementById("ciao");
    const muta = document.getElementById("muta");
    let audioPlay = true;
    let arrAudio = [audioWelcome, audioErrore, audioErroreCheck, audioAccesso];
    let srcAudio = ["../Audio/Welcome.mp3", "../Audio/Errore.mp3", "../Audio/Accesso.mp3","../Audio/ErroreComp.mp3"]


    //gestioneAudioOn-AudioOff
    muta.onclick = () => {
        if(audioPlay==true){
        audioPlay = false;
        arrAudio.map(elem => elem.src = "");
        muta.src = "../img/volumOFF.png";
    }
        else{
            for(let i=0; i<arrAudio.length; i++){
                arrAudio[i].src = srcAudio[i];
            }
            audioPlay = true;
            muta.src = "../img/volumOn.png";
        }
    }



    //popUp Admin
    footer.onmouseover = () => {
        AdminIcon.style.width = "10vw";
        AdminIcon.style.height = "10vh";
        AdminIcon.style.border = "solid  rgb(255, 187, 0)  6px";
    }

    footer.onmouseleave = () => {
        AdminIcon.style.width = "0vw";
        AdminIcon.style.height = "0vh";
        AdminIcon.style.border = "";
    }



    //Funzione di riproduzione audio
    const playAudio = (elem) => {
        
        if (elem != audioWelcome || boolAudioCheck==false)
        audioWelcome.src = "";
       else{
            if (boolAudioCheck == true) {
                boolAudioCheck = false;
            }
        }
       
        elem.play();
        
    }



    //Funzione controllo lunghezza PAN CODE E BANK CODE
    const testInput = (input, regex) => {
        if (!regex.test(input.value)) {
            input.value = "";
            input.placeholder = "NUMERO INCORRETTO DI NUMERI"
            playAudio(audioErrore);
            return false;
        } else {
            return true;
        }
    }



    //funzioni audio e reload
    main.onclick = () => playAudio(audioWelcome);
    indietro.onclick = () => window.location.reload();



    //generazione Div in rispsota alla request
    const renderFunc = (jsonGet) => {
        let stampa = "";
        if (jsonGet == undefined || jsonGet.length == 0) {
            stampa += `<div class="autogeneratedErr">`;
            stampa += messError;
            stampa += `</div>`;
        } else {
            let arrJson = [...jsonGet];
            stampa += `<div class="autogenerated scroll">`;
            arrJson.map(elem => stampa += `<div class="finalAutogenerated">${elem.name}</div>`);
            stampa += `</div>`;
        }
        main.innerHTML = stampa;
    }



    //creazione json da inviare con la request
    const creaObject = (value, key, lenght) => {
        let obj = {};
        for (let i = 0; i < lenght; i++) {
            obj[key[i]] = value[i]
        }
        return obj;
    }



    //request alla restApi
    async function getFunctionality(url, method, obj) {
        try {
            let response = await fetch(buildRequest(url, method, JSON.stringify(obj)));
            if (response.ok)
                return await response.json()
        } catch (error) {
            console.log(error);
        }
    }



    //builder della request
    const buildRequest = (url, met, bod) => {
        let headers = new Headers({
            "Accept": "application/json",
            "Content-Type": "application/json",
        });

        return new Request(url, {
            method: met,
            headers: headers,
            body: bod
        });
    }



    //Funzione principale
    btn.onclick = async () => {
        arr = [];
        let check = testInput(input, regex);
        let check2 = testInput(bankCode, regex2);
        checkBox.map(elem => {
            if (elem.checked)
                arr.push(parseInt(elem.value))
        })
        if (arr.length == 0) {
            playAudio(audioErroreCheck);
        }
        if (check === true && check2 === true && arr.length != 0) {
            arrValue.push(input.value, bankCode.value, arr);
            let obj = creaObject(arrValue, arrElem, arrValue.length);
            main.innerHTML = "";
            playAudio(audioAccesso);
            renderFunc(await getFunctionality(url, 'POST', obj));
        }
    }


    
})(); 

