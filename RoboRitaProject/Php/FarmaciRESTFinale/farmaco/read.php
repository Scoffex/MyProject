<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: *");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
 
include_once '../config/database.php';
include_once '../models/farmaco.php';

if ($_SERVER['REQUEST_METHOD'] === 'OPTIONS') {
    // The request is using the POST method
    header("HTTP/1.1 200 OK");
    return;
}

$database = new Database();
$db = $database->getConnection();
 
$farmaco = new Farmaco($db);

$farmaco->id = (isset($_GET['id']) && $_GET['id']) ? $_GET['id'] : '0';

$result = $farmaco->read();

if($result->num_rows > 0){    
    $itemRecords=array();
    $itemRecords["farmaco"]=array(); 
	while ($farmaco = $result->fetch_assoc()) { 	
        extract($farmaco); 
        $itemDetails=array(
            "id" => $id,
            "nome" => $nome,
            "descrizione" => $descrizione,
			"quantita" => $quantita,
            "datascadenza" => $datascadenza,            
			"datarifornimento" => $datarifornimento,		
        ); 
       array_push($itemRecords["farmaco"], $itemDetails);
    }    
    http_response_code(200);     
    echo json_encode($itemRecords);
}else{     
    http_response_code(404);     
    echo json_encode(
        array("message" => "No item found.")
    );
} 
?>