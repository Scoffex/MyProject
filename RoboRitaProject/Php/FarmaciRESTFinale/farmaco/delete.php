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
$farmaco = new farmaco($db);
 
$data = json_decode(file_get_contents("php://input"));

if(!empty($data->id)) {
	$farmaco->id = $data->id;
	if($farmaco->delete()){    
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