

( async function (){
    
    const uri2= "http://localhost/FarmaciRESTFinale/loginusers";

    document.getElementById('login').addEventListener('click', async() => {
        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;
        if ( username && password) {
                let utente = await loginUtente(username, password);
                if(utente){
                sessionStorage.setItem("token", utente.token);
                location.href="../Progetto/dashboard.html";
                document.getElementById('stampa').innerHTML = `<p>Utente loggato correttamente</p>`;
                }else {
                    document.getElementById('stampa').innerHTML = `<p>Credenziali errate </p>`;
                }
            }
                else{
                    document.getElementById('stampa').innerHTML = `<p>Credenziali vuote </p>`;
                }
    })
    
    try{
        //let user = await readUser();
        //let farmaco = await createUser('oki', 'ciaociao', 15, '2022-06-20', '2022-08-20');
        //let farmaco = await deleteUser(1);
        //let farmaco = await updateUser(11, 'Ciao', 'CiaoCiao', 30, '2022-06-21', '2022-06-25');
        //console.log(user);
        //let utente=await createUtente('bilbo', 'bello', 'brutto', 'andrealaera@gmail.com', 'Endriu99');
        //console.log(utente);
        
    }catch(error){
        console.log(error);
    }
    async function loginUtente(username, password){
        
            try {
                let body = {username, password}; //sarebbe name=name, email=email, gender=gender, status=status la sintassi permette di evitare ciò scrivendo le variabili come se le aspetta l'oggetto
                let response = await fetch(buildRequest(`${uri2}/login.php`, 'POST', JSON.stringify(body)));
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
            "Content-Type":"application/json"
        });

        return new Request(url, {
            method: method,
            headers: headers,
            body: body
        })
    }
})();