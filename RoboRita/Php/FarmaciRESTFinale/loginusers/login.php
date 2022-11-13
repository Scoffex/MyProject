<?php
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: *");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
 
include_once '../config/database.php';
include_once '../models/loginusers.php';
 
if ($_SERVER['REQUEST_METHOD'] === 'OPTIONS') {
    // The request is using the POST method
    header("HTTP/1.1 200 OK");
    return;
}
$database = new Database();
$db = $database->getConnection();
 
$loginusers = new Loginusers($db);
$data = json_decode(file_get_contents("php://input"));


if(!empty($data->username) && !empty($data->password)) {    

    $loginusers->username = $data->username;
    $loginusers->password = $data->password;
    
    $result = $loginusers->login();
    
    if($result->num_rows > 0){    
        $user_detail = $result->fetch_assoc();
        if (password_verify($loginusers->password, $user_detail['password'])) {
            $token = base64_encode($user_detail['id'].":".bin2hex(random_bytes(16)));
            $loginusers->store_token($user_detail['id'],$token);

            http_response_code(201);
            echo json_encode(array("message" => "user found.","token"=>$token));   
            
        } else {
            http_response_code(401);         
            echo json_encode(array("message" => "wrong username/password combination ."));
        }      
    } else {         
        http_response_code(503);        
        echo json_encode(array("message" => "Unable to find user."));
    }
} else {    
    http_response_code(400);    
    echo json_encode(array("message" => "Unable to authenticate user. Data is incomplete."));
}

?>