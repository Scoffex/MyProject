<?php
class Farmaco {   
    private $conn;
    private $tabellaFarmaci = "farmaci";  
    public $id;
    public $nome;
    public $descrizione;
    public $quantita;
    public $datascadenza;
    public $datarifornimento;

    public function __construct($db){
        $this->conn = $db;
    }	
	
	function read(){	
		if($this->id) {
			$stmt = $this->conn->prepare("SELECT * FROM ".$this->tabellaFarmaci." WHERE id = ?");
			$stmt->bind_param("i", $this->id);					
		} else {
			$stmt = $this->conn->prepare("SELECT * FROM ".$this->tabellaFarmaci);		
		}		
		$stmt->execute();			
		$result = $stmt->get_result();		
		return $result;	
	}
    function create() {
		
		$stmt = $this->conn->prepare("
			INSERT INTO ".$this->tabellaFarmaci."(`nome`, `descrizione`,`quantita`,`datascadenza`, `datarifornimento`)
			VALUES(?,?,?,?,?)");

		$this->nome  = htmlspecialchars(strip_tags($this->nome));
		$this->descrizione  = htmlspecialchars(strip_tags($this->descrizione));
		$this->quantita  = htmlspecialchars(strip_tags($this->quantita));
		$this->datascadenza  = date("Y-m-d H:i:s");
		$this->datarifornimento  =  date("Y-m-d H:i:s");		
		
		$stmt->bind_param("ssiss", $this->nome, $this->descrizione, $this->quantita, $this->datascadenza,$this->datarifornimento);
		
		if($stmt->execute()) {
			return true;
		}
	 
		return false;		 
	}
    function delete(){
		
		$stmt = $this->conn->prepare("
			DELETE FROM ".$this->tabellaFarmaci." 
			WHERE id = ?");
			
		$this->id = htmlspecialchars(strip_tags($this->id));
	 
		$stmt->bind_param("i", $this->id);
	 
		if($stmt->execute()){
			return true;
		}
	 
		return false;		 
		
	}
    function update(){
	 
		$stmt = $this->conn->prepare("
			UPDATE ".$this->tabellaFarmaci." 
			SET  nome= ?, descrizione = ?, quantita = ?, datascadenza = ?, datarifornimento = ?
			WHERE id = ?");
	 
		$this->nome  = htmlspecialchars(strip_tags($this->nome));
		$this->descrizione  = htmlspecialchars(strip_tags($this->descrizione));
		$this->quantita  = htmlspecialchars(strip_tags($this->quantita));
        $this->datascadenza  = htmlspecialchars(strip_tags($this->datascadenza));
		$this->datarifornimento  = htmlspecialchars(strip_tags($this->datarifornimento));
	
	 
		$stmt->bind_param("ssissi", $this->nome, $this->descrizione, $this->quantita, $this->datascadenza, $this->datarifornimento, $this->id);
		
		if($stmt->execute()){
			return true;
		}
	 
		return false;
	}
}
?>