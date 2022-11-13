<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");

include_once '../config/database.php';
include_once '../models/loginusers.php';

$database = new Database();
$db = $database->getConnection();
 
$loginusers = new Loginusers($db);

$loginusers->id = (isset($_GET['id']) && $_GET['id']) ? $_GET['id'] : '0';

$result = $loginusers->read();

if($result->num_rows > 0){    
    $itemRecords=array();
    $itemRecords["loginusers"]=array(); 
	while ($loginusers = $result->fetch_assoc()) { 	
        extract($loginusers); 
        $itemDetails=array(
            "id" => $id,
            "username" => $username,
            "nome" => $nome,
			"cognome" => $cognome,
            "email" => $email,            
			"password" => $password,		
        ); 
       array_push($itemRecords["loginusers"], $itemDetails);
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