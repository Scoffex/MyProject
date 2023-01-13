<?php
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: *");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
  
include_once '../config/database.php';
include_once '../models/loginusers.php';
 
$database = new Database();
$db = $database->getConnection();

if ($_SERVER['REQUEST_METHOD'] === 'OPTIONS') {
    // The request is using the POST method
    header("HTTP/1.1 200 OK");
    return;
}
$loginusers = new Loginusers($db);

/* if(!$users->validate_token($_SERVER['PHP_AUTH_USER'],base64_encode($_SERVER['PHP_AUTH_USER'].":".$_SERVER['PHP_AUTH_PW']))) { 
    http_response_code(401);   
    echo json_encode(array("message" => "Unauthorized."));  
    exit();
} */

$data = json_decode(file_get_contents("php://input"));

if(!empty($data->username) && !empty($data->email) && !empty($data->nome) && !empty($data->cognome) && !empty($data->password)) {    

    $loginusers->username = $data->username;
    $loginusers->nome = $data->nome;
    $loginusers->cognome = $data->cognome;
    $loginusers->email = $data->email;	
    $loginusers->password = $data->password;    
    
    if($loginusers->create()){         
        http_response_code(201);         
        echo json_encode(array("message" => "Item was created."));
    } else{         
        http_response_code(503);        
        echo json_encode(array("message" => "Unable to create item."));
    }
} else {    
    http_response_code(400);    
    echo json_encode(array("message" => "Unable to create item. Data is incomplete."));
}
?>