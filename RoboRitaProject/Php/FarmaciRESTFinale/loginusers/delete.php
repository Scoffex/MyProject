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

if(!empty($data->id)) {
	$loginusers->id = $data->id;
	if($loginusers->delete()){    
		http_response_code(200); 
		echo json_encode(array("message" => "User was deleted."));
	} else {    
		http_response_code(503);   
		echo json_encode(array("message" => "Unable to delete user."));
	}
} else {
	http_response_code(400);    
    echo json_encode(array("message" => "Unable to delete user. Data is incomplete."));
}
?>