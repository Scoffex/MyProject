Mandiri ATM documentazione per utilizzare il nostro applicativo:

Per utilizzare il nostro applicativo, a causa di problemi relativi alla cors policy dei browser, bisogna avviare qualsiasi browser con Cors Policy disattivata. Per fare ciò inserire nel cmd (avviato come amministratore) tale codice: 

"C:\Program Files\Google\Chrome\Application\chrome.exe" --disable-web-security --disable-gpu --user-data-dir=~/chromeTempRepo 

Il path in questione varia a seconda delle locazione di chrome nel file system.

Successivamente scaricare docker e avviare il docker compose.

Ora tutti i servizi sono avviati. In caso sia il primo il servizio dell'api potrebbe non avviarsi correttamente a causa della mancanza del db.

In caso di tale evenienza stoppare e restartare il docker-compose.

Successivamente per un corretto utilizzo è necessario riempire il db delle periferiche, bin e bank-code manualmente. Un esempio di insert da fare nel db: 

use  projectWorkBanking;

INSERT INTO bank_code(id, bank, bank_code) values (1, '08509', 'Banca Centro Emilia');
INSERT INTO bank_code(id, bank, bank_code) values (2, '03374', 'Alto Adige Banca S.P.A.');
INSERT INTO bank_code(id, bank, bank_code) values (3, '03124','Banca Del Fucino - S.P.A.');
INSERT INTO peripheral(id, name) values (1,'CDM');
INSERT INTO peripheral(id, name) values (2,'CIM');
INSERT INTO peripheral(id, name) values (3,'RPR');
INSERT INTO peripheral(id, name) values (4,'IPM');
INSERT INTO peripheral(id, name) values (5,'KEYBOARD');
INSERT INTO bin(id, bin_value) values(1, '11');
INSERT INTO bin(id, bin_value) values(2, '12');
INSERT INTO bin(id, bin_value) values(3, '13');

NOTA DOCKER: 
se si vuole effettuare la insert nel db da docker: 
	1) aprire il cmd nella cartella BackEnd.
	2) Digitare: "docker exec -ti projectwork-sql-1 bash"
	3) Digitare:  "mysql -uroot -proot"
	4) Digitare: "use  projectWorkBanking;"

E infine incollare le insert senza lo "use  projectWorkBanking;" in quanto si è già selezionato il db.

Ora il db sarà pronto a ricevere le funzionalità.

Da front-end accedere alla sezione admin (password admin = "1234") e fare la insert di tutte le operazioni che si desidera inserire, come versamento, prelievo ecc. indicare un nome, una descrizione, la tipologia di operazione, inserire il bankCode affiliato a quell'operazione e il bin code (verranno mostrati a schermo quelli disponibili in maniera dinamica) una volta selezionato tutti, inviare la richiesta tramite il medesimo button. 

Ora, tornando al pannello client, se utilizzeremo il medesimo binCode e bankCode e le medesime periferiche inserite nella fase di insert della funzionalità, potremo accedere alla nostra funzionalità. L'applicativo notificherà nel caso in cui i dati inseriti siano errati o nel caso in cui non siano presenti funzionalità per quel binCode o bankCode.