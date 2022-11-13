<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
 
include_once '../config/database.php';
include_once '../models/loginusers.php';
 
$database = new Database();
$db = $database->getConnection();
 
$loginusers = new Loginusers($db);
 
$data = json_decode(file_get_contents("php://input"));

if(!empty($data->id) && !empty($data->username) && !empty($data->email) && !empty($data->nome) && !empty($data->cognome) && !empty($data->password)) { 
	
	$loginusers->id = $data->id; 		
	$loginusers->username  = htmlspecialchars(strip_tags($data->username));
	$loginusers->nome  = htmlspecialchars(strip_tags($data->nome));
	$loginusers->cognome  = htmlspecialchars(strip_tags($data->cognome));	
	$loginusers->email  =  htmlspecialchars(strip_tags($data->email));	
    $loginusers->password  =  htmlspecialchars(strip_tags($data->password));
	
	if($loginusers->update()){     
		http_response_code(200);   
		echo json_encode(array("message" => "Item was updated."));
	}else{    
		http_response_code(503);     
		echo json_encode(array("message" => "Unable to update items."));
	}
	
} else {
	http_response_code(400);    
    echo json_encode(array("message" => "Unable to update items. Data is incomplete."));
}
?>