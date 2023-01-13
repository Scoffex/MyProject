<?php
class Loginusers {   
    private $conn;
    private $tabellaUtente = "loginusers";      
    private $tabellaToken = "tokens";      
    public $id;
    public $username;
    public $nome;
    public $cognome;
    public $email;
    public $password;
    
    public function __construct($db){
        $this->conn = $db;
    }	
    function create() {
		
		$stmt = $this->conn->prepare("
			INSERT INTO ".$this->tabellaUtente."(`username`, `password`,`nome`,`cognome`, `email`)
			VALUES(?,?,?,?,?)");

		$this->username  = htmlspecialchars(strip_tags($this->username));
		$this->password  = password_hash($this->password, PASSWORD_BCRYPT);
		$this->nome  = htmlspecialchars(strip_tags($this->nome));
		$this->cognome  = htmlspecialchars(strip_tags($this->cognome));
		$this->email  = htmlspecialchars(strip_tags($this->email));
		
		$stmt->bind_param("sssss", $this->username, $this->password, $this->nome, $this->cognome,$this->email);
		
		if($stmt->execute()) {
			return true;
		}
	 
		return false;		 
	}
    function update(){
	 
		$stmt = $this->conn->prepare("
			UPDATE ".$this->tabellaUtente." 
			SET  username= ?, password = ?, nome = ?, cognome = ?, email = ?
			WHERE id = ?");
	 
		$this->username  = htmlspecialchars(strip_tags($this->username));
		$this->password  = password_hash($this->password, PASSWORD_BCRYPT);
		$this->nome  = htmlspecialchars(strip_tags($this->nome));
        $this->cognome  = htmlspecialchars(strip_tags($this->cognome));
		$this->email  = htmlspecialchars(strip_tags($this->email));
	
	 
		$stmt->bind_param("sssssi", $this->username, $this->password, $this->nome, $this->cognome, $this->email, $this->id);
		
		if($stmt->execute()){
			return true;
		}
	 
		return false;
	}
    function read(){	
		if($this->id) {
			$stmt = $this->conn->prepare("SELECT * FROM ".$this->tabellaUtente." WHERE id = ?");
			$stmt->bind_param("i", $this->id);					
		} else {
			$stmt = $this->conn->prepare("SELECT * FROM ".$this->tabellaUtente);		
		}		
		$stmt->execute();			
		$result = $stmt->get_result();		
		return $result;	
	}
    function delete(){
		
		$stmt = $this->conn->prepare("
			DELETE FROM ".$this->tabellaUtente." 
			WHERE id = ?");
			
		$this->id = htmlspecialchars(strip_tags($this->id));
	 
		$stmt->bind_param("i", $this->id);
	 
		if($stmt->execute()){
			return true;
		}
	 
		return false;		 
		
	}
    function login() {		
		if($this->username !="" && $this->password !="") {
			$stmt = $this->conn->prepare("SELECT * FROM ".$this->tabellaUtente." WHERE username = ?");
			$stmt->bind_param("s", $this->username);
			
			$stmt->execute();			
			$result = $stmt->get_result();				
			return $result;				
		}
	}
    function store_token($user_id,$token) {
        
        $delete_previous_token = $this->delete_token($user_id);
 
        if ($delete_previous_token) {
            $stmt = $this->conn->prepare("
            INSERT INTO ".$this->tabellaToken."(`user_id`, `token`)
            VALUES(?,?)");          
        
            $stmt->bind_param("is", $user_id, $token);
            
            if($stmt->execute()) {
                return true;
            }
        }
        return false;
    }
 
 
    function delete_token($user_id) {
        $stmt = $this->conn->prepare("
        DELETE FROM ".$this->tabellaToken." WHERE user_id =?");
        $stmt->bind_param("i", $user_id);
        
        if($stmt->execute()) {
            return true;
        }
    }
    
    function validate_token($user_id,$token) {
        if($user_id !="" && $token !="") {
            $stmt = $this->conn->prepare("SELECT * FROM ".$this->tabellaToken." WHERE user_id= ? AND token= ?");
            $stmt->bind_param("is", $user_id, $token);
            $stmt->execute();           
            $result = $stmt->get_result();              
            if($result->num_rows > 0){
                return true;
            }           
        }
        return false;
    }

}
?>